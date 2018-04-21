package top.yigege.domain;

public class TeleporterAdmin {
	private String telporterAdminId;
	private String username;
	private String password;
	private int sex;
	private String tel;
	
	
	//传送点管理员与传送点一对一
	private Teleporter teleporter;
	public Teleporter getTeleporter() {
		return teleporter;
	}
	public void setTeleporter(Teleporter teleporter) {
		this.teleporter = teleporter;
	}
	public String getTelporterAdminId() {
		return telporterAdminId;
	}
	public void setTelporterAdminId(String telporterAdminId) {
		this.telporterAdminId = telporterAdminId;
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
	
}
