-- MySQL dump 10.13  Distrib 5.7.19, for Win64 (x86_64)
--
-- Host: localhost    Database: sgpa
-- ------------------------------------------------------
-- Server version	5.7.19-log

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
-- Table structure for table `academia`
--

DROP TABLE IF EXISTS `academia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `academia` (
  `idAcademia` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(80) DEFAULT NULL,
  `direccion` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`idAcademia`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `academia`
--

LOCK TABLES `academia` WRITE;
/*!40000 ALTER TABLE `academia` DISABLE KEYS */;
/*!40000 ALTER TABLE `academia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `actividad`
--

DROP TABLE IF EXISTS `actividad`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `actividad` (
  `idActividad` int(11) NOT NULL AUTO_INCREMENT,
  `fecha` varchar(50) DEFAULT NULL,
  `hora_inicio` varchar(50) DEFAULT NULL,
  `hora_termina` varchar(50) DEFAULT NULL,
  `lugar` varchar(100) DEFAULT NULL,
  `idPlanDeTrabajo` int(11) DEFAULT NULL,
  PRIMARY KEY (`idActividad`),
  KEY `idPlanDeTrabajo` (`idPlanDeTrabajo`),
  CONSTRAINT `actividad_ibfk_1` FOREIGN KEY (`idPlanDeTrabajo`) REFERENCES `plan_de_trabajo` (`idPlanDeTrabajo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `actividad`
--

LOCK TABLES `actividad` WRITE;
/*!40000 ALTER TABLE `actividad` DISABLE KEYS */;
/*!40000 ALTER TABLE `actividad` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `avance_programatico`
--

DROP TABLE IF EXISTS `avance_programatico`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `avance_programatico` (
  `idAvance` int(11) NOT NULL AUTO_INCREMENT,
  `fecha_creacion` varchar(50) DEFAULT NULL,
  `ultima_modificacion` varchar(50) DEFAULT NULL,
  `url_servidor` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`idAvance`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `avance_programatico`
--

LOCK TABLES `avance_programatico` WRITE;
/*!40000 ALTER TABLE `avance_programatico` DISABLE KEYS */;
/*!40000 ALTER TABLE `avance_programatico` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `coordinador`
--

DROP TABLE IF EXISTS `coordinador`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `coordinador` (
  `numeroPersonal` int(150) NOT NULL,
  `idAcademia` int(11) DEFAULT NULL,
  `nombre` varchar(80) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`numeroPersonal`),
  KEY `idAcademia` (`idAcademia`),
  CONSTRAINT `coordinador_ibfk_1` FOREIGN KEY (`idAcademia`) REFERENCES `academia` (`idAcademia`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `coordinador`
--

LOCK TABLES `coordinador` WRITE;
/*!40000 ALTER TABLE `coordinador` DISABLE KEYS */;
/*!40000 ALTER TABLE `coordinador` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `curso`
--

DROP TABLE IF EXISTS `curso`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `curso` (
  `nrc` int(11) NOT NULL,
  `numeroPersonal` int(150) DEFAULT NULL,
  `idExperiencia` int(11) DEFAULT NULL,
  `periodo` varchar(50) DEFAULT NULL,
  `idPlan` int(11) DEFAULT NULL,
  `idAvance` int(11) DEFAULT NULL,
  PRIMARY KEY (`nrc`),
  KEY `numeroPersonal` (`numeroPersonal`),
  KEY `idExperiencia` (`idExperiencia`),
  KEY `idPlan` (`idPlan`),
  KEY `idAvance` (`idAvance`),
  CONSTRAINT `curso_ibfk_1` FOREIGN KEY (`numeroPersonal`) REFERENCES `docente` (`numeroPersonal`),
  CONSTRAINT `curso_ibfk_2` FOREIGN KEY (`idExperiencia`) REFERENCES `ee` (`idExperiencia`),
  CONSTRAINT `curso_ibfk_3` FOREIGN KEY (`idPlan`) REFERENCES `plan_de_curso` (`idPlan`),
  CONSTRAINT `curso_ibfk_4` FOREIGN KEY (`idAvance`) REFERENCES `avance_programatico` (`idAvance`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `curso`
--

LOCK TABLES `curso` WRITE;
/*!40000 ALTER TABLE `curso` DISABLE KEYS */;
/*!40000 ALTER TABLE `curso` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `docente`
--

DROP TABLE IF EXISTS `docente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `docente` (
  `numeroPersonal` int(150) NOT NULL,
  `nombre` varchar(80) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`numeroPersonal`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `docente`
--

LOCK TABLES `docente` WRITE;
/*!40000 ALTER TABLE `docente` DISABLE KEYS */;
/*!40000 ALTER TABLE `docente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ee`
--

DROP TABLE IF EXISTS `ee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ee` (
  `idExperiencia` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) DEFAULT NULL,
  `creditos` int(11) DEFAULT NULL,
  PRIMARY KEY (`idExperiencia`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ee`
--

LOCK TABLES `ee` WRITE;
/*!40000 ALTER TABLE `ee` DISABLE KEYS */;
/*!40000 ALTER TABLE `ee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `plan_de_curso`
--

DROP TABLE IF EXISTS `plan_de_curso`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `plan_de_curso` (
  `idPlan` int(11) NOT NULL AUTO_INCREMENT,
  `fecha_creacion` varchar(50) DEFAULT NULL,
  `utima_modificacion` varchar(50) DEFAULT NULL,
  `url_servidor` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`idPlan`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `plan_de_curso`
--

LOCK TABLES `plan_de_curso` WRITE;
/*!40000 ALTER TABLE `plan_de_curso` DISABLE KEYS */;
/*!40000 ALTER TABLE `plan_de_curso` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `plan_de_trabajo`
--

DROP TABLE IF EXISTS `plan_de_trabajo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `plan_de_trabajo` (
  `idPlanDeTrabajo` int(11) NOT NULL AUTO_INCREMENT,
  `idAcademia` int(11) DEFAULT NULL,
  `idReporteCoordinador` int(11) DEFAULT NULL,
  `fecha_creacion` varchar(50) DEFAULT NULL,
  `ultima_modificacion` varchar(50) DEFAULT NULL,
  `url_servidor` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`idPlanDeTrabajo`),
  KEY `idAcademia` (`idAcademia`),
  KEY `idReporteCoordinador` (`idReporteCoordinador`),
  CONSTRAINT `plan_de_trabajo_ibfk_1` FOREIGN KEY (`idAcademia`) REFERENCES `academia` (`idAcademia`),
  CONSTRAINT `plan_de_trabajo_ibfk_2` FOREIGN KEY (`idReporteCoordinador`) REFERENCES `reporte_coordinador` (`idReporteCoordinador`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `plan_de_trabajo`
--

LOCK TABLES `plan_de_trabajo` WRITE;
/*!40000 ALTER TABLE `plan_de_trabajo` DISABLE KEYS */;
/*!40000 ALTER TABLE `plan_de_trabajo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reporte_coordinador`
--

DROP TABLE IF EXISTS `reporte_coordinador`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `reporte_coordinador` (
  `idReporteCoordinador` int(11) NOT NULL AUTO_INCREMENT,
  `fecha_creacion` varchar(50) DEFAULT NULL,
  `ultima_modificacion` varchar(50) DEFAULT NULL,
  `url_servidor` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`idReporteCoordinador`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reporte_coordinador`
--

LOCK TABLES `reporte_coordinador` WRITE;
/*!40000 ALTER TABLE `reporte_coordinador` DISABLE KEYS */;
/*!40000 ALTER TABLE `reporte_coordinador` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-04-13 22:09:35
