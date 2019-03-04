package top.yigege.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.apache.struts2.json.annotations.JSON;

/**
 * 
 * @ClassName:  Rider   
 * @Description:骑手实体
 * @author: yigege
 * @date:   2018年12月16日 上午11:16:50
 */
public class Rider {
	/**骑手id*/
	private String riderId;
	/**骑手token*/
	private String token;
	/**骑手姓名*/
	private String username;
	/**骑手密码*/
	private String password;
	/**骑手性别*/
	private int sex;
	/**骑手电话*/
	private String tel;
	/**骑手真实姓名*/
	private String realName;
	/**骑手身份证号码*/
	private String  IDNumber;
	/**骑手地址*/
	private String address;
	/**收入*/
	private Double balance;
	
	public String getIDNumber() {
		return IDNumber;
	}

	public void setIDNumber(String iDNumber) {
		IDNumber = iDNumber;
	}


	private int riderState;
	public int getRiderState() {
		return riderState;
	}

	public void setRiderState(int riderState) {
		this.riderState = riderState;
	}


	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}


	private String deviceToken;
	public String getDeviceToken() {
		return deviceToken;
	}

	public void setDeviceToken(String deviceToken) {
		this.deviceToken = deviceToken;
	}


	private Date checkinDate;
	
	private Teleporter teleporter;
	public Teleporter getTeleporter() {
		return teleporter;
	}

	public void setTeleporter(Teleporter teleporter) {
		this.teleporter = teleporter;
	}

	
	private Set<RiderOrder> riderOrders = new HashSet<RiderOrder>();
	public String getRiderId() {
		return riderId;
	}

	public void setRiderId(String riderId) {
		this.riderId = riderId;
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

	@JSON(serialize=false)
	public Set<RiderOrder> getRiderOrders() {
		return riderOrders;
	}

	public void setRiderOrders(Set<RiderOrder> riderOrders) {
		this.riderOrders = riderOrders;
	}

	public Date getCheckinDate() {
		return checkinDate;
	}

	public void setCheckinDate(Date checkinDate) {
		this.checkinDate = checkinDate;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}
	
	
	
}
