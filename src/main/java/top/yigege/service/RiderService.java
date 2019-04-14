package top.yigege.service;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import top.yigege.dao.RiderDao;
import top.yigege.domain.Rider;
import top.yigege.domain.Teleporter;
import top.yigege.util.ValidatorUtil;
import top.yigege.util.VerifyIdCardHelper;
import top.yigege.vo.RiderQueryCondition;
import top.yigege.vo.TypeVO;
import top.yigege.web.socket.LocationWebSocket;

/**
 * 
 * @ClassName:  RiderService   
 * @Description:骑手服务类
 * @author: yigege
 * @date:   2018年12月16日 上午11:30:06
 */
public class RiderService extends BaseService{


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
	public Rider findRiderByTel(String tel) throws Exception {
		//校验手机号
		if (!ValidatorUtil.isMobile(tel)) {
			throw  new Exception("手机号非法");
		}

		//手机号是否已注册
		if (!telIsRegister(tel)) {
			throw  new Exception(tel+"手机号未注册");
		}

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
	 * @param rider
	 * @param teleporter
	 */
	public void doRiderCheckin(Rider rider,Teleporter teleporter) throws Exception {
		/*int state = 1;
		try {
			riderDao.checkIn(teleporterId,riderId);
		}catch(Exception e){
			state = 0;
		}
		return state;*/
		//验证实名认证
		if (VerifyIdCardHelper.sendVerfidyIdCardRequest(rider.getIDNumber(),rider.getRealName())){
			logger.info("认证成功");
			Rider updateRider = findRiderByTel(rider.getTel());
			//绑定传送点
			updateRider.setTeleporter(teleporter);

			//更新骑手信息
			updateRider.setRealName(rider.getRealName());
			updateRider.setIDNumber(rider.getIDNumber());

			updateRiderService(updateRider);
		}else {
			logger.info("认证失败");
			throw new Exception("姓名【"+rider.getRealName()+"】与身份证号码【"+rider.getIDNumber()+"】不匹配，请重试");
		}
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
	public List<Rider> findRidersByTeleproter(Integer teleporterId) {
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

	/**
	 * 骑手位置改变
	 * @param longitudeStr
	 * @param latitudeStr
	 * @param riderIdStr
	 */
	public void changeLocation(String longitudeStr, String latitudeStr, String riderIdStr) {
		double logitude = Double.valueOf(longitudeStr);
		double latitude = Double.valueOf(latitudeStr);

		LocationWebSocket.changeRiderLocation(logitude,latitude,riderIdStr);
	}

	/**
	 * 根据穿点查询骑手
	 * @param teleporter
	 * @return
	 */
    public List<Rider> queryRiderByTeleporter(Teleporter teleporter) {

    	return riderDao.findRidersByTeleproter(teleporter.getTeleporterId());
    }

	/**
	 * 校验登记信息
	 * @param rider
	 */
	public void validateCheckInData(Rider rider,Teleporter teleporter) throws Exception {
		if (!(null != teleporter && teleporter.getTeleporterId() != null)) {
			throw new Exception("登记的传送点不能为空");
		}

		//手机号
		if (StringUtils.isBlank(rider.getTel())) {
			throw new Exception("手机号不能为空");
		}else {
			if (!telIsRegister(rider.getTel())) {
				throw new Exception(rider.getTel()+"还未注册，请先注册");
			}
		}

		//判断是否在其他传送点登记
		Rider returnRider = findRiderByTel(rider.getTel());
		if (null != returnRider.getTeleporter()) {
			throw  new Exception(rider.getTel()+"已在传送点【"+returnRider.getTeleporter().getAddress()+"】登记，请先到该传送点进行注销");
		}


	}
}
