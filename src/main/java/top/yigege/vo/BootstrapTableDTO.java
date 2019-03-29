package top.yigege.vo;

import java.util.List;

import top.yigege.enums.HttpCodeEnum;

/**
 * 
 * @ClassName:  BootstrapTableDTO   
 * @Description:bootstrap返回实体
 * @author: yigege
 * @date:   2019年3月6日 下午10:14:36
 */
public class BootstrapTableDTO {
	
	/**总数*/
	private int total;
	
	/**数据*/
	private List rows;

	/**返回码，传送门使用*/
	private int code;

	/**消息，传送门使用*/
	private Object message;

	public Object getMessage() {
		return message;
	}

	public void setMessage(Object message) {
		this.message = message;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public List getRows() {
		return rows;
	}

	public void setRows(List rows) {
		this.rows = rows;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}
	
	
	
	
}
