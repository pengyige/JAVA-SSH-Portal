package top.yigege.dao;

import top.yigege.domain.User;

public interface UserDao extends BaseDao<User>{
	
	public boolean nameIsExist(String username);

	public boolean telIsExist(String tel);
	
	public int findToken(String token);

	public User findUserByPass(User user);

	public void updateToken(String userId, String token);

	public void clearToken(String token);

	public User findUserByTel(String tel);
	
	
}
