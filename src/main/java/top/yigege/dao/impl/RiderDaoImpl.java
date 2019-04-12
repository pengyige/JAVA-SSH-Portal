package top.yigege.dao.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;

import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import top.yigege.dao.RiderDao;
import top.yigege.domain.Rider;
import top.yigege.util.DateUtil;
import top.yigege.vo.RiderQueryCondition;
import top.yigege.vo.TypeVO;

/**
 * @ClassName:  RiderDaoImpl   
 * @Description:骑手Dao实现类
 * @author: yigege
 * @date:   2018年12月16日 上午11:12:06
 */
public class RiderDaoImpl extends BaseDaoImpl<Rider> implements RiderDao{

	@Override
	public boolean telIsExist(String tel) {
		Session session = this.getSessionFactory().getCurrentSession();
		String hql = "from Rider where tel = ?";
		List list = session.createQuery(hql)
				.setParameter(0, tel)
				.list();
		
		if(list.isEmpty()){
			return false;
		}
			return true;
	}

	
	@Override
	public Rider findRiderByTel(String tel) {
		Rider resultRider = null;
		Session session = this.getSessionFactory().getCurrentSession();
		String hql = "from Rider where  tel = ?";
		List list = session.createQuery(hql)
				.setParameter(0, tel)
				.list();
		if(!list.isEmpty()){
			resultRider = (Rider) list.get(0);
		}

		return resultRider;
	
	}


	@Override
	public void updateToken(String riderId, String token) {
		Session session = this.getSessionFactory().getCurrentSession();
		String hql = "update Rider set token = ? where riderId = ?";
		session.createQuery(hql)
				.setParameter(0, token)
				.setParameter(1, riderId)
				.executeUpdate();
		
	}


	@Override
	public void checkIn(String teleporterId, String riderId) {
		Date checkinDate = new Date();
		Session session = this.getSessionFactory().getCurrentSession();
		String hql = "update Rider set teleporter_rider_id = ?, checkinDate = ? where riderId = ?";
		session.createQuery(hql)
				.setParameter(0, teleporterId)
				.setParameter(1, checkinDate)
				.setParameter(2, riderId)
				.executeUpdate();
		
	}


	@Override
	public int findToken(String token) {
		Session session = this.getSessionFactory().getCurrentSession();
		String hql = "from Rider where token = ?";
		List list = session.createQuery(hql)
				.setParameter(0, token)
				.list();
		if(list.isEmpty()){
			return -1;
		}
		return 1;
	}


	@Override
	public void logoutChecin(String riderId) {
		Session session = this.getSessionFactory().getCurrentSession();
		String hql = "update Rider set teleporter_rider_id = ?, checkinDate = ? where riderId = ?";
		session.createQuery(hql)
				.setParameter(0, null)
				.setParameter(1, null)
				.setParameter(2, riderId)
				.executeUpdate();
		
	}


	@Override
	public List<Rider> findRidersByTeleproter(Integer teleporterId) {
		Session session = this.getSessionFactory().getCurrentSession();
		String hql = "from Rider where teleporter_rider_id = ?";
		List list = session.createQuery(hql)
				.setParameter(0, teleporterId)
				.list();
		return list;
	}

	@Override
	public List<Rider> pageLicstByCondition(int page, int rows, RiderQueryCondition riderQueryCondition) {
		Criteria criteria = this.getSessionFactory().getCurrentSession().createCriteria(Rider.class);
		criteria.setFirstResult((page-1)*rows);
		criteria.setMaxResults(rows);


		if (null != riderQueryCondition) {
			//编号
			if (StringUtils.isNotBlank(riderQueryCondition.getIds())) {
				criteria.add(Restrictions.in("riderId", riderQueryCondition.getIds().split(",")));
			}

			//注册日期
			if (null != riderQueryCondition.getDate()) {
				criteria.add(Restrictions.between("registerDate",riderQueryCondition.getDate(), DateUtil.getNextDay(riderQueryCondition.getDate())));
			}
		}

		//排序
		criteria.addOrder(Order.desc("riderId"));
		return (List<Rider>)criteria.list();
	}

	@Override
	public Long getCountByCondition(RiderQueryCondition riderQueryCondition) {
		Criteria criteria = this.getSessionFactory().getCurrentSession().createCriteria(Rider.class);
		criteria.setProjection(Projections.rowCount());
		if (null != riderQueryCondition) {
			//编号
			if (StringUtils.isNotBlank(riderQueryCondition.getIds())) {
				criteria.add(Restrictions.in("riderId", riderQueryCondition.getIds().split(",")));
			}

			//注册日期
			if (null != riderQueryCondition.getDate()) {
				criteria.add(Restrictions.between("registerDate",riderQueryCondition.getDate(), DateUtil.getNextDay(riderQueryCondition.getDate())));
			}
		}
		//排序
		criteria.addOrder(Order.desc("riderId"));
		return (Long) criteria.uniqueResult();
	}

	@Override
	public TypeVO[] getRiderRegisterCountByTime() {
		Session session = this.getSessionFactory().getCurrentSession();
		String querySql = "select  date_format(u.registerDate,'%Y-%m-%d') ,count(*) count  from t_rider u where u.registerDate BETWEEN  CURDATE() -7  and NOW() GROUP BY u.registerDate\n";
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
