package top.yigege.web.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import top.yigege.constants.Constants;
import top.yigege.domain.MessageType;
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

		return JSON_DATA;
	}


	/**
	 * 更新消息
	 * @return
	 */
	public String updateMessage() {
		return JSON_DATA;
	}

	/**
	 * 删除消息
	 * @return
	 */
	public String deleteMessage() {
		return JSON_DATA;
	}

	/**
	 * 添加消息
	 * @return
	 */
	public String addMessage() {
		return JSON_DATA;
	}
}
