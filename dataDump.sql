CREATE DATABASE  IF NOT EXISTS `dev` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `dev`;
-- MySQL dump 10.13  Distrib 8.0.33, for macos13 (arm64)
--
-- Host: 127.0.0.1    Database: dev
-- ------------------------------------------------------
-- Server version	8.0.33

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `feedbacks`
--

DROP TABLE IF EXISTS `feedbacks`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `feedbacks` (
  `feedback_id` bigint NOT NULL AUTO_INCREMENT,
  `timestamp` datetime(6) DEFAULT NULL,
  `rating` double DEFAULT NULL,
  `user_id` bigint DEFAULT NULL,
  PRIMARY KEY (`feedback_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `feedbacks`
--

LOCK TABLES `feedbacks` WRITE;
/*!40000 ALTER TABLE `feedbacks` DISABLE KEYS */;
INSERT INTO `feedbacks` VALUES (2,'2024-02-08 20:06:07.510213',2,1),(3,'2024-02-08 20:06:10.309391',2,1),(4,'2024-02-08 20:07:05.393515',2,1),(5,'2024-02-08 20:08:15.825693',3,1),(6,'2024-02-08 20:18:33.209750',3,1),(7,'2024-02-08 20:29:58.129814',3,1),(8,'2024-02-08 20:41:46.293229',3,1);
/*!40000 ALTER TABLE `feedbacks` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order_items`
--

DROP TABLE IF EXISTS `order_items`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `order_items` (
  `order_item_id` bigint NOT NULL AUTO_INCREMENT,
  `mrp` double DEFAULT NULL,
  `price` double DEFAULT NULL,
  `product_full_name` varchar(255) DEFAULT NULL,
  `product_id` varchar(255) DEFAULT NULL,
  `quantity` int DEFAULT NULL,
  `transaction_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`order_item_id`),
  KEY `FKr991hktdnn6evsyy5mup9moeb` (`transaction_id`),
  CONSTRAINT `FKr991hktdnn6evsyy5mup9moeb` FOREIGN KEY (`transaction_id`) REFERENCES `transactions` (`transaction_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_items`
--

LOCK TABLES `order_items` WRITE;
/*!40000 ALTER TABLE `order_items` DISABLE KEYS */;
INSERT INTO `order_items` VALUES (1,3475,3189,'Elite Footwear Classic White Sneakers','PRD12461SG3G',1,'TRX290060'),(2,1254,1000,'Bliss Pink Blush Palette','PRD12461SG3C',1,'TRX290060'),(3,3475,3132,'Opulent Blush Peach Blush Palette','PRD12461SG3H',1,'TRX290060'),(4,6513,5495,'Glow White Shirt','PRD12461SG3D',1,'TRX290060'),(5,5475,5400,'Stride Black Sneakers','PRD12461SG3B',1,'TRX290060'),(6,3463,3112,'Nova Trends Slim Fit Jeans','PRD12461SG3E',1,'TRX290060'),(7,3475,3466,'Mystique Striped Shirt','PRD12461SG3I',1,'TRX290060'),(8,3475,3156,'Eclat Nude Lipstick','PRD12461SG3F',1,'TRX290060'),(9,4475,4400,'Lush Red Lipstick','PRD12461SG3A',1,'TRX290060'),(10,3475,3400,'Verve Denim Jeans - Grey','PRD12461SG3J',1,'TRX290060');
/*!40000 ALTER TABLE `order_items` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `products`
--

DROP TABLE IF EXISTS `products`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `products` (
  `product_serial` varchar(255) NOT NULL,
  `mrp` double DEFAULT NULL,
  `product_brand` varchar(255) DEFAULT NULL,
  `product_category` varchar(255) DEFAULT NULL,
  `product_image` varchar(255) DEFAULT NULL,
  `product_name` varchar(255) DEFAULT NULL,
  `selling_price` double DEFAULT NULL,
  `sku_id` varchar(255) DEFAULT NULL,
  `tax_rate` double DEFAULT NULL,
  PRIMARY KEY (`product_serial`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `products`
--

LOCK TABLES `products` WRITE;
/*!40000 ALTER TABLE `products` DISABLE KEYS */;
INSERT INTO `products` VALUES ('PRD12461SG3A',4475,'Lush','Beauty','https://swissbeauty.in/cdn/shop/files/SB-S17_05_B_1400x.jpg?v=1695038919','Red Lipstick',4400,'10002',18),('PRD12461SG3B',5475,'Stride','Apparel','https://imagescdn.thecollective.in/img/app/product/7/789565-9236010.jpg','Black Sneakers',5400,'10003',12),('PRD12461SG3C',1254,'Bliss','Beauty','https://images-cdn.ubuy.co.in/657f4f5944ffe7474403da26-e-l-f-cosmetics-powder-blush-palette.jpg','Pink Blush Palette',1000,'10004',18),('PRD12461SG3D',6513,'Glow','Apparel','https://imagescdn.thecollective.in/img/app/product/4/444720-3655954.jpg','White Shirt',5495,'10005',12),('PRD12461SG3E',3463,'Nova Trends','Apparel','https://imagescdn.thecollective.in/img/app/product/9/944142-12101781.jpg','Slim Fit Jeans',3112,'10006',12),('PRD12461SG3F',3475,'Eclat','Beauty','https://cdn11.bigcommerce.com/s-ilgxsy4t82/images/stencil/1280x1280/products/222059/564012/A9878200_f3f53bf1-80af-4c7c-81d8-a143d2de590d__94129.1686633959.jpg?c=1&imbypass=on','Nude Lipstick',3156,'10007',18),('PRD12461SG3G',3475,'Elite Footwear','Apparel','https://hips.hearstapps.com/vader-prod.s3.amazonaws.com/1683139047-7-6452a9e262290.png?crop=1xw:1xh;center,top&resize=980:*','Classic White Sneakers',3189,'10008',12),('PRD12461SG3H',3475,'Opulent Blush','Beauty','https://images-cdn.ubuy.co.in/633ff10f461cf634b5260daf-cheek-palette-bronzer-highlighter.jpg','Peach Blush Palette',3132,'10009',18),('PRD12461SG3I',3475,'Mystique','Apparel','https://i.etsystatic.com/6454408/r/il/f5f81c/425491807/il_570xN.425491807_isep.jpg','Striped Shirt',3466,'10010',12),('PRD12461SG3J',3475,'Verve','Apparel','https://imagescdn.thecollective.in/img/app/product/8/870089-10346868.jpg','Denim Jeans - Grey',3400,'10001',12);
/*!40000 ALTER TABLE `products` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transactions`
--

DROP TABLE IF EXISTS `transactions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `transactions` (
  `transaction_id` varchar(255) NOT NULL,
  `created_at` datetime(6) DEFAULT NULL,
  `encrypted_mobile` varchar(255) DEFAULT NULL,
  `error_message` varchar(255) DEFAULT NULL,
  `payment_id` bigint DEFAULT NULL,
  `payment_method` varchar(255) DEFAULT NULL,
  `payment_status` varchar(255) DEFAULT NULL,
  `user_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`transaction_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transactions`
--

LOCK TABLES `transactions` WRITE;
/*!40000 ALTER TABLE `transactions` DISABLE KEYS */;
INSERT INTO `transactions` VALUES ('TRX290060','2024-02-08 20:40:59.350012','+91 111 - 111 - 1111','',12345678,'UPI','Successful','1');
/*!40000 ALTER TABLE `transactions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `user_id` bigint NOT NULL AUTO_INCREMENT,
  `user_encrypted_mobile` varchar(255) DEFAULT NULL,
  `user_feedback` double DEFAULT NULL,
  `user_lp_balance` int DEFAULT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  `user_role` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'jg5m/ZlpybxL5qYCVdxuOA==',2.940918017178774,7510,'Swastik',NULL);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-02-08 20:43:46
