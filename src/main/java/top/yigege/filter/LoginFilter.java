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
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest httpRequest, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		HttpServletRequest httpServletRequest = (HttpServletRequest) httpRequest;
		//1. 得到请求的uri
		String uri = httpServletRequest.getRequestURI();
		//2. 得到后缀/与?之间
		String uriPath = HttpUriUtil.getUriPath(uri);
		//3. 得到后缀
		String suffix = uriPath.substring(uriPath.lastIndexOf('.'));
		logger.info("请求的路径为:"+uri);
		//如果不在资源内并且不在排除的排除的uri,判断session是否有效
		if (!resourceList.contains(suffix) && !excludedUri.contains(uriPath)) {
			Object user = httpServletRequest.getAttribute(PortalSessionKey.USER_SESSION_KEY);
			if (null == user) {
				logger.info("您还没有登入");
			}
		}else {
			//获取请求ip
			String requestIp = HttpUriUtil.getRemoteHost(httpServletRequest);
			logger.info("请求接口ip="+requestIp);
		}
		
		
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
		
		//2. 初始排除的url
		excludedUri = new ArrayList<String>();
		
	}

}
