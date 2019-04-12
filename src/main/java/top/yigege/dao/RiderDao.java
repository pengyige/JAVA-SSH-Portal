package top.yigege.dao;

import java.util.List;

import top.yigege.domain.Rider;
import top.yigege.vo.RiderQueryCondition;
import top.yigege.vo.TypeVO;

/**
 * 
 * @ClassName:  RiderDao   
 * @Description:骑手Dao接口
 * @author: yigege
 * @date:   2018年12月16日 上午10:33:03
 */
public interface RiderDao extends BaseDao<Rider>{

	/**
	 * 电话号码是否存在
	 * @param tel
	 * @return 存在:true;不存在:false
	 */
	boolean telIsExist(String tel);

	/**
	 * 通过电话号码查找骑手
	 * @param tel	电话号码
	 * @return
	 */
	Rider findRiderByTel(String tel);

	/**
	 * 更新骑手token
	 * @param riderId
	 * @param token
	 */
	void updateToken(String riderId, String token);

	/**
	 * 注册骑手
	 * @param teleporterId
	 * @param riderId
	 */
	void checkIn(String teleporterId, String riderId);

	/**
	 * 查询token
	 * @param token
	 * @return
	 */
	int findToken(String token);

	/**
	 * 注销骑手
	 * @param riderId
	 */
	void logoutChecin(String riderId);

	/**
	 * 通过传送点id查询所有骑手
	 * @param teleporterId
	 * @return
	 */
	List<Rider> findRidersByTeleproter(Integer teleporterId);

    List<Rider> pageLicstByCondition(int page, int rows, RiderQueryCondition riderQueryCondition);

	Long getCountByCondition(RiderQueryCondition riderQueryCondition);

    TypeVO[] getRiderRegisterCountByTime();
}
