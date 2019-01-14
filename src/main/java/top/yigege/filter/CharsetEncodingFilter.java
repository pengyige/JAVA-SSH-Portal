package top.yigege.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;


/**
 * 
 * @ClassName:  CharsetEncodingFilter   
 * @Description:编码过滤器
 * @author: yigege
 * @date:   2019年1月14日 下午10:03:19
 */
public class CharsetEncodingFilter implements Filter{
	
	/**编码*/
	private static String encoding; 
	 
	public void destroy() {
		
	}
 
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// 设置字符编码链锁
		request.setCharacterEncoding(encoding);
		response.setCharacterEncoding(encoding);
		chain.doFilter(request, response);
		
	}
	
	/**
	 * 初始化
	 * @param config
	 * @throws ServletException
	 */
	public void init(FilterConfig config) throws ServletException {
		// 接收web.xml配置文件中的初始参数
		encoding = config.getInitParameter("CharsetEncoding");
		
	}

}
