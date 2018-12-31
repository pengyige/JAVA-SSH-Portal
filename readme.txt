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
			top.yigege.enums
			top.yigege.vo
		1.2.2 src/main/resources
			beans.xml
			struts.xml
			hibernate.cfg.xml		
			log4j.properties		日志配置文件
			db.properties
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
| t_rider            |
| t_rider_order      |
| t_teleporter       |
| t_teleporter_admin |
| t_user             |
| t_user_order       |
用户与用户订单 一对多  (双向)
骑手与骑手订单 一对多 (双向)
传送点与骑手 一对多 (双向)
管理员与传送点 一对一 (双向外键关联)
骑手订单与用户订单 一对一 (单向外键关联,由骑手订单维护外键)

常亮定义：
订单状态:1:在呼叫配送员，2:配送员已接单，3:配送员已取货，4:已送达，5:已取消配送，6:无配送员接单。
性别:1:男 0:女
用户类型:1:普通用户 2:商业用户
骑手状态:1:未开始接单 2:已开始接单
系统消息类型 1:传送点消息 2:骑手消息 3:用户消息

表结构
//t_user(用户表)
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user`  (
  `userId` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户id',
  `token` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '用户token',
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '用户名',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '用户密码 md5',
  `sex` int(11) DEFAULT 1 COMMENT '性别 1:男 0女',
  `tel` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '用户电话',
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '用户邮箱',
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '用户地址',
  `type` int(11) DEFAULT 1 COMMENT '用户类型 1:普通用户 2:商业用户',
  `createTime` datetime(0) DEFAULT NULL COMMENT '注册时间',
  PRIMARY KEY (`userId`) USING BTREE,
  UNIQUE INDEX `username`(`username`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;


//t_user_order(用户订单表)
DROP TABLE IF EXISTS `t_user_order`;
CREATE TABLE `t_user_order`  (
  `userOrderId` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户订单id',
  `shipAddress` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '发件人地址',
  `shipName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '发件人姓名',
  `shipTel` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '发件人电话',
  `receiveAddress` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '收件人地址',
  `receiveName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '收件人姓名',
  `receiveTel` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '收件人电话',
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '订单备注',
  `orderTime` datetime(0) DEFAULT NULL COMMENT '创建时间',
  `payment` double DEFAULT NULL COMMENT '支付金额',
  `state` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '订单状态 1:在呼叫配送员  2:配送员已接单  3:配送员已取货  4:已送达  5:已取消配送  6:无配送员接单。',
  `longitude` double DEFAULT NULL COMMENT '订单经度',
  `latitude` double DEFAULT NULL COMMENT '订单纬度',
  `user_order_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '订单用户id',
  PRIMARY KEY (`userOrderId`) USING BTREE,
  INDEX `FK3076D685961D5C0C`(`user_order_id`) USING BTREE,
  CONSTRAINT `FK3076D685961D5C0C` FOREIGN KEY (`user_order_id`) REFERENCES `t_user` (`userId`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

//t_teleporter(传送点表)
DROP TABLE IF EXISTS `t_teleporter`;
CREATE TABLE `t_teleporter`  (
  `teleporterId` int(11) NOT NULL AUTO_INCREMENT COMMENT '传送点id',
  `createDate` datetime(0) DEFAULT NULL COMMENT '创建时间',
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '传送点地址',
  `remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`teleporterId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;


//t_teleporter_admin(传送点管理员表)
DROP TABLE IF EXISTS `t_teleporter_admin`;
CREATE TABLE `t_teleporter_admin`  (
  `teleporterAdminId` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '传送点管理员id',
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '传送点管理员姓名',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '传送点管理员密码 md5',
  `sex` int(11) DEFAULT 1 COMMENT '传送点管理员性别 1:男 0:女',
  `tel` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '传送点管理员电话',
  `admin_porter_Id` int(11) DEFAULT NULL COMMENT '传送点id',
  PRIMARY KEY (`teleporterAdminId`) USING BTREE,
  UNIQUE INDEX `admin_porter_Id`(`admin_porter_Id`) USING BTREE,
  INDEX `FK24A7F1D3DEC24015`(`admin_porter_Id`) USING BTREE,
  CONSTRAINT `FK24A7F1D3DEC24015` FOREIGN KEY (`admin_porter_Id`) REFERENCES `t_teleporter` (`teleporterId`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

//t_rider(骑手表)
-- ----------------------------
-- Table structure for t_rider
-- ----------------------------
DROP TABLE IF EXISTS `t_rider`;
CREATE TABLE `t_rider`  (
  `riderId` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '骑手id',
  `token` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '骑手token',
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '骑手用户名',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '骑手密码',
  `checkinDate` datetime(0) DEFAULT NULL COMMENT '登记日期',
  `sex` int(11) DEFAULT 1 COMMENT '性别 1:男 0:女',
  `tel` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '骑手手机号',
  `deviceToken` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '骑手推送token',
  `riderState` int(11) DEFAULT 1 COMMENT '骑手状态 1:未开始接单 2:开始接单',
  `IDNumber` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '骑手身份证',
  `realName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '骑手真实姓名',
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '骑手地址',
  `teleporter_rider_id` int(11) DEFAULT NULL COMMENT '骑手登记传送点id',
  `createTime` datetime(0) DEFAULT NULL COMMENT '骑手注册时间',
  PRIMARY KEY (`riderId`) USING BTREE,
  UNIQUE INDEX `username`(`username`) USING BTREE,
  INDEX `FKA0E6F2EFE66AB740`(`teleporter_rider_id`) USING BTREE,
  CONSTRAINT `FKA0E6F2EFE66AB740` FOREIGN KEY (`teleporter_rider_id`) REFERENCES `t_teleporter` (`teleporterId`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;


//t_rider_order(骑手订单表)
DROP TABLE IF EXISTS `t_rider_order`;
CREATE TABLE `t_rider_order`  (
  `riderOrderId` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '骑手订单id',
  `createDate` datetime(0) DEFAULT NULL COMMENT '接单时间',
  `rider_order_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '骑手id',
  `userorder_riderorder_Id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '用户订单id',
  PRIMARY KEY (`riderOrderId`) USING BTREE,
  UNIQUE INDEX `userorder_riderorder_Id`(`userorder_riderorder_Id`) USING BTREE,
  INDEX `FK8BC8ADFE4B7D7F8C`(`userorder_riderorder_Id`) USING BTREE,
  INDEX `FK8BC8ADFE271597CA`(`rider_order_id`) USING BTREE,
  CONSTRAINT `FK8BC8ADFE271597CA` FOREIGN KEY (`rider_order_id`) REFERENCES `t_rider` (`riderId`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK8BC8ADFE4B7D7F8C` FOREIGN KEY (`userorder_riderorder_Id`) REFERENCES `t_user_order` (`userOrderId`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

SET FOREIGN_KEY_CHECKS = 1;

//创建数据库
create database portal;

//使用数据库
use portal;

三、接口测试

		
