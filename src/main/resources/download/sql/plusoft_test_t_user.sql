-- MySQL dump 10.13  Distrib 5.6.23, for Win64 (x86_64)
--
-- Host: localhost    Database: plusoft_test
-- ------------------------------------------------------
-- Server version	5.6.17

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `t_user`
--

DROP TABLE IF EXISTS `t_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_user` (
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `login_name` varchar(50) DEFAULT NULL COMMENT '帐号',
  `pass_word` varchar(50) DEFAULT NULL COMMENT '密码',
  `name` varchar(50) DEFAULT NULL COMMENT '姓名',
  `age` int(11) DEFAULT NULL COMMENT '年龄(number)',
  `birthday` datetime DEFAULT NULL COMMENT '生日(datetime)',
  `dept_id` varchar(50) DEFAULT NULL COMMENT '部门(combobox)',
  `position` varchar(50) DEFAULT NULL COMMENT '职位(combobox)',
  `gender` int(11) DEFAULT NULL COMMENT '性别：1男；2女',
  `married` int(11) DEFAULT NULL COMMENT '0未婚；1已婚',
  `salary` varchar(20) DEFAULT NULL COMMENT '薪资',
  `educational` varchar(20) DEFAULT NULL COMMENT '学历',
  `country` varchar(20) DEFAULT NULL COMMENT '国家',
  `city` varchar(20) DEFAULT NULL COMMENT '城市',
  `remarks` varchar(2000) DEFAULT NULL COMMENT '备注',
  `school` varchar(20) DEFAULT NULL COMMENT '毕业学校',
  `createtime` datetime DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='InnoDB free: 6144 kB; InnoDB free: 7168 kB; InnoDB free: 7168 kB';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_user`
--

LOCK TABLES `t_user` WRITE;
/*!40000 ALTER TABLE `t_user` DISABLE KEYS */;
INSERT INTO `t_user` VALUES (1,'zm@163.com','123','张明',27,'1983-01-13 00:00:00','cw','cw2',1,0,'3839','2','','','爱好足球','贵州财经大学','2012-01-31 10:50:12','zm@163.com'),(2,'sww@163.com','123','宋蔚伟',25,'1987-01-21 00:00:00','sc','sc3',1,0,'3681','2','','','爱好篮球','天津科技大学','2012-01-31 10:53:35','sww@163.com'),(3,'cyj@163.com','123','陈英杰',25,'1987-01-21 00:00:00','sc','sc3',1,0,'3681','2','','','','南京审计学院','2012-01-31 10:53:55','cyj@qq.com'),(4,'zw@hotmail.com','123','张伟',31,'1981-01-14 00:00:00','rs','rs2',1,1,'4760','2','','','','南京工业大学','2012-01-31 11:04:18','zw@hotmail.com');
/*!40000 ALTER TABLE `t_user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-04-01 18:17:54
