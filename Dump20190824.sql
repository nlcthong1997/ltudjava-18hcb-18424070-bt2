-- MySQL dump 10.13  Distrib 5.7.27, for Linux (x86_64)
--
-- Host: localhost    Database: quanlysinhvien
-- ------------------------------------------------------
-- Server version	5.7.27-0ubuntu0.18.04.1

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
-- Table structure for table `points`
--

DROP TABLE IF EXISTS `points`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `points` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `className` varchar(45) DEFAULT NULL,
  `subjectCode` varchar(45) DEFAULT NULL,
  `idStudent` varchar(45) DEFAULT NULL,
  `midPoint` float DEFAULT NULL,
  `endPoint` float DEFAULT NULL,
  `otherPoint` float DEFAULT NULL,
  `totalPoint` float DEFAULT NULL,
  `nameStudent` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `points`
--

LOCK TABLES `points` WRITE;
/*!40000 ALTER TABLE `points` DISABLE KEYS */;
INSERT INTO `points` VALUES (1,'17HCB','CTT011','1742001',6,7,8,7,'Nguyen Van A'),(2,'17HCB','CTT012','1742001',4,5,8,6.25,'Nguyen Van A'),(3,'17HCB','CTT011','1742002',4,4,4,4,'Tran Van B'),(4,'17HCB','CTT012','1742002',8,8,8,8,'Tran Van B'),(5,'17HCB','CTT011','1742003',3,6,1,3.5,'Huynh Van C'),(7,'17HCB','CTT011','1742004',1,2,9,4,'Mai Van D'),(8,'17HCB','CTT012','1742004',5,5,5,5,'Mai Van D'),(9,'17HCB','CTT011','1742005',6,6,7,6.5,'Ho Thi E'),(10,'17HCB','CTT012','1742005',7,8,7,7.25,'Ho Thi E'),(11,'17HCB','CTT011','1842001',4,7,9,6.75,'Ly Van F');
/*!40000 ALTER TABLE `points` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `references`
--

DROP TABLE IF EXISTS `references`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `references` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '	',
  `fromDate` datetime DEFAULT NULL,
  `toDate` datetime DEFAULT NULL,
  `subjectCode` varchar(45) DEFAULT NULL,
  `subjectName` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `references`
--

LOCK TABLES `references` WRITE;
/*!40000 ALTER TABLE `references` DISABLE KEYS */;
/*!40000 ALTER TABLE `references` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `schedules`
--

DROP TABLE IF EXISTS `schedules`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `schedules` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `className` varchar(45) DEFAULT NULL,
  `subjectCode` varchar(45) DEFAULT NULL,
  `subjectName` varchar(45) DEFAULT NULL,
  `classroom` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `schedules`
--

LOCK TABLES `schedules` WRITE;
/*!40000 ALTER TABLE `schedules` DISABLE KEYS */;
INSERT INTO `schedules` VALUES (37,'17HCB','CTT011','Thiet Ke Giao Dien','C32'),(38,'17HCB','CTT012','Kiem Chung Phan Mem','C32');
/*!40000 ALTER TABLE `schedules` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `studentReference`
--

DROP TABLE IF EXISTS `studentReference`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `studentReference` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `idReference` int(11) DEFAULT NULL,
  `idStudent` varchar(45) DEFAULT NULL,
  `nameStudent` varchar(45) DEFAULT NULL,
  `pointReference` float DEFAULT NULL,
  `pointHope` float DEFAULT NULL,
  `reason` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `studentReference`
--

LOCK TABLES `studentReference` WRITE;
/*!40000 ALTER TABLE `studentReference` DISABLE KEYS */;
/*!40000 ALTER TABLE `studentReference` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `students`
--

DROP TABLE IF EXISTS `students`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `students` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '	',
  `className` varchar(45) DEFAULT NULL,
  `idStudent` varchar(45) DEFAULT NULL,
  `nameStudent` varchar(45) DEFAULT NULL,
  `sex` varchar(45) DEFAULT NULL,
  `identityCard` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `students`
--

LOCK TABLES `students` WRITE;
/*!40000 ALTER TABLE `students` DISABLE KEYS */;
INSERT INTO `students` VALUES (31,'17HCB','1742001','Nguyen Van A','Nam','123456789'),(32,'17HCB','1742002','Tran Van B','Nam','234567891'),(33,'17HCB','1742003','Huynh Van C','Nu','345678912'),(34,'17HCB','1742004','Mai Van D','Nam','456789123'),(35,'17HCB','1742005','Ho Thi E','Nu','567891234'),(36,'18HCB','1842001','Ly Van F','Nam','678912345'),(37,'18HCB','1842002','Chieu Van G','Nam','789123456'),(38,'18HCB','1842003','Tran Thi H','Nu','891234567'),(39,'18HCB','1842004','Mac Van T','Nam','912345678'),(40,'18HCB','1842005','Van ThiJ','Nu','987654321'),(41,'17HCB','1742006','Nguyen Thong','Nam','2811223344'),(42,'17HCB','1742007','Nguyen Hanh','Nu','12308710');
/*!40000 ALTER TABLE `students` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `subject_student`
--

DROP TABLE IF EXISTS `subject_student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `subject_student` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `idStudent` varchar(45) DEFAULT NULL,
  `subjectCode` varchar(45) DEFAULT NULL,
  `nameSubject` varchar(45) DEFAULT NULL,
  `classroom` varchar(45) DEFAULT NULL,
  `className` varchar(45) DEFAULT NULL,
  `type` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=256 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subject_student`
--

LOCK TABLES `subject_student` WRITE;
/*!40000 ALTER TABLE `subject_student` DISABLE KEYS */;
INSERT INTO `subject_student` VALUES (241,'1742001','CTT011','Thiet Ke Giao Dien','C32','17HCB',NULL),(242,'1742001','CTT012','Kiem Chung Phan Mem','C32','17HCB',NULL),(243,'1742002','CTT011','Thiet Ke Giao Dien','C32','17HCB',NULL),(244,'1742002','CTT012','Kiem Chung Phan Mem','C32','17HCB',NULL),(246,'1742003','CTT012','Kiem Chung Phan Mem','C32','17HCB',NULL),(247,'1742004','CTT011','Thiet Ke Giao Dien','C32','17HCB',NULL),(248,'1742004','CTT012','Kiem Chung Phan Mem','C32','17HCB',NULL),(249,'1742005','CTT011','Thiet Ke Giao Dien','C32','17HCB',NULL),(250,'1742005','CTT012','Kiem Chung Phan Mem','C32','17HCB',NULL),(255,'1842001','CTT011','Thiet Ke Giao Dien','C32','17HCB','18HCB');
/*!40000 ALTER TABLE `subject_student` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `username` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  `type` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'giaovu','giaovu','gv'),(2,'1742001','12345','sv');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-08-24  7:06:01
