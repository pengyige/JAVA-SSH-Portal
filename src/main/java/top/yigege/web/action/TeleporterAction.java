package top.yigege.web.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.alibaba.fastjson.JSONObject;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;

import freemarker.template.utility.StringUtil;
import top.yigege.constants.Constants;
import top.yigege.domain.SuperAdmin;
import top.yigege.domain.Teleporter;
import top.yigege.enums.HttpCodeEnum;
import top.yigege.json.result.ForTeleporter;
import top.yigege.service.TeleporterService;
import top.yigege.util.ReturnDTOUtil;
import top.yigege.vo.ReturnDTO;
import top.yigege.vo.TeleporterQueryCondition;

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
	
	/**传送点查询对象*/
	private TeleporterQueryCondition teleporterQueryCondition;
	
	public TeleporterQueryCondition getTeleporterQueryCondition() {
		return teleporterQueryCondition;
	}
	public void setTeleporterQueryCondition(TeleporterQueryCondition teleporterQueryCondition) {
		this.teleporterQueryCondition = teleporterQueryCondition;
	}
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
		logger.info("添加传送点");
	 
	    try {
	    	teleporterService.addTeleporter(teleporter,(SuperAdmin)getRequest().getSession().getAttribute(Constants.PortalSessionKey.USER_SESSION_KEY));
	    	this.returnDTO = ReturnDTOUtil.success(teleporter.getAddress()+"添加成功!");
	    }catch (Exception e) {
			e.printStackTrace();
			this.returnDTO = ReturnDTOUtil.fail(e.getMessage());
		}
		return JSON_DATA;
	}
	
	
	
	/**
	 * 删除传送点
	 */
	@SuppressWarnings("unchecked")
	public String deleteTeleporter() {
			
		
		
	     //1.删除传送点业务处理
		 try {
		   if (null == this.teleporter.getTeleporterId()) {
			   throw new Exception("传送点ID不能为空!");
		   }	 
			 
	       teleporterService.deleteTeleporterById(this.teleporter.getTeleporterId());
	       this.returnDTO = ReturnDTOUtil.success("删除传送点成功!");
		 }catch (Exception e) {
			this.returnDTO = ReturnDTOUtil.fail(e.getMessage());
		 }
	     
	     return JSON_DATA;
	}
	
	
	
	/**
	 * 分页查询所有传送点
	 */
	public String queryAllByPage() {
		 logger.info("分页查询所有传送点");
		  
		 try {
		     List<Teleporter> teleporterLists = teleporterService.pageListByCondition(page,rows,teleporterQueryCondition);
		     
		     Long count = teleporterService.getTeleporterCountByCondition(teleporterQueryCondition);
		     if(teleporterLists != null) {
		    	 bootstrapTableDTO.setCode(HttpCodeEnum.OK.getCode());
		    	 bootstrapTableDTO.setTotal(count.intValue());
		    	 bootstrapTableDTO.setRows(teleporterLists);
		     }else {
		    	 bootstrapTableDTO.setCode(HttpCodeEnum.FAIL.getCode());
		     }
		 }catch (Exception e) {
			 e.printStackTrace();
			 bootstrapTableDTO.setCode(HttpCodeEnum.FAIL.getCode());
		}
	     
	     
	     return BOOTSTRAP_TABLE_JSON_DATA;
	}
	
	
	/**
	 * 查询传送点详情
	 * @return
	 */
	public String getTeleporterDetailById() {
		logger.info("查询传送点详情");
		if (null == teleporter.getTeleporterId()) {
			this.returnDTO = ReturnDTOUtil.paramError("传送点id为空");
			return JSON_DATA;
		}
		
		try {
			Teleporter returnTeleporter = teleporterService.queryTeleporterById(teleporter.getTeleporterId());
			if (null != returnTeleporter) {
				this.returnDTO = ReturnDTOUtil.success(returnTeleporter);
			}else {
				this.returnDTO = ReturnDTOUtil.fail(teleporter.getTeleporterId()+"对应的传送点不存在");
			}
		}catch (Exception e) {
			e.printStackTrace();
			this.returnDTO = ReturnDTOUtil.error(e.getMessage());
		};
		return JSON_DATA;
	}
	
	
	/**
	 * 更新传送点信息
	 * @return
	 */
	public String update() {
		logger.info("修改传送点信息");
		logger.info("请求参数"+teleporter.toString());
		if (null == teleporter.getTeleporterId()) {
			this.returnDTO = ReturnDTOUtil.paramError("传送点ID不能为空!");
			return JSON_DATA;
		}
		
		try {
			teleporterService.updateTelerpoter(teleporter);
			this.returnDTO = ReturnDTOUtil.success("更新传送点信息成功!");
		} catch (Exception e) {
			
			e.printStackTrace();
			this.returnDTO = ReturnDTOUtil.fail(e.getMessage());
		}
		
		return JSON_DATA;
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
	
	/**
	 * 进入传送点管理页面
	 * @return
	 */
	public String intoTeleporterManagerPage() {
		logger.info("进入传送点查询");
		//查询所有传送点
		return "intoTeleporterManagerPage";
	}
	
	
}
