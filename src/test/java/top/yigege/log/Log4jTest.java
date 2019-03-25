package top.yigege.log;

import static org.junit.Assert.*;

import org.apache.log4j.Logger;
import org.aspectj.weaver.patterns.ThisOrTargetAnnotationPointcut;
import org.junit.Test;
import org.omg.CORBA.PRIVATE_MEMBER;

/**
 * 
 * @ClassName:  Log4jTest   
 * @Description:测试
 * @author: yigege
 * @date:   2019年2月17日 下午8:13:08
 */
public class Log4jTest {

	@Test
	public void test() {
		Logger logger = Logger.getLogger(Log4jTest.class.getClass());
		System.out.println("a");
		logger.info("test");
	}
	
	@Test
	public void testCeil() {
		System.out.println(Math.ceil(1/50.0));
	}

}
