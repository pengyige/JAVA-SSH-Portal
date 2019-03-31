package top.yigege.dao.impl;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;

import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import top.yigege.dao.UserDao;
import top.yigege.domain.User;
import top.yigege.util.DateUtil;
import top.yigege.util.TypeConvertUtil;
import top.yigege.vo.TypeVO;
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


	public Long[] getPortalCount() {
		Session session = this.getSessionFactory().getCurrentSession();
		String querySql = "select count(*)  from t_user\n" +
				"union ALL\n" +
				"select count(*)  FROM t_rider\n" +
				"union ALL\n" +
				"select count(*)  from t_teleporter\n" +
				"union ALL\n" +
				"select count(*)  FROM t_teleporter_admin\n" +
				"union ALL\n" +
				"select count(*)  FROM t_superadmin\n" +
				"union ALL\n" +
				"select count(*)  FROM t_user_order\n" +
				"union ALL\n" +
				"select count(*)  FROM t_rider_order\n" +
				"union ALL\n" +
				"select ifnull(sum(userOrder.payment),0)  FROM t_user_order userOrder where userOrder.state = 4\n" +
				"union ALL\n" +
				"select count(*)  FROM t_system_message m where m.type = 2\n" +
				"union ALL\n" +
				"select count(*)  FROM t_system_message ";

		List<Double> counts = session.createSQLQuery(querySql).list();
		Double[] countDouble = counts.toArray(new Double[counts.size()]);

	    return TypeConvertUtil.DoubleToLong(countDouble);
	}


	@Override
	public TypeVO[] getUserRegisterCountByTime() {
		Session session = this.getSessionFactory().getCurrentSession();
		String querySql = "select  date_format(u.createTime,'%Y-%m-%d') ,count(*) count  from t_user u where u.createTime BETWEEN  CURDATE() -7  and NOW() GROUP BY u.createTime\n";
		List result = session.createSQLQuery(querySql).list();
		if (null != result && result.size() > 0 ) {
			TypeVO[] typeVOS = new TypeVO[result.size()];
			for (int i = 0 ; i < result.size(); i++) {
				Object[] object = (Object[])((Object[])result.get(i));
				typeVOS[i] = new TypeVO(Long.parseLong(object[1].toString()),object[0].toString());
			}
			return typeVOS;
		}else {
			return null;
		}
	}

}
