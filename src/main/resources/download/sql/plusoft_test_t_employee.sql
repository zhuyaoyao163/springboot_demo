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
-- Table structure for table `t_employee`
--

DROP TABLE IF EXISTS `t_employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_employee` (
  `id` varchar(50) NOT NULL DEFAULT '' COMMENT '员工编号',
  `loginname` varchar(50) DEFAULT NULL COMMENT '帐号',
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
  `email` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='InnoDB free: 6144 kB; InnoDB free: 7168 kB; InnoDB free: 7168 kB';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_employee`
--

LOCK TABLES `t_employee` WRITE;
/*!40000 ALTER TABLE `t_employee` DISABLE KEYS */;
INSERT INTO `t_employee` VALUES ('8197fb45-2b60-4309-820c-e70824fc9b33','zm@163.com','张明',27,'1983-01-13 00:00:00','cw','cw2',1,0,'3839','2','','','爱好足球','贵州财经大学','2012-01-31 10:50:12','zm@163.com'),('b3d3d2b2-460a-470e-a33c-aff1c8d8a652','sww@163.com','宋蔚伟',25,'1987-01-21 00:00:00','sc','sc3',1,0,'3681','2','','','爱好篮球','天津科技大学','2012-01-31 10:53:35','sww@163.com'),('410c0185-3c9c-44ec-b9fb-f5a856013157','cyj@163.com','陈英杰',25,'1987-01-21 00:00:00','sc','sc3',1,0,'3681','2','','','','南京审计学院','2012-01-31 10:53:55','cyj@qq.com'),('70b7f3d2-b5d3-413f-b3ae-d56e07fbe5fe','zw@hotmail.com','张伟',31,'1981-01-14 00:00:00','rs','rs2',1,1,'4760','2','','','','南京工业大学','2012-01-31 11:04:18','zw@hotmail.com'),('ceb1ab63-c0c6-40fb-a481-65ed70b9e2a2','huang8373268@qq.com','黄磊',37,NULL,'sc','sc2',2,1,'7398','2','','','','金陵科技学院','2012-01-31 11:10:36','huang8373268@qq.com'),('20ac24f7-a34c-4f12-89f0-91d65b2ddfa9','xucc198712@qq.com','徐承承',27,'1985-07-17 00:00:00','js','js2',2,0,'4373','2','','','','南京邮电学院','2012-01-31 13:28:51','xucc198712@qq.com'),('d6fb5410-adde-46a9-9d2b-dee99c64a83d','xzz@163.com','谢忠哲',25,'1987-10-07 00:00:00','js','js3',2,0,'3860','2','','','','宁波工程大学','2012-01-31 13:28:34','xzz@163.com'),('ac3c3166-e677-45a5-9d1b-da4f09d6fc2a','zhoulan2010@hotmail.com','周兰',34,'1978-12-15 00:00:00','rs','rs1',2,1,'6580','3','','','','南京理工大学','2012-01-31 13:28:33','zhoulan2010@hotmail.com'),('61a6943f-990e-4169-b6a0-bed9bdc42a5f','xiaoqian18392342@qq.com','陈晓倩',24,'1988-11-18 00:00:00','sc','sc3',2,0,'3000','2','','','','南京信息工程大学','2012-01-31 13:28:31','xiaoqian18392342@qq.com'),('54b12a07-1f7d-4616-b3e9-9dcc465a5f33','13625147852@163.com','张鹏楠',25,'1987-06-12 00:00:00','js','js3',1,0,'3230','2','','','','南京邮电学院','2012-01-31 14:04:24',NULL),('b0171c0f-5064-4975-9f54-ebf28666aca6','jan3844@gmail.com','沈臻妍',25,'1987-03-17 00:00:00','rs','rs2',2,0,'3400','2','','','','浙江理工大学','2012-01-31 13:28:31','jan3844@gmail.com'),('9252b4a2-8000-4b3e-b29a-ac7849163ca2','djf19830326@qq.com','杜鉴锋',28,'1984-11-08 00:00:00','js','js2',1,1,'5300','2','','','','南京理工大学','2012-01-31 13:28:29','djf19830326@qq.com'),('8cb7e27c-ebab-48b5-bf83-67f8294e8797','shcheng@163.com','施华成',30,'1982-05-04 00:00:00','sc','sc2',2,1,'5600','2','','','','南京晓庄学院','2012-01-31 13:28:28','shcheng@163.com'),('7ef2fc41-27b2-4991-9134-189f95d76c42','hk2006@qq.com','黄凯',24,'1988-01-28 00:00:00','sc','sc3',1,0,'2900','2','','','','湖南科技大学','2012-01-31 13:28:27','hk2006@qq.com'),('a817ca24-ede0-4932-8455-b1e86eb7772d','wl19861219@163.com','王岚',25,'1987-08-19 00:00:00','sc','sc3',2,0,'3000','2','','','','南京审计学院','2012-01-31 13:28:26','wl19861219@163.com'),('b4366fb3-fb9c-4244-b3b6-c56de0c70cde','tangyue@gmail.com','唐岳',35,'1977-06-21 00:00:00','sc','sc1',1,1,'6300','2','','','','金陵科技大学','2012-01-31 13:28:26','tangyue@gmail.com'),('7cc225c6-2673-4993-ab02-288e15fc351b','wss2005@qq.com','王珊珊',27,'1985-03-12 00:00:00','js','js4',2,1,'3700','2','','','','南京审计学院','2012-01-31 11:10:47','wss2005@qq.com'),('a46d28db-c484-4e58-9076-166cb957a152','19880141x@qq.com','薛乃馨',25,'1987-01-20 00:00:00','cw','cw3',2,0,'3100','2','','','','合肥学院','2012-01-31 11:10:47','19880141x@qq.com'),('beb61bb1-9c6c-4c93-8d82-ab784cc00b27','wwy@yahoo.com','吴蔚一',28,'1984-06-12 00:00:00','js','js4',1,1,'4320','2','','','','铜陵学院','2012-01-31 11:10:47','wwy@yahoo.com'),('c95c8c42-9fa9-4188-9a6e-0cb676d824e5','jinyi1987@qq.com','金怡',26,'1986-04-14 00:00:00','js','js2',2,0,'3987','2','','','','江苏大学','2012-01-31 11:10:41','jinyi1987@qq.com'),('6f1da849-7fea-4fe1-ba33-71f7d4a6412d','ywq2000@163.com','袁维琦',27,'1985-01-09 00:00:00','js','js3',1,1,'4632','2','','','','三江学院','2012-01-31 11:10:40','ywq2000@163.com'),('626c9bd1-c99b-4969-9af8-58d216c2a49b','hongweishi@hotmail.com','施宏伟',37,'1975-10-16 00:00:00','js','js1',1,1,'6350','2','','','','江苏科技大学','2012-01-31 11:10:39','hongweishi@hotmail.com'),('17ac00b0-ea98-4865-b006-38a462ad201a','wj1983417@qq.com','王军',28,'1984-01-10 00:00:00','js','js2',1,1,'4850','2','','','','扬州大学','2012-01-31 11:10:38','wj1983417@qq.com'),('d4d7b386-5030-4ef8-882f-0aa869217121','chenjie1866@qq.com','陈杰',24,'1988-10-12 00:00:00','cw','cw3',1,0,'3000','2','','','','徐州工程大学','2012-01-31 11:10:38','chenjie1866@qq.com'),('27eb622c-6b1b-431e-9cf5-c82a71fea2d5','wkliang123@163.com','王克良',29,'1983-01-13 00:00:00','sc','sc2',1,1,'5300','2','','','','常熟理工大学','2012-01-31 11:10:37','wkliang123@163.com'),('77b8dd59-30a5-49cd-aaa2-095926770438','qinli3849087@qq.com','秦立',25,'1987-10-30 00:00:00','sc','sc3',2,1,'3000','2','','','','盐城师范学院','2012-01-31 11:10:37','qinli3849087@qq.com'),('c7643283-f8f8-4329-9f06-276168ffc192','zhangliang@163.com','张亮',25,'1987-05-21 00:00:00','sc','sc3',2,0,'3500','2','','','','宿州学院','2012-01-31 11:10:36','zhangliang@163.com'),('10a9f701-e0e0-4506-8937-e7c0ae8c4ae6','glq@qq.com','顾乐琴',24,'1988-01-13 00:00:00','js','js5',2,0,'2000','2','','','','上海交通大学','2012-01-31 11:10:33','glq@qq.com'),('5b68ce26-90d5-4df5-9fe3-cdbd2a325f23','gyj@qq.com','高英杰',26,'1986-10-15 00:00:00','cw','cw3',1,0,'3232','2','','','','上海外贸大学','2012-01-31 11:04:51','gyj@qq.com'),('7804c632-5959-4c8e-b7e7-633926efa8d9','zhou123@163.com','周捷',26,'1986-01-14 00:00:00','js','js3',1,0,'4600','2','','','','安徽农业大学','2012-01-31 11:04:46','zhou123@163.com'),('14e8841e-9b41-485c-9cd4-de77f8ba4cfa','zhuming@163.com','朱敏',24,'1988-01-13 00:00:00','js','js5',1,0,'2000','2','','','','汕头大学','2012-01-31 11:04:41','zhumin@163.com'),('ad62a74d-82b0-4ece-9d01-59965d60f86e','miaochun@qq.com','苗春',30,'1982-06-16 00:00:00','rs','rs1',2,1,'6000','2','','','','苏州大学','2012-01-31 11:04:35','miaochun@qq.com'),('12dfbe12-8a80-4bd6-9d88-f36b505408f8','wjm@qq.com','王佳美',27,'1985-07-25 00:00:00','sc','sc3',2,1,'3681','2','','','','河北科技大学','2012-01-31 10:53:40','wjm@qq.com'),('0ffa83ef-c0d2-4c9b-9c31-aa46b657c700','lili@163.com','李丽',25,'1987-06-25 00:00:00','js','js3',2,0,'3681','2','','','','上海工商学院','2012-01-31 10:53:52','lili@163.com'),('92c2a9fb-5da1-4de5-a516-0c4c96d82ffd','wq@163.com','王强',25,'1987-12-11 00:00:00','js','js2',1,0,'3201','2','','','','天津商业大学','2012-01-31 10:53:39','wq@163.com');
/*!40000 ALTER TABLE `t_employee` ENABLE KEYS */;
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
