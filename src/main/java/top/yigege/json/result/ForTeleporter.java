package top.yigege.json.result;

/**
 * 
 * @ClassName:  ForTeleporter   
 * @Description:
 * @author: yigege
 * @date:   2018年12月16日 上午10:41:47
 */
public class ForTeleporter {
	private int value;
	private String address;
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public ForTeleporter(int value, String address) {
		super();
		this.value = value;
		this.address = address;
	}
	
	
	
	
}
