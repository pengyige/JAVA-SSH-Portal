package top.yigege.web.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;
import top.yigege.constants.Constants;
import top.yigege.domain.MessageType;
import top.yigege.domain.SuperAdmin;
import top.yigege.domain.SystemMessage;
import top.yigege.enums.HttpCodeEnum;
import top.yigege.service.SystemMessageService;
import top.yigege.util.ReturnDTOUtil;
import top.yigege.vo.SystemMessageQueryCondition;

/**
 * 
 * @ClassName:  SystemMessageAction   
 * @Description:系统消息表现层
 * @author: yigege
 * @date:   2018年12月31日 下午7:29:56
 */
public class SystemMessageAction extends BaseAction{

	/**系统消息服务对象*/
	private SystemMessageService systemMessageService;
	public void setSystemMessageService(SystemMessageService systemMessageService) {
		this.systemMessageService = systemMessageService;
	}

	/**消息实体*/
	private SystemMessage message = new SystemMessage();
	public void setMessage(SystemMessage message) {
		this.message = message;
	}
	public SystemMessage getMessage() {
		return message;
	}

	/**查询对象*/
	private SystemMessageQueryCondition systemMessageQueryCondition;
	public void setSystemMessageQueryCondition(SystemMessageQueryCondition systemMessageQueryCondition) {
		this.systemMessageQueryCondition = systemMessageQueryCondition;
	}

	
	/**
	 * 跳转到系统消息管理页面
	 * @return
	 */
	public String intoSystemMessageManagerPage() {
		return "intoSystemMessageManagerPage";
	}


	/**
	 * 分页查询
	 * @return
	 */
	public String queryAllByPage() {
		logger.info("分页查询所有消息");
		try {
			List<SystemMessage> teleporterAdmins = systemMessageService.pageListByCondition(page,rows,systemMessageQueryCondition);

			Long count = systemMessageService.getTeleporterAdminCountByCondition(systemMessageQueryCondition);
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
	 * 查询所有消息类型
	 * @return
	 */
	public String queryAllMessageType() {


		MessageType[] messageType = new MessageType[4];
		messageType[0] = new MessageType(Constants.MessageType.PORTAL,Constants.MessageType.getName(Constants.MessageType.PORTAL));
		messageType[1] = new MessageType(Constants.MessageType.USER,Constants.MessageType.getName(Constants.MessageType.USER));
		messageType[2] = new MessageType(Constants.MessageType.RIDER,Constants.MessageType.getName(Constants.MessageType.RIDER));
		messageType[3] = new MessageType(Constants.MessageType.ALL,Constants.MessageType.getName(Constants.MessageType.ALL));
		returnDTO = ReturnDTOUtil.success(messageType);
		return  JSON_DATA;
	}

	/**
	 * 查询消息详情
	 * @return
	 */
	public String getMessageDetailById() {
		logger.info("获取消息详细信息");
		if (null == message.getMessageId()) {
			this.returnDTO = ReturnDTOUtil.paramError("消息ID为空");
			return JSON_DATA;
		}

		try {
			SystemMessage returnSystemMessage = systemMessageService.getSystemMessageById(message.getMessageId());
			if (null != returnSystemMessage) {
				this.returnDTO = ReturnDTOUtil.success(returnSystemMessage);
			}else {
				this.returnDTO = ReturnDTOUtil.fail(message.getMessageId()+"对应的消息不存在");
			}
		}catch (Exception e) {
			logger.info("获取消息信息失败,失败原因:"+e.getMessage());
			e.printStackTrace();
			this.returnDTO = ReturnDTOUtil.error(e.getMessage());
		};
		return JSON_DATA;
	}


	/**
	 * 更新消息
	 * @return
	 */
	public String updateMessage() {
		logger.info("修改消息");
		String returnMessage = systemMessageService.checkMessageData(message);
		if (returnMessage.length() > 0) {
			returnDTO = ReturnDTOUtil.paramError(returnMessage);
			return JSON_DATA;
		}

		try {
			systemMessageService.updateMessage(message);
			returnDTO = ReturnDTOUtil.success(message.getTitle()+"消息更新成功");
		} catch (Exception e) {
			e.printStackTrace();
			logger.info("更新消息失败,失败原因:"+e.getMessage());
			returnDTO = ReturnDTOUtil.fail(e.getMessage());
		}

		return JSON_DATA;
	}

	/**
	 * 删除消息
	 * @return
	 */
	public String deleteMessage() {
		logger.info("删除消息");
		if (null == message.getMessageId()) {
			returnDTO = ReturnDTOUtil.paramError("消息ID不能为空");
			return JSON_DATA;
		}


		try {
			systemMessageService.deleteMessage(message);
			returnDTO = ReturnDTOUtil.success("删除成功");
		}catch (Exception e) {
			e.printStackTrace();
			logger.info("删除管理员失败,失败原因:"+e.getMessage());
			returnDTO = ReturnDTOUtil.fail(e.getMessage());
		}
		return JSON_DATA;
	}

	/**
	 * 添加消息
	 * @return
	 */
	public String addMessage() {
		logger.info("开始添加消息");
		String returnMessage = systemMessageService.checkMessageData(message);
		if (returnMessage.length() > 0 ) {
			returnDTO = ReturnDTOUtil.paramError(returnMessage);
			return JSON_DATA;
		}

		try {
			systemMessageService.addMessage(message,(SuperAdmin)request.getSession().getAttribute(Constants.PortalSessionKey.USER_SESSION_KEY));
			returnDTO = ReturnDTOUtil.success(message.getTitle()+"添加成功");
		}catch (Exception e) {
			e.printStackTrace();;
			logger.info("添加消息失败，失败原因:"+e.getMessage());
			returnDTO = ReturnDTOUtil.fail(e.getMessage());
		}
		return JSON_DATA;
	}


	/**
	 * 通过类型查询消息
	 * @return
	 */
	public String queryMessageByType() {
		logger.info("通过类型查询消息");

		try{

			List<SystemMessage> systemMessages = systemMessageService.pageListByCondition(1,10,systemMessageQueryCondition);
			returnDTO = ReturnDTOUtil.success(systemMessages);
		}catch (Exception e) {
			e.printStackTrace();
			logger.info("通过类型查询消息失败，失败原因:"+e.getMessage());
			returnDTO = ReturnDTOUtil.fail(e.getMessage());
		}
		return  JSON_DATA;
	}
}
