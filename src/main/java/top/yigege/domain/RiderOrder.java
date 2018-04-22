package top.yigege.domain;

import java.util.Date;

public class RiderOrder {
	private String riderOrderId;
	private Date createDate;
	
	private UserOrder userOrder;
	private Rider rider;
	public String getRiderOrderId() {
		return riderOrderId;
	}
	public void setRiderOrderId(String riderOrderId) {
		this.riderOrderId = riderOrderId;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public UserOrder getUserOrder() {
		return userOrder;
	}
	public void setUserOrder(UserOrder userOrder) {
		this.userOrder = userOrder;
	}
	public Rider getRider() {
		return rider;
	}
	public void setRider(Rider rider) {
		this.rider = rider;
	}
	
	
}
