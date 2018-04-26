package top.yigege.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.apache.struts2.json.annotations.JSON;

public class Rider {
	private String riderId;
	private String token;
	private String username;
	private String password;
	private int sex;
	private String tel;
	
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
	
	
}
