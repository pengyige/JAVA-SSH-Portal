/*
 Navicat Premium Data Transfer

 Source Server         : portal
 Source Server Type    : MySQL
 Source Server Version : 50633
 Source Host           : yigege.top:3306
 Source Schema         : portal

 Target Server Type    : MySQL
 Target Server Version : 50633
 File Encoding         : 65001

 Date: 31/12/2018 18:58:23
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

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

SET FOREIGN_KEY_CHECKS = 1;
