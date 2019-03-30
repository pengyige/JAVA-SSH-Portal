package top.yigege.dao.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;

import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import top.yigege.dao.UserDao;
import top.yigege.domain.User;
import top.yigege.util.DateUtil;
import top.yigege.vo.UserQueryCondition;

/**
 * 
 * @ClassName:  UserDaoImpl   
 * @Description:用户Dao实现类
 * @author: yigege
 * @date:   2018年12月16日 上午11:15:59
 */
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {

	@Override
	public boolean nameIsExist(String username) {
		Session session = this.getSessionFactory().getCurrentSession();
		String hql = "from User where username = ?";
		List list = session.createQuery(hql)
				.setParameter(0, username)
				.list();
		
		if(list.isEmpty()){
			return false;
		}
			return true;
		
	}

	@Override
	public int findToken(String token) {
		Session session = this.getSessionFactory().getCurrentSession();
		String hql = "from User where token = ?";
		List list = session.createQuery(hql)
				.setParameter(0, token)
				.list();
		if(list.isEmpty()){
			return -1;
		}
		return 1;
	}

	@Override
	public boolean telIsExist(String tel) {
		Session session = this.getSessionFactory().getCurrentSession();
		String hql = "from User where tel = ?";
		List list = session.createQuery(hql)
				.setParameter(0, tel)
				.list();
		
		if(list.isEmpty()){
			return false;
		}
			return true;
	}

	@Override
	public User findUserByPass(User user) {
		User resultUser = null;
		Session session = this.getSessionFactory().getCurrentSession();
		String hql = "from User where password = ? and tel = ?";
		List list = session.createQuery(hql)
				.setParameter(0, user.getPassword())
				.setParameter(1, user.getTel())
				.list();
		if(!list.isEmpty()){
			resultUser = (User) list.get(0);
		}

		return resultUser;
	}

	@Override
	public void updateToken(String userId, String token) {
		Session session = this.getSessionFactory().getCurrentSession();
		String hql = "update User set token = ? where userId = ?";
		session.createQuery(hql)
				.setParameter(0, token)
				.setParameter(1, userId)
				.executeUpdate();
		
	}

	@Override
	public void clearToken(String token) {
		Session session = this.getSessionFactory().getCurrentSession();
		String hql = "update User set token = 'NULL' where token = ?";
		session.createQuery(hql)
				.setParameter(0, token)
				.executeUpdate();
		
	}

	@Override
	public User findUserByTel(String tel) {
		User resultUser = null;
		Session session = this.getSessionFactory().getCurrentSession();
		String hql = "from User where  tel = ?";
		List list = session.createQuery(hql)
				.setParameter(0, tel)
				.list();
		if(!list.isEmpty()){
			resultUser = (User) list.get(0);
		}

		return resultUser;
	}

	@Override
	public List<User> pageListByCondition(int page, int rows, UserQueryCondition userQueryCondition) {
		Criteria criteria = this.getSessionFactory().getCurrentSession().createCriteria(User.class);
		criteria.setFirstResult((page-1)*rows);
		criteria.setMaxResults(rows);


		if (null != userQueryCondition) {
			//编号
			if (StringUtils.isNotBlank(userQueryCondition.getIds())) {
				criteria.add(Restrictions.in("userId", userQueryCondition.getIds().split(",")));
			}

			//类型
			if (0 != userQueryCondition.getType()) {

				criteria.add(Restrictions.eq("type",userQueryCondition.getType()));

			}

			//注册日期
			if (null != userQueryCondition.getDate()) {
				criteria.add(Restrictions.between("createTime",userQueryCondition.getDate(), DateUtil.getNextDay(userQueryCondition.getDate())));
			}
		}

		//排序
		criteria.addOrder(Order.desc("userId"));
		return (List<User>)criteria.list();
	}

	@Override
	public Long getTeleporterAdminCountByCondition(UserQueryCondition userQueryCondition) {
		Criteria criteria = this.getSessionFactory().getCurrentSession().createCriteria(User.class);
		criteria.setProjection(Projections.rowCount());
		if (null != userQueryCondition) {
			//编号
			if (StringUtils.isNotBlank(userQueryCondition.getIds())) {
				criteria.add(Restrictions.in("userId", userQueryCondition.getIds().split(",")));
			}

			//类型
			if (0 != userQueryCondition.getType()) {

				criteria.add(Restrictions.eq("type",userQueryCondition.getType()));

			}

			//注册日期
			if (null != userQueryCondition.getDate()) {
				criteria.add(Restrictions.between("createTime",userQueryCondition.getDate(), DateUtil.getNextDay(userQueryCondition.getDate())));
			}
		}
		//排序
		criteria.addOrder(Order.desc("userId"));
		return (Long) criteria.uniqueResult();
	}


}
