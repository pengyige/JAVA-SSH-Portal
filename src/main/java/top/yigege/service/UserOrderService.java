package top.yigege.service;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import top.yigege.constants.Constants;
import top.yigege.dao.UserOrderDao;
import top.yigege.domain.UserOrder;
import top.yigege.vo.OrderQueryCondition;

/**
 * 
 * @ClassName:  UserOrderService   
 * @Description:用户订单服务类
 * @author: yigege
 * @date:   2018年12月16日 上午11:39:38
 */
public class UserOrderService {
	/**用户订单Dao*/
	private UserOrderDao userOrderDao;
	public void setUserOrderDao(UserOrderDao userOrderDao) {
		this.userOrderDao = userOrderDao;
	}
	
	/**
	 * 保存用户订单
	 * @param userOrder
	 * @return
	 */
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
	
	/**
	 * 通过用户id查询所有订单
	 * @param userId
	 * @param orderState
	 * @return
	 */
	public List<UserOrder> findUserOrderByUserId(String userId,String orderState) {
		List<UserOrder> userOrderLists =  null;
		try {
			userOrderLists = userOrderDao.findUserOrderByUserId(userId,orderState);
		}catch(Exception e) {
			return null;
		}
		
		return userOrderLists;
	}
	
	/**
	 * 更新订单状态
	 * @param userOrderId
	 * @param userOrderState
	 * @return
	 */
	public int updateUserOrderState(String userOrderId,String userOrderState) {
		int resultState = 1;
		try {
			resultState = userOrderDao.updateState(userOrderId,userOrderState);
		}catch(Exception e) {
			resultState = 0;
			return resultState;
		}
		return resultState;
	}
	
	/**
	 * 取消用户订单
	 * @param userOrderId
	 * @return
	 */
	public int cancelUserOrder(String userOrderId) {
		int resultState = 1;
		try {
			UserOrder userOrder = new UserOrder();
			userOrder.setUserOrderId(userOrderId);
			userOrderDao.delete(userOrder);
		}catch(Exception e) {
			resultState = 0;
			return resultState;
		}
		return resultState;
	}

	/**
	 * 查询所有用户订单
	 * @return
	 */
	public List findAll() {
		return userOrderDao.findAll();
	}

	/**
	 * 分页获取所有订单
	 * @param page
	 * @param rows
	 * @param orderQueryCondition
	 * @return
	 */
	public List<UserOrder> pageListByCondition(int page, int rows, OrderQueryCondition orderQueryCondition) {
		return userOrderDao.pageListByCondition(page,rows,orderQueryCondition);
	}

	/**
	 * 分页获取所有订单数量
	 * @param orderQueryCondition
	 * @return
	 */
	public Long getCountByCondition(OrderQueryCondition orderQueryCondition) {
		return userOrderDao.getCountByCondition(orderQueryCondition);
	}

	/**
	 * 查询所有待接待订单
	 * @return
	 */
    public List<UserOrder> queryUnReceiveOrder() {

		return userOrderDao.findUserOrderByStatus(Constants.OrderState.WAIT);
    }

	/**
	 *  派单
	 * @param userOrderId
	 * @param riderId
	 */
	public void doDispacherOrder(String userOrderId, String riderId) throws Exception {
		if (StringUtils.isBlank(userOrderId)) {
			throw  new Exception("用户订单ID不能为空");
		}

		if (StringUtils.isBlank(riderId)) {
			throw new Exception("骑手ID不能为空");
		}

		//通过腾讯信鸽派单

	}
}
