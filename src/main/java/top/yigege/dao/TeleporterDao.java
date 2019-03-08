package top.yigege.dao;

import java.util.List;

import top.yigege.domain.Teleporter;
import top.yigege.vo.TeleporterQueryCondition;

/**
 * 
 * @ClassName:  TeleporterDao   
 * @Description:传送点Dao
 * @author: yigege
 * @date:   2018年12月16日 上午11:05:33
 */
public interface TeleporterDao extends BaseDao<Teleporter>{

	
	List<Teleporter> pageListByCondition(int page, int rows, TeleporterQueryCondition teleporterQueryCondition);

	Long getTeleporterCountByCondition(TeleporterQueryCondition teleporterQueryCondition);

	
	
}
