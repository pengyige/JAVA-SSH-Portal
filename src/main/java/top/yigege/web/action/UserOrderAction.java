package top.yigege.web.action;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import com.opensymphony.xwork2.ModelDriven;
import com.tencent.xinge.XingeApp;

import top.yigege.constants.Constants;
import top.yigege.domain.Rider;
import top.yigege.domain.User;
import top.yigege.domain.UserOrder;
import top.yigege.enums.HttpCodeEnum;
import top.yigege.service.RiderService;
import top.yigege.service.UserOrderService;
import top.yigege.service.UserService;
import top.yigege.util.ReturnDTOUtil;
import top.yigege.util.XingeUtil;
import top.yigege.vo.OrderQueryCondition;
import top.yigege.vo.TypeVO;

/**
 * 
 * @ClassName:  UserOrderAction   
 * @Description:用户订单action
 * @author: yigege
 * @date:   2018年12月16日 下午12:39:04
 */
public class UserOrderAction extends BaseAction implements ModelDriven<UserOrder>{
	private UserOrderService userOrderService;
	public void setUserOrderService(UserOrderService userOrderService) {
		this.userOrderService = userOrderService;
	}
	
	private UserService userService;
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	
	private RiderService riderService;
	public void setRiderService(RiderService riderService) {
		this.riderService = riderService;
	}

	/**订单查询条件*/
	private OrderQueryCondition orderQueryCondition = new OrderQueryCondition();

	public OrderQueryCondition getOrderQueryCondition() {
		return orderQueryCondition;
	}

	public void setOrderQueryCondition(OrderQueryCondition orderQueryCondition) {
		this.orderQueryCondition = orderQueryCondition;
	}

	//通过属性封装获取参数
	private String userId;
	private String token;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	//通过模型驱动获取参数
	private UserOrder userOrder = new UserOrder();
	@Override
	public UserOrder getModel() {
		return userOrder;
	}
	
	public void setUserOrder(UserOrder userOrder) {
		this.userOrder = userOrder;
	}
	
	
	/**
	 *添加用户订单
	 */
	public String add() {
		//1.校验token
		int state;
		if(userService.validateToken(token) == -1) {
			this.getJsonData().put("state", -1);
			return "jsonData";
		}
		
		//2.封装数据
		User user = new User();
		user.setUserId(userId);
		
		SimpleDateFormat bartDateFormat = new SimpleDateFormat("yyyyddmm");
		Date date = new Date();
		String userOrderId = bartDateFormat.format(date)+date.getTime();
		this.userOrder.setOrderTime(date);
		this.userOrder.setUserOrderId(userOrderId);
		this.userOrder.setUser(user);
		
		//3.保存订单
		state = userOrderService.saveUserOrder(this.userOrder);
		this.getJsonData().put("state", state);
		
		return "jsonData";
	}
	

	
	/**
	 * 修改用户订单状态
	 */
	public String updateState() {
	/*	//1.校验token
		int state;
		if(userService.validateToken(token) == -1) {
			this.getJsonData().put("state", -1);
			return "jsonData";
		}
				
		//2.更新订单状态
	    state = userOrderService.updateUserOrderState(this.userOrder.getUserOrderId(),userOrder.getState());
	    this.getJsonData().put("state", state);
	    return "jsonData";*/
	return  JSON_DATA;
	}
	
	
	/**
	 * 取消用户订单
	 */
	public String cancelOrder() {
		//1.校验token
		int state;
		if(userService.validateToken(token) == -1) {
			this.getJsonData().put("state", -1);
			return "jsonData";
		}
		
		//2.取消订单业务处理
		state = userOrderService.cancelUserOrder(this.userOrder.getUserOrderId());
		this.getJsonData().put("state", state);
		return "jsonData";
	}
	
	/**
	 * 跳转到用户订单管理
	 * @return
	 */
	public String intoOrderManagerPage() {
		return "intoOrderManagerPage";
	}

	/**
	 * 分页查询所有订单
	 * @return
	 */
	public String queryAllByPage() {
		logger.info("分页查询所有订单");

		try {
			List<UserOrder> orders = userOrderService.pageListByCondition(page,rows,orderQueryCondition);

			Long count = userOrderService.getCountByCondition(orderQueryCondition);
			if(orders != null) {
				bootstrapTableDTO.setCode(HttpCodeEnum.OK.getCode());
				bootstrapTableDTO.setTotal(count.intValue());
				bootstrapTableDTO.setRows(orders);
			}else {
				bootstrapTableDTO.setCode(HttpCodeEnum.FAIL.getCode());
				bootstrapTableDTO.setMessage(HttpCodeEnum.INVALID_REQUEST.getMessage());
			}
		}catch (Exception e) {
			e.printStackTrace();
			bootstrapTableDTO.setCode(HttpCodeEnum.FAIL.getCode());
			bootstrapTableDTO.setMessage(e.getMessage());
		}


		return BOOTSTRAP_TABLE_JSON_DATA;
	}

	/**
	 * 返回所有订单状态
	 * @return
	 */
	public String getAllOrderType() {
		logger.info("查询所有订单状态");
		TypeVO[] typeVO =  new TypeVO[5];

		typeVO[0] = new TypeVO(Constants.OrderState.WAIT, Constants.OrderState.getName((Constants.OrderState.WAIT)));
		typeVO[1] = new TypeVO(Constants.OrderState.ALREADY_RECEIVER, Constants.OrderState.getName((Constants.OrderState.ALREADY_RECEIVER)));
		typeVO[2] = new TypeVO(Constants.OrderState.ALREADY_PICK, Constants.OrderState.getName((Constants.OrderState.ALREADY_PICK)));
		typeVO[3] = new TypeVO(Constants.OrderState.ALREADY_ARRIVER, Constants.OrderState.getName((Constants.OrderState.ALREADY_ARRIVER)));
		typeVO[4] = new TypeVO(Constants.OrderState.CANCEL, Constants.OrderState.getName((Constants.OrderState.CANCEL)));

		returnDTO = ReturnDTOUtil.success(typeVO);
		return JSON_DATA;
	}
}
