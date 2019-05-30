/*
Navicat MySQL Data Transfer
Source Host     : localhost:3306
Source Database : erhia
Target Host     : localhost:3306
Target Database : erhia
Date: 2018-07-23 15:26:45
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for t_brand
-- ----------------------------
DROP TABLE IF EXISTS `t_brand`;
CREATE TABLE `t_brand` (
  `id` int(11) NOT NULL auto_increment,
  `name` varchar(50) default NULL,
  PRIMARY KEY  (`id`),
  UNIQUE KEY `t_brand_name_uk` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_brand
-- ----------------------------
INSERT INTO `t_brand` VALUES ('2', '大众');
INSERT INTO `t_brand` VALUES ('4', '奔驰');
INSERT INTO `t_brand` VALUES ('3', '奥迪');
INSERT INTO `t_brand` VALUES ('5', '宝马');
INSERT INTO `t_brand` VALUES ('1', '标致');

-- ----------------------------
-- Table structure for t_car
-- ----------------------------
DROP TABLE IF EXISTS `t_car`;
CREATE TABLE `t_car` (
  `id` int(11) NOT NULL auto_increment,
  `car_number` varchar(10) default NULL,
  `brand_id` int(11) default NULL,
  `model` varchar(40) default NULL,
  `color` varchar(20) default NULL,
  `category_id` int(11) default NULL,
  `t_comments` varchar(100) default NULL,
  `price` double(11,2) default NULL,
  `rent` double(9,2) default NULL,
  `status` int(1) default NULL,
  `useable` int(1) default NULL,
  PRIMARY KEY  (`id`),
  KEY `brand_id` (`brand_id`),
  KEY `t_car_category_id_fk` (`category_id`),
  CONSTRAINT `t_car_category_id_fk` FOREIGN KEY (`category_id`) REFERENCES `t_category` (`id`),
  CONSTRAINT `brand_id` FOREIGN KEY (`brand_id`) REFERENCES `t_brand` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_car
-- ----------------------------
INSERT INTO `t_car` VALUES ('1', '沪A11C32', '2', '郎逸', '红色', '2', '自动1.6L', '140000.00', '72.00', '0', '0');
INSERT INTO `t_car` VALUES ('2', '沪B6888', '2', '途观', '黑色', '3', '自动1.8T', '220000.00', '200.00', '0', '0');
INSERT INTO `t_car` VALUES ('3', '沪A1686', '3', 'A4L', '红色', '4', '自动2.0T', '400000.00', '359.00', '0', '0');
INSERT INTO `t_car` VALUES ('4', '沪D11C32', '1', '308', '黑色', '1', '手动1.6L', '130000.00', '56.00', '0', '0');
INSERT INTO `t_car` VALUES ('5', '沪E11C99', '1', '308S', '蓝色', '2', '自动1.2T', '160000.00', '70.00', '0', '0');
INSERT INTO `t_car` VALUES ('6', '沪F11C21', '2', '高尔夫', '红色', '1', '自动1.4T', '200000.00', '69.00', '0', '0');
INSERT INTO `t_car` VALUES ('7', '沪F1324', '5', '320Li', '白色', '4', '自动2.0T', '380000.00', '500.00', '0', '0');
INSERT INTO `t_car` VALUES ('8', '沪F6666', '4', 'B200', '黑色', '4', '自动1.6T', '320000.00', '300.00', '0', '0');

-- ----------------------------
-- Table structure for t_category
-- ----------------------------
DROP TABLE IF EXISTS `t_category`;
CREATE TABLE `t_category` (
  `id` int(11) NOT NULL auto_increment,
  `name` varchar(50) default NULL,
  PRIMARY KEY  (`id`),
  UNIQUE KEY `t_category_name_uk` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_category
-- ----------------------------
INSERT INTO `t_category` VALUES ('3', 'SUV');
INSERT INTO `t_category` VALUES ('4', '精英型');
INSERT INTO `t_category` VALUES ('1', '紧凑型');
INSERT INTO `t_category` VALUES ('2', '舒适型');

-- ----------------------------
-- Table structure for t_record
-- ----------------------------
DROP TABLE IF EXISTS `t_record`;
CREATE TABLE `t_record` (
  `id` int(11) NOT NULL auto_increment,
  `user_id` int(11) default NULL,
  `car_id` int(11) default NULL,
  `start_date` varchar(255) default NULL,
  `return_date` varchar(255) default NULL,
  `payment` double(9,2) default NULL,
  PRIMARY KEY  (`id`),
  KEY `t_record_user_id_fk` (`user_id`),
  KEY `t_record_car_id_fk` (`car_id`),
  CONSTRAINT `t_record_car_id_fk` FOREIGN KEY (`car_id`) REFERENCES `t_car` (`id`),
  CONSTRAINT `t_record_user_id_fk` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_record
-- ----------------------------
INSERT INTO `t_record` VALUES ('1', '2', '2', '2017-01-24', '2017-01-26', '400.00');
INSERT INTO `t_record` VALUES ('2', '3', '4', '2017-02-20', '2017-02-28', '448.00');
INSERT INTO `t_record` VALUES ('3', '4', '5', '2017-03-01', '2017-03-03', '210.00');
INSERT INTO `t_record` VALUES ('4', '1', '1', '2017-03-02', '2017-03-06', '288.00');

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` int(11) NOT NULL auto_increment,
  `username` char(40) NOT NULL,
  `password` char(20) NOT NULL,
  `sex` char(10) default NULL,
  `id_number` char(18) default NULL,
  `tel` char(11) default NULL,
  `addr` char(100) default NULL,
  `type` int(1) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('1', 'xiaoming', '111111', '0', '15647641312345', '1515445554', '江苏', '0');
INSERT INTO `t_user` VALUES ('2', 'tom', '111111', '0', '15647641312346', '1515445555', '日本', '0');
INSERT INTO `t_user` VALUES ('3', 'lucy', '111111', '0', '15647641312347', '1515445556', '上海', '0');
INSERT INTO `t_user` VALUES ('4', 'sam', '111111', '0', '15647641312348', '1515445557', '北京', '0');
INSERT INTO `t_user` VALUES ('5', 'leo', '111111', '0', '15647641312349', '1515445558', '深圳', '0');
INSERT INTO `t_user` VALUES ('6', 'marry', '111111', '0', '15647641312340', '1515445559', '南京', '1');
INSERT INTO `t_user` VALUES ('7', 'admin', 'admin', null, null, null, null, '1');
