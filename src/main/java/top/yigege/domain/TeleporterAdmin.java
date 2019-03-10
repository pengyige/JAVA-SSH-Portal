package top.yigege.domain;

import java.util.Date;

/**
 * 
 * @ClassName:  TeleporterAdmin   
 * @Description:传送点管理员
 * @author: yigege
 * @date:   2018年12月16日 上午11:20:52
 */
public class TeleporterAdmin {
	
	/**传送点管理员id*/
	private String teleporterAdminId;
	
	/**传送点管理员姓名*/
	private String username;
	
	/**传送点管理员密码*/
	private String password;
	
	/**传送点管理员性别*/
	private int sex;
	
	/**传送点管理员电话*/
	private String tel;
	
	/**注册时间*/
	private Date registerDate;
	
	/**操作人*/
	private  SuperAdmin superAdmin;
	
	//传送点管理员与传送点一对一
	private Teleporter teleporter;
	public Teleporter getTeleporter() {
		return teleporter;
	}
	public void setTeleporter(Teleporter teleporter) {
		this.teleporter = teleporter;
	}
	
	public String getTeleporterAdminId() {
		return teleporterAdminId;
	}
	public void setTeleporterAdminId(String teleporterAdminId) {
		this.teleporterAdminId = teleporterAdminId;
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
	public Date getRegisterDate() {
		return registerDate;
	}
	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}
	public SuperAdmin getSuperAdmin() {
		return superAdmin;
	}
	public void setSuperAdmin(SuperAdmin superAdmin) {
		this.superAdmin = superAdmin;
	}
	
	
	
	
	
}
