CREATE SCHEMA `app_scout`
DEFAULT CHARACTER SET = utf8;

USE `app_scout`;


CREATE TABLE `user` (
  `name` VARCHAR(124) NOT NULL,
  `email` VARCHAR(64) NOT NULL,
  `registration_number` VARCHAR(15) NOT NULL,
  `password` VARCHAR(20) NOT NULL,
  UNIQUE INDEX `email_UNIQUE` (`email` ASC) VISIBLE,
  UNIQUE INDEX `registration_number_UNIQUE` (`registration_number` ASC) VISIBLE,
  PRIMARY KEY (`registration_number`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE `game` (
  `name` VARCHAR(64) NOT NULL,
  `id` INT NOT NULL,
  `description` VARCHAR(512) NOT NULL,
  `duration_max` INT NULL,
  `duration_min` INT NULL,
  `material_list` VARCHAR(128) NULL,
  `quant_min` INT NULL,
  `quant_max` INT NULL,
  `user_registration_number` VARCHAR(15) NOT NULL,
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

ALTER TABLE `game`
ADD CONSTRAINT fk_user_registration_number 
	FOREIGN KEY (user_registration_number)
    REFERENCES user(registration_number);