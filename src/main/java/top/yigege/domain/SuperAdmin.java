package top.yigege.domain;

import java.util.Date;

/**
 * 
 * @ClassName:  SuperAdmin   
 * @Description:超级管理员实体
 * @author: yigege
 * @date:   2018年12月16日 下午1:40:03
 */
public class SuperAdmin {
	
	/**超级管理员id*/
	private String superAdminId; 
	
	/**管理员姓名*/
	private String username;
	
	/**管理员密码*/
	private String password;
	
	/**上次登入时间*/
	private Date lastLoginTime;

	public SuperAdmin() {
		super();
		// TODO Auto-generated constructor stub
	}


	
	public SuperAdmin(String superAdminId, String username, String password, Date lastLoginTime) {
		super();
		this.superAdminId = superAdminId;
		this.username = username;
		this.password = password;
		this.lastLoginTime = lastLoginTime;
	}


	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public String getSuperAdminId() {
		return superAdminId;
	}

	public void setSuperAdminId(String superAdminId) {
		this.superAdminId = superAdminId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Date getLastLoginTime() {
		return lastLoginTime;
	}

	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	@Override
	public String toString() {
		return "SuperAdmin [superAdminId=" + superAdminId + ", username=" + username + ", lastLoginTime="
				+ lastLoginTime + "]";
	}
	
	

}
