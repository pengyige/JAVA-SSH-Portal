package top.yigege.superadmin.dao;

import static org.junit.Assert.*;

import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import top.yigege.domain.SuperAdmin;
import top.yigege.service.SuperAdminService;
import top.yigege.util.MD5Util;

/**
 * 
 * @ClassName:  SuperAdminDaoTest   
 * @Description:超级管理员Dao测试
 * @author: yigege
 * @date:   2018年12月16日 下午6:15:15
 */
public class SuperAdminDaoTest {

	protected final Log	logger	= LogFactory.getLog(getClass());
	//初始化容器
    private static ApplicationContext appContext ;
    
    /**创建超级管理员服务器对象*/
	public static SuperAdminService superAdminService;
    
    /**
     * 自动补录测试
     */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		 //配置xml文件路径
        String[] xml = {"classpath:beans.xml"};
        //spring读取配置文件
        appContext = new FileSystemXmlApplicationContext(xml);
        //初始化
        superAdminService = (SuperAdminService) appContext.getBean("superAdminService");

	}
	
	/**
	 * 保存超级管理员
	 */
	@Test
	public void saveSuperAdmin() {
		//1.创建管理员对象
		SuperAdmin superAdmin = new SuperAdmin();
		superAdmin.setUsername("pengyi");
		superAdmin.setPassword(MD5Util.MD5("123456"));
		Date date = new Date();
		superAdmin.setLastLoginTime(date);
		
		//2.保存管理员
		superAdminService.addSuperAdmin(superAdmin);
	}
	

	
	/**
	 * 超级管理员登入测试
	 */
	@Test
	public void superAdminLogin() {
		//1.创建管理员
		SuperAdmin superAdmin = new SuperAdmin();
		superAdmin.setUsername("pengyi");
		superAdmin.setPassword(MD5Util.MD5("123456"));
		
		//2.登入
		superAdmin  = superAdminService.verifySuperAdmin(superAdmin.getUsername(),superAdmin.getPassword());
		
		logger.info(superAdmin.toString());
	}

}
