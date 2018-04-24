package top.yigege.service;

import java.util.List;

import top.yigege.dao.TeleporterAdminDao;
import top.yigege.domain.TeleporterAdmin;

public class TeleporterAdminService {
	private TeleporterAdminDao teleporterAdminDao;
	public void setTeleporterAdminDao(TeleporterAdminDao teleporterAdminDao) {
		this.teleporterAdminDao = teleporterAdminDao;
	}
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
	public List<TeleporterAdmin> findAll() {
		
		return teleporterAdminDao.findAll();
	}
	public TeleporterAdmin adminLogin(TeleporterAdmin teleporterAdmin) {
		
		
		return teleporterAdminDao.findTeleporterAdminByPass(teleporterAdmin);
	}
	

}
