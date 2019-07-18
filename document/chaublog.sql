/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50725
Source Host           : localhost:3306
Source Database       : chaublog

Target Server Type    : MYSQL
Target Server Version : 50725
File Encoding         : 65001

Date: 2019-07-18 14:04:55
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for uss_admin
-- ----------------------------
DROP TABLE IF EXISTS `uss_admin`;
CREATE TABLE `uss_admin` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(64) DEFAULT NULL,
  `password` varchar(64) DEFAULT NULL,
  `icon` varchar(500) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `nick_name` varchar(200) DEFAULT NULL,
  `note` varchar(500) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `login_time` datetime DEFAULT NULL,
  `status` int(1) DEFAULT '1' COMMENT '帐号启用状态：0->禁用；1->启用',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of uss_admin
-- ----------------------------
INSERT INTO `uss_admin` VALUES ('4', 'chenli', '$2a$10$NBqdadwNBlzxieHmArJ1pO6Gr10p/plkdg5jJqeDo6yyxREyXcr3.', null, null, null, null, '2019-07-17 19:27:17', null, '1');

-- ----------------------------
-- Table structure for uss_admin_role_relation
-- ----------------------------
DROP TABLE IF EXISTS `uss_admin_role_relation`;
CREATE TABLE `uss_admin_role_relation` (
  `id` bigint(20) NOT NULL,
  `admin_id` bigint(20) DEFAULT NULL,
  `role_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of uss_admin_role_relation
-- ----------------------------

-- ----------------------------
-- Table structure for uss_permission
-- ----------------------------
DROP TABLE IF EXISTS `uss_permission`;
CREATE TABLE `uss_permission` (
  `id` bigint(20) NOT NULL,
  `pid` bigint(20) DEFAULT NULL,
  `name` varchar(100) DEFAULT NULL,
  `value` varchar(200) DEFAULT NULL,
  `icon` varchar(500) DEFAULT NULL,
  `type` int(1) DEFAULT NULL,
  `uri` varchar(200) DEFAULT NULL,
  `status` int(1) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `sort` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of uss_permission
-- ----------------------------

-- ----------------------------
-- Table structure for uss_role
-- ----------------------------
DROP TABLE IF EXISTS `uss_role`;
CREATE TABLE `uss_role` (
  `id` bigint(20) NOT NULL,
  `name` varchar(100) DEFAULT NULL,
  `description` varchar(500) DEFAULT NULL,
  `admin_count` int(11) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `status` int(1) DEFAULT '1' COMMENT '启用状态：0->禁用；1->启用',
  `sort` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of uss_role
-- ----------------------------
INSERT INTO `uss_role` VALUES ('1', '超级管理员', '超级管理员', '0', '2019-07-18 11:34:05', '1', '0');
INSERT INTO `uss_role` VALUES ('2', '管理员', '管理员', '0', '2019-07-18 11:36:56', '1', '0');

-- ----------------------------
-- Table structure for uss_role_permission_relation
-- ----------------------------
DROP TABLE IF EXISTS `uss_role_permission_relation`;
CREATE TABLE `uss_role_permission_relation` (
  `id` bigint(20) NOT NULL,
  `role_id` bigint(20) DEFAULT NULL,
  `permission_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of uss_role_permission_relation
-- ----------------------------
