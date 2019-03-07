package top.yigege.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;

import top.yigege.dao.BaseDao;

/**
 * 
 * @ClassName:  BaseDaoImpl   
 * @Description:基础DAO实现类
 * @author: yigege
 * @date:   2018年12月16日 上午11:11:46   
 * @param <T>
 */
public class BaseDaoImpl<T> implements BaseDao<T> {
	private Class pclass;
	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/*构造时获取运行中的泛型类型,如User.class;用于查询等操作*/
	public BaseDaoImpl() {
		//1.得到当前运行类的class
		Class clazz = this.getClass();
		
		//2.得到运行类的父类的参数化类型
		  //使用Type子接口ParameterizedType
		Type type = clazz.getGenericSuperclass();
		ParameterizedType ptype = (ParameterizedType) type;
		
		//3.得到实际类型参数
		Type[] types = ptype.getActualTypeArguments();
		this.pclass = (Class) types[0];
		
	}
	
	
	@Override
	public void save(T t) {
		this.sessionFactory.getCurrentSession().save(t);
		
	}

	@Override
	public void delete(T t) {
		this.sessionFactory.getCurrentSession().delete(t);
		
	}

	@Override
	public void update(T t) {
		this.sessionFactory.getCurrentSession().update(t);
		
	}

	@Override
	public T find(Serializable id) {
		return (T)this.sessionFactory.getCurrentSession().get(pclass, id);
	}

	@Override
	public List<T> findAll() {
		// TODO Auto-generated method stub
				String hql = "from "+pclass.getSimpleName();
				return (List<T>)(this.sessionFactory.getCurrentSession().createQuery(hql)
		.list());
	}
	
	public Long getAllCount() {
		Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(pclass);
        criteria.setProjection(Projections.rowCount());
        Long count = (Long) criteria.uniqueResult();
        return count;
	}

	
	@SuppressWarnings("unchecked")
	public List<T> pageList(int page , int rows) {
		Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(pclass);
		criteria.setFirstResult((page-1)*rows);
		criteria.setMaxResults(rows);
		return (List<T>)criteria.list();
	}
}
