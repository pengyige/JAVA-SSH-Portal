package top.yigege.dao.impl;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import top.yigege.dao.RiderOrderDao;
import top.yigege.domain.RiderOrder;
import top.yigege.domain.UserOrder;

/**
 * 
 * @ClassName:  RiderOrderImpl   
 * @Description:骑手订单DAO实现类
 * @author: yigege
 * @date:   2018年12月16日 上午11:12:48
 */
public class RiderOrderDaoImpl extends BaseDaoImpl<RiderOrder> implements RiderOrderDao{

	@SuppressWarnings("unchecked")
	@Override
	public List<RiderOrder> findRiderOrderByUserId(String riderId) {
		String hql= "from RiderOrder where rider_order_id = ?";
		return (List<RiderOrder>)(this.getSessionFactory().
				getCurrentSession()
				.createQuery(hql)
				.setParameter(0, riderId)
				.list());
	}



	

}
