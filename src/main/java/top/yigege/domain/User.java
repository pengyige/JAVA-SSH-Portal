package top.yigege.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.apache.struts2.json.annotations.JSON;

/**
 * 
 * @ClassName:  User   
 * @Description:用户实体
 * @author: yigege
 * @date:   2018年12月16日 上午11:22:17
 */
public class User {
	
	/**用户id*/
	private String userId;
	
	/**用户token*/
	private String token;
	
	/**用户名*/
	private String username;
	
	/**用户密码*/
	private String password;
	
	/**用户性别*/
	private int sex;
	
	/**用户手机号*/
	private String tel;
	
	/**用户邮箱*/
	private String email;
	
	/**用户地址*/
	private String address;
	
	/**用户类型*/
	private int type;
	
	/**用户注册时间*/
	private Date createTime;
	
	/**余额*/
	private Double balance;
	
	/**用户订单*/
	private Set<UserOrder> userOrders = new HashSet<UserOrder>();
	@JSON(serialize=false)
	public Set<UserOrder> getUserOrders() {
		return userOrders;
	}
	public void setUserOrders(Set<UserOrder> userOrders) {
		this.userOrders = userOrders;
	}
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
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Double getBalance() {
		return balance;
	}
	public void setBalance(Double balance) {
		this.balance = balance;
	}
	
	
	
	
}
