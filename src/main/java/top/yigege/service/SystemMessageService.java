package top.yigege.service;

import java.util.List;

import top.yigege.dao.SystemMessageDao;
import top.yigege.domain.SystemMessage;

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
	
}
