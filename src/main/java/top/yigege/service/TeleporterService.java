package top.yigege.service;

import java.util.List;

import org.apache.commons.lang.StringUtils;

import top.yigege.dao.TeleporterDao;
import top.yigege.domain.Area;
import top.yigege.domain.Teleporter;
import top.yigege.domain.TeleporterAdmin;

/**
 * 
 * @ClassName:  TeleporterService   
 * @Description:传送点服务类
 * @author: yigege
 * @date:   2018年12月16日 上午11:37:38
 */
public class TeleporterService {
	
	/**传送点Dao*/
	private TeleporterDao teleporterDao;
	
	/**区域服务层*/
	private AreaService areaService;
	
	/**传送点管理员服务层*/
	private TeleporterAdminService teleporterAdminService;
	
	public void setTeleporterDao(TeleporterDao teleporterDao) {
		this.teleporterDao = teleporterDao;
	}
	
	public void setAreaService(AreaService areaService) {
		this.areaService = areaService;
	}

	public void setTeleporterAdminService(TeleporterAdminService teleporterAdminService) {
		this.teleporterAdminService = teleporterAdminService;
	}

	/**
	 * 添加传送点
	 * @param teleporter
	 * @return
	 */
	public int addTeleporter(Teleporter teleporter) {
		int resultState = 1;
		try {
			teleporterDao.save(teleporter);
		}catch(Exception e) {
			resultState = 0;
			return resultState;
		}
		return resultState;
	}
	
	/**
	 * 通过对传送点id删除传送点
	 * @param teleporterId
	 * @return
	 */
	public int deleteTeleporterById(Integer teleporterId) {
		int resultState = 1;
		try {
			Teleporter t = new Teleporter();
			t.setTeleporterId(teleporterId);
			teleporterDao.delete(t);
		}catch(Exception e) {
			resultState = 0;
			return resultState;
		}
		return resultState;
	}


	/**
	 * 查询所有传送点
	 * @return
	 */
	public List<Teleporter> queryAll() {
		
		return teleporterDao.findAll();
	}
	
	/**
	 * 返回传送点所有数量
	 * @return
	 */
	public Long getTeleporterCount() {
		
		return teleporterDao.getAllCount();
	}
	
	/**
	 * 分页查询
	 * @param page
	 * @param rows
	 * @return
	 */
	public List<Teleporter> pageList(int page , int rows) {
		return teleporterDao.pageList(page,rows);
	}
	
	
	/**
	 * 通过id查询传送点
	 * @param teleporterId
	 * @return
	 */
	public Teleporter queryTeleporterById(Integer teleporterId) {
		return teleporterDao.find(teleporterId);
	}

	/**
	 * 更新传送点信息
	 * @param teleporter 需要更新的传送点信息
	 * @throws Exception 
	 */
	public void updateTelerpoter(Teleporter teleporter) throws Exception {
		//得到数据库中原始对象
		
		Teleporter oldTeleporter = queryTeleporterById(teleporter.getTeleporterId());
		
		//区域是否修改
		if (null != teleporter.getArea() && null != teleporter.getArea().getId()) {
			//修改此传送点区域
			Area area = areaService.getAreaById(teleporter.getArea().getId());
			//重新设置一对一实体关系
			if (null == area) {
				throw new Exception(teleporter.getArea().getId()+"区域不存在");
			}
			oldTeleporter.setArea(area);
		}
		
		//地址是否修改
		if (StringUtils.isNotBlank(teleporter.getAddress())) {
			oldTeleporter.setAddress(teleporter.getAddress());
		}
		
		//管理员是否修改
		if (null != teleporter.getTeleporterAdmin() && StringUtils.isNotBlank(teleporter.getTeleporterAdmin().getTeleporterAdminId())) {
			//修改此管理员
			TeleporterAdmin teleporterAdmin = teleporterAdminService.getTeleporterAdminById(teleporter.getTeleporterAdmin().getTeleporterAdminId());
			//重新设置映射关系
			if (null == teleporterAdmin) {
				throw new Exception(teleporter.getTeleporterAdmin().getTeleporterAdminId()+"传送点管理员不存在");
			}
			oldTeleporter.setTeleporterAdmin(teleporterAdmin);
		}
		
		//更新实体
		teleporterDao.update(oldTeleporter);
		
	}

}
