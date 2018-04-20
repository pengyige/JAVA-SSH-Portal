一、环境搭建
	1.1 导入开发包
		struts2 2.3.16
		spring 3.1.2
		hibernate 4.1.7
		...
	1.2 项目结构
		1.2.1 src/main/java包结构
			top.yigege.domain
			top.yigege.dao
			top.yigege.dao.impl
			top.yigege.service
			top.yigege.web.action
			top.yigege.util
			top.yigege.exception
		1.2.2 src/main/resources
			beans.xml
			struts.xml
			hibernate.cfg.xml
		1.2.3 src/test/java
			top.yigege.action
		1.2.4 src/main/webapp
			   css
			   image
			   js
			   WEB-INF
			   		web.xml
二、数据库设计
用户表，骑手表、管理员表、传送点表、用户订单表、骑手订单表、传送点骑手表

用户与用户订单 一对多
骑手与骑手订单 一对多
管理员与传送点 一对一
传送点与骑手 一对多

//创建数据库
create database portal;

//使用数据库
use portal;

//创建用户表
user |  CREATE TABLE `user` (
  `userId` varchar(255) NOT NULL,
  `token` varchar(255) DEFAULT NULL,
  `username` varchar(255) ,
  `password` varchar(255) DEFAULT NULL,
  `sex` int(11) DEFAULT NULL,
  `tel` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `type` int(11) DEFAULT NULL,
  PRIMARY KEY (`userId`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;;

//创建订单表
user_order | CREATE TABLE `user_order` (
  `userOrderId` varchar(255) NOT NULL,
  `shipAddress` varchar(255) DEFAULT NULL,
  `shipName` varchar(255) DEFAULT NULL,
  `shipTel` varchar(255) DEFAULT NULL,
  `receiveAddress` varchar(255) DEFAULT NULL,
  `receiveName` varchar(255) DEFAULT NULL,
  `receiveTel` varchar(255) DEFAULT NULL,
  `orderTime` datetime DEFAULT NULL,
  `payment` double DEFAULT NULL,
  'remark' varchar(255) DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  `user_order_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`userOrderId`),
  KEY `FK731991DA961D5C0C` (`user_order_id`),
  CONSTRAINT `FK731991DA961D5C0C` FOREIGN KEY (`user_order_id`) REFERENCES `user` (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


		