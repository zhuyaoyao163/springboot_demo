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
-- Table structure for table `plus_file`
--

DROP TABLE IF EXISTS `plus_file`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `plus_file` (
  `id` varchar(50) NOT NULL DEFAULT '',
  `name` varchar(500) DEFAULT NULL,
  `type` varchar(50) DEFAULT NULL,
  `size` varchar(20) DEFAULT NULL,
  `url` varchar(300) DEFAULT NULL,
  `pid` varchar(50) DEFAULT NULL,
  `createdate` datetime DEFAULT NULL,
  `updatedate` datetime DEFAULT NULL,
  `folder` int(11) DEFAULT NULL,
  `num` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='InnoDB free: 7168 kB; InnoDB free: 7168 kB';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `plus_file`
--

LOCK TABLES `plus_file` WRITE;
/*!40000 ALTER TABLE `plus_file` DISABLE KEYS */;
INSERT INTO `plus_file` VALUES ('1','Files',NULL,'0',NULL,'-1',NULL,NULL,1,NULL),('10','Product icons',NULL,NULL,NULL,'3',NULL,NULL,1,NULL),('11','Description.rtf','rtf',NULL,NULL,'1',NULL,NULL,0,NULL),('12','n.txt','txt',NULL,NULL,'1',NULL,NULL,0,NULL),('13','o.txt','txt',NULL,NULL,'1',NULL,NULL,0,NULL),('14','file1.txt','txt',NULL,NULL,'2',NULL,NULL,0,NULL),('15','file2.txt','txt',NULL,NULL,'2',NULL,NULL,0,NULL),('16','file3.txt','txt',NULL,NULL,'3',NULL,NULL,0,NULL),('17','file4.txt','txt',NULL,NULL,'3',NULL,NULL,0,NULL),('18','file5.txt','txt',NULL,NULL,'4',NULL,NULL,0,NULL),('19','file6.txt','txt',NULL,NULL,'5',NULL,NULL,0,NULL),('2','Documents',NULL,NULL,NULL,'1',NULL,NULL,1,NULL),('20','file7.txt','txt',NULL,NULL,'6',NULL,NULL,0,NULL),('21','file8','txt',NULL,NULL,'7',NULL,NULL,0,NULL),('22','file9','txt',NULL,NULL,'8',NULL,NULL,0,NULL),('253','Files',NULL,'0',NULL,'-1',NULL,NULL,1,NULL),('3','Images',NULL,NULL,NULL,'1',NULL,NULL,1,NULL),('4','Music',NULL,NULL,NULL,'1',NULL,NULL,1,NULL),('5','System',NULL,NULL,NULL,'1',NULL,NULL,1,NULL),('6','Video',NULL,NULL,NULL,'1',NULL,NULL,1,NULL),('7','Projects',NULL,NULL,NULL,'2',NULL,NULL,1,NULL),('8','Reports',NULL,NULL,NULL,'2',NULL,NULL,1,NULL),('9','Employees',NULL,NULL,NULL,'3',NULL,NULL,1,NULL);
/*!40000 ALTER TABLE `plus_file` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-04-01 18:17:53
