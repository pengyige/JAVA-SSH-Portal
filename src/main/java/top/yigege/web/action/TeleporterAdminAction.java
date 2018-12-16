package top.yigege.web.action;

import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;

import top.yigege.domain.Teleporter;
import top.yigege.domain.TeleporterAdmin;
import top.yigege.service.TeleporterAdminService;
import top.yigege.util.MD5Util;

/**
 * 
 * @ClassName:  TeleporterAdminAction   
 * @Description:传送点管理员action
 * @author: yigege
 * @date:   2018年12月16日 下午12:38:20
 */
public class TeleporterAdminAction extends BaseAction implements ModelDriven<TeleporterAdmin>,ServletRequestAware,ServletResponseAware{
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
	
	
	//IOC注入serlvedAPI对象
	private HttpServletRequest request;
	@Override
	public void setServletRequest(HttpServletRequest request) {
		// TODO Auto-generated method stub
		this.request = request; 
		
	}
	
	private HttpServletResponse response;
	@Override
	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
		
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
	     
	     if(teleporterAdmin.getSex() == 0) {
	    	 teleporterAdmin.setSex(1);
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
	    	 this.getJsonData().put("total", teleporterAdminLists.size());
	    	 this.getJsonData().put("rows", teleporterAdminLists);
	     }else {
	    	 this.getJsonData().put("state", 0);
	     }
		return "jsonData";
	}
	
	
	/**
	 * 管理员登入
	 * @return
	 */
	public String login() {
		
		/*TeleporterAdmin teleporterAdmin = teleporterAdminService.adminLogin(this.teleporterAdmin);
		if(teleporterAdmin != null) {
			 ActionContext actionContext = ActionContext.getContext();  
		     Map session = actionContext.getSession();  
		     session.put("admin", teleporterAdmin); 
		     this.getJsonData().put("state", 1);
		     this.getJsonData().put("result",teleporterAdmin);
		}else {
			this.getJsonData().put("state", 0);
		}*/
		
		 //检查手机号是否存在
		 boolean flag=teleporterAdminService.telIsExist(teleporterAdmin.getTel());
		 if(flag){
			 	teleporterAdmin=teleporterAdminService.loginByPass(teleporterAdmin.getTel(),MD5Util.MD5(teleporterAdmin.getPassword()));	
			 	if(teleporterAdmin!=null){
			 		((HttpServletRequest)request).getSession().setAttribute("teleporterAdmin", teleporterAdmin);
			 		//  登录成功
			 		Cookie cookie_tel=new Cookie("cookie_tel",teleporterAdmin.getTel());
			 		cookie_tel.setMaxAge(12*60*30);
			 		Cookie cookie_password=new Cookie("cookie_password",teleporterAdmin.getPassword());
			 		cookie_password.setMaxAge(12*60*30);
			 		//发送两个cookie
			 		response.addCookie(cookie_tel);
			 		response.addCookie(cookie_password);
			 		//重定向到登录后的主页
			 		return "manage";
			 	}
			 	else{
			 		
			 		//密码错误返回给JSP页面
			 		 request.setAttribute("error","用户名或密码错误！");
			 		return "ad_login";
			 	}
			 
		 }else{
			 //账号不存在 返回给JSP页面
			 request.setAttribute("error", "该手机号未注册");
				return "ad_login";
		 }
	}

	
	/**
	 * 通过cookie登入
	 */
	public String loginByCookie() {
		String cookie_tel_str=null;
		String cookie_password_str=null;
		Cookie[] cookies=request.getCookies();
		if(cookies!=null){
			for(Cookie cookie:cookies){
				if("cookie_tel".equals(cookie.getName())){
					cookie_tel_str=cookie.getValue();
				}
				if("cookie_password".equals(cookie.getName())){
					cookie_password_str=cookie.getValue();
				}
			}
			
		}
		
		int state = 0;
		//若找到,使用cookie登入的
		if(cookie_tel_str!=null&&cookie_password_str!=null){
			teleporterAdmin=teleporterAdminService.loginByPass(cookie_tel_str,cookie_password_str);	
			if(teleporterAdmin != null) {
				((HttpServletRequest)request).getSession().setAttribute("teleporterAdmin", teleporterAdmin);
				state = 1;
				this.getJsonData().put("result", teleporterAdmin);
			}
			
		}
		this.getJsonData().put("state", state);
		return "jsonData";
	}
	
	
	/**
	 * 管理员注销
	 */
	public String logout() {
		//1.检查管理员是否登入
		if(this.request.getSession().getAttribute("teleporterAdmin") != null) {
			this.request.getSession().removeAttribute("teleporterAdmin");
		}
		return "ad_login";
	}
}
