-- phpMyAdmin SQL Dump
-- version 3.2.4
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Dec 03, 2014 at 04:55 PM
-- Server version: 5.1.44
-- PHP Version: 5.3.1

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `cisis_registration_db`
--

-- --------------------------------------------------------

--
-- Table structure for table `member`
--

CREATE TABLE IF NOT EXISTS `member` (
  `member_id` int(6) NOT NULL COMMENT 'This member id is the primary key',
  `user_id` varchar(20) NOT NULL COMMENT 'Member''s user id',
  `organization_type` int(6) NOT NULL COMMENT 'A reference to the organization code (1)to which the member belongs.',
  `status_type` int(6) NOT NULL COMMENT 'A reference to the status code (2).',
  `confirm_status` int(11) NOT NULL COMMENT 'This user has confirmed or has not confirmed their information.',
  `user_type` int(11) NOT NULL COMMENT 'Code type 17',
  `created_date_time` datetime NOT NULL COMMENT 'Created date/time',
  `created_user_id` varchar(20) NOT NULL COMMENT 'Created user id ',
  `updated_date_time` datetime NOT NULL COMMENT 'Updated date/time',
  `updated_user_id` varchar(20) NOT NULL COMMENT 'Updated user id',
  PRIMARY KEY (`member_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='This is the base member tale.  Other tables will link by the';

--
-- Dumping data for table `member`
--

INSERT INTO `member` (`member_id`, `user_id`, `organization_type`, `status_type`, `confirm_status`, `user_type`, `created_date_time`, `created_user_id`, `updated_date_time`, `updated_user_id`) VALUES
(1, 'bjmaclean', 1, 1, 0, 1, '2014-08-05 00:00:00', 'Admin', '2014-08-05 00:00:00', 'Admin'),
(7, '1052', 1, 1, 0, 2, '2014-08-16 22:52:50', '', '2014-08-16 22:52:50', ''),
(8, 'AlanNormal', 1, 1, 0, 2, '2014-08-18 15:08:32', '', '2014-08-18 15:08:32', ''),
(9, 'AlanAdmin', 1, 1, 0, 1, '2014-08-18 15:09:03', '', '2014-08-18 15:09:03', ''),
(10, 'zmtheriault', 1, 1, 0, 0, '2014-12-03 12:50:07', '', '2014-12-03 12:50:07', '');
