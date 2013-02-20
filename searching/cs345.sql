-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.1.37


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema cs345
--

CREATE DATABASE IF NOT EXISTS cs345;
USE cs345;

--
-- Definition of table `product`
--

DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `slno` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `item_name` varchar(200) NOT NULL,
  `qty` int(10) unsigned NOT NULL,
  `price` double(10,2) NOT NULL,
  PRIMARY KEY (`slno`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `product`
--

/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` (`slno`,`item_name`,`qty`,`price`) VALUES 
 (1,'coke',50,5.00),
 (2,'pepsi',5,11.00),
 (3,'Budweiser',10,15.00),
 (4,'Carlsberg Lager',25,26.00),
 (5,'Tomato Juice',35,55.00),
 (6,'Coca-Cola',100,6.00),
 (7,'Tomato Juice',1,150.00),
 (8,'Fla-Vor-Ice',6,75.00),
 (9,'Flavor Aid',31,21.00),
 (10,'Mondo Drinks',55,4.00),
 (11,'Otter-Pops',13,65.00),
 (12,'Pop-Ice',39,40.00),
 (13,'Wyler\'s',25,49.00),
 (14,'Magnolia Spice Teas',65,40.00),
 (15,'Minute Maid Fruit Drink',20,29.00),
 (16,'Hi-C Fruit Drink',60,20.00),
 (17,'Five Alive Juice',25,3.00),
 (18,'Whipple Smoothies',20,14.00),
 (19,'Ruby Red Drink',22,16.00),
 (20,'White Cranberry Peach',25,18.00),
 (21,'Old Orchard',35,8.00),
 (22,'Pespi Cola',45,27.00),
 (23,'Snapple',65,29.00),
 (24,'Ruby Red Drink',29,31.00),
 (25,'Pita Bread',11,33.00),
 (26,'Brownberry Bread',26,39.00),
 (27,'Boboli Bread',55,41.00),
 (28,'Crescent Rolls',6,43.00),
 (29,'Buttermilk Biscuits',3,47.00),
 (30,'Jumbo Buttermilk Biscuits',9,49.00),
 (31,'Texas Art Butter Flavor Biscuits',25,3.00),
 (32,'Country Delight Bread',76,7.00),
 (33,'Butternut',13,9.00),
 (34,'Sunbeam',15,4.00),
 (35,'Roman Meal',0,0.00);
/*!40000 ALTER TABLE `product` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
