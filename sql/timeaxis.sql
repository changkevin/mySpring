/*
Navicat MySQL Data Transfer

Source Server         : local.127.0.0.1
Source Server Version : 50634
Source Host           : localhost:3306
Source Database       : timeaxis

Target Server Type    : MYSQL
Target Server Version : 50634
File Encoding         : 65001

Date: 2018-01-27 13:12:36
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `t_sys_res`
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_res`;
CREATE TABLE `t_sys_res` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(32) CHARACTER SET utf8 DEFAULT NULL COMMENT '名称',
  `key` varchar(32) CHARACTER SET utf8 DEFAULT NULL COMMENT '菜单key',
  `url` varchar(256) CHARACTER SET utf8 DEFAULT NULL COMMENT '链接地址',
  `code_route` varchar(256) DEFAULT NULL COMMENT '权限路径',
  `type` int(11) DEFAULT '1' COMMENT '类型，1：菜单',
  `sort` int(11) DEFAULT '1' COMMENT '排序',
  `level` int(11) DEFAULT '1' COMMENT '级别',
  `parent_id` int(11) DEFAULT '0' COMMENT '父id',
  `state` int(11) DEFAULT '1' COMMENT '状态，1：显示，2：隐藏',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COMMENT='菜单表';

-- ----------------------------
-- Records of t_sys_res
-- ----------------------------
INSERT INTO `t_sys_res` VALUES ('1', '首页', 'index', 'index', 'index', '1', '1', '1', '0', '1');
INSERT INTO `t_sys_res` VALUES ('2', '模块1', 'module1', 'emperor/list', 'module1', '1', '2', '1', '0', '1');
INSERT INTO `t_sys_res` VALUES ('3', '模块2', 'module2', 'capital/list', 'module2', '1', '3', '1', '0', '1');
INSERT INTO `t_sys_res` VALUES ('4', '模块3', 'module3', 'capital/list', 'module3', '1', '4', '1', '0', '1');
INSERT INTO `t_sys_res` VALUES ('5', '系统管理', 'sys', null, 'sys', '1', '5', '1', '0', '1');
INSERT INTO `t_sys_res` VALUES ('6', '菜单管理', 'menu', 'menu/list', 'sys:menu', '1', '1', '2', '5', '1');
INSERT INTO `t_sys_res` VALUES ('7', '角色管理', 'role', 'role/list', 'sys:role', '1', '2', '2', '5', '1');
INSERT INTO `t_sys_res` VALUES ('8', '用户管理', 'user', 'user/list', 'sys:user', '1', '3', '2', '5', '1');

-- ----------------------------
-- Table structure for `t_sys_role`
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_role`;
CREATE TABLE `t_sys_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(64) CHARACTER SET utf8 DEFAULT '' COMMENT '名称',
  `remark` varchar(128) CHARACTER SET utf8 DEFAULT NULL COMMENT '备注',
  `sort` int(11) DEFAULT '1' COMMENT '排序',
  `state` tinyint(11) unsigned DEFAULT '1' COMMENT '状态，1：显示，2：隐藏',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COMMENT='角色表';

-- ----------------------------
-- Records of t_sys_role
-- ----------------------------
INSERT INTO `t_sys_role` VALUES ('1', 'admin', '系统管理员', '1', '1');
INSERT INTO `t_sys_role` VALUES ('2', 'common_user', '普通用户', '2', '1');

-- ----------------------------
-- Table structure for `t_sys_role_res`
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_role_res`;
CREATE TABLE `t_sys_role_res` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `role_id` int(11) DEFAULT NULL COMMENT '角色id',
  `res_id` int(11) DEFAULT NULL COMMENT '菜单id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COMMENT='角色和菜单关联表';

-- ----------------------------
-- Records of t_sys_role_res
-- ----------------------------
INSERT INTO `t_sys_role_res` VALUES ('1', '1', '1');
INSERT INTO `t_sys_role_res` VALUES ('2', '1', '2');
INSERT INTO `t_sys_role_res` VALUES ('3', '1', '3');
INSERT INTO `t_sys_role_res` VALUES ('4', '1', '4');
INSERT INTO `t_sys_role_res` VALUES ('5', '1', '5');
INSERT INTO `t_sys_role_res` VALUES ('6', '1', '6');
INSERT INTO `t_sys_role_res` VALUES ('7', '1', '7');
INSERT INTO `t_sys_role_res` VALUES ('8', '1', '8');
INSERT INTO `t_sys_role_res` VALUES ('9', '2', '1');
INSERT INTO `t_sys_role_res` VALUES ('10', '2', '2');
INSERT INTO `t_sys_role_res` VALUES ('11', '2', '3');
INSERT INTO `t_sys_role_res` VALUES ('12', '2', '4');

-- ----------------------------
-- Table structure for `t_sys_user`
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_user`;
CREATE TABLE `t_sys_user` (
  `id` bigint(18) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_id` varchar(64) CHARACTER SET utf8 DEFAULT NULL COMMENT '用户id',
  `username` varchar(64) CHARACTER SET utf8 DEFAULT NULL COMMENT '用户名',
  `password` varchar(64) CHARACTER SET utf8 DEFAULT NULL COMMENT '密码',
  `sex` tinyint(4) DEFAULT '1' COMMENT '性别，0：未知，1：男，2：女',
  `nickname` varchar(64) CHARACTER SET utf8 DEFAULT NULL COMMENT '昵称',
  `register_type` int(11) DEFAULT '10' COMMENT '注册类型，100：网站，200：QQ，300：微信，400：微博',
  `email` varchar(64) CHARACTER SET utf8 DEFAULT NULL COMMENT 'email',
  `phone` varchar(11) CHARACTER SET utf8 DEFAULT NULL COMMENT '手机号',
  `address` varchar(128) CHARACTER SET utf8 DEFAULT NULL COMMENT '地址',
  `icon_url` varchar(256) CHARACTER SET utf8 DEFAULT NULL COMMENT '头像地址',
  `profile` varchar(1000) CHARACTER SET utf8 DEFAULT NULL COMMENT '个人简介',
  `state` int(11) DEFAULT '1' COMMENT '状态',
  `login_count` int(11) DEFAULT '0' COMMENT '登录次数',
  `last_login_time` datetime DEFAULT NULL COMMENT '最后登录时间',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COMMENT='用户表';

-- ----------------------------
-- Records of t_sys_user
-- ----------------------------
INSERT INTO `t_sys_user` VALUES ('10', '100201706131614297792788', 'admin', '202cb962ac59075b964b07152d234b70', '1', null, '100', null, null, null, null, null, '1', '8', '2017-06-19 17:49:43', '2017-06-13 16:14:29', null);
INSERT INTO `t_sys_user` VALUES ('11', '100201706131826081635283', 'test', '202cb962ac59075b964b07152d234b70', '1', null, '100', null, null, null, null, null, '1', '1', '2017-06-19 16:45:06', '2017-06-13 18:26:08', null);
INSERT INTO `t_sys_user` VALUES ('16', '100201706221801088575661', 'zhang', '96e79218965eb72c92a549dd5a330112', '1', null, '100', null, null, null, null, null, '1', '2', '2017-06-22 18:01:30', '2017-06-22 18:01:08', null);

-- ----------------------------
-- Table structure for `t_sys_user_role`
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_user_role`;
CREATE TABLE `t_sys_user_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_id` varchar(64) CHARACTER SET utf8 DEFAULT NULL COMMENT '用户id',
  `role_id` int(11) DEFAULT NULL COMMENT '角色id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COMMENT='用户和角色关联表';

-- ----------------------------
-- Records of t_sys_user_role
-- ----------------------------
INSERT INTO `t_sys_user_role` VALUES ('1', '100201706131614297792788', '1');
INSERT INTO `t_sys_user_role` VALUES ('2', '100201706131826081635283', '2');
INSERT INTO `t_sys_user_role` VALUES ('3', '100201706221801088575661', '2');

-- ----------------------------
-- Table structure for `t_ta_capital`
-- ----------------------------
DROP TABLE IF EXISTS `t_ta_capital`;
CREATE TABLE `t_ta_capital` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of t_ta_capital
-- ----------------------------

-- ----------------------------
-- Table structure for `t_ta_dynasty`
-- ----------------------------
DROP TABLE IF EXISTS `t_ta_dynasty`;
CREATE TABLE `t_ta_dynasty` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '朝代名称',
  `begin_year` int(11) DEFAULT NULL COMMENT '创建年',
  `end_year` int(11) DEFAULT NULL COMMENT '灭亡年',
  `is_assured` int(3) unsigned DEFAULT '1' COMMENT '纪年是否确定，0：否，1：是',
  `captital_id` int(11) DEFAULT NULL COMMENT ' 首都id',
  `emperor_id` int(11) DEFAULT NULL COMMENT '创建者id',
  `parent_id` int(11) DEFAULT '-1' COMMENT '所属朝代id',
  `level` int(4) DEFAULT '1' COMMENT '朝代划分级别',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COMMENT='朝代表';

-- ----------------------------
-- Records of t_ta_dynasty
-- ----------------------------
INSERT INTO `t_ta_dynasty` VALUES ('1', '夏朝', '-2197', '-1773', '0', null, null, '-1', '1');
INSERT INTO `t_ta_dynasty` VALUES ('2', '商朝', '-1773', '-1114', '0', null, null, '-1', '1');
INSERT INTO `t_ta_dynasty` VALUES ('3', '周朝', '-1049', '-221', '0', null, null, '-1', '1');
INSERT INTO `t_ta_dynasty` VALUES ('4', null, null, null, '1', null, null, '-1', '1');

-- ----------------------------
-- Table structure for `t_ta_emperor`
-- ----------------------------
DROP TABLE IF EXISTS `t_ta_emperor`;
CREATE TABLE `t_ta_emperor` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL,
  `is_founder` tinyint(3) unsigned DEFAULT '0' COMMENT '是否是开国者，0：否，1：是',
  `order` int(10) unsigned DEFAULT NULL COMMENT '本朝第几代',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='帝王表';

-- ----------------------------
-- Records of t_ta_emperor
-- ----------------------------

-- ----------------------------
-- Table structure for `t_ta_year`
-- ----------------------------
DROP TABLE IF EXISTS `t_ta_year`;
CREATE TABLE `t_ta_year` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `year` int(11) DEFAULT NULL COMMENT '年份',
  `dynasty_id` int(11) DEFAULT NULL COMMENT '朝代id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='纪年表';

-- ----------------------------
-- Records of t_ta_year
-- ----------------------------
