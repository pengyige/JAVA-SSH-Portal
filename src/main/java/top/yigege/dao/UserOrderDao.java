package top.yigege.dao;

import java.util.List;

import top.yigege.domain.UserOrder;

/**
 * 
 * @ClassName:  UserOrderDao   
 * @Description:用户订单
 * @author: yigege
 * @date:   2018年12月16日 上午11:09:42
 */
public interface UserOrderDao extends BaseDao<UserOrder>{

	/**
	 * 通过用户id查询所有用户订单
	 * @param userId
	 * @param orderState
	 * @return
	 */
	List<UserOrder> findUserOrderByUserId(String userId,String orderState);

	/**
	 * 更新订单状态
	 * @param userOrderId
	 * @param userOrderState
	 * @return
	 */
	int updateState(String userOrderId, String userOrderState);

}
