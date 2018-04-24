package top.yigege.web.action;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;

import top.yigege.domain.User;
import top.yigege.service.UserService;
import top.yigege.util.MD5Util;

public class UserAction extends BaseAction{
	private UserService userService;
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	

	//校验属性
	private String userId;
	private String token;
	private String username;
	private String password;
	private int sex;
	private String tel;
	private String email;
	private String address;
	private int type;
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
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	
	
	/**
	 * 修改用户
	 * @return
	 */
	public String updateUser() {
		//1.首先执行校验，失败后返回"input"
		
		//校验成功后
		User user = new User();
		user.setUserId(userId);
		user.setToken(token);
	
		int resultState;
		//1.判断token是否有效
		resultState =userService.validateToken(token);
		if(resultState == -1) {
			this.getJsonData().put("state", -1);
			return "jsonData";
		}
		//获取数据库中用户所有信息,根据传入参数进行update
		user = userService.findUserById(userId);
		if(username != null && !username.trim().equals("")) {
			//1.判断用户是否存在
			 if(userService.nameIsExist(username) == 1) {
				 this.getJsonData().put("state",-2);
				 return "jsonData";
			 }
			user.setUsername(username);
		}
		if(password!= null && !password.trim().equals("")) 
			user.setPassword(MD5Util.MD5(password));
		if(type != 0) 
			user.setType(type);
		if(sex != 0) 
			user.setSex(sex);
		if(password!= null && !password.trim().equals(""))
			user.setEmail(email);
		if(address != null && !address.trim().equals(""))
			user.setAddress(address);
		if(tel != null && !tel.trim().equals(""))
			user.setTel(tel);
				
		//更新用户
	    resultState = userService.updateUserService(user);
	    this.getJsonData().put("state",resultState);
		return "jsonData";
	}
	
	
	
	/**
	 * 通过手机号注册
	 * @return
	 */
	public String register() {
		
		User user = new User();
		user.setUsername(tel);
		user.setTel(tel);
		user.setSex(1);
		user.setType(1);
		if(userService.telIsRegister(tel)) {
			this.getJsonData().put("state", -1);
			return "jsonData";
		}
		int resultState = userService.registerUser(user);
		this.getJsonData().put("state",resultState);
		return "jsonData";
	}
	
	
	/**
	 * 用户密码登入
	 */
	public String login() {
		User user  = new User();
		if(tel != null && !tel.trim().equals(""))
			user.setTel(tel);
		if(password != null && !password.trim().equals(""))
			user.setPassword(MD5Util.MD5(password));
		
		//检查手机号是否被注册
		if(!userService.telIsRegister(user.getTel())) {
			this.getJsonData().put("state",-1);
			return "jsonData";
		}
		
		//检查手机号和密码是否匹配
		User resultUser = userService.loginUserByPassword(user);
		if(resultUser != null) {
		
			//设置相应的token
			long currentTime  = System.currentTimeMillis();
			String token = resultUser.getUserId()+"_"+currentTime;
			userService.updateUserToken(resultUser.getUserId(), token);
			resultUser.setToken(token);
			
			this.getJsonData().put("state", 1);
			this.getJsonData().put("user", resultUser);
		
		}else {
			this.getJsonData().put("state", 0);
		}
			
		return "jsonData";
	}
	
	/**
	 * 用户手机登入
	 */
	public String loginByTel() {
		User user = userService.findUserByTel(tel);
		if(user != null) {
			//设置相应的token
			long currentTime  = System.currentTimeMillis();
			String token = user.getUserId()+"_"+currentTime;
			userService.updateUserToken(user.getUserId(), token);
			user.setToken(token);
			
			this.getJsonData().put("state", 1);
			this.getJsonData().put("user",user);
			
			
		}else {
			this.getJsonData().put("state", 0);
		}
		return "jsonData";
	}
	
	
	
	/**
	 * 用户名是否存在
	 */
	public String nameIsExist() {
		
		int state = userService.nameIsExist(username);
		this.getJsonData().put("state", state);
		
		return "jsonData";
	}
	
	/**
	 * 注销用户
	 */
	public String logout() {
		int state = userService.clearUserToken(token);
		this.getJsonData().put("state", state);
		return "jsonData";
	}
	
	
	/**
	 * 手机号是否已注册
	 */
	public String telIsExist() {
		if(userService.telIsRegister(tel))
			this.getJsonData().put("state", 1);
		else
			this.getJsonData().put("state", 0);
		return "jsonData";
	}
	
	
	
	/**
	 * 超级管理员登入接口
	 */
	public String superAdminLogin() {
		if(username.equals("pengyi") && password.equals("123456")) {
			User user = new  User();
			user.setUsername(username);
			user.setPassword(password);
			 ActionContext actionContext = ActionContext.getContext();  
		        Map session = actionContext.getSession();  
		        session.put("superuser", user);  
		        return "admin";
		}	
		return "error";
	}
	
}
