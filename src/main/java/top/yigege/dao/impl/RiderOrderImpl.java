package top.yigege.dao.impl;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import top.yigege.dao.RiderOrderDao;
import top.yigege.domain.RiderOrder;
import top.yigege.domain.UserOrder;

public class RiderOrderImpl extends BaseDaoImpl<RiderOrder> implements RiderOrderDao{

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
