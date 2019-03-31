package top.yigege.service;

import java.util.List;

import top.yigege.dao.RiderDao;
import top.yigege.domain.Rider;
import top.yigege.vo.RiderQueryCondition;
import top.yigege.vo.TypeVO;

/**
 * 
 * @ClassName:  RiderService   
 * @Description:骑手服务类
 * @author: yigege
 * @date:   2018年12月16日 上午11:30:06
 */
public class RiderService {
	
	/**骑手Dao*/
	private RiderDao riderDao;
	public void setRiderDao(RiderDao riderDao) {
		this.riderDao = riderDao;
	}
	
	/**
	 * 查询骑手电话是否存在
	 * @param tel
	 * @return
	 */
	public boolean telIsRegister(String tel) {
		return riderDao.telIsExist(tel);
	}
	
	/**
	 * 注册骑手
	 * @param rider
	 * @return 成功:1;失败:0
	 */
	public int registerRider(Rider rider) {
		int state = 1;
		try {
			riderDao.save(rider);
		}catch(Exception e) {
			state = 0;
			return state;
		}
		return state;
		
	}
	
	/**
	 * 通过骑手手机号查询骑手
	 * @param tel
	 * @return
	 */
	public Rider findRiderByTel(String tel) {
		
		return riderDao.findRiderByTel(tel);
	}
	
	/**
	 * 更新骑手token
	 * @param riderId
	 * @param token
	 * @return
	 */
	public int updateRiderToken(String riderId, String token) {
		int state = 1;
		try {
			riderDao.updateToken(riderId,token);
		}catch(Exception e){
			state = 0;
		}
		return state;
		
	}
	
	/**
	 * 骑手登记
	 * @param teleporterId
	 * @param riderId
	 * @return
	 */
	public int riderCheckin(String teleporterId, String riderId) {
		int state = 1;
		try {
			riderDao.checkIn(teleporterId,riderId);
		}catch(Exception e){
			state = 0;
		}
		return state;
	}
	
	/**
	 * 校验token
	 * @param token
	 * @return
	 */
	public int validateToken(String token) {
		
		return riderDao.findToken(token);
	}
	
	/**
	 * 通过id查询骑手
	 * @param riderId
	 * @return
	 */
	public Rider findRiderById(String riderId) {
		
		return riderDao.find(riderId);
	}
	
	/**
	 * 更新骑手信息
	 * @param tempRider
	 * @return
	 */
	public int updateRiderService(Rider tempRider) {
		int state = 1;
		try {
			riderDao.update(tempRider);
		}catch(Exception e) {
			state = 0;
			return state;
		}
		return state;
	}
	
	/**
	 * 查询所有骑手
	 * @return
	 */
	public List<Rider> findAll() {
		// TODO Auto-generated method stub
		return riderDao.findAll();
	}
	
	
	/**
	 * 注销骑手
	 * @param riderId
	 * @return
	 */
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
	
	/**
	 * 通过传送点查询所有骑手
	 * @param teleporterId
	 * @return
	 */
	public List<Rider> findRidersByTeleproter(String teleporterId) {
		// TODO Auto-generated method stub
		return riderDao.findRidersByTeleproter(teleporterId);
	}

    public List<Rider> pageListByCondition(int page, int rows, RiderQueryCondition riderQueryCondition) {
		return riderDao.pageLicstByCondition(page,rows,riderQueryCondition);
    }

	public Long getCountByCondition(RiderQueryCondition riderQueryCondition) {
		return riderDao.getCountByCondition(riderQueryCondition);
	}

	/**
	 * 查询骑手注册数量
	 * @return
	 */
    public TypeVO[] queryRiderRegisterCountByTime() {
		return riderDao.getRiderRegisterCountByTime();
    }
}
