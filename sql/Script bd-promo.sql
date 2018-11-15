CREATE DATABASE  IF NOT EXISTS `bd-promo` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */;
USE `bd-promo`;
-- MySQL dump 10.13  Distrib 8.0.12, for Win64 (x86_64)
--
-- Host: localhost    Database: bd-promo
-- ------------------------------------------------------
-- Server version	8.0.12

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `activite`
--

DROP TABLE IF EXISTS `activite`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `activite` (
  `AC_ID` int(11) NOT NULL,
  `AC_NOM` varchar(100) NOT NULL,
  PRIMARY KEY (`AC_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `activite`
--

LOCK TABLES `activite` WRITE;
/*!40000 ALTER TABLE `activite` DISABLE KEYS */;
INSERT INTO `activite` VALUES (1,'Programmer en Java'),(2,'Ecouter les mouches'),(3,'Jouer au bilboquet'),(4,'Dormir pendant le cours'),(5,'Chercher un stage à Haiti'),(6,'Attendre les vacances'),(7,'Prendre le goûter'),(8,'Caresser le chat'),(9,'Ecouter de la musique'),(10,'Rien faire'),(11,'Jouer à Angular'),(12,'Rêver'),(13,'Travailler jour et nuit');
/*!40000 ALTER TABLE `activite` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `apprenant`
--

DROP TABLE IF EXISTS `apprenant`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `apprenant` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `prenom` varchar(50) NOT NULL,
  `nom` varchar(50) NOT NULL,
  `date` date DEFAULT NULL,
  `email` varchar(100) NOT NULL,
  `photo` varchar(100) DEFAULT NULL,
  `id_Region` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `Apprenant_Region_FK_idx` (`id_Region`),
  CONSTRAINT `Apprenant_Region_FK` FOREIGN KEY (`id_Region`) REFERENCES `region` (`RE_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `apprenant`
--

LOCK TABLES `apprenant` WRITE;
/*!40000 ALTER TABLE `apprenant` DISABLE KEYS */;
INSERT INTO `apprenant` VALUES (1,'Géraldine','Autrique','1970-12-27','geraldine.autrique@laposte.fr',NULL,2),(2,'Nicolas','Filine','1986-08-07','nicolas.filine@laposte.fr',NULL,1),(3,'Pierre','Gorce','1976-01-05','pierrexgorce@gmail.com',NULL,1),(4,'Samuel','Joblon','1973-10-18','samuel.joblon@gmail.com',NULL,1),(5,'Phoneprasong','Khamvongsa','1985-05-26','pomlao@hotmail.com',NULL,2),(6,'Vincent','Lebegue','1986-08-13','vincent.lebegue@labanquepostale.fr',NULL,1),(7,'Matthieu','Londeix','1981-05-19','matthieu.londeix@laposte.fr',NULL,3),(8,'Thomas','Longueville','1972-04-26','thomas.longueville@laposte.fr',NULL,2),(9,'Christine','Métivier','1980-04-29','christine.pereira@laposte.fr',NULL,1),(10,'Laurent','Picard','1972-05-23','laurent2.picard@laposte.fr',NULL,1),(11,'David','Pouline','1982-07-07','david.pouline@facteo.fr',NULL,2),(12,'Julien','Prod\'homme','1990-08-31','prodhomme.julien@gmail.com',NULL,1),(13,'Samuel','Sabot','1980-04-10','samuel.sabot@facteo.fr',NULL,2),(14,'Salvatore','Sancesario','1975-05-10','salvatore.sancesario@facteo.fr',NULL,1),(15,'David','Sylvestre','1986-07-06','david.sylvestre@mfacteur.fr',NULL,3),(16,'Cédric','Tressous','1984-08-08','cedric.tressous@gmail.com',NULL,3),(17,'Zébulon','Zébutruc','1977-03-13','zebulonzeb@free.fr',NULL,2);
/*!40000 ALTER TABLE `apprenant` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `avoir`
--

DROP TABLE IF EXISTS `avoir`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `avoir` (
  `id_Act` int(11) NOT NULL,
  `id_App` int(11) NOT NULL,
  PRIMARY KEY (`id_Act`,`id_App`),
  KEY `possede_Apprenant0_FK` (`id_App`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `avoir`
--

LOCK TABLES `avoir` WRITE;
/*!40000 ALTER TABLE `avoir` DISABLE KEYS */;
INSERT INTO `avoir` VALUES (1,1),(3,1),(5,1),(2,2),(4,2),(6,2),(7,3),(8,4),(10,4),(2,5),(4,5),(6,5),(1,6),(3,6),(5,6),(2,7),(4,7),(6,7),(8,8),(9,8),(10,8),(1,9),(3,9),(5,9),(11,10),(2,11),(4,11),(6,11),(1,12),(3,12),(5,12),(11,13),(8,14),(10,14),(1,15),(3,15),(5,15),(8,16);
/*!40000 ALTER TABLE `avoir` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `region`
--

DROP TABLE IF EXISTS `region`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `region` (
  `RE_ID` int(11) NOT NULL AUTO_INCREMENT,
  `RE_NOM` varchar(100) NOT NULL,
  PRIMARY KEY (`RE_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `region`
--

LOCK TABLES `region` WRITE;
/*!40000 ALTER TABLE `region` DISABLE KEYS */;
INSERT INTO `region` VALUES (1,'Ile de France'),(2,'Pays de Loire'),(3,'Aquitaine');
/*!40000 ALTER TABLE `region` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-11-15 12:31:22
