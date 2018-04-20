package top.yigege.dao.impl;

import java.util.List;

import top.yigege.dao.UserOrderDao;
import top.yigege.domain.User;
import top.yigege.domain.UserOrder;

public class UserOrderDaoImpl extends BaseDaoImpl<UserOrder> implements UserOrderDao {

	@Override
	public List<UserOrder> findUserOrderByUserId(String userId,String orderState) {
		String hql = null;
		if(orderState == null || orderState.trim().equals(""))
			hql	= "from UserOrder where user_order_id = ?";
			
		else
			hql = "from UserOrder where user_order_id = ? and state = "+orderState;
		return (List<UserOrder>)(this.getSessionFactory().
				getCurrentSession()
				.createQuery(hql)
				.setParameter(0, userId)
				.list());
		
	}



}
