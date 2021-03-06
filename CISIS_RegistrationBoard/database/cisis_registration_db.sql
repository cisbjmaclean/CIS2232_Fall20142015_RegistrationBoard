-- phpMyAdmin SQL Dump
-- version 4.1.6
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Dec 15, 2014 at 06:19 PM
-- Server version: 5.6.16
-- PHP Version: 5.5.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `cisis_registration_db`
--

-- --------------------------------------------------------

--
-- Table structure for table `code_type`
--

CREATE TABLE IF NOT EXISTS `code_type` (
  `code_type` int(3) NOT NULL COMMENT 'This is the primary key for code types',
  `english_description` varchar(100) NOT NULL COMMENT 'English description',
  `french_description` varchar(100) NOT NULL COMMENT 'French description',
  `created_date_time` datetime NOT NULL,
  `created_user_id` varchar(20) NOT NULL,
  `updated_date_time` datetime NOT NULL,
  `updated_user_id` varchar(20) NOT NULL,
  PRIMARY KEY (`code_type`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='This hold the code types that are available for the applicat';

--
-- Dumping data for table `code_type`
--

INSERT INTO `code_type` (`code_type`, `english_description`, `french_description`, `created_date_time`, `created_user_id`, `updated_date_time`, `updated_user_id`) VALUES
(1, 'Organizations', 'Organizations', '2014-06-06 00:00:00', 'BJMACLEAN', '2014-06-06 00:00:00', 'BJMACLEAN'),
(2, 'status', 'status', '2014-06-06 00:00:00', 'BJMACLEAN', '2014-06-06 00:00:00', 'BJMACLEAN'),
(3, 'salutation', 'salutation', '2014-06-06 00:00:00', 'BJMACLEAN', '2014-06-06 00:00:00', 'BJMACLEAN'),
(4, 'circulation group', 'circulation group', '2014-06-06 00:00:00', 'BJMACLEAN', '2014-06-06 00:00:00', 'BJMACLEAN'),
(5, 'provinces', 'provinces', '2014-06-06 00:00:00', 'BJMACLEAN', '2014-06-06 00:00:00', 'BJMACLEAN'),
(6, 'gender', 'gender', '2014-06-06 00:00:00', 'BJMACLEAN', '2014-06-06 00:00:00', 'BJMACLEAN'),
(7, 'Countries', 'Countries', '2014-06-06 00:00:00', 'BJMACLEAN', '2014-06-06 00:00:00', 'BJMACLEAN'),
(8, 'Education designations', 'Education designations', '2014-06-15 00:00:00', 'BJMACLEAN', '2014-06-15 00:00:00', 'BJMACLEAN'),
(9, 'Employment Status', 'Employment Status', '2014-06-15 00:00:00', 'BJMACLEAN', '2014-06-15 00:00:00', 'BJMACLEAN'),
(10, 'Currency Options', 'Currency Options', '2014-06-15 00:00:00', 'BJMACLEAN', '2014-06-15 00:00:00', 'BJMACLEAN'),
(11, 'Practice Areas', 'Practice Areas', '2014-06-15 00:00:00', 'BJMACLEAN', '2014-06-15 00:00:00', 'BJMACLEAN'),
(12, 'Employment Status', 'Employment Status', '2014-06-15 00:00:00', 'BJMACLEAN', '2014-06-15 00:00:00', 'BJMACLEAN'),
(13, 'Employment Category', 'Employment Category', '2014-06-15 00:00:00', 'BJMACLEAN', '2014-06-15 00:00:00', 'BJMACLEAN'),
(14, 'Funding Source', 'Funding Source', '2014-06-15 00:00:00', 'BJMACLEAN', '2014-06-15 00:00:00', 'BJMACLEAN'),
(15, 'Positions', 'Positions', '2014-06-15 00:00:00', 'BJMACLEAN', '2014-06-15 00:00:00', 'BJMACLEAN'),
(16, 'Notification types', 'Notification types', '2014-06-06 00:00:00', 'BJMACLEAN', '2014-06-06 00:00:00', 'BJMACLEAN'),
(17, 'User types', 'User types', '2014-08-16 21:52:57', 'admin', '2014-08-16 21:52:57', 'admin'),
(18, 'Divisions', 'Divisions', '2014-08-16 21:52:57', 'admin', '2014-08-16 21:52:57', 'admin'),
(19, 'Levels', 'Levels', '2014-08-16 21:52:57', 'admin', '2014-08-16 21:52:57', 'admin'),
(20, 'Clubs', 'Clubs', '2014-08-16 21:52:57', 'admin', '2014-08-16 21:52:57', 'admin');

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
(21, 1, 'Graduate Course', 'Graduate Course', 'Graduate Course', 'Graduate Course', '2014-12-02 00:00:00', 'Graduate Course', '2014-12-17 00:00:00', '1'),
(21, 2, 'Undergrad Course', 'Undergrad Course', 'Undergrad Course', 'Undergrad Course', '2014-12-18 00:00:00', 'Undergrad Course', '2014-12-19 00:00:00', '1'),
(21, 3, 'Auditing Undergrad Course', 'Auditing Undergrad C', 'Auditing Undergrad Course', 'Auditing Undergrad C', '2014-12-19 00:00:00', 'Auditing Undergrad C', '2014-12-17 00:00:00', '1'),
(21, 4, 'Advanced Certification', 'Advanced Certificati', 'Advanced Certification', 'Advanced Certificati', '2014-12-17 00:00:00', 'Advanced Certificati', '2014-12-26 00:00:00', '1'),
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

-- --------------------------------------------------------

--
-- Table structure for table `event`
--

CREATE TABLE IF NOT EXISTS `event` (
  `event_num` int(10) NOT NULL AUTO_INCREMENT,
  `member_id` int(6) NOT NULL,
  `pd_code` int(3) NOT NULL,
  `date` varchar(10) NOT NULL,
  `description` varchar(144) NOT NULL,
  `hour` double(10,2) NOT NULL,
  PRIMARY KEY (`event_num`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=8 ;

--
-- Dumping data for table `event`
--

INSERT INTO `event` (`event_num`, `member_id`, `pd_code`, `date`, `description`, `hour`) VALUES
(1, 1, 1, '10/10/1987', 'test', 0.00),
(3, 1, 3, '2014-07-09', 'This is an audited course.', 0.00),
(4, 1, 2, '2014-09-09', 'test', 0.00),
(5, 1, 1, '2014-12-24', 'testing confirm', 0.00);

-- --------------------------------------------------------

--
-- Table structure for table `member`
--

CREATE TABLE IF NOT EXISTS `member` (
  `member_id` int(6) NOT NULL COMMENT 'This member id is the primary key',
  `user_id` varchar(20) NOT NULL COMMENT 'Member''s user id',
  `organization_type` int(6) NOT NULL COMMENT 'A reference to the organization code (1)to which the member belongs.',
  `status_type` int(6) NOT NULL COMMENT 'A reference to the status code (2).',
  `confirm_status` int(5) NOT NULL,
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
(1, 'bjmaclean', 1, 1, 1, 1, '2014-08-05 00:00:00', 'Admin', '2014-11-28 09:29:18', 'bjmaclean');

-- --------------------------------------------------------

--
-- Table structure for table `member_access`
--

CREATE TABLE IF NOT EXISTS `member_access` (
  `member_id` int(6) NOT NULL COMMENT 'Member id',
  `user_id` varchar(20) NOT NULL COMMENT 'Member''s user id',
  `password` varchar(20) NOT NULL COMMENT 'Member''s password',
  `access_string` varchar(20) NOT NULL COMMENT 'Bits representing the roles for this user',
  `created_date_time` datetime NOT NULL,
  `created_user_id` varchar(20) NOT NULL,
  `updated_date_time` datetime NOT NULL,
  `updated_user_id` varchar(20) NOT NULL,
  PRIMARY KEY (`member_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='This contains member access data';

--
-- Dumping data for table `member_access`
--

INSERT INTO `member_access` (`member_id`, `user_id`, `password`, `access_string`, `created_date_time`, `created_user_id`, `updated_date_time`, `updated_user_id`) VALUES
(1, 'bjmaclean', 'bjmacleanpw', '1111111111', '2014-06-07 00:00:00', 'BJMACLEAN', '2014-08-17 21:40:37', 'bjmaclean');

-- --------------------------------------------------------

--
-- Table structure for table `member_bio`
--

CREATE TABLE IF NOT EXISTS `member_bio` (
  `member_id` int(6) DEFAULT NULL,
  `first_name` varchar(20) DEFAULT NULL,
  `middle_name` varchar(20) DEFAULT NULL,
  `last_name` varchar(20) DEFAULT NULL,
  `address_1` varchar(30) DEFAULT NULL,
  `address_2` varchar(30) DEFAULT NULL,
  `municipality` varchar(30) DEFAULT NULL COMMENT 'Community/town/city',
  `province_code` int(3) DEFAULT NULL COMMENT 'Code type 5',
  `postal_code` varchar(6) DEFAULT NULL COMMENT 'Postal code (no dash)',
  `home_phone` varchar(10) DEFAULT NULL,
  `cell_phone` varchar(10) DEFAULT NULL,
  `work_phone` varchar(10) DEFAULT NULL,
  `work_phone_extension` varchar(5) DEFAULT NULL,
  `fax_number` varchar(10) DEFAULT NULL,
  `email_address` varchar(50) DEFAULT NULL,
  `date_of_birth` varchar(10) DEFAULT NULL COMMENT 'yyyy-mm-dd format',
  `gender_code` int(3) DEFAULT NULL COMMENT 'code type 6'
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Member biographical information';

--
-- Dumping data for table `member_bio`
--

INSERT INTO `member_bio` (`member_id`, `first_name`, `middle_name`, `last_name`, `address_1`, `address_2`, `municipality`, `province_code`, `postal_code`, `home_phone`, `cell_phone`, `work_phone`, `work_phone_extension`, `fax_number`, `email_address`, `date_of_birth`, `gender_code`) VALUES
(1, 'Bruce', 'John', 'MacLean', '69 Bonavista Ave.', '', 'Stratford', 5, 'c1b0e3', '9025691111', NULL, '9025669663', '663', '9022225555', 'bjmaclean@hollandcollege.com', '2000-01-05', 2);

-- --------------------------------------------------------

--
-- Table structure for table `member_bio_registration`
--

CREATE TABLE IF NOT EXISTS `member_bio_registration` (
  `member_id` int(6) DEFAULT NULL,
  `salutation_code` int(3) DEFAULT NULL COMMENT 'Code type 3',
  `previous_surnames` varchar(100) DEFAULT NULL COMMENT 'Any priour surnames',
  `email_to_members` tinyint(1) DEFAULT NULL COMMENT 'Permission to distribute email to members',
  `email_to_business` tinyint(1) DEFAULT NULL COMMENT 'Permission to distribute email to business',
  `email_to_government` tinyint(1) DEFAULT NULL COMMENT 'Permission to distribute email to government',
  `email_to_peida_executive` tinyint(1) DEFAULT NULL COMMENT 'Permission to distribute email to PEIDA Executive',
  `website_address` varchar(50) DEFAULT NULL,
  `bilingual_e_f_ind` tinyint(1) DEFAULT NULL COMMENT 'boolean for English/French',
  `bilingual_other` varchar(50) DEFAULT NULL COMMENT 'other bilingual combination',
  `canadian_citizen_ind` tinyint(1) DEFAULT NULL,
  `landed_immigrant_ind` tinyint(1) DEFAULT NULL,
  `country_of_origin_code` int(3) DEFAULT NULL COMMENT 'Country of origin',
  `immigrant_authorized_ind` tinyint(1) DEFAULT NULL,
  `immigrant_authorized_expiry_date` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Member biographical information';

--
-- Dumping data for table `member_bio_registration`
--

INSERT INTO `member_bio_registration` (`member_id`, `salutation_code`, `previous_surnames`, `email_to_members`, `email_to_business`, `email_to_government`, `email_to_peida_executive`, `website_address`, `bilingual_e_f_ind`, `bilingual_other`, `canadian_citizen_ind`, `landed_immigrant_ind`, `country_of_origin_code`, `immigrant_authorized_ind`, `immigrant_authorized_expiry_date`) VALUES
(1, 2, 'None', 1, 0, 1, 0, 'bjmac.hccis.info:8080/registrationboard', 0, 'N/A', 0, 1, 1, 0, '');

-- --------------------------------------------------------

--
-- Table structure for table `member_education`
--

CREATE TABLE IF NOT EXISTS `member_education` (
  `member_id` int(6) NOT NULL COMMENT 'Member id pk',
  `me_sequence` int(6) NOT NULL COMMENT 'Sequence number unique in this table.',
  `program_code` int(3) NOT NULL COMMENT 'Code type 8',
  `designation` varchar(25) NOT NULL COMMENT 'type of cert.',
  `me_year` int(4) NOT NULL COMMENT 'Year certification was received',
  `me_province_code` int(3) NOT NULL COMMENT 'Province education received',
  `me_institution` varchar(100) NOT NULL COMMENT 'Name of granting institution',
  `me_core_ind` tinyint(1) NOT NULL COMMENT 'Is this a core eduction',
  `me_active_ind` bigint(20) unsigned NOT NULL COMMENT 'Active code type',
  `created_date_time` datetime NOT NULL,
  `created_user_id` varchar(20) NOT NULL,
  `updated_date_time` datetime NOT NULL,
  `updated_user_id` varchar(20) NOT NULL,
  PRIMARY KEY (`member_id`,`me_sequence`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Member education data';

--
-- Dumping data for table `member_education`
--

INSERT INTO `member_education` (`member_id`, `me_sequence`, `program_code`, `designation`, `me_year`, `me_province_code`, `me_institution`, `me_core_ind`, `me_active_ind`, `created_date_time`, `created_user_id`, `updated_date_time`, `updated_user_id`) VALUES
(1, 1, 1, '', 2010, 1, 'UPEI', 1, 0, '2014-06-15 00:00:00', 'BJMACLEAN', '2014-08-17 00:06:11', 'BJMACLEAN'),
(1, 2, 2, '', 2015, 4, 'mcm', 1, 0, '2014-06-15 22:20:10', '', '2014-06-21 19:01:31', ''),
(1, 3, 2, 'Science', 1995, 5, 'McMaster', 0, 1, '2014-06-15 22:54:41', '', '2014-06-15 22:54:41', '');

-- --------------------------------------------------------

--
-- Table structure for table `member_employer`
--

CREATE TABLE IF NOT EXISTS `member_employer` (
  `member_id` int(6) NOT NULL,
  `me_sequence` int(11) NOT NULL COMMENT 'sequence of the employer for a given employee',
  `me_active_ind` tinyint(1) NOT NULL COMMENT 'deleted or not.',
  `member_employer_primary_ind` tinyint(1) DEFAULT NULL COMMENT 'Primary indicator',
  `employer_name` varchar(40) NOT NULL COMMENT 'Employer name',
  `address_1` varchar(30) NOT NULL,
  `address_2` varchar(30) NOT NULL,
  `municipality` varchar(30) NOT NULL COMMENT 'Community/town/city',
  `province_code` int(3) NOT NULL COMMENT 'Code type 5',
  `postal_code` varchar(6) NOT NULL COMMENT 'Postal code (no dash)',
  `position_code` int(3) DEFAULT NULL COMMENT 'Code type 15',
  `practice_area_code` int(3) DEFAULT NULL COMMENT 'Code type 11',
  `employment_status_code` int(3) DEFAULT NULL COMMENT 'Code type 12',
  `employment_category_code` int(3) DEFAULT NULL COMMENT 'Code type 13',
  `funding_source_code` int(3) DEFAULT NULL COMMENT 'Code type 14',
  `created_date_time` datetime NOT NULL,
  `created_user_id` varchar(20) NOT NULL,
  `updated_date_time` datetime NOT NULL,
  `updated_user_id` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `member_employer`
--

INSERT INTO `member_employer` (`member_id`, `me_sequence`, `me_active_ind`, `member_employer_primary_ind`, `employer_name`, `address_1`, `address_2`, `municipality`, `province_code`, `postal_code`, `position_code`, `practice_area_code`, `employment_status_code`, `employment_category_code`, `funding_source_code`, `created_date_time`, `created_user_id`, `updated_date_time`, `updated_user_id`) VALUES
(1, 1, 0, 1, '1', '2', '3', '4', 4, '5', 1, 1, 1, 1, 1, '2014-08-01 22:05:06', '', '2014-08-17 00:07:34', '');

-- --------------------------------------------------------

--
-- Table structure for table `member_employment`
--

CREATE TABLE IF NOT EXISTS `member_employment` (
  `member_id` int(6) NOT NULL,
  `employment_status_code` int(3) DEFAULT NULL COMMENT 'Code type 9',
  `currency_code` int(3) DEFAULT NULL COMMENT 'Code type 10',
  `practice_via_telephone_ind` tinyint(1) NOT NULL COMMENT 'employment - do they practice via telephone',
  `practice_via_internet_ind` tinyint(1) NOT NULL COMMENT 'employment - do they practice via internet',
  `practice_in_person_ind` tinyint(1) NOT NULL COMMENT 'employment - do they practice in person',
  `practice_jurisdictions` varchar(200) DEFAULT NULL COMMENT 'Jurisdictions where member practices'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `member_employment`
--

INSERT INTO `member_employment` (`member_id`, `employment_status_code`, `currency_code`, `practice_via_telephone_ind`, `practice_via_internet_ind`, `practice_in_person_ind`, `practice_jurisdictions`) VALUES
(1, 1, 2, 1, 0, 1, 'TEST');

-- --------------------------------------------------------

--
-- Table structure for table `notification`
--

CREATE TABLE IF NOT EXISTS `notification` (
  `notification_id` int(10) NOT NULL AUTO_INCREMENT,
  `notification_type_code` int(3) NOT NULL COMMENT 'Code type 16',
  `notification_detail` varchar(144) NOT NULL,
  `status_code` int(11) NOT NULL,
  `created_date_time` datetime NOT NULL,
  `created_user_id` varchar(20) DEFAULT NULL,
  `updated_date_time` datetime NOT NULL,
  `updated_user_id` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`notification_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=16 ;

--
-- Dumping data for table `notification`
--

INSERT INTO `notification` (`notification_id`, `notification_type_code`, `notification_detail`, `status_code`, `created_date_time`, `created_user_id`, `updated_date_time`, `updated_user_id`) VALUES
(5, 2, 'This is a test on Thursday.', 0, '2014-07-17 20:59:34', NULL, '2014-07-21 20:57:16', NULL),
(12, 1, 'bj test', 1, '2014-09-09 15:06:27', NULL, '2014-09-09 15:06:27', NULL),
(15, 2, 'just a test to see if it works', 1, '2014-11-20 09:37:42', NULL, '2014-11-20 09:37:42', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `pd_type`
--

CREATE TABLE IF NOT EXISTS `pd_type` (
  `pd_code` int(10) NOT NULL,
  `pd_title_eng` varchar(300) NOT NULL,
  `pd_title_fr` varchar(300) NOT NULL,
  `pd_hour` double(3,1) NOT NULL,
  `pd_comment_eng` varchar(144) NOT NULL,
  `pd_comment_fr` varchar(144) NOT NULL,
  `hour_req` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `pd_type`
--

INSERT INTO `pd_type` (`pd_code`, `pd_title_eng`, `pd_title_fr`, `pd_hour`, `pd_comment_eng`, `pd_comment_fr`, `hour_req`) VALUES
(1, 'Graduate Course', 'Graduate Course', 30.0, 'On Successful Completion', 'On Successful Completion', 0),
(2, 'Undergrad Course', 'Undergrad Course', 10.0, 'On Successful Completion', 'On Successful Completion', 0),
(3, 'Auditing Undergrad Course', 'Auditing Undergrad Course', 5.0, 'On Completion', 'On Completion', 0),
(4, 'Advanced Certification', 'Advanced Certification', 0.0, 'Credit hours evaluated on individual basis', 'Credit hours evaluated on individual basis', 0),
(5, 'Short Courses/ Workshops/ Meetings/ Seminars/ Conference/ Symposia/ Grand rounds/ Web-based or teleconference workshops or seminars that are interactive or include an assessment.', 'Short Courses/ Workshops/ Meetings/ Seminars/ Conference/ Symposia/ Grand rounds/ Web-based or teleconference workshops or seminars that are interactive or include an assessment.', 0.5, 'Per Hour of Professional Subject Matter * does not include lunch or coffee breaks.', 'Per Hour of Professional Subject Matter * does not include lunch or coffee breaks.', 1),
(6, 'Non-Interactice Webinars/ Teleconference/ Telemedicine/ Videos', 'Non-Interactice Webinars/ Teleconference/ Telemedicine/ Videos', 0.5, 'Per Hour of Professional Subject Matter * Up to a maximum of 5 c hrs/yr.', 'Per Hour of Professional Subject Matter * Up to a maximum of 5 c hrs/yr.', 1),
(7, 'Journal Club Preparation and presentation to a group of professionals.', 'Journal Club Preparation and presentation to a group of professionals.', 1.0, 'Per Hour of Professional Subject Matter.', 'Per Hour of Professional Subject Matter.', 1),
(8, 'Journal Club Participation', 'Journal Club Participation', 0.5, 'Per Hour of Professional Subject Matter', 'Per Hour of Professional Subject Matter', 1),
(9, 'Individual Study Program that is pre-approved by the Board', 'Individual Study Program that is pre-approved by the Board', 1.0, 'Per Hour of Professional Subject Matter.', 'Per Hour of Professional Subject Matter.', 1),
(10, 'Presentations To Professionals', 'Presentations To Professionals', 2.0, 'Per hr of Professional Subject Matter. Max 6 c hrs/yr.', 'Per hr of Professional Subject Matter. Max 6 c hrs/yr.', 1),
(11, 'Presentations - Discussion leader at professional seminars/workshops', 'Presentations - Discussion leader at professional seminars/workshops', 0.5, 'Per Presentation', 'Per Presentation', 0),
(12, 'Presentations- Poster Presentation', 'Presentations- Poster Presentation', 2.0, 'Per Poster.', 'Per Poster.', 0),
(13, 'Writing for Publication- Article for professional press', 'Writing for Publication- Article for professional press', 2.0, 'Per Article', 'Per Article', 0),
(14, 'Writing for Publication- Peer reviewed article', 'Writing for Publication- Peer reviewed article', 3.0, 'Per Article.', 'Per Article.', 0),
(15, 'Writing for Publication- Book review for professional press', 'Writing for Publication- Book review for professional press', 2.0, 'Per Book.', 'Per Book.', 0),
(16, 'Media Relations- Radio/TV/Newspaper interview', 'Media Relations- Radio/TV/Newspaper interview', 0.5, 'Per Interview', 'Per Interview', 0),
(17, 'Media Relations- Newspaper articles on professional topics', 'Media Relations- Newspaper articles on professional topics', 0.5, 'Per Article.', 'Per Article.', 0),
(18, 'Professional, Trade, and Educational Exhibits', 'Professional, Trade, and Educational Exhibits', 0.5, 'Per event(Max 2 c hrs/yr)', 'Per event(Max 2 c hrs/yr)', 0),
(19, 'Participation on Registration Board', 'Participation on Registration Board', 1.0, 'Per year', 'Per year', 0),
(20, 'Preparing Examinations/ Evaluating Candidates', 'Preparing Examinations/ Evaluating Candidates', 1.0, '1 c hr/yr', '1 c hr/yr', 0);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
