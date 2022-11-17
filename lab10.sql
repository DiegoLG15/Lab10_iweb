CREATE DATABASE  IF NOT EXISTS `bi_corp_business` /*!40100 DEFAULT CHARACTER SET utf8mb3 */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `bi_corp_business`;
-- MySQL dump 10.13  Distrib 8.0.29, for Win64 (x86_64)
--
-- Host: localhost    Database: bi_corp_business
-- ------------------------------------------------------
-- Server version	8.0.29

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
-- Table structure for table `credentials`
--

DROP TABLE IF EXISTS `credentials`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `credentials` (
  `nro_documento` varchar(45) NOT NULL,
  `password` varchar(45) DEFAULT NULL,
  `hashedPassword` varchar(100) DEFAULT NULL,
  `tipoUsuario` tinyint DEFAULT NULL,
  PRIMARY KEY (`nro_documento`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `credentials`
--

LOCK TABLES `credentials` WRITE;
/*!40000 ALTER TABLE `credentials` DISABLE KEYS */;
INSERT INTO `credentials` VALUES ('234567','aeamano','e0281b9dceed1a31230382f596f05d03ba78532713a48412ffb17b381e459b3b',1),('70649549','mionks','c1dae0b5ec199cca1461b76c452cd27ca96ad69b8a874f17a9bbdf4f4db28697',2);
/*!40000 ALTER TABLE `credentials` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `jm_client_bii`
--

DROP TABLE IF EXISTS `jm_client_bii`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `jm_client_bii` (
  `g4093_nro_id` varchar(45) NOT NULL,
  `g4093_name` varchar(45) DEFAULT NULL,
  `g4093_age` varchar(45) DEFAULT NULL,
  `g4093_type` varchar(45) DEFAULT NULL,
  `g4093_documentType` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`g4093_nro_id`),
  UNIQUE KEY `g4093_nro_id_UNIQUE` (`g4093_nro_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `jm_client_bii`
--

LOCK TABLES `jm_client_bii` WRITE;
/*!40000 ALTER TABLE `jm_client_bii` DISABLE KEYS */;
INSERT INTO `jm_client_bii` VALUES ('09634122','Julio Carrion','25','N','DNI'),('12383943','Stuardo Lucho','32','N','DNI'),('20538856674','MEN GRAPH S.A.C.','NA','J','RUC'),('20552103816','AGROLIGHT PERU S.A.C','NA','J','RUC'),('53129384','Alonso Guevara','22','N','DNI'),('60741392','Brenda Tumbalobos','25','N','DNI'),('65749300','Manuel Yarlek','58','N','DNI'),('70312364','Hiroshi GIOTOKU','25','N','DNI'),('70649549','Carlos Minaya','22','N','DNI');
/*!40000 ALTER TABLE `jm_client_bii` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `jm_cotr_bis`
--

DROP TABLE IF EXISTS `jm_cotr_bis`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `jm_cotr_bis` (
  `g6789_contract` varchar(250) NOT NULL,
  `client_nro_id` varchar(45) NOT NULL,
  `g6789_currency` varchar(45) DEFAULT NULL,
  `G6789_status` tinyint DEFAULT NULL,
  `g6789_months` int DEFAULT NULL,
  PRIMARY KEY (`g6789_contract`),
  UNIQUE KEY `cod_nup_UNIQUE` (`g6789_contract`),
  KEY `fk_JM_COTR_BIS_JM_CLIENT_BII_idx` (`client_nro_id`),
  CONSTRAINT `fk_JM_COTR_BIS_JM_CLIENT_BII` FOREIGN KEY (`client_nro_id`) REFERENCES `jm_client_bii` (`g4093_nro_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `jm_cotr_bis`
--

LOCK TABLES `jm_cotr_bis` WRITE;
/*!40000 ALTER TABLE `jm_cotr_bis` DISABLE KEYS */;
INSERT INTO `jm_cotr_bis` VALUES ('0129','20552103816','PEN',2,6),('1221','12383943','PEN',1,3),('2446','70649549','PEN',2,6),('2834','20552103816','USD',1,3),('4342','53129384','PEN',1,5),('4543','60741392','PEN',1,4),('5345','20538856674','EUR',0,1),('5436','65749300','USD',1,2),('5678','09634122','USD',0,2),('5765','20538856674','USD',2,8),('7453','09634122','USD',2,4),('7765','70312364','EUR',2,3),('9243','20538856674','PEN',0,2),('9874','70649549','PEN',0,4);
/*!40000 ALTER TABLE `jm_cotr_bis` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `jm_values`
--

DROP TABLE IF EXISTS `jm_values`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `jm_values` (
  `idJM_VALUES` int NOT NULL AUTO_INCREMENT,
  `lgd_value` float DEFAULT NULL,
  `pd_value` float DEFAULT NULL,
  `recovery_rate` float DEFAULT NULL,
  `jm_cotr_bis_g6789_cod_nup` varchar(250) NOT NULL,
  PRIMARY KEY (`idJM_VALUES`,`jm_cotr_bis_g6789_cod_nup`),
  UNIQUE KEY `idJM_VALUES_UNIQUE` (`idJM_VALUES`),
  KEY `fk_jm_values_jm_cotr_bis1_idx` (`jm_cotr_bis_g6789_cod_nup`),
  CONSTRAINT `fk_jm_values_jm_cotr_bis1` FOREIGN KEY (`jm_cotr_bis_g6789_cod_nup`) REFERENCES `jm_cotr_bis` (`g6789_contract`)
) ENGINE=InnoDB AUTO_INCREMENT=104 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `jm_values`
--

LOCK TABLES `jm_values` WRITE;
/*!40000 ALTER TABLE `jm_values` DISABLE KEYS */;
INSERT INTO `jm_values` VALUES (90,0.343,0.231,0.456,'096341225678'),(91,0.124,0.321,0.654,'096341227453'),(92,0.988,0.312,0.538,'123839431221'),(93,0.524,0.341,0.454,'205388566745345'),(94,0.423,0.543,0.987,'205388566745765'),(95,0.423,0.342,0.879,'205388566749243'),(96,0.763,0.984,0.789,'205521038160129'),(97,0.634,0.767,0.876,'205521038162834'),(98,0.136,0.999,0.678,'531293844342'),(99,0.534,0.789,0.768,'607413924543'),(100,0.453,0.987,0.786,'657493005436'),(101,0.931,0.876,0.765,'703123647765'),(102,0.543,0.678,0.657,'706495492446'),(103,0.54,0.666,0.974,'706495499874');
/*!40000 ALTER TABLE `jm_values` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-11-16 19:50:43
