package top.yigege.dao.impl;


import java.util.List;

import top.yigege.dao.AreaDao;
import top.yigege.domain.Area;

/**
 * 
 * @ClassName:  AreaDaoImpl   
 * @Description:TODO
 * @author: yigege
 * @date:   2019年3月6日 下午8:53:10
 */
public class AreaDaoImpl extends BaseDaoImpl<Area> implements AreaDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<Area> getCities() {
		List<Area> areas = null;
		String hql = "from Area a where a.parent_id != 0"; 
		areas = this.getSessionFactory().getCurrentSession().createQuery(hql).list();
		return areas;
	}

	
}
