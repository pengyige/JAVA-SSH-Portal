package top.yigege.service;

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

	
}
