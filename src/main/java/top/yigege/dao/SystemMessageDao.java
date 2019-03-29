package top.yigege.dao;

import top.yigege.domain.SystemMessage;
import top.yigege.vo.SystemMessageQueryCondition;

import java.util.List;

/**
 * 
 * @ClassName:  SystemMessageDao   
 * @Description:系统消息dao
 * @author: yigege
 * @date:   2018年12月31日 下午7:32:08
 */
public interface SystemMessageDao extends BaseDao<SystemMessage>{

    /**
     * 分页查询
     * @param page
     * @param rows
     * @param systemMessageQueryCondition
     * @return
     */
    List<SystemMessage> pageListByCondition(int page, int rows, SystemMessageQueryCondition systemMessageQueryCondition);

    /**
     * 分页查询总数
     * @param systemMessageQueryCondition
     * @return
     */
    Long getTeleporterAdminCountByCondition(SystemMessageQueryCondition systemMessageQueryCondition);
}
