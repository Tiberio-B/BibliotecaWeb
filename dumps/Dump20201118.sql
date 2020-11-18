-- MySQL dump 10.13  Distrib 8.0.22, for Win64 (x86_64)
--
-- Host: localhost    Database: bibliotecaweb
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
-- Table structure for table `autore`
--

DROP TABLE IF EXISTS `autore`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `autore` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `cognome` varchar(255) DEFAULT NULL,
  `ddn` datetime(6) DEFAULT NULL,
  `nome` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `autore`
--

LOCK TABLES `autore` WRITE;
/*!40000 ALTER TABLE `autore` DISABLE KEYS */;
INSERT INTO `autore` VALUES (1,'Castaldo','2000-11-27 23:00:00.000000','Salvatore'),(2,'Huaman Lopez','1972-08-02 23:00:00.000000','Rosalia'),(3,'Ortu','1960-07-18 23:00:00.000000','Imera'),(4,'Huaman Lopez','1980-05-05 22:00:00.000000','Telga'),(5,'Cenciarelli','1996-01-18 23:00:00.000000','Vanessa'),(6,'Pascucci','1980-03-06 23:00:00.000000','Morena'),(7,'Sipio','2002-10-26 22:00:00.000000','Satinka'),(8,'Tabane','1998-05-01 22:00:00.000000','Saverio'),(9,'Terracciano','2002-09-12 22:00:00.000000','Scott'),(10,'Balice','1950-03-03 23:00:00.000000','Enzo');
/*!40000 ALTER TABLE `autore` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `libro`
--

DROP TABLE IF EXISTS `libro`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `libro` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `genere` varchar(255) DEFAULT NULL,
  `titolo` varchar(255) DEFAULT NULL,
  `trama` varchar(255) DEFAULT NULL,
  `autore_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK60maulnp6ojrxqucl8qgusyg1` (`autore_id`),
  CONSTRAINT `FK60maulnp6ojrxqucl8qgusyg1` FOREIGN KEY (`autore_id`) REFERENCES `autore` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `libro`
--

LOCK TABLES `libro` WRITE;
/*!40000 ALTER TABLE `libro` DISABLE KEYS */;
INSERT INTO `libro` VALUES (1,'STORIOGRAFIA','Otobalu','trama',NULL),(2,'EPICA','Ubusepu','trama',NULL),(3,'SOCIALE','Ofegalu','trama',NULL),(4,'AVVENTURA','Idesagi','trama',8),(5,'DIARIO','Itinafi','trama',3),(6,'ROSA','Elacega','trama',NULL),(7,'EPISTOLARE','Imavogi','trama',NULL),(8,'EROTICO','Ovebetu','trama',7),(9,'EPICA','Olevevi','trama',10),(10,'ROSA','Iziguva','trama',7),(11,'POESIA','Icavuge','trama',NULL),(12,'FANTASCIENZA','Anusice','trama',NULL),(13,'STORIOGRAFIA','Orumulo','trama',NULL),(14,'FANTASCIENZA','Ivomame','trama',4),(15,'ROSA','Abusazo','trama',3),(16,'SOCIALE','Agomasa','trama',NULL),(17,'FORMAZIONE','Ogeluco','trama',NULL),(18,'EROTICO','Irosabo','trama',NULL),(19,'UMORISTICO','Etobiva','trama',NULL),(20,'FORMAZIONE','Acecata','trama',NULL),(21,'POESIA','Uvuloza','trama',NULL),(22,'FANTASCIENZA','Aciliro','trama',NULL),(23,'UMORISTICO','Enebaga','trama',NULL),(24,'STORICO','Avovilo','trama',10),(25,'ROSA','Apilazo','trama',3),(26,'FANTASCIENZA','Asucere','trama',NULL),(27,'SOCIALE','Umefeto','trama',2),(28,'FORMAZIONE','Asuvuce','trama',8),(29,'DIVULGATIVO','Elacebo','trama',1),(30,'EPICA','Ifidozu','trama',NULL);
/*!40000 ALTER TABLE `libro` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ruolo`
--

DROP TABLE IF EXISTS `ruolo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ruolo` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `codice` varchar(255) DEFAULT NULL,
  `descrizione` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ruolo`
--

LOCK TABLES `ruolo` WRITE;
/*!40000 ALTER TABLE `ruolo` DISABLE KEYS */;
INSERT INTO `ruolo` VALUES (1,'ADMIN_ROLE','amministratore'),(2,'GUEST_ROLE','guest'),(3,'CLASSIC_ROLE','classic');
/*!40000 ALTER TABLE `ruolo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `utente`
--

DROP TABLE IF EXISTS `utente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `utente` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `cognome` varchar(255) DEFAULT NULL,
  `nome` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `stato` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `utente`
--

LOCK TABLES `utente` WRITE;
/*!40000 ALTER TABLE `utente` DISABLE KEYS */;
INSERT INTO `utente` VALUES (1,'Bardi','Primula','password','NON_ATTIVO','Epenefa'),(2,'Giorgetti','Vasco','password','NON_ATTIVO','Ivomame'),(3,'Porcu','Luminosa','password','NON_ATTIVO','Elotupo'),(4,'Autalano','Ivan','password','NON_ATTIVO','Ibogucu'),(5,'De Rosa','Osvaldo','password','NON_ATTIVO','Utilelo'),(6,'Soldati','Stelio','password','NON_ATTIVO','Ecobose'),(7,'Tioni','Tullia','password','NON_ATTIVO','Olivuru'),(8,'Silvestri','Simone','password','NON_ATTIVO','Opesocu');
/*!40000 ALTER TABLE `utente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `utente_ruolo`
--

DROP TABLE IF EXISTS `utente_ruolo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `utente_ruolo` (
  `utente_id` bigint NOT NULL,
  `ruolo_id` bigint NOT NULL,
  PRIMARY KEY (`utente_id`,`ruolo_id`),
  KEY `FKtb317nv6nce9x7hklpom605xq` (`ruolo_id`),
  CONSTRAINT `FKnhivefye2ppafs5c3muckb7um` FOREIGN KEY (`utente_id`) REFERENCES `utente` (`id`),
  CONSTRAINT `FKtb317nv6nce9x7hklpom605xq` FOREIGN KEY (`ruolo_id`) REFERENCES `ruolo` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `utente_ruolo`
--

LOCK TABLES `utente_ruolo` WRITE;
/*!40000 ALTER TABLE `utente_ruolo` DISABLE KEYS */;
INSERT INTO `utente_ruolo` VALUES (1,1),(3,1),(4,1),(6,1),(7,1),(2,2),(3,2),(8,2),(2,3),(4,3),(7,3);
/*!40000 ALTER TABLE `utente_ruolo` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-11-18 15:56:06
