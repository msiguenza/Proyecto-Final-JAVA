/*
Navicat MySQL Data Transfer

Source Server         : root1
Source Server Version : 50141
Source Host           : localhost:3306
Source Database       : hotel

Target Server Type    : MYSQL
Target Server Version : 50141
File Encoding         : 65001

Date: 2014-02-19 16:21:50
*/

select * from capacidadhabitacion;

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `capacidadhabitacion`
-- ----------------------------
DROP TABLE IF EXISTS `capacidadhabitacion`;
CREATE TABLE `capacidadhabitacion` (
  `capacidadhab` int(1) NOT NULL,
  PRIMARY KEY (`capacidadhab`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of capacidadhabitacion
-- ----------------------------
INSERT INTO `capacidadhabitacion` VALUES ('1');
INSERT INTO `capacidadhabitacion` VALUES ('2');
INSERT INTO `capacidadhabitacion` VALUES ('3');

-- ----------------------------
-- Table structure for `check_in`
-- ----------------------------
DROP TABLE IF EXISTS `check_in`;
CREATE TABLE `check_in` (
  `idreserva` int(5) NOT NULL,
  `numhab` int(3) DEFAULT NULL,
  `fechaentrada` date DEFAULT NULL,
  `condicionalojamiento` varchar(20) DEFAULT NULL,
  `dnicliente` varchar(9) NOT NULL,
  `numpersonas` int(2) DEFAULT NULL,
  `preciototal` int(5) DEFAULT NULL,
  PRIMARY KEY (`idreserva`),
  KEY `FK_reserva` (`idreserva`),
  KEY `FK_cliente` (`dnicliente`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of check_in
-- ----------------------------
INSERT INTO `check_in` VALUES ('1', '102', '2014-02-17', '', '30241073y', '2', '100');

-- ----------------------------
-- Table structure for `check_out`
-- ----------------------------
DROP TABLE IF EXISTS `check_out`;
CREATE TABLE `check_out` (
  `idreserva` int(5) NOT NULL,
  `numhab` int(3) DEFAULT NULL,
  `fechasalida` date DEFAULT NULL,
  `preciototal` int(5) DEFAULT NULL,
  `dnicliente` varchar(9) NOT NULL,
  PRIMARY KEY (`idreserva`),
  KEY `FK_reserva` (`idreserva`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of check_out
-- ----------------------------

-- ----------------------------
-- Table structure for `cliente`
-- ----------------------------
DROP TABLE IF EXISTS `cliente`;
CREATE TABLE `cliente` (
  `idcliente` int(3) NOT NULL AUTO_INCREMENT,
  `dnicliente` varchar(9) NOT NULL,
  `nombrecliente` varchar(20) DEFAULT NULL,
  `apellidoscliente` varchar(30) DEFAULT NULL,
  `direccioncliente` varchar(20) DEFAULT NULL,
  `telefonocliente` int(9) DEFAULT NULL,
  `emailcliente` varchar(50) DEFAULT NULL,
  `fechanacimiento` varchar(10) DEFAULT NULL,
  `codpostalcliente` int(5) DEFAULT NULL,
  `localidadcliente` varchar(20) DEFAULT NULL,
  `provinciacliente` varchar(20) DEFAULT NULL,
  `paiscliente` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`idcliente`),
  UNIQUE KEY `dnicliente` (`dnicliente`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of cliente
-- ----------------------------
INSERT INTO `cliente` VALUES ('1', '30241073Y', 'silvia', 'perez7', 'C/ Ojiva', '666666666', 'silv@hotmail.com', '02/09/1986', '41008', 'españa', 'sevilla', 'sevilla');
INSERT INTO `cliente` VALUES ('4', '28668563Y', 'lljlk', 'jkljlkjlk', 'jkljlklk', '666666666', 'si@gmail.com', '02/09/1986', '41008', 'sevilla', 'sevilla', 'españa');
INSERT INTO `cliente` VALUES ('5', '30267767c', 'dfssdf', 'sdfsdf', 'sdfsdf', '954957329', 'silvi@hm.com', '02/09/1986', '41008', 'sevilla', 'sevilla', 'España');

-- ----------------------------
-- Table structure for `empleado`
-- ----------------------------
DROP TABLE IF EXISTS `empleado`;
CREATE TABLE `empleado` (
  `idempleado` int(3) NOT NULL AUTO_INCREMENT,
  `dniempleado` varchar(9) NOT NULL,
  `nombreempleado` varchar(20) DEFAULT NULL,
  `apellidosempleado` varchar(35) DEFAULT NULL,
  `direccionempleado` varchar(20) DEFAULT NULL,
  `telefonoempleado` int(9) DEFAULT NULL,
  `rolempleado` varchar(20) DEFAULT NULL,
  `usuario` varchar(20) DEFAULT NULL,
  `clave` varchar(20) DEFAULT NULL,
  `cp` int(5) DEFAULT NULL,
  `localidad` varchar(20) DEFAULT NULL,
  `provincia` varchar(20) DEFAULT NULL,
  `pais` varchar(20) DEFAULT NULL,
  `email` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`idempleado`),
  UNIQUE KEY `dniempleado` (`dniempleado`),
  UNIQUE KEY `usuario` (`usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of empleado
-- ----------------------------
INSERT INTO `empleado` VALUES ('1', '30241073Y', 'Silvia', 'Pérez Gómez', 'C/ Ojiva', '954957329', 'Administrador', 'admin', '1', '41008', 'Sevilla', 'Sevilla', 'España', 'silviapg1986@hotmail.com');
INSERT INTO `empleado` VALUES ('5', '30241169X', 'silvia', 'salad gutierrez', 'hola', '651159255', 'Limpiadora', 'silvia', '1', '41008', 'Sevilla', 'Sevilla', 'España', 'silviapg@hotmail.com');
INSERT INTO `empleado` VALUES ('6', '28756682n', 'enrique', 'salas gutierrez', 'lkjjlkljk', '654465222', 'Recepcionista', 'enrique', '1', '41005', 'Cadiz', 'Cadiz', 'España', 'esalas@hotmail.com');
select * from empleado;

delete from empleado where dniempleado='30241169x';
-- ----------------------------
-- Table structure for `habitacion`
-- ----------------------------
DROP TABLE IF EXISTS `habitacion`;
CREATE TABLE `habitacion` (
  `numhab` int(3) NOT NULL AUTO_INCREMENT,
  `numplanta` int(2) DEFAULT NULL,
  `vistas` varchar(20) DEFAULT NULL,
  `tipo` varchar(20) DEFAULT NULL,
  `estado` varchar(20) DEFAULT NULL,
  `dnilimpiadora` varchar(9) DEFAULT NULL,
  `capacidad` int(2) DEFAULT NULL,
  `descripcion` varchar(300) DEFAULT NULL,
  `precio` int(5) DEFAULT NULL,
  PRIMARY KEY (`numhab`),
  KEY `FK_habitacion` (`numplanta`),
  KEY `FK_vistas` (`vistas`),
  KEY `FK_tipo` (`tipo`),
  KEY `FK_capacidad` (`capacidad`),
  KEY `FK_hab_emp` (`dnilimpiadora`)
) ENGINE=MyISAM AUTO_INCREMENT=103 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of habitacion
-- ----------------------------
INSERT INTO `habitacion` VALUES ('101', '1', 'A la piscina', 'Simple', 'Disponible', null, '1', 'Habitación barata', '40');
INSERT INTO `habitacion` VALUES ('102', '2', 'Al campo', 'Doble', 'Disponible', null, '2', '', '50');

-- ----------------------------
-- Table structure for `hotel`
-- ----------------------------
DROP TABLE IF EXISTS `hotel`;
CREATE TABLE `hotel` (
  `nombrehotel` varchar(20) NOT NULL DEFAULT '',
  `cifhotel` varchar(9) DEFAULT NULL,
  `direccionhotel` varchar(50) DEFAULT NULL,
  `cphotel` int(5) DEFAULT NULL,
  `telefonohotel` int(9) DEFAULT NULL,
  `localidadhotel` varchar(30) DEFAULT NULL,
  `paishotel` varchar(30) DEFAULT NULL,
  `provinciahotel` varchar(30) DEFAULT NULL,
  `emailhotel` varchar(50) DEFAULT NULL,
  `plantashotel` int(2) DEFAULT NULL,
  `roleshotel` varchar(20) DEFAULT NULL,
  `vistashabitacion` varchar(30) DEFAULT NULL,
  `capacidadhabitacion` int(2) DEFAULT NULL,
  `tiposhabitacion` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`nombrehotel`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of hotel
-- ----------------------------
INSERT INTO `hotel` VALUES ('Meliá Lebreros', 'A458910', 'Avda.de la Constitución', '0', '954616758', 'Sevilla', 'España', 'Sevilla', 'melia@melialebreros.com', '4', 'null', 'null', '0', 'null');

-- ----------------------------
-- Table structure for `pago`
-- ----------------------------
DROP TABLE IF EXISTS `pago`;
CREATE TABLE `pago` (
  `idpago` int(10) AUTO_INCREMENT,
  `dnicliente` varchar(9) NOT NULL,
  `idreserva` int(5) NOT NULL,
  `precio_total` int(4) DEFAULT NULL,
  `fecha_pago` date DEFAULT NULL,
  `metodo_pago` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`idpago`),
  KEY `FK_reserva` (`idreserva`),
  KEY `FK_cliente` (`dnicliente`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of pago
-- ----------------------------
INSERT INTO `pago` VALUES ('30241073y', '1', '100', '2014-02-17', 'Tarjeta1203-2365-2569-2365');

-- ----------------------------
-- Table structure for `pension`
-- ----------------------------
DROP TABLE IF EXISTS `pension`;
CREATE TABLE `pension` (
  `pension` varchar(20) NOT NULL,
  `precio` int(5) NOT NULL,
  PRIMARY KEY (`pension`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of pension
-- ----------------------------
INSERT INTO `pension` VALUES ('Pensión completa', '40');
INSERT INTO `pension` VALUES ('Media pension', '20');

-- ----------------------------
-- Table structure for `reserva`
-- ----------------------------
DROP TABLE IF EXISTS `reserva`;
CREATE TABLE `reserva` (
  `idreserva` int(5) NOT NULL AUTO_INCREMENT,
  `numhab` int(3) DEFAULT NULL,
  `fechaentrada` varchar(10) DEFAULT NULL,
  `fechasalida` varchar(10) DEFAULT NULL,
  `dnicliente` varchar(9) NOT NULL,
  `numpersonas` int(2) DEFAULT NULL,
  `observaciones` varchar(50) DEFAULT NULL,
  `precioHabitacion` int(5),
  PRIMARY KEY (`idreserva`),
  KEY `FK_alquiler_hab` (`numhab`),
  KEY `FK_alquiler_clien` (`dnicliente`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of reserva
-- ----------------------------
delete from check_in;
delete from pago where fecha_pago= '2014-02-20';
INSERT INTO `reserva` VALUES (null, '101', '2014-02-20', '2014-02-20', '30241073y', '2', '', '80');
select * from pago;
select * from pago where fecha_pago='2014-02-20';
select * from reserva where dnicliente='30241073y' and fechaentrada='2014-02-24';
-- ----------------------------
-- Table structure for `rolempleado`
-- ----------------------------
DROP TABLE IF EXISTS `rolempleado`;
CREATE TABLE `rolempleado` (
  `rol` varchar(20) NOT NULL,
  PRIMARY KEY (`rol`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of rolempleado
-- ----------------------------
INSERT INTO `rolempleado` VALUES ('Administrador');
INSERT INTO `rolempleado` VALUES ('Limpiadora');
INSERT INTO `rolempleado` VALUES ('Mantenimiento');
INSERT INTO `rolempleado` VALUES ('Recepcionista');

-- ----------------------------
-- Table structure for `tipohabitacion`
-- ----------------------------
DROP TABLE IF EXISTS `tipohabitacion`;
CREATE TABLE `tipohabitacion` (
  `tipo` varchar(20) NOT NULL,
  PRIMARY KEY (`tipo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of tipohabitacion
-- ----------------------------
INSERT INTO `tipohabitacion` VALUES ('Doble');
INSERT INTO `tipohabitacion` VALUES ('Simple');
INSERT INTO `tipohabitacion` VALUES ('Triple');

-- ----------------------------
-- Table structure for `vistashabitacion`
-- ----------------------------
DROP TABLE IF EXISTS `vistashabitacion`;
CREATE TABLE `vistashabitacion` (
  `vistas` varchar(20) NOT NULL,
  PRIMARY KEY (`vistas`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of vistashabitacion
-- ----------------------------
INSERT INTO `vistashabitacion` VALUES ('A la piscina');
INSERT INTO `vistashabitacion` VALUES ('Al campo');
INSERT INTO `vistashabitacion` VALUES ('Al mar');
