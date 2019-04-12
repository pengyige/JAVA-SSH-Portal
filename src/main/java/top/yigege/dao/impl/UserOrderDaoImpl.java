package top.yigege.dao.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import top.yigege.dao.UserOrderDao;
import top.yigege.domain.User;
import top.yigege.domain.UserOrder;
import top.yigege.vo.OrderQueryCondition;

/**
 * 
 * @ClassName:  UserOrderDaoImpl   
 * @Description:用户订单Dao实现类
 * @author: yigege
 * @date:   2018年12月16日 上午11:16:19
 */
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

	@Override
	public int updateState(String userOrderId, String userOrderState) {
		String hql = "update UserOrder set state = ? where userOrderId = ?";
		int count = this.getSessionFactory().getCurrentSession()
											.createQuery(hql)
											.setParameter(0, userOrderState)
											.setParameter(1, userOrderId)
											.executeUpdate();
		return count;
	
	}

	@Override
	public List<UserOrder> pageListByCondition(int page, int rows, OrderQueryCondition orderQueryCondition) {
		Criteria criteria = this.getSessionFactory().getCurrentSession().createCriteria(UserOrder.class);
		criteria.setFirstResult((page - 1) * rows);
		criteria.setMaxResults(rows);


		if (null != orderQueryCondition) {
			//编号
			if (StringUtils.isNotBlank(orderQueryCondition.getIds())) {
				criteria.add(Restrictions.in("userOrderId", orderQueryCondition.getIds().split(",")));
			}

			//状态
			if (0 != orderQueryCondition.getState()) {
				criteria.add(Restrictions.eq("state", orderQueryCondition.getState()));
			}
		}

		//排序
		criteria.addOrder(Order.desc("userOrderId"));
		return (List<UserOrder>) criteria.list();

	}

	@Override
	public Long getCountByCondition(OrderQueryCondition orderQueryCondition) {
		Criteria criteria = this.getSessionFactory().getCurrentSession().createCriteria(UserOrder.class);
		criteria.setProjection(Projections.rowCount());


		if (null != orderQueryCondition) {
			//编号
			if (StringUtils.isNotBlank(orderQueryCondition.getIds())) {
				criteria.add(Restrictions.in("userOrderId", orderQueryCondition.getIds().split(",")));
			}

			//状态
			if (0 != orderQueryCondition.getState()) {
				criteria.add(Restrictions.eq("state", orderQueryCondition.getState()));
			}


		}
		//排序
		criteria.addOrder(Order.desc("userOrderId"));
		return (Long) criteria.uniqueResult();
	}

	@Override
	public List<UserOrder> findUserOrderByStatus(Long wait) {
		Criteria criteria = this.getSessionFactory().getCurrentSession().createCriteria(UserOrder.class);
		criteria.add(Restrictions.eq("state",wait.intValue()));
		return (List<UserOrder>) criteria.list();
	}


}
