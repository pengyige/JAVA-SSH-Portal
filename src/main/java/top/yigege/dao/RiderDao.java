package top.yigege.dao;

import java.util.List;

import top.yigege.domain.Rider;

public interface RiderDao extends BaseDao<Rider>{

	boolean telIsExist(String tel);

	Rider findRiderByTel(String tel);

	void updateToken(String riderId, String token);

	void checkIn(String teleporterId, String riderId);

	int findToken(String token);

	void logoutChecin(String riderId);

	List<Rider> findRidersByTeleproter(String teleporterId);

}
