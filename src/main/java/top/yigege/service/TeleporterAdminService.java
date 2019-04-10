package top.yigege.service;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import top.yigege.dao.TeleporterAdminDao;
import top.yigege.dao.TeleporterDao;
import top.yigege.domain.SuperAdmin;
import top.yigege.domain.Teleporter;
import top.yigege.domain.TeleporterAdmin;
import top.yigege.util.MD5Util;
import top.yigege.util.ValidatorUtil;
import top.yigege.vo.TeleporterAdminQueryCondition;

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

	/**传送点Dao*/
	private TeleporterDao teleporterDao;
	public void setTeleporterDao(TeleporterDao teleporterDao) {
		this.teleporterDao = teleporterDao;
	}

	public void setTeleporterAdminDao(TeleporterAdminDao teleporterAdminDao) {
		this.teleporterAdminDao = teleporterAdminDao;
	}
	
	/**
	 * 添加传送点管理员
	 * @param teleporterAdmin
	 * @return
	 */
	public void addAdmin(TeleporterAdmin teleporterAdmin, SuperAdmin superAdmin) throws Exception {
		if (null == teleporterAdmin.getTeleporter()) {
			throw  new Exception("传送点不能为空");
		}

		int teleporterId = teleporterAdmin.getTeleporter().getTeleporterId();

		//设置密码,默认为手机号
		teleporterAdmin.setPassword(MD5Util.MD5(teleporterAdmin.getTel()));

		//判断此传送是否被绑定
		Teleporter teleporter = teleporterDao.find(teleporterId);
		if (null == teleporter) {
			throw new Exception("系统错误，传送点"+teleporterId+"不存在");
		}else {
			if (null != teleporter.getTeleporterAdmin()) {
				throw  new Exception("传送点【"+teleporter.getAddress()+"】,管理员【"+teleporter.getTeleporterAdmin().getUsername()+"】已绑定,请先解绑");
			}
		}
		//设置传送点
		teleporterAdmin.setTeleporter(teleporter);
		//设置日期
		teleporterAdmin.setRegisterDate(new Date());
		//设置录入人
		teleporterAdmin.setSuperAdmin(superAdmin);

		teleporterAdminDao.save(teleporterAdmin);


	}
	
	/**
	 * 删除管理员
	 * @param teleporterAdmin
	 * @return
	 */
	public void deleteAdmin(TeleporterAdmin teleporterAdmin) throws Exception {
	    TeleporterAdmin deleteTeleporterAdmin = getTeleporterAdminById(teleporterAdmin.getTeleporterAdminId());
	    if (null == deleteTeleporterAdmin) {
	        throw  new Exception("系统错误，管理员"+deleteTeleporterAdmin.getTeleporterAdminId()+"不存在");
        }

	    teleporterAdminDao.delete(deleteTeleporterAdmin);

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
	public void doBindAdminAndTeleporter(String teleporterAdminId,Teleporter teleporter) throws Exception {
		
		
		TeleporterAdmin teleporterAdmin = getTeleporterAdminById(teleporterAdminId);
		if (null == teleporterAdmin) {
			throw new Exception(teleporterAdminId+"管理员不存在!");
		}
		
		if (null == teleporter) {
			throw new Exception("传送点不能为空!");
		}
		
		//判断此管理员是否已经绑定其他传送点
		if (null != teleporterAdmin.getTeleporter() && (!teleporterAdmin.getTeleporter().getTeleporterId().equals(teleporter.getTeleporterId()))) {
			throw new Exception("管理员:"+teleporterAdmin.getUsername()+",已绑定("+"编号【"+teleporterAdmin.getTeleporter().getTeleporterId()+"】,地址【"+teleporterAdmin.getTeleporter().getAddress()+"】,请先解除");
		}
		

		//判断此传送点是否已绑定其他管理员
		TeleporterAdmin tempTeleporterAdmin =  getTeleporterAdminByTeleporterId(teleporter.getTeleporterId());
		if (null != tempTeleporterAdmin && (!tempTeleporterAdmin.getTeleporterAdminId().equals(teleporterAdmin.getTeleporterAdminId()))) {
			throw new Exception("编号:"+teleporter.getTeleporterId()+" 地址:"+teleporter.getAddress()+"已绑定(编号【"+tempTeleporterAdmin.getTeleporterAdminId()+"】，姓名【"+tempTeleporterAdmin.getUsername()+"】，请先解除");

		}
		
		//重新设置传送点
		teleporterAdmin.setTeleporter(teleporter);
		
		teleporterAdminDao.update(teleporterAdmin);
	}

    /**
     * 解除管理员与传送点绑定关系
     * @param teleporterAdminId
     * @return 解绑后的实体
     * @throws Exception
     */
	public TeleporterAdmin doUnBindAdminAndTeleporter(String teleporterAdminId) throws Exception {
		
		TeleporterAdmin teleporterAdmin = getTeleporterAdminById(teleporterAdminId);
		if (null == teleporterAdmin) {
			throw new Exception(teleporterAdminId+"管理员不存在!");
		}

		if (null == teleporterAdmin.getTeleporter()) {
		    throw new Exception(teleporterAdmin.getUsername()+"还没有绑定传送点，请先绑定");
        }

		//外键置为Null
		teleporterAdmin.setTeleporter(null);
		teleporterAdminDao.update(teleporterAdmin);

		return teleporterAdmin;
	}

	/**
	 * 分页查询传送点管理员
	 * @param page 当前页
	 * @param rows 分页大小
	 * @param teleporterAdminQueryCondition 查询条件
	 * @return
	 */
	public List<TeleporterAdmin> pageListByCondition(int page, int rows, TeleporterAdminQueryCondition teleporterAdminQueryCondition) {


		return teleporterAdminDao.pageListByCondition(page,rows,teleporterAdminQueryCondition);

	}

	/**
	 * 分页总数
	 * @param teleporterAdminQueryCondition
	 * @return
	 */
	public Long getTeleporterAdminCountByCondition(TeleporterAdminQueryCondition teleporterAdminQueryCondition) {
		return teleporterAdminDao.getTeleporterAdminCountByCondition(teleporterAdminQueryCondition);
	}


	/**
	 * 通过id查询传送点管理员
	 * @param teleporterAdminId
	 * @return
	 */
	public TeleporterAdmin queryTeleporterAdminById(Integer teleporterAdminId) {
		return teleporterAdminDao.find(teleporterAdminId);
	}


    /**
     * 修改管理员
     * @param teleporterAdmin
     */
	public void updateTeleporterAdmin(TeleporterAdmin teleporterAdmin) throws Exception {
	    if (StringUtils.isBlank(teleporterAdmin.getTeleporterAdminId())) {
	        throw  new Exception("传送点管理员ID不能为空");
        }

		TeleporterAdmin updateTeleporterAdmin = getTeleporterAdminById(teleporterAdmin.getTeleporterAdminId());
	    if (null == updateTeleporterAdmin) {
	    	throw new Exception("系统错误，"+teleporterAdmin.getTeleporterAdminId()+"传送点不存在");
		}

	    //用户名
	    if (StringUtils.isNotBlank(teleporterAdmin.getUsername())) {
	    	updateTeleporterAdmin.setUsername(teleporterAdmin.getUsername());
		}

	    //手机号
		if (StringUtils.isNotBlank(teleporterAdmin.getTel())) {
			updateTeleporterAdmin.setTel(teleporterAdmin.getTel());
		}

		//性别
		updateTeleporterAdmin.setSex(teleporterAdmin.getSex());

		//传送点是否更新
		if (null == teleporterAdmin.getTeleporter() || null == teleporterAdmin.getTeleporter().getTeleporterId()) {
		//	throw  new Exception("传送点不能为空!");
		}else {
			doBindAdminAndTeleporter(teleporterAdmin.getTeleporterAdminId(),teleporterDao.find(teleporterAdmin.getTeleporter().getTeleporterId()));
		}
		teleporterAdminDao.update(updateTeleporterAdmin);

    }


    /**
     * 校验传送点管理员信息
     * @param teleporterAdmin
     * @return
     */
	public String validTeleporterAdminData(TeleporterAdmin teleporterAdmin) {
	    StringBuilder message = new StringBuilder();
	    if (null != teleporterAdmin) {

	        //用户名
	        if (StringUtils.isBlank(teleporterAdmin.getUsername())) {
	            message.append("用户名不能为空!\r\n");
            }

	        //手机号
            if (StringUtils.isBlank(teleporterAdmin.getTel())) {
                message.append("手机号不能为空!\r\n");
            }else {
                if (!ValidatorUtil.isMobile(teleporterAdmin.getTel())) {
                    message.append("手机号格式非法!\r\n");
                }else if (telIsExist(teleporterAdmin.getTel())) {
                	message.append("手机号已被注册!\r\n");
				}
            }
         }

	    return message.toString();
    }

	/**
	 * 修改传送时信息校验
	 * @param teleporterAdmin
	 * @return
	 */
	public String modifyTeleporterAdminValid(TeleporterAdmin teleporterAdmin) {
		StringBuilder message = new StringBuilder();
		if (null != teleporterAdmin) {

			//用户名
			if (StringUtils.isBlank(teleporterAdmin.getUsername())) {
				message.append("用户名不能为空!\r\n");
			}

		}

		return message.toString();
	}

}
