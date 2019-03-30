package top.yigege.service;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import top.yigege.dao.SystemMessageDao;
import top.yigege.domain.SuperAdmin;
import top.yigege.domain.SystemMessage;
import top.yigege.vo.SystemMessageQueryCondition;

/**
 * 
 * @ClassName:  SystemMessageService   
 * @Description:系统消息服务层
 * @author: yigege
 * @date:   2018年12月31日 下午7:31:03
 */
public class SystemMessageService {

	/**系统消息dao*/
	private SystemMessageDao systemMessageDao;
	public void setSystemMessageDao(SystemMessageDao systemMessageDao) {
		this.systemMessageDao = systemMessageDao;
	}
	
	/**
	 * 获取所有系统消息
	 */
	public List<SystemMessage> queyAllSystemMessage() {
		
		//获取系统消息
		return systemMessageDao.findAll();
	}

	/**
	 * 分页查询总数
	 * @param systemMessageQueryCondition
	 * @return
	 */
    public Long getTeleporterAdminCountByCondition(SystemMessageQueryCondition systemMessageQueryCondition) {
		return systemMessageDao.getTeleporterAdminCountByCondition(systemMessageQueryCondition);
    }

	/**
	 * 分页查询
	 * @param page
	 * @param rows
	 * @param systemMessageQueryCondition
	 * @return
	 */
	public List<SystemMessage> pageListByCondition(int page, int rows, SystemMessageQueryCondition systemMessageQueryCondition) {
		return systemMessageDao.pageListByCondition(page,rows,systemMessageQueryCondition);
	}

	/**
	 * 查询消息详情
	 * @param messageId
	 * @return
	 */
	public SystemMessage getSystemMessageById(Integer messageId) {
		return systemMessageDao.find(messageId);
	}

	/**
	 * 校验消息实体数据
	 * @param message
	 * @return
	 * @throws Exception
	 */
	public String checkMessageData(SystemMessage message) {
		StringBuilder stringBuilder = new StringBuilder();
		if (null != message) {
			if (StringUtils.isBlank(message.getTitle())) {
				stringBuilder.append("标题不能为空\r\n");
			}

			if (StringUtils.isBlank(message.getContent())) {
				stringBuilder.append("内容不能为空\r\n");
			}

			if (0 == message.getType()) {
				stringBuilder.append("消息类型不能为空\r\n");
			}


		}else {
			stringBuilder.append("消息信息不能为空");
		}

		return stringBuilder.toString();
	}

	/**
	 * 更新消息
	 * @param message
	 */
	public void updateMessage(SystemMessage message) throws Exception {
		if (null == message.getMessageId()) {
			throw  new Exception("消息ID不能为空");

		}

		//获取需要更新的消息
		SystemMessage updateSystemMessage = systemMessageDao.find(message.getMessageId());
		if (null == updateSystemMessage) {
			throw new Exception(message.getMessageId()+"消息不存在");
		}

		if (StringUtils.isNotBlank(message.getTitle())) {
			updateSystemMessage.setTitle(message.getTitle());
		}

		if (StringUtils.isNotBlank(message.getContent())) {
			updateSystemMessage.setContent(message.getContent());
		}

		if (0 == message.getType()) {
			throw new Exception("消息类型不能为空");
		}else {
			updateSystemMessage.setType(message.getType());
		}

		updateSystemMessage.setState(message.getState());

		systemMessageDao.update(updateSystemMessage);
	}

	/**
	 * 删除消息
	 * @param message
	 */
	public void deleteMessage(SystemMessage message) throws Exception {
		SystemMessage systemMessage = getSystemMessageById(message.getMessageId());
		if (null == systemMessage) {
			throw  new Exception(message.getMessageId()+"消息不存在");
		}

		systemMessageDao.delete(systemMessage);
	}

	/**
	 * 添加消息
	 * @param message
	 * @param superAdmin
	 */
	public void addMessage(SystemMessage message, SuperAdmin superAdmin) {
		//设置录入人
		message.setSuperAdmin(superAdmin);
		//设置录入时间
		message.setCreateTime(new Date());

		systemMessageDao.save(message);
	}
}
