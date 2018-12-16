package top.yigege.web.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletResponseAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;

import top.yigege.domain.Teleporter;
import top.yigege.json.result.ForTeleporter;
import top.yigege.service.TeleporterService;

/**
 * 
 * @ClassName:  TeleporterAction   
 * @Description:传送点action
 * @author: yigege
 * @date:   2018年12月16日 下午12:34:58
 */
public class TeleporterAction extends BaseAction implements ModelDriven<Teleporter>,ServletResponseAware{
	
	
	private TeleporterService teleporterService;
	public void setTeleporterService(TeleporterService teleporterService) {
		this.teleporterService = teleporterService;
	}

	//模型驱动封装传送点信息
	private Teleporter teleporter = new Teleporter();
	public Teleporter getTeleporter() {
		return teleporter;
	}
	public void setTeleporter(Teleporter teleporter) {
		this.teleporter = teleporter;
	}

	@Override
	public Teleporter getModel() {
		// TODO Auto-generated method stub
		return this.teleporter;
	}
	
	
	//采用IOC注入servletApi
	private HttpServletResponse response;
	@Override
	public void setServletResponse(HttpServletResponse response) {
		// TODO Auto-generated method stub
		this.response = response;
	}
	
	/**
	 * 添加传送点
	 */
	public String addTeleporter() {
		//1.检查超级管理员是否登入
		int state;
		 ActionContext actionContext = ActionContext.getContext();  
	     Map session = actionContext.getSession(); 
	     if(!session.containsKey("superuser")) {
	    	 this.getJsonData().put("state", -1);
	    	 return "jsonData";
	     }
	     
	     //2.添加传送点业务处理
	     Date date = new Date();
	     teleporter.setCreateDate(date);
	     state = teleporterService.addTeleporter(teleporter);
	     this.getJsonData().put("state", state);
		return "jsonData";
	}
	
	
	
	/**
	 * 删除传送点
	 */
	public String deleteTeleporter() {
		//1.检查超级管理员是否登入
		int state;
		 ActionContext actionContext = ActionContext.getContext();  
	     Map session = actionContext.getSession(); 
	     if(!session.containsKey("superuser")) {
	    	 this.getJsonData().put("state", -1);
	    	 return "jsonData";
	     }
	     
	     //2.删除传送点业务处理
	     state = teleporterService.deleteTeleporterById(this.teleporter.getTeleporterId());
	     this.getJsonData().put("state",state);
	     
	     return "jsonData";
	}
	
	
	
	/**
	 * 查询所有传送点
	 */
	public String queryAll() {
		//1.检查超级管理员是否登入
		int state;
		 ActionContext actionContext = ActionContext.getContext();  
	     Map session = actionContext.getSession(); 
	     if(!session.containsKey("superuser")) {
	    	 this.getJsonData().put("state", -1);
	    	 return "jsonData";
	     }
	     
	     //2.查询所有传送点业务处理
	     List<Teleporter> teleporterLists = teleporterService.queryAll();
	     if(teleporterLists != null) {
	    	 this.getJsonData().put("total", teleporterLists.size());
	    	 this.getJsonData().put("rows", teleporterLists);
	     }else {
	    	 this.getJsonData().put("state", 0);
	     }
	     return "jsonData";
	}
	
	
	/**
	 * 得到传送点下拉框所对应的JSON数据
	 */
	public String getJSONforSelect() {
		//1.检查超级管理员是否登入
		int state;
		 ActionContext actionContext = ActionContext.getContext();  
	     Map session = actionContext.getSession(); 
	     if(!session.containsKey("superuser")) {
	    	 this.getJsonData().put("state", -1);
	    	 return "jsonData";
	     }
	     
	     //2.查询所有传送点业务处理
	     List<Teleporter> teleporterLists = teleporterService.queryAll();
	     if(teleporterLists != null) {
	    	 List<ForTeleporter> optionLists = new ArrayList();
	    	 //只需要传送点id,和地址
	    	 StringBuilder sb = new StringBuilder();
	    	 sb.append("[");
	    	 for(int i = 0 ; i < teleporterLists.size(); i ++) {
	    		 Teleporter teleporter =  teleporterLists.get(i);
	    		 String temp = "{\"value\":"+teleporter.getTeleporterId()+",\"address\":\""+teleporter.getAddress()+"\"},";
	    		 sb.append(temp);
	    	 }
	    	 sb.append("]");
	    	 sb.setCharAt(sb.length()-2, ' ');
	    	
	    	 response.setCharacterEncoding("UTF-8");
	    	 response.setContentType("text/html;charset=utf-8");
	    	 try {
				response.getWriter().println(sb.toString());
				response.getWriter().close();
				return null;
			} catch (IOException e) {
				
				e.printStackTrace();
			}
	    	 
	  
	     }else {
	    	 this.getJsonData().put("state", 0);
	     }
	     return "jsonData";
	  
	}
	
}
