package top.yigege.service;

import java.util.List;

import top.yigege.dao.RiderDao;
import top.yigege.domain.Rider;

public class RiderService {
	private RiderDao riderDao;
	public void setRiderDao(RiderDao riderDao) {
		this.riderDao = riderDao;
	}
	public boolean telIsRegister(String tel) {
		return riderDao.telIsExist(tel);
	}
	public int registerRider(Rider rider) {
		int state = 1;
		try {
			riderDao.save(rider);
		}catch(Exception e) {
			state = 0;
		}
		return state;
		
	}
	public Rider findRiderByTel(String tel) {
		
		return riderDao.findRiderByTel(tel);
	}
	public int updateRiderToken(String riderId, String token) {
		int state = 1;
		try {
			riderDao.updateToken(riderId,token);
		}catch(Exception e){
			state = 0;
		}
		return state;
		
	}
	public int riderCheckin(String teleporterId, String riderId) {
		int state = 1;
		try {
			riderDao.checkIn(teleporterId,riderId);
		}catch(Exception e){
			state = 0;
		}
		return state;
	}
	public int validateToken(String token) {
		
		return riderDao.findToken(token);
	}
	public Rider findRiderById(String riderId) {
		
		return riderDao.find(riderId);
	}
	public int updateUserService(Rider tempRider) {
		int state = 1;
		try {
			riderDao.update(tempRider);
		}catch(Exception e) {
			state = 0;
			return state;
		}
		return state;
	}
	public List<Rider> findAll() {
		// TODO Auto-generated method stub
		return riderDao.findAll();
	}
	
	
	public int logoutCheckin(String riderId) {
		int state = 1;
		try {
			riderDao.logoutChecin(riderId);
		}catch(Exception e) {
			state = 0;
			return state;
		}
		return state;
	}
	public List<Rider> findRidersByTeleproter(String teleporterId) {
		// TODO Auto-generated method stub
		return riderDao.findRidersByTeleproter(teleporterId);
	}
	
}
