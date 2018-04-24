package top.yigege.dao.impl;

import java.util.List;

import org.hibernate.Session;

import top.yigege.dao.TeleporterAdminDao;
import top.yigege.domain.TeleporterAdmin;
import top.yigege.domain.User;
import top.yigege.util.MD5Util;

public class TeleporterAdminDaoImpl extends BaseDaoImpl<TeleporterAdmin> implements TeleporterAdminDao{

	@Override
	public TeleporterAdmin findTeleporterAdminByPass(TeleporterAdmin teleporterAdmin) {
		TeleporterAdmin tempTeleporterAdmin = null;
		Session session = this.getSessionFactory().getCurrentSession();
		String hql = "from TeleporterAdmin where password = ? and tel = ?";
		List list = session.createQuery(hql)
				.setParameter(0, MD5Util.MD5(teleporterAdmin.getPassword()))
				.setParameter(1, teleporterAdmin.getTel())
				.list();
		if(!list.isEmpty()){
			tempTeleporterAdmin = (TeleporterAdmin) list.get(0);
		}

		return tempTeleporterAdmin;

	}

}
