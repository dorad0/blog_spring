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
-- Table `blog_mvc`.`users`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `blog_mvc`.`users` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `birth_date` DATE NOT NULL,
  `enabled` BIT(1) NOT NULL DEFAULT b'0',
  `name` VARCHAR(255) NOT NULL,
  `password` VARCHAR(255) NOT NULL,
  `registration_date` DATETIME NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `UK_gj2fy3dcix7ph7k8684gka40c` (`name` ASC))
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `blog_mvc`.`articles`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `blog_mvc`.`articles` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `publication_date` DATETIME NOT NULL,
  `text` LONGTEXT NOT NULL,
  `title` VARCHAR(255) NOT NULL,
  `user_id` BIGINT(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `UK_571gx7oqo5xpmgocegaidlcu9` (`title` ASC),
  INDEX `fk_articles_to_users` (`user_id` ASC),
  CONSTRAINT `fk_articles_to_users`
    FOREIGN KEY (`user_id`)
    REFERENCES `blog_mvc`.`users` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `blog_mvc`.`comments`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `blog_mvc`.`comments` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `publication_date` DATETIME NOT NULL,
  `text` VARCHAR(255) NOT NULL DEFAULT 'unknown',
  `article_id` BIGINT(20) NOT NULL,
  `user_id` BIGINT(20) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_comments_to_articles` (`article_id` ASC),
  INDEX `fk_comments_to_users` (`user_id` ASC),
  CONSTRAINT `fk_comments_to_articles`
    FOREIGN KEY (`article_id`)
    REFERENCES `blog_mvc`.`articles` (`id`),
  CONSTRAINT `fk_comments_to_users`
    FOREIGN KEY (`user_id`)
    REFERENCES `blog_mvc`.`users` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `blog_mvc`.`user_roles`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `blog_mvc`.`user_roles` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `role` VARCHAR(255) NOT NULL DEFAULT 'unknown',
  `user_id` BIGINT(20) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_user_roles_to_users` (`user_id` ASC),
  CONSTRAINT `fk_user_roles_to_users`
    FOREIGN KEY (`user_id`)
    REFERENCES `blog_mvc`.`users` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
