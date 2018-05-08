#采用SSH框架进行后台开发，maven进行项目构建,接入百度地图服务和腾讯信鸽完成推送
#配置数据库、Tomcat

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
			top.yigege.json.result
		1.2.2 src/main/resources
			beans.xml
			struts.xml
			hibernate.cfg.xml
		1.2.3 src/test/java
			top.yigege.action
		1.2.4 src/main/webapp
			   bootstrap-3.3.7-dist
			   easyUI
			   css
			   image
			   js
			   WEB-INF
			   		web.xml
			   ad_login.jsp
			   manage.jsp
			   superad_login.jsp
			   supermanage.jsp
			   userridertest.jsp
二、数据库设计
用户表，骑手表、管理员表、传送点表、用户订单表、骑手订单表
| rider            |
| rider_order      |
| teleporter       |
| teleporter_admin |
| user             |
| user_order       |
用户与用户订单 一对多  (双向)
骑手与骑手订单 一对多 (双向)
传送点与骑手 一对多 (双向)
管理员与传送点 一对一 (双向外键关联)
骑手订单与用户订单 一对一 (单向外键关联,由骑手订单维护外键)

表结构
//user(用户表)
+----------+--------------+------+-----+---------+-------+
| Field    | Type         | Null | Key | Default | Extra |
+----------+--------------+------+-----+---------+-------+
| userId   | varchar(255) | NO   | PRI | NULL    |       |
| token    | varchar(255) | YES  |     | NULL    |       |
| username | varchar(255) | YES  | UNI | NULL    |       |
| password | varchar(255) | YES  |     | NULL    |       |
| sex      | int(11)      | YES  |     | 1       |       |
| tel      | varchar(255) | YES  |     | NULL    |       |
| email    | varchar(255) | YES  |     | NULL    |       |
| address  | varchar(255) | YES  |     | NULL    |       |
| type     | int(11)      | YES  |     | 1       |       |
+----------+--------------+------+-----+---------+-------+

//user_order(用户订单表)
+----------------+--------------+------+-----+---------+-------+
| Field          | Type         | Null | Key | Default | Extra |
+----------------+--------------+------+-----+---------+-------+
| userOrderId    | varchar(255) | NO   | PRI | NULL    |       |
| shipAddress    | varchar(255) | YES  |     | NULL    |       |
| shipName       | varchar(255) | YES  |     | NULL    |       |
| shipTel        | varchar(255) | YES  |     | NULL    |       |
| receiveAddress | varchar(255) | YES  |     | NULL    |       |
| receiveName    | varchar(255) | YES  |     | NULL    |       |
| receiveTel     | varchar(255) | YES  |     | NULL    |       |
| remark         | varchar(255) | YES  |     | NULL    |       |
| orderTime      | datetime     | YES  |     | NULL    |       |
| payment        | double       | YES  |     | NULL    |       |
| state          | varchar(255) | YES  |     | NULL    |       |
| user_order_id  | varchar(255) | YES  | MUL | NULL    |       |
| longitude      | double       | YES  |     | NULL    |       |
| latitude       | double       | YES  |     | NULL    |       |
+----------------+--------------+------+-----+---------+-------+

//teleporter(传送点表)
+--------------+--------------+------+-----+---------+----------------+
| Field        | Type         | Null | Key | Default | Extra          |
+--------------+--------------+------+-----+---------+----------------+
| teleporterId | int(11)      | NO   | PRI | NULL    | auto_increment |
| createDate   | datetime     | YES  |     | NULL    |                |
| address      | varchar(255) | YES  |     | NULL    |                |
| remark       | varchar(255) | YES  |     | NULL    |                |
+--------------+--------------+------+-----+---------+----------------+

//teleporter_admin(传送点管理员表)
+------------------+--------------+------+-----+---------+-------+
| Field            | Type         | Null | Key | Default | Extra |
+------------------+--------------+------+-----+---------+-------+
| teleporterAdminId | varchar(255) | NO   | PRI | NULL    |       |
| username         | varchar(255) | YES  |     | NULL    |       |
| password         | varchar(255) | YES  |     | NULL    |       |
| sex              | int(11)      | YES  |     | 1       |       |
| tel              | varchar(255) | YES  |     | NULL    |       |
| admin_porter_Id  | int(11)      | YES  | UNI | NULL    |       |
+------------------+--------------+------+-----+---------+-------+

//rider(骑手表)
+---------------------+--------------+------+-----+---------+-------+
| Field               | Type         | Null | Key | Default | Extra |
+---------------------+--------------+------+-----+---------+-------+
| riderId             | varchar(255) | NO   | PRI | NULL    |       |
| token               | varchar(255) | YES  |     | NULL    |       |
| username            | varchar(255) | YES  | UNI | NULL    |       |
| password            | varchar(255) | YES  |     | NULL    |       |
| checkinDate         | datetime     | YES  |     | NULL    |       |
| sex                 | int(11)      | YES  |     | 1       |       |
| tel                 | varchar(255) | YES  |     | NULL    |       |
| teleporter_rider_id | int(11)      | YES  | MUL | NULL    |       |
| deviceToken         | varchar(255) | YES  |     | NULL    |       |
| riderState          | int(11)      | YES  |     | 1       |       |
| IDNumber            | varchar(255) | YES  |     | NULL    |       |
| realName            | varchar(255) | YES  |     | NULL    |       |
| address             | varchar(255) | YES  |     | NULL    |       |
+---------------------+--------------+------+-----+---------+-------+

//rider_order(骑手订单表)
+-------------------------+--------------+------+-----+---------+-------+
| Field                   | Type         | Null | Key | Default | Extra |
+-------------------------+--------------+------+-----+---------+-------+
| riderOrderId            | varchar(255) | NO   | PRI | NULL    |       |
| createDate              | datetime     | YES  |     | NULL    |       |
| rider_order_id          | varchar(255) | YES  | MUL | NULL    |       |
| userorder_riderorder_Id | varchar(255) | YES  | UNI | NULL    |       |
+-------------------------+--------------+------+-----+---------+-------+


//创建数据库
create database portal;

//使用数据库
use portal;

//创建用户表
| user  | CREATE TABLE `user` (
  `userId` varchar(255) NOT NULL,
  `token` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `sex` int(11) DEFAULT '1',
  `tel` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `type` int(11) DEFAULT '1',
  PRIMARY KEY (`userId`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


//创建订单表
| user_order | CREATE TABLE `user_order` (
  `userOrderId` varchar(255) NOT NULL,
  `shipAddress` varchar(255) DEFAULT NULL,
  `shipName` varchar(255) DEFAULT NULL,
  `shipTel` varchar(255) DEFAULT NULL,
  `receiveAddress` varchar(255) DEFAULT NULL,
  `receiveName` varchar(255) DEFAULT NULL,
  `receiveTel` varchar(255) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  `orderTime` datetime DEFAULT NULL,
  `payment` double DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  `user_order_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`userOrderId`),
  KEY `FK731991DA961D5C0C` (`user_order_id`),
  CONSTRAINT `FK731991DA961D5C0C` FOREIGN KEY (`user_order_id`) REFERENCES `user` (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8
//订单状态 1待支付 2待接单 3待取货4配送中 5已完成

//创建传送点管理员表
| teleporter_admin | CREATE TABLE `teleporter_admin` (
  `teleporterAdminId` varchar(255) NOT NULL,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `sex` int(11) DEFAULT '1',
  `tel` varchar(255) DEFAULT NULL,
  `admin_porter_Id` int(11) DEFAULT NULL,
  PRIMARY KEY (`telporterAdminId`),
  UNIQUE KEY `admin_porter_Id` (`admin_porter_Id`),
  KEY `FK23841968DEC24015` (`admin_porter_Id`),
  CONSTRAINT `FK23841968DEC24015` FOREIGN KEY (`admin_porter_Id`) REFERENCES `teleporter` (`teleporterId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


//创建传送点表
| teleporter | CREATE TABLE `teleporter` (
  `teleporterId` int(11) NOT NULL AUTO_INCREMENT,
  `createDate` datetime DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`teleporterId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

//创建骑手表
| rider | CREATE TABLE `rider` (
  `riderId` varchar(255) NOT NULL,
  `token` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `checkinDate` datetime DEFAULT NULL,
  `sex` int(11) DEFAULT '1',
  `tel` varchar(255) DEFAULT NULL,
  `teleporter_rider_id` int(11) DEFAULT NULL,
  `deviceToken` varchar(255) DEFAULT NULL,
  `riderState` int(11) DEFAULT '1',
  PRIMARY KEY (`riderId`),
  UNIQUE KEY `username` (`username`),
  KEY `FK677B67AE66AB740` (`teleporter_rider_id`),
  CONSTRAINT `FK677B67AE66AB740` FOREIGN KEY (`teleporter_rider_id`) REFERENCES `teleporter` (`teleporterId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 |
//riderState 1表示停止接单 2开始接单


//创建骑手订单表
| rider_order | CREATE TABLE `rider_order` (
  `riderOrderId` varchar(255) NOT NULL,
  `createDate` datetime DEFAULT NULL,
  `rider_order_id` varchar(255) DEFAULT NULL,
  `userorder_riderorder_Id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`riderOrderId`),
  UNIQUE KEY `userorder_riderorder_Id` (`userorder_riderorder_Id`),
  KEY `FK9D7D5D494B7D7F8C` (`userorder_riderorder_Id`),
  KEY `FK9D7D5D49271597CA` (`rider_order_id`),
  CONSTRAINT `FK9D7D5D49271597CA` FOREIGN KEY (`rider_order_id`) REFERENCES `rider` (`riderId`),
  CONSTRAINT `FK9D7D5D494B7D7F8C` FOREIGN KEY (`userorder_riderorder_Id`) REFERENCES `user_order` (`userOrderId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

三、接口测试

		
