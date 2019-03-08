package top.yigege.dao;

import top.yigege.domain.TeleporterAdmin;

/**
 * 
 * @ClassName:  TeleporterAdminDao   
 * @Description:传送点管理员Dao
 * @author: yigege
 * @date:   2018年12月16日 上午11:04:39
 */
public interface TeleporterAdminDao extends BaseDao<TeleporterAdmin>{


	/**
	 * 
	 * @param cookie_tel_str
	 * @param cookie_password_str
	 * @return
	 */
	TeleporterAdmin loginByTel2(String cookie_tel_str, String cookie_password_str);

	/**
	 * 手机号是否存在
	 * @param tel
	 * @return
	 */
	boolean telIsExist(String tel);

	/**
	 * 通过传送点id获取管理员
	 * @param teleporterId
	 * @return
	 */
	TeleporterAdmin findByTeleporterId(Integer teleporterId);

}
