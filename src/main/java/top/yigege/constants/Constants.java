package top.yigege.constants;

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
	public static interface YesOrNo {
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
	public static interface ValidOrInvalid {
		
		public static final int VALID = 1;
		public static final int INVALID = -1;
	}

}
