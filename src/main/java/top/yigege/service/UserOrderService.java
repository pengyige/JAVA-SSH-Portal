package top.yigege.service;

import java.util.List;

import top.yigege.dao.UserOrderDao;
import top.yigege.domain.UserOrder;

public class UserOrderService {
	private UserOrderDao userOrderDao;
	public void setUserOrderDao(UserOrderDao userOrderDao) {
		this.userOrderDao = userOrderDao;
	}
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
	public List<UserOrder> findUserOrderByUserId(String userId,String orderState) {
		List<UserOrder> userOrderLists =  null;
		try {
			userOrderLists = userOrderDao.findUserOrderByUserId(userId,orderState);
		}catch(Exception e) {
			return null;
		}
		
		return userOrderLists;
	}

	
}
