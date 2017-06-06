# --------------------------------------------------------
# Host:                         127.0.0.1
# Database:                     etms
# Server version:               5.1.50-community
# Server OS:                    Win32
# HeidiSQL version:             5.0.0.3272
# Date/time:                    2013-04-17 16:10:40
# --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
# Dumping database structure for etms
DROP DATABASE IF EXISTS `etms`;
CREATE DATABASE IF NOT EXISTS `etms` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `etms`;


# Dumping structure for table etms.reset_password
DROP TABLE IF EXISTS `reset_password`;
CREATE TABLE IF NOT EXISTS `reset_password` (
  `RESET_PASS_ID` int(11) NOT NULL AUTO_INCREMENT,
  `IS_PASS_CHANGED` varchar(255) DEFAULT NULL,
  `RESET_PASSS_CREATED` datetime DEFAULT NULL,
  `RESET_PASS_UNIQUE_CODE` varchar(255) DEFAULT NULL,
  `RESET_PASSS_UPDATED` datetime DEFAULT NULL,
  `UNIQUE_CODE_VALIDITY` datetime DEFAULT NULL,
  `USER_ID` int(11) DEFAULT NULL,
  PRIMARY KEY (`RESET_PASS_ID`),
  KEY `FKE0B3578BA2BFA1FB` (`USER_ID`),
  CONSTRAINT `FKE0B3578BA2BFA1FB` FOREIGN KEY (`USER_ID`) REFERENCES `users` (`USER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

# Data exporting was unselected.


# Dumping structure for table etms.sessions
DROP TABLE IF EXISTS `sessions`;
CREATE TABLE IF NOT EXISTS `sessions` (
  `SESS_ID` int(11) NOT NULL AUTO_INCREMENT,
  `AVAIL_SINCE` datetime DEFAULT NULL,
  `AVAIL_TILL` datetime DEFAULT NULL,
  `IP_ADDR` varchar(255) DEFAULT NULL,
  `SESSION` varchar(255) DEFAULT NULL,
  `USER_ID` int(11) DEFAULT NULL,
  PRIMARY KEY (`SESS_ID`),
  KEY `FK53BFD09DA2BFA1FB` (`USER_ID`),
  CONSTRAINT `FK53BFD09DA2BFA1FB` FOREIGN KEY (`USER_ID`) REFERENCES `users` (`USER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

# Data exporting was unselected.


# Dumping structure for table etms.users
DROP TABLE IF EXISTS `users`;
CREATE TABLE IF NOT EXISTS `users` (
  `USER_ID` int(11) NOT NULL AUTO_INCREMENT,
  `AVAIL_SINCE` datetime DEFAULT NULL,
  `AVAIL_TILL` datetime DEFAULT NULL,
  `CITY` varchar(255) DEFAULT NULL,
  `COMPANY` varchar(255) DEFAULT NULL,
  `COUNTRY` varchar(255) DEFAULT NULL,
  `EMAIL` varchar(255) DEFAULT NULL,
  `EXTRA_ID` varchar(255) DEFAULT NULL,
  `FIRST_NAME` varchar(255) DEFAULT NULL,
  `LAST_NAME` varchar(255) DEFAULT NULL,
  `PASSWORD` varchar(255) DEFAULT NULL,
  `PHONE` varchar(12) DEFAULT NULL,
  `POSTAL_CODE` varchar(12) DEFAULT NULL,
  `STREET_ADDRESS` varchar(255) DEFAULT NULL,
  `USER_TYPE` int(11) DEFAULT NULL,
  PRIMARY KEY (`USER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

# Data exporting was unselected.
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
