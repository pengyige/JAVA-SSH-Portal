package top.yigege.log;

import static org.junit.Assert.*;

import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggerFactory;
import org.aspectj.weaver.patterns.ThisOrTargetAnnotationPointcut;
import org.junit.Test;
import org.omg.CORBA.PRIVATE_MEMBER;

public class Log4jTest {

	@Test
	public void test() {
		Logger logger = Logger.getLogger(Log4jTest.class.getClass());
		
		logger.debug("test");
	}

}
