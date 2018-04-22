package top.yigege.dao;

import java.util.List;

import top.yigege.domain.RiderOrder;

public interface RiderOrderDao extends BaseDao<RiderOrder>{

	List<RiderOrder> findRiderOrderByUserId(String riderId);

	
	
	
}
