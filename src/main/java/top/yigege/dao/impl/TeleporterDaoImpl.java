package top.yigege.dao.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;

import top.yigege.dao.TeleporterDao;
import top.yigege.domain.Teleporter;
import top.yigege.util.DateUtil;
import top.yigege.util.TypeConvertUtil;
import top.yigege.vo.TeleporterQueryCondition;

/**
 * 
 * @ClassName:  TeleporterDaoImpl   
 * @Description:传送点Dao实现类
 * @author: yigege
 * @date:   2018年12月16日 上午11:15:40
 */
public class TeleporterDaoImpl extends BaseDaoImpl<Teleporter> implements TeleporterDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<Teleporter> pageListByCondition(int page, int rows, TeleporterQueryCondition teleporterQueryCondition) {
		Criteria criteria = this.getSessionFactory().getCurrentSession().createCriteria(Teleporter.class);
		criteria.setFirstResult((page-1)*rows);
		criteria.setMaxResults(rows);
		
		//编号
		if (null != teleporterQueryCondition) {
			if (StringUtils.isNotBlank(teleporterQueryCondition.getIds())) {
				criteria.add(Restrictions.in("teleporterId", TypeConvertUtil.StringToInt(teleporterQueryCondition.getIds().split(","))));
			}
			
			//地址
			if (StringUtils.isNotBlank(teleporterQueryCondition.getAreas())) {
				criteria = criteria.createAlias("area", "a");
				criteria.add(Restrictions.eq("a.id", Integer.parseInt(teleporterQueryCondition.getAreas())));

			}
			
			//日期
			if (null != teleporterQueryCondition.getDate()) {
				criteria.add(Restrictions.between("createDate",teleporterQueryCondition.getDate(),DateUtil.getNextDay(teleporterQueryCondition.getDate())));
			}
		}
		
		//排序
		criteria.addOrder(Order.asc("teleporterId"));
		return (List<Teleporter>)criteria.list();
	}

	@Override
	public Long getTeleporterCountByCondition(TeleporterQueryCondition teleporterQueryCondition) {
		Criteria criteria = this.getSessionFactory().getCurrentSession().createCriteria(Teleporter.class);
		criteria.setProjection(Projections.rowCount());
		//编号
		if (null != teleporterQueryCondition) {
			if (StringUtils.isNotBlank(teleporterQueryCondition.getIds())) {
				criteria.add(Restrictions.in("teleporterId", TypeConvertUtil.StringToInt(teleporterQueryCondition.getIds().split(","))));
			}
			
			//地址
			if (StringUtils.isNotBlank(teleporterQueryCondition.getAreas())) {
				criteria = criteria.createAlias("area", "a");
				criteria.add(Restrictions.eq("a.id", Integer.parseInt(teleporterQueryCondition.getAreas())));

			}
			
			//日期
			if (null != teleporterQueryCondition.getDate()) {
				criteria.add(Restrictions.between("createDate",teleporterQueryCondition.getDate(),DateUtil.getNextDay(teleporterQueryCondition.getDate())));
			}
		}
		
		return (Long) criteria.uniqueResult();
	}

	
}
