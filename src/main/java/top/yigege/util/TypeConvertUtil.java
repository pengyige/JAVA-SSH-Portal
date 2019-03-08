package top.yigege.util;

/**
 * 
 * @ClassName:  TypeConvertUtil   
 * @Description:类型转换
 * @author: yigege
 * @date:   2019年3月8日 下午8:00:18
 */
public class TypeConvertUtil {

	/**
	 * String数组转int数组
	 * @param arrs
	 * @return
	 */
	public static Integer[] StringToInt(String[] arrs){

		Integer[] ints = new Integer[arrs.length];

	    for(int i = 0;i < arrs.length;i++){

	        ints[i] = Integer.parseInt(arrs[i]);

	    }

	    return ints;
	}

}
