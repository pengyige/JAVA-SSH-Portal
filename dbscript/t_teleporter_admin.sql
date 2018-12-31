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

 Date: 31/12/2018 18:57:41
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_teleporter_admin
-- ----------------------------
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

SET FOREIGN_KEY_CHECKS = 1;
