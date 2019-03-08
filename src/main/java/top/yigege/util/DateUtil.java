package top.yigege.util;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * 
 * @ClassName:  DateUtil   
 * @Description:日期处理类
 * @author: yigege
 * @date:   2019年3月8日 下午9:38:14
 */
public class DateUtil{
	
	public static final long DAY_MILLI = 24 * 60 * 60 * 1000; // 一天的MilliSecond
	
	public static String DATE_FORMAT_DATEONLY = "yyyy-MM-dd"; // 年/月/日
	public static String DATE_FORMAT_DATETIME = "yyyy-MM-dd HH:mm:ss"; // 年/月/日
	
	
	/**
	* 获取下一天的日期格式串
	*
	* 
	*/
	public static Date getNextDay(Date date) {

		Calendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		calendar.add(Calendar.DATE, 1);
		date = calendar.getTime();
		return date;
	}
}
