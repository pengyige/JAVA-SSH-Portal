package top.yigege.dao.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;

import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import top.yigege.dao.TeleporterAdminDao;
import top.yigege.domain.TeleporterAdmin;
import top.yigege.domain.User;
import top.yigege.util.DateUtil;
import top.yigege.util.MD5Util;
import top.yigege.util.TypeConvertUtil;
import top.yigege.vo.TeleporterAdminQueryCondition;

/**
 * 
 * @ClassName:  TeleporterAdminDaoImpl   
 * @Description:传送点管理员Dao实现类
 * @author: yigege
 * @date:   2018年12月16日 上午11:14:23
 */
public class TeleporterAdminDaoImpl extends BaseDaoImpl<TeleporterAdmin> implements TeleporterAdminDao{

	/*
	 * author:mengyue
	 * 判断用户手机号是否存在
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
		if(null != list && !list.isEmpty()){
				resultTeleporterAdmin=(TeleporterAdmin)list.get(0);
		}
		return resultTeleporterAdmin;
		
	}


	/**
	 * 通过传送点id获取管理员
	 */
	@Override
	public TeleporterAdmin findByTeleporterId(Integer teleporterId) {
		TeleporterAdmin resultTeleporterAdmin=null;
		Session session=this.getSessionFactory().getCurrentSession();
		String hql="from TeleporterAdmin t where t.teleporter.teleporterId = ? ";
		List list=session.createQuery(hql)
				.setParameter(0, teleporterId)
				.list();
		if(null != list && !list.isEmpty()){
				resultTeleporterAdmin = (TeleporterAdmin)list.get(0);
		}
		return resultTeleporterAdmin;
	}

	@Override
	public List<TeleporterAdmin> pageListByCondition(int page, int rows, TeleporterAdminQueryCondition teleporterAdminQueryCondition) {
		Criteria criteria = this.getSessionFactory().getCurrentSession().createCriteria(TeleporterAdmin.class);
		criteria.setFirstResult((page-1)*rows);
		criteria.setMaxResults(rows);


		if (null != teleporterAdminQueryCondition) {
			//编号
			if (StringUtils.isNotBlank(teleporterAdminQueryCondition.getIds())) {
				criteria.add(Restrictions.in("teleporterAdminId", teleporterAdminQueryCondition.getIds().split(",")));
			}

			//手机号,模糊匹配
			if (StringUtils.isNotBlank(teleporterAdminQueryCondition.getPhone())) {
				criteria.add(Restrictions.ilike("tel", teleporterAdminQueryCondition.getPhone(), MatchMode.ANYWHERE));
			}

			//传送点
			if (StringUtils.isNotBlank(teleporterAdminQueryCondition.getTeleporter())) {
				criteria = criteria.createAlias("teleporter", "t");
				criteria.add(Restrictions.eq("t.id", Integer.parseInt(teleporterAdminQueryCondition.getTeleporter())));

			}

			//注册日期
			if (null != teleporterAdminQueryCondition.getDate()) {
				criteria.add(Restrictions.between("registerDate",teleporterAdminQueryCondition.getDate(), DateUtil.getNextDay(teleporterAdminQueryCondition.getDate())));
			}
		}

		//排序
		criteria.addOrder(Order.asc("userId"));
		return (List<TeleporterAdmin>)criteria.list();
	}

	@Override
	public Long getTeleporterAdminCountByCondition(TeleporterAdminQueryCondition teleporterAdminQueryCondition) {
		Criteria criteria = this.getSessionFactory().getCurrentSession().createCriteria(TeleporterAdmin.class);
		criteria.setProjection(Projections.rowCount());
		if (null != teleporterAdminQueryCondition) {
			//编号
			if (StringUtils.isNotBlank(teleporterAdminQueryCondition.getIds())) {
				criteria.add(Restrictions.in("teleporterAdminId", teleporterAdminQueryCondition.getIds().split(",")));
			}

			//手机号,模糊匹配
			if (StringUtils.isNotBlank(teleporterAdminQueryCondition.getPhone())) {
				criteria.add(Restrictions.ilike("tel", teleporterAdminQueryCondition.getPhone(), MatchMode.ANYWHERE));
			}

			//传送点
			if (StringUtils.isNotBlank(teleporterAdminQueryCondition.getTeleporter())) {
				criteria = criteria.createAlias("teleporter", "t");
				criteria.add(Restrictions.eq("t.id", Integer.parseInt(teleporterAdminQueryCondition.getTeleporter())));

			}



			//注册日期
			if (null != teleporterAdminQueryCondition.getDate()) {
				criteria.add(Restrictions.between("registerDate",teleporterAdminQueryCondition.getDate(), DateUtil.getNextDay(teleporterAdminQueryCondition.getDate())));
			}
		}

		//排序
		criteria.addOrder(Order.asc("teleporterAdminId"));
		return (Long) criteria.uniqueResult();
	}


}
