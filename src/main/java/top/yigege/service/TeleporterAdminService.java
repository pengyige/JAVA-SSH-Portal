package top.yigege.service;

import java.util.List;

import top.yigege.dao.TeleporterAdminDao;
import top.yigege.domain.Teleporter;
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
	
	/**
	 * 通过传送点id获取传送点管理员
	 * @return
	 */
	public TeleporterAdmin getTeleporterAdminByTeleporterId(Integer teleporterId) {
		return teleporterAdminDao.findByTeleporterId(teleporterId);
	}
	
	/**
	 * 绑定管理员所属传送点
	 * 一个传送点只能对应一个管理员，反之也是，如要绑定，需先解除
	 * @param teleporterAdminId 传送点管理员id
	 * @param teleporter
	 * @throws Exception 
	 */
	public void bindAdminAndTeleporter(String teleporterAdminId,Teleporter teleporter) throws Exception {
		
		
		TeleporterAdmin teleporterAdmin = getTeleporterAdminById(teleporterAdminId);
		if (null == teleporterAdmin) {
			throw new Exception(teleporterAdminId+"管理员不存在!");
		}
		
		if (null == teleporter) {
			throw new Exception("传送点不能为空!");
		}
		
		//判断此管理员是否已经绑定其他传送点
		if (null != teleporterAdmin.getTeleporter()) {
			throw new Exception("管理员:"+teleporterAdmin.getUsername()+",已绑定("+"编号:"+teleporterAdmin.getTeleporter().getTeleporterId()+",地址:"+teleporterAdmin.getTeleporter().getAddress()+",请先解除");
		}
		

		//判断此传送点是否已绑定
		if (null != getTeleporterAdminByTeleporterId(teleporter.getTeleporterId())) {
			throw new Exception("编号:"+teleporter.getTeleporterId()+" 地址:"+teleporter.getAddress()+"已绑定，请先解除");
		} 
		
		//重新设置传送点
		teleporterAdmin.setTeleporter(teleporter);
		
		teleporterAdminDao.update(teleporterAdmin);
	}
	
	/**
	 * 解除管理员与传送点绑定关系
	 * @param teleporterAdminId
	 * @throws Exception 
	 */
	public void unBindAdminAndTeleporter(String teleporterAdminId) throws Exception {
		
		TeleporterAdmin teleporterAdmin = getTeleporterAdminById(teleporterAdminId);
		if (null == teleporterAdmin) {
			throw new Exception(teleporterAdminId+"管理员不存在!");
		}
		
		//外键置为Null
		teleporterAdmin.setTeleporter(null);
		teleporterAdminDao.update(teleporterAdmin);
	}
	

}
