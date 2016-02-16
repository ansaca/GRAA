-- --------------------------------------------------------
-- Host:                         localhost
-- Versión del servidor:         5.6.26-log - MySQL Community Server (GPL)
-- SO del servidor:              Win64
-- HeidiSQL Versión:             9.3.0.4984
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Volcando estructura de base de datos para gepad
CREATE DATABASE IF NOT EXISTS `gepad` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `gepad`;


-- Volcando estructura para tabla gepad.accionescontrato
CREATE TABLE IF NOT EXISTS `accionescontrato` (
  `numerocontratoacciones` int(11) NOT NULL,
  `codigoclausulaacciones` int(11) NOT NULL,
  `codigopagoacciones` int(11) NOT NULL,
  `descripcionacciones` text,
  `evidenciasacciones` text,
  PRIMARY KEY (`numerocontratoacciones`,`codigoclausulaacciones`,`codigopagoacciones`),
  KEY `FK_accionescontrato_clausula` (`codigoclausulaacciones`),
  KEY `FK_accionescontrato_pago` (`codigopagoacciones`),
  CONSTRAINT `FK_accionescontrato_clausula` FOREIGN KEY (`codigoclausulaacciones`) REFERENCES `clausula` (`codigoclausula`),
  CONSTRAINT `FK_accionescontrato_contrato` FOREIGN KEY (`numerocontratoacciones`) REFERENCES `contrato` (`numerocontrato`),
  CONSTRAINT `FK_accionescontrato_pago` FOREIGN KEY (`codigopagoacciones`) REFERENCES `pago` (`codigopago`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla gepad.accionescontrato: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `accionescontrato` DISABLE KEYS */;
/*!40000 ALTER TABLE `accionescontrato` ENABLE KEYS */;


-- Volcando estructura para tabla gepad.actividad
CREATE TABLE IF NOT EXISTS `actividad` (
  `codigoactividad` int(11) NOT NULL AUTO_INCREMENT,
  `fechaactividad` date DEFAULT NULL,
  `horadesdeactividad` varchar(50) DEFAULT NULL,
  `horahastaactividad` varchar(50) DEFAULT NULL,
  `descripcionactividad` text,
  `resultadosobtenidosactividad` text,
  `codigomonitoractividad` int(11) DEFAULT NULL,
  `cantidadhorasactividad` int(11) DEFAULT NULL,
  `codigoinformeactividad` int(11) DEFAULT NULL,
  PRIMARY KEY (`codigoactividad`),
  KEY `FK_actividad_monitor` (`codigomonitoractividad`),
  KEY `FK_actividad_informe` (`codigoinformeactividad`),
  CONSTRAINT `FK_actividad_informe` FOREIGN KEY (`codigoinformeactividad`) REFERENCES `informe` (`codigoinforme`),
  CONSTRAINT `FK_actividad_monitor` FOREIGN KEY (`codigomonitoractividad`) REFERENCES `monitor` (`codigomonitor`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla gepad.actividad: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `actividad` DISABLE KEYS */;
/*!40000 ALTER TABLE `actividad` ENABLE KEYS */;


-- Volcando estructura para tabla gepad.ambientedeaprendizaje
CREATE TABLE IF NOT EXISTS `ambientedeaprendizaje` (
  `codigoambiente` int(11) NOT NULL AUTO_INCREMENT,
  `nombreambiente` varchar(100) DEFAULT NULL,
  `capacidadambiente` int(11) DEFAULT NULL,
  `areaambiente` int(11) DEFAULT NULL,
  `codigotipoambiente` int(11) DEFAULT NULL,
  `numerosedeambiente` int(11) DEFAULT NULL,
  `estadoambiente` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`codigoambiente`),
  KEY `FK_ambientedeaprendizaje_tipoambiente` (`codigotipoambiente`),
  KEY `FK_ambientedeaprendizaje_sede` (`numerosedeambiente`),
  CONSTRAINT `FK_ambientedeaprendizaje_sede` FOREIGN KEY (`numerosedeambiente`) REFERENCES `sede` (`numerosede`),
  CONSTRAINT `FK_ambientedeaprendizaje_tipoambiente` FOREIGN KEY (`codigotipoambiente`) REFERENCES `tipoambiente` (`codigotipoambiente`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla gepad.ambientedeaprendizaje: ~3 rows (aproximadamente)
/*!40000 ALTER TABLE `ambientedeaprendizaje` DISABLE KEYS */;
INSERT INTO `ambientedeaprendizaje` (`codigoambiente`, `nombreambiente`, `capacidadambiente`, `areaambiente`, `codigotipoambiente`, `numerosedeambiente`, `estadoambiente`) VALUES
	(1, 'Sala sistemas', 40, 80, 1, 0, 'Disponible'),
	(2, 'Mercadeo', 50, 80, 1, 1, 'Disponible'),
	(3, 'Cabras\r\n', 30, 76, 1, 0, 'Disponible');
/*!40000 ALTER TABLE `ambientedeaprendizaje` ENABLE KEYS */;


-- Volcando estructura para tabla gepad.aprendiz
CREATE TABLE IF NOT EXISTS `aprendiz` (
  `documentoaprendiz` bigint(20) NOT NULL,
  `fichatitulacionaprendiz` int(11) DEFAULT NULL,
  PRIMARY KEY (`documentoaprendiz`),
  KEY `FK_aprendiz_fichatitulacion` (`fichatitulacionaprendiz`),
  CONSTRAINT `FK_aprendiz_fichatitulacion` FOREIGN KEY (`fichatitulacionaprendiz`) REFERENCES `fichatitulacion` (`fichatitulacion`) ON UPDATE CASCADE,
  CONSTRAINT `FK_aprendiz_personal` FOREIGN KEY (`documentoaprendiz`) REFERENCES `personal` (`documentopersonal`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla gepad.aprendiz: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `aprendiz` DISABLE KEYS */;
/*!40000 ALTER TABLE `aprendiz` ENABLE KEYS */;


-- Volcando estructura para tabla gepad.area
CREATE TABLE IF NOT EXISTS `area` (
  `codigoarea` int(10) NOT NULL AUTO_INCREMENT,
  `nombrearea` varchar(50) DEFAULT NULL,
  `codigodependencia` int(10) DEFAULT NULL,
  PRIMARY KEY (`codigoarea`),
  KEY `FK_area_dependencia` (`codigodependencia`),
  CONSTRAINT `FK_area_dependencia` FOREIGN KEY (`codigodependencia`) REFERENCES `dependencia` (`codigodependencia`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla gepad.area: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `area` DISABLE KEYS */;
INSERT INTO `area` (`codigoarea`, `nombrearea`, `codigodependencia`) VALUES
	(1, 'Almacen', 1);
/*!40000 ALTER TABLE `area` ENABLE KEYS */;


-- Volcando estructura para tabla gepad.asignafichas
CREATE TABLE IF NOT EXISTS `asignafichas` (
  `codigoasigna` int(10) NOT NULL AUTO_INCREMENT,
  `fichatitulacion` int(10) DEFAULT NULL,
  `documentoinstructor` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`codigoasigna`),
  KEY `FK_asignafichas_titulacion` (`fichatitulacion`),
  KEY `FK_asignafichas_instructor` (`documentoinstructor`),
  CONSTRAINT `FK_asignafichas_instructor` FOREIGN KEY (`documentoinstructor`) REFERENCES `instructor` (`documentoinstructor`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_asignafichas_titulacion` FOREIGN KEY (`fichatitulacion`) REFERENCES `fichatitulacion` (`fichatitulacion`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla gepad.asignafichas: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `asignafichas` DISABLE KEYS */;
/*!40000 ALTER TABLE `asignafichas` ENABLE KEYS */;


-- Volcando estructura para tabla gepad.banco
CREATE TABLE IF NOT EXISTS `banco` (
  `codigobanco` int(11) NOT NULL AUTO_INCREMENT,
  `nombrebanco` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`codigobanco`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla gepad.banco: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `banco` DISABLE KEYS */;
/*!40000 ALTER TABLE `banco` ENABLE KEYS */;


-- Volcando estructura para tabla gepad.capacitacion
CREATE TABLE IF NOT EXISTS `capacitacion` (
  `codigocapacitacion` int(11) NOT NULL AUTO_INCREMENT,
  `nombrecapacitacion` varchar(100) DEFAULT NULL,
  `institucioncapacitacion` varchar(100) DEFAULT NULL,
  `fechacapacitacion` date DEFAULT NULL,
  `tiempocapacitacion` int(11) DEFAULT NULL,
  `tipotiempocapacitacion` varchar(50) DEFAULT NULL,
  `documentoinstructor` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`codigocapacitacion`),
  KEY `FK_capacitacion_instructor` (`documentoinstructor`),
  CONSTRAINT `FK_capacitacion_instructor` FOREIGN KEY (`documentoinstructor`) REFERENCES `instructor` (`documentoinstructor`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla gepad.capacitacion: ~6 rows (aproximadamente)
/*!40000 ALTER TABLE `capacitacion` DISABLE KEYS */;
INSERT INTO `capacitacion` (`codigocapacitacion`, `nombrecapacitacion`, `institucioncapacitacion`, `fechacapacitacion`, `tiempocapacitacion`, `tipotiempocapacitacion`, `documentoinstructor`) VALUES
	(1, 'dsdsfds', 'fsdfdsfds', '2015-12-15', 34, 'HORAS', 1116235891),
	(2, 'dsfsdfdsf', 'sdfdsfds', '2015-12-23', 4, 'MESES', 1116235891),
	(3, 'OTRA', 'FSDFSDFDSF', '0000-00-00', 56, 'HORAS', 1116235891),
	(4, 'OTRA', 'FSDFSDFDSF', '0000-00-00', 56, 'HORAS', 1116235891),
	(5, 'OTRA', 'FSDFSDFDSF', '0000-00-00', 56, 'HORAS', 1116235891),
	(6, 'OTRA', 'FSDFSDFDSF', '2015-12-21', 56, 'HORAS', 1116235891);
/*!40000 ALTER TABLE `capacitacion` ENABLE KEYS */;


-- Volcando estructura para tabla gepad.centro
CREATE TABLE IF NOT EXISTS `centro` (
  `codigocentro` int(11) NOT NULL,
  `nombrecentro` varchar(50) DEFAULT NULL,
  `direccioncentro` varchar(50) DEFAULT NULL,
  `ciudadcentro` varchar(50) DEFAULT NULL,
  `codigoregionalcentro` int(11) DEFAULT NULL,
  `documentofuncionariocentro` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`codigocentro`),
  KEY `FK_centro_regional` (`codigoregionalcentro`),
  KEY `FK_centro_funcionario` (`documentofuncionariocentro`),
  CONSTRAINT `FK_centro_funcionario` FOREIGN KEY (`documentofuncionariocentro`) REFERENCES `funcionario` (`documentofuncionario`),
  CONSTRAINT `FK_centro_regional` FOREIGN KEY (`codigoregionalcentro`) REFERENCES `regional` (`codigoregional`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla gepad.centro: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `centro` DISABLE KEYS */;
INSERT INTO `centro` (`codigocentro`, `nombrecentro`, `direccioncentro`, `ciudadcentro`, `codigoregionalcentro`, `documentofuncionariocentro`) VALUES
	(9125, 'CENTRO LATINOAMERICANO DE ESPECIES MENORES', 'KM2 VIA BUGA TULUA', 'TULUA', 30, NULL);
/*!40000 ALTER TABLE `centro` ENABLE KEYS */;


-- Volcando estructura para tabla gepad.clausula
CREATE TABLE IF NOT EXISTS `clausula` (
  `codigoclausula` int(11) NOT NULL AUTO_INCREMENT,
  `descripcionclausula` text,
  PRIMARY KEY (`codigoclausula`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla gepad.clausula: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `clausula` DISABLE KEYS */;
/*!40000 ALTER TABLE `clausula` ENABLE KEYS */;


-- Volcando estructura para tabla gepad.clausulacontrato
CREATE TABLE IF NOT EXISTS `clausulacontrato` (
  `codigoclausula` int(11) NOT NULL,
  `numerocontrato` int(11) NOT NULL,
  PRIMARY KEY (`codigoclausula`,`numerocontrato`),
  KEY `FK_clausulacontrato_contrato` (`numerocontrato`),
  CONSTRAINT `FK__clausula` FOREIGN KEY (`codigoclausula`) REFERENCES `clausula` (`codigoclausula`),
  CONSTRAINT `FK_clausulacontrato_contrato` FOREIGN KEY (`numerocontrato`) REFERENCES `contrato` (`numerocontrato`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla gepad.clausulacontrato: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `clausulacontrato` DISABLE KEYS */;
/*!40000 ALTER TABLE `clausulacontrato` ENABLE KEYS */;


-- Volcando estructura para tabla gepad.clienteexterno
CREATE TABLE IF NOT EXISTS `clienteexterno` (
  `documentocliente` bigint(20) NOT NULL,
  PRIMARY KEY (`documentocliente`),
  CONSTRAINT `FK_clienteexterno_personal` FOREIGN KEY (`documentocliente`) REFERENCES `personal` (`documentopersonal`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla gepad.clienteexterno: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `clienteexterno` DISABLE KEYS */;
/*!40000 ALTER TABLE `clienteexterno` ENABLE KEYS */;


-- Volcando estructura para tabla gepad.coformador
CREATE TABLE IF NOT EXISTS `coformador` (
  `documentocoformador` bigint(20) NOT NULL,
  `nombrecoformador` varchar(50) DEFAULT NULL,
  `cargocoformador` varchar(50) DEFAULT NULL,
  `telefonocoformador` varchar(50) DEFAULT NULL,
  `numeroempresa` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`documentocoformador`),
  KEY `FK_coformador_empresa` (`numeroempresa`),
  CONSTRAINT `FK_coformador_empresa` FOREIGN KEY (`numeroempresa`) REFERENCES `empresa` (`numeroempresa`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla gepad.coformador: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `coformador` DISABLE KEYS */;
/*!40000 ALTER TABLE `coformador` ENABLE KEYS */;


-- Volcando estructura para tabla gepad.comite
CREATE TABLE IF NOT EXISTS `comite` (
  `documentopersonal` bigint(20) NOT NULL,
  `numeroseguimiento` int(11) NOT NULL,
  `cargo` varchar(50) NOT NULL,
  PRIMARY KEY (`documentopersonal`,`numeroseguimiento`),
  KEY `FK_comite_seguimiento` (`numeroseguimiento`),
  CONSTRAINT `FK_comite_personal` FOREIGN KEY (`documentopersonal`) REFERENCES `personal` (`documentopersonal`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_comite_seguimiento` FOREIGN KEY (`numeroseguimiento`) REFERENCES `seguimiento` (`codigoseguimiento`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla gepad.comite: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `comite` DISABLE KEYS */;
/*!40000 ALTER TABLE `comite` ENABLE KEYS */;


-- Volcando estructura para tabla gepad.contrato
CREATE TABLE IF NOT EXISTS `contrato` (
  `numerocontrato` int(10) NOT NULL,
  `fechainiciocontrato` date DEFAULT NULL,
  `fechafincontrato` date DEFAULT NULL,
  `objetocontrato` text,
  `estadocontrato` varchar(50) DEFAULT NULL,
  `valortotalcontrato` bigint(20) DEFAULT NULL,
  `numerocompromisosiifcontrato` int(11) DEFAULT NULL,
  `formapagocontrato` varchar(50) DEFAULT NULL,
  `numerocuentacontrato` bigint(20) DEFAULT NULL,
  `tipocuentacontrato` varchar(50) DEFAULT NULL,
  `codigobancocontrato` int(11) DEFAULT NULL,
  `documentocoordinadorcontrato` bigint(20) DEFAULT NULL,
  `documentopersonalcontrato` bigint(20) DEFAULT NULL,
  `codigolineacontrato` int(11) DEFAULT NULL,
  `clasepersonacontrato` varchar(50) DEFAULT NULL,
  `ingresossuperiorescontrato` char(50) DEFAULT NULL,
  `regimenivacontrato` char(50) DEFAULT NULL,
  `excluidoivacontrato` char(50) DEFAULT NULL,
  `declarantecontrato` char(50) DEFAULT NULL,
  `pensionadocontrato` char(50) DEFAULT NULL,
  `dependientescontratp` char(50) DEFAULT NULL,
  `embargocontrato` char(50) DEFAULT NULL,
  `valorembargocontrato` int(11) DEFAULT NULL,
  `valormensualcontrato` bigint(20) DEFAULT NULL,
  `valorhoracontrato` int(11) DEFAULT NULL,
  `tipoarlcontrato` int(11) DEFAULT NULL,
  PRIMARY KEY (`numerocontrato`),
  KEY `FK_contrato_banco` (`codigobancocontrato`),
  KEY `FK_contrato_coordinador` (`documentocoordinadorcontrato`),
  KEY `FK_contrato_personal` (`documentopersonalcontrato`),
  KEY `FK_contrato_lineacentro` (`codigolineacontrato`),
  CONSTRAINT `FK_contrato_banco` FOREIGN KEY (`codigobancocontrato`) REFERENCES `banco` (`codigobanco`),
  CONSTRAINT `FK_contrato_coordinador` FOREIGN KEY (`documentocoordinadorcontrato`) REFERENCES `coordinador` (`documentocoordinador`),
  CONSTRAINT `FK_contrato_lineacentro` FOREIGN KEY (`codigolineacontrato`) REFERENCES `lineacentro` (`codigolinea`),
  CONSTRAINT `FK_contrato_personal` FOREIGN KEY (`documentopersonalcontrato`) REFERENCES `personal` (`documentopersonal`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla gepad.contrato: ~191 rows (aproximadamente)
/*!40000 ALTER TABLE `contrato` DISABLE KEYS */;
INSERT INTO `contrato` (`numerocontrato`, `fechainiciocontrato`, `fechafincontrato`, `objetocontrato`, `estadocontrato`, `valortotalcontrato`, `numerocompromisosiifcontrato`, `formapagocontrato`, `numerocuentacontrato`, `tipocuentacontrato`, `codigobancocontrato`, `documentocoordinadorcontrato`, `documentopersonalcontrato`, `codigolineacontrato`, `clasepersonacontrato`, `ingresossuperiorescontrato`, `regimenivacontrato`, `excluidoivacontrato`, `declarantecontrato`, `pensionadocontrato`, `dependientescontratp`, `embargocontrato`, `valorembargocontrato`, `valormensualcontrato`, `valorhoracontrato`, `tipoarlcontrato`) VALUES
	(443, '2015-01-20', '2015-12-11', NULL, 'EJECUCION', NULL, NULL, NULL, NULL, NULL, NULL, 66726704, 37729607, 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(449, '2015-01-20', '2015-12-11', NULL, 'EJECUCION', NULL, NULL, NULL, NULL, NULL, NULL, 66726704, 4408060, 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(454, '2015-07-01', '2015-12-11', NULL, 'EJECUCION', NULL, NULL, NULL, NULL, NULL, NULL, 66726704, 14796542, 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(456, '2015-01-20', '2015-12-11', NULL, 'EJECUCION', NULL, NULL, NULL, NULL, NULL, NULL, 2631490, 94387680, 2, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(462, '2015-07-01', '2015-12-11', NULL, 'EJECUCION', NULL, NULL, NULL, NULL, NULL, NULL, 2631490, 66803909, 2, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(465, '2015-01-20', '2015-12-11', NULL, 'EJECUCION', NULL, NULL, NULL, NULL, NULL, NULL, 66726704, 94153675, 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(471, '2015-09-23', '2015-12-11', NULL, 'EJECUCION', NULL, NULL, NULL, NULL, NULL, NULL, 66726704, 1116235700, 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(476, '2015-01-20', '2015-12-11', NULL, 'EJECUCION', NULL, NULL, NULL, NULL, NULL, NULL, 66726704, 31193147, 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(487, '2015-01-20', '2015-12-11', NULL, 'EJECUCION', NULL, NULL, NULL, NULL, NULL, NULL, 66726704, 1116242450, 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(513, '2015-01-21', '2015-12-11', NULL, 'EJECUCION', NULL, NULL, NULL, NULL, NULL, NULL, 66726704, 94395869, 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(517, '2015-01-21', '2015-12-11', NULL, 'EJECUCION', NULL, NULL, NULL, NULL, NULL, NULL, 66726704, 14897229, 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(518, '2015-01-21', '2015-12-11', NULL, 'EJECUCION', NULL, NULL, NULL, NULL, NULL, NULL, 66726704, 16626377, 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(521, '2015-01-21', '2015-12-11', NULL, 'EJECUCION', NULL, NULL, NULL, NULL, NULL, NULL, 66726704, 66801799, 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(563, '2015-01-21', '2015-12-11', NULL, 'EJECUCION', NULL, NULL, NULL, NULL, NULL, NULL, 66726704, 94151777, 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(564, '2015-01-21', '2015-12-11', NULL, 'EJECUCION', NULL, NULL, NULL, NULL, NULL, NULL, 66726704, 29309904, 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(566, '2015-01-21', '2015-12-11', NULL, 'EJECUCION', NULL, NULL, NULL, NULL, NULL, NULL, 66726704, 94391225, 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(571, '2015-01-21', '2015-12-11', NULL, 'EJECUCION', NULL, NULL, NULL, NULL, NULL, NULL, 66726704, 29877456, 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(573, '2015-01-21', '2015-12-11', NULL, 'EJECUCION', NULL, NULL, NULL, NULL, NULL, NULL, 66726704, 9736754, 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(576, '2015-01-21', '2015-12-11', NULL, 'EJECUCION', NULL, NULL, NULL, NULL, NULL, NULL, 66726704, 94392383, 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(578, '2015-01-21', '2015-11-13', NULL, 'EJECUCION', NULL, NULL, NULL, NULL, NULL, NULL, 66726704, 6499389, 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(580, '2015-01-21', '2015-12-11', NULL, 'EJECUCION', NULL, NULL, NULL, NULL, NULL, NULL, 66726704, 66726036, 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(584, '2015-01-21', '2015-12-11', NULL, 'EJECUCION', NULL, NULL, NULL, NULL, NULL, NULL, 66726704, 1116244664, 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(588, '2015-01-21', '2015-12-11', NULL, 'EJECUCION', NULL, NULL, NULL, NULL, NULL, NULL, 66726704, 38869122, 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(592, '2015-01-21', '2015-12-11', NULL, 'EJECUCION', NULL, NULL, NULL, NULL, NULL, NULL, 66726704, 31810074, 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(596, '2015-01-21', '2015-12-11', NULL, 'EJECUCION', NULL, NULL, NULL, NULL, NULL, NULL, 66726704, 31791653, 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(600, '2015-01-21', '2015-12-11', NULL, 'EJECUCION', NULL, NULL, NULL, NULL, NULL, NULL, 66726704, 1116235537, 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(606, '2015-01-21', '2015-12-11', NULL, 'EJECUCION', NULL, NULL, NULL, NULL, NULL, NULL, 66726704, 66720662, 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(610, '2015-01-21', '2015-12-11', NULL, 'EJECUCION', NULL, NULL, NULL, NULL, NULL, NULL, 66726704, 42015472, 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(612, '2015-01-21', '2015-12-11', NULL, 'EJECUCION', NULL, NULL, NULL, NULL, NULL, NULL, 66726704, 16368987, 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(614, '2015-01-21', '2015-12-11', NULL, 'EJECUCION', NULL, NULL, NULL, NULL, NULL, NULL, 66726704, 29873118, 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(615, '2015-01-21', '2015-12-11', NULL, 'EJECUCION', NULL, NULL, NULL, NULL, NULL, NULL, 66726704, 66712227, 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(616, '2015-01-21', '2015-12-11', NULL, 'EJECUCION', NULL, NULL, NULL, NULL, NULL, NULL, 66726704, 1116722533, 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(617, '2015-01-21', '2015-12-11', NULL, 'EJECUCION', NULL, NULL, NULL, NULL, NULL, NULL, 66726704, 29875987, 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(618, '2015-01-21', '2015-12-11', NULL, 'EJECUCION', NULL, NULL, NULL, NULL, NULL, NULL, 66726704, 94395777, 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(620, '2015-01-21', '2015-12-11', NULL, 'EJECUCION', NULL, NULL, NULL, NULL, NULL, NULL, 66726704, 30311965, 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(621, '2015-01-21', '2015-12-11', NULL, 'EJECUCION', NULL, NULL, NULL, NULL, NULL, NULL, 66726704, 66931412, 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(628, '2015-01-21', '2015-12-11', NULL, 'EJECUCION', NULL, NULL, NULL, NULL, NULL, NULL, 66726704, 31203237, 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(631, '2015-01-21', '2015-12-11', NULL, 'EJECUCION', NULL, NULL, NULL, NULL, NULL, NULL, 66726704, 1032376771, 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(633, '2015-01-21', '2015-12-11', NULL, 'EJECUCION', NULL, NULL, NULL, NULL, NULL, NULL, 66726704, 33817719, 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(635, '2015-01-21', '2015-12-11', NULL, 'EJECUCION', NULL, NULL, NULL, NULL, NULL, NULL, 66726704, 16632002, 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(643, '2015-01-21', '2015-12-11', NULL, 'EJECUCION', NULL, NULL, NULL, NULL, NULL, NULL, 66726704, 1112100266, 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(648, '2015-01-21', '2015-12-11', NULL, 'EJECUCION', NULL, NULL, NULL, NULL, NULL, NULL, 66726704, 31951934, 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(655, '2015-01-21', '2015-12-11', NULL, 'EJECUCION', NULL, NULL, NULL, NULL, NULL, NULL, 66726704, 94154232, 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(658, '2015-01-21', '2015-12-11', NULL, 'EJECUCION', NULL, NULL, NULL, NULL, NULL, NULL, 66726704, 29433366, 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(665, '2015-01-21', '2015-12-11', NULL, 'EJECUCION', NULL, NULL, NULL, NULL, NULL, NULL, 66726704, 73109148, 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(672, '2015-01-21', '2015-12-11', NULL, 'EJECUCION', NULL, NULL, NULL, NULL, NULL, NULL, 66726704, 14799474, 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(688, '2015-01-21', '2015-12-11', NULL, 'EJECUCION', NULL, NULL, NULL, NULL, NULL, NULL, 66726704, 29287323, 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(689, '2015-03-10', '2015-12-11', NULL, 'EJECUCION', NULL, NULL, NULL, NULL, NULL, NULL, 66726704, 31202853, 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(691, '2015-01-21', '2015-12-11', NULL, 'EJECUCION', NULL, NULL, NULL, NULL, NULL, NULL, 66726704, 65785466, 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(693, '2015-01-21', '2015-12-11', NULL, 'EJECUCION', NULL, NULL, NULL, NULL, NULL, NULL, 2631490, 31189608, 2, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(695, '2015-01-21', '2015-12-11', NULL, 'EJECUCION', NULL, NULL, NULL, NULL, NULL, NULL, 66726704, 76306931, 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(696, '2015-01-21', '2015-12-11', NULL, 'EJECUCION', NULL, NULL, NULL, NULL, NULL, NULL, 2631490, 26471980, 2, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(703, '2015-01-21', '2015-12-11', NULL, 'EJECUCION', NULL, NULL, NULL, NULL, NULL, NULL, 2631490, 14891728, 2, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(736, '2015-01-21', '2015-12-11', NULL, 'EJECUCION', NULL, NULL, NULL, NULL, NULL, NULL, 66726704, 3482453, 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(742, '2015-01-21', '2015-12-11', NULL, 'EJECUCION', NULL, NULL, NULL, NULL, NULL, NULL, 66726704, 43508604, 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(743, '2015-01-21', '2015-12-11', NULL, 'EJECUCION', NULL, NULL, NULL, NULL, NULL, NULL, 66726704, 16355511, 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(750, '2015-01-21', '2015-12-11', NULL, 'EJECUCION', NULL, NULL, NULL, NULL, NULL, NULL, 66726704, 91438736, 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(751, '2015-01-21', '2015-12-11', NULL, 'EJECUCION', NULL, NULL, NULL, NULL, NULL, NULL, 66726704, 1088294650, 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(752, '2015-01-21', '2015-12-11', NULL, 'EJECUCION', NULL, NULL, NULL, NULL, NULL, NULL, 2631490, 14882452, 2, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(753, '2015-01-21', '2015-12-11', NULL, 'EJECUCION', NULL, NULL, NULL, NULL, NULL, NULL, 2631490, 16280474, 2, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(760, '2015-01-22', '2015-12-11', NULL, 'EJECUCION', NULL, NULL, NULL, NULL, NULL, NULL, 2631490, 31194207, 2, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(761, '2015-01-22', '2015-12-11', NULL, 'EJECUCION', NULL, NULL, NULL, NULL, NULL, NULL, 14889925, 14800977, 3, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(762, '2015-01-22', '2015-12-11', NULL, 'EJECUCION', NULL, NULL, NULL, NULL, NULL, NULL, 14889925, 31755103, 3, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(763, '2015-01-22', '2015-12-11', NULL, 'EJECUCION', NULL, NULL, NULL, NULL, NULL, NULL, 14889925, 38796631, 3, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(768, '2015-01-22', '2015-12-11', NULL, 'EJECUCION', NULL, NULL, NULL, NULL, NULL, NULL, 2631490, 1116235526, 2, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(769, '2015-01-22', '2015-12-11', NULL, 'EJECUCION', NULL, NULL, NULL, NULL, NULL, NULL, 14889925, 6498352, 3, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(770, '2015-01-22', '2015-12-11', NULL, 'EJECUCION', NULL, NULL, NULL, NULL, NULL, NULL, 14889925, 31793192, 3, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(774, '2015-01-22', '2015-12-11', NULL, 'EJECUCION', NULL, NULL, NULL, NULL, NULL, NULL, 14889925, 31189932, 3, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(778, '2015-01-22', '2015-12-11', NULL, 'EJECUCION', NULL, NULL, NULL, NULL, NULL, NULL, 14889925, 38859741, 3, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(779, '2015-01-22', '2015-12-11', NULL, 'EJECUCION', NULL, NULL, NULL, NULL, NULL, NULL, 2631490, 1115065269, 2, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(782, '2015-01-22', '2015-12-11', NULL, 'EJECUCION', NULL, NULL, NULL, NULL, NULL, NULL, 2631490, 38794509, 2, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(784, '2015-01-22', '2015-12-11', NULL, 'EJECUCION', NULL, NULL, NULL, NULL, NULL, NULL, 2631490, 31416143, 2, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(785, '2015-01-22', '2015-12-11', NULL, 'EJECUCION', NULL, NULL, NULL, NULL, NULL, NULL, 14889925, 16234415, 3, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(786, '2015-01-22', '2015-12-11', NULL, 'EJECUCION', NULL, NULL, NULL, NULL, NULL, NULL, 2631490, 29873150, 2, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(787, '2015-01-22', '2015-12-11', NULL, 'EJECUCION', NULL, NULL, NULL, NULL, NULL, NULL, 2631490, 14892405, 2, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(789, '2015-01-22', '2015-12-11', NULL, 'EJECUCION', NULL, NULL, NULL, NULL, NULL, NULL, 2631490, 29178689, 2, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(791, '2015-01-22', '2015-12-11', NULL, 'EJECUCION', NULL, NULL, NULL, NULL, NULL, NULL, 14889925, 14703817, 3, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(792, '2015-01-22', '2015-12-11', NULL, 'EJECUCION', NULL, NULL, NULL, NULL, NULL, NULL, 14889925, 17658884, 3, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(793, '2015-01-22', '2015-12-11', NULL, 'EJECUCION', NULL, NULL, NULL, NULL, NULL, NULL, 14889925, 31983737, 2, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(794, '2015-01-22', '2015-12-11', NULL, 'EJECUCION', NULL, NULL, NULL, NULL, NULL, NULL, 14889925, 31791348, 3, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(795, '2015-01-22', '2015-12-11', NULL, 'EJECUCION', NULL, NULL, NULL, NULL, NULL, NULL, 2631490, 6498932, 2, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(796, '2015-01-22', '2015-12-11', NULL, 'EJECUCION', NULL, NULL, NULL, NULL, NULL, NULL, 14889925, 21811664, 3, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(798, '2015-01-22', '2015-12-11', NULL, 'EJECUCION', NULL, NULL, NULL, NULL, NULL, NULL, 14889925, 66983210, 3, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(800, '2015-01-22', '2015-12-11', NULL, 'EJECUCION', NULL, NULL, NULL, NULL, NULL, NULL, 2631490, 66725854, 2, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(802, '2015-01-22', '2015-12-11', NULL, 'EJECUCION', NULL, NULL, NULL, NULL, NULL, NULL, 14889925, 29875145, 3, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(804, '2015-01-22', '2015-12-11', NULL, 'EJECUCION', NULL, NULL, NULL, NULL, NULL, NULL, 2631490, 38790890, 2, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(807, '2015-01-22', '2015-12-11', NULL, 'EJECUCION', NULL, NULL, NULL, NULL, NULL, NULL, 2631490, 12187322, 2, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(808, '2015-03-11', '2015-12-11', NULL, 'EJECUCION', NULL, NULL, NULL, NULL, NULL, NULL, 66726704, 19315061, 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(809, '2015-01-22', '2015-12-11', NULL, 'EJECUCION', NULL, NULL, NULL, NULL, NULL, NULL, 14889925, 29817337, 3, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(811, '2015-01-22', '2015-12-11', NULL, 'EJECUCION', NULL, NULL, NULL, NULL, NULL, NULL, 2631490, 94153900, 2, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(812, '2015-01-22', '2015-12-11', NULL, 'EJECUCION', NULL, NULL, NULL, NULL, NULL, NULL, 2631490, 24582678, 2, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(813, '2015-01-22', '2015-12-11', NULL, 'EJECUCION', NULL, NULL, NULL, NULL, NULL, NULL, 2631490, 38791047, 2, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(815, '2015-01-22', '2015-12-11', '', 'EJECUCION', 0, 0, NULL, NULL, NULL, NULL, 66726704, 16358684, 3, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(816, '2015-01-22', '2015-12-11', NULL, 'EJECUCION', NULL, NULL, NULL, NULL, NULL, NULL, 14889925, 71905008, 3, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(817, '2015-01-22', '2015-12-11', NULL, 'EJECUCION', NULL, NULL, NULL, NULL, NULL, NULL, 14889925, 66724717, 3, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(819, '2015-01-22', '2015-12-11', NULL, 'EJECUCION', NULL, NULL, NULL, NULL, NULL, NULL, 2631490, 1467461, 2, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(830, '2015-01-22', '2015-12-11', NULL, 'EJECUCION', NULL, NULL, NULL, NULL, NULL, NULL, 14889925, 14799364, 3, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(884, '2015-01-22', '2015-12-11', NULL, 'EJECUCION', NULL, NULL, NULL, NULL, NULL, NULL, 2631490, 29784485, 2, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(886, '2015-01-22', '2015-12-11', NULL, 'EJECUCION', NULL, NULL, NULL, NULL, NULL, NULL, 2631490, 38874052, 2, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(890, '2015-01-22', '2015-12-11', NULL, 'EJECUCION', NULL, NULL, NULL, NULL, NULL, NULL, 14889925, 38792768, 3, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(932, '2015-01-23', '2015-12-11', NULL, 'EJECUCION', NULL, NULL, NULL, NULL, NULL, NULL, 2631490, 29757606, 2, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(944, '2015-01-23', '2015-12-11', NULL, 'EJECUCION', NULL, NULL, NULL, NULL, NULL, NULL, 2631490, 94393714, 2, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(947, '2015-01-23', '2015-12-11', NULL, 'EJECUCION', NULL, NULL, NULL, NULL, NULL, NULL, 2631490, 66870495, 2, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(950, '2015-01-23', '2015-12-11', NULL, 'EJECUCION', NULL, NULL, NULL, NULL, NULL, NULL, 2631490, 41952684, 2, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(951, '2015-01-23', '2015-12-11', NULL, 'EJECUCION', NULL, NULL, NULL, NULL, NULL, NULL, 2631490, 14796609, 2, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(985, '2015-01-23', '2015-12-11', NULL, 'EJECUCION', NULL, NULL, NULL, NULL, NULL, NULL, 2631490, 31792489, 2, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(989, '2015-01-23', '2015-12-11', NULL, 'EJECUCION', NULL, NULL, NULL, NULL, NULL, NULL, 2631490, 16552383, 2, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(992, '2015-01-23', '2015-12-11', NULL, 'EJECUCION', NULL, NULL, NULL, NULL, NULL, NULL, 66726704, 94153772, 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(1013, '2015-01-23', '2015-12-11', NULL, 'EJECUCION', NULL, NULL, NULL, NULL, NULL, NULL, 66726704, 75082123, 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(1016, '2015-01-23', '2015-12-11', 'Ã³ Ã© Ãº Ã­ Ã? Ã? Ã? Ã?', 'EJECUCION', 234444, 3456, NULL, NULL, NULL, NULL, 66726704, 1116235891, 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(1094, '2015-01-23', '2015-12-11', NULL, 'EJECUCION', NULL, NULL, NULL, NULL, NULL, NULL, 2631490, 14878719, 2, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(1095, '2015-01-23', '2015-12-11', NULL, 'EJECUCION', NULL, NULL, NULL, NULL, NULL, NULL, 66726704, 16345190, 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(1096, '2015-01-23', '2015-12-11', NULL, 'EJECUCION', NULL, NULL, NULL, NULL, NULL, NULL, 2631490, 31791842, 2, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(1098, '2015-01-23', '2015-12-11', NULL, 'EJECUCION', NULL, NULL, NULL, NULL, NULL, NULL, 2631490, 34564875, 2, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(1103, '2015-01-23', '2015-12-11', NULL, 'EJECUCION', NULL, NULL, NULL, NULL, NULL, NULL, 2631490, 34322238, 2, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(1105, '2015-01-23', '2015-12-11', NULL, 'EJECUCION', NULL, NULL, NULL, NULL, NULL, NULL, 2631490, 16366537, 2, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(1106, '2015-01-23', '2015-12-11', NULL, 'EJECUCION', NULL, NULL, NULL, NULL, NULL, NULL, 66726704, 29875954, 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(1108, '2015-01-23', '2015-12-11', NULL, 'EJECUCION', NULL, NULL, NULL, NULL, NULL, NULL, 66726704, 94229067, 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(1111, '2015-01-23', '2015-12-11', NULL, 'EJECUCION', NULL, NULL, NULL, NULL, NULL, NULL, 66726704, 1115063775, 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(1113, '2015-01-23', '2015-12-11', NULL, 'EJECUCION', NULL, NULL, NULL, NULL, NULL, NULL, 14889925, 66660491, 3, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(1116, '2015-01-23', '2015-12-11', NULL, 'EJECUCION', NULL, NULL, NULL, NULL, NULL, NULL, 14889925, 41950999, 3, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(1118, '2015-01-23', '2015-12-11', NULL, 'EJECUCION', NULL, NULL, NULL, NULL, NULL, NULL, 14889925, 41944840, 3, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(1123, '2015-01-23', '2015-12-11', NULL, 'EJECUCION', NULL, NULL, NULL, NULL, NULL, NULL, 2631490, 66902155, 2, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(1125, '2015-01-23', '2015-12-11', NULL, 'EJECUCION', NULL, NULL, NULL, NULL, NULL, NULL, 66726704, 52418009, 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(1127, '2015-01-23', '2015-12-11', NULL, 'EJECUCION', NULL, NULL, NULL, NULL, NULL, NULL, 2631490, 66719503, 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(1131, '2015-01-23', '2015-12-11', NULL, 'EJECUCION', NULL, NULL, NULL, NULL, NULL, NULL, 2631490, 66723089, 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(1134, '2015-01-23', '2015-12-11', NULL, 'EJECUCION', NULL, NULL, NULL, NULL, NULL, NULL, 2631490, 94225794, 2, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(1696, '2015-02-02', '2015-12-03', NULL, 'EJECUCION', NULL, NULL, NULL, NULL, NULL, NULL, 14889925, 31437342, 3, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(1697, '2015-02-02', '2015-12-03', NULL, 'EJECUCION', NULL, NULL, NULL, NULL, NULL, NULL, 14889925, 31794807, 3, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(1699, '2015-02-02', '2015-12-03', NULL, 'EJECUCION', NULL, NULL, NULL, NULL, NULL, NULL, 14889925, 94395028, 3, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(1701, '2015-02-02', '2015-12-03', NULL, 'EJECUCION', NULL, NULL, NULL, NULL, NULL, NULL, 14889925, 51605771, 3, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(1702, '2015-02-02', '2015-12-03', NULL, 'EJECUCION', NULL, NULL, NULL, NULL, NULL, NULL, 2631490, 6498998, 2, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(1703, '2015-02-02', '2015-12-11', NULL, 'EJECUCION', NULL, NULL, NULL, NULL, NULL, NULL, 14889925, 1116238204, 3, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(1716, '2015-02-02', '2015-12-03', NULL, 'EJECUCION', NULL, NULL, NULL, NULL, NULL, NULL, 14889925, 1110457030, 4, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(1717, '2015-02-02', '2015-12-03', NULL, 'EJECUCION', NULL, NULL, NULL, NULL, NULL, NULL, 14889925, 16222766, 4, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(1718, '2015-02-02', '2015-12-03', NULL, 'EJECUCION', NULL, NULL, NULL, NULL, NULL, NULL, 14889925, 6197502, 3, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(1720, '2015-02-02', '2015-12-03', NULL, 'EJECUCION', NULL, NULL, NULL, NULL, NULL, NULL, 14889925, 1116238490, 4, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(1724, '2015-02-02', '2015-12-03', NULL, 'EJECUCION', NULL, NULL, NULL, NULL, NULL, NULL, 14889925, 1114118406, 4, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(1730, '2015-02-02', '2015-12-03', NULL, 'EJECUCION', NULL, NULL, NULL, NULL, NULL, NULL, 14889925, 25286245, 3, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(1732, '2015-02-02', '2015-12-03', NULL, 'EJECUCION', NULL, NULL, NULL, NULL, NULL, NULL, 14889925, 16613100, 4, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(1735, '2015-02-02', '2015-12-03', NULL, 'EJECUCION', NULL, NULL, NULL, NULL, NULL, NULL, 14889925, 16260064, 4, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(1737, '2015-02-02', '2015-12-03', NULL, 'EJECUCION', NULL, NULL, NULL, NULL, NULL, NULL, 14889925, 14885006, 4, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(1741, '2015-02-02', '2015-12-03', NULL, 'EJECUCION', NULL, NULL, NULL, NULL, NULL, NULL, 14889925, 6198189, 4, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(1743, '2015-02-02', '2015-12-03', NULL, 'EJECUCION', NULL, NULL, NULL, NULL, NULL, NULL, 14889925, 10387268, 3, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(1744, '2015-02-02', '2015-12-03', NULL, 'EJECUCION', NULL, NULL, NULL, NULL, NULL, NULL, 14889925, 16231728, 3, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(1747, '2015-02-02', '2015-12-03', NULL, 'EJECUCION', NULL, NULL, NULL, NULL, NULL, NULL, 14889925, 31429208, 3, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(1748, '2015-02-02', '2015-12-03', NULL, 'EJECUCION', NULL, NULL, NULL, NULL, NULL, NULL, 14889925, 60349944, 3, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(1751, '2015-02-02', '2015-12-03', NULL, 'EJECUCION', NULL, NULL, NULL, NULL, NULL, NULL, 14889925, 94364756, 4, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(1755, '2015-02-02', '2015-12-03', NULL, 'EJECUCION', NULL, NULL, NULL, NULL, NULL, NULL, 14889925, 16367151, 4, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(1762, '2015-02-02', '2015-12-03', NULL, 'EJECUCION', NULL, NULL, NULL, NULL, NULL, NULL, 14889925, 1130613755, 4, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(1765, '2015-02-02', '2015-12-03', NULL, 'EJECUCION', NULL, NULL, NULL, NULL, NULL, NULL, 14889925, 29993888, 4, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(1768, '2015-02-02', '2015-12-03', NULL, 'EJECUCION', NULL, NULL, NULL, NULL, NULL, NULL, 14889925, 94394223, 4, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(1769, '2015-02-02', '2015-12-03', NULL, 'EJECUCION', NULL, NULL, NULL, NULL, NULL, NULL, 14889925, 16369376, 3, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(1773, '2015-02-02', '2015-12-03', NULL, 'EJECUCION', NULL, NULL, NULL, NULL, NULL, NULL, 14889925, 14898070, 4, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(1832, '2015-02-03', '2015-12-11', NULL, 'EJECUCION', NULL, NULL, NULL, NULL, NULL, NULL, 66726704, 66716789, 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(1898, '2015-02-05', '2015-12-11', NULL, 'EJECUCION', NULL, NULL, NULL, NULL, NULL, NULL, 2631490, 94300648, 2, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(1971, '2015-02-10', '2015-11-30', NULL, 'EJECUCION', NULL, NULL, NULL, NULL, NULL, NULL, 14889925, 29142993, 4, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(2133, '2015-03-02', '2015-11-27', NULL, 'EJECUCION', NULL, NULL, NULL, NULL, NULL, NULL, 66726704, 14799965, 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(2214, '2015-03-12', '2015-11-15', NULL, 'EJECUCION', NULL, NULL, NULL, NULL, NULL, NULL, 66726704, 1116253923, 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(2231, '2015-03-13', '2015-11-15', NULL, 'EJECUCION', NULL, NULL, NULL, NULL, NULL, NULL, 66726704, 76324492, 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(2592, '2015-06-03', '2015-12-12', NULL, 'EJECUCION', NULL, NULL, NULL, NULL, NULL, NULL, 14889925, 29877544, 3, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(2593, '2015-06-03', '2015-12-12', NULL, 'EJECUCION', NULL, NULL, NULL, NULL, NULL, NULL, 14889925, 29873381, 3, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(2594, '2015-06-03', '2015-12-12', NULL, 'EJECUCION', NULL, NULL, NULL, NULL, NULL, NULL, 14889925, 31791366, 3, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(2613, '2015-06-09', '2015-12-12', NULL, 'EJECUCION', NULL, NULL, NULL, NULL, NULL, NULL, 14889925, 1088588392, 3, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(2660, '2015-06-17', '2015-12-11', NULL, 'EJECUCION', NULL, NULL, NULL, NULL, NULL, NULL, 14889925, 1112102456, 3, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(2662, '2015-06-17', '2015-12-11', NULL, 'EJECUCION', NULL, NULL, NULL, NULL, NULL, NULL, 14889925, 14889105, 3, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(2856, '2015-07-15', '2015-11-30', NULL, 'EJECUCION', NULL, NULL, NULL, NULL, NULL, NULL, 14889925, 31657622, 3, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(2907, '2015-07-21', '2015-12-11', NULL, 'EJECUCION', NULL, NULL, NULL, NULL, NULL, NULL, 66726704, 29186941, 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(2908, '2015-07-21', '2015-12-11', NULL, 'EJECUCION', NULL, NULL, NULL, NULL, NULL, NULL, 66726704, 66724842, 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(2909, '2015-07-21', '2015-12-11', NULL, 'EJECUCION', NULL, NULL, NULL, NULL, NULL, NULL, 66726704, 38790099, 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(2910, '2015-07-21', '2015-12-11', NULL, 'EJECUCION', NULL, NULL, NULL, NULL, NULL, NULL, 66726704, 1116256886, 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(2911, '2015-07-21', '2015-12-11', NULL, 'EJECUCION', NULL, NULL, NULL, NULL, NULL, NULL, 66726704, 1116243314, 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(2912, '2015-07-21', '2015-12-11', NULL, 'EJECUCION', NULL, NULL, NULL, NULL, NULL, NULL, 2631490, 31939719, 2, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(2913, '2015-07-21', '2015-12-11', NULL, 'EJECUCION', NULL, NULL, NULL, NULL, NULL, NULL, 2631490, 1116240360, 2, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(2915, '2015-07-21', '2015-12-11', NULL, 'EJECUCION', NULL, NULL, NULL, NULL, NULL, NULL, 2631490, 86056316, 2, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(2916, '2015-07-21', '2015-12-11', NULL, 'EJECUCION', NULL, NULL, NULL, NULL, NULL, NULL, 2631490, 94276055, 2, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(2917, '2015-07-21', '2015-12-11', NULL, 'EJECUCION', NULL, NULL, NULL, NULL, NULL, NULL, 66726704, 31793858, 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(2918, '2015-07-21', '2015-12-11', NULL, 'EJECUCION', NULL, NULL, NULL, NULL, NULL, NULL, 66726704, 66716173, 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(2919, '2015-07-21', '2015-12-11', NULL, 'EJECUCION', NULL, NULL, NULL, NULL, NULL, NULL, 66726704, 94394545, 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(2921, '2015-07-21', '2015-12-11', NULL, 'EJECUCION', NULL, NULL, NULL, NULL, NULL, NULL, 2631490, 10031755, 2, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(2945, '2015-07-24', '2015-12-11', NULL, 'EJECUCION', NULL, NULL, NULL, NULL, NULL, NULL, 66726704, 24333313, 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(2946, '2015-07-24', '2015-12-11', NULL, 'EJECUCION', NULL, NULL, NULL, NULL, NULL, NULL, 66726704, 1116240430, 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(2947, '2015-07-24', '2015-12-11', NULL, 'EJECUCION', NULL, NULL, NULL, NULL, NULL, NULL, 66726704, 29785289, 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(2949, '2015-07-24', '2015-12-11', NULL, 'EJECUCION', NULL, NULL, NULL, NULL, NULL, NULL, 66726704, 42147334, 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(3007, '2015-08-04', '2015-12-11', NULL, 'EJECUCION', NULL, NULL, NULL, NULL, NULL, NULL, 14889925, 94392876, 4, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(3025, '2015-08-06', '2015-12-11', NULL, 'EJECUCION', NULL, NULL, NULL, NULL, NULL, NULL, 66726704, 1113038646, 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(3026, '2015-08-06', '2015-12-11', NULL, 'EJECUCION', NULL, NULL, NULL, NULL, NULL, NULL, 2631490, 94311609, 2, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(3157, '2015-09-07', '2015-11-30', NULL, 'EJECUCION', NULL, NULL, NULL, NULL, NULL, NULL, 14889925, 31793845, 3, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(3158, '2015-09-07', '2015-12-11', NULL, 'EJECUCION', NULL, NULL, NULL, NULL, NULL, NULL, 14889925, 1116238393, 3, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(3384, '2015-10-16', '2015-12-16', NULL, 'EJECUCION', NULL, NULL, NULL, NULL, NULL, NULL, 66726704, 38756665, 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
	(3385, '2015-10-16', '2015-12-16', NULL, 'EJECUCION', NULL, NULL, NULL, NULL, NULL, NULL, 66726704, 16361177, 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
/*!40000 ALTER TABLE `contrato` ENABLE KEYS */;


-- Volcando estructura para tabla gepad.controlvehicular
CREATE TABLE IF NOT EXISTS `controlvehicular` (
  `codigocontrol` int(11) NOT NULL AUTO_INCREMENT,
  `documentofuncionario` bigint(20) DEFAULT NULL,
  `placavehiculo` varchar(50) DEFAULT NULL,
  `fechacontrol` date DEFAULT NULL,
  `horasalida` varchar(50) DEFAULT NULL,
  `horallegada` varchar(50) DEFAULT NULL,
  `kmsalida` int(11) DEFAULT NULL,
  `kmllegada` int(11) DEFAULT NULL,
  PRIMARY KEY (`codigocontrol`),
  KEY `FK_controlvehicular_funcionario` (`documentofuncionario`),
  KEY `FK_controlvehicular_vehiculo` (`placavehiculo`),
  CONSTRAINT `FK_controlvehicular_funcionario` FOREIGN KEY (`documentofuncionario`) REFERENCES `funcionario` (`documentofuncionario`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_controlvehicular_vehiculo` FOREIGN KEY (`placavehiculo`) REFERENCES `vehiculo` (`placavehiculo`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla gepad.controlvehicular: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `controlvehicular` DISABLE KEYS */;
/*!40000 ALTER TABLE `controlvehicular` ENABLE KEYS */;


-- Volcando estructura para tabla gepad.coordinador
CREATE TABLE IF NOT EXISTS `coordinador` (
  `documentocoordinador` bigint(20) NOT NULL,
  `tipocoordinador` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`documentocoordinador`),
  CONSTRAINT `FK_coordinador_personal` FOREIGN KEY (`documentocoordinador`) REFERENCES `personal` (`documentopersonal`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla gepad.coordinador: ~6 rows (aproximadamente)
/*!40000 ALTER TABLE `coordinador` DISABLE KEYS */;
INSERT INTO `coordinador` (`documentocoordinador`, `tipocoordinador`) VALUES
	(2631490, 'COORDINADOR ACADEMICO'),
	(14889925, 'COORDINADOR ACADEMICO'),
	(14890737, 'SUBDIRECTOR'),
	(16794967, 'COORDINADOR DE FORMACIÓN'),
	(66726704, 'COORDINADORA ACADEMICA'),
	(94472795, 'COORDINADOR ADMINISTRATIVO');
/*!40000 ALTER TABLE `coordinador` ENABLE KEYS */;


-- Volcando estructura para tabla gepad.criterio
CREATE TABLE IF NOT EXISTS `criterio` (
  `codigocriterio` int(10) NOT NULL AUTO_INCREMENT,
  `nombrecriterio` varchar(200) DEFAULT NULL,
  `codigoelemento` int(11) DEFAULT NULL,
  PRIMARY KEY (`codigocriterio`),
  KEY `FK_criterio_elemento` (`codigoelemento`),
  CONSTRAINT `FK_criterio_elemento` FOREIGN KEY (`codigoelemento`) REFERENCES `elemento` (`codigoelemento`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla gepad.criterio: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `criterio` DISABLE KEYS */;
/*!40000 ALTER TABLE `criterio` ENABLE KEYS */;


-- Volcando estructura para tabla gepad.criterioevaluacion
CREATE TABLE IF NOT EXISTS `criterioevaluacion` (
  `codigoevaluacion` int(10) NOT NULL,
  `codigocriterio` int(10) NOT NULL,
  PRIMARY KEY (`codigoevaluacion`,`codigocriterio`),
  KEY `FK_criterioevaluacion_criterio` (`codigocriterio`),
  CONSTRAINT `FK_criterioevaluacion_criterio` FOREIGN KEY (`codigocriterio`) REFERENCES `criterio` (`codigocriterio`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_criterioevaluacion_evaluacion` FOREIGN KEY (`codigoevaluacion`) REFERENCES `evaluacion` (`codigoevaluacion`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla gepad.criterioevaluacion: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `criterioevaluacion` DISABLE KEYS */;
/*!40000 ALTER TABLE `criterioevaluacion` ENABLE KEYS */;


-- Volcando estructura para tabla gepad.dependencia
CREATE TABLE IF NOT EXISTS `dependencia` (
  `codigodependencia` int(10) NOT NULL AUTO_INCREMENT,
  `nombredependencia` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`codigodependencia`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla gepad.dependencia: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `dependencia` DISABLE KEYS */;
INSERT INTO `dependencia` (`codigodependencia`, `nombredependencia`) VALUES
	(1, 'Niabala');
/*!40000 ALTER TABLE `dependencia` ENABLE KEYS */;


-- Volcando estructura para tabla gepad.elemento
CREATE TABLE IF NOT EXISTS `elemento` (
  `codigoelemento` int(11) NOT NULL AUTO_INCREMENT,
  `nombreelemento` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`codigoelemento`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla gepad.elemento: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `elemento` DISABLE KEYS */;
/*!40000 ALTER TABLE `elemento` ENABLE KEYS */;


-- Volcando estructura para tabla gepad.elementoparticular
CREATE TABLE IF NOT EXISTS `elementoparticular` (
  `numeroserieelemento` varchar(50) NOT NULL,
  `nombreelemento` varchar(50) DEFAULT NULL,
  `accesorioselemento` text,
  PRIMARY KEY (`numeroserieelemento`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla gepad.elementoparticular: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `elementoparticular` DISABLE KEYS */;
/*!40000 ALTER TABLE `elementoparticular` ENABLE KEYS */;


-- Volcando estructura para tabla gepad.empresa
CREATE TABLE IF NOT EXISTS `empresa` (
  `numeroempresa` bigint(20) NOT NULL,
  `nombreempresa` varchar(50) DEFAULT NULL,
  `direccionempresa` varchar(50) DEFAULT NULL,
  `telefonoempresa` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`numeroempresa`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla gepad.empresa: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `empresa` DISABLE KEYS */;
/*!40000 ALTER TABLE `empresa` ENABLE KEYS */;


-- Volcando estructura para tabla gepad.eproductiva
CREATE TABLE IF NOT EXISTS `eproductiva` (
  `codigoeproductiva` int(11) NOT NULL AUTO_INCREMENT,
  `fechainicioproductiva` date DEFAULT NULL,
  `fechafinproductiva` date DEFAULT NULL,
  `funcionesproductiva` text,
  `estadoproductiva` varchar(50) DEFAULT NULL,
  `cartaproductiva` varchar(50) DEFAULT NULL,
  `formatoproductiva` varchar(50) DEFAULT NULL,
  `documentoaprendiz` bigint(20) DEFAULT NULL,
  `codigotipopractica` int(11) DEFAULT NULL,
  `numeroempresa` bigint(20) DEFAULT NULL,
  `documentocoformador` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`codigoeproductiva`),
  KEY `FK_eproductiva_aprendiz` (`documentoaprendiz`),
  KEY `FK_eproductiva_tipopractica` (`codigotipopractica`),
  KEY `FK_eproductiva_empresa` (`numeroempresa`),
  KEY `FK_eproductiva_coformador` (`documentocoformador`),
  CONSTRAINT `FK_eproductiva_aprendiz` FOREIGN KEY (`documentoaprendiz`) REFERENCES `aprendiz` (`documentoaprendiz`),
  CONSTRAINT `FK_eproductiva_coformador` FOREIGN KEY (`documentocoformador`) REFERENCES `coformador` (`documentocoformador`),
  CONSTRAINT `FK_eproductiva_empresa` FOREIGN KEY (`numeroempresa`) REFERENCES `empresa` (`numeroempresa`),
  CONSTRAINT `FK_eproductiva_tipopractica` FOREIGN KEY (`codigotipopractica`) REFERENCES `tipopractica` (`codigotipopractica`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla gepad.eproductiva: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `eproductiva` DISABLE KEYS */;
/*!40000 ALTER TABLE `eproductiva` ENABLE KEYS */;


-- Volcando estructura para tabla gepad.evaluacion
CREATE TABLE IF NOT EXISTS `evaluacion` (
  `codigoevaluacion` int(10) NOT NULL AUTO_INCREMENT,
  `tipoevaluacion` varchar(50) NOT NULL,
  `estadoevaluacion` varchar(50) NOT NULL,
  PRIMARY KEY (`codigoevaluacion`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla gepad.evaluacion: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `evaluacion` DISABLE KEYS */;
/*!40000 ALTER TABLE `evaluacion` ENABLE KEYS */;


-- Volcando estructura para tabla gepad.evaluacionaprendiz
CREATE TABLE IF NOT EXISTS `evaluacionaprendiz` (
  `codigoevaluaciona` int(10) NOT NULL AUTO_INCREMENT,
  `fechaevaluaciona` date DEFAULT NULL,
  `documentoinstructor` bigint(20) DEFAULT NULL,
  `documentoaprendiz` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`codigoevaluaciona`),
  KEY `FK_evaluacionaprendiz_instructor` (`documentoinstructor`),
  KEY `FK_evaluacionaprendiz_aprendiz` (`documentoaprendiz`),
  CONSTRAINT `FK_evaluacionaprendiz_aprendiz` FOREIGN KEY (`documentoaprendiz`) REFERENCES `aprendiz` (`documentoaprendiz`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_evaluacionaprendiz_instructor` FOREIGN KEY (`documentoinstructor`) REFERENCES `instructor` (`documentoinstructor`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla gepad.evaluacionaprendiz: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `evaluacionaprendiz` DISABLE KEYS */;
/*!40000 ALTER TABLE `evaluacionaprendiz` ENABLE KEYS */;


-- Volcando estructura para tabla gepad.evaluacioncoordinador
CREATE TABLE IF NOT EXISTS `evaluacioncoordinador` (
  `codigoevaluacionc` int(10) NOT NULL AUTO_INCREMENT,
  `fechaevaluacionc` date DEFAULT NULL,
  `documentocoordinador` bigint(20) DEFAULT NULL,
  `documentoinstructor` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`codigoevaluacionc`),
  KEY `FK_evaluacioncoordinador_coordinador` (`documentocoordinador`),
  KEY `FK_evaluacioncoordinador_instructor` (`documentoinstructor`),
  CONSTRAINT `FK_evaluacioncoordinador_coordinador` FOREIGN KEY (`documentocoordinador`) REFERENCES `coordinador` (`documentocoordinador`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_evaluacioncoordinador_instructor` FOREIGN KEY (`documentoinstructor`) REFERENCES `instructor` (`documentoinstructor`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla gepad.evaluacioncoordinador: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `evaluacioncoordinador` DISABLE KEYS */;
/*!40000 ALTER TABLE `evaluacioncoordinador` ENABLE KEYS */;


-- Volcando estructura para tabla gepad.evaluaciondesempeno
CREATE TABLE IF NOT EXISTS `evaluaciondesempeno` (
  `codigoevaluaciondesempeno` int(10) NOT NULL AUTO_INCREMENT,
  `codigoevaluacion` int(10) NOT NULL DEFAULT '0',
  `documentoinstructor` bigint(20) NOT NULL DEFAULT '0',
  `fechaevaluacion` date NOT NULL,
  `observacionesevaluacion` text NOT NULL,
  `puntajeevaluacion` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`codigoevaluaciondesempeno`),
  KEY `FK_evaluaciondesempeno_evaluacion` (`codigoevaluacion`),
  KEY `FK_evaluaciondesempeno_instructor` (`documentoinstructor`),
  CONSTRAINT `FK_evaluaciondesempeno_evaluacion` FOREIGN KEY (`codigoevaluacion`) REFERENCES `evaluacion` (`codigoevaluacion`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_evaluaciondesempeno_instructor` FOREIGN KEY (`documentoinstructor`) REFERENCES `instructor` (`documentoinstructor`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla gepad.evaluaciondesempeno: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `evaluaciondesempeno` DISABLE KEYS */;
/*!40000 ALTER TABLE `evaluaciondesempeno` ENABLE KEYS */;


-- Volcando estructura para tabla gepad.experiencia
CREATE TABLE IF NOT EXISTS `experiencia` (
  `codigoexperiencia` int(11) NOT NULL AUTO_INCREMENT,
  `empresaexperiencia` varchar(50) DEFAULT NULL,
  `ocupacionexperiencia` varchar(50) DEFAULT NULL,
  `fechaingresoexperiencia` date DEFAULT NULL,
  `fecharetiroexperiencia` date DEFAULT NULL,
  `documentoinstructor` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`codigoexperiencia`),
  KEY `FK_experiencia_instructor` (`documentoinstructor`),
  CONSTRAINT `FK_experiencia_instructor` FOREIGN KEY (`documentoinstructor`) REFERENCES `instructor` (`documentoinstructor`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla gepad.experiencia: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `experiencia` DISABLE KEYS */;
INSERT INTO `experiencia` (`codigoexperiencia`, `empresaexperiencia`, `ocupacionexperiencia`, `fechaingresoexperiencia`, `fecharetiroexperiencia`, `documentoinstructor`) VALUES
	(1, 'sdfdsf', 'fdsfdsfds', '2015-12-04', '0000-00-00', 1116235891);
/*!40000 ALTER TABLE `experiencia` ENABLE KEYS */;


-- Volcando estructura para tabla gepad.fichatitulacion
CREATE TABLE IF NOT EXISTS `fichatitulacion` (
  `fichatitulacion` int(10) NOT NULL,
  `jornadatitulacion` varchar(50) DEFAULT NULL,
  `codigoprograma` int(10) DEFAULT NULL,
  `numerosede` int(11) DEFAULT NULL,
  PRIMARY KEY (`fichatitulacion`),
  KEY `FK_titulacion_programa` (`codigoprograma`),
  KEY `FK_fichatitulacion_sede` (`numerosede`),
  CONSTRAINT `FK_fichatitulacion_sede` FOREIGN KEY (`numerosede`) REFERENCES `sede` (`numerosede`),
  CONSTRAINT `FK_titulacion_programa` FOREIGN KEY (`codigoprograma`) REFERENCES `programa` (`codigoprograma`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla gepad.fichatitulacion: ~1 rows (aproximadamente)
/*!40000 ALTER TABLE `fichatitulacion` DISABLE KEYS */;
INSERT INTO `fichatitulacion` (`fichatitulacion`, `jornadatitulacion`, `codigoprograma`, `numerosede`) VALUES
	(1, 'Diurna', 756676, 1);
/*!40000 ALTER TABLE `fichatitulacion` ENABLE KEYS */;


-- Volcando estructura para tabla gepad.formacion
CREATE TABLE IF NOT EXISTS `formacion` (
  `codigoformacion` int(11) NOT NULL AUTO_INCREMENT,
  `nombreformacion` varchar(100) DEFAULT NULL,
  `institucionformacion` varchar(100) DEFAULT NULL,
  `anioformacion` int(11) DEFAULT NULL,
  `documentoinstructor` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`codigoformacion`),
  KEY `FK_formacion_instructor` (`documentoinstructor`),
  CONSTRAINT `FK_formacion_instructor` FOREIGN KEY (`documentoinstructor`) REFERENCES `instructor` (`documentoinstructor`)
) ENGINE=InnoDB AUTO_INCREMENT=192 DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla gepad.formacion: ~191 rows (aproximadamente)
/*!40000 ALTER TABLE `formacion` DISABLE KEYS */;
INSERT INTO `formacion` (`codigoformacion`, `nombreformacion`, `institucionformacion`, `anioformacion`, `documentoinstructor`) VALUES
	(1, 'LICENCIADA EN EDUCACION PARA LAS CIENCIAS NATURALES Y EDUCACION AMBIENTAL', NULL, NULL, 31951934),
	(2, 'INGENIERIA AMBIENTAL', NULL, NULL, 94154232),
	(3, 'INGENIERIA AMBIENTAL', NULL, NULL, 94394545),
	(4, 'CONTADOR PUBLICO', NULL, NULL, 16626377),
	(5, 'CONTADOR PUBLICO', NULL, NULL, 94391225),
	(6, 'CONTADOR PUBLICO', NULL, NULL, 66726036),
	(7, 'CONTADOR PUBLICO', NULL, NULL, 1116244664),
	(8, 'CONTADOR PUBLICO', NULL, NULL, 38869122),
	(9, 'CONTADORA', NULL, NULL, 31791653),
	(10, 'CONTADOR PUBLICO', NULL, NULL, 66720662),
	(11, 'CONTADOR PUBLICO', NULL, NULL, 42015472),
	(12, 'CONTADOR PUBLICO', NULL, NULL, 16368987),
	(13, 'CONTADOR PUBLICO', NULL, NULL, 66712227),
	(14, 'ADMINISTRADOR FINANCIERO', NULL, NULL, 1116722533),
	(15, 'CONTADOR PUBLICO', NULL, NULL, 29875987),
	(16, 'FINANZAS Y COMERCIO INTERNACIONAL', NULL, NULL, 1032376771),
	(17, 'CONTADOR PUBLICO', NULL, NULL, 16361177),
	(18, 'ADMINISTRADOR DE NEGOCIOS INTERNACIONALES', NULL, NULL, 14897229),
	(19, 'NEGOCIACION INTERNACIONAL', NULL, NULL, 1116253923),
	(20, 'COMERCIO INTERNACIONAL', NULL, NULL, 1116243314),
	(21, 'INGENIERA INDUSTRIAL ', NULL, NULL, 94395869),
	(22, 'ADMINISTRADOR DE EMPRESAS', NULL, NULL, 66801799),
	(23, 'GESTION EMPRESARIAL', NULL, NULL, 29877456),
	(24, 'INGENIERO INDUSTRIAL', NULL, NULL, 94392383),
	(25, 'ADMINISTRADOR DE EMPRESAS', NULL, NULL, 6499389),
	(26, 'ADMINISTRADOR DE EMPRESAS', NULL, NULL, 31810074),
	(27, 'INGENIERO INDUSTRIAL', NULL, NULL, 94395777),
	(28, 'INGENIERIA INDUSTRIAL', NULL, NULL, 66931412),
	(29, 'ECONOMISTA', NULL, NULL, 33817719),
	(30, 'ADMINISTRACION DE EMPRESAS', NULL, NULL, 73109148),
	(31, 'ADMINISTRADORA DE EMPRESAS', NULL, NULL, 14799474),
	(32, 'ADMINISTRADOR DE EMPRESAS', NULL, NULL, 76324492),
	(33, 'ADMINISTRACION DE EMPRESAS', NULL, NULL, 29186941),
	(34, 'ADMINISTRACION DE EMPRESAS', NULL, NULL, 66724842),
	(35, 'ADMINISTRACION DE EMPRESAS', NULL, NULL, 38790099),
	(36, 'INGENIERA INDUSTRIAL ', NULL, NULL, 31793858),
	(37, 'ABOGADA', NULL, NULL, 31193147),
	(38, 'ABOGADA', NULL, NULL, 66716173),
	(39, 'ENFERMERA', NULL, NULL, 29873118),
	(40, 'ENFERMERA', NULL, NULL, 31203237),
	(41, 'ADMINISTRACION EN SALUD', NULL, NULL, 3482453),
	(42, 'SALUD OCUPACIONAL', NULL, NULL, 16632002),
	(43, 'FISIOTERAPEUTA ESPECIALISTA EN SALUD OCUPACIONAL', NULL, NULL, 65785466),
	(44, 'SALUD OCUPACIONAL', NULL, NULL, 76306931),
	(45, 'SALUD OCUPACIONAL', NULL, NULL, 29785289),
	(46, 'SALUD OCUPACIONAL', NULL, NULL, 38756665),
	(47, 'INGENIERO EN SISTEMAS', NULL, NULL, 94153772),
	(48, 'INGENIERO DE SISTEMAS', NULL, NULL, 75082123),
	(49, 'INGENIERO EN SISTEMAS', NULL, NULL, 1116235891),
	(50, 'SISTEMAS DE INFORMACION', NULL, NULL, 16345190),
	(51, 'INGENIERO DE SISTEMAS', NULL, NULL, 29875954),
	(52, 'INGENIERO EN SISTEMAS', NULL, NULL, 94229067),
	(53, 'TECNOLOGO EN ADMINISTRACION DE REDES DE COMPUTADORES', NULL, NULL, 1115063775),
	(54, 'INGENIERO DE SISTEMAS', NULL, NULL, 14799965),
	(55, 'INGENIERO DE SISTEMAS', NULL, NULL, 1116240430),
	(56, 'INGENIERO DE SISTEMAS', NULL, NULL, 1113038646),
	(57, 'LICENCIADO EDUCACION BASICA CON ENFASIS EN EDUCACION FISICA', NULL, NULL, 14796542),
	(58, 'LICENCIADO EDUCACION FISICA', NULL, NULL, 94153675),
	(59, 'INGENIERO ELECTRICISTA', NULL, NULL, 4408060),
	(60, 'INGENIERO ELECTRICO', NULL, NULL, 1116235537),
	(61, 'MECANICA', NULL, NULL, 16355511),
	(62, 'PSICOLOGO', NULL, NULL, 94151777),
	(63, 'SALUD OCUPACIONAL', NULL, NULL, 29309904),
	(64, 'CONTADOR PUBLICO', NULL, NULL, 66716789),
	(65, 'LICENCIADO EN LENGUAS EXTRANJERAS', NULL, NULL, 1116242450),
	(66, 'LICENCIADA EN LENGUAS MODERNAS', NULL, NULL, 30311965),
	(67, 'LICENCIADO EN EDUCACION BASICA CON ENFASIS EN LENGUAS EXTRANJERAS', NULL, NULL, 1116256886),
	(68, 'CONTADOR PUBLICO', NULL, NULL, 31202853),
	(69, 'ADMINISTRADOR PUBLICO', NULL, NULL, 19315061),
	(70, 'DISEÑADORA DE MODAS', NULL, NULL, 52418009),
	(71, 'PUBLICIDAD Y MERCADEO', NULL, NULL, 24333313),
	(72, 'COMUNICADORA SOCIAL', NULL, NULL, 37729607),
	(73, 'COMUNICACIÓN ', NULL, NULL, 1112100266),
	(74, 'SICOLOGA', NULL, NULL, 29433366),
	(75, 'PSICOLOGO', NULL, NULL, 29287323),
	(76, 'LICENCIATURA EN CIENCIAS RELIGIOSAS Y ETICA', NULL, NULL, 43508604),
	(77, 'ADMINISTRACION TURISTICA', NULL, NULL, 1116235700),
	(78, 'ADMINISTRADOR HOTELERO Y TURISTICO', NULL, NULL, 9736754),
	(79, 'ADMINISTRACION DE EMPRESAS HOTELERAS Y TURISTICAS', NULL, NULL, 91438736),
	(80, 'TECNOLOGO TURISMO RECREATIVO', NULL, NULL, 1088294650),
	(81, 'GUIANZA TURISTICA', NULL, NULL, 42147334),
	(82, 'INGENIERIA AGRONOMICA', NULL, NULL, 14882452),
	(83, 'INGENIERIA AGRONOMICA', NULL, NULL, 16280474),
	(84, 'INGENIERA AGRÍCOLA', NULL, NULL, 31416143),
	(85, 'INGENIERO AGRÍCOLA', NULL, NULL, 12187322),
	(86, 'INGENIERO AGRONOMO', NULL, NULL, 16358684),
	(87, 'INGENIERO AGRONOMO', NULL, NULL, 1467461),
	(88, 'INGENIERA AGROFORESTAL', NULL, NULL, 34322238),
	(89, 'INGENIERA AGRONOMA', NULL, NULL, 66902155),
	(90, 'INGENIERO AGRONOMO', NULL, NULL, 94300648),
	(91, 'INGENIERA EN ALIMENTOS', NULL, NULL, 31189608),
	(92, 'TECNOLOGO EN ALIMENTOS', NULL, NULL, 14891728),
	(93, 'INGENIERIA DE ALIMENTOS', NULL, NULL, 1116240360),
	(94, 'INGENIERO AMBIENTAL', NULL, NULL, 38794509),
	(95, 'INGENIERA AMBIENTAL', NULL, NULL, 29873150),
	(96, 'INGENIERO AMBIENTAL', NULL, NULL, 6498932),
	(97, 'INGENIERIA DE RECURSOS NATURALES Y MEDIO AMBIENTE', NULL, NULL, 66725854),
	(98, 'INGENIERA AMBIENTAL', NULL, NULL, 38790890),
	(99, 'INGENIERIA DE RECURSOS NATURALES Y MEDIO AMBIENTE', NULL, NULL, 94153900),
	(100, 'INGENIERIA QUIMICA', NULL, NULL, 38874052),
	(101, 'BIOLOGA', NULL, NULL, 31939719),
	(102, 'ADMINISTRADORA FINANCIERA', NULL, NULL, 24582678),
	(103, 'CONTADOR PUBLICO', NULL, NULL, 94393714),
	(104, 'CONTADOR PUBLICO', NULL, NULL, 66870495),
	(105, 'CONTADOR PUBLICO', NULL, NULL, 31792489),
	(106, 'LICENCIADO EDUCACION FISICA', NULL, NULL, 94387680),
	(107, 'LICENCIADO EN EDUCACION BASICA CON ENFASIS EN EDUCACION FISICA, RECREACION Y DEPORTES', NULL, NULL, 6498998),
	(108, 'TRABAJADORA SOCIAL', NULL, NULL, 66803909),
	(109, 'PSICOLOGO', NULL, NULL, 31194207),
	(110, 'TRABAJADORA SOCIAL', NULL, NULL, 1116235526),
	(111, 'COMUNICACIÓN SOCIAL Y PERIODISTA', NULL, NULL, 1115065269),
	(112, 'PSICOLOGIA', NULL, NULL, 38791047),
	(113, 'PSICOLOGA', NULL, NULL, 29784485),
	(114, 'SICOLOGO', NULL, NULL, 94276055),
	(115, 'ZOOTECNISTA', NULL, NULL, 26471980),
	(116, 'ZOOTECNISTA', NULL, NULL, 14892405),
	(117, 'ZOOTECNISTA', NULL, NULL, 29178689),
	(118, 'ADMINISTRADOR DE EMPRESAS AGROPECUARIAS', NULL, NULL, 86056316),
	(119, 'ZOOCTENISTA', NULL, NULL, 10031755),
	(120, 'ZOOCTENIA', NULL, NULL, 94311609),
	(121, 'ADMINISTRADORA DE EMPRESAS AGROPECUARIAS', NULL, NULL, 29757606),
	(122, 'ADMINISTRADOR DE EMPRESAS AGROPECUARIAS', NULL, NULL, 41952684),
	(123, 'ADMINISTRADOR DE EMPRESAS', NULL, NULL, 14878719),
	(124, 'ADMINISTRADOR DE EMPRESAS AGROPECUARIAS', NULL, NULL, 34564875),
	(125, 'ADMINISTRACION DE EMPRESAS', NULL, NULL, 94225794),
	(126, 'BACTERIOLOGA', NULL, NULL, 31791842),
	(127, 'SALUD OCUPACIONAL', NULL, NULL, 66719503),
	(128, ' SALUD OCUPACIONAL', NULL, NULL, 66723089),
	(129, 'INGENIERO ELECTRONICO', NULL, NULL, 14796609),
	(130, 'ADMINISTRADOR DE SISTEMAS INFORMATICOS', NULL, NULL, 16552383),
	(131, 'INGENIERO DE SISTEMAS', NULL, NULL, 16366537),
	(132, 'ADMINISTRADOR DE EMPRESAS AGROPECUARIAS', NULL, NULL, 31793192),
	(133, 'INGENIERO AGROECOLOGICO', NULL, NULL, 17658884),
	(134, 'INGENIERO AGRONOMO ', NULL, NULL, 31983737),
	(135, 'ADMINISTRADORA DE EMPRESAS AGROPECUARIAS', NULL, NULL, 29875145),
	(136, 'INGENIERO AGRONOMO ', NULL, NULL, 71905008),
	(137, 'TECNOLOGO EN AGROPECUARIA AMBIENTAL', NULL, NULL, 14799364),
	(138, 'INGENIERO AGROINDUSTRIAL', NULL, NULL, 66660491),
	(139, 'FILOSOFIA', NULL, NULL, 10387268),
	(140, 'LICENCIATURA EN EDUCACION BASICA CON ENFASIS EN LENGUAS EXTRANJERAS', NULL, NULL, 31791366),
	(141, 'INGENIERO AGRONOMO', NULL, NULL, 66724717),
	(142, 'INGENIERA DE RECURSOS NATURALES Y MEDIO AMBIENTE', NULL, NULL, 29877544),
	(143, 'ADMINISTRADOR DE EMPRESAS', NULL, NULL, 38859741),
	(144, 'ADMINISTRADOR DE EMPRESAS', NULL, NULL, 31791348),
	(145, 'ADMINSITRACION FINANCIERA', NULL, NULL, 21811664),
	(146, 'ADMINISTRADOR DE EMPRESAS', NULL, NULL, 29817337),
	(147, 'TECNOLOGO EN ADMINISTRACION AGROPECUARIA', NULL, NULL, 41950999),
	(148, 'ADMINISTRADORA DE EMPRESAS', NULL, NULL, 1116238204),
	(149, 'CONTADOR PUBLICO', NULL, NULL, 31755103),
	(150, 'ADMINISTRADOR FINANCIERO', NULL, NULL, 6498352),
	(151, 'CONTADOR PUBLICO', NULL, NULL, 31189932),
	(152, 'ADMINISTRADORA FINANCIERA', NULL, NULL, 38792768),
	(153, 'PROFESIONAL EN DEPORTE Y ACTIVIDAD FISICA', NULL, NULL, 60349944),
	(154, 'MAESTRO EN EDUCACION FISICA Y DEPORTES', NULL, NULL, 14889105),
	(155, 'PSICOLOGA', NULL, NULL, 31794807),
	(156, 'PSICOLOGA', NULL, NULL, 51605771),
	(157, 'HISTORIA', NULL, NULL, 25286245),
	(158, 'PSICOLOGA', NULL, NULL, 31429208),
	(159, 'SICOLOGA', NULL, NULL, 1112102456),
	(160, 'GESTION DOCUMENTAL', NULL, NULL, 31437342),
	(161, 'HOTELERIA Y TURISMOS ECOLOGICO', NULL, NULL, 41944840),
	(162, 'INGENIERO EN SISTEMAS', NULL, NULL, 94395028),
	(163, 'TECNOLOGÍA EN ADMINISTRACIÓN DEL ENSAMBLE Y MANTENIMIENTO DE COMPUTADORES Y REDES', NULL, NULL, 6197502),
	(164, 'INGENIERO DE SISTEMAS', NULL, NULL, 16231728),
	(165, 'TECNOLOGO EN INGENIERIA DE SISTEMAS', NULL, NULL, 16369376),
	(166, 'INGENIERO DE SISTEMAS', NULL, NULL, 14800977),
	(167, 'FISIOTERAPIA', NULL, NULL, 1116238393),
	(168, 'ZOOTECNISTA', NULL, NULL, 16234415),
	(169, 'MEDICO VETERINARIO ZOOTECNISTA', NULL, NULL, 66983210),
	(170, 'ZOOTECNISTA', NULL, NULL, 1088588392),
	(171, 'ADMINISTRACION DE EMPRESAS', NULL, NULL, 31657622),
	(172, 'INGENIERIA INDUSTRIAL', NULL, NULL, 38796631),
	(173, 'INGENIERA INDUSTRIAL ', NULL, NULL, 29873381),
	(174, 'INGENIERIA DE SISTEMAS', NULL, NULL, 31793845),
	(175, 'INGENIERO AGROINDUSTRIAL', NULL, NULL, 14703817),
	(176, 'ADMINISTRACION AGROPECUARIA', NULL, NULL, 1114118406),
	(177, 'INGENIERIA AGRONOMICA', NULL, NULL, 16613100),
	(178, 'INGENIERO AGRONOMO ', NULL, NULL, 16260064),
	(179, 'INGENIERO AGRONOMO', NULL, NULL, 14885006),
	(180, 'INGENIERO AGRONOMO ', NULL, NULL, 6198189),
	(181, 'ADMINISTRADOR DE EMPRESAS AGROPECUARIAS', NULL, NULL, 29993888),
	(182, 'INGENIERIA AGRONOMICA', NULL, NULL, 14898070),
	(183, 'ADMINISTRADOR DE EMPRESAS', NULL, NULL, 16367151),
	(184, 'PROFESIONAL EN FINANZAS Y NEGOCIOS INTERNACIONALES', NULL, NULL, 1130613755),
	(185, 'INGENIERO INDUSTRIAL', NULL, NULL, 94394223),
	(186, 'CONTADOR PUBLICO', NULL, NULL, 29142993),
	(187, 'ADMINISTRACION DE NEGOCIOS INTERNACIONALES', NULL, NULL, 94392876),
	(188, 'MEDICO VETERINARIO ZOOTECNISTA', NULL, NULL, 1110457030),
	(189, 'ADMINISTRADOR DE EMPRESAS AGROPECUARIAS', NULL, NULL, 16222766),
	(190, 'ADMINISTRADORA DE EMPRESAS AGROPECUARIAS', NULL, NULL, 1116238490),
	(191, 'ADMINISTRADOR DE EMPRESAS AGROPECUARIAS', NULL, NULL, 94364756);
/*!40000 ALTER TABLE `formacion` ENABLE KEYS */;


-- Volcando estructura para tabla gepad.funcionario
CREATE TABLE IF NOT EXISTS `funcionario` (
  `documentofuncionario` bigint(20) NOT NULL,
  `codigoarea` int(11) NOT NULL,
  PRIMARY KEY (`documentofuncionario`),
  KEY `FK_funcionario_area` (`codigoarea`),
  CONSTRAINT `FK_funcionario_area` FOREIGN KEY (`codigoarea`) REFERENCES `area` (`codigoarea`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_funcionario_personal` FOREIGN KEY (`documentofuncionario`) REFERENCES `personal` (`documentopersonal`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla gepad.funcionario: ~2 rows (aproximadamente)
/*!40000 ALTER TABLE `funcionario` DISABLE KEYS */;
INSERT INTO `funcionario` (`documentofuncionario`, `codigoarea`) VALUES
	(16345190, 1),
	(37729607, 1);
/*!40000 ALTER TABLE `funcionario` ENABLE KEYS */;


-- Volcando estructura para tabla gepad.guarda
CREATE TABLE IF NOT EXISTS `guarda` (
  `documentoguarda` bigint(20) NOT NULL,
  PRIMARY KEY (`documentoguarda`),
  CONSTRAINT `FK_guarda_personal` FOREIGN KEY (`documentoguarda`) REFERENCES `personal` (`documentopersonal`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla gepad.guarda: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `guarda` DISABLE KEYS */;
INSERT INTO `guarda` (`documentoguarda`) VALUES
	(16345190);
/*!40000 ALTER TABLE `guarda` ENABLE KEYS */;


-- Volcando estructura para tabla gepad.hablaidioma
CREATE TABLE IF NOT EXISTS `hablaidioma` (
  `documentoinstructor` bigint(20) NOT NULL,
  `codigoidioma` int(11) NOT NULL,
  `nivelhabla` varchar(50) DEFAULT NULL,
  `nivelescribe` varchar(50) DEFAULT NULL,
  `nivellee` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`documentoinstructor`,`codigoidioma`),
  KEY `FK_hablaidioma_idioma` (`codigoidioma`),
  CONSTRAINT `FK_hablaidioma_idioma` FOREIGN KEY (`codigoidioma`) REFERENCES `idioma` (`codigoidioma`),
  CONSTRAINT `FK_hablaidioma_instructor` FOREIGN KEY (`documentoinstructor`) REFERENCES `instructor` (`documentoinstructor`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla gepad.hablaidioma: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `hablaidioma` DISABLE KEYS */;
/*!40000 ALTER TABLE `hablaidioma` ENABLE KEYS */;


-- Volcando estructura para tabla gepad.idioma
CREATE TABLE IF NOT EXISTS `idioma` (
  `codigoidioma` int(11) NOT NULL AUTO_INCREMENT,
  `nombreidioma` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`codigoidioma`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla gepad.idioma: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `idioma` DISABLE KEYS */;
/*!40000 ALTER TABLE `idioma` ENABLE KEYS */;


-- Volcando estructura para tabla gepad.informe
CREATE TABLE IF NOT EXISTS `informe` (
  `codigoinforme` int(11) NOT NULL AUTO_INCREMENT,
  `fechainforme` date DEFAULT NULL,
  `periodoinforme` varchar(100) DEFAULT NULL,
  `codigomonitor` int(11) DEFAULT NULL,
  `balanceinforme` text,
  `sugerenciasinforme` text,
  `archivoevidencias` longblob,
  `estadoinforme` varchar(50) DEFAULT NULL,
  `observacionesinforme` text,
  PRIMARY KEY (`codigoinforme`),
  KEY `FK_informe_monitor` (`codigomonitor`),
  CONSTRAINT `FK_informe_monitor` FOREIGN KEY (`codigomonitor`) REFERENCES `monitor` (`codigomonitor`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla gepad.informe: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `informe` DISABLE KEYS */;
/*!40000 ALTER TABLE `informe` ENABLE KEYS */;


-- Volcando estructura para tabla gepad.ingreso
CREATE TABLE IF NOT EXISTS `ingreso` (
  `numeroingreso` int(11) NOT NULL AUTO_INCREMENT,
  `fechaingreso` date DEFAULT NULL,
  `horaingreso` varchar(50) DEFAULT NULL,
  `horasalida` varchar(50) DEFAULT NULL,
  `motivoingreso` text,
  `documentopersonal` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`numeroingreso`),
  KEY `FK_ingreso_personal` (`documentopersonal`),
  CONSTRAINT `FK_ingreso_personal` FOREIGN KEY (`documentopersonal`) REFERENCES `personal` (`documentopersonal`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla gepad.ingreso: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `ingreso` DISABLE KEYS */;
/*!40000 ALTER TABLE `ingreso` ENABLE KEYS */;


-- Volcando estructura para tabla gepad.ingresoelemento
CREATE TABLE IF NOT EXISTS `ingresoelemento` (
  `numeroserielemento` varchar(50) NOT NULL,
  `numeroingreso` int(11) NOT NULL,
  PRIMARY KEY (`numeroserielemento`,`numeroingreso`),
  KEY `FK_ingresoelemento_ingreso` (`numeroingreso`),
  CONSTRAINT `FK_ingresoelemento_elementoparticular` FOREIGN KEY (`numeroserielemento`) REFERENCES `elementoparticular` (`numeroserieelemento`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_ingresoelemento_ingreso` FOREIGN KEY (`numeroingreso`) REFERENCES `ingreso` (`numeroingreso`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla gepad.ingresoelemento: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `ingresoelemento` DISABLE KEYS */;
/*!40000 ALTER TABLE `ingresoelemento` ENABLE KEYS */;


-- Volcando estructura para tabla gepad.instructor
CREATE TABLE IF NOT EXISTS `instructor` (
  `documentoinstructor` bigint(20) NOT NULL,
  `tipoinstructor` varchar(50) DEFAULT NULL,
  `perfilocupacionalinstructor` text,
  `logrosinstructor` text,
  PRIMARY KEY (`documentoinstructor`),
  CONSTRAINT `FK_instructor_personal` FOREIGN KEY (`documentoinstructor`) REFERENCES `personal` (`documentopersonal`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla gepad.instructor: ~192 rows (aproximadamente)
/*!40000 ALTER TABLE `instructor` DISABLE KEYS */;
INSERT INTO `instructor` (`documentoinstructor`, `tipoinstructor`, `perfilocupacionalinstructor`, `logrosinstructor`) VALUES
	(1467461, 'CONTRATISTA', 'AGRICOLA\r', NULL),
	(3482453, 'CONTRATISTA', 'SALUD\r', NULL),
	(4408060, 'CONTRATISTA', 'INSTALACIONES ELECTRICAS Y SISTEMAS\r', NULL),
	(6197502, 'CONTRATISTA', 'INFORMATICA\r', NULL),
	(6198189, 'CONTRATISTA', 'AGRICOLA\r', NULL),
	(6498352, 'CONTRATISTA', 'CONTABILIDAD\r', NULL),
	(6498932, 'CONTRATISTA', 'AMBIENTAL\r', NULL),
	(6498998, 'CONTRATISTA', 'CULTURA FISICA\r', NULL),
	(6499389, 'CONTRATISTA', 'COMERCIO, PROCESOS ADMINISTRATIVOS\r', NULL),
	(7553074, 'CONTRATISTA', 'COMERCIO', NULL),
	(9736754, 'CONTRATISTA', 'HOTELERIA Y TURISMO\r', NULL),
	(10031755, 'CONTRATISTA', 'PECUARIA\r', NULL),
	(10387268, 'CONTRATISTA', 'BILINGUISMO\r', NULL),
	(12187322, 'CONTRATISTA', 'AGRICOLA\r', NULL),
	(14703817, 'CONTRATISTA', 'AGROINDUSTRIA\r', NULL),
	(14796542, 'CONTRATISTA', 'CULTURA FISICA\r', NULL),
	(14796609, 'CONTRATISTA', 'SISTEMAS\r', NULL),
	(14799364, 'CONTRATISTA', 'AGRICOLA\r', NULL),
	(14799474, 'CONTRATISTA', 'COMERCIO, PROCESOS ADMINISTRATIVOS, MERCADEO\r', NULL),
	(14799965, 'CONTRATISTA', 'SISTEMAS\r', NULL),
	(14800977, 'CONTRATISTA', 'SISTEMAS\r', NULL),
	(14878719, 'CONTRATISTA', 'PROCESOS ADMINISTRATIVOS, \r', NULL),
	(14882452, 'CONTRATISTA', 'AGRICOLA\r', NULL),
	(14885006, 'CONTRATISTA', 'AGRICOLA\r', NULL),
	(14889105, 'CONTRATISTA', 'CULTURA FISICA\r', NULL),
	(14891728, 'CONTRATISTA', 'AGROINDUSTRIA\r', NULL),
	(14892405, 'CONTRATISTA', 'PECUARIA\r', NULL),
	(14897229, 'CONTRATISTA', 'COMERCIO INTERNACIONAL\r', NULL),
	(14898070, 'CONTRATISTA', 'AGRICOLA\r', NULL),
	(16222766, 'CONTRATISTA', 'PECUARIA\r', NULL),
	(16231728, 'CONTRATISTA', 'INFORMATICA\r', NULL),
	(16234415, 'CONTRATISTA', 'PECUARIA\r', NULL),
	(16260064, 'CONTRATISTA', 'AGRICOLA\r', NULL),
	(16280474, 'CONTRATISTA', 'AGRICOLA\r', NULL),
	(16345190, 'CONTRATISTA', 'SISTEMAS\r', NULL),
	(16355511, 'CONTRATISTA', 'SOLDADURA, VENTA DE PRODUCTOS\r', NULL),
	(16358684, 'CONTRATISTA', 'AGRICOLA\r', NULL),
	(16361177, 'CONTRATISTA', 'CONTABILIDAD , MATEMATICA FINANCIERA\r', NULL),
	(16366537, 'CONTRATISTA', 'SISTEMAS\r', NULL),
	(16367151, 'CONTRATISTA', 'COMERCIALIZACION\r', NULL),
	(16368987, 'CONTRATISTA', 'CONTABILIDAD , MATEMATICA FINANCIERA\r', NULL),
	(16369376, 'CONTRATISTA', 'INFORMATICA\r', NULL),
	(16552383, 'CONTRATISTA', 'SISTEMAS\r', NULL),
	(16613100, 'CONTRATISTA', 'AGRICOLA\r\n', ''),
	(16626377, 'CONTRATISTA', 'CONTABILIDAD Y FINANZAS\r', NULL),
	(16632002, 'CONTRATISTA', 'SALUD OCUPACIONAL\r', NULL),
	(17658884, 'CONTRATISTA', 'AGRICOLA\r', NULL),
	(19315061, 'CONTRATISTA', 'VIRTUALIZACION\r', NULL),
	(21811664, 'CONTRATISTA', 'COMERCIO\r', NULL),
	(24333313, 'CONTRATISTA', 'DISEÑO GRAFICO\r', NULL),
	(24582678, 'CONTRATISTA', 'BILINGUISMO\r', NULL),
	(25286245, 'CONTRATISTA', 'ETICA Y COMUNICACIÓN\r', NULL),
	(26471980, 'CONTRATISTA', 'PECUARIA\r', NULL),
	(29142993, 'CONTRATISTA', 'COMERCIALIZACION\r', NULL),
	(29178689, 'CONTRATISTA', 'PECUARIA\r', NULL),
	(29186941, 'CONTRATISTA', 'COMERCIO\r', NULL),
	(29287323, 'CONTRATISTA', 'ETICA Y COMUNICACIÓN\r', NULL),
	(29309904, 'CONTRATISTA', 'PEDAGOGIA\r', NULL),
	(29433366, 'CONTRATISTA', 'ETICA Y COMUNICACIÓN\r', NULL),
	(29757606, 'CONTRATISTA', 'PROCESOS ADMINISTRATIVOS, \r', NULL),
	(29784485, 'CONTRATISTA', 'ETICA Y COMUNICACIÓN\r', NULL),
	(29785289, 'CONTRATISTA', 'SALUD OCUPACIONAL\r', NULL),
	(29817337, 'CONTRATISTA', 'COMERCIO\r', NULL),
	(29873118, 'CONTRATISTA', 'SALUD \r', NULL),
	(29873150, 'CONTRATISTA', 'AMBIENTAL\r', NULL),
	(29873381, 'CONTRATISTA', 'SALUD OCUPACIONAL\r', NULL),
	(29875145, 'CONTRATISTA', 'AGRICOLA\r', NULL),
	(29875954, 'CONTRATISTA', 'SISTEMAS Y GESTION DOCUMENTAL\r', NULL),
	(29875987, 'CONTRATISTA', 'CONTABILIDAD\r', NULL),
	(29877456, 'CONTRATISTA', 'COMERCIO, PROCESOS ADMINISTRATIVOS\r', NULL),
	(29877544, 'CONTRATISTA', 'AMBIENTAL\r', NULL),
	(29993888, 'CONTRATISTA', 'AGRICOLA\r', NULL),
	(30311965, 'CONTRATISTA', 'BILINGUISMO\r', NULL),
	(31189608, 'CONTRATISTA', 'AGROINDUSTRIA\r', NULL),
	(31189932, 'CONTRATISTA', 'CONTABILIDAD\r', NULL),
	(31193147, 'CONTRATISTA', 'POLITICA INSTITUCIONAL\r', NULL),
	(31194207, 'CONTRATISTA', 'ETICA Y COMUNICACIÓN\r', NULL),
	(31202853, 'CONTRATISTA', 'VIRTUALIZACION\r\n', 'ffffff'),
	(31203237, 'CONTRATISTA', 'SALUD\r', NULL),
	(31416143, 'CONTRATISTA', 'AGRICOLA\r', NULL),
	(31429208, 'CONTRATISTA', 'ETICA Y COMUNICACIÓN\r', NULL),
	(31437342, 'CONTRATISTA', 'GESTION DOCUMENTAL\r', NULL),
	(31657622, 'CONTRATISTA', 'PEDAGOGIA\r', NULL),
	(31755103, 'CONTRATISTA', 'CONTABILIDAD\r', NULL),
	(31791348, 'CONTRATISTA', 'COMERCIO\r', NULL),
	(31791366, 'CONTRATISTA', 'BILINGUISMO\r', NULL),
	(31791653, 'CONTRATISTA', 'CONTABILIDAD , MATEMATICA FINANCIERA\r', NULL),
	(31791842, 'CONTRATISTA', 'SALUD OCUPACIONAL\r', NULL),
	(31792489, 'CONTRATISTA', 'CONTABILIDAD\r', NULL),
	(31793192, 'CONTRATISTA', 'AGRICOLA\r', NULL),
	(31793845, 'CONTRATISTA', 'SALUD OCUPACIONAL\r', NULL),
	(31793858, 'CONTRATISTA', 'COMERCIO, PROCESOS ADMINISTRATIVOS, MERCADEO\r', NULL),
	(31794807, 'CONTRATISTA', 'ETICA Y COMUNICACIÓN\r', NULL),
	(31810074, 'CONTRATISTA', 'COMERCIO, PROCESOS ADMINISTRATIVOS\r', NULL),
	(31939719, 'CONTRATISTA', 'AMBIENTAL\r', NULL),
	(31951934, 'CONTRATISTA', 'AMBIENTAL\r', NULL),
	(31983737, 'CONTRATISTA', 'AGRICOLA\r', NULL),
	(33817719, 'CONTRATISTA', 'COMERCIO, PROCESOS ADMINISTRATIVOS,MERCADEO\r', NULL),
	(34322238, 'CONTRATISTA', 'AGRICOLA\r', NULL),
	(34564875, 'CONTRATISTA', 'PROCESOS ADMINISTRATIVOS\r', NULL),
	(37729607, 'CONTRATISTA', 'ETICA Y COMUNICACIÓN\r', NULL),
	(38756665, 'CONTRATISTA', 'SALUD OCUPACIONAL\r', NULL),
	(38790099, 'CONTRATISTA', 'COMERCIO\r', NULL),
	(38790890, 'CONTRATISTA', 'AMBIENTAL\r', NULL),
	(38791047, 'CONTRATISTA', 'ETICA Y COMUNICACIÓN\r', NULL),
	(38792768, 'CONTRATISTA', 'CONTABILIDAD\r', NULL),
	(38794509, 'CONTRATISTA', 'AMBIENTAL\r', NULL),
	(38796631, 'CONTRATISTA', 'SALUD OCUPACIONAL\r\n', 'dddd'),
	(38859741, 'CONTRATISTA', 'COMERCIO\r', NULL),
	(38869122, 'CONTRATISTA', 'CONTABILIDAD , MATEMATICA FINANCIERA\r', NULL),
	(38874052, 'CONTRATISTA', 'AMBIENTAL\r', NULL),
	(41944840, 'CONTRATISTA', 'HOTELERIA Y TURISMO\r', NULL),
	(41950999, 'CONTRATISTA', 'COMERCIO\r', NULL),
	(41952684, 'CONTRATISTA', 'PROCESOS ADMINISTRATIVOS, \r', NULL),
	(42015472, 'CONTRATISTA', 'CONTABILIDAD , MATEMATICA FINANCIERA\r', NULL),
	(42147334, 'CONTRATISTA', 'HOTELERIA Y TURISMO\r', NULL),
	(43508604, 'CONTRATISTA', 'ETICA Y COMUNICACIÓN\r', NULL),
	(51605771, 'CONTRATISTA', 'ETICA Y COMUNICACIÓN\r', NULL),
	(52418009, 'CONTRATISTA', 'DISEÑO DE MODA\r', NULL),
	(60349944, 'CONTRATISTA', 'CULTURA FISICA\r', NULL),
	(65785466, 'CONTRATISTA', 'SALUD OCUPACIONAL\r', NULL),
	(66660491, 'CONTRATISTA', 'AGRICOLA\r', NULL),
	(66712227, 'CONTRATISTA', 'CONTABILIDAD , MATEMATICA FINANCIERA\r', NULL),
	(66716173, 'CONTRATISTA', 'POLITICA INSTITUCIONAL\r', NULL),
	(66716789, 'CONTRATISTA', 'PEDAGOGIA\r', NULL),
	(66719503, 'CONTRATISTA', 'SALUD OCUPACIONAL\r', NULL),
	(66720662, 'CONTRATISTA', 'CONTABILIDAD , MATEMATICA FINANCIERA\r', NULL),
	(66723089, 'CONTRATISTA', 'SALUD OCUPACIONAL\r', NULL),
	(66724717, 'CONTRATISTA', 'AMBIENTAL\r', NULL),
	(66724842, 'CONTRATISTA', 'COMERCIO\r', NULL),
	(66725854, 'CONTRATISTA', 'AMBIENTAL\r', NULL),
	(66726036, 'CONTRATISTA', 'CONTABILIDAD , MATEMATICA FINANCIERA\r', NULL),
	(66801799, 'CONTRATISTA', 'COMERCIO, PROCESOS ADMINISTRATIVOS\r', NULL),
	(66803909, 'CONTRATISTA', 'ETICA Y COMUNICACIÓN\r', NULL),
	(66870495, 'CONTRATISTA', 'CONTABILIDAD\r', NULL),
	(66902155, 'CONTRATISTA', 'AGRICOLA\r', NULL),
	(66931412, 'CONTRATISTA', 'COMERCIO, PROCESOS ADMINISTRATIVOS, SALUD OCUPACIONAL\r', NULL),
	(66983210, 'CONTRATISTA', 'PECUARIA\r', NULL),
	(71905008, 'CONTRATISTA', 'AGRICOLA\r', NULL),
	(73109148, 'CONTRATISTA', 'COMERCIO, PROCESOS ADMINISTRATIVOS, MERCADEO\r', NULL),
	(75082123, 'CONTRATISTA', 'SISTEMAS\r', NULL),
	(76306931, 'CONTRATISTA', 'SALUD OCUPACIONAL\r', NULL),
	(76324492, 'CONTRATISTA', 'COMERCIO, PROCESOS ADMINISTRATIVOS,MERCADEO\r', NULL),
	(86056316, 'CONTRATISTA', 'PECUARIA\r', NULL),
	(91438736, 'CONTRATISTA', 'HOTELERIA Y TURISMO\r', NULL),
	(94151777, 'CONTRATISTA', 'PEDAGOGIA\r', NULL),
	(94153675, 'CONTRATISTA', 'CULTURA FISICA\r', NULL),
	(94153772, 'CONTRATISTA', 'SISTEMAS\r\n', 'asdasd'),
	(94153900, 'CONTRATISTA', 'AMBIENTAL\r', NULL),
	(94154232, 'CONTRATISTA', 'AMBIENTAL\r', NULL),
	(94225794, 'CONTRATISTA', 'PROCESOS ADMINISTRATIVOS\r', NULL),
	(94229067, 'CONTRATISTA', 'SISTEMAS\r', NULL),
	(94276055, 'CONTRATISTA', 'ETICA Y COMUNICACIÓN\r', NULL),
	(94300648, 'CONTRATISTA', 'AGRICOLA\r', NULL),
	(94311609, 'CONTRATISTA', 'PECUARIA\r', NULL),
	(94364756, 'CONTRATISTA', 'PECUARIA\r', NULL),
	(94387680, 'CONTRATISTA', 'CULTURA FISICA\r', NULL),
	(94391225, 'CONTRATISTA', 'CONTABILIDAD, MATEMATICA FINANCIERA\r', NULL),
	(94392383, 'CONTRATISTA', 'COMERCIO, PROCESOS ADMINISTRATIVOS\r', NULL),
	(94392876, 'CONTRATISTA', 'COMERCIALIZACION\r', NULL),
	(94393714, 'CONTRATISTA', 'CONTABILIDAD\r', NULL),
	(94394223, 'CONTRATISTA', 'COMERCIALIZACION\r', NULL),
	(94394545, 'CONTRATISTA', 'AMBIENTAL\r', NULL),
	(94395028, 'CONTRATISTA', 'INFORMATICA\r', NULL),
	(94395777, 'CONTRATISTA', 'COMERCIO, PROCESOS ADMINISTRATIVOS\r', NULL),
	(94395869, 'CONTRATISTA', 'COMERCIO, PROCESOS ADMINISTRATIVOS\r', NULL),
	(1032376771, 'CONTRATISTA', 'CONTABILIDAD , MATEMATICA FINANCIERA\r', NULL),
	(1088294650, 'CONTRATISTA', 'HOTELERIA Y TURISMO\r', NULL),
	(1088588392, 'CONTRATISTA', 'PECUARIA\r', NULL),
	(1110457030, 'CONTRATISTA', 'PECUARIA\r', NULL),
	(1112100266, 'CONTRATISTA', 'ETICA Y COMUNICACIÓN\r', NULL),
	(1112102456, 'CONTRATISTA', 'ETICA Y COMUNICACIÓN\r', NULL),
	(1113038646, 'CONTRATISTA', 'SISTEMAS\r', NULL),
	(1114118406, 'CONTRATISTA', 'AGRICOLA\r', NULL),
	(1115063775, 'CONTRATISTA', 'SISTEMAS\r\n', 'asdasds'),
	(1115065269, 'CONTRATISTA', 'ETICA Y COMUNICACIÓN\r', NULL),
	(1116235526, 'CONTRATISTA', 'ETICA Y COMUNICACIÓN\r', NULL),
	(1116235537, 'CONTRATISTA', 'INSTALACIONES ELECTRICAS Y SISTEMAS\r', NULL),
	(1116235700, 'CONTRATISTA', 'HOTELERIA Y TURISMO\r', NULL),
	(1116235891, 'CONTRATISTA', 'INGENIERIA DE SISTEMAS y INGENIERIA DE SISTEMAS y INGENIERIA DE SISTEMAS y INGENIERIA DE SISTEMASINGENIERIA DE SISTEMASINGENIERIA DE SISTEMASINGENIERIA DE SISTEMASvvINGENIERIA DE SISTEMASINGENIERIA DE SISTEMASINGENIERIA DE SISTEMASINGENIERIA DE SISTEMASINGENIERIA DE SISTEMASv', 'participacion'),
	(1116238204, 'CONTRATISTA', 'COMERCIO\r', NULL),
	(1116238393, 'CONTRATISTA', 'SISTEMAS\r', NULL),
	(1116238490, 'CONTRATISTA', 'PECUARIA\r', NULL),
	(1116240360, 'CONTRATISTA', 'AGROINDUSTRIA\r', NULL),
	(1116240430, 'CONTRATISTA', 'SISTEMAS\r', NULL),
	(1116242450, 'CONTRATISTA', 'BILINGUISMO\r', NULL),
	(1116243314, 'CONTRATISTA', 'COMERCIO, COMERCIO INTERNACIONAL\r', NULL),
	(1116244664, 'CONTRATISTA', 'CONTABILIDAD , MATEMATICA FINANCIERA\r', NULL),
	(1116253923, 'CONTRATISTA', 'COMERCIO INTERNACIONAL\r', NULL),
	(1116256886, 'CONTRATISTA', 'BILINGUISMO\r', NULL),
	(1116722533, 'CONTRATISTA', 'CONTABILIDAD , MATEMATICA FINANCIERA\r', NULL),
	(1130613755, 'CONTRATISTA', 'COMERCIALIZACION\r', NULL);
/*!40000 ALTER TABLE `instructor` ENABLE KEYS */;


-- Volcando estructura para tabla gepad.lideresficha
CREATE TABLE IF NOT EXISTS `lideresficha` (
  `documentoinstructor` bigint(20) NOT NULL,
  `fichatitulacion` int(11) NOT NULL,
  `fechaasignacion` date DEFAULT NULL,
  PRIMARY KEY (`documentoinstructor`,`fichatitulacion`),
  KEY `FK_lideresficha_instructor` (`documentoinstructor`),
  KEY `FK_lideresficha_fichatitulacion` (`fichatitulacion`),
  CONSTRAINT `FK_lideresficha_fichatitulacion` FOREIGN KEY (`fichatitulacion`) REFERENCES `fichatitulacion` (`fichatitulacion`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_lideresficha_instructor` FOREIGN KEY (`documentoinstructor`) REFERENCES `instructor` (`documentoinstructor`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla gepad.lideresficha: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `lideresficha` DISABLE KEYS */;
/*!40000 ALTER TABLE `lideresficha` ENABLE KEYS */;


-- Volcando estructura para tabla gepad.lineacentro
CREATE TABLE IF NOT EXISTS `lineacentro` (
  `codigolinea` int(11) NOT NULL AUTO_INCREMENT,
  `nombrelinea` varchar(50) DEFAULT NULL,
  `codigocentrolinea` int(11) DEFAULT NULL,
  PRIMARY KEY (`codigolinea`),
  KEY `FK_lineacentro_centro` (`codigocentrolinea`),
  CONSTRAINT `FK_lineacentro_centro` FOREIGN KEY (`codigocentrolinea`) REFERENCES `centro` (`codigocentro`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla gepad.lineacentro: ~4 rows (aproximadamente)
/*!40000 ALTER TABLE `lineacentro` DISABLE KEYS */;
INSERT INTO `lineacentro` (`codigolinea`, `nombrelinea`, `codigocentrolinea`) VALUES
	(1, 'COMERCIO Y SERVICIOS', 9125),
	(2, 'ESPECIES MENORES', 9125),
	(3, 'ARTICULACIÓN', 9125),
	(4, 'JOVENES RURALES', 9125);
/*!40000 ALTER TABLE `lineacentro` ENABLE KEYS */;


-- Volcando estructura para tabla gepad.monitor
CREATE TABLE IF NOT EXISTS `monitor` (
  `codigomonitor` int(11) NOT NULL AUTO_INCREMENT,
  `documentoaprendiz` bigint(20) DEFAULT NULL,
  `codigotipomonitoria` int(11) DEFAULT NULL,
  `documentopersonal` bigint(20) DEFAULT NULL,
  `fechainiciomonitoria` date DEFAULT NULL,
  `fechafinmonitoria` date DEFAULT NULL,
  `proyectomonitor` text,
  `estadomonitoria` varchar(50) DEFAULT NULL,
  `numerocuentamonitor` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`codigomonitor`),
  KEY `FK_monitor_aprendiz` (`documentoaprendiz`),
  KEY `FK_monitor_personal` (`documentopersonal`),
  KEY `FK_monitor_tipomonitoria` (`codigotipomonitoria`),
  CONSTRAINT `FK_monitor_aprendiz` FOREIGN KEY (`documentoaprendiz`) REFERENCES `aprendiz` (`documentoaprendiz`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_monitor_personal` FOREIGN KEY (`documentopersonal`) REFERENCES `personal` (`documentopersonal`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_monitor_tipomonitoria` FOREIGN KEY (`codigotipomonitoria`) REFERENCES `tipomonitoria` (`codigotipomonitoria`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla gepad.monitor: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `monitor` DISABLE KEYS */;
/*!40000 ALTER TABLE `monitor` ENABLE KEYS */;


-- Volcando estructura para tabla gepad.noticia
CREATE TABLE IF NOT EXISTS `noticia` (
  `numeronoticia` int(11) NOT NULL AUTO_INCREMENT,
  `titulonoticia` varchar(100) DEFAULT NULL,
  `descripcionnoticia` text,
  `fechapublicacionnoticia` date DEFAULT NULL,
  PRIMARY KEY (`numeronoticia`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla gepad.noticia: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `noticia` DISABLE KEYS */;
/*!40000 ALTER TABLE `noticia` ENABLE KEYS */;


-- Volcando estructura para tabla gepad.novedad
CREATE TABLE IF NOT EXISTS `novedad` (
  `numeronovedad` int(11) NOT NULL AUTO_INCREMENT,
  `nombrenovedad` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`numeronovedad`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla gepad.novedad: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `novedad` DISABLE KEYS */;
/*!40000 ALTER TABLE `novedad` ENABLE KEYS */;


-- Volcando estructura para tabla gepad.pago
CREATE TABLE IF NOT EXISTS `pago` (
  `codigopago` int(11) NOT NULL AUTO_INCREMENT,
  `numeropago` int(11) DEFAULT NULL,
  `fechainiciopago` date DEFAULT NULL,
  `fechafinpago` date DEFAULT NULL,
  `saldoanteriorpago` int(11) DEFAULT NULL,
  `saldonuevopago` int(11) DEFAULT NULL,
  `numerocontratopago` int(11) DEFAULT NULL,
  `numerohoraspago` int(11) DEFAULT NULL,
  `diasliquidarpago` int(11) DEFAULT NULL,
  `numeroplanillapago` int(11) DEFAULT NULL,
  `ibcpago` int(11) DEFAULT NULL,
  `aportessaludpago` int(11) DEFAULT NULL,
  `aportepensionpago` int(11) DEFAULT NULL,
  `aportesolidariopago` int(11) DEFAULT NULL,
  `aportearl` int(11) DEFAULT NULL,
  `ahorrovoluntariopago` int(11) DEFAULT NULL,
  `dependientespago` int(11) DEFAULT NULL,
  `saludprepagadapago` int(11) DEFAULT NULL,
  `interesviviendapago` int(11) DEFAULT NULL,
  PRIMARY KEY (`codigopago`),
  KEY `FK__contrato` (`numerocontratopago`),
  CONSTRAINT `FK__contrato` FOREIGN KEY (`numerocontratopago`) REFERENCES `contrato` (`numerocontrato`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla gepad.pago: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `pago` DISABLE KEYS */;
/*!40000 ALTER TABLE `pago` ENABLE KEYS */;


-- Volcando estructura para tabla gepad.permiso
CREATE TABLE IF NOT EXISTS `permiso` (
  `codigopermiso` int(10) NOT NULL AUTO_INCREMENT,
  `fechapermiso` date DEFAULT NULL,
  `horadesdepermiso` varchar(50) DEFAULT NULL,
  `horahastapermiso` varchar(50) DEFAULT NULL,
  `motivopermiso` text,
  `estadopermiso` varchar(50) DEFAULT NULL,
  `documentocoordinador` bigint(20) DEFAULT NULL,
  `documentoinstructor` bigint(20) DEFAULT NULL,
  `documentoaprendiz` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`codigopermiso`),
  KEY `FK_permiso_coordinador` (`documentocoordinador`),
  KEY `FK_permiso_instructor` (`documentoinstructor`),
  KEY `FK_permiso_aprendiz` (`documentoaprendiz`),
  CONSTRAINT `FK_permiso_aprendiz` FOREIGN KEY (`documentoaprendiz`) REFERENCES `aprendiz` (`documentoaprendiz`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_permiso_coordinador` FOREIGN KEY (`documentocoordinador`) REFERENCES `coordinador` (`documentocoordinador`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_permiso_instructor` FOREIGN KEY (`documentoinstructor`) REFERENCES `instructor` (`documentoinstructor`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla gepad.permiso: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `permiso` DISABLE KEYS */;
/*!40000 ALTER TABLE `permiso` ENABLE KEYS */;


-- Volcando estructura para tabla gepad.personal
CREATE TABLE IF NOT EXISTS `personal` (
  `documentopersonal` bigint(20) NOT NULL,
  `nombrepersonal` varchar(100) NOT NULL,
  `apellidopersonal` varchar(100) NOT NULL,
  `direccionpersonal` varchar(100) DEFAULT NULL,
  `correopersonal` varchar(100) DEFAULT NULL,
  `telefonopersonal` varchar(100) DEFAULT NULL,
  `clavepersonal` varchar(255) DEFAULT NULL,
  `fechanacimientopersonal` date DEFAULT NULL,
  `lugarnacimientopersonal` varchar(50) DEFAULT NULL,
  `fotopersonal` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`documentopersonal`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla gepad.personal: ~198 rows (aproximadamente)
/*!40000 ALTER TABLE `personal` DISABLE KEYS */;
INSERT INTO `personal` (`documentopersonal`, `nombrepersonal`, `apellidopersonal`, `direccionpersonal`, `correopersonal`, `telefonopersonal`, `clavepersonal`, `fechanacimientopersonal`, `lugarnacimientopersonal`, `fotopersonal`) VALUES
	(1467461, ' JOSE FERNEY ', 'MONTES MORENO\r', NULL, NULL, NULL, '1467461', NULL, NULL, ''),
	(2631490, 'JAVIER', 'PEDROZA JARAMILLO', '', NULL, NULL, '2631490', '0000-00-00', '', ''),
	(3482453, 'DUBERLEY ', 'OSORIO PATIÑO \r', NULL, NULL, NULL, '3482453', NULL, NULL, ''),
	(4408060, ' JORGE IVAN ', 'JIMENEZ SERNA\r', NULL, NULL, NULL, '4408060', NULL, NULL, ''),
	(6197502, 'MAGNOL', 'OSSA LINARES \r', NULL, NULL, NULL, '6197502', NULL, NULL, ''),
	(6198189, 'EDISON', 'RAMIREZ OROZCO \r', NULL, NULL, NULL, '6198189', NULL, NULL, ''),
	(6498352, 'HOMERO ALFONSO', 'DUQUE ZULUAGA \r', NULL, NULL, NULL, '6498352', NULL, NULL, ''),
	(6498932, ' ADALBERTO ', 'LOPEZ OROZCO\r', NULL, NULL, NULL, '6498932', NULL, NULL, ''),
	(6498998, ' JHON ABAD ', 'FLOREZ SEPULVEDA\r', NULL, NULL, NULL, '6498998', NULL, NULL, ''),
	(6499389, ' JORGE OLMEDO ', 'GUEVARA BELALCAZAR\r', NULL, NULL, NULL, '6499389', NULL, NULL, ''),
	(7553074, 'LUIS RODOLFO', 'HUTADO', NULL, NULL, NULL, '7553074', NULL, NULL, NULL),
	(9736754, 'GONZALO ANDRES ', 'CANO FERNANDEZ \r', NULL, NULL, NULL, '9736754', NULL, NULL, ''),
	(10031755, 'BORIS DANIEL ', 'VELASQUEZ GUTIERREZ\r', NULL, NULL, NULL, '10031755', NULL, NULL, ''),
	(10387268, 'FAVIO  ', 'SOLIS CUENU\r', NULL, NULL, NULL, '10387268', NULL, NULL, ''),
	(12187322, 'JOSE ALIRIO ', 'MUÑOZ \r', NULL, NULL, NULL, '12187322', NULL, NULL, ''),
	(14703817, 'CARLOS ALBERTO', 'GIRALDO MARIN \r', NULL, NULL, NULL, '14703817', NULL, NULL, ''),
	(14796542, 'OSCAR VICENTE ', 'OTALVORA CIFUENTES\r', NULL, NULL, NULL, '14796542', NULL, NULL, ''),
	(14796609, ' JULIAN ANDRES ', 'GARCIA GIRALDO\r', NULL, NULL, NULL, '14796609', NULL, NULL, ''),
	(14799364, ' GERMAN ALONSO ', 'CASTILLO ORJUELA\r', NULL, NULL, NULL, '14799364', NULL, NULL, ''),
	(14799474, ' RUBEN DARIO ', 'HINCAPIE ROBLES\r', NULL, NULL, NULL, '14799474', NULL, NULL, ''),
	(14799965, 'ALEXANDER ', 'ATEHORTUA CARVAJAL  \r', NULL, NULL, NULL, '14799965', NULL, NULL, ''),
	(14800977, 'DIEGO ALEXANDER', 'GOMEZ GOMEZ \r', NULL, NULL, NULL, '14800977', NULL, NULL, ''),
	(14878719, 'JAMES ', 'DOMINGUEZ ARAGON \r', NULL, NULL, NULL, '14878719', NULL, NULL, ''),
	(14882452, 'ADRIANO ', 'SARRIA SALGUERO \r', NULL, NULL, NULL, '14882452', NULL, NULL, ''),
	(14885006, 'JAVIER', 'GIRALDO HERRERA \r', NULL, NULL, NULL, '14885006', NULL, NULL, ''),
	(14889105, 'OSCAR FERNADO ', 'SANCHEZ PIZARRO\r', NULL, NULL, NULL, '14889105', NULL, NULL, ''),
	(14889925, 'DARIO GERMAN', 'MARTINEZ MONTOYA', '', NULL, NULL, '14889925', '0000-00-00', '', ''),
	(14890737, 'GERMÁN', 'SUÁREZ GARCÍA', '', NULL, NULL, '14890737', '0000-00-00', '', ''),
	(14891728, ' JULIAN ', 'VILLARRUEL SARMIENTO\r', NULL, NULL, NULL, '14891728', NULL, NULL, ''),
	(14892405, ' FABIAN ALEXANDER ', 'ANGEL ANGEL\r', NULL, NULL, NULL, '14892405', NULL, NULL, ''),
	(14897229, ' ALBETH ', 'MARTINEZ VALENCIA\r', NULL, NULL, NULL, '14897229', NULL, NULL, ''),
	(14898070, 'HERY FABIAN', 'VIAFARA MILLAN \r', NULL, NULL, NULL, '14898070', NULL, NULL, ''),
	(16222766, 'JHONNY ALEXANDER', 'NUÑEZ FLOREZ \r', NULL, NULL, NULL, '16222766', NULL, NULL, ''),
	(16231728, 'DIEGO FERNANDO', 'GRAJALES MUÑOZ \r', NULL, NULL, NULL, '16231728', NULL, NULL, ''),
	(16234415, 'ALEXANDER', 'ALDANA MEJIA \r', NULL, NULL, NULL, '16234415', NULL, NULL, ''),
	(16260064, 'JORGE LUIS', 'MONDRAGON SAA \r', NULL, NULL, NULL, '16260064', NULL, NULL, ''),
	(16280474, ' JORGE ELIECER ', 'RIVADENEIRA GONZALEZ\r', NULL, NULL, NULL, '16280474', NULL, NULL, ''),
	(16345190, ' ALBERTO ', 'LONDOÑO VALENCIA\r', NULL, NULL, NULL, '16345190', NULL, NULL, ''),
	(16355511, 'MARIO ', 'QUINTERO SUAZA \r', NULL, NULL, NULL, '16355511', NULL, NULL, ''),
	(16358684, ' CARLOS ARTURO ', 'BEJARANO MENDOZA\r', NULL, NULL, NULL, '16358684', NULL, NULL, ''),
	(16361177, ' RUBIEL ', 'GONZALEZ OCHOA\r', NULL, NULL, NULL, '16361177', NULL, NULL, ''),
	(16366537, ' HUGO FERNANDO ', 'ZULUAGA OSPINA\r', NULL, NULL, NULL, '16366537', NULL, NULL, ''),
	(16367151, 'MAURICIO', 'POLANCO HUERTAS \r', NULL, NULL, NULL, '16367151', NULL, NULL, ''),
	(16368987, ' FERNANDO ALONSO ', 'ARIAS RAMIREZ\r', NULL, NULL, NULL, '16368987', NULL, NULL, ''),
	(16369376, 'LUIS FERNANDO', 'ALMANZA VELASQUEZ \r', NULL, NULL, NULL, '16369376', NULL, NULL, ''),
	(16552383, 'JUAN CAMILO', ' LEMOS GIL \r', NULL, NULL, NULL, '16552383', NULL, NULL, ''),
	(16613100, 'JAIME', ' ARCE BURBANO', 'SDSAD', 'JAIME', '343', '16613100', '2015-12-01', 'DASDASD', '16613100.jpg'),
	(16626377, 'OSCAR DARIO ', 'SANCHEZ RODRIGUEZ \r', NULL, NULL, NULL, '16626377', NULL, NULL, ''),
	(16632002, ' JORGE ENRIQUE', 'QUINTERO BAUTISTA\r', NULL, NULL, NULL, '16632002', NULL, NULL, ''),
	(16794967, 'JHON FERNANDO', 'VILLADA SERNA', '', NULL, NULL, '16794967', '0000-00-00', '', ''),
	(17658884, 'CARLOS AUGUSTO ', 'GAVIRIA ALBAÑIL \r', NULL, NULL, NULL, '17658884', NULL, NULL, ''),
	(19315061, 'ABEL JOSE ', 'SABOGAL CRUZ \r', NULL, NULL, NULL, '19315061', NULL, NULL, ''),
	(21811664, 'BEATRIZ ELENA ', 'VERA CADAVID \r', NULL, NULL, NULL, '21811664', NULL, NULL, ''),
	(24333313, 'MARGARITA MARIA ', 'SANCHEZ HENAO\r', NULL, NULL, NULL, '24333313', NULL, NULL, ''),
	(24582678, 'ELIANA PATRICIA  ', 'RESTREPO HENAO\r', NULL, NULL, NULL, '24582678', NULL, NULL, ''),
	(25286245, 'MARIA DEL MAR ', 'ILLERA CAJIAO\r', NULL, NULL, NULL, '25286245', NULL, NULL, ''),
	(26471980, 'ESMERALDA', 'RODRIGUEZ ROJAS \r', NULL, NULL, NULL, '26471980', NULL, NULL, ''),
	(29142993, ' OLGA SOFIA', ' GONZALEZ ARIAS\r', NULL, NULL, NULL, '29142993', NULL, NULL, ''),
	(29178689, ' PAOLA ANDREA ', 'JIMENEZ TORRES\r', NULL, NULL, NULL, '29178689', NULL, NULL, ''),
	(29186941, ' MARIA ANDREA ', 'DE LA TORRE VIDARTE\r', NULL, NULL, NULL, '29186941', NULL, NULL, ''),
	(29287323, 'ANGELA MARIA ', 'GOMEZ PEÑA \r', NULL, NULL, NULL, '29287323', NULL, NULL, ''),
	(29309904, 'SANDRA YULIETH ', 'GARCIA GONZALES \r', NULL, NULL, NULL, '29309904', NULL, NULL, ''),
	(29433366, 'ROSA  ', 'LILIANA PEREZ\r', NULL, NULL, NULL, '29433366', NULL, NULL, ''),
	(29757606, ' MARCELA CAROLINA ', 'ROJAS RAYO\r', NULL, NULL, NULL, '29757606', NULL, NULL, ''),
	(29784485, 'SORLEYDA', 'MEDINA RAMIREZ \r', NULL, NULL, NULL, '29784485', NULL, NULL, ''),
	(29785289, 'PAOLA ANDREA ', 'CALDERON ZAPATA\r', NULL, NULL, NULL, '29785289', NULL, NULL, ''),
	(29817337, ' MARTHA CECILIA ', 'RAMIREZ TABARES\r', NULL, NULL, NULL, '29817337', NULL, NULL, ''),
	(29873118, 'VICTORIA EUGENIA', ' GOMEZ BRAVO \r', NULL, NULL, NULL, '29873118', NULL, NULL, ''),
	(29873150, ' VIADID ', 'MARTINEZ ROMERO\r', NULL, NULL, NULL, '29873150', NULL, NULL, ''),
	(29873381, 'YULI VANESA', ' DAVILA MUÑOZ\r', NULL, NULL, NULL, '29873381', NULL, NULL, ''),
	(29875145, ' ROSMERY ', 'CORTES ESCOBAR\r', NULL, NULL, NULL, '29875145', NULL, NULL, ''),
	(29875954, ' GLORIA YANETH ', 'LOPEZ RAMIREZ\r', NULL, NULL, NULL, '29875954', NULL, NULL, ''),
	(29875987, 'PAULA ANDREA ', 'LOPEZ HERRERA \r', NULL, NULL, NULL, '29875987', NULL, NULL, ''),
	(29877456, ' DIANA MARIA ', 'TRIANA MEJIA\r', NULL, NULL, NULL, '29877456', NULL, NULL, ''),
	(29877544, 'ALEJANDRA ', 'MARIA PLAZAS SANTA\r', NULL, NULL, NULL, '29877544', NULL, NULL, ''),
	(29993888, 'NANCY', 'BETANCOURTH BADOS \r', NULL, NULL, NULL, '29993888', NULL, NULL, ''),
	(30311965, ' MARGARITA MARIA ', 'VILLA LONDOÑO\r', NULL, NULL, NULL, '30311965', NULL, NULL, ''),
	(31189608, 'GLORIA MERY  ', 'RUSSI COY\r', NULL, NULL, NULL, '31189608', NULL, NULL, ''),
	(31189932, 'MIRYAM', 'FARFAN \r', NULL, NULL, NULL, '31189932', NULL, NULL, ''),
	(31193147, 'MARIA ISABEL', ' MUÑOZ MANTILLA \r', NULL, NULL, NULL, '31193147', NULL, NULL, ''),
	(31194207, 'AMANDA  ', 'GIRALDO TOBON\r', NULL, NULL, NULL, '31194207', NULL, NULL, ''),
	(31202853, ' BIBIANA ', 'ALVAREZ FONSECA', 'FWEFEWR', 'SFSAD', '34324', '31202853', '2015-12-08', 'RRRR', 'foto bibiana.jpg'),
	(31203237, 'ODALID AMPARO', ' CASTRILLON GUTIERREZ \r', NULL, NULL, NULL, '31203237', NULL, NULL, ''),
	(31416143, ' MARIELA', ' VALENCIA\r', NULL, NULL, NULL, '31416143', NULL, NULL, ''),
	(31429208, 'MARTHA ELENA', 'SOTO AGUDELO \r', NULL, NULL, NULL, '31429208', NULL, NULL, ''),
	(31437342, 'ILEANA', 'DURAN MONSALVE \r', NULL, NULL, NULL, '31437342', NULL, NULL, ''),
	(31657622, 'VIVIANA ANDREA ', 'OSPINA HOLGUIN\r', NULL, NULL, NULL, '31657622', NULL, NULL, ''),
	(31755103, 'YANETH', 'POSSO WILCHES \r', NULL, NULL, NULL, '31755103', NULL, NULL, ''),
	(31791348, 'CLAUDIA XIMENA  ', 'VILLEGAS RAMIREZ\r', NULL, NULL, NULL, '31791348', NULL, NULL, ''),
	(31791366, 'MARITZA ', 'ROMAN RODRIGUEZ\r', NULL, NULL, NULL, '31791366', NULL, NULL, ''),
	(31791653, ' DIANA PATRICIA ', 'CANO MARQUEZ\r', NULL, NULL, NULL, '31791653', NULL, NULL, ''),
	(31791842, 'MARIA ALEJANDRA  ', 'MONTAÑO LOPEZ\r', NULL, NULL, NULL, '31791842', NULL, NULL, ''),
	(31792489, ' MONICA ANDREA ', 'GOMEZ BARONA\r', NULL, NULL, NULL, '31792489', NULL, NULL, ''),
	(31793192, ' KATHERINE ', 'HEDMONT SANCHEZ\r', NULL, NULL, NULL, '31793192', NULL, NULL, ''),
	(31793845, 'CAROLINA', ' ARIAS ALZATE\r', NULL, NULL, NULL, '31793845', NULL, NULL, ''),
	(31793858, ' DIANA LORENA', ' GONZALEZ VALENCIA\r', NULL, NULL, NULL, '31793858', NULL, NULL, ''),
	(31794807, 'CLAUDIA LORENA', 'ALEGRIA RINCON \r', NULL, NULL, NULL, '31794807', NULL, NULL, ''),
	(31810074, ' MARIA CECILIA ', 'CHAVEZ GUTIERREZ\r', NULL, NULL, NULL, '31810074', NULL, NULL, ''),
	(31939719, 'LILIANA ALEXANDRA ', 'TOBOS TIJARO\r', NULL, NULL, NULL, '31939719', NULL, NULL, ''),
	(31951934, 'MARIA DEL CARMEN', 'CACERES CALDERON\r', NULL, NULL, NULL, '31951934', NULL, NULL, ''),
	(31983737, ' MONICA ', 'HERNANDEZ ALVAREZ\r', NULL, NULL, NULL, '31983737', NULL, NULL, ''),
	(33817719, ' SANDRA MILENA ', 'REY LIZARAZO\r', NULL, NULL, NULL, '33817719', NULL, NULL, ''),
	(34322238, 'MARITZA ALEJANDRA  ', 'NOGUERA JIMENEZ\r', NULL, NULL, NULL, '34322238', NULL, NULL, ''),
	(34564875, 'MARIA TERESA  ', 'VALENCIA PINEDA\r', NULL, NULL, NULL, '34564875', NULL, NULL, ''),
	(37729607, ' ANA MILENA ', 'POVEDA MANJARRES\r', NULL, NULL, NULL, '37729607', NULL, NULL, ''),
	(38756665, 'YURY YANED', 'ORDOÑEZ GARCIA \r', NULL, NULL, NULL, '38756665', NULL, NULL, ''),
	(38790099, 'ALEJANDRA CECILIA ', 'MEJIA AGUDELO\r', NULL, NULL, NULL, '38790099', NULL, NULL, ''),
	(38790890, ' JANIS BIVIANA ', 'CHICA MUÑOZ\r', NULL, NULL, NULL, '38790890', NULL, NULL, ''),
	(38791047, 'LEIDY VIVIANA', 'HOYOS RAMIREZ\r', NULL, NULL, NULL, '38791047', NULL, NULL, ''),
	(38792768, 'MARIA DEL PILAR', 'FRANKY GONZALEZ \r', NULL, NULL, NULL, '38792768', NULL, NULL, ''),
	(38794509, 'LORENA ROCIO ', 'LOPEZ ARCINIEGAS \r', NULL, NULL, NULL, '38794509', NULL, NULL, ''),
	(38796631, 'NATALIA', 'LONDOÃ?Â?Ã?Â?O SANCHEZ ', 'DDDDDD', 'DDD', '3333', '38796631', '2015-12-23', 'DDDD', 'RUIZ_GABRIEL.jpg'),
	(38859741, 'FANNY  ', 'MARIN GIRALDO\r', NULL, NULL, NULL, '38859741', NULL, NULL, ''),
	(38869122, 'BERTHA LUCIA ', 'ORTIZ LOZANO\r', NULL, NULL, NULL, '38869122', NULL, NULL, ''),
	(38874052, ' AMANDA ', 'RIVERA DIAZ\r', NULL, NULL, NULL, '38874052', NULL, NULL, ''),
	(41944840, 'LIDA PATRICIA', 'MURIEL ROJAS \r', NULL, NULL, NULL, '41944840', NULL, NULL, ''),
	(41950999, 'MAYERLINE  ', 'CARDONA MARTÍNEZ\r', NULL, NULL, NULL, '41950999', NULL, NULL, ''),
	(41952684, ' MARÍA TERESA ', 'SABOGAL RESTREPO\r', NULL, NULL, NULL, '41952684', NULL, NULL, ''),
	(42015472, 'PAULA MARIA ', 'MARIN VARGAS \r', NULL, NULL, NULL, '42015472', NULL, NULL, ''),
	(42147334, 'MARIA YANETH ', 'GIRALDO GALLEGO\r', NULL, NULL, NULL, '42147334', NULL, NULL, ''),
	(43508604, ' ANA ISABEL ', 'SANCHEZ SALAZAR\r', NULL, NULL, NULL, '43508604', NULL, NULL, ''),
	(51605771, 'SANDRA ISABEL', 'NOVOA NARVAEZ \r', NULL, NULL, NULL, '51605771', NULL, NULL, ''),
	(52418009, ' MONICA ', 'MARIN FRANKLIN\r', NULL, NULL, NULL, '52418009', NULL, NULL, ''),
	(60349944, 'BERLY DEL ROSARIO', 'LOZANO \r', NULL, NULL, NULL, '60349944', NULL, NULL, ''),
	(65785466, ' ANGELICA MARIA ', 'RODRIGUEZ VERA\r', NULL, NULL, NULL, '65785466', NULL, NULL, ''),
	(66660491, 'MARIA ISABEL  ', 'VARELA QUINTERO\r', NULL, NULL, NULL, '66660491', NULL, NULL, ''),
	(66712227, ' YANETH ', 'GOMEZ NOVOA\r', NULL, NULL, NULL, '66712227', NULL, NULL, ''),
	(66716173, 'MARIA EUGENIA ', 'DUQUE GRAJALES\r', NULL, NULL, NULL, '66716173', NULL, NULL, ''),
	(66716789, ' GLORIA AMPARO ', 'CHARRIA CEREZO\r', NULL, NULL, NULL, '66716789', NULL, NULL, ''),
	(66719503, ' DORA CONSTANZA ', 'GONZALEZ FERNANDEZ\r', NULL, NULL, NULL, '66719503', NULL, NULL, ''),
	(66720662, ' PAULA ANDREA ', 'SANCHEZ OLIVEROS\r', NULL, NULL, NULL, '66720662', NULL, NULL, ''),
	(66723089, ' ELSA ', 'CAICEDO CUERO\r', NULL, NULL, NULL, '66723089', NULL, NULL, ''),
	(66724717, ' ELEONORA ', 'ECHEVERRY ZAFRA\r', NULL, NULL, NULL, '66724717', NULL, NULL, ''),
	(66724842, 'CLAUDIA ROSA', ' MARTINEZ NARANJO\r', NULL, NULL, NULL, '66724842', NULL, NULL, ''),
	(66725854, 'CLAUDIA ANDREA ', 'DURAN RODRIGUEZ \r', NULL, NULL, NULL, '66725854', NULL, NULL, ''),
	(66726036, 'CAROLINE ', 'PEREA CABAL\r', NULL, NULL, NULL, '66726036', NULL, NULL, ''),
	(66726704, 'MARIA CRISTINA', 'LEMUS PEREZ', '', NULL, NULL, '66726704', '0000-00-00', '', ''),
	(66801799, ' CRISTINA ', 'LOZANO SARRIA\r', NULL, NULL, NULL, '66801799', NULL, NULL, ''),
	(66803909, 'CATALINA ', 'ROJAS VALENCIA\r', NULL, NULL, NULL, '66803909', NULL, NULL, ''),
	(66870495, ' ANA LUCIA ', 'RODRIGUEZ RODRIGUEZ\r', NULL, NULL, NULL, '66870495', NULL, NULL, ''),
	(66902155, 'SANDRA FLORENTINA  ', 'ORTIZ USECHE\r', NULL, NULL, NULL, '66902155', NULL, NULL, ''),
	(66931412, ' SANDRA MILENA ', 'HURTADO PRADO\r', NULL, NULL, NULL, '66931412', NULL, NULL, ''),
	(66983210, 'ROCIO MARYSOPHY', 'VILLA NARANJO \r', NULL, NULL, NULL, '66983210', NULL, NULL, ''),
	(71905008, 'JESUS ENRIQUE  ', 'PALACIO SANCHEZ\r', NULL, NULL, NULL, '71905008', NULL, NULL, ''),
	(73109148, 'ROY ', 'MARTELO THORRENS \r', NULL, NULL, NULL, '73109148', NULL, NULL, ''),
	(75082123, ' GERMAN EDUARDO ', 'RAMIREZ RAMIREZ\r', NULL, NULL, NULL, '75082123', NULL, NULL, ''),
	(76306931, 'MARTIN ARIEL ', 'CASTAÑO GONZALEZ \r', NULL, NULL, NULL, '76306931', NULL, NULL, ''),
	(76324492, 'ARIS JOAO', 'CADAVID GUTIERREZ\r', NULL, NULL, NULL, '76324492', NULL, NULL, ''),
	(86056316, 'JULIAN ADOLFO ', 'MANZANO GUTIERREZ\r', NULL, NULL, NULL, '86056316', NULL, NULL, ''),
	(91438736, ' JAVIER JESUS ', 'MALDONADO AYALA\r', NULL, NULL, NULL, '91438736', NULL, NULL, ''),
	(94151777, ' EFRAIN ', 'ARBOLEDA SAAVEDRA\r', NULL, NULL, NULL, '94151777', NULL, NULL, ''),
	(94153675, ' GUSTAVO ADOLFO ', 'LOZANO PEDRAZA\r', NULL, NULL, NULL, '94153675', NULL, NULL, ''),
	(94153772, 'DIEGO ALEXANDER ', 'CAMPINO TORO ', 'ASDSAD', 'ASDASD', '3333', '94153772', '2015-12-24', 'DASDASD', 'ARROYAVE.JPG'),
	(94153900, 'GABRIEL ALBERTO  ', 'PRADO BUITRAGO\r', NULL, NULL, NULL, '94153900', NULL, NULL, ''),
	(94154232, 'JORGE HERNAN', 'CIFUENTES MALDONADO\r', NULL, NULL, NULL, '94154232', NULL, NULL, ''),
	(94225794, 'DIEGO LUIS  ', 'PAREJA MARIN\r', NULL, NULL, NULL, '94225794', NULL, NULL, ''),
	(94229067, 'DIEGO ALBERTO ', 'PINILLA HERNANDEZ \r', NULL, NULL, NULL, '94229067', NULL, NULL, ''),
	(94276055, 'DIEGO FERNANDO', 'RENDON GUTIERREZ\r', NULL, NULL, NULL, '94276055', NULL, NULL, ''),
	(94300648, ' LEANDRO ', 'BEJARANO\r', NULL, NULL, NULL, '94300648', NULL, NULL, ''),
	(94311609, 'JAMES FARYD ', 'ZULETA JURADO\r', NULL, NULL, NULL, '94311609', NULL, NULL, ''),
	(94364756, ' JUAN STEBAN ', 'SERNA JARAMILLO\r', NULL, NULL, NULL, '94364756', NULL, NULL, ''),
	(94387680, ' TULIO ENRIQUE ', 'BENITEZ ORTIZ\r', NULL, NULL, NULL, '94387680', NULL, NULL, ''),
	(94391225, 'ALFREDO', 'VARGAS\r', NULL, NULL, NULL, '94391225', NULL, NULL, ''),
	(94392383, '  ANDRES FERNANDO  ', 'GOMEZ FAJARDO\r', NULL, NULL, NULL, '94392383', NULL, NULL, ''),
	(94392876, 'KENIDER FRANSUA ', 'ESPINAL CASTELLANOS\r', NULL, NULL, NULL, '94392876', NULL, NULL, ''),
	(94393714, ' SERGIO DE JESUS ', 'GOMEZ GIRALDO\r', NULL, NULL, NULL, '94393714', NULL, NULL, ''),
	(94394223, 'CARLOS ANDRES', 'MATALLANA BENITEZ \r', NULL, NULL, NULL, '94394223', NULL, NULL, ''),
	(94394545, 'MAURICIO', 'GOMEZ FAJARDO\r', NULL, NULL, NULL, '94394545', NULL, NULL, ''),
	(94395028, 'EDWIN', 'QUINTERO MONSALVE \r', NULL, NULL, NULL, '94395028', NULL, NULL, ''),
	(94395777, 'MILTON GEOVANNY ', 'ARBOLEDA SAAVEDRA \r', NULL, NULL, NULL, '94395777', NULL, NULL, ''),
	(94395869, ' JOHN ALEXANDER ', 'ARROYAVE MEJIA\r', NULL, NULL, NULL, '94395869', NULL, NULL, ''),
	(94472795, 'ANDRES ', 'PRIETO PEREZ', '', NULL, NULL, '94472795', '0000-00-00', '', ''),
	(1032376771, ' YADIRA MILENA ', 'CAMPO GALINDO\r', NULL, NULL, NULL, '1032376771', NULL, NULL, ''),
	(1088294650, 'CHRISTIAN ', 'GONZALEZ FRANCO \r', NULL, NULL, NULL, '1088294650', NULL, NULL, ''),
	(1088588392, 'WILLIAM ARMANDO ', 'TAPIE CANACUAN\r', NULL, NULL, NULL, '1088588392', NULL, NULL, ''),
	(1110457030, 'ALIXON YULIETH', 'REINA NIETO \r', NULL, NULL, NULL, '1110457030', NULL, NULL, ''),
	(1112100266, ' HERNAN FELIPE ', 'MARMOLEJO LIZALDA\r', NULL, NULL, NULL, '1112100266', NULL, NULL, ''),
	(1112102456, 'LEIDY JOHANA ', 'CASTAÑEDA DUQUE\r', NULL, NULL, NULL, '1112102456', NULL, NULL, ''),
	(1113038646, 'LUIS GERMAN ', 'TORO PAREJA\r', NULL, NULL, NULL, '1113038646', NULL, NULL, ''),
	(1114118406, 'VICTOR HUGO', 'MARMOLEJO VALENCIA \r', NULL, NULL, NULL, '1114118406', NULL, NULL, ''),
	(1115063775, 'JUAN DAVID ', 'CASTAÃ?O ', 'DSDSD', 'SADSAD', '2332', '1115063775', '2015-12-30', 'ASDASDSAD', 'FOTO 2015 PNG.png'),
	(1115065269, ' LEIDY JOHANA ', 'RUIZ CORTES\r', NULL, NULL, NULL, '1115065269', NULL, NULL, ''),
	(1116235526, 'CLAUDIA  ', 'FERNANDA MAZUERA\r', NULL, NULL, NULL, '1116235526', NULL, NULL, ''),
	(1116235537, ' DIEGO FERNANDO ', 'MURILLO LOPEZ\r', NULL, NULL, NULL, '1116235537', NULL, NULL, ''),
	(1116235700, 'KAREN ', 'RIASCOS QUIÑONES\r', NULL, NULL, NULL, '1116235700', NULL, NULL, ''),
	(1116235891, ' DIANA LORENA ', 'VELANDIA VANEGAS', 'CARRERA 41 35-51 APTO 107', 'DVELANDIA@SENA.EDU.CO', '3164903099', 'diana', '1987-01-22', 'TULUA', '1116235891.jpg'),
	(1116238204, 'JOHANNA ANDREA', 'NARVAEZ GIRALDO \r', NULL, NULL, NULL, '1116238204', NULL, NULL, ''),
	(1116238393, 'FABIO ANDRES ', 'SANCHEZ MEJIA\r', NULL, NULL, NULL, '1116238393', NULL, NULL, ''),
	(1116238490, 'JOHN JAIRO', 'MARIN ARBOLEDA \r', NULL, NULL, NULL, '1116238490', NULL, NULL, ''),
	(1116240360, 'MARIA ISABEL ', 'VELEZ VICTORIA\r', NULL, NULL, NULL, '1116240360', NULL, NULL, ''),
	(1116240430, 'EDWARD ALEXANDER ', 'GONZALEZ AGUDELO\r', NULL, NULL, NULL, '1116240430', NULL, NULL, ''),
	(1116242450, ' JUAN DIEGO ', 'SALAMANDO AGUIRRE\r', NULL, NULL, NULL, '1116242450', NULL, NULL, ''),
	(1116243314, 'JUAN DAVID ', 'LOZANO GALVEZ\r', NULL, NULL, NULL, '1116243314', NULL, NULL, ''),
	(1116244664, 'ANGELICA ', 'HERNANDEZ ROMERO\r', NULL, NULL, NULL, '1116244664', NULL, NULL, ''),
	(1116253923, 'GOMEZ ', 'GOMEZ MAURICIO\r', NULL, NULL, NULL, '1116253923', NULL, NULL, ''),
	(1116256886, 'CHRISTIAN ANDRES ', 'CUERO GAMBOA\r', NULL, NULL, NULL, '1116256886', NULL, NULL, ''),
	(1116722533, ' ELIZABETH ', 'LOPEZ MONSALVE\r', NULL, NULL, NULL, '1116722533', NULL, NULL, ''),
	(1130613755, 'LADY ALEJANDRA', 'GALINDO CASTILLO \r', NULL, NULL, NULL, '1130613755', NULL, NULL, '');
/*!40000 ALTER TABLE `personal` ENABLE KEYS */;


-- Volcando estructura para tabla gepad.programa
CREATE TABLE IF NOT EXISTS `programa` (
  `codigoprograma` int(10) NOT NULL,
  `nombreprograma` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`codigoprograma`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla gepad.programa: ~3 rows (aproximadamente)
/*!40000 ALTER TABLE `programa` DISABLE KEYS */;
INSERT INTO `programa` (`codigoprograma`, `nombreprograma`) VALUES
	(756676, 'ADSI'),
	(5555444, 'GERI'),
	(8456673, 'ADSI');
/*!40000 ALTER TABLE `programa` ENABLE KEYS */;


-- Volcando estructura para tabla gepad.regional
CREATE TABLE IF NOT EXISTS `regional` (
  `codigoregional` int(11) NOT NULL AUTO_INCREMENT,
  `nombreregional` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`codigoregional`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla gepad.regional: ~32 rows (aproximadamente)
/*!40000 ALTER TABLE `regional` DISABLE KEYS */;
INSERT INTO `regional` (`codigoregional`, `nombreregional`) VALUES
	(1, 'Amazonas'),
	(2, 'Antioquia'),
	(3, 'Arauca'),
	(4, 'Atlántico'),
	(5, 'Bolívar'),
	(6, 'Boyacá'),
	(7, 'Caldas'),
	(8, 'Caquetá'),
	(9, 'Casanare'),
	(10, 'Cauca'),
	(11, 'Cesar'),
	(12, 'Chocó'),
	(13, 'Córdoba'),
	(14, 'Cundinamarca'),
	(15, 'Güainia'),
	(16, 'Guaviare'),
	(17, 'Huila'),
	(18, 'La Guajira'),
	(19, 'Magdalena'),
	(20, 'Meta'),
	(21, 'Nariño'),
	(22, 'Norte de Santander'),
	(23, 'Putumayo'),
	(24, 'Quindío'),
	(25, 'Risaralda'),
	(26, 'San Andrés y Providencia'),
	(27, 'Santander'),
	(28, 'Sucre'),
	(29, 'Tolima'),
	(30, 'Valle del Cauca'),
	(31, 'Vaupés'),
	(32, 'Vichada');
/*!40000 ALTER TABLE `regional` ENABLE KEYS */;


-- Volcando estructura para tabla gepad.reservaambiente
CREATE TABLE IF NOT EXISTS `reservaambiente` (
  `codigoreservambiente` int(11) NOT NULL AUTO_INCREMENT,
  `codigoambiente` int(11) DEFAULT NULL,
  `documentopersonal` bigint(20) DEFAULT NULL,
  `fichatitulacion` int(11) DEFAULT NULL,
  `fechainicioreserva` date DEFAULT NULL,
  `fechafinreserva` date DEFAULT NULL,
  `horainicioreserva` varchar(50) DEFAULT NULL,
  `horafinreserva` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`codigoreservambiente`),
  KEY `FK_reservaambiente_ambientedeaprendizaje` (`codigoambiente`),
  KEY `FK_reservaambiente_personal` (`documentopersonal`),
  KEY `FK_reservaambiente_fichatitulacion` (`fichatitulacion`),
  CONSTRAINT `FK_reservaambiente_ambientedeaprendizaje` FOREIGN KEY (`codigoambiente`) REFERENCES `ambientedeaprendizaje` (`codigoambiente`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_reservaambiente_fichatitulacion` FOREIGN KEY (`fichatitulacion`) REFERENCES `fichatitulacion` (`fichatitulacion`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_reservaambiente_personal` FOREIGN KEY (`documentopersonal`) REFERENCES `personal` (`documentopersonal`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla gepad.reservaambiente: ~4 rows (aproximadamente)
/*!40000 ALTER TABLE `reservaambiente` DISABLE KEYS */;
INSERT INTO `reservaambiente` (`codigoreservambiente`, `codigoambiente`, `documentopersonal`, `fichatitulacion`, `fechainicioreserva`, `fechafinreserva`, `horainicioreserva`, `horafinreserva`) VALUES
	(1, 2, 2631490, 1, '2016-02-10', '2016-02-10', '04:00:00', '10:00:00'),
	(5, 2, 2631490, 1, NULL, NULL, '08:00:00', '09:00:00');
/*!40000 ALTER TABLE `reservaambiente` ENABLE KEYS */;


-- Volcando estructura para tabla gepad.sede
CREATE TABLE IF NOT EXISTS `sede` (
  `numerosede` int(11) NOT NULL,
  `nombresede` varchar(50) DEFAULT NULL,
  `direccionsede` varchar(50) DEFAULT NULL,
  `documentofuncionario` bigint(20) DEFAULT NULL,
  `estadosede` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`numerosede`),
  KEY `FK_sede_funcionario` (`documentofuncionario`),
  CONSTRAINT `FK_sede_funcionario` FOREIGN KEY (`documentofuncionario`) REFERENCES `funcionario` (`documentofuncionario`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla gepad.sede: ~3 rows (aproximadamente)
/*!40000 ALTER TABLE `sede` DISABLE KEYS */;
INSERT INTO `sede` (`numerosede`, `nombresede`, `direccionsede`, `documentofuncionario`, `estadosede`) VALUES
	(0, 'CLEM', 'Km2 Tulua-Buga', 16345190, 'Disponible'),
	(1, 'Mercantil', 'Calle 30 No 40-23', 37729607, 'Disponible'),
	(2, 'Salesiano', 'Calle 26 No 22-22', 16345190, 'Disponible');
/*!40000 ALTER TABLE `sede` ENABLE KEYS */;


-- Volcando estructura para tabla gepad.seguimiento
CREATE TABLE IF NOT EXISTS `seguimiento` (
  `codigoseguimiento` int(11) NOT NULL AUTO_INCREMENT,
  `numeroactaseguimiento` int(11) DEFAULT '0',
  `fechaseguimiento` date DEFAULT NULL,
  `faseseguimiento` varchar(200) DEFAULT NULL,
  `competenciasseguimiento` varchar(200) DEFAULT NULL,
  `obsseguimiento` text,
  `conclusionesseguimiento` text,
  `compromisosseguimiento` text,
  `ciudadseguimiento` text,
  `lugarseguimiento` varchar(100) DEFAULT NULL,
  `horaseguimiento` varchar(100) DEFAULT NULL,
  `horafinseguimiento` varchar(100) DEFAULT NULL,
  `estadoseguimiento` varchar(100) DEFAULT NULL,
  `fichatitulacion` int(10) DEFAULT NULL,
  PRIMARY KEY (`codigoseguimiento`),
  KEY `FK_seguimiento_fichatitulacion` (`fichatitulacion`),
  CONSTRAINT `FK_seguimiento_fichatitulacion` FOREIGN KEY (`fichatitulacion`) REFERENCES `fichatitulacion` (`fichatitulacion`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla gepad.seguimiento: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `seguimiento` DISABLE KEYS */;
/*!40000 ALTER TABLE `seguimiento` ENABLE KEYS */;


-- Volcando estructura para tabla gepad.seguimientoaprendiz
CREATE TABLE IF NOT EXISTS `seguimientoaprendiz` (
  `documentoaprendiz` bigint(20) NOT NULL,
  `numeroseguimiento` int(11) NOT NULL,
  `rendimientoseguimiento` text,
  `estrategiaseguimiento` text,
  `numeronovedad` int(11) DEFAULT NULL,
  PRIMARY KEY (`documentoaprendiz`,`numeroseguimiento`),
  KEY `FK_seguimientoaprendiz_seguimiento` (`numeroseguimiento`),
  KEY `FK_seguimientoaprendiz_novedad` (`numeronovedad`),
  CONSTRAINT `FK_seguimientoaprendiz_aprendiz` FOREIGN KEY (`documentoaprendiz`) REFERENCES `aprendiz` (`documentoaprendiz`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_seguimientoaprendiz_novedad` FOREIGN KEY (`numeronovedad`) REFERENCES `novedad` (`numeronovedad`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_seguimientoaprendiz_seguimiento` FOREIGN KEY (`numeroseguimiento`) REFERENCES `seguimiento` (`codigoseguimiento`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla gepad.seguimientoaprendiz: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `seguimientoaprendiz` DISABLE KEYS */;
/*!40000 ALTER TABLE `seguimientoaprendiz` ENABLE KEYS */;


-- Volcando estructura para tabla gepad.seguimientop
CREATE TABLE IF NOT EXISTS `seguimientop` (
  `numeroseguimientop` int(11) NOT NULL AUTO_INCREMENT,
  `fechaseguimientoa` date DEFAULT NULL,
  `fechaseguimientoi` date DEFAULT NULL,
  `actividadesseguimiento` text,
  `balanceseguimiento` text,
  `observacionesseguimientoa` text,
  `observacionesseguimientoi` text,
  `codigoeproductiva` int(11) DEFAULT NULL,
  `documentoinstructor` bigint(20) DEFAULT NULL,
  `fechainicioseguimiento` date DEFAULT NULL,
  `fechafinseguimiento` date DEFAULT NULL,
  PRIMARY KEY (`numeroseguimientop`),
  KEY `FK_seguimientop_eproductiva` (`codigoeproductiva`),
  KEY `FK_seguimientop_instructor` (`documentoinstructor`),
  CONSTRAINT `FK_seguimientop_eproductiva` FOREIGN KEY (`codigoeproductiva`) REFERENCES `eproductiva` (`codigoeproductiva`),
  CONSTRAINT `FK_seguimientop_instructor` FOREIGN KEY (`documentoinstructor`) REFERENCES `instructor` (`documentoinstructor`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla gepad.seguimientop: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `seguimientop` DISABLE KEYS */;
/*!40000 ALTER TABLE `seguimientop` ENABLE KEYS */;


-- Volcando estructura para tabla gepad.tipoambiente
CREATE TABLE IF NOT EXISTS `tipoambiente` (
  `codigotipoambiente` int(11) NOT NULL AUTO_INCREMENT,
  `descripciontipoambiente` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`codigotipoambiente`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla gepad.tipoambiente: ~4 rows (aproximadamente)
/*!40000 ALTER TABLE `tipoambiente` DISABLE KEYS */;
INSERT INTO `tipoambiente` (`codigotipoambiente`, `descripciontipoambiente`) VALUES
	(1, 'Aula'),
	(2, 'Laboratorio'),
	(3, 'Taller Electronica'),
	(4, 'Aula virtual'),
	(5, 'Biblioteca');
/*!40000 ALTER TABLE `tipoambiente` ENABLE KEYS */;


-- Volcando estructura para tabla gepad.tipomonitoria
CREATE TABLE IF NOT EXISTS `tipomonitoria` (
  `codigotipomonitoria` int(11) NOT NULL AUTO_INCREMENT,
  `nombretipomonitoria` varchar(50) NOT NULL DEFAULT '0',
  `descripciontipomonitoria` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`codigotipomonitoria`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla gepad.tipomonitoria: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `tipomonitoria` DISABLE KEYS */;
/*!40000 ALTER TABLE `tipomonitoria` ENABLE KEYS */;


-- Volcando estructura para tabla gepad.tipopractica
CREATE TABLE IF NOT EXISTS `tipopractica` (
  `codigotipopractica` int(11) NOT NULL AUTO_INCREMENT,
  `nombretipopractica` varchar(50) DEFAULT NULL,
  `descripciontipopractica` text,
  PRIMARY KEY (`codigotipopractica`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla gepad.tipopractica: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `tipopractica` DISABLE KEYS */;
/*!40000 ALTER TABLE `tipopractica` ENABLE KEYS */;


-- Volcando estructura para tabla gepad.turno
CREATE TABLE IF NOT EXISTS `turno` (
  `codigoturno` int(10) NOT NULL AUTO_INCREMENT,
  `codigoarea` int(10) NOT NULL DEFAULT '0',
  `documentocliente` bigint(20) NOT NULL DEFAULT '0',
  `numeroturno` int(11) NOT NULL DEFAULT '0',
  `fechaturno` date NOT NULL,
  `horaingresoturno` varchar(50) NOT NULL,
  `horasalidaturno` varchar(50) DEFAULT NULL,
  `motivoturno` text NOT NULL,
  `estadoturno` varchar(50) NOT NULL,
  `observacionesturno` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`codigoturno`),
  KEY `FK_turno_area` (`codigoarea`),
  KEY `FK_turno_clienteexterno` (`documentocliente`),
  CONSTRAINT `FK_turno_area` FOREIGN KEY (`codigoarea`) REFERENCES `area` (`codigoarea`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_turno_clienteexterno` FOREIGN KEY (`documentocliente`) REFERENCES `clienteexterno` (`documentocliente`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla gepad.turno: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `turno` DISABLE KEYS */;
/*!40000 ALTER TABLE `turno` ENABLE KEYS */;


-- Volcando estructura para tabla gepad.usodeambientes
CREATE TABLE IF NOT EXISTS `usodeambientes` (
  `codigousoambiente` int(11) NOT NULL AUTO_INCREMENT,
  `documentoguarda` bigint(20) DEFAULT NULL,
  `codigoambiente` int(11) DEFAULT NULL,
  `documentopersonal` bigint(20) DEFAULT NULL,
  `fichatitulacion` int(11) DEFAULT NULL,
  `fechausoambiente` date DEFAULT NULL,
  `horaentradaambiente` varchar(50) DEFAULT NULL,
  `horasalidaambiente` varchar(50) DEFAULT NULL,
  `entregaambiente` char(50) DEFAULT NULL,
  `observacionesusoambiente` text,
  `codigoreservaambiente` int(11) DEFAULT NULL,
  PRIMARY KEY (`codigousoambiente`),
  KEY `FK_usodeambientes_guarda` (`documentoguarda`),
  KEY `FK_usodeambientes_ambientedeaprendizaje` (`codigoambiente`),
  KEY `FK_usodeambientes_personal` (`documentopersonal`),
  KEY `FK_usodeambientes_fichatitulacion` (`fichatitulacion`),
  KEY `FK_usodeambientes_reservaambiente` (`codigoreservaambiente`),
  CONSTRAINT `FK_usodeambientes_ambientedeaprendizaje` FOREIGN KEY (`codigoambiente`) REFERENCES `ambientedeaprendizaje` (`codigoambiente`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_usodeambientes_fichatitulacion` FOREIGN KEY (`fichatitulacion`) REFERENCES `fichatitulacion` (`fichatitulacion`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_usodeambientes_guarda` FOREIGN KEY (`documentoguarda`) REFERENCES `guarda` (`documentoguarda`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_usodeambientes_personal` FOREIGN KEY (`documentopersonal`) REFERENCES `personal` (`documentopersonal`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_usodeambientes_reservaambiente` FOREIGN KEY (`codigoreservaambiente`) REFERENCES `reservaambiente` (`codigoreservambiente`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla gepad.usodeambientes: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `usodeambientes` DISABLE KEYS */;
/*!40000 ALTER TABLE `usodeambientes` ENABLE KEYS */;


-- Volcando estructura para tabla gepad.valoracion
CREATE TABLE IF NOT EXISTS `valoracion` (
  `codigoevaluaciondesempeno` int(10) NOT NULL,
  `codigocriterio` int(10) NOT NULL,
  `puntajevaloracion` int(10) DEFAULT NULL,
  PRIMARY KEY (`codigoevaluaciondesempeno`,`codigocriterio`),
  KEY `FK_valoracion_criterio` (`codigocriterio`),
  CONSTRAINT `FK_valoracion_criterio` FOREIGN KEY (`codigocriterio`) REFERENCES `criterio` (`codigocriterio`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_valoracion_evaluaciondesempeno` FOREIGN KEY (`codigoevaluaciondesempeno`) REFERENCES `evaluaciondesempeno` (`codigoevaluaciondesempeno`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla gepad.valoracion: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `valoracion` DISABLE KEYS */;
/*!40000 ALTER TABLE `valoracion` ENABLE KEYS */;


-- Volcando estructura para tabla gepad.vehiculo
CREATE TABLE IF NOT EXISTS `vehiculo` (
  `placavehiculo` varchar(50) NOT NULL,
  `tipovehiculo` varchar(50) DEFAULT NULL,
  `kmvehiculo` int(11) DEFAULT NULL,
  PRIMARY KEY (`placavehiculo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla gepad.vehiculo: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `vehiculo` DISABLE KEYS */;
/*!40000 ALTER TABLE `vehiculo` ENABLE KEYS */;


-- Volcando estructura para tabla gepad.viaticos
CREATE TABLE IF NOT EXISTS `viaticos` (
  `codigoviatico` int(11) NOT NULL AUTO_INCREMENT,
  `lugardesplazamientoviatico` varchar(50) DEFAULT NULL,
  `fechainicioviatico` date DEFAULT NULL,
  `fechafinviatico` date DEFAULT NULL,
  `propositoviatico` text,
  `actividadesviatico` text,
  `codigopago` int(11) DEFAULT NULL,
  PRIMARY KEY (`codigoviatico`),
  KEY `FK_viaticos_pago` (`codigopago`),
  CONSTRAINT `FK_viaticos_pago` FOREIGN KEY (`codigopago`) REFERENCES `pago` (`codigopago`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla gepad.viaticos: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `viaticos` DISABLE KEYS */;
/*!40000 ALTER TABLE `viaticos` ENABLE KEYS */;


-- Volcando estructura para tabla gepad.visita
CREATE TABLE IF NOT EXISTS `visita` (
  `numerovisita` int(11) NOT NULL AUTO_INCREMENT,
  `codigoeproductiva` int(11) DEFAULT NULL,
  `documentoinstructor` bigint(20) DEFAULT NULL,
  `fechavisita` date DEFAULT NULL,
  `observacionesvisita` text,
  `estadovisita` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`numerovisita`),
  KEY `FK_visita_eproductiva` (`codigoeproductiva`),
  KEY `FK_visita_instructor` (`documentoinstructor`),
  CONSTRAINT `FK_visita_eproductiva` FOREIGN KEY (`codigoeproductiva`) REFERENCES `eproductiva` (`codigoeproductiva`),
  CONSTRAINT `FK_visita_instructor` FOREIGN KEY (`documentoinstructor`) REFERENCES `instructor` (`documentoinstructor`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla gepad.visita: ~0 rows (aproximadamente)
/*!40000 ALTER TABLE `visita` DISABLE KEYS */;
/*!40000 ALTER TABLE `visita` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
