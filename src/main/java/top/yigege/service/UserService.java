package top.yigege.service;

import top.yigege.dao.UserDao;
import top.yigege.domain.User;
import top.yigege.exception.RegisterException;

public class UserService {
	private UserDao userDao;
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	/**
	 * 注册用户
	 * @param user
	 * @return
	 */
	public int registerUser(User user){
		int state = 1;
		try {
			userDao.save(user);
		}catch(Exception e) {
			state = 0;
		}
		return state;
	}
		
	/**
	 * 查询用户通过userId
	 * @param userId
	 * @return
	 */
	public User findUserById(String userId) {
		return userDao.find(userId);
	}
	
	/**
	 * 更新用户
	 * @param user
	 * @return
	 */
	public int updateUserService(User user) {
		int iFlag = 1;
		//1.插入数据
		try{
			userDao.update(user);
		}catch(Exception e) {
			iFlag = 0;
		}
		
		return iFlag;
	}
	
	
	/**
	 * 验证token 1表示存在,-1表示不存在
	 * @param token
	 * @return
	 */
	public int validateToken(String token) {
		
		return userDao.findToken(token);
		
	}

	
	/**
	 * 用户登入
	 * @param user
	 * @return
	 */
	public User loginUserByPassword(User user) {

		return userDao.findUserByPass(user);
	}
	
	/**
	 * 用户手机号是否注册
	 */
	public boolean telIsRegister(String tel) {
		return userDao.telIsExist(tel);
	}

	/**
	 * 更新用户token
	 * @param userId
	 * @param token
	 * @return
	 */
	public int updateUserToken(String userId, String token) {
		int state = 1;
		try {
			userDao.updateToken(userId,token);
		}catch(Exception e){
			state = 0;
		}
		return state;
	}

	/**
	 * 查询用户是否已注册
	 * @param username
	 * @return
	 */
	public int nameIsExist(String username) {
		int resultState ;
		try {
		if(userDao.nameIsExist(username)) {
			resultState = 1;
		}else {
			resultState = -1;
		}
		}catch(Exception e) {
			resultState = 0;
			return resultState;
		}	
		return resultState;
	}

	
	/**
	 * 清空用户token
	 * @param token
	 * @return
	 */
	public int clearUserToken(String token) {
		int resultState = 1;
		try {
			userDao.clearToken(token);
		}catch(Exception e) {
			resultState = 0;
			return resultState;
		}
		return resultState;
	}

	public User findUserByTel(String tel) {
		
		return userDao.findUserByTel(tel);
	}
	
	
	
}
