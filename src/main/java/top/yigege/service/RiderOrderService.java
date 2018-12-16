package top.yigege.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import top.yigege.dao.RiderOrderDao;
import top.yigege.domain.Rider;
import top.yigege.domain.RiderOrder;
import top.yigege.domain.UserOrder;

/**
 * 
 * @ClassName:  RiderOrderService   
 * @Description:骑手订单服务类
 * @author: yigege
 * @date:   2018年12月16日 上午10:49:28
 */
public class RiderOrderService {
	
	/**骑手订单dao*/
	private RiderOrderDao riderOrderDao;
	/**
	 * 注入骑手订单dao
	 * @param riderOrderDao
	 */
	public void setRiderOrderDao(RiderOrderDao riderOrderDao) {
		this.riderOrderDao = riderOrderDao;
	}
	
	/**
	 * 骑手接单
	 * @param riderId
	 * @param userOrderId
	 * @return
	 */
	public int receiveOrder(String riderId, String userOrderId) {
		int resultState = 1;
		try {
			Date createDate = new Date();
			SimpleDateFormat format = new SimpleDateFormat("yyyymmdd");
			String riderOrderId = format.format(createDate)+createDate.getTime();
			
			RiderOrder riderOrder = new RiderOrder();
			riderOrder.setRiderOrderId(riderOrderId);
			riderOrder.setCreateDate(createDate);
			
			UserOrder userOrder = new UserOrder();
			userOrder.setUserOrderId(userOrderId);
			riderOrder.setUserOrder(userOrder);
			
			Rider rider = new Rider();
			rider.setRiderId(riderId);
			riderOrder.setRider(rider);
			
			
			riderOrderDao.save(riderOrder);
		}catch(Exception e){
			resultState = 0;
			return resultState;
		}
		return resultState;
	}

	
	/**
	 * 查询所有骑手订单
	 * @param riderId
	 * @return
	 */
	public List<RiderOrder> findAll(String riderId) {
		
		return riderOrderDao.findRiderOrderByUserId(riderId);
	}
	
}
