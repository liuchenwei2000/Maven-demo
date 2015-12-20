CREATE TABLE `tb_book` (
  `pk_book` char(36) NOT NULL,
  `title` varchar(200) NOT NULL,
  `author` varchar(50) NOT NULL,
  `price` decimal(10,2),
  PRIMARY KEY (`pk_book`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;