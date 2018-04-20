package top.yigege.web.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.opensymphony.xwork2.ModelDriven;

import top.yigege.domain.User;
import top.yigege.domain.UserOrder;
import top.yigege.service.UserOrderService;
import top.yigege.service.UserService;

public class UserOrderAction extends BaseAction implements ModelDriven<UserOrder>{
	private UserOrderService userOrderService;
	public void setUserOrderService(UserOrderService userOrderService) {
		this.userOrderService = userOrderService;
	}
	
	private UserService userService;
	public void setUserService(UserService userService) {
		this.userService = userService;
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
	 *用户订单查询 
	 */
	public String query() {
		//1.校验token
		int state;
		if(userService.validateToken(token) == -1) {
			this.getJsonData().put("state", -1);
			return "jsonData";
		}
		//2.获取用户订单业务逻辑处理
		try {
			List<UserOrder> userOrderLists = userOrderService.findUserOrderByUserId(userId,this.userOrder.getState());
			this.getJsonData().put("state", 1);
			this.getJsonData().put("userOrders", userOrderLists);
		}catch(Exception e) {
			this.getJsonData().put("state", 0);
			return "jsonData";
		}
		
		return "jsonData";
	}
}
