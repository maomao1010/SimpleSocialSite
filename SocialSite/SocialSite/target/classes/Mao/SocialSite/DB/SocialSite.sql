-- --------------------------------------------------------
-- 主機:                           127.0.0.1
-- 伺服器版本:                        10.3.39-MariaDB - mariadb.org binary distribution
-- 伺服器作業系統:                      Win64
-- HeidiSQL 版本:                  12.5.0.6677
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- 傾印 socialsite 的資料庫結構
CREATE DATABASE IF NOT EXISTS `socialsite` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci */;
USE `socialsite`;

-- 傾印  資料表 socialsite.commentdata 結構
CREATE TABLE IF NOT EXISTS `commentdata` (
  `CommentID` varchar(50) NOT NULL DEFAULT '',
  `UserID` varchar(50) NOT NULL DEFAULT '',
  `PostID` varchar(50) NOT NULL DEFAULT '',
  `Content` varchar(100) NOT NULL DEFAULT '',
  `CreatedAt` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  PRIMARY KEY (`CommentID`),
  KEY `FK_commentdata_userdata` (`UserID`),
  KEY `FK_commentdata_postdata` (`PostID`),
  CONSTRAINT `FK_commentdata_postdata` FOREIGN KEY (`PostID`) REFERENCES `postdata` (`PostID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_commentdata_userdata` FOREIGN KEY (`UserID`) REFERENCES `userdata` (`UserID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- 正在傾印表格  socialsite.commentdata 的資料：~0 rows (近似值)

-- 傾印  資料表 socialsite.postdata 結構
CREATE TABLE IF NOT EXISTS `postdata` (
  `PostID` varchar(50) NOT NULL DEFAULT '',
  `UserID` varchar(50) NOT NULL DEFAULT '',
  `Content` varchar(50) NOT NULL DEFAULT '',
  `Image` varchar(50) DEFAULT '',
  `CreateAt` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  PRIMARY KEY (`PostID`),
  KEY `FK_postdata_userdata` (`UserID`),
  CONSTRAINT `FK_postdata_userdata` FOREIGN KEY (`UserID`) REFERENCES `userdata` (`UserID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- 正在傾印表格  socialsite.postdata 的資料：~0 rows (近似值)

-- 傾印  資料表 socialsite.userdata 結構
CREATE TABLE IF NOT EXISTS `userdata` (
  `UserID` varchar(50) NOT NULL DEFAULT '',
  `Name` varchar(50) NOT NULL DEFAULT '',
  `Phone` varchar(50) NOT NULL DEFAULT '',
  `Email` varchar(50) NOT NULL DEFAULT '',
  `Password` varchar(50) NOT NULL DEFAULT '',
  `CoverImage` varchar(50) DEFAULT '',
  `Biography` varchar(50) NOT NULL DEFAULT '',
  PRIMARY KEY (`UserID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- 正在傾印表格  socialsite.userdata 的資料：~0 rows (近似值)

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
