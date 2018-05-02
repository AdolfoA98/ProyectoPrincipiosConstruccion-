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
  `idAcademia` bigint(20) NOT NULL,
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
  `idActividad` int(11) NOT NULL,
  `idObjetivo` int(11) DEFAULT NULL,
  `nombre` varchar(200) DEFAULT NULL,
  `fecha` varchar(50) DEFAULT NULL,
  `forma_operar` text,
  PRIMARY KEY (`idActividad`),
  KEY `idObjetivo` (`idObjetivo`),
  CONSTRAINT `actividad_ibfk_1` FOREIGN KEY (`idObjetivo`) REFERENCES `objetivo` (`idObjetivo`)
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
-- Table structure for table `avance`
--

DROP TABLE IF EXISTS `avance`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `avance` (
  `idAvan` int(11) NOT NULL,
  `idUnidad` int(11) DEFAULT NULL,
  `porCiento_avance` float DEFAULT NULL,
  `observaciones` text,
  PRIMARY KEY (`idAvan`),
  KEY `idUnidad` (`idUnidad`),
  CONSTRAINT `avance_ibfk_1` FOREIGN KEY (`idUnidad`) REFERENCES `unidad` (`idUnidad`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `avance`
--

LOCK TABLES `avance` WRITE;
/*!40000 ALTER TABLE `avance` DISABLE KEYS */;
/*!40000 ALTER TABLE `avance` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `avance_programatico`
--

DROP TABLE IF EXISTS `avance_programatico`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `avance_programatico` (
  `idAvance` int(11) NOT NULL,
  `bloque` int(11) DEFAULT NULL,
  `seccion` varchar(50) DEFAULT NULL,
  `idAvan` int(11) DEFAULT NULL,
  `idPlaneacion` int(11) DEFAULT NULL,
  PRIMARY KEY (`idAvance`),
  KEY `idAvan` (`idAvan`),
  KEY `idPlaneacion` (`idPlaneacion`),
  CONSTRAINT `avance_programatico_ibfk_1` FOREIGN KEY (`idAvan`) REFERENCES `avance` (`idAvan`),
  CONSTRAINT `avance_programatico_ibfk_2` FOREIGN KEY (`idPlaneacion`) REFERENCES `planeacion` (`idPlaneacion`)
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
-- Table structure for table `bibliografia`
--

DROP TABLE IF EXISTS `bibliografia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bibliografia` (
  `idBibliografia` int(11) NOT NULL,
  `autor` varchar(150) DEFAULT NULL,
  `titulo` varchar(180) DEFAULT NULL,
  `editorial` varchar(100) DEFAULT NULL,
  `anio` int(11) DEFAULT NULL,
  PRIMARY KEY (`idBibliografia`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bibliografia`
--

LOCK TABLES `bibliografia` WRITE;
/*!40000 ALTER TABLE `bibliografia` DISABLE KEYS */;
/*!40000 ALTER TABLE `bibliografia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `calendario_evaluacion`
--

DROP TABLE IF EXISTS `calendario_evaluacion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `calendario_evaluacion` (
  `idCalendario` int(11) NOT NULL,
  `idUnidad` int(11) DEFAULT NULL,
  `fecha` varchar(100) DEFAULT NULL,
  `criterio_eval` text,
  `instrumento` varchar(150) DEFAULT NULL,
  `porcentaje` float DEFAULT NULL,
  PRIMARY KEY (`idCalendario`),
  KEY `idUnidad` (`idUnidad`),
  CONSTRAINT `calendario_evaluacion_ibfk_1` FOREIGN KEY (`idUnidad`) REFERENCES `unidad` (`idUnidad`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `calendario_evaluacion`
--

LOCK TABLES `calendario_evaluacion` WRITE;
/*!40000 ALTER TABLE `calendario_evaluacion` DISABLE KEYS */;
/*!40000 ALTER TABLE `calendario_evaluacion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `coordinador`
--

DROP TABLE IF EXISTS `coordinador`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `coordinador` (
  `numeroPersonal` int(150) NOT NULL,
  `idAcademia` bigint(20) DEFAULT NULL,
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
  `idPlan` int(11) DEFAULT NULL,
  `idAvance` int(11) DEFAULT NULL,
  `periodo` varchar(50) DEFAULT NULL,
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
  `numeroPersonal` int(11) NOT NULL,
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
  `idExperiencia` int(11) NOT NULL,
  `idProgramEdu` int(11) DEFAULT NULL,
  `idAcademia` bigint(20) DEFAULT NULL,
  `nombre` varchar(100) DEFAULT NULL,
  `creditos` int(11) DEFAULT NULL,
  PRIMARY KEY (`idExperiencia`),
  KEY `idProgramEdu` (`idProgramEdu`),
  KEY `idAcademia` (`idAcademia`),
  CONSTRAINT `ee_ibfk_1` FOREIGN KEY (`idProgramEdu`) REFERENCES `pe` (`idProgramEdu`),
  CONSTRAINT `ee_ibfk_2` FOREIGN KEY (`idAcademia`) REFERENCES `academia` (`idAcademia`)
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
-- Table structure for table `evaluacion`
--

DROP TABLE IF EXISTS `evaluacion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `evaluacion` (
  `idEvaluacion` int(11) NOT NULL,
  `elemento` varchar(150) DEFAULT NULL,
  `porcentaje` float DEFAULT NULL,
  PRIMARY KEY (`idEvaluacion`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `evaluacion`
--

LOCK TABLES `evaluacion` WRITE;
/*!40000 ALTER TABLE `evaluacion` DISABLE KEYS */;
/*!40000 ALTER TABLE `evaluacion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `objetivo`
--

DROP TABLE IF EXISTS `objetivo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `objetivo` (
  `idObjetivo` int(11) NOT NULL,
  `meta` text,
  PRIMARY KEY (`idObjetivo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `objetivo`
--

LOCK TABLES `objetivo` WRITE;
/*!40000 ALTER TABLE `objetivo` DISABLE KEYS */;
/*!40000 ALTER TABLE `objetivo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `participa_plandetrabajo`
--

DROP TABLE IF EXISTS `participa_plandetrabajo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `participa_plandetrabajo` (
  `idParticipacion` int(11) NOT NULL,
  `numeroPersonal` int(11) DEFAULT NULL,
  `idPlanDeTrabajo` int(11) DEFAULT NULL,
  PRIMARY KEY (`idParticipacion`),
  KEY `numeroPersonal` (`numeroPersonal`),
  KEY `idPlanDeTrabajo` (`idPlanDeTrabajo`),
  CONSTRAINT `participa_plandetrabajo_ibfk_1` FOREIGN KEY (`numeroPersonal`) REFERENCES `docente` (`numeroPersonal`),
  CONSTRAINT `participa_plandetrabajo_ibfk_2` FOREIGN KEY (`idPlanDeTrabajo`) REFERENCES `plan_de_trabajo` (`idPlanDeTrabajo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `participa_plandetrabajo`
--

LOCK TABLES `participa_plandetrabajo` WRITE;
/*!40000 ALTER TABLE `participa_plandetrabajo` DISABLE KEYS */;
/*!40000 ALTER TABLE `participa_plandetrabajo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pe`
--

DROP TABLE IF EXISTS `pe`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pe` (
  `idProgramEdu` int(11) NOT NULL,
  `nombre` varchar(150) DEFAULT NULL,
  PRIMARY KEY (`idProgramEdu`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pe`
--

LOCK TABLES `pe` WRITE;
/*!40000 ALTER TABLE `pe` DISABLE KEYS */;
/*!40000 ALTER TABLE `pe` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `plan_de_curso`
--

DROP TABLE IF EXISTS `plan_de_curso`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `plan_de_curso` (
  `idPlan` int(11) NOT NULL AUTO_INCREMENT,
  `bloque` int(11) DEFAULT NULL,
  `seccion` varchar(50) DEFAULT NULL,
  `objetivo_general` text,
  `idPlaneacion` int(11) DEFAULT NULL,
  `idBibliografia` int(11) DEFAULT NULL,
  `idCalendario` int(11) DEFAULT NULL,
  PRIMARY KEY (`idPlan`),
  KEY `idPlaneacion` (`idPlaneacion`),
  KEY `idBibliografia` (`idBibliografia`),
  KEY `idCalendario` (`idCalendario`),
  CONSTRAINT `plan_de_curso_ibfk_1` FOREIGN KEY (`idPlaneacion`) REFERENCES `planeacion` (`idPlaneacion`),
  CONSTRAINT `plan_de_curso_ibfk_2` FOREIGN KEY (`idBibliografia`) REFERENCES `bibliografia` (`idBibliografia`),
  CONSTRAINT `plan_de_curso_ibfk_3` FOREIGN KEY (`idCalendario`) REFERENCES `calendario_evaluacion` (`idCalendario`)
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
  `idPlanDeTrabajo` int(11) NOT NULL,
  `fecha_aprobacion` varchar(100) DEFAULT NULL,
  `objetivo_general` text,
  `idObjetivoUno` int(11) DEFAULT NULL,
  `idObjetivoDos` int(11) DEFAULT NULL,
  `idObjetivoTres` int(11) DEFAULT NULL,
  `idTemaExam` int(11) DEFAULT NULL,
  `idEvaluacion` int(11) DEFAULT NULL,
  PRIMARY KEY (`idPlanDeTrabajo`),
  KEY `idObjetivoUno` (`idObjetivoUno`),
  KEY `idObjetivoDos` (`idObjetivoDos`),
  KEY `idObjetivoTres` (`idObjetivoTres`),
  KEY `idTemaExam` (`idTemaExam`),
  KEY `idEvaluacion` (`idEvaluacion`),
  CONSTRAINT `plan_de_trabajo_ibfk_1` FOREIGN KEY (`idObjetivoUno`) REFERENCES `objetivo` (`idObjetivo`),
  CONSTRAINT `plan_de_trabajo_ibfk_2` FOREIGN KEY (`idObjetivoDos`) REFERENCES `objetivo` (`idObjetivo`),
  CONSTRAINT `plan_de_trabajo_ibfk_3` FOREIGN KEY (`idObjetivoTres`) REFERENCES `objetivo` (`idObjetivo`),
  CONSTRAINT `plan_de_trabajo_ibfk_4` FOREIGN KEY (`idTemaExam`) REFERENCES `temas_examen` (`idTemaExam`),
  CONSTRAINT `plan_de_trabajo_ibfk_5` FOREIGN KEY (`idEvaluacion`) REFERENCES `evaluacion` (`idEvaluacion`)
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
-- Table structure for table `planeacion`
--

DROP TABLE IF EXISTS `planeacion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `planeacion` (
  `idPlaneacion` int(11) NOT NULL,
  `idUnidad` int(11) DEFAULT NULL,
  `idTema` int(11) DEFAULT NULL,
  `fecha` varchar(180) DEFAULT NULL,
  `practicas` text,
  `tecnica_didactica` text,
  PRIMARY KEY (`idPlaneacion`),
  KEY `idUnidad` (`idUnidad`),
  KEY `idTema` (`idTema`),
  CONSTRAINT `planeacion_ibfk_1` FOREIGN KEY (`idUnidad`) REFERENCES `unidad` (`idUnidad`),
  CONSTRAINT `planeacion_ibfk_2` FOREIGN KEY (`idTema`) REFERENCES `tema` (`idTema`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `planeacion`
--

LOCK TABLES `planeacion` WRITE;
/*!40000 ALTER TABLE `planeacion` DISABLE KEYS */;
/*!40000 ALTER TABLE `planeacion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reporte_coordinador`
--

DROP TABLE IF EXISTS `reporte_coordinador`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `reporte_coordinador` (
  `idReporteCoordinador` int(11) NOT NULL AUTO_INCREMENT,
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

--
-- Table structure for table `tema`
--

DROP TABLE IF EXISTS `tema`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tema` (
  `idTema` int(11) NOT NULL,
  `idUnidad` int(11) DEFAULT NULL,
  `nombre` varchar(180) DEFAULT NULL,
  PRIMARY KEY (`idTema`),
  KEY `idUnidad` (`idUnidad`),
  CONSTRAINT `tema_ibfk_1` FOREIGN KEY (`idUnidad`) REFERENCES `unidad` (`idUnidad`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tema`
--

LOCK TABLES `tema` WRITE;
/*!40000 ALTER TABLE `tema` DISABLE KEYS */;
/*!40000 ALTER TABLE `tema` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `temas_examen`
--

DROP TABLE IF EXISTS `temas_examen`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `temas_examen` (
  `idTemaExam` int(11) NOT NULL,
  `idUnidad` int(11) DEFAULT NULL,
  `parcial` enum('1er Parcial','2do Parcial') DEFAULT NULL,
  PRIMARY KEY (`idTemaExam`),
  KEY `idUnidad` (`idUnidad`),
  CONSTRAINT `temas_examen_ibfk_1` FOREIGN KEY (`idUnidad`) REFERENCES `unidad` (`idUnidad`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `temas_examen`
--

LOCK TABLES `temas_examen` WRITE;
/*!40000 ALTER TABLE `temas_examen` DISABLE KEYS */;
/*!40000 ALTER TABLE `temas_examen` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `unidad`
--

DROP TABLE IF EXISTS `unidad`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `unidad` (
  `idUnidad` int(11) NOT NULL,
  `idProgramEdu` int(11) DEFAULT NULL,
  `no_unidad` int(11) DEFAULT NULL,
  `nombre` varchar(150) DEFAULT NULL,
  PRIMARY KEY (`idUnidad`),
  KEY `idProgramEdu` (`idProgramEdu`),
  CONSTRAINT `unidad_ibfk_1` FOREIGN KEY (`idProgramEdu`) REFERENCES `pe` (`idProgramEdu`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `unidad`
--

LOCK TABLES `unidad` WRITE;
/*!40000 ALTER TABLE `unidad` DISABLE KEYS */;
/*!40000 ALTER TABLE `unidad` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-05-01 20:56:10
