package top.yigege.util;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * 
 * @ClassName:  HibernateUtil   
 * @Description:Hibernate帮助类
 * @author: yigege
 * @date:   2018年12月16日 上午11:46:43
 */
public class HibernateUtil {
	private static final SessionFactory ourSessionFactory;

    static {
        try {
            Configuration configuration = new Configuration();
            configuration.configure("hibernate.cfg.xml");

            ourSessionFactory = configuration.buildSessionFactory();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
    	return ourSessionFactory;
    }
    
    public static Session getSession() throws HibernateException {
        return ourSessionFactory.openSession();
    }
}
