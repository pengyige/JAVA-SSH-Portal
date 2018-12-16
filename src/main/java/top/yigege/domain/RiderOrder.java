package top.yigege.domain;

import java.util.Date;

/**
 * 
 * @ClassName:  RiderOrder   
 * @Description:骑手订单
 * @author: yigege
 * @date:   2018年12月16日 上午11:17:07
 */
public class RiderOrder {
	
	/**骑手订单id*/
	private String riderOrderId;
	/**骑手订单创建日期*/
	private Date createDate;
	/**用户订单*/
	private UserOrder userOrder;
	/**骑手*/
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
