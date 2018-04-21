package top.yigege.domain;

import java.util.Date;

public class Teleporter {
	private Integer teleporterId;
	private Date createDate;
	private String address;
	private String remark;
	
	//传送点与传送点管理员一对一
	private TeleporterAdmin teleporterAdmin;
	public TeleporterAdmin getTeleporterAdmin() {
		return teleporterAdmin;
	}
	public void setTeleporterAdmin(TeleporterAdmin teleporterAdmin) {
		this.teleporterAdmin = teleporterAdmin;
	}
	public Integer getTeleporterId() {
		return teleporterId;
	}
	public void setTeleporterId(Integer teleporterId) {
		this.teleporterId = teleporterId;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
}
