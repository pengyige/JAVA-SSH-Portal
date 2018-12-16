package top.yigege.service;

import java.util.List;

import top.yigege.dao.UserOrderDao;
import top.yigege.domain.UserOrder;

/**
 * 
 * @ClassName:  UserOrderService   
 * @Description:用户订单服务类
 * @author: yigege
 * @date:   2018年12月16日 上午11:39:38
 */
public class UserOrderService {
	/**用户订单Dao*/
	private UserOrderDao userOrderDao;
	public void setUserOrderDao(UserOrderDao userOrderDao) {
		this.userOrderDao = userOrderDao;
	}
	
	/**
	 * 保存用户订单
	 * @param userOrder
	 * @return
	 */
	public int saveUserOrder(UserOrder userOrder) {
		int resultState = 1;
		try {
			userOrderDao.save(userOrder);
		}catch(Exception e) {
			resultState = 0;
			return resultState;
		}
		return resultState;
	}
	
	/**
	 * 通过用户id查询所有订单
	 * @param userId
	 * @param orderState
	 * @return
	 */
	public List<UserOrder> findUserOrderByUserId(String userId,String orderState) {
		List<UserOrder> userOrderLists =  null;
		try {
			userOrderLists = userOrderDao.findUserOrderByUserId(userId,orderState);
		}catch(Exception e) {
			return null;
		}
		
		return userOrderLists;
	}
	
	/**
	 * 更新订单状态
	 * @param userOrderId
	 * @param userOrderState
	 * @return
	 */
	public int updateUserOrderState(String userOrderId,String userOrderState) {
		int resultState = 1;
		try {
			resultState = userOrderDao.updateState(userOrderId,userOrderState);
		}catch(Exception e) {
			resultState = 0;
			return resultState;
		}
		return resultState;
	}
	
	/**
	 * 取消用户订单
	 * @param userOrderId
	 * @return
	 */
	public int cancelUserOrder(String userOrderId) {
		int resultState = 1;
		try {
			UserOrder userOrder = new UserOrder();
			userOrder.setUserOrderId(userOrderId);
			userOrderDao.delete(userOrder);
		}catch(Exception e) {
			resultState = 0;
			return resultState;
		}
		return resultState;
	}

	/**
	 * 查询所有用户订单
	 * @return
	 */
	public List findAll() {
		return userOrderDao.findAll();
	}
}
