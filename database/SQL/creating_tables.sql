-- DROP SCHEMA app_scout;

CREATE SCHEMA `app_scout` 
DEFAULT CHARACTER SET latin1 COLLATE latin1_general_cs ;


USE app_scout;

CREATE TABLE user (
  name VARCHAR(124) NOT NULL,
  email VARCHAR(64) NOT NULL,
  registration_number INT NOT NULL,
  password VARCHAR(20) NOT NULL,
  UNIQUE (email, registration_number),
  PRIMARY KEY (registration_number))
ENGINE = InnoDB;

CREATE TABLE game (
  name VARCHAR(64) NOT NULL,
  id INT NOT NULL AUTO_INCREMENT,
  description VARCHAR(512) NOT NULL,
  duration_max INT NULL,
  duration_min INT NULL,
  material_list VARCHAR(128) NULL,
  quant_min INT NULL,
  quant_max INT NULL,
  user_registration_number INT NOT NULL,
  UNIQUE INDEX id_UNIQUE (id ASC) VISIBLE,
  PRIMARY KEY (id)
) ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1 COLLATE latin1_swedish_ci;

CREATE TABLE place (
  id INT NOT NULL UNIQUE AUTO_INCREMENT,
  name VARCHAR(45) NOT NULL,
  PRIMARY KEY (id)
) ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1 COLLATE latin1_swedish_ci;
	       
CREATE TABLE game_is_done_in (
  fk_place_id INT NOT NULL,
  fk_game_id INT NOT NULL,
  PRIMARY KEY(fk_place_id, fk_game_id))
ENGINE = InnoDB;

CREATE TABLE competences (
    number SMALLINT NOT NULL,
    title VARCHAR(128) NOT NULL,
    fk_ramo_id INT,
    PRIMARY KEY (number, fk_Ramo_id)
) ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1 COLLATE latin1_swedish_ci;

CREATE TABLE ramo (
    id INT PRIMARY KEY UNIQUE,
    name VARCHAR(64) NOT NULL
) ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1 COLLATE latin1_swedish_ci;

CREATE TABLE game_type (
    type_id INT PRIMARY KEY UNIQUE NOT NULL,
    description VARCHAR(64) NOT NULL
) ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1 COLLATE latin1_swedish_ci;

CREATE TABLE game_belongs_to_ramo (
    fk_ramo_id INT NOT NULL,
    fk_game_id INT NOT NULL,
    PRIMARY KEY (fk_ramo_id, fk_game_id)
) ENGINE = InnoDB;

CREATE TABLE game_have_competence (
    fk_game_id INT NOT NULL,
    fk_competences_number SMALLINT NOT NULL,
    PRIMARY KEY (fk_game_id, fk_competences_number)
) ENGINE = InnoDB;


CREATE TABLE game_is_type (
    fk_game_type_id INT NOT NULL,
    fk_game_id INT NOT NULL,
    PRIMARY KEY (fk_game_type_id, fk_game_id)
) ENGINE = InnoDB;

ALTER TABLE game ADD CONSTRAINT fk_Game_2
    FOREIGN KEY (user_registration_number)
    REFERENCES user (registration_number)
    ON DELETE CASCADE;
 
ALTER TABLE competences ADD CONSTRAINT FK_Competences_2
    FOREIGN KEY (fk_ramo_id)
    REFERENCES ramo (id)
    ON DELETE RESTRICT;
 
ALTER TABLE game_belongs_to_ramo ADD CONSTRAINT FK_game_belongs_to_ramo_1
    FOREIGN KEY (fk_Ramo_id)
    REFERENCES ramo (id)
    ON DELETE RESTRICT;
 
ALTER TABLE game_belongs_to_ramo ADD CONSTRAINT FK_game_belongs_to_ramo_2
    FOREIGN KEY (fk_game_id)
    REFERENCES game (id)
    ON DELETE CASCADE;
 
ALTER TABLE game_have_competence  ADD CONSTRAINT FK_have_1
    FOREIGN KEY (fk_game_id)
    REFERENCES game (id)
    ON DELETE CASCADE;
 
ALTER TABLE game_have_competence  ADD CONSTRAINT FK_have_2
    FOREIGN KEY (fk_competences_number)
    REFERENCES competences (number)
    ON DELETE CASCADE;
 
ALTER TABLE game_is_done_in ADD CONSTRAINT FK_game_is_done_in_1
    FOREIGN KEY (fk_place_id)
    REFERENCES place (id)
    ON DELETE CASCADE;
 
ALTER TABLE game_is_done_in ADD CONSTRAINT FK_game_is_done_in_2
    FOREIGN KEY (fk_game_id)
    REFERENCES game (id)
    ON DELETE CASCADE;
 
ALTER TABLE game_is_type ADD CONSTRAINT FK_is_1
    FOREIGN KEY (fk_game_type_id)
    REFERENCES game_Type (type_id)
    ON DELETE CASCADE;
 
ALTER TABLE game_is_type ADD CONSTRAINT FK_is_2
    FOREIGN KEY (fk_game_id)
    REFERENCES game (id)
    ON DELETE CASCADE;
