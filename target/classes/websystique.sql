/*
Navicat MySQL Data Transfer

Source Server         : Local Test Database
Source Server Version : 50626
Source Host           : localhost:3306
Source Database       : websystique

Target Server Type    : MYSQL
Target Server Version : 50626
File Encoding         : 65001

Date: 2016-04-01 03:55:03
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for share
-- ----------------------------
DROP TABLE IF EXISTS `share`;
CREATE TABLE `share` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `symbol` varchar(50) NOT NULL,
  `price` double(20,6) NOT NULL,
  `joining_date` date NOT NULL,
  `quantity` bigint(20) NOT NULL,
  `value` double(20,6) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of share
-- ----------------------------
INSERT INTO `share` VALUES ('7', 'BAL.AX', '10.340000', '2016-04-01', '10', '100.000000');
INSERT INTO `share` VALUES ('8', 'BAL.AX', '10.340000', '2016-04-01', '100', '1034.000000');
INSERT INTO `share` VALUES ('9', 'A2M.AX', '1.710000', '2016-04-01', '20', '34.200000');
INSERT INTO `share` VALUES ('10', 'BGA.AX', '5.900000', '2016-04-01', '50', '295.000000');
INSERT INTO `share` VALUES ('11', 'a2m.ax', '1.710000', '2016-04-01', '100', '171.000000');
INSERT INTO `share` VALUES ('12', 'bal.ax', '10.340000', '2016-04-01', '10', '103.400000');
INSERT INTO `share` VALUES ('13', 'BAL.ax', '10.340000', '2016-04-01', '100', '1034.000000');
