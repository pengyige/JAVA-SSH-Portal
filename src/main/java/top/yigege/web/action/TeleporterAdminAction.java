package top.yigege.web.action;

import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;

import top.yigege.domain.Teleporter;
import top.yigege.domain.TeleporterAdmin;
import top.yigege.service.TeleporterAdminService;
import top.yigege.util.MD5Util;

public class TeleporterAdminAction extends BaseAction implements ModelDriven<TeleporterAdmin>{
	private TeleporterAdminService teleporterAdminService;
	public void setTeleporterAdminService(TeleporterAdminService teleporterAdminService) {
		this.teleporterAdminService = teleporterAdminService;
	}

	private TeleporterAdmin teleporterAdmin = new TeleporterAdmin();
	public TeleporterAdmin getTeleporterAdmin() {
		return teleporterAdmin;
	}
	public void setTeleporterAdmin(TeleporterAdmin teleporterAdmin) {
		this.teleporterAdmin = teleporterAdmin;
	}

	
	
	//属性封装teleporter_admin_Id;
	private Integer teleporter_admin_Id;
	public Integer getTeleporter_admin_Id() {
		return teleporter_admin_Id;
	}
	public void setTeleporter_admin_Id(Integer teleporter_admin_Id) {
		this.teleporter_admin_Id = teleporter_admin_Id;
	}
	//模型驱动封装管理员参数
	@Override
	public TeleporterAdmin getModel() {
		// TODO Auto-generated method stub
		return this.teleporterAdmin;
	}
	
	
	/**
	 * 添加传送点管理员
	 * @return
	 */
	public String add() {
		//1.检查超级管理员是否登入
		int state;
		 ActionContext actionContext = ActionContext.getContext();  
	     Map session = actionContext.getSession(); 
	     if(!session.containsKey("superuser")) {
	    	 this.getJsonData().put("state", -1);
	    	 return "jsonData";
	     }
	     
	     if(teleporterAdmin.getPassword() == null || teleporterAdmin.getPassword().trim() == "") 
	     {
	    	 teleporterAdmin.setPassword(MD5Util.MD5(teleporterAdmin.getTel()));
	     }else {
	    	 teleporterAdmin.setPassword(MD5Util.MD5(teleporterAdmin.getPassword()));
	     }

	     //2.添加管理员业务处理
	     Teleporter teleporter = new Teleporter();
	     teleporter.setTeleporterId(teleporter_admin_Id);
	     this.teleporterAdmin.setTeleporter(teleporter);
	     state = teleporterAdminService.addAdmin(this.teleporterAdmin);
	     this.getJsonData().put("state", state);
		return "jsonData";
	}
	
	
	/**
	 * 删除传送点管理员
	 */
	public String deleteAdmin() {
		//1.检查超级管理员是否登入
		int state;
		 ActionContext actionContext = ActionContext.getContext();  
	     Map session = actionContext.getSession(); 
	     if(!session.containsKey("superuser")) {
	    	 this.getJsonData().put("state", -1);
	    	 return "jsonData";
	     }
	     
	     
	     //2.删除管理员业务处理
	     state = teleporterAdminService.deleteAdmin(this.teleporterAdmin);
	     this.getJsonData().put("state", state);
		return "jsonData";
	}
	
	
	/**
	 * 查询所有管理员
	 */
	public String queryAll(){
		//1.检查超级管理员是否登入
		int state;
		 ActionContext actionContext = ActionContext.getContext();  
	     Map session = actionContext.getSession(); 
	     if(!session.containsKey("superuser")) {
	    	 this.getJsonData().put("state", -1);
	    	 return "jsonData";
	     }
	     
	     //2.查询所有管理员业务处理
	     List<TeleporterAdmin> teleporterAdminLists = teleporterAdminService.findAll();
	     if(teleporterAdminLists != null) {
	    	 this.getJsonData().put("state", 1);
	    	 this.getJsonData().put("result", teleporterAdminLists);
	     }else {
	    	 this.getJsonData().put("state", 0);
	     }
		return "jsonData";
	}

}
