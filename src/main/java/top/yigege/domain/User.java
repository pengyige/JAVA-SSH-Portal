package top.yigege.domain;

import java.util.HashSet;
import java.util.Set;

public class User {
	private String userId;
	private String token;
	private String username;
	private String password;
	private int sex;
	private String tel;
	private String email;
	private String address;
	private int type;
	
	private Set<UserOrder> userOrders = new HashSet<UserOrder>();
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
	
	
}
