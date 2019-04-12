package top.yigege.web.action;

import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.alibaba.fastjson.serializer.SerialWriterStringEncoder;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;

import top.yigege.constants.Constants;
import top.yigege.domain.SuperAdmin;
import top.yigege.domain.Teleporter;
import top.yigege.domain.TeleporterAdmin;
import top.yigege.enums.HttpCodeEnum;
import top.yigege.service.TeleporterAdminService;
import top.yigege.util.MD5Util;
import top.yigege.util.ReturnDTOUtil;
import top.yigege.vo.BootstrapTableDTO;
import top.yigege.vo.ReturnDTO;
import top.yigege.vo.TeleporterAdminQueryCondition;

/**
 * 
 * @ClassName:  TeleporterAdminAction   
 * @Description:传送点管理员action
 * @author: yigege
 * @date:   2018年12月16日 下午12:38:20
 */
public class TeleporterAdminAction extends BaseAction implements ModelDriven<TeleporterAdmin>,ServletRequestAware,ServletResponseAware{
	/**传送点管理员服务层*/
	private TeleporterAdminService teleporterAdminService;
	public void setTeleporterAdminService(TeleporterAdminService teleporterAdminService) {
		this.teleporterAdminService = teleporterAdminService;
	}

	/**传送点管理员VO*/
	private TeleporterAdmin teleporterAdmin = new TeleporterAdmin();

	/**传送点管理员查询条件VO*/
	private TeleporterAdminQueryCondition teleporterAdminQueryCondition;

	public TeleporterAdminQueryCondition getTeleporterAdminQueryCondition() {
		return teleporterAdminQueryCondition;
	}

	public void setTeleporterAdminQueryCondition(TeleporterAdminQueryCondition teleporterAdminQueryCondition) {
		this.teleporterAdminQueryCondition = teleporterAdminQueryCondition;
	}

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

		 //检查手机号是否存在
		 boolean flag = teleporterAdminService.telIsExist(teleporterAdmin.getTel());
		 if(flag){
			 	teleporterAdmin=teleporterAdminService.loginByPass(teleporterAdmin.getTel(),MD5Util.MD5(teleporterAdmin.getPassword()));	
			 	if(teleporterAdmin!=null){
			 		if ( null == teleporterAdmin.getTeleporter()) {
						returnDTO = ReturnDTOUtil.fail("您还没有绑定传送点，请先绑定");
						return JSON_DATA;
					}


			 		((HttpServletRequest)request).getSession().setAttribute(Constants.PortalSessionKey.USER_SESSION_KEY, teleporterAdmin);
			 		//  登录成功
			 		Cookie cookie_tel=new Cookie(Constants.CookieKey.KEY_COOK_TEL,teleporterAdmin.getTel());
			 		cookie_tel.setMaxAge(12*60*30);
			 		Cookie cookie_password=new Cookie(Constants.CookieKey.KEY_COOK_PASSWORD,teleporterAdmin.getPassword());
			 		cookie_password.setMaxAge(12*60*30);
			 		//发送两个cookie
			 		response.addCookie(cookie_tel);
			 		response.addCookie(cookie_password);
			 		//重定向到登录后的主页
			 		returnDTO = ReturnDTOUtil.success();
			 	}
			 	else{
			 		
			 		//密码错误返回给JSP页面
			 		returnDTO = ReturnDTOUtil.fail("用户名或密码错误！");
			 	}
			 
		 }else{
			 //账号不存在 返回给JSP页面
			 returnDTO = ReturnDTOUtil.fail("该手机号未注册");
		 }

		 return JSON_DATA;
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
	 * 传送点管理员管理界面
	 * @return
	 */
	public String index() {
		logger.info("跳转到管理员管理页面");
		return "intoTeleporterAdminIndexPage";
	}
	

	public String queryGeneralSituation() {
		logger.info("传送点总体概况");
		return "intoGeneralSituation";
	}

	/**
	 * 管理员注销
	 */
	public String logout() {
		//1.检查管理员是否登入
		if(this.request.getSession().getAttribute(Constants.PortalSessionKey.USER_SESSION_KEY) != null) {
			this.request.getSession().removeAttribute(Constants.PortalSessionKey.USER_SESSION_KEY);
		}
		return "intoTeleporterAdminLoginPage";
	}
	
	/**
	 * 查询所有传送点管理员
	 * @return
	 */
	public String queryAllTelporterAdmin() {
		logger.info("查询所有传送点管理员");
		List<TeleporterAdmin> teleporterAdmins = null;
		try {
			teleporterAdmins = teleporterAdminService.findAll();
			this.returnDTO = ReturnDTOUtil.success(teleporterAdmins);
		}catch (Exception e) {
			e.printStackTrace();
			this.returnDTO = ReturnDTOUtil.fail(e.getMessage());
		}
			
		
		return JSON_DATA;
	}
	
	/**
	 * 跳转到传送点管理员管理界面
	 * @return
	 */
	public String intoTeleporterAdminManagerPage() {
		return "intoTeleporterAdminManagerPage";
	}
	
	/**
	 * 分页查询
	 * @return
	 */
	public String queryAllByPage() {
		logger.info("分页查询所有传送点管理员");

		try {
			List<TeleporterAdmin> teleporterAdmins = teleporterAdminService.pageListByCondition(page,rows,teleporterAdminQueryCondition);

			Long count = teleporterAdminService.getTeleporterAdminCountByCondition(teleporterAdminQueryCondition);
			if(teleporterAdmins != null) {
				bootstrapTableDTO.setCode(HttpCodeEnum.OK.getCode());
				bootstrapTableDTO.setTotal(count.intValue());
				bootstrapTableDTO.setRows(teleporterAdmins);
			}else {
				bootstrapTableDTO.setCode(HttpCodeEnum.FAIL.getCode());
				bootstrapTableDTO.setMessage(HttpCodeEnum.INVALID_REQUEST.getMessage());
			}
		}catch (Exception e) {
			e.printStackTrace();
			bootstrapTableDTO.setCode(HttpCodeEnum.FAIL.getCode());
			bootstrapTableDTO.setMessage(e.getMessage());
		}


		return BOOTSTRAP_TABLE_JSON_DATA;
	}
	
	/**
	 * 查询传送点管理员详情
	 * @return
	 */
	public String getTeleporterAdminDetailById() {
		logger.info("查询传送点管理员详情");
		if (null == teleporterAdmin.getTeleporterAdminId()) {
			this.returnDTO = ReturnDTOUtil.paramError("传送点管理员id为空");
			return JSON_DATA;
		}

		try {
			TeleporterAdmin returnTeleporterAdmin = teleporterAdminService.getTeleporterAdminById(teleporterAdmin.getTeleporterAdminId());
			if (null != returnTeleporterAdmin) {
				this.returnDTO = ReturnDTOUtil.success(returnTeleporterAdmin);
			}else {
				this.returnDTO = ReturnDTOUtil.fail(teleporterAdmin.getTeleporterAdminId()+"对应的传送点不存在");
			}
		}catch (Exception e) {
			e.printStackTrace();
			this.returnDTO = ReturnDTOUtil.error(e.getMessage());
		};
		return JSON_DATA;
	}
	
	/**
	 * 更新传送点管理员
	 * @return
	 */
	public String updateTeleporterAdmin() {
	    logger.info("更新传送点管理员");
	    String returnMessage = teleporterAdminService.modifyTeleporterAdminValid(teleporterAdmin);
	    if (returnMessage.length() > 0) {
	        returnDTO = ReturnDTOUtil.paramError(returnMessage);
	        return JSON_DATA;
        }

        try {
            teleporterAdminService.updateTeleporterAdmin(teleporterAdmin);
            returnDTO = ReturnDTOUtil.success(teleporterAdmin.getUsername()+"传送点管理员信息更新成功");
        } catch (Exception e) {
            e.printStackTrace();
            logger.info("更新传送点管理员失败,失败原因:"+e.getMessage());
            returnDTO = ReturnDTOUtil.fail(e.getMessage());
        }

        return JSON_DATA;
	}
	
	/**
	 * 删除传送点管理员
	 * @return
	 */
	public String deleteTeleporterAdmin() {
		logger.info("删除传送点管理员");
		if (StringUtils.isBlank(teleporterAdmin.getTeleporterAdminId())) {
			returnDTO = ReturnDTOUtil.paramError("传送点管理员ID不能为空");
			return JSON_DATA;
		}


		try {
			teleporterAdminService.deleteAdmin(teleporterAdmin);
			returnDTO = ReturnDTOUtil.success("删除成功");
		}catch (Exception e) {
			e.printStackTrace();
			logger.info("删除管理员失败,失败原因:"+e.getMessage());
			returnDTO = ReturnDTOUtil.fail(e.getMessage());
		}
		return JSON_DATA;
	}
	
	/**
	 * 添加传送点管理员
	 * @return
	 */
	public String addTeleporterAdmin() {
		logger.info("开始登记管理员");
		String returnMessage = teleporterAdminService.validTeleporterAdminData(teleporterAdmin);
		if (returnMessage.length() > 0 ) {
			returnDTO = ReturnDTOUtil.paramError(returnMessage);
			return JSON_DATA;
		}

		try {
			teleporterAdminService.addAdmin(teleporterAdmin,(SuperAdmin)request.getSession().getAttribute(Constants.PortalSessionKey.USER_SESSION_KEY));
			returnDTO = ReturnDTOUtil.success(teleporterAdmin.getUsername()+"登记成功");
		}catch (Exception e) {
			e.printStackTrace();;
			logger.info("登记管理员失败，失败原因:"+e.getMessage());
			returnDTO = ReturnDTOUtil.fail(e.getMessage());
		}
		return JSON_DATA;
	}

    /**
     * 解绑传送点
     * @return
     */
    public String unBindTeleporter() {
        logger.info("解除传送点绑定");
        if (StringUtils.isBlank(teleporterAdmin.getTeleporterAdminId())) {
            this.returnDTO = ReturnDTOUtil.paramError("管理员ID不能为空");
            return JSON_DATA;
        }

        try {
           TeleporterAdmin returnTeleporterAdmin = teleporterAdminService.doUnBindAdminAndTeleporter(teleporterAdmin.getTeleporterAdminId());
           this.returnDTO =  ReturnDTOUtil.success(returnTeleporterAdmin);
        }catch (Exception e) {
            logger.info(e.getMessage());
            e.printStackTrace();
            this.returnDTO = ReturnDTOUtil.fail(e.getMessage());
        }
	    return JSON_DATA;
    }
}
