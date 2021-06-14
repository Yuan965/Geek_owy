/*
Navicat MySQL Data Transfer

Source Server         : OWY
Source Server Version : 50626
Source Host           : localhost:3306
Source Database       : owy

Target Server Type    : MYSQL
Target Server Version : 50626
File Encoding         : 65001

Date: 2021-06-14 21:00:43
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `order`
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '订单id',
  `jnlno` bigint(20) NOT NULL COMMENT '订单号',
  `userid` bigint(20) NOT NULL COMMENT '用户id',
  `tot_amount` decimal(10,2) NOT NULL COMMENT '总金额',
  `pay_amount` decimal(10,2) DEFAULT NULL COMMENT '付款金额',
  `status` varchar(1) COLLATE utf8_bin NOT NULL COMMENT '0:未支付；1代发货；2已发货;3已完成',
  `createtime` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `updatetime` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `receiver_name` varchar(100) COLLATE utf8_bin NOT NULL COMMENT '收货人姓名',
  `receiver_phone` varchar(32) COLLATE utf8_bin NOT NULL COMMENT '收货人电话',
  `receiver_province` varchar(32) COLLATE utf8_bin NOT NULL COMMENT '收货人省份',
  `receiver_city` varchar(32) COLLATE utf8_bin NOT NULL COMMENT '收货人市',
  `receiver_region` varchar(32) COLLATE utf8_bin NOT NULL COMMENT '收货人区',
  `receiver_detail_address` varchar(200) COLLATE utf8_bin NOT NULL COMMENT '收货人地址',
  `note` varchar(500) COLLATE utf8_bin NOT NULL COMMENT '备注',
  PRIMARY KEY (`id`),
  KEY `pri_userid` (`userid`),
  KEY `jnlno` (`jnlno`),
  CONSTRAINT `pri_userid` FOREIGN KEY (`userid`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of order
-- ----------------------------

-- ----------------------------
-- Table structure for `order_item`
-- ----------------------------
DROP TABLE IF EXISTS `order_item`;
CREATE TABLE `order_item` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `order_id` bigint(20) NOT NULL COMMENT '订单id',
  `jnlno` bigint(20) NOT NULL COMMENT '订单编号',
  `prd_id` bigint(20) NOT NULL COMMENT '商品id',
  `prd_price` decimal(10,2) NOT NULL COMMENT '销售价格',
  `prd_real_price` decimal(10,2) NOT NULL COMMENT '优惠后实际金额',
  `buy_num` bigint(20) NOT NULL COMMENT '购买数量',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of order_item
-- ----------------------------

-- ----------------------------
-- Table structure for `product`
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `prd_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `prd_name` varchar(255) CHARACTER SET utf8 NOT NULL COMMENT '商品名',
  `prd_price` decimal(10,0) NOT NULL COMMENT '商品价格',
  `prd_img` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '商品图片',
  `prd_desc` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '商品描述',
  `prd_brand` varchar(255) COLLATE utf8_bin DEFAULT NULL COMMENT '商品品牌',
  PRIMARY KEY (`prd_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of product
-- ----------------------------

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `password` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
