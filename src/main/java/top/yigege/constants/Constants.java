package top.yigege.constants;

import org.apache.commons.io.monitor.FileAlterationListener;
import org.omg.CORBA.PUBLIC_MEMBER;

import static top.yigege.constants.Constants.MessageType.*;

/**
 * 
 * @ClassName:  Constants   
 * @Description:常量类
 * @author: yigege
 * @date:   2018年12月16日 下午1:23:16
 */
public class Constants {
	
	/**
	 * 
	 * @ClassName:  YesOrNo   
	 * @Description:TODO
	 * @author: yigege
	 * @date:   2018年12月16日 下午1:25:53
	 */
	public  interface YesOrNo {
		/**成功状态*/
		public static final int YES = 1;
		/**失败状态*/
		public static final int NO = -1;
		/**无效状态*/
		public static final int ERROR = 0;
	}
	
	/**
	 * 
	 * @ClassName:  ValidOrInvalid   
	 * @Description:TODO
	 * @author: yigege
	 * @date:   2018年12月16日 下午1:30:16
	 */
	public interface ValidOrInvalid {
		
		public static final int VALID = 1;
		public static final int INVALID = -1;
	}
	
	/**
	 * 
	 * @ClassName:  PortalSessionKey   
	 * @Description:保持session中的key
	 * @author: yigege
	 * @date:   2019年1月14日 下午9:29:09
	 */
	public  interface PortalSessionKey {
		

		/**session key*/
		public static final String USER_SESSION_KEY = "top.yigege.session.user";
		
		
	}

	/**
	 * SessionKey
	 */
	public  interface SessionValueKey {
		/**上一次登入时间*/
		public static final String LAST_LOGIN_TIME = "lastlogintime";
	}


	/**
	 * 排序
	 */
	public  interface OrderValue {
		
		/**正序*/
		public static final int ASC = 0;
		
		/**倒序*/
		public static final int DESC = 1;
	}


	/**
	 * 消息类型
	 */
	public static  class   MessageType {

		/**传送点*/
		public static	Long PORTAL = 1l;

		/**用户端*/
		public static	Long USER = 2l;

		/**骑手端*/
		public static	Long RIDER = 3l;

		/**所有*/
		public static	Long ALL = 4l;


		public static String getName(Long key) {
			String value = "";
			switch (key.intValue()) {
				case 1 :value = "传送点";break;
				case 2 :value = "用户端";break;
				case 3 :value = "骑手端";break;
				case 4 :value = "全部";break;
				default:break;
			}
			return value;
		}


	}


	/**
	 * 用户类型
	 */
	public static class UserType {
		/**普通用户*/
		public static final Long NORMAL = 1L;

		/**商业用户*/
		public static final Long BUSINESS = 2L;

		public static  String getName(Long key) {
			String value = "";
			switch (key.intValue()) {
				case 1 :value = "普通用户";break;
				case 2 :value = "商业用户";break;
				default:break;
			}
			return value;
		}
	}
}
