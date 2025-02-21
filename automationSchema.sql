-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema Army
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema Army
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `Army` ;
USE `Army` ;

-- -----------------------------------------------------
-- Table `Army`.`soldiers`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Army`.`soldiers` (
  `id` INT(32) UNSIGNED NOT NULL,
  `first_name` VARCHAR(45) NOT NULL,
  `last_name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Army`.`training_programs`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Army`.`training_programs` (
  `id` INT(32) UNSIGNED NOT NULL,
  `program_name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Army`.`soldier_training`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Army`.`soldier_training` (
  `id` INT(32) UNSIGNED NOT NULL,
  `soldiers_id` INT(32) UNSIGNED NOT NULL,
  `training_programs_id` INT(32) UNSIGNED NOT NULL,
  `start_date` DATE NOT NULL,
  `end_date` DATE NULL,
  INDEX `fk_soldiers_has_training_programs_training_programs1_idx` (`training_programs_id` ASC) VISIBLE,
  INDEX `fk_soldiers_has_training_programs_soldiers_idx` (`soldiers_id` ASC) VISIBLE,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_soldiers_has_training_programs_soldiers`
    FOREIGN KEY (`soldiers_id`)
    REFERENCES `Army`.`soldiers` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_soldiers_has_training_programs_training_programs1`
    FOREIGN KEY (`training_programs_id`)
    REFERENCES `Army`.`training_programs` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Army`.`mediacal_records`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Army`.`mediacal_records` (
  `id` INT(32) UNSIGNED NOT NULL,
  `blood_type` VARCHAR(2) NOT NULL,
  `rh` BINARY NOT NULL,
  `soldiers_id` INT(32) UNSIGNED NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_mediaca;_records_soldiers1_idx` (`soldiers_id` ASC) VISIBLE,
  CONSTRAINT `fk_mediaca;_records_soldiers1`
    FOREIGN KEY (`soldiers_id`)
    REFERENCES `Army`.`soldiers` (`id`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Army`.`allergies`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Army`.`allergies` (
  `id` INT(32) UNSIGNED NOT NULL,
  `allergen` VARCHAR(45) NOT NULL,
  `mediacal_records_id` INT(32) UNSIGNED NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_allergies_mediacal_records1_idx` (`mediacal_records_id` ASC) VISIBLE,
  CONSTRAINT `fk_allergies_mediacal_records1`
    FOREIGN KEY (`mediacal_records_id`)
    REFERENCES `Army`.`mediacal_records` (`id`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Army`.`ranks`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Army`.`ranks` (
  `id` INT(32) UNSIGNED NOT NULL,
  `rank_name` VARCHAR(45) NOT NULL,
  `soldiers_id` INT(32) UNSIGNED NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_rank_soldiers1_idx` (`soldiers_id` ASC) VISIBLE,
  CONSTRAINT `fk_rank_soldiers1`
    FOREIGN KEY (`soldiers_id`)
    REFERENCES `Army`.`soldiers` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Army`.`units`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Army`.`units` (
  `id` INT(32) UNSIGNED NOT NULL,
  `unit_name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Army`.`divisions`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Army`.`divisions` (
  `id` INT(32) UNSIGNED NOT NULL,
  `division_name` VARCHAR(45) NOT NULL,
  `soldiers_id` INT(32) UNSIGNED NOT NULL,
  `units_id` INT(32) UNSIGNED NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_divisions_soldiers1_idx` (`soldiers_id` ASC) VISIBLE,
  INDEX `fk_divisions_units1_idx` (`units_id` ASC) VISIBLE,
  CONSTRAINT `fk_divisions_soldiers1`
    FOREIGN KEY (`soldiers_id`)
    REFERENCES `Army`.`soldiers` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_divisions_units1`
    FOREIGN KEY (`units_id`)
    REFERENCES `Army`.`units` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Army`.`departments`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Army`.`departments` (
  `id` INT(32) UNSIGNED NOT NULL,
  `department_name` VARCHAR(45) NOT NULL,
  `divisions_id` INT(32) UNSIGNED NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_department_divisions1_idx` (`divisions_id` ASC) VISIBLE,
  CONSTRAINT `fk_department_divisions1`
    FOREIGN KEY (`divisions_id`)
    REFERENCES `Army`.`divisions` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Army`.`missions`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Army`.`missions` (
  `id` INT(32) UNSIGNED NOT NULL,
  `mission_name` VARCHAR(45) NOT NULL,
  `mission_date` DATE NOT NULL,
  `location` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Army`.`equipment`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Army`.`equipment` (
  `id` INT(32) UNSIGNED NOT NULL,
  `equipment_name` VARCHAR(45) NOT NULL,
  `equipment_type` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Army`.`unit_missions`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Army`.`unit_missions` (
  `id` VARCHAR(45) NOT NULL,
  `missions_id` INT(32) UNSIGNED NOT NULL,
  `units_id` INT(32) UNSIGNED NOT NULL,
  INDEX `fk_missions_has_units_units1_idx` (`units_id` ASC) VISIBLE,
  INDEX `fk_missions_has_units_missions1_idx` (`missions_id` ASC) VISIBLE,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_missions_has_units_missions1`
    FOREIGN KEY (`missions_id`)
    REFERENCES `Army`.`missions` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_missions_has_units_units1`
    FOREIGN KEY (`units_id`)
    REFERENCES `Army`.`units` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Army`.`soldier_equipment`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Army`.`soldier_equipment` (
  `id` INT(32) UNSIGNED NOT NULL,
  `equipment_id` INT(32) UNSIGNED NOT NULL,
  `soldiers_id` INT(32) UNSIGNED NOT NULL,
  `issue_date` DATE NOT NULL,
  `return_date` DATE NULL,
  INDEX `fk_equipment_has_soldiers_soldiers1_idx` (`soldiers_id` ASC) VISIBLE,
  INDEX `fk_equipment_has_soldiers_equipment1_idx` (`equipment_id` ASC) VISIBLE,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_equipment_has_soldiers_equipment1`
    FOREIGN KEY (`equipment_id`)
    REFERENCES `Army`.`equipment` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_equipment_has_soldiers_soldiers1`
    FOREIGN KEY (`soldiers_id`)
    REFERENCES `Army`.`soldiers` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
