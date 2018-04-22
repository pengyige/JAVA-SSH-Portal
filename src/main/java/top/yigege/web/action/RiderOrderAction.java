package top.yigege.web.action;

import java.util.List;

import com.opensymphony.xwork2.ModelDriven;

import top.yigege.domain.RiderOrder;
import top.yigege.service.RiderOrderService;
import top.yigege.service.RiderService;
import top.yigege.service.UserOrderService;

public class RiderOrderAction extends BaseAction implements ModelDriven<RiderOrder>{
	private RiderOrderService riderOrderService;
	public void setRiderOrderService(RiderOrderService riderOrderService) {
		this.riderOrderService = riderOrderService;
	}
	
	private RiderService riderService;
	public void setRiderService(RiderService riderService) {
		this.riderService = riderService;
	}

	private UserOrderService userOrderService;
	public void setUserOrderService(UserOrderService userOrderService) {
		this.userOrderService = userOrderService;
	}

	//属性封装用户订单ID,骑手ID
	private String userOrderId;
	private String token;
	private String riderId;
	public String getUserOrderId() {
		return userOrderId;
	}
	public void setUserOrderId(String userOrderId) {
		this.userOrderId = userOrderId;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getRiderId() {
		return riderId;
	}

	public void setRiderId(String riderId) {
		this.riderId = riderId;
	}

	//模型驱动封装骑手订单信息
	private RiderOrder riderOrder = new RiderOrder();
	public RiderOrder getRiderOrder() {
		return riderOrder;
	}

	public void setRiderOrder(RiderOrder riderOrder) {
		this.riderOrder = riderOrder;
	}

	@Override
	public RiderOrder getModel() {
	
		return null;
	}
	
	
	
	/**
	 * 骑手接受订单
	 */
	public String receive() {
		//1.验证token是否有效
		if(riderService.validateToken(token) == -1) {
			this.getJsonData().put("state", -1);
			return "jsonData";
		}
		
		//2.接单业务逻辑处理
		int state = riderOrderService.receiveOrder(riderId,userOrderId);
		
		if(state == 1) {
			//2.1更新订单状态为待取货
			userOrderService.updateUserOrderState(userOrderId, "3");
			
		}
		this.getJsonData().put("state",state);
	
		
		return "jsonData";
	}
	
	/**
	 * 查询骑手订单所有信息
	 */
	public String findAll() {
		//1.验证token是否有效
		if(riderService.validateToken(token) == -1) {
			this.getJsonData().put("state", -1);
			return "jsonData";
		}
		
		//2.查询业务逻辑处理
		int state;
		try {
		List<RiderOrder> riderOrderLists = riderOrderService.findAll(riderId);
		if(riderOrderLists != null) {
			this.getJsonData().put("state", 1);
			this.getJsonData().put("result", riderOrderLists);
		}
		}catch(Exception e) {
			state = 0;
			this.getJsonData().put("state", state);
			return "jsonData";
		}
		
		return "jsonData";
	}

}
