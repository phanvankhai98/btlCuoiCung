-- MySQL dump 10.13  Distrib 8.0.22, for Win64 (x86_64)
--
-- Host: localhost    Database: db_thue_xe
-- ------------------------------------------------------
-- Server version	8.0.22

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `tblnguoi`
--

DROP TABLE IF EXISTS `tblnguoi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tblnguoi` (
  `id` int NOT NULL AUTO_INCREMENT,
  `ho` varchar(45) DEFAULT NULL,
  `ten` varchar(45) DEFAULT NULL,
  `dem` varchar(45) DEFAULT NULL,
  `ngaysinh` int DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `sdt` varchar(45) DEFAULT NULL,
  `ghichu` varchar(45) DEFAULT NULL,
  `username` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  `role` int DEFAULT NULL,
  `iddiachi` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `fk_tblnguoi_tbldiachi_idx` (`iddiachi`),
  CONSTRAINT `fk_tblnguoi_tbldiachi` FOREIGN KEY (`iddiachi`) REFERENCES `tbldiachi` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tblnguoi`
--

LOCK TABLES `tblnguoi` WRITE;
/*!40000 ALTER TABLE `tblnguoi` DISABLE KEYS */;
INSERT INTO `tblnguoi` VALUES (1,'phan','khai','van',20138410,'pvkha@gmail.com','0326556656','k','user','123456',1,1),(2,'phan','khai','van ',20130410,'oadad@gmail.com','0326548585','s',NULL,NULL,2,1),(3,'Nguyen','A','van',20130410,'skdjsd@gmail.com','0311546544','aa',NULL,NULL,2,1),(4,'Phan','K','K',20130410,'sdlk@gmail.com','0326548446','aa','',NULL,2,1),(19,'Van','Phan','Khaiiii',20130410,'skdj@gmail.com','12312332','sdsd',NULL,NULL,2,1),(20,'Van','Phan','Khaiiii',20130410,'skdj@gmail.com','12312332','sdsd',NULL,NULL,2,1),(21,'Van','Phan','Khaiiiiiiiii',20130410,'skdj@gmail.com','12312332','sdsd',NULL,NULL,2,1),(22,'Van','Phan','Khaiiiiiiiii',20130410,'skdj@gmail.com','12312332','sdsd',NULL,NULL,2,1),(23,'Van','Phan','Khaiiii',20130410,'skdj@gmail.com','12312332','sdsd',NULL,NULL,2,1),(24,'phan','khai','van',20130410,'ákjdk@gmail.com','01122121','kkkk',NULL,NULL,2,1);
/*!40000 ALTER TABLE `tblnguoi` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-01-06  0:58:37
