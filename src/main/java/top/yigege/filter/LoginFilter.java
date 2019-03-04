package top.yigege.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.monitor.FileAlterationListener;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.springframework.http.HttpRequest;

import top.yigege.constants.Constants.PortalSessionKey;
import top.yigege.util.HttpUriUtil;

/**
 * 
 * @ClassName:  LoginFilter   
 * @Description:登入过滤器
 * @author: yigege
 * @date:   2019年1月14日 下午10:32:59
 */
public class LoginFilter implements Filter{
	
	/**日志对象*/
	private Logger logger = Logger.getLogger(LoginFilter.class.getName());
	
	/**资源文件过滤列表*/
	private List<String> resourceList;
	
	/**排除的uri*/
	private List<String> excludedUri;
	
	/**管理员登入路径*/
	public static final String ADMIN_LOGIN_URL = "/portal/page/admin/login/adminLogin.jsp";
	/**超级管理员登入路径*/
	public static final String SUPER_ADMIN_LOGIN_URL = "/portal/page/super-admin/login/superAdminLogin.jsp";
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest httpRequest, ServletResponse httpResponse, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpServletRequest = (HttpServletRequest) httpRequest;
		HttpServletResponse httpServletResponse = (HttpServletResponse) httpResponse;
		//1. 得到请求的uri
		String uri = httpServletRequest.getRequestURI();
		//2. 得到后缀/与?之间
		String uriPath = HttpUriUtil.getUriPath(uri);
		//空地址请求
		if (uriPath.equals("/")) {
			httpServletResponse.sendRedirect(ADMIN_LOGIN_URL);
			return;
		}
		//3. 得到后缀
		String suffix = uriPath.substring(uriPath.lastIndexOf('.'));
		logger.info("请求的路径为:"+uri);
		//如果不在资源内并且不在排除的排除的uri,判断session是否有效
		if (!resourceList.contains(suffix) && !excludedUri.contains(uriPath)) {
			Object user = httpServletRequest.getSession().getAttribute(PortalSessionKey.USER_SESSION_KEY);
			if (null == user) {
				logger.info("还没有登入");
				//判断是传送点管理员还是系统管理员
				if (-1 == uriPath.indexOf("/teleporterAdmin") ) {
					//跳转到系统管理员登入页面
					httpServletResponse.sendRedirect(SUPER_ADMIN_LOGIN_URL);
					
				}else {
					httpServletResponse.sendRedirect(ADMIN_LOGIN_URL);
				}
				return;
				
				
			}
		}else {
			//获取请求ip
			String requestIp = HttpUriUtil.getRemoteHost(httpServletRequest);
			logger.info("请求接口ip="+requestIp);
		}
		
		chain.doFilter(httpRequest, httpResponse);
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		//1. 初始化不拦截的资源
		resourceList = new ArrayList<String>();
		resourceList.add(".js");
		resourceList.add(".css");
		resourceList.add(".gif");
		resourceList.add(".jpg");
		resourceList.add(".png");
		resourceList.add(".jpeg");
		resourceList.add(".bmp");
		resourceList.add(".svg");
		resourceList.add(".xml");
		resourceList.add(".jsp");
		resourceList.add(".html");
		resourceList.add(".htm");
		resourceList.add(".class"); 
		resourceList.add(".jar"); 
		resourceList.add(".app"); 
		resourceList.add(".map"); 
		
		//2. 初始排除的url
		excludedUri = new ArrayList<String>();
		//管理员登入
		excludedUri.add("/teleporterAdmin_login.action");
		//系统管理员登入
		excludedUri.add("/superAdmin_login.action");
	}

}
