package top.yigege.util;

/**
 * 
 * @ClassName:  HttpUriUtil   
 * @Description:请求uri处理
 * @author: yigege
 * @date:   2019年1月14日 下午10:42:55
 */
public class HttpUriUtil {

	/**
	 * 获得uri中的最后一个/与最后一个?中间的部分
	 * @param uri
	 * @return
	 */
	public static String getUriPath(String uri) {
		if (uri != null&&!uri.equals("/")&&!uri.equals("")) {
			int start = uri.lastIndexOf("/");
			int end = uri.lastIndexOf("?");
			if (start == -1) {
				start = 0;
			}
			if (end == -1) {
				end = uri.length();
			}
			else{
				end=end-1;
			}
			String path = uri.substring(start, end);
			return path;
		}
		else {
			return "/";
		}
	}
	
	/**
	 * 获取远程主机ip地址
	 * @param request
	 * @return
	 */
	public static String getRemoteHost(javax.servlet.http.HttpServletRequest request){

	    String ip = request.getHeader("x-forwarded-for");

	    if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)){

	        ip = request.getHeader("Proxy-Client-IP");

	    }

	    if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)){

	        ip = request.getHeader("WL-Proxy-Client-IP");

	    }

	    if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)){

	        ip = request.getRemoteAddr();

	    }

	    return ip.equals("0:0:0:0:0:0:0:1")?"127.0.0.1":ip;

	}
}
