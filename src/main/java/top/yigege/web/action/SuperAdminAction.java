package top.yigege.web.action;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.springframework.http.server.ServerHttpRequest;

import com.opensymphony.xwork2.ModelDriven;

import top.yigege.constants.Constants;
import top.yigege.domain.SuperAdmin;
import top.yigege.domain.UserOrder;
import top.yigege.service.SuperAdminService;
import top.yigege.util.MD5Util;
import top.yigege.util.ReturnDTOUtil;

/**
 * 
 * @ClassName:  SuperAdminAction   
 * @Description:超级管理员action
 * @author: yigege
 * @date:   2018年12月16日 下午5:34:00
 */
@SuppressWarnings("serial")
public class SuperAdminAction extends BaseAction implements ModelDriven<SuperAdmin>,ServletRequestAware{
	
	/**超级管理员服务对象*/
	private SuperAdminService superAdminService;
	
	public void setSuperAdminService(SuperAdminService superAdminService) {
		this.superAdminService = superAdminService;
	}

	//通过模型驱动获取参数
	private SuperAdmin superAdmin = new SuperAdmin();
	@Override
	public SuperAdmin getModel() {
		return superAdmin;
	}
	
	
	//采用IOC注入servletAPI
	private HttpServletRequest request;
	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
		
	}
	
	/**
	 * 跳转到管理首页
	 * @return
	 */
	public String index() {
		//判断用户是否登入，这里已经在拦截器中进行了判断
		return "index";
	}

	
	/**
	 * 跳转到登入页面
	 * @return
	 */
	public String toLoginPage() {
		return "toLoginPage";
	}
	
	/**
	 * 登入
	 * @return
	 */
	public String login() {
		logger.info("管理员开始登入");
		
		//1.检验输入参数
		if(StringUtils.isBlank(superAdmin.getUsername())) {
			returnDTO = ReturnDTOUtil.paramError("用户名不能为空");
			return JSON_DATA;
		}
		
		if(StringUtils.isBlank(superAdmin.getPassword())) {
			returnDTO = ReturnDTOUtil.paramError("密码不能为空");
			return JSON_DATA;
		}
		
		//2.查询超级管理员
		logger.info("username:"+superAdmin.getUsername()+";password:+"+superAdmin.getPassword());
		SuperAdmin superAdmin = superAdminService.verifySuperAdmin(this.superAdmin.getUsername(), MD5Util.MD5(this.superAdmin.getPassword()));
		if (null == superAdmin) {
			returnDTO = ReturnDTOUtil.fail("用户名或密码不正常");
			return JSON_DATA;
		}else {
			Date lastLoginTime = superAdmin.getLastLoginTime();
			//更新用户登入时间
			superAdmin.setLastLoginTime(new Date());
			superAdminService.updateSuperAdmin(superAdmin);
			//保存登入用户
			request.getSession().setAttribute(Constants.PortalSessionKey.USER_SESSION_KEY, superAdmin);
			request.getSession().setAttribute(Constants.SessionValueKey.LAST_LOGIN_TIME, lastLoginTime);
			returnDTO = ReturnDTOUtil.success();
			return JSON_DATA;
		}
	}
	
	/**
	 * 管理员注销
	 */
	public String logout() {
		HttpSession session =  request.getSession();
		if (null != session && null != session.getAttribute(Constants.PortalSessionKey.USER_SESSION_KEY)) {
			session.removeAttribute(Constants.PortalSessionKey.USER_SESSION_KEY);
		}
		return "toLoginPage";
	}
	
	/**
	 * 查询总体情况
	 * @return
	 */
	public String queryGeneralSituation() {
		
		return "toGeneralSiuation";
	}
	

	
}
