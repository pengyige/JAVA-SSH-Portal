package top.yigege.web.action;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.monitor.FileAlterationListener;
import org.apache.log4j.Logger;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.aspectj.weaver.patterns.ThisOrTargetAnnotationPointcut;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ResolverUtil.NameEndsWith;

import top.yigege.vo.BootstrapTableDTO;
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
	
	/**bootstrap返回对象*/
	protected BootstrapTableDTO bootstrapTableDTO = new BootstrapTableDTO();
	
	/**request对象*/
	protected HttpServletRequest request;
	
	/**返回json数据*/
	public static final String JSON_DATA = "jsonData";
	
	/**返回bootstrap-table数据*/
	public static final String BOOTSTRAP_TABLE_JSON_DATA = "bootstrapTableData";
	
	/**bootstrap-table 当前页*/
	public int page;
	
	/**bootstrap-table 分页大小*/
	public int rows;
	
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
	public BootstrapTableDTO getBootstrapTableDTO() {
		return bootstrapTableDTO;
	}
	public void setBootstrapTableDTO(BootstrapTableDTO bootstrapTableDTO) {
		this.bootstrapTableDTO = bootstrapTableDTO;
	}
	public HttpServletRequest getRequest() {
		return request;
	}
	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getRows() {
		return rows;
	}
	public void setRows(int rows) {
		this.rows = rows;
	}
	
	
	
	
}
