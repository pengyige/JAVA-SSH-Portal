package top.yigege.dao.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;

import top.yigege.dao.RiderDao;
import top.yigege.domain.Rider;

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

}
