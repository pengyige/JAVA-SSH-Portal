package top.yigege.userdao;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;

import top.yigege.dao.impl.UserDaoImpl;
import top.yigege.domain.User;
import top.yigege.util.HibernateUtil;

public class UserDaoTest {
	
	
	@Test
	public void testSave() {
		User user = new User();
		user.setTel("18186424431");
		user.setType(1);
		
		UserDaoImpl userDao = new UserDaoImpl();
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		userDao.setSessionFactory(sessionFactory);
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		userDao.save(user);
		session.getTransaction().commit();
		
		
	}
	
	
	@Test
	public void testUpdateUser() {
		User user = new User();
		user.setUserId("4028ab5b62d31a5d0162d31a605f0000");
		user.setTel("11111111");
		user.setType(1);
		UserDaoImpl userDao = new UserDaoImpl();
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		userDao.setSessionFactory(sessionFactory);
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		userDao.update(user);
		session.getTransaction().commit();
	}
	
	@Test
	public void test() {
		SimpleDateFormat bartDateFormat = new SimpleDateFormat("yyyyddmm");
		System.out.println(bartDateFormat.format(new Date()));
	}

}
