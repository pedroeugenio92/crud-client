CREATE TABLE `client`.`city` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`)
	
CREATE TABLE `client`.`client` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NOT NULL ,
  `gender` VARCHAR(1) NOT NULL,
  `birth` DATETIME NOT NULL,
  `age` INT NOT NULL,
  `city_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `FK_CLIENT_CITY_idx` (`city_id` ASC),
  CONSTRAINT `FK_CLIENT_CITY`
    FOREIGN KEY (`city_id`)
    REFERENCES `client`.`city` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

