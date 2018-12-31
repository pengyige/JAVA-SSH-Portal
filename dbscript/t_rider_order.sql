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

 Date: 31/12/2018 18:58:13
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_rider_order
-- ----------------------------
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
