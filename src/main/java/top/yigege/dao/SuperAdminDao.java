package top.yigege.dao;

import top.yigege.domain.SuperAdmin;

/**
 * 
 * @ClassName:  SuperAdminDao   
 * @Description:超级管理员Dao
 * @author: yigege
 * @date:   2018年12月16日 下午5:21:20
 */
public interface SuperAdminDao extends BaseDao<SuperAdmin> {

	/**
	 * 通过姓名和密码查找超级管理员
	 * @param username
	 * @param password
	 */
	SuperAdmin findSuperAdminByUsernameAndPass(String username,String password);
}
