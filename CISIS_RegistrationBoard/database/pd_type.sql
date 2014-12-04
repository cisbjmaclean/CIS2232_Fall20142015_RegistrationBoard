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