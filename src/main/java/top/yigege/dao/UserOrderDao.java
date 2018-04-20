package top.yigege.dao;

import java.util.List;

import top.yigege.domain.UserOrder;

public interface UserOrderDao extends BaseDao<UserOrder>{

	List<UserOrder> findUserOrderByUserId(String userId,String orderState);

}
