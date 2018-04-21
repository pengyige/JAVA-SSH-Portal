package top.yigege.web.action;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;

import top.yigege.domain.Teleporter;
import top.yigege.service.TeleporterService;

public class TeleporterAction extends BaseAction implements ModelDriven<Teleporter>{
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
	    	 this.getJsonData().put("state", 1);
	    	 this.getJsonData().put("result", teleporterLists);
	     }else {
	    	 this.getJsonData().put("state", 0);
	     }
	     return "jsonData";
	}
}
