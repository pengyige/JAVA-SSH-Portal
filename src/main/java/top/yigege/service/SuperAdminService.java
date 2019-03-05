package top.yigege.service;

import top.yigege.dao.SuperAdminDao;
import top.yigege.domain.SuperAdmin;

/**
 * 
 * @ClassName:  SuperAdminService   
 * @Description:超级管理员服务类
 * @author: yigege
 * @date:   2018年12月16日 下午5:29:24
 */
public class SuperAdminService{

	/**超级管理员Dao*/
	private SuperAdminDao superAdminDao;
	
	public void setSuperAdminDao(SuperAdminDao superAdminDao) {
		this.superAdminDao = superAdminDao;
	}
	
	
	/**
	 * 判断用户号和密码是否正确
	 */
	public SuperAdmin verifySuperAdmin(String username,String password) {
		
		return superAdminDao.findSuperAdminByUsernameAndPass(username, password);
	}
	
	
	/**
	 * 添加管理员
	 * @param superAdmin
	 */
	public void addSuperAdmin(SuperAdmin superAdmin) {
		
		superAdminDao.save(superAdmin);
	}
	
	/**
	 * 更新管理员信息
	 * @param superAdmin
	 */
	public void updateSuperAdmin(SuperAdmin superAdmin) {
		superAdminDao.update(superAdmin);
	}
	
}
