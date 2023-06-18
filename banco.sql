-- MySQL dump 10.13  Distrib 8.0.23, for Win64 (x86_64)
--
-- Host: localhost    Database: projeto
-- ------------------------------------------------------
-- Server version	8.0.23

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
-- Table structure for table `integrante`
--

DROP TABLE IF EXISTS `integrante`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `integrante` (
  `nick` varchar(20) NOT NULL,
  `posicao` varchar(20) NOT NULL,
  `pontuacao` int NOT NULL,
  `Time_nomeTime` varchar(30) NOT NULL,
  PRIMARY KEY (`nick`),
  KEY `fk_Integrante_Time1_idx` (`Time_nomeTime`),
  CONSTRAINT `fk_Integrante_Time1` FOREIGN KEY (`Time_nomeTime`) REFERENCES `time` (`nomeTime`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `integrante`
--

LOCK TABLES `integrante` WRITE;
/*!40000 ALTER TABLE `integrante` DISABLE KEYS */;
INSERT INTO `integrante` VALUES ('22nd may','Selva',60,'inatel'),('Aw5hdgvsdqoad','Atirador',60,'inatel3'),('Comunistaric','Suporte',50,'inatel2'),('Dualyty','Atirador',50,'inatel2'),('duclou','Suporte',60,'inatel3'),('Flip sid','Meio',30,'inatel2'),('Kami','Meio',80,'inatel3'),('Kev tft','Topo',60,'inatel3'),('Lelzika','Selva',0,'inatel3'),('phylore','Meio',60,'inatel'),('piva','Suporte',70,'inatel'),('ramborger','Atirador',60,'inatel'),('shi no hashira','Topo',60,'inatel'),('Treinador1','Treinador',0,'inatel'),('Treinador2','Treinador',10,'inatel2'),('Treinador3','Treinador',10,'inatel3'),('Xidex entregas','Topo',30,'inatel2'),('ZCinna','Selva',50,'inatel2');
/*!40000 ALTER TABLE `integrante` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `jogador`
--

DROP TABLE IF EXISTS `jogador`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `jogador` (
  `idJogador` int NOT NULL AUTO_INCREMENT,
  `elo` varchar(45) NOT NULL,
  `winr` varchar(30) DEFAULT NULL,
  `win` varchar(10) DEFAULT NULL,
  `lose` varchar(10) DEFAULT NULL,
  `Integrante_nick` varchar(20) NOT NULL,
  PRIMARY KEY (`idJogador`),
  KEY `fk_Jogador_Integrante1_idx` (`Integrante_nick`),
  CONSTRAINT `fk_Jogador_Integrante1` FOREIGN KEY (`Integrante_nick`) REFERENCES `integrante` (`nick`)
) ENGINE=InnoDB AUTO_INCREMENT=149 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `jogador`
--

LOCK TABLES `jogador` WRITE;
/*!40000 ALTER TABLE `jogador` DISABLE KEYS */;
INSERT INTO `jogador` VALUES (134,'Diamond 2','Win Ratio 55%','76W','62L','shi no hashira'),(135,'Diamond 2','Win Ratio 50%','125W','127L','22nd may'),(136,'Diamond 3','Win Ratio 50%','255W','254L','phylore'),(137,'Diamond 4','Win Ratio 43%','86W','113L','ramborger'),(138,'Master','Win Ratio 59%','105W','73L','piva'),(139,'Silver 2','Win Ratio 50%','35W','35L','Xidex entregas'),(140,'Platinum 4','Win Ratio 46%','78W','92L','ZCinna'),(141,'Silver 1','Win Ratio 53%','70W','62L','Flip sid'),(142,'Platinum 2','Win Ratio 51%','137W','134L','Dualyty'),(143,'Platinum 4','Win Ratio 56%','71W','56L','Comunistaric'),(144,'Diamond 3','Win Ratio 53%','123W','111L','Kev tft'),(145,'Unranked','','','','Lelzika'),(146,'Grandmaster','Win Ratio 52%','314W','286L','Kami'),(147,'Diamond 2','Win Ratio 54%','80W','67L','Aw5hdgvsdqoad');
/*!40000 ALTER TABLE `jogador` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `patrocionio`
--

DROP TABLE IF EXISTS `patrocionio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `patrocionio` (
  `marca` varchar(20) NOT NULL,
  `investimento` float NOT NULL,
  PRIMARY KEY (`marca`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `patrocionio`
--

LOCK TABLES `patrocionio` WRITE;
/*!40000 ALTER TABLE `patrocionio` DISABLE KEYS */;
INSERT INTO `patrocionio` VALUES ('pat1',10),('pat2',200),('pat3',300),('pat4',600),('pat5',300),('pat6',600);
/*!40000 ALTER TABLE `patrocionio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `patrocionio_has_time`
--

DROP TABLE IF EXISTS `patrocionio_has_time`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `patrocionio_has_time` (
  `Patrocionio_marca` varchar(20) NOT NULL,
  `Time_nomeTime` varchar(30) NOT NULL,
  PRIMARY KEY (`Patrocionio_marca`,`Time_nomeTime`),
  KEY `fk_Patrocionio_has_Time_Time1_idx` (`Time_nomeTime`),
  KEY `fk_Patrocionio_has_Time_Patrocionio_idx` (`Patrocionio_marca`),
  CONSTRAINT `fk_Patrocionio_has_Time_Patrocionio` FOREIGN KEY (`Patrocionio_marca`) REFERENCES `patrocionio` (`marca`),
  CONSTRAINT `fk_Patrocionio_has_Time_Time1` FOREIGN KEY (`Time_nomeTime`) REFERENCES `time` (`nomeTime`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `patrocionio_has_time`
--

LOCK TABLES `patrocionio_has_time` WRITE;
/*!40000 ALTER TABLE `patrocionio_has_time` DISABLE KEYS */;
/*!40000 ALTER TABLE `patrocionio_has_time` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `time`
--

DROP TABLE IF EXISTS `time`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `time` (
  `nomeTime` varchar(30) NOT NULL,
  PRIMARY KEY (`nomeTime`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `time`
--

LOCK TABLES `time` WRITE;
/*!40000 ALTER TABLE `time` DISABLE KEYS */;
INSERT INTO `time` VALUES ('inatel'),('inatel2'),('inatel3');
/*!40000 ALTER TABLE `time` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `treinador`
--

DROP TABLE IF EXISTS `treinador`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `treinador` (
  `idTreinador` int NOT NULL AUTO_INCREMENT,
  `idade` int NOT NULL,
  `titulos` int DEFAULT NULL,
  `Integrante_nick` varchar(20) NOT NULL,
  PRIMARY KEY (`idTreinador`),
  KEY `fk_Treinador_Integrante1_idx` (`Integrante_nick`),
  CONSTRAINT `fk_Treinador_Integrante1` FOREIGN KEY (`Integrante_nick`) REFERENCES `integrante` (`nick`)
) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `treinador`
--

LOCK TABLES `treinador` WRITE;
/*!40000 ALTER TABLE `treinador` DISABLE KEYS */;
INSERT INTO `treinador` VALUES (41,20,0,'Treinador1'),(42,21,1,'Treinador2'),(43,22,2,'Treinador3');
/*!40000 ALTER TABLE `treinador` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-06-17 23:06:42
