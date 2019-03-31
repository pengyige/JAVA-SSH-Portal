package top.yigege.dao;

import top.yigege.domain.User;
import top.yigege.vo.TypeVO;
import top.yigege.vo.UserQueryCondition;

import java.util.List;

/**
 * 
 * @ClassName:  UserDao   
 * @Description:用户Dao
 * @author: yigege
 * @date:   2018年12月16日 上午11:05:51
 */
public interface UserDao extends BaseDao<User>{
	
	/**
	 * 姓名是否存在
	 * @param username
	 * @return
	 */
	public boolean nameIsExist(String username);

	/**
	 * 手机号是否存在
	 * @param tel
	 * @return
	 */
	public boolean telIsExist(String tel);
	
	/**
	 * 查找token
	 * @param token
	 * @return 存在:1;不存在:-1
	 */
	public int findToken(String token);

	/**
	 * 通过账号和密码查询用户
	 * @param user
	 * @return 不存在:null
	 */
	public User findUserByPass(User user);

	/**
	 * 更新用户token
	 * @param userId
	 * @param token
	 */
	public void updateToken(String userId, String token);

	/**
	 * 清除token
	 * @param token
	 */
	public void clearToken(String token);

	/**
	 * 通过手机号查询用户
	 * @param tel
	 * @return
	 */
	public User findUserByTel(String tel);


	/**
	 * 分页查询所有用户
	 * @param page
	 * @param rows
	 * @param userQueryCondition
	 * @return
	 */
    List<User> pageListByCondition(int page, int rows, UserQueryCondition userQueryCondition);

	/**
	 * 分页查询所有用户数量
	 * @param userQueryCondition
	 * @return
	 */
	Long getTeleporterAdminCountByCondition(UserQueryCondition userQueryCondition);

    /**
     * 查询所有数量
     * @return
     */
    Long[] getPortalCount();

	/**
	 * 获取用户注册数量
	 * @return
	 */
	TypeVO[] getUserRegisterCountByTime();
}
