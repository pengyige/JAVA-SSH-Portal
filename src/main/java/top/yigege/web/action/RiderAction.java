package top.yigege.web.action;

import com.opensymphony.xwork2.ModelDriven;

import top.yigege.domain.Rider;
import top.yigege.domain.User;
import top.yigege.service.RiderService;
import top.yigege.util.MD5Util;

public class RiderAction extends BaseAction implements ModelDriven<Rider>{
	private RiderService riderService;
	public RiderService getRiderService() {
		return riderService;
	}
	public void setRiderService(RiderService riderService) {
		this.riderService = riderService;
	}

	//采用属性封装传送点id参数
	private String teleporterId;
	public String getTeleporterId() {
		return teleporterId;
	}
	public void setTeleporterId(String teleporterId) {
		this.teleporterId = teleporterId;
	}

	//采用模型驱动封装骑手参数
	private Rider rider = new Rider();
	public Rider getRider() {
		return rider;
	}
	public void setRider(Rider rider) {
		this.rider = rider;
	}

	@Override
	public Rider getModel() {
		// TODO Auto-generated method stub
		return this.rider;
	}
	
	
	/**
	 * 骑手注册
	 */
	public String register() {
		this.rider.setUsername(rider.getTel());
		this.rider.setSex(1);
		//1.校验手机号是否已注册
		if(riderService.telIsRegister(rider.getTel())) {
			this.getJsonData().put("state", -1);
			return "jsonData";
		}
		
		//2.注册用户业务处理
		int state = riderService.registerRider(rider);
		this.getJsonData().put("state", state);
		return "jsonData";
	}
	
	/**
	 * 骑手手机号登入
	 */
	public String loginByTel() {
		//1.校验手机号是否存在
		Rider resultRider = riderService.findRiderByTel(rider.getTel());
		
	
		//2.骑手手机号登入业务处理
		if(resultRider != null) {
			//设置相应的token
			long currentTime  = System.currentTimeMillis();
			String token = resultRider.getRiderId()+"_"+currentTime;
			//2.1更新骑手token
			int state = riderService.updateRiderToken(resultRider.getRiderId(), token);
			if(state == 0) {
				this.getJsonData().put("state", 0);
				return "jsonData";
			}
			resultRider.setToken(token);
			
			this.getJsonData().put("state", 1);
			this.getJsonData().put("rider",resultRider);
		}else {
			this.getJsonData().put("state", -1);
		}
		return "jsonData";
	}
	
	
	/**
	 * 更新骑手信息
	 */
	public String update() {	
		int resultState;
		//1.判断token是否有效
		resultState =riderService.validateToken(rider.getToken());
		if(resultState == -1) {
			this.getJsonData().put("state", -1);
			return "jsonData";
		}
		//获取数据库中骑手所有信息,根据传入参数进行update
		Rider tempRider = riderService.findRiderById(rider.getRiderId());
		if(rider.getUsername() != null && !rider.getUsername().trim().equals("")) {
			tempRider.setUsername(rider.getUsername());
		}
		if(rider.getPassword()!= null && !rider.getPassword().trim().equals("")) 
			tempRider.setPassword(MD5Util.MD5(rider.getPassword()));
		if(rider.getSex() != 0)
			tempRider.setSex(rider.getSex());
		if(rider.getTel() != null && !rider.getTel().trim().equals(""))
			tempRider.setTel(rider.getTel());
				
		//更新用户
	    resultState = riderService.updateUserService(tempRider);
	    this.getJsonData().put("state",resultState);
	
	
	
		return "jsonData";
	}
	
	/**
	 * 骑手传送点登记
	 */
	public String checkin() {
		
		int state = 1;
		state = riderService.riderCheckin(teleporterId,rider.getRiderId());
		this.getJsonData().put("state", state);
		return "jsonData";
	}
	
	
	public String findAll() {
		
		return "json";
	}
	
}
