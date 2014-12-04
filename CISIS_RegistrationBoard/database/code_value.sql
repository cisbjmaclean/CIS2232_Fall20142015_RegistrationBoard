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
-- Table structure for table `code_value`
--

CREATE TABLE IF NOT EXISTS `code_value` (
  `code_type_id` int(3) NOT NULL COMMENT 'see code_type table',
  `code_value_sequence` int(3) NOT NULL COMMENT 'Along with code type id make up the primary key',
  `english_description` varchar(100) NOT NULL COMMENT 'English description',
  `english_description_short` varchar(20) NOT NULL COMMENT 'English abbreviation for description',
  `french_description` varchar(100) NOT NULL COMMENT 'French description',
  `french_description_short` varchar(20) NOT NULL COMMENT 'French abbreviation for description',
  `created_date_time` datetime NOT NULL,
  `created_user_id` varchar(20) NOT NULL,
  `updated_date_time` datetime NOT NULL,
  `updated_user_id` varchar(20) NOT NULL,
  PRIMARY KEY (`code_type_id`,`code_value_sequence`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='This will hold code values for the application.';

--
-- Dumping data for table `code_value`
--

INSERT INTO `code_value` (`code_type_id`, `code_value_sequence`, `english_description`, `english_description_short`, `french_description`, `french_description_short`, `created_date_time`, `created_user_id`, `updated_date_time`, `updated_user_id`) VALUES
(1, 1, 'PEI Dietitians', 'PEI Dietitians', 'PEI Dietitians', '0', '2014-06-07 00:00:00', 'BJMACLEAN', '2014-06-07 00:00:00', 'BJMACLEAN'),
(2, 1, 'Active', 'Active', 'Active', '0', '2014-06-07 00:00:00', 'BJMACLEAN', '2014-06-07 00:00:00', 'BJMACLEAN'),
(2, 2, 'Inactive', 'Inactive', 'Inactive', '0', '2014-06-07 00:00:00', 'BJMACLEAN', '2014-06-07 00:00:00', 'BJMACLEAN'),
(3, 1, 'Miss', 'Miss', 'Miss', '0', '2014-06-07 00:00:00', 'BJMACLEAN', '2014-06-07 00:00:00', 'BJMACLEAN'),
(3, 2, 'Mr', 'Mr', 'Mr', '0', '2014-06-07 00:00:00', 'BJMACLEAN', '2014-06-07 00:00:00', 'BJMACLEAN'),
(3, 3, 'Mrs', 'Mrs', 'Mrs', '0', '2014-06-07 00:00:00', 'BJMACLEAN', '2014-06-07 00:00:00', 'BJMACLEAN'),
(3, 4, 'Ms', 'Ms', 'Ms', '0', '2014-06-07 00:00:00', 'BJMACLEAN', '2014-06-07 00:00:00', 'BJMACLEAN'),
(3, 5, 'Dr', 'Dr', 'Dr', '0', '2014-06-07 00:00:00', 'BJMACLEAN', '2014-06-07 00:00:00', 'BJMACLEAN'),
(4, 1, 'Members', 'Members', 'Members', '0', '2014-06-07 00:00:00', 'BJMACLEAN', '2014-06-07 00:00:00', 'BJMACLEAN'),
(4, 2, 'Business', 'Business', 'Business', '0', '2014-06-07 00:00:00', 'BJMACLEAN', '2014-06-07 00:00:00', 'BJMACLEAN'),
(4, 3, 'Government', 'Government', 'Government', '0', '2014-06-07 00:00:00', 'BJMACLEAN', '2014-06-07 00:00:00', 'BJMACLEAN'),
(4, 4, 'PEIDA Executive', 'PEIDA Executive', 'PEIDA Executive', '0', '2014-06-07 00:00:00', 'BJMACLEAN', '2014-06-07 00:00:00', 'BJMACLEAN'),
(5, 1, 'Yukon', 'Yukon', 'Yukon', '0', '2014-06-07 00:00:00', 'BJMACLEAN', '2014-06-07 00:00:00', 'BJMACLEAN'),
(5, 2, 'Saskatchewan', 'Saskatchewan', 'Saskatchewan', '0', '2014-06-07 00:00:00', 'BJMACLEAN', '2014-06-07 00:00:00', 'BJMACLEAN'),
(5, 3, 'Quebec', 'Quebec', 'Quebec', '0', '2014-06-07 00:00:00', 'BJMACLEAN', '2014-06-07 00:00:00', 'BJMACLEAN'),
(5, 4, 'Prince Edward Island', 'PEI', 'Prince Edward Island', '0', '2014-06-07 00:00:00', 'BJMACLEAN', '2014-06-07 00:00:00', 'BJMACLEAN'),
(5, 5, 'Ontario', 'Ontario', 'Ontario', '0', '2014-06-07 00:00:00', 'BJMACLEAN', '2014-06-07 00:00:00', 'BJMACLEAN'),
(5, 6, 'Nunavut', 'Nunavut', 'Nunavut', '0', '2014-06-07 00:00:00', 'BJMACLEAN', '2014-06-07 00:00:00', 'BJMACLEAN'),
(5, 7, 'Nova Scotia', 'Nova Scotia', 'Nova Scotia', '0', '2014-06-07 00:00:00', 'BJMACLEAN', '2014-06-07 00:00:00', 'BJMACLEAN'),
(5, 8, 'Northwest Territories', 'NWT', 'Northwest Territories', '0', '2014-06-07 00:00:00', 'BJMACLEAN', '2014-06-07 00:00:00', 'BJMACLEAN'),
(5, 9, 'Newfoundland and Labrador', 'NFLD LAB', 'Newfoundland and Labrador', '0', '2014-06-07 00:00:00', 'BJMACLEAN', '2014-06-07 00:00:00', 'BJMACLEAN'),
(5, 10, 'New Brunswick', 'New Brunswick', 'New Brunswick', '0', '2014-06-07 00:00:00', 'BJMACLEAN', '2014-06-07 00:00:00', 'BJMACLEAN'),
(5, 11, 'Manitoba', 'Manitoba', 'Manitoba', '0', '2014-06-07 00:00:00', 'BJMACLEAN', '2014-06-07 00:00:00', 'BJMACLEAN'),
(5, 12, 'British Columbia', 'British Columbia', 'British Columbia', '0', '2014-06-07 00:00:00', 'BJMACLEAN', '2014-06-07 00:00:00', 'BJMACLEAN'),
(5, 13, 'Alberta', 'Alberta', 'Alberta', '0', '2014-06-07 00:00:00', 'BJMACLEAN', '2014-06-07 00:00:00', 'BJMACLEAN'),
(6, 1, 'Male', 'Male', 'Male', '0', '2014-06-07 00:00:00', 'BJMACLEAN', '2014-06-07 00:00:00', 'BJMACLEAN'),
(6, 2, 'Female', 'Female', 'Female', '0', '2014-06-07 00:00:00', 'BJMACLEAN', '2014-06-07 00:00:00', 'BJMACLEAN'),
(7, 1, 'Canada', 'Canada', 'Canada', '0', '2014-06-07 00:00:00', 'BJMACLEAN', '2014-06-07 00:00:00', 'BJMACLEAN'),
(7, 2, 'United States', 'United States', 'United States', '0', '2014-06-07 00:00:00', 'BJMACLEAN', '2014-06-07 00:00:00', 'BJMACLEAN'),
(8, 1, 'Doctorate', 'phd', 'Doctorate', '0', '2014-06-15 00:00:00', 'BJMACLEAN', '2014-06-15 00:00:00', 'BJMACLEAN'),
(8, 2, 'Masters', 'Masters', 'Masters', 'Masters', '2014-06-07 00:00:00', 'BJMACLEAN', '2014-06-07 00:00:00', 'BJMACLEAN'),
(8, 3, 'Baccalaureate', 'Baccalaureate', 'Baccalaureate', 'Baccalaureate', '2014-06-07 00:00:00', 'BJMACLEAN', '2014-06-07 00:00:00', 'BJMACLEAN'),
(8, 4, 'Certificate', 'Certificate', 'Certificate', 'Certificate', '2014-06-07 00:00:00', 'BJMACLEAN', '2014-06-07 00:00:00', 'BJMACLEAN'),
(8, 5, 'Diploma', 'Diploma', 'Diploma', 'Diploma', '2014-06-07 00:00:00', 'BJMACLEAN', '2014-06-07 00:00:00', 'BJMACLEAN'),
(8, 6, 'Other', 'Other', 'Other', 'Other', '2014-06-07 00:00:00', 'BJMACLEAN', '2014-06-07 00:00:00', 'BJMACLEAN'),
(8, 7, 'Internship', 'Internship', 'Internship', 'Internship', '2014-06-18 00:00:00', 'BJMACLEAN', '2014-06-18 00:00:00', 'BJMACLEAN'),
(9, 1, 'Employed as dietitian', '', '', '', '2014-06-18 00:00:00', 'BJMACLEAN', '2014-06-18 00:00:00', 'BJMACLEAN'),
(9, 2, 'Unemployed/Seeking Employment as Dietitian', '', '', '', '2014-06-18 00:00:00', 'BJMACLEAN', '2014-06-18 00:00:00', 'BJMACLEAN'),
(9, 3, 'Unemployed/Not Seeking Employment as Dietitian', '', '', '', '2014-06-18 00:00:00', 'BJMACLEAN', '2014-06-18 00:00:00', 'BJMACLEAN'),
(10, 1, '800 hours within the last five years', '', '', '', '2014-06-18 00:00:00', 'BJMACLEAN', '2014-06-18 00:00:00', 'BJMACLEAN'),
(10, 2, '400 hours within the last five years', '', '', '', '2014-06-18 00:00:00', 'BJMACLEAN', '2014-06-18 00:00:00', 'BJMACLEAN'),
(10, 3, '225 hours in a single continuous block\r\nof work within the last three years', '', '', '', '2014-06-18 00:00:00', 'BJMACLEAN', '2014-06-18 00:00:00', 'BJMACLEAN'),
(10, 4, 'None of the above', '', '', '', '2014-06-18 00:00:00', 'BJMACLEAN', '2014-06-18 00:00:00', 'BJMACLEAN'),
(11, 1, 'Queen Elizabeth Hospital', '', '', '0', '2014-06-07 00:00:00', 'BJMACLEAN', '2014-06-07 00:00:00', 'BJMACLEAN'),
(11, 2, 'Prince County Hospital', '', '', '0', '2014-06-07 00:00:00', 'BJMACLEAN', '2014-06-07 00:00:00', 'BJMACLEAN'),
(12, 1, 'Full Time', '', '', '0', '2014-06-07 00:00:00', 'BJMACLEAN', '2014-06-07 00:00:00', 'BJMACLEAN'),
(12, 2, 'Part Time', '', '', '0', '2014-06-07 00:00:00', 'BJMACLEAN', '2014-06-07 00:00:00', 'BJMACLEAN'),
(13, 1, 'Permanent', '', '', '0', '2014-06-07 00:00:00', 'BJMACLEAN', '2014-06-07 00:00:00', 'BJMACLEAN'),
(13, 2, 'Temporary', '', '', '0', '2014-06-07 00:00:00', 'BJMACLEAN', '2014-06-07 00:00:00', 'BJMACLEAN'),
(13, 3, 'Casual', '', '', '0', '2014-06-07 00:00:00', 'BJMACLEAN', '2014-06-07 00:00:00', 'BJMACLEAN'),
(13, 4, 'Self Employed', '', '', '0', '2014-06-07 00:00:00', 'BJMACLEAN', '2014-06-07 00:00:00', 'BJMACLEAN'),
(14, 1, 'Public/Government', '', '', '0', '2014-06-07 00:00:00', 'BJMACLEAN', '2014-06-07 00:00:00', 'BJMACLEAN'),
(14, 2, 'Private Sector/Individual Client(s)', '', '', '0', '2014-06-07 00:00:00', 'BJMACLEAN', '2014-06-07 00:00:00', 'BJMACLEAN'),
(14, 3, 'Public/Private Mix', '', '', '0', '2014-06-07 00:00:00', 'BJMACLEAN', '2014-06-07 00:00:00', 'BJMACLEAN'),
(14, 4, 'Public/Government', '', '', '0', '2014-06-07 00:00:00', 'BJMACLEAN', '2014-06-07 00:00:00', 'BJMACLEAN'),
(14, 5, 'Other Funding Source', '', '', '0', '2014-06-07 00:00:00', 'BJMACLEAN', '2014-06-07 00:00:00', 'BJMACLEAN'),
(15, 1, 'Dietitian', '', '', '', '2014-06-18 00:00:00', 'BJMACLEAN', '2014-06-18 00:00:00', 'BJMACLEAN'),
(15, 2, 'Other', '', '', '', '2014-06-18 00:00:00', 'BJMACLEAN', '2014-06-18 00:00:00', 'BJMACLEAN'),
(16, 1, 'Message', 'Message', 'Message', 'Message', '2014-06-07 00:00:00', 'BJMACLEAN', '2014-06-07 00:00:00', 'BJMACLEAN'),
(16, 2, 'Important Message', 'Important Message', 'IM', 'IM', '2014-06-07 00:00:00', 'BJMACLEAN', '2014-06-07 00:00:00', 'BJMACLEAN'),
(17, 1, 'Administrator', 'Admin', 'Administrator', 'Admin', '2014-08-16 21:55:23', 'Admin', '2014-08-16 21:55:23', 'Admin'),
(17, 2, 'Member', 'Member', 'Member', 'Member', '2014-08-16 21:56:07', 'Admin', '2014-08-16 21:56:07', 'Admin'),
(21, 5, 'Short Courses/ Workshops/ Meetings/ Seminars/ Conf...', 'ShortCourses', 'Short Courses/ Workshops/ Meetings/ Seminars/ Conf...', 'ShortCourses', '2014-11-28 00:00:00', '1', '2014-11-21 00:00:00', '1'),
(21, 6, 'Non-Interactice Webinars/ Teleconference/ Telemedi...', 'Non-Interactice', 'Non-Interactice Webinars/ Teleconference/ Telemedi...', 'Non-Interactice.', '2014-11-28 00:00:00', '1', '2014-11-29 00:00:00', '1'),
(21, 7, 'Journal Club Preparation and presentation to a gro...', 'Journal ClubAnd', 'Journal Club Preparation and presentation to a gro...', 'Journal ClubAnd', '2014-11-27 00:00:00', '1', '2014-11-29 00:00:00', '1'),
(21, 8, 'Journal Club Participation', 'Journal Club', 'Journal Club Participation', 'Journal Club', '2014-11-27 00:00:00', '1', '2014-11-29 00:00:00', '1'),
(21, 9, 'Individual Study Program that is pre-approved by t...', 'IndStudProgpre-appro', 'Individual Study Program that is pre-approved by t...', 'IndStudProgpre-appro', '2014-11-06 00:00:00', '1', '2014-11-21 00:00:00', '1'),
(21, 10, 'Presentations To Professionals', 'PresentationsProfes', 'Presentations To Professionals', 'PresentationsProfes', '2014-11-19 00:00:00', '1', '2014-11-26 00:00:00', '1'),
(21, 11, 'Presentations - Discussion leader at professional ...', 'PresDiscleaderprof', 'Presentations - Discussion leader at professional ...', 'PresDiscleaderprof', '2014-11-19 00:00:00', '1', '2014-11-28 00:00:00', '1'),
(21, 12, 'Presentations- Poster Presentation', 'Poster Presentation', 'Presentations- Poster Presentation', 'Poster Presentation', '2014-11-21 00:00:00', '1', '2014-11-28 00:00:00', '1'),
(21, 13, 'Writing for Publication- Article for professional ...', 'WritingArticleprofes', 'Writing for Publication- Article for professional ...', 'WritingArticleprofes', '2014-11-13 00:00:00', '1', '2014-11-28 00:00:00', '1'),
(21, 14, 'Writing for Publication- Peer reviewed article', 'WritingPeerreviewed', 'Writing for Publication- Peer reviewed article', 'WritingPeerreviewed', '2014-11-13 00:00:00', '1', '2014-11-28 00:00:00', '1'),
(21, 15, 'Writing for Publication- Book review for professio...', 'WritingBookprofess', 'Writing for Publication- Book review for professio...', 'WritingBookprofess', '2014-11-27 00:00:00', '1', '2014-11-28 00:00:00', '1'),
(21, 16, 'Media Relations- Radio/TV/Newspaper interview', 'Mediainterview', 'Media Relations- Radio/TV/Newspaper interview', 'Mediainterview', '2014-11-27 00:00:00', '1', '2014-11-28 00:00:00', '1'),
(21, 17, 'Media Relations- Newspaper articles on professiona...', 'Mediaprofessiona', 'Media Relations- Newspaper articles on professiona...', 'Mediaprofessiona', '2014-11-21 00:00:00', '1', '2014-11-29 00:00:00', '1'),
(21, 18, 'Professional, Trade, and Educational Exhibits', 'Professional Exhibit', 'Professional, Trade, and Educational Exhibits', 'Professional Exhibit', '2014-11-17 00:00:00', '1', '2014-11-27 00:00:00', '1'),
(21, 19, 'Participation on Registration Board', 'Participation on Reg', 'Participation on Registration Board', 'Participation on Reg', '2014-11-14 00:00:00', '1', '2014-11-26 00:00:00', '1'),
(21, 20, 'Preparing Examinations/ Evaluating Candidates', 'Preparing Examinatio', 'Preparing Examinations/ Evaluating Candidates', 'Preparing Examinatio', '2014-11-20 00:00:00', '1', '2014-11-24 00:00:00', '1');

