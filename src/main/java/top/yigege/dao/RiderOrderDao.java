package top.yigege.dao;

import java.util.List;

import top.yigege.domain.RiderOrder;

/**
 * 
 * @ClassName:  RiderOrderDao   
 * @Description:骑手订单dao
 * @author: yigege
 * @date:   2018年12月16日 上午11:04:06
 */
public interface RiderOrderDao extends BaseDao<RiderOrder>{

	/**
	 * 通过骑手id查询所有订单
	 * @param riderId
	 * @return
	 */
	List<RiderOrder> findRiderOrderByUserId(String riderId);

	
	
	
}
