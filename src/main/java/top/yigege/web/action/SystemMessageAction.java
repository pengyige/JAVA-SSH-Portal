package top.yigege.web.action;

import java.util.List;

import top.yigege.domain.SystemMessage;
import top.yigege.service.SystemMessageService;

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
	
	
	/**
	 * test
	 */
	public void hello() {
		System.out.println("hello,systemmessage");
	}
	
	public void get() {
		
		List<SystemMessage> systemMessages = systemMessageService.queyAllSystemMessage();
		if (null != systemMessages) {
			for (int i = 0 ; i < systemMessages.size(); i++) {
				logger.info(systemMessages.toString());
			}
		}
		
	}
}
