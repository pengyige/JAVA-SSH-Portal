package top.yigege.web.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.springframework.http.server.ServerHttpRequest;

import com.opensymphony.xwork2.ModelDriven;

import top.yigege.domain.SuperAdmin;
import top.yigege.domain.UserOrder;
import top.yigege.service.SuperAdminService;
import top.yigege.util.MD5Util;

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
		//1.检验输入参数
		if(StringUtils.isBlank(superAdmin.getUsername())) {
			request.setAttribute("error", "用户名不能为空");
			return "loginError";
		}
		
		if(StringUtils.isBlank(superAdmin.getPassword())) {
			request.setAttribute("error", "密码不能为空");
			return "loginError";
		}
		
		//2.查询超级管理员
		logger.info("username:"+superAdmin.getUsername()+";password:+"+superAdmin.getPassword());
		SuperAdmin superAdmin = superAdminService.verifySuperAdmin(this.superAdmin.getUsername(), MD5Util.MD5(this.superAdmin.getPassword()));
		if(null == superAdmin) {
			request.setAttribute("error", "用户名或密码不正确");
			return "loginError";
		}else {
			request.getSession().setAttribute("superAdmin", superAdmin);
			return "loginSuccess";
		}
	}

	
}
