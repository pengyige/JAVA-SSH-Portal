package top.yigege.domain;

import java.util.Date;

import org.apache.struts2.json.annotations.JSON;

/**
 * 
 * @ClassName:  UserOrder   
 * @Description:用户订单
 * @author: yigege
 * @date:   2018年12月16日 上午11:25:29
 */
public class UserOrder {
	
	/**用户订单id*/
	private String userOrderId;
	
	/**发送人地址*/
	private String shipAddress;
	
	/**发送人姓名*/
	private String shipName;
	
	/**发送人电话*/
	private String shipTel;
	
	/**收件人地址*/
	private String receiveAddress;
	
	/**收件人姓名*/
	private String receiveName;
	
	/**收件人电话*/
	private String receiveTel;
	
	/**订单日期*/
	private Date orderTime;
	
	/**支付金额*/
	private double payment;
	
	/**备注*/
	private String remark;
	
	/**订单状态*/
	private String state;
	
	/**经度*/
	private double longitude;
	
	/**纬度*/
	private double latitude;
	
	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	private User user;

	public String getUserOrderId() {
		return userOrderId;
	}

	public void setUserOrderId(String userOrderId) {
		this.userOrderId = userOrderId;
	}

	public String getShipAddress() {
		return shipAddress;
	}

	public void setShipAddress(String shipAddress) {
		this.shipAddress = shipAddress;
	}

	public String getShipName() {
		return shipName;
	}

	public void setShipName(String shipName) {
		this.shipName = shipName;
	}

	public String getShipTel() {
		return shipTel;
	}

	public void setShipTel(String shipTel) {
		this.shipTel = shipTel;
	}

	public String getReceiveAddress() {
		return receiveAddress;
	}

	public void setReceiveAddress(String receiveAddress) {
		this.receiveAddress = receiveAddress;
	}

	public String getReceiveName() {
		return receiveName;
	}

	public void setReceiveName(String receiveName) {
		this.receiveName = receiveName;
	}

	public String getReceiveTel() {
		return receiveTel;
	}

	public void setReceiveTel(String receiveTel) {
		this.receiveTel = receiveTel;
	}

	public Date getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(Date orderTime) {
		this.orderTime = orderTime;
	}

	public double getPayment() {
		return payment;
	}

	public void setPayment(double payment) {
		this.payment = payment;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@JSON(serialize=false)
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	
}
