package top.yigege.dao.impl;

import java.util.List;

import org.hibernate.Session;

import top.yigege.dao.SuperAdminDao;
import top.yigege.domain.SuperAdmin;
import top.yigege.domain.User;

/**
 * 
 * @ClassName:  SuperAdminDaoImpl   
 * @Description:超级管理员实现类
 * @author: yigege
 * @date:   2018年12月16日 下午5:22:25
 */
public class SuperAdminDaoImpl extends BaseDaoImpl<SuperAdmin> implements SuperAdminDao {

	@Override
	public SuperAdmin findSuperAdminByUsernameAndPass(String username, String password) {
		SuperAdmin superAdmin = null;
		Session session = this.getSessionFactory().getCurrentSession();
		String hql = "from SuperAdmin where username = ? and password = ?";
		@SuppressWarnings("rawtypes")
		List list = session.createQuery(hql)
				.setParameter(0, username)
				.setParameter(1, password)
				.list();
		if(!list.isEmpty() && list.size() > 0){
			superAdmin = (SuperAdmin) list.get(0);
		}

		return superAdmin;
	}



}
