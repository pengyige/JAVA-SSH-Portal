package top.yigege.web.action;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.aspectj.weaver.patterns.ThisOrTargetAnnotationPointcut;

import com.opensymphony.xwork2.ActionSupport;

import top.yigege.vo.ReturnDTO;

/**
 * 
 * @ClassName:  BaseAction   
 * @Description:公共action
 * @author: yigege
 * @date:   2018年12月16日 上午11:49:25
 */
public class BaseAction extends ActionSupport  implements ServletRequestAware{
	
	/**日志对象*/
	protected Logger logger = Logger.getLogger(this.getClass());
	
	/**返回json对象*/
	private Map jsonData = new HashMap<String,Object>();
	
	/**返回的Json对象*/
	protected ReturnDTO returnDTO = new ReturnDTO();
	
	/**request对象*/
	private HttpServletRequest request;
	
	/**返回json数据*/
	public static final String JSON_DATA = "jsonData";
	
	public Map getJsonData() {
		return jsonData;
	}
	public void setJsonData(Map jsonData) {
		this.jsonData = jsonData;
	}
	public Logger getLogger() {
		return logger;
	}
	public void setLogger(Logger logger) {
		this.logger = logger;
	}
	public ReturnDTO getReturnDTO() {
		return returnDTO;
	}
	public void setReturnDTO(ReturnDTO returnDTO) {
		this.returnDTO = returnDTO;
	}
	@Override
	public void setServletRequest(HttpServletRequest request) {
		
		this.request = request;
		
	}
	
	
}
