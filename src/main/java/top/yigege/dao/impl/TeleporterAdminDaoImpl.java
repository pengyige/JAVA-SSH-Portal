package top.yigege.dao.impl;

import java.util.List;

import org.hibernate.Session;

import top.yigege.dao.TeleporterAdminDao;
import top.yigege.domain.TeleporterAdmin;
import top.yigege.domain.User;
import top.yigege.util.MD5Util;

public class TeleporterAdminDaoImpl extends BaseDaoImpl<TeleporterAdmin> implements TeleporterAdminDao{

	/*
	 * author:mengyue
	 * 判断用户是否存在
	 */
	public boolean telIsExist(String tel) {
		Session session = this.getSessionFactory().getCurrentSession();
		String hql = "from TeleporterAdmin where tel = ?";
		List list = session.createQuery(hql)
				.setParameter(0, tel)
				.list();
		
		if(list.isEmpty()){
			return false;
		}
			return true;
		
	}
	
	
	/*
	 * 通过参数tel password进行登录
	 */
	public TeleporterAdmin loginByTel2(String tel, String password) {
		TeleporterAdmin resultTeleporterAdmin=null;
		Session session=this.getSessionFactory().getCurrentSession();
		String hql="from TeleporterAdmin where tel=? and password=?";
		List list=session.createQuery(hql)
				.setParameter(0, tel)
				.setParameter(1, password)
				.list();
		if(!list.isEmpty()){
				resultTeleporterAdmin=(TeleporterAdmin)list.get(0);
		}
		return resultTeleporterAdmin;
		
	}



}
