package top.yigege.web.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.opensymphony.xwork2.ActionContext;

import org.apache.commons.lang.StringUtils;
import top.yigege.constants.Constants;
import top.yigege.domain.User;
import top.yigege.domain.UserOrder;
import top.yigege.enums.HttpCodeEnum;
import top.yigege.service.UserService;
import top.yigege.util.MD5Util;
import top.yigege.util.ReturnDTOUtil;
import top.yigege.util.ValidatorUtil;
import top.yigege.vo.PageVo;
import top.yigege.vo.TypeVO;
import top.yigege.vo.UserQueryCondition;

import static top.yigege.constants.Constants.UserType.BUSINESS;
import static top.yigege.constants.Constants.UserType.NORMAL;

/**
 * 
 * @ClassName:  UserAction   
 * @Description:用户action
 * @author: yigege
 * @date:   2018年12月16日 下午12:38:35
 */
public class UserAction extends BaseAction{
	private UserService userService;
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	
	/**值对象*/
	private User user = new User();
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}

	/**查询条件*/
	private UserQueryCondition userQueryCondition;
	public UserQueryCondition getUserQueryCondition() {
		return userQueryCondition;
	}
	public void setUserQueryCondition(UserQueryCondition userQueryCondition) {
		this.userQueryCondition = userQueryCondition;
	}

	/**
	 * 修改用户
	 * @return
	 */
	public String updateUser() {
		return  JSON_DATA;
	}
	
	
	
	/**
	 * 通过手机号注册
	 * @return
	 */
	public String register() {
		logger.info("开始注册用户");
		try {
			userService.validateUserInfo(user);

			userService.registerUser(user);
		}catch (Exception e) {
			e.printStackTrace();
			logger.info("注册失败,失败原因:"+e.getMessage());
			returnDTO = ReturnDTOUtil.fail(e.getMessage());
		}
		return  JSON_DATA;
	}
	
	
	/**
	 * 用户密码登入
	 */
	public String login() {
		logger.info("用户开始登入");

		//1.校验参数合法性
		if (StringUtils.isBlank(user.getTel())) {
			returnDTO = ReturnDTOUtil.paramError("手机号不能为空");
			return JSON_DATA;
		}else {
			if (!ValidatorUtil.isMobile(user.getTel())) {
				returnDTO = ReturnDTOUtil.paramError(user.getTel()+"非法");
				return JSON_DATA;
			}
		}

		if (StringUtils.isBlank(user.getPassword())) {
			returnDTO = ReturnDTOUtil.paramError("密码不能为空");
			return JSON_DATA;
		}

		//2.检查手机号是否被注册
		if(!userService.telIsRegister(user.getTel())) {
			returnDTO = ReturnDTOUtil.fail(user.getTel()+"已经被注册");
			return JSON_DATA;
		}
		
		//检查手机号和密码是否匹配
		User resultUser = userService.loginUserByPassword(user);
		if(resultUser != null) {
		
			//设置相应的token
			long currentTime  = System.currentTimeMillis();
			String token = resultUser.getUserId()+"_"+currentTime;
			userService.updateUserToken(resultUser.getUserId(), token);
			resultUser.setToken(token);
			
			returnDTO = ReturnDTOUtil.success(resultUser);
		
		}else {
			returnDTO = ReturnDTOUtil.fail("手机号或密码不正确");
		}
			
		return  JSON_DATA;
	}
	
	/**
	 * 用户手机登入
	 */
	public String loginByTel() {
		//1.校验参数合法性
		if (StringUtils.isBlank(user.getTel())) {
			returnDTO = ReturnDTOUtil.paramError("手机号不能为空");
			return JSON_DATA;
		}else {
			if (!ValidatorUtil.isMobile(user.getTel())) {
				returnDTO = ReturnDTOUtil.paramError(user.getTel()+"非法");
				return JSON_DATA;
			}
		}

		//2.这里还是需要验证码，写死1234
		String code = request.getParameter("code");
		if (StringUtils.isBlank(code)) {
			returnDTO = ReturnDTOUtil.paramError("验证码不能为空");
			return JSON_DATA;
		}else {
			if (!code.equals("1234")) {
				returnDTO = ReturnDTOUtil.fail("验证不正确");
			}
		}

		User returnUser = userService.findUserByTel(user.getTel());
		if(user != null) {
			//设置相应的token
			long currentTime  = System.currentTimeMillis();
			String token = user.getUserId()+"_"+currentTime;
			userService.updateUserToken(user.getUserId(), token);
			user.setToken(token);
			
			returnDTO = ReturnDTOUtil.success(returnUser);
		}else {
			returnDTO = ReturnDTOUtil.fail("手机号不正确");
		}
		return JSON_DATA;
	}
	
	
	
	/**
	 * 用户名是否存在
	 */
	public String nameIsExist() {
		if (StringUtils.isBlank(user.getUsername())) {
			returnDTO = ReturnDTOUtil.paramError("用户名不能为空");
			return  JSON_DATA;
		}

		int state = userService.nameIsExist(user.getUsername());
		returnDTO = ReturnDTOUtil.success(state);
		
		return JSON_DATA;
	}
	
	/**
	 * 注销用户
	 */
	public String logout() {
		if (StringUtils.isBlank(user.getToken())) {
			returnDTO = ReturnDTOUtil.paramError("token不能为空");
			return  JSON_DATA;
		}

		int state = userService.clearUserToken(user.getToken());
		returnDTO = ReturnDTOUtil.success(state);
		return JSON_DATA;
	}
	
	
	/**
	 * 手机号是否已注册
	 */
	public String telIsExist() {
		User returnUser = userService.findUserByTel(user.getTel());
		if(returnUser != null) {
			returnDTO = ReturnDTOUtil.success(Constants.YesOrNo.YES);
		}
		else {
			returnDTO = ReturnDTOUtil.success(Constants.YesOrNo.NO);
		}
		return JSON_DATA;
	}

	/**
	 * 跳转到用户管理页面
	 * @return
	 */
	public String intoUserManagerPage() {
		return "intoUserManagerPage";
	}

	/**
	 * 分页查询所有用户
	 * @return
	 */
	public String queryAllByPage() {
		logger.info("分页查询所有用户");

		try {
			List<User> users = userService.pageListByCondition(page,rows,userQueryCondition);

			Long count = userService.getTeleporterAdminCountByCondition(userQueryCondition);
			if(users != null) {
				bootstrapTableDTO.setCode(HttpCodeEnum.OK.getCode());
				bootstrapTableDTO.setTotal(count.intValue());
				bootstrapTableDTO.setRows(users);
			}else {
				bootstrapTableDTO.setCode(HttpCodeEnum.FAIL.getCode());
				bootstrapTableDTO.setMessage(HttpCodeEnum.INVALID_REQUEST.getMessage());
			}
		}catch (Exception e) {
			e.printStackTrace();
			bootstrapTableDTO.setCode(HttpCodeEnum.FAIL.getCode());
			bootstrapTableDTO.setMessage(e.getMessage());
		}


		return BOOTSTRAP_TABLE_JSON_DATA;
	}

	/**
	 * 返回所有用户类型
	 * @return
	 */
	public String queryAllUserType() {
		logger.info("获取所有用户消息");
		TypeVO[] typeVO = new TypeVO[2];


		typeVO[0] = new TypeVO(NORMAL,Constants.UserType.getName(NORMAL));

		typeVO[1] = new TypeVO(BUSINESS,Constants.UserType.getName(BUSINESS));

		returnDTO = ReturnDTOUtil.success(typeVO);
		return JSON_DATA;
	}


	/**
	 * 查询总数
	 * @return
	 */
	public String queryTotalCount() {
		logger.info("开始查询总数");
		try {
			returnDTO = ReturnDTOUtil.success(userService.getTotalCount());
		}catch (Exception e) {
			e.printStackTrace();;
			returnDTO = ReturnDTOUtil.fail(e.getMessage());
	}
		return JSON_DATA;
	}


	/**
	 * 查询最近一周用户注册数量
	 * @return
	 */
	public String queryRecentUserRegisterCount() {
		logger.info("查询最近一周用户注册数量");

		try {
			TypeVO[] typeVOS =  userService.queryUserRegisterCountByTime();
			returnDTO = ReturnDTOUtil.success(typeVOS);
		}catch (Exception e) {
			e.printStackTrace();
			logger.info("查询用户注册数量失败，失败原因:"+e.getMessage());
			returnDTO = ReturnDTOUtil.fail(e.getMessage());
		}

		return JSON_DATA;

	}

	/**
	 * json测试
	 * @return
	 */
	public String testJsonData() {
		PageVo pageVo = new PageVo();
		List<User> users = new ArrayList<User>();
		User user = new User();
		user.setAddress("test");
		
		//创建用户订单
		UserOrder userOrder = new UserOrder();
		userOrder.setShipAddress("test");
		Set<UserOrder> userOrders = new HashSet<UserOrder>();
		userOrders.add(userOrder);
		//添加订单
		
		user.setUserOrders(userOrders);
		users.add(user);
		users.add(user);
		Map<String,Object> result = new HashMap<String, Object>();
		result.put("users", users);
		pageVo.setResults(result);
		this.returnDTO = ReturnDTOUtil.success(pageVo);
		
		return JSON_DATA;
	}
	
}
