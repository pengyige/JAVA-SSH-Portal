package top.yigege.service;

import java.util.List;

import top.yigege.dao.TeleporterDao;
import top.yigege.domain.Teleporter;

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
	public void setTeleporterDao(TeleporterDao teleporterDao) {
		this.teleporterDao = teleporterDao;
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
	

}
