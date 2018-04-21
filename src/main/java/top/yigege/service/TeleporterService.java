package top.yigege.service;

import java.util.List;

import top.yigege.dao.TeleporterDao;
import top.yigege.domain.Teleporter;

public class TeleporterService {
	private TeleporterDao teleporterDao;
	public void setTeleporterDao(TeleporterDao teleporterDao) {
		this.teleporterDao = teleporterDao;
	}
	
	
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


	public List<Teleporter> queryAll() {
		
		return teleporterDao.findAll();
	}
	

}
