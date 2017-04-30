CREATE DATABASE  IF NOT EXISTS `app_db` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `app_db`;
-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: localhost    Database: app_db
-- ------------------------------------------------------
-- Server version	5.7.17-log

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
-- Table structure for table `baseidea`
--

DROP TABLE IF EXISTS `baseidea`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `baseidea` (
  `baseIdeaID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `stepID` int(10) unsigned NOT NULL,
  PRIMARY KEY (`baseIdeaID`),
  UNIQUE KEY `baseIdeaID_UNIQUE` (`baseIdeaID`),
  KEY `baseStep_idx` (`stepID`),
  CONSTRAINT `baseStep` FOREIGN KEY (`stepID`) REFERENCES `step` (`stepID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `baseidea`
--

LOCK TABLES `baseidea` WRITE;
/*!40000 ALTER TABLE `baseidea` DISABLE KEYS */;
INSERT INTO `baseidea` VALUES (1,1),(2,4);
/*!40000 ALTER TABLE `baseidea` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `categorytype`
--

DROP TABLE IF EXISTS `categorytype`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `categorytype` (
  `categoryID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `category` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`categoryID`),
  UNIQUE KEY `categoryID_UNIQUE` (`categoryID`),
  UNIQUE KEY `category_UNIQUE` (`category`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categorytype`
--

LOCK TABLES `categorytype` WRITE;
/*!40000 ALTER TABLE `categorytype` DISABLE KEYS */;
INSERT INTO `categorytype` VALUES (1,'Energie'),(2,'Intelligence artificielle'),(3,'Urbanisme');
/*!40000 ALTER TABLE `categorytype` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `idea`
--

DROP TABLE IF EXISTS `idea`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `idea` (
  `ideaID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `title` varchar(45) NOT NULL,
  `categoryID` int(10) unsigned NOT NULL,
  `description` mediumtext,
  `creationDate` date NOT NULL,
  `researcherID` int(10) unsigned NOT NULL,
  PRIMARY KEY (`ideaID`),
  UNIQUE KEY `ideaID_UNIQUE` (`ideaID`),
  KEY `categoryID_idx` (`categoryID`),
  KEY `researcherID_idx` (`researcherID`),
  CONSTRAINT `categoryID` FOREIGN KEY (`categoryID`) REFERENCES `categorytype` (`categoryID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `researcherID` FOREIGN KEY (`ideaID`) REFERENCES `researcher` (`researcherID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `idea`
--

LOCK TABLES `idea` WRITE;
/*!40000 ALTER TABLE `idea` DISABLE KEYS */;
INSERT INTO `idea` VALUES (1,'Batterie à rechargement instantané',1,'Elle se recharge en quelques secondes et a une autonomie de plusieurs jours !','2017-04-30',2),(2,'La ville du futur',3,'Une ville intelligente qui facilite la vie de ses habitants.','2017-04-30',3),(3,'Machine learning 2.0',2,'Une IA capable d\'apprendre de manière autonome !','2017-04-30',1);
/*!40000 ALTER TABLE `idea` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `post`
--

DROP TABLE IF EXISTS `post`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `post` (
  `postID` int(10) unsigned NOT NULL,
  `text` longtext,
  `date` datetime DEFAULT NULL,
  `researcherID` int(10) unsigned NOT NULL,
  `topicID` int(10) unsigned NOT NULL,
  PRIMARY KEY (`postID`),
  UNIQUE KEY `postID_UNIQUE` (`postID`),
  KEY `topicID_idx` (`topicID`),
  KEY `researcherIDFK_idx` (`researcherID`),
  CONSTRAINT `researcherIDFK` FOREIGN KEY (`researcherID`) REFERENCES `researcher` (`researcherID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `topicID` FOREIGN KEY (`topicID`) REFERENCES `topic` (`topicID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `post`
--

LOCK TABLES `post` WRITE;
/*!40000 ALTER TABLE `post` DISABLE KEYS */;
INSERT INTO `post` VALUES (1,'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras ut posuere ante. Praesent semper urna non felis rhoncus, quis vestibulum nulla sollicitudin. Vivamus consectetur diam ac accumsan tristique. Cras sit amet odio sed ante eleifend molestie. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Sed blandit, metus vitae ultricies ornare, neque erat aliquet ligula, non posuere dolor nisl in nisi. Pellentesque quis libero vulputate tellus fermentum rutrum sed sit amet nibh. Etiam nunc orci, semper.','2017-04-30 15:47:37',1,1),(2,'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras ut posuere ante. Praesent semper urna non felis rhoncus, quis vestibulum nulla sollicitudin. Vivamus consectetur diam ac accumsan tristique. Cras sit amet odio sed ante eleifend molestie. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Sed blandit, metus vitae ultricies ornare, neque erat aliquet ligula, non posuere dolor nisl in nisi. Pellentesque quis libero vulputate tellus fermentum rutrum sed sit amet nibh. Etiam nunc orci, semper.','2017-04-30 15:47:37',2,1),(3,'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras ut posuere ante. Praesent semper urna non felis rhoncus, quis vestibulum nulla sollicitudin. Vivamus consectetur diam ac accumsan tristique. Cras sit amet odio sed ante eleifend molestie. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Sed blandit, metus vitae ultricies ornare, neque erat aliquet ligula, non posuere dolor nisl in nisi. Pellentesque quis libero vulputate tellus fermentum rutrum sed sit amet nibh. Etiam nunc orci, semper.','2017-04-30 15:47:37',1,1),(4,'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras ut posuere ante. Praesent semper urna non felis rhoncus, quis vestibulum nulla sollicitudin. Vivamus consectetur diam ac accumsan tristique. Cras sit amet odio sed ante eleifend molestie. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Sed blandit, metus vitae ultricies ornare, neque erat aliquet ligula, non posuere dolor nisl in nisi. Pellentesque quis libero vulputate tellus fermentum rutrum sed sit amet nibh. Etiam nunc orci, semper.','2017-04-30 15:47:37',3,1),(5,'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras ut posuere ante. Praesent semper urna non felis rhoncus, quis vestibulum nulla sollicitudin. Vivamus consectetur diam ac accumsan tristique. Cras sit amet odio sed ante eleifend molestie. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Sed blandit, metus vitae ultricies ornare, neque erat aliquet ligula, non posuere dolor nisl in nisi. Pellentesque quis libero vulputate tellus fermentum rutrum sed sit amet nibh. Etiam nunc orci, semper.','2017-04-30 15:47:37',2,1),(6,'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras ut posuere ante. Praesent semper urna non felis rhoncus, quis vestibulum nulla sollicitudin. Vivamus consectetur diam ac accumsan tristique. Cras sit amet odio sed ante eleifend molestie. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Sed blandit, metus vitae ultricies ornare, neque erat aliquet ligula, non posuere dolor nisl in nisi. Pellentesque quis libero vulputate tellus fermentum rutrum sed sit amet nibh. Etiam nunc orci, semper.','2017-04-30 15:47:37',1,1),(7,'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras ut posuere ante. Praesent semper urna non felis rhoncus, quis vestibulum nulla sollicitudin. Vivamus consectetur diam ac accumsan tristique. Cras sit amet odio sed ante eleifend molestie. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Sed blandit, metus vitae ultricies ornare, neque erat aliquet ligula, non posuere dolor nisl in nisi. Pellentesque quis libero vulputate tellus fermentum rutrum sed sit amet nibh. Etiam nunc orci, semper.','2017-04-30 15:47:37',2,1),(8,'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras ut posuere ante. Praesent semper urna non felis rhoncus, quis vestibulum nulla sollicitudin. Vivamus consectetur diam ac accumsan tristique. Cras sit amet odio sed ante eleifend molestie. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Sed blandit, metus vitae ultricies ornare, neque erat aliquet ligula, non posuere dolor nisl in nisi. Pellentesque quis libero vulputate tellus fermentum rutrum sed sit amet nibh. Etiam nunc orci, semper.','2017-04-30 15:47:37',1,2),(9,'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras ut posuere ante. Praesent semper urna non felis rhoncus, quis vestibulum nulla sollicitudin. Vivamus consectetur diam ac accumsan tristique. Cras sit amet odio sed ante eleifend molestie. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Sed blandit, metus vitae ultricies ornare, neque erat aliquet ligula, non posuere dolor nisl in nisi. Pellentesque quis libero vulputate tellus fermentum rutrum sed sit amet nibh. Etiam nunc orci, semper.','2017-04-30 15:47:37',2,2),(10,'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras ut posuere ante. Praesent semper urna non felis rhoncus, quis vestibulum nulla sollicitudin. Vivamus consectetur diam ac accumsan tristique. Cras sit amet odio sed ante eleifend molestie. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Sed blandit, metus vitae ultricies ornare, neque erat aliquet ligula, non posuere dolor nisl in nisi. Pellentesque quis libero vulputate tellus fermentum rutrum sed sit amet nibh. Etiam nunc orci, semper.','2017-04-30 15:47:37',1,2),(11,'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras ut posuere ante. Praesent semper urna non felis rhoncus, quis vestibulum nulla sollicitudin. Vivamus consectetur diam ac accumsan tristique. Cras sit amet odio sed ante eleifend molestie. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Sed blandit, metus vitae ultricies ornare, neque erat aliquet ligula, non posuere dolor nisl in nisi. Pellentesque quis libero vulputate tellus fermentum rutrum sed sit amet nibh. Etiam nunc orci, semper.','2017-04-30 15:47:37',3,2),(12,'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras ut posuere ante. Praesent semper urna non felis rhoncus, quis vestibulum nulla sollicitudin. Vivamus consectetur diam ac accumsan tristique. Cras sit amet odio sed ante eleifend molestie. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Sed blandit, metus vitae ultricies ornare, neque erat aliquet ligula, non posuere dolor nisl in nisi. Pellentesque quis libero vulputate tellus fermentum rutrum sed sit amet nibh. Etiam nunc orci, semper.','2017-04-30 15:47:37',2,2),(13,'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras ut posuere ante. Praesent semper urna non felis rhoncus, quis vestibulum nulla sollicitudin. Vivamus consectetur diam ac accumsan tristique. Cras sit amet odio sed ante eleifend molestie. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Sed blandit, metus vitae ultricies ornare, neque erat aliquet ligula, non posuere dolor nisl in nisi. Pellentesque quis libero vulputate tellus fermentum rutrum sed sit amet nibh. Etiam nunc orci, semper.','2017-04-30 15:47:37',1,2),(14,'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras ut posuere ante. Praesent semper urna non felis rhoncus, quis vestibulum nulla sollicitudin. Vivamus consectetur diam ac accumsan tristique. Cras sit amet odio sed ante eleifend molestie. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Sed blandit, metus vitae ultricies ornare, neque erat aliquet ligula, non posuere dolor nisl in nisi. Pellentesque quis libero vulputate tellus fermentum rutrum sed sit amet nibh. Etiam nunc orci, semper.','2017-04-30 15:47:37',2,2),(15,'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras ut posuere ante. Praesent semper urna non felis rhoncus, quis vestibulum nulla sollicitudin. Vivamus consectetur diam ac accumsan tristique. Cras sit amet odio sed ante eleifend molestie. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Sed blandit, metus vitae ultricies ornare, neque erat aliquet ligula, non posuere dolor nisl in nisi. Pellentesque quis libero vulputate tellus fermentum rutrum sed sit amet nibh. Etiam nunc orci, semper.','2017-04-30 15:47:37',1,3),(16,'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras ut posuere ante. Praesent semper urna non felis rhoncus, quis vestibulum nulla sollicitudin. Vivamus consectetur diam ac accumsan tristique. Cras sit amet odio sed ante eleifend molestie. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Sed blandit, metus vitae ultricies ornare, neque erat aliquet ligula, non posuere dolor nisl in nisi. Pellentesque quis libero vulputate tellus fermentum rutrum sed sit amet nibh. Etiam nunc orci, semper.','2017-04-30 15:47:37',2,3),(17,'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras ut posuere ante. Praesent semper urna non felis rhoncus, quis vestibulum nulla sollicitudin. Vivamus consectetur diam ac accumsan tristique. Cras sit amet odio sed ante eleifend molestie. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Sed blandit, metus vitae ultricies ornare, neque erat aliquet ligula, non posuere dolor nisl in nisi. Pellentesque quis libero vulputate tellus fermentum rutrum sed sit amet nibh. Etiam nunc orci, semper.','2017-04-30 15:47:37',1,3),(18,'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras ut posuere ante. Praesent semper urna non felis rhoncus, quis vestibulum nulla sollicitudin. Vivamus consectetur diam ac accumsan tristique. Cras sit amet odio sed ante eleifend molestie. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Sed blandit, metus vitae ultricies ornare, neque erat aliquet ligula, non posuere dolor nisl in nisi. Pellentesque quis libero vulputate tellus fermentum rutrum sed sit amet nibh. Etiam nunc orci, semper.','2017-04-30 15:47:37',3,3),(19,'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras ut posuere ante. Praesent semper urna non felis rhoncus, quis vestibulum nulla sollicitudin. Vivamus consectetur diam ac accumsan tristique. Cras sit amet odio sed ante eleifend molestie. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Sed blandit, metus vitae ultricies ornare, neque erat aliquet ligula, non posuere dolor nisl in nisi. Pellentesque quis libero vulputate tellus fermentum rutrum sed sit amet nibh. Etiam nunc orci, semper.','2017-04-30 15:47:37',2,3),(20,'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras ut posuere ante. Praesent semper urna non felis rhoncus, quis vestibulum nulla sollicitudin. Vivamus consectetur diam ac accumsan tristique. Cras sit amet odio sed ante eleifend molestie. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Sed blandit, metus vitae ultricies ornare, neque erat aliquet ligula, non posuere dolor nisl in nisi. Pellentesque quis libero vulputate tellus fermentum rutrum sed sit amet nibh. Etiam nunc orci, semper.','2017-04-30 15:47:37',1,3),(21,'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras ut posuere ante. Praesent semper urna non felis rhoncus, quis vestibulum nulla sollicitudin. Vivamus consectetur diam ac accumsan tristique. Cras sit amet odio sed ante eleifend molestie. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Sed blandit, metus vitae ultricies ornare, neque erat aliquet ligula, non posuere dolor nisl in nisi. Pellentesque quis libero vulputate tellus fermentum rutrum sed sit amet nibh. Etiam nunc orci, semper.','2017-04-30 15:47:37',2,3),(22,'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras ut posuere ante. Praesent semper urna non felis rhoncus, quis vestibulum nulla sollicitudin. Vivamus consectetur diam ac accumsan tristique. Cras sit amet odio sed ante eleifend molestie. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Sed blandit, metus vitae ultricies ornare, neque erat aliquet ligula, non posuere dolor nisl in nisi. Pellentesque quis libero vulputate tellus fermentum rutrum sed sit amet nibh. Etiam nunc orci, semper.','2017-04-30 15:47:37',3,4),(23,'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras ut posuere ante. Praesent semper urna non felis rhoncus, quis vestibulum nulla sollicitudin. Vivamus consectetur diam ac accumsan tristique. Cras sit amet odio sed ante eleifend molestie. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Sed blandit, metus vitae ultricies ornare, neque erat aliquet ligula, non posuere dolor nisl in nisi. Pellentesque quis libero vulputate tellus fermentum rutrum sed sit amet nibh. Etiam nunc orci, semper.','2017-04-30 15:47:37',2,4),(24,'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras ut posuere ante. Praesent semper urna non felis rhoncus, quis vestibulum nulla sollicitudin. Vivamus consectetur diam ac accumsan tristique. Cras sit amet odio sed ante eleifend molestie. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Sed blandit, metus vitae ultricies ornare, neque erat aliquet ligula, non posuere dolor nisl in nisi. Pellentesque quis libero vulputate tellus fermentum rutrum sed sit amet nibh. Etiam nunc orci, semper.','2017-04-30 15:47:37',1,4),(25,'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras ut posuere ante. Praesent semper urna non felis rhoncus, quis vestibulum nulla sollicitudin. Vivamus consectetur diam ac accumsan tristique. Cras sit amet odio sed ante eleifend molestie. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Sed blandit, metus vitae ultricies ornare, neque erat aliquet ligula, non posuere dolor nisl in nisi. Pellentesque quis libero vulputate tellus fermentum rutrum sed sit amet nibh. Etiam nunc orci, semper.','2017-04-30 15:47:37',2,4),(26,'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras ut posuere ante. Praesent semper urna non felis rhoncus, quis vestibulum nulla sollicitudin. Vivamus consectetur diam ac accumsan tristique. Cras sit amet odio sed ante eleifend molestie. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Sed blandit, metus vitae ultricies ornare, neque erat aliquet ligula, non posuere dolor nisl in nisi. Pellentesque quis libero vulputate tellus fermentum rutrum sed sit amet nibh. Etiam nunc orci, semper.','2017-04-30 15:47:37',3,4),(27,'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras ut posuere ante. Praesent semper urna non felis rhoncus, quis vestibulum nulla sollicitudin. Vivamus consectetur diam ac accumsan tristique. Cras sit amet odio sed ante eleifend molestie. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Sed blandit, metus vitae ultricies ornare, neque erat aliquet ligula, non posuere dolor nisl in nisi. Pellentesque quis libero vulputate tellus fermentum rutrum sed sit amet nibh. Etiam nunc orci, semper.','2017-04-30 15:47:37',1,4),(28,'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras ut posuere ante. Praesent semper urna non felis rhoncus, quis vestibulum nulla sollicitudin. Vivamus consectetur diam ac accumsan tristique. Cras sit amet odio sed ante eleifend molestie. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Sed blandit, metus vitae ultricies ornare, neque erat aliquet ligula, non posuere dolor nisl in nisi. Pellentesque quis libero vulputate tellus fermentum rutrum sed sit amet nibh. Etiam nunc orci, semper.','2017-04-30 15:47:37',3,4),(29,'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras ut posuere ante. Praesent semper urna non felis rhoncus, quis vestibulum nulla sollicitudin. Vivamus consectetur diam ac accumsan tristique. Cras sit amet odio sed ante eleifend molestie. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Sed blandit, metus vitae ultricies ornare, neque erat aliquet ligula, non posuere dolor nisl in nisi. Pellentesque quis libero vulputate tellus fermentum rutrum sed sit amet nibh. Etiam nunc orci, semper.','2017-04-30 15:47:37',1,4),(30,'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras ut posuere ante. Praesent semper urna non felis rhoncus, quis vestibulum nulla sollicitudin. Vivamus consectetur diam ac accumsan tristique. Cras sit amet odio sed ante eleifend molestie. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Sed blandit, metus vitae ultricies ornare, neque erat aliquet ligula, non posuere dolor nisl in nisi. Pellentesque quis libero vulputate tellus fermentum rutrum sed sit amet nibh. Etiam nunc orci, semper.','2017-04-30 15:47:37',3,4),(31,'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras ut posuere ante. Praesent semper urna non felis rhoncus, quis vestibulum nulla sollicitudin. Vivamus consectetur diam ac accumsan tristique. Cras sit amet odio sed ante eleifend molestie. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Sed blandit, metus vitae ultricies ornare, neque erat aliquet ligula, non posuere dolor nisl in nisi. Pellentesque quis libero vulputate tellus fermentum rutrum sed sit amet nibh. Etiam nunc orci, semper.','2017-04-30 15:47:37',2,4),(32,'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras ut posuere ante. Praesent semper urna non felis rhoncus, quis vestibulum nulla sollicitudin. Vivamus consectetur diam ac accumsan tristique. Cras sit amet odio sed ante eleifend molestie. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Sed blandit, metus vitae ultricies ornare, neque erat aliquet ligula, non posuere dolor nisl in nisi. Pellentesque quis libero vulputate tellus fermentum rutrum sed sit amet nibh. Etiam nunc orci, semper.','2017-04-30 15:47:37',3,4),(33,'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras ut posuere ante. Praesent semper urna non felis rhoncus, quis vestibulum nulla sollicitudin. Vivamus consectetur diam ac accumsan tristique. Cras sit amet odio sed ante eleifend molestie. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Sed blandit, metus vitae ultricies ornare, neque erat aliquet ligula, non posuere dolor nisl in nisi. Pellentesque quis libero vulputate tellus fermentum rutrum sed sit amet nibh. Etiam nunc orci, semper.','2017-04-30 15:47:37',2,4),(34,'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras ut posuere ante. Praesent semper urna non felis rhoncus, quis vestibulum nulla sollicitudin. Vivamus consectetur diam ac accumsan tristique. Cras sit amet odio sed ante eleifend molestie. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Sed blandit, metus vitae ultricies ornare, neque erat aliquet ligula, non posuere dolor nisl in nisi. Pellentesque quis libero vulputate tellus fermentum rutrum sed sit amet nibh. Etiam nunc orci, semper.','2017-04-30 15:47:37',1,4),(35,'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras ut posuere ante. Praesent semper urna non felis rhoncus, quis vestibulum nulla sollicitudin. Vivamus consectetur diam ac accumsan tristique. Cras sit amet odio sed ante eleifend molestie. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Sed blandit, metus vitae ultricies ornare, neque erat aliquet ligula, non posuere dolor nisl in nisi. Pellentesque quis libero vulputate tellus fermentum rutrum sed sit amet nibh. Etiam nunc orci, semper.','2017-04-30 15:47:37',2,4);
/*!40000 ALTER TABLE `post` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `product` (
  `productID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `price` double DEFAULT NULL,
  `availability` tinyint(1) DEFAULT NULL,
  `stepID` int(10) unsigned NOT NULL,
  PRIMARY KEY (`productID`),
  UNIQUE KEY `productID_UNIQUE` (`productID`),
  KEY `prodStep_idx` (`stepID`),
  CONSTRAINT `prodStep` FOREIGN KEY (`stepID`) REFERENCES `step` (`stepID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `prototype`
--

DROP TABLE IF EXISTS `prototype`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `prototype` (
  `prototypeID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `market` longtext,
  `resources` longtext,
  `results` longtext,
  `stepID` int(10) unsigned NOT NULL,
  PRIMARY KEY (`prototypeID`),
  UNIQUE KEY `prototypeID_UNIQUE` (`prototypeID`),
  KEY `protoStep_idx` (`stepID`),
  CONSTRAINT `protoStep` FOREIGN KEY (`stepID`) REFERENCES `step` (`stepID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `prototype`
--

LOCK TABLES `prototype` WRITE;
/*!40000 ALTER TABLE `prototype` DISABLE KEYS */;
INSERT INTO `prototype` VALUES (1,'Lyon','Financement par la ville de Lyon et la BCI','',3);
/*!40000 ALTER TABLE `prototype` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `researcher`
--

DROP TABLE IF EXISTS `researcher`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `researcher` (
  `researcherID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `surname` varchar(45) NOT NULL,
  `username` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `password` varchar(64) NOT NULL,
  PRIMARY KEY (`researcherID`),
  UNIQUE KEY `researcherID_UNIQUE` (`researcherID`),
  UNIQUE KEY `username_UNIQUE` (`username`),
  UNIQUE KEY `email_UNIQUE` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `researcher`
--

LOCK TABLES `researcher` WRITE;
/*!40000 ALTER TABLE `researcher` DISABLE KEYS */;
INSERT INTO `researcher` VALUES (1,'dupont','jean','dupdup','jean.dupont@email.com','9302C614100D901BFDA67E8B6C6FF447D900636A374FA9A7F47E8D70FCE98836'),(2,'martin','alfred','fredou','alfred.martin@email.com','CF89E07EFE22B39C52534997D4213AA9CDDC4DBEE05F8F5C20B9CFD31BD96BFE'),(3,'rex','daniel','dan','daniel.rex@email.com','5CCB0720553EB7EB93079D3CFA395A930FF8F0E13F2C1BBB60FB8894C0626E16');
/*!40000 ALTER TABLE `researcher` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `simulation`
--

DROP TABLE IF EXISTS `simulation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `simulation` (
  `simulationID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `results` longtext,
  `stepID` int(10) unsigned NOT NULL,
  PRIMARY KEY (`simulationID`),
  UNIQUE KEY `simulationID_UNIQUE` (`simulationID`),
  KEY `simuStep_idx` (`stepID`),
  CONSTRAINT `simuStep` FOREIGN KEY (`stepID`) REFERENCES `step` (`stepID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `simulation`
--

LOCK TABLES `simulation` WRITE;
/*!40000 ALTER TABLE `simulation` DISABLE KEYS */;
INSERT INTO `simulation` VALUES (1,'',2);
/*!40000 ALTER TABLE `simulation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `statustype`
--

DROP TABLE IF EXISTS `statustype`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `statustype` (
  `statusID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `status` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`statusID`),
  UNIQUE KEY `statusID_UNIQUE` (`statusID`),
  UNIQUE KEY `status_UNIQUE` (`status`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `statustype`
--

LOCK TABLES `statustype` WRITE;
/*!40000 ALTER TABLE `statustype` DISABLE KEYS */;
INSERT INTO `statustype` VALUES (3,'Abandonné'),(1,'En cours'),(2,'Terminé');
/*!40000 ALTER TABLE `statustype` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `step`
--

DROP TABLE IF EXISTS `step`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `step` (
  `stepID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `creationDate` date NOT NULL,
  `title` varchar(45) NOT NULL,
  `description` longtext,
  `progression` double NOT NULL,
  `ideaID` int(10) unsigned NOT NULL,
  `statusID` int(10) unsigned NOT NULL,
  PRIMARY KEY (`stepID`),
  UNIQUE KEY `stepID_UNIQUE` (`stepID`),
  KEY `ideaID_idx` (`ideaID`),
  KEY `statusID_idx` (`statusID`),
  CONSTRAINT `ideaID` FOREIGN KEY (`ideaID`) REFERENCES `idea` (`ideaID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `statusIDFK` FOREIGN KEY (`statusID`) REFERENCES `statustype` (`statusID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `step`
--

LOCK TABLES `step` WRITE;
/*!40000 ALTER TABLE `step` DISABLE KEYS */;
INSERT INTO `step` VALUES (1,'2017-04-30','Lancement du projet','Brainstorming et recherche de financement',30,1,1),(2,'2016-12-04','Tests des algorithmes','A l\'aide de logiciels de simulation, nous testons nos algorithmes d\'apprentissage',90,3,1),(3,'2016-09-21','Experimentation à Lyon','Un arrondissement de la ville de Lyon nous a permis de réaliser des premiers tests',60,2,1),(4,'2016-07-14','Présentation des algortihmes','Explication des principaux algortihmes utilisés',100,3,2);
/*!40000 ALTER TABLE `step` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `topic`
--

DROP TABLE IF EXISTS `topic`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `topic` (
  `topicID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `locked` tinyint(1) DEFAULT NULL,
  `creationDate` datetime DEFAULT NULL,
  `stepID` int(10) unsigned NOT NULL,
  PRIMARY KEY (`topicID`),
  UNIQUE KEY `topicID_UNIQUE` (`topicID`),
  KEY `stepID_idx` (`stepID`),
  CONSTRAINT `stepID` FOREIGN KEY (`stepID`) REFERENCES `step` (`stepID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `topic`
--

LOCK TABLES `topic` WRITE;
/*!40000 ALTER TABLE `topic` DISABLE KEYS */;
INSERT INTO `topic` VALUES (1,0,'2017-04-30 15:12:01',1),(2,0,'2016-12-04 14:45:45',2),(3,0,'2016-09-21 09:13:12',3),(4,1,'2016-07-14 11:02:26',4);
/*!40000 ALTER TABLE `topic` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-04-30 15:48:58
