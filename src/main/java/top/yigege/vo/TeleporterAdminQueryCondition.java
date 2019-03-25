package top.yigege.vo;

import java.util.Date;

/**
 * 
 * @ClassName:  TeleporterAdminQueryCondition   
 * @Description:传送点管理员查询条件
 * @author: yigege
 * @date:   2019年3月24日 下午9:37:37
 */
public class TeleporterAdminQueryCondition {

	/**编号*/
	private String ids;
	
	/**登记日期*/
	private Date date;
	
	/**传送点*/
	private String teleporter;
	
	/**手机号*/
	private String phone;

	public String getIds() {
		return ids;
	}

	public void setIds(String ids) {
		this.ids = ids;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getTeleporter() {
		return teleporter;
	}

	public void setTeleporter(String teleporter) {
		this.teleporter = teleporter;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public TeleporterAdminQueryCondition() {
	}

	public TeleporterAdminQueryCondition(String ids, Date date, String teleporter, String phone) {
		this.ids = ids;
		this.date = date;
		this.teleporter = teleporter;
		this.phone = phone;
	}
}
