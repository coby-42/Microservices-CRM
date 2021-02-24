CREATE DATABASE `user_service` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE user_service;

CREATE TABLE `role` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `user_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK61g3ambult7v7nh59xirgd9nf` (`user_id`),
  CONSTRAINT `FK61g3ambult7v7nh59xirgd9nf` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `user` (
  `dtype` varchar(31) NOT NULL,
  `id` bigint NOT NULL AUTO_INCREMENT,
  `password` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `user_service`.`user`
(`dtype`, `password`, `username`, `first_name`, `last_name`)
VALUES
('Admin', '$2a$10$RBpj2rjM.9UlUYsMYyGv7emc9vAf04piwt7EuLX4mpawhsAGOCmey', 'admin', '', ''),
('SalesRep', '$2a$10$RBpj2rjM.9UlUYsMYyGv7emc9vAf04piwt7EuLX4mpawhsAGOCmey', 'user1', 'User1 FirstName', 'User1 LastName'),
('SalesRep', '$2a$10$RBpj2rjM.9UlUYsMYyGv7emc9vAf04piwt7EuLX4mpawhsAGOCmey', 'user2', 'User2 FirstName', 'User2 LastName'),
('SalesRep', '$2a$10$RBpj2rjM.9UlUYsMYyGv7emc9vAf04piwt7EuLX4mpawhsAGOCmey', 'user3', 'User3 FirstName', 'User3 LastName');

INSERT INTO `user_service`.`role`(`name`, `user_id`)
VALUES
('ADMIN', '1'),
('SALES_REP', '2'),
('SALES_REP', '3'),
('SALES_REP', '4');




