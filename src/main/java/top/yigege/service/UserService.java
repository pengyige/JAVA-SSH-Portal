package top.yigege.service;

import org.apache.commons.lang.StringUtils;
import top.yigege.constants.Constants;
import top.yigege.dao.UserDao;
import top.yigege.domain.User;
import top.yigege.exception.RegisterException;
import top.yigege.util.ValidatorUtil;
import top.yigege.vo.OrderQueryCondition;
import top.yigege.vo.TypeVO;
import top.yigege.vo.UserQueryCondition;

import java.sql.Date;
import java.util.List;
import java.util.UUID;

/**
 * 
 * @ClassName:  UserService   
 * @Description:用户服务类
 * @author: yigege
 * @date:   2018年12月16日 上午11:45:58
 */
public class UserService {
	
	/**用户Dao*/
	private UserDao userDao;
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	/**
	 * 注册用户
	 * @param user
	 * @return
	 */
	public void doRegisterUser(User user){


		//生成token
		user.setToken(UUID.randomUUID()+"_"+System.currentTimeMillis());
		//初始余额5
		user.setBalance(5.0d);
		user.setCreateTime(new java.util.Date());
		userDao.save(user);


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
	 * @throws Exception 
	 */
	public int updateUserService(User user){
		int iFlag = Constants.YesOrNo.YES;
		//1.插入数据
		try{
			userDao.update(user);
		}catch(Exception e) {
			iFlag =  Constants.YesOrNo.NO;
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
		int resultState = Constants.YesOrNo.YES;
		try {
		if(userDao.nameIsExist(username)) {
			resultState = Constants.YesOrNo.YES;
		}else {
			resultState = Constants.YesOrNo.NO;
		}
		}catch(Exception e) {
			resultState = Constants.YesOrNo.ERROR;
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
		int resultState = Constants.ValidOrInvalid.VALID;
		try {
			userDao.clearToken(token);
		}catch(Exception e) {
			resultState = Constants.YesOrNo.ERROR;
			return resultState;
		}
		return resultState;
	}

	public User findUserByTel(String tel) {
		
		return userDao.findUserByTel(tel);
	}

	/**
	 * 分页查询所有用户
	 * @param page
	 * @param rows
	 * @param userQueryCondition
	 * @return
	 */
	public List<User> pageListByCondition(int page, int rows, UserQueryCondition userQueryCondition) {
		return userDao.pageListByCondition(page,rows,userQueryCondition);
	}

	/**
	 * 分页查询所有用户总数
	 * @param userQueryCondition
	 * @return
	 */
	public Long getTeleporterAdminCountByCondition(UserQueryCondition userQueryCondition) {
		return userDao.getTeleporterAdminCountByCondition(userQueryCondition);
	}

	/**
	 * 获取总数
	 * @return
	 */
	public Long[] getTotalCount() {
		return userDao.getPortalCount();
	}

	/**
	 * 获取用户注册数量
	 * @return
	 */
    public TypeVO[] queryUserRegisterCountByTime() {
    	return userDao.getUserRegisterCountByTime();
    }

	/**
	 * 校验用户信息
	 * @param user
	 */
	public void validateUserInfo(User user) throws Exception {
		if (StringUtils.isBlank(user.getTel())) {
			throw  new Exception("手机号不能为空");
		}else {
			if (!ValidatorUtil.isMobile(user.getTel())) {
				throw  new Exception("手机号非法");
			}

			if (null != findUserByTel(user.getTel())) {
				throw  new Exception("手机号已被注册");
			}
		}

		if (StringUtils.isBlank(user.getUsername())) {
			throw  new Exception("用户名不能为空");
		}

		if (StringUtils.isBlank(user.getPassword())) {
			throw new Exception("密码不能为空");
		}else {
			if (!ValidatorUtil.isPassword(user.getPassword())) {
				throw new Exception("密码非法");
			}
		}


    }
}
