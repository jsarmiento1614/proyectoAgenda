--DROP TABLE IF EXISTS `eventos`;

CREATE TABLE IF NOT EXISTS `eventos` (
  
	`IdEvent` int(25) NOT NULL,
  
	`IdUser` int(25) NOT NULL,
  
	`fecha` date NOT NULL,
  
	`Titulo` varchar(50) NOT NULL,
  
	`Detalles` varchar(50) NOT NULL,
  
	`Ubicación` varchar(50) NOT NULL,
  
	`Inicio` time NOT NULL,
  
	`Fin` time NOT NULL,
  
	PRIMARY KEY (`IdEvent`),
  
	KEY `IdUser` (`IdUser`)

) ENGINE=InnoDB;





--DROP TABLE IF EXISTS `usuarios`;

CREATE TABLE IF NOT EXISTS `usuarios` (
  
	`IdUser` int(25) NOT NULL,
  
	`nombre` varchar(50) NOT NULL,
  
	`email` varchar(50) NOT NULL,
  
	PRIMARY KEY (`IdUser`)

) ENGINE=InnoDB;


