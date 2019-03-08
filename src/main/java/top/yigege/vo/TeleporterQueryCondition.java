package top.yigege.vo;

import java.util.Date;

import com.mchange.util.IntEnumeration;

/**
 * 
 * @ClassName:  TeleporterQueryCondition   
 * @Description:传送点查询条件VO
 * @author: yigege
 * @date:   2019年3月8日 下午5:11:57
 */
public class TeleporterQueryCondition {

	/**传送点编号*/
	private String ids;
	
	/**传送点日期*/
	private Date date;
	
	private String address;
	
	/**区域*/
	private String areas;

	

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

	public String getAreas() {
		return areas;
	}

	public void setAreas(String areas) {
		this.areas = areas;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	
	
	
	
}
