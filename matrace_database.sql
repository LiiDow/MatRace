-- phpMyAdmin SQL Dump
-- version 4.0.4
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Jul 07, 2015 at 12:59 PM
-- Server version: 5.6.12-log
-- PHP Version: 5.4.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `matrace_db`
--
CREATE DATABASE IF NOT EXISTS `matrace_db` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `matrace_db`;

-- --------------------------------------------------------

--
-- Table structure for table `game`
--

CREATE TABLE IF NOT EXISTS `game` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `idp1` int(11) NOT NULL,
  `idp2` int(11) NOT NULL,
  `accepted` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=4 ;

--
-- Dumping data for table `game`
--

INSERT INTO `game` (`id`, `idp1`, `idp2`, `accepted`) VALUES
(1, 2, 1, 1),
(2, 1, 2, 1),
(3, 4, 3, 1);

-- --------------------------------------------------------

--
-- Table structure for table `player`
--

CREATE TABLE IF NOT EXISTS `player` (
  `id_player` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(15) NOT NULL,
  `score` int(11) NOT NULL DEFAULT '0',
  `x` int(11) NOT NULL,
  `y` int(11) NOT NULL,
  `avatar` varchar(50) NOT NULL,
  `id_game` int(11) DEFAULT NULL,
  `online` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id_player`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

--
-- Dumping data for table `player`
--

INSERT INTO `player` (`id_player`, `name`, `score`, `x`, `y`, `avatar`, `id_game`, `online`) VALUES
(1, 'reda', 340, 2, 3, '2', 2, 0),
(2, 'walid', 186, 5, 5, '1', 2, 0),
(3, 'yassin', 688, 4, 5, '1', 3, 1),
(4, 'Syco', 274, 1, 1, '3', 3, 1);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
