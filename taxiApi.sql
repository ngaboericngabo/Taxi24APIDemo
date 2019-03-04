-- MySQL dump 10.13  Distrib 5.5.11, for Win32 (x86)
--
-- Host: localhost    Database: taxiapi
-- ------------------------------------------------------
-- Server version	5.5.11

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
-- Table structure for table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hibernate_sequence`
--

LOCK TABLES `hibernate_sequence` WRITE;
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` VALUES (1);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `invoice`
--

DROP TABLE IF EXISTS `invoice`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `invoice` (
  `invoice_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `amount` bigint(20) NOT NULL,
  `bill_number` varchar(255) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `invoice_status` varchar(255) DEFAULT NULL,
  `trip_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`invoice_id`),
  KEY `FK95ma69hwycg3lwavfngnptww1` (`trip_id`),
  CONSTRAINT `FK95ma69hwycg3lwavfngnptww1` FOREIGN KEY (`trip_id`) REFERENCES `trip` (`trip_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `invoice`
--

LOCK TABLES `invoice` WRITE;
/*!40000 ALTER TABLE `invoice` DISABLE KEYS */;
INSERT INTO `invoice` VALUES (1,5000,'BILL1065',NULL,'Payed',2),(2,5000,'BILL1045','2019-03-03 17:11:49','Payed',2),(3,5000,'BILL1000','2019-03-03 17:25:01','Payed',2),(4,5000,'BILL1000','2019-03-04 16:18:53','Payed',2);
/*!40000 ALTER TABLE `invoice` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `trip`
--

DROP TABLE IF EXISTS `trip`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `trip` (
  `trip_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `comment` varchar(255) DEFAULT NULL,
  `finish_latutide` double NOT NULL,
  `finish_longitude` double NOT NULL,
  `finish_time_date` datetime DEFAULT NULL,
  `price` bigint(20) NOT NULL,
  `stat_latutide` double NOT NULL,
  `stat_longitude` double NOT NULL,
  `stat_time_date` datetime DEFAULT NULL,
  `trip_status_code` varchar(255) DEFAULT NULL,
  `driver_id` bigint(20) DEFAULT NULL,
  `reder_id` bigint(20) DEFAULT NULL,
  `created_time` datetime DEFAULT NULL,
  PRIMARY KEY (`trip_id`),
  KEY `FKrm4qy9h6bw4vj5p41bpr0jf5m` (`driver_id`),
  KEY `FKlwj4kjooxil688ddd539r1mxq` (`reder_id`),
  CONSTRAINT `FKlwj4kjooxil688ddd539r1mxq` FOREIGN KEY (`reder_id`) REFERENCES `users` (`user_id`),
  CONSTRAINT `FKrm4qy9h6bw4vj5p41bpr0jf5m` FOREIGN KEY (`driver_id`) REFERENCES `users` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `trip`
--

LOCK TABLES `trip` WRITE;
/*!40000 ALTER TABLE `trip` DISABLE KEYS */;
INSERT INTO `trip` VALUES (2,'This an new trip request',-1.97097,30.110868,'2019-03-04 16:18:52',5000,-1.97097,-1.97097,'2019-03-03 15:41:53','COMPLETED',20,13,'2019-03-03 15:41:53'),(3,'This an new trip request',-1.97097,30.110868,'2019-03-04 16:16:27',5000,-1.97097,-1.97097,'2019-03-03 15:47:02','ACTIVE',20,13,'2019-03-03 15:47:02'),(4,'This an new trip request',-1.97097,30.110868,'2019-03-04 16:17:24',1779,-1.97097,-1.97097,'2019-03-04 16:15:05','ACTIVE',20,13,'2019-03-04 16:15:05');
/*!40000 ALTER TABLE `trip` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_category`
--

DROP TABLE IF EXISTS `user_category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_category` (
  `user_category_id` bigint(20) NOT NULL,
  `user_category_code` varchar(255) DEFAULT NULL,
  `user_category_description` varchar(255) DEFAULT NULL,
  `user_category_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`user_category_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_category`
--

LOCK TABLES `user_category` WRITE;
/*!40000 ALTER TABLE `user_category` DISABLE KEYS */;
INSERT INTO `user_category` VALUES (1,'PASSENG','A passenger ','Passenger'),(2,'RIDER','A Rider','Rider'),(3,'DRIVER','A Driver','Drivers');
/*!40000 ALTER TABLE `user_category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `user_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `email` varchar(255) DEFAULT NULL,
  `fname` varchar(255) DEFAULT NULL,
  `lname` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `user_category_id` bigint(20) NOT NULL,
  PRIMARY KEY (`user_id`),
  KEY `FK2aur5earr4kseqljq9u2rry4h` (`user_category_id`),
  CONSTRAINT `FK2aur5earr4kseqljq9u2rry4h` FOREIGN KEY (`user_category_id`) REFERENCES `user_category` (`user_category_id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (13,'vava@crimsonlogic.com','vava','Uwase','07889765871',2),(14,'ericn@crimsonlogic.com','Ngabo','Eric','0722334455',1),(15,'able@crimsonlogic.com','Abel','Mutatina','0788998899',1),(16,'aime@crimsonlogic.com','Muhoza','Aime','078888775',1),(17,'jony@crimsonlogic.com','Kamanzi','John','07888899775',2),(18,'kazu@crimsonlogic.com','Kazungu','Nkubitoto','0784499775',2),(19,'richard@crimsonlogic.com','Richard','Munana','07844955575',2),(20,'emil@crimsonlogic.com','Emile','Kabano','07841155575',3),(21,'ramba@crimsonlogic.com','Modeste','Ramba','078415343575',3),(22,'mukunzi@crimsonlogic.com','Mahoro','Muhoza','07841333222',3);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users_availability`
--

DROP TABLE IF EXISTS `users_availability`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users_availability` (
  `available_driver_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `available_date_time` datetime DEFAULT NULL,
  `latitude` double NOT NULL,
  `longitude` double NOT NULL,
  `status` varchar(255) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`available_driver_id`),
  KEY `FKkw0eu6t6j4i7tl5qx0cfnowkd` (`user_id`),
  CONSTRAINT `FKkw0eu6t6j4i7tl5qx0cfnowkd` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users_availability`
--

LOCK TABLES `users_availability` WRITE;
/*!40000 ALTER TABLE `users_availability` DISABLE KEYS */;
INSERT INTO `users_availability` VALUES (1,'2019-03-03 12:20:04',-2.020722,30.114299,'AVAILABLE',20),(2,'2019-03-03 12:20:22',-1.989842,30.107436,'AVAILABLE',21),(3,'2019-03-04 13:23:38',-1.970525,30.104425,'OCCUPIED',22);
/*!40000 ALTER TABLE `users_availability` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-03-04 16:44:18
