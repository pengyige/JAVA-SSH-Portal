package top.yigege.dao.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import top.yigege.dao.SystemMessageDao;
import top.yigege.domain.SystemMessage;
import top.yigege.util.DateUtil;
import top.yigege.util.TypeConvertUtil;
import top.yigege.vo.SystemMessageQueryCondition;

public class SystemMessageDaoImpl extends BaseDaoImpl<SystemMessage> implements SystemMessageDao{


    @Override
    public List<SystemMessage> pageListByCondition(int page, int rows, SystemMessageQueryCondition systemMessageQueryCondition) {
        Criteria criteria = this.getSessionFactory().getCurrentSession().createCriteria(SystemMessage.class);
        criteria.setFirstResult((page-1)*rows);
        criteria.setMaxResults(rows);


        if (null != systemMessageQueryCondition) {
            //编号
            if (StringUtils.isNotBlank(systemMessageQueryCondition.getIds())) {
                criteria.add(Restrictions.in("messageId", TypeConvertUtil.StringToInt(systemMessageQueryCondition.getIds().split(","))));
            }

            //标题
            if (StringUtils.isNotBlank(systemMessageQueryCondition.getTitle())) {
                criteria.add(Restrictions.ilike("title", systemMessageQueryCondition.getTitle(), MatchMode.ANYWHERE));
            }

            //内容
            if (StringUtils.isNotBlank(systemMessageQueryCondition.getContent())) {
                criteria.add(Restrictions.ilike("content",systemMessageQueryCondition.getContent(),MatchMode.ANYWHERE));
            }

            //类型
            if (0 != systemMessageQueryCondition.getType()) {
                criteria.add(Restrictions.eq("type",systemMessageQueryCondition.getType()));
            }

            //创建日期
            if (null != systemMessageQueryCondition.getDate()) {
                criteria.add(Restrictions.between("createDate",systemMessageQueryCondition.getDate(), DateUtil.getNextDay(systemMessageQueryCondition.getDate())));
            }
        }

        //排序
        criteria.addOrder(Order.desc("messageId"));
        return (List<SystemMessage>)criteria.list();
    }

    @Override
    public Long getTeleporterAdminCountByCondition(SystemMessageQueryCondition systemMessageQueryCondition) {
        Criteria criteria = this.getSessionFactory().getCurrentSession().createCriteria(SystemMessage.class);
        criteria.setProjection(Projections.rowCount());
        if (null != systemMessageQueryCondition) {
            //编号
            if (StringUtils.isNotBlank(systemMessageQueryCondition.getIds())) {
                criteria.add(Restrictions.in("messageId", TypeConvertUtil.StringToInt(systemMessageQueryCondition.getIds().split(","))));
            }

            //标题
            if (StringUtils.isNotBlank(systemMessageQueryCondition.getTitle())) {
                criteria.add(Restrictions.ilike("title", systemMessageQueryCondition.getTitle(), MatchMode.ANYWHERE));
            }

            //内容
            if (StringUtils.isNotBlank(systemMessageQueryCondition.getContent())) {
                criteria.add(Restrictions.ilike("content",systemMessageQueryCondition.getContent(),MatchMode.ANYWHERE));
            }

            //类型
            if (0 != systemMessageQueryCondition.getType()) {
                criteria.add(Restrictions.eq("type",systemMessageQueryCondition.getType()));
            }

            //创建日期
            if (null != systemMessageQueryCondition.getDate()) {
                criteria.add(Restrictions.between("createDate",systemMessageQueryCondition.getDate(), DateUtil.getNextDay(systemMessageQueryCondition.getDate())));
            }
        }

        //排序
        criteria.addOrder(Order.desc("messageId"));
        return (Long) criteria.uniqueResult();
    }
}
