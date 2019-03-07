package top.yigege.service;

import java.util.List;

import top.yigege.dao.TeleporterAdminDao;
import top.yigege.domain.TeleporterAdmin;

/**
 * 
 * @ClassName:  TeleporterAdminService   
 * @Description:传送点管理员服务类
 * @author: yigege
 * @date:   2018年12月16日 上午11:36:16
 */
public class TeleporterAdminService {
	
	/**传送点管理员Dao*/
	private TeleporterAdminDao teleporterAdminDao;
	public void setTeleporterAdminDao(TeleporterAdminDao teleporterAdminDao) {
		this.teleporterAdminDao = teleporterAdminDao;
	}
	
	/**
	 * 添加传送点管理员
	 * @param teleporterAdmin
	 * @return
	 */
	public int addAdmin(TeleporterAdmin teleporterAdmin) {
		int resultState = 1;
		try {
			teleporterAdminDao.save(teleporterAdmin);
		}catch(Exception e) {
			resultState = 0;
			return resultState;
		}
		return resultState;
	}
	
	/**
	 * 删除管理员
	 * @param teleporterAdmin
	 * @return
	 */
	public int deleteAdmin(TeleporterAdmin teleporterAdmin) {
		int resultState = 1;
		try {
			teleporterAdminDao.delete(teleporterAdmin);
		}catch(Exception e) {
			resultState = 0;
			return resultState;
		}
		return resultState;
	}
	
	/**
	 * 查询所有管理员
	 * @return
	 */
	public List<TeleporterAdmin> findAll() {
		
		return teleporterAdminDao.findAll();
	}
	
	/**
	 * 管理员登入
	 * @param cookie_tel_str
	 * @param cookie_password_str
	 * @return
	 */
	public TeleporterAdmin loginByPass(String cookie_tel_str,
			String cookie_password_str) {
		
		return teleporterAdminDao.loginByTel2(cookie_tel_str, cookie_password_str);
	}
	
	/**
	 * 手机号是否存在
	 * @param tel
	 * @return
	 */
	public boolean telIsExist(String tel) {
		
		return teleporterAdminDao.telIsExist(tel);
	}
	
	/**
	 * 通过id返回传送点管理员
	 * @return
	 */
	public TeleporterAdmin getTeleporterAdminById(String id) {
		return teleporterAdminDao.find(id);
	}
	

}
