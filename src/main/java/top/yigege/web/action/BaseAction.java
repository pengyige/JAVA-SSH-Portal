package top.yigege.web.action;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.aspectj.weaver.patterns.ThisOrTargetAnnotationPointcut;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 
 * @ClassName:  BaseAction   
 * @Description:公共action
 * @author: yigege
 * @date:   2018年12月16日 上午11:49:25
 */
public class BaseAction extends ActionSupport{
	
	/**日志对象*/
	protected Logger logger = Logger.getLogger(this.getClass());
	
	/**返回json对象*/
	private Map jsonData = new HashMap<String,Object>();
	public Map getJsonData() {
		return jsonData;
	}
	public void setJsonData(Map jsonData) {
		this.jsonData = jsonData;
	}
}
