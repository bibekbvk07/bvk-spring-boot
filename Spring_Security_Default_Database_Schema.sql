use student_directory;

-- DROP TABLE IF EXISTS --
DROP TABLE IF EXISTS `users`;
DROP TABLE IF EXISTS `authorities`;

-- Scripts to create a users table --
create table `users`(
`username` varchar(50) NOT NULL,
`password` varchar(50) NOT NULL,
`enabled` tinyint(1) NOT NULL,
PRIMARY KEY (`username`)
) Engine = InnoDB DEFAULT charset = latin1;

-- Scripts to insert data into users table --
INSERT INTO `users` values ('bibek', '{noop}bibek123', 1);
INSERT INTO `users` values ('karuna', '{noop}karuna123', 1);
INSERT INTO `users` values ('bipin', '{noop}bipin123', 1);

-- Scripts to create a authorities table --
create table `authorities`(
`username` varchar(50) NOT NULL,
`authority` varchar(50) NOT NULL,
UNIQUE KEY `authorities_idx_1` (`username`, `authority`),
CONSTRAINT `authorities_idfk_1` FOREIGN KEY(`username`) REFERENCES `users` (`username`)
) Engine = InnoDB DEFAULT charset = latin1;

-- Scripts to insert data into authorities table --
INSERT INTO `authorities` VALUES ('bibek', 'ROLE_EMPLOYEE');
INSERT INTO `authorities` VALUES ('karuna', 'ROLE_EMPLOYEE');
INSERT INTO `authorities` VALUES ('karuna', 'ROLE_MANAGER');
INSERT INTO `authorities` VALUES ('bipin', 'ROLE_EMPLOYEE');
INSERT INTO `authorities` VALUES ('bipin', 'ROLE_MANAGER');
INSERT INTO `authorities` VALUES ('bipin', 'ROLE_ADMIN');

DROP TABLE IF EXISTS `members`;

-- create a table members -- 
create table `members`(
`user_id` varchar(50) not null,
`pwd` varchar(68) not null,
`active` tinyint not null,
PRIMARY KEY (`user_id`)
) Engine = InnoDB DEFAULT CHARSET= latin1;

-- create a table members -- 
create table `roles`(
`user_id` varchar(50) not null,
`role` varchar(50) not null,
UNIQUE KEY `authorities1_idx_1` (`user_id`,`role`),
CONSTRAINT `authorities1_idfk_1` FOREIGN KEY (`user_id`) REFERENCES `members` (`user_id`)
) Engine = InnoDB DEFAULT CHARSET= latin1;

-- Scripts to insert default --
INSERT INTO `members` VALUES ('bibek', '{bcrypt}$2a$10$m7YukoGbQTc2EJTXlyutAexITH6Z2EOLP4DROXEqf811mhwW4zHxm', 1);
INSERT INTO `members` VALUES ('karuna', '{bcrypt}$2a$10$Bm8dZ14GJy8eCcvzGtBqxOYi.7PInyI03htXmlKlDus8mK6gOQfOC', 1);
INSERT INTO `members` VALUES ('bipin', '{bcrypt}$2a$10$3lLO9s4CoQDizmNvqkS7luXW8bosi9XUfRoseFSI7Tk15liyrIV7e', 1);
INSERT INTO `members` VALUES ('susan', '{bcrypt}$2a$10$8DggVzOBCSiziVZm82t0vOL5sWyZA7MCZXFQGWZYfY2ottNau42em',0);

-- Scripts to insert data into authorities table --
INSERT INTO `roles` VALUES ('bibek', 'ROLE_EMPLOYEE');
INSERT INTO `roles` VALUES ('karuna', 'ROLE_EMPLOYEE');
INSERT INTO `roles` VALUES ('karuna', 'ROLE_MANAGER');
INSERT INTO `roles` VALUES ('bipin', 'ROLE_EMPLOYEE');
INSERT INTO `roles` VALUES ('bipin', 'ROLE_MANAGER');
INSERT INTO `roles` VALUES ('bipin', 'ROLE_ADMIN');
INSERT INTO `roles` VALUES ('susan', 'ROLE_ADMIN');




