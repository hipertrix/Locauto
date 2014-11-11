-- phpMyAdmin SQL Dump
-- version 4.2.6deb1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Nov 11, 2014 at 08:01 PM
-- Server version: 5.5.40-0ubuntu1
-- PHP Version: 5.5.12-2ubuntu4.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `locauto`
--

-- --------------------------------------------------------

--
-- Table structure for table `usuario`
--

CREATE TABLE IF NOT EXISTS `usuario` (
  `cpf` varchar(11) NOT NULL,
  `nome` varchar(55) NOT NULL,
  `senha` varchar(55) NOT NULL,
  `email` varchar(100) DEFAULT NULL,
  `cnh` varchar(25) DEFAULT NULL,
  `endereco` int(255) DEFAULT NULL,
  `cidade` int(11) DEFAULT NULL,
  `telefone` int(15) DEFAULT NULL,
  `nascimento` date DEFAULT NULL,
  `tipo_susuario` int(11) DEFAULT '0',
  `status` int(11) DEFAULT '0',
  `usuario_cadastrador` varchar(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
