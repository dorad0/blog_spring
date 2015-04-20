-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema blog_mvc
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema blog_mvc
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `blog_mvc` DEFAULT CHARACTER SET utf8 ;
USE `blog_mvc` ;

-- -----------------------------------------------------
-- Table `blog_mvc`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `blog_mvc`.`user` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `birthdate` DATETIME NOT NULL,
  `enabled` BIT(1) NOT NULL,
  `name` VARCHAR(255) NOT NULL,
  `password` VARCHAR(255) NOT NULL,
  `registrationdate` DATETIME NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `UK_gj2fy3dcix7ph7k8684gka40c` (`name` ASC))
ENGINE = InnoDB
AUTO_INCREMENT = 6
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `blog_mvc`.`article`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `blog_mvc`.`article` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `publicationDate` DATETIME NOT NULL,
  `text` LONGTEXT NOT NULL,
  `title` VARCHAR(255) NOT NULL,
  `user_id` BIGINT(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `UK_571gx7oqo5xpmgocegaidlcu9` (`title` ASC),
  INDEX `FK_tcgc5bv7iarylc19wy17n3r6c` (`user_id` ASC),
  CONSTRAINT `FK_tcgc5bv7iarylc19wy17n3r6c`
    FOREIGN KEY (`user_id`)
    REFERENCES `blog_mvc`.`user` (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 26
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `blog_mvc`.`comment`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `blog_mvc`.`comment` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `publicationDate` DATETIME NOT NULL,
  `text` VARCHAR(255) NOT NULL,
  `article_id` BIGINT(20) NOT NULL,
  `user_id` BIGINT(20) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `FK_i4gfabcdddfcsr8rqvwh87hny` (`article_id` ASC),
  INDEX `FK_mxoojfj9tmy8088avf57mpm02` (`user_id` ASC),
  CONSTRAINT `FK_i4gfabcdddfcsr8rqvwh87hny`
    FOREIGN KEY (`article_id`)
    REFERENCES `blog_mvc`.`article` (`id`),
  CONSTRAINT `FK_mxoojfj9tmy8088avf57mpm02`
    FOREIGN KEY (`user_id`)
    REFERENCES `blog_mvc`.`user` (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 26
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `blog_mvc`.`user_role`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `blog_mvc`.`user_role` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `role` VARCHAR(255) NOT NULL,
  `user_id` BIGINT(20) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `FK_apcc8lxk2xnug8377fatvbn04` (`user_id` ASC),
  CONSTRAINT `FK_apcc8lxk2xnug8377fatvbn04`
    FOREIGN KEY (`user_id`)
    REFERENCES `blog_mvc`.`user` (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 6
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
