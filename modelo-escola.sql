-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema escola
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema escola
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `escola` DEFAULT CHARACTER SET utf8 ;
USE `escola` ;

-- -----------------------------------------------------
-- Table `escola`.`aluno`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `escola`.`aluno` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(40) NULL,
  `numero_matricula` VARCHAR(7) NULL,
  `cpf` VARCHAR(45) NULL,
  `endereco` VARCHAR(45) NULL,
  `nascimento` DATE NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `numero_matricula_UNIQUE` (`numero_matricula` ASC) VISIBLE,
  UNIQUE INDEX `cpf_UNIQUE` (`cpf` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `escola`.`contato`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `escola`.`contato` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `descricao` VARCHAR(45) NULL,
  `tipo` VARCHAR(45) NULL,
  `aluno_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_contato_aluno_idx` (`aluno_id` ASC) VISIBLE,
  CONSTRAINT `fk_contato_aluno`
    FOREIGN KEY (`aluno_id`)
    REFERENCES `escola`.`aluno` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `escola`.`responsavel`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `escola`.`responsavel` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NULL,
  `endereco` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `escola`.`aluno_responsavel`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `escola`.`aluno_responsavel` (
  `aluno_id` INT NOT NULL,
  `responsavel_id` INT NOT NULL,
  PRIMARY KEY (`aluno_id`, `responsavel_id`),
  INDEX `fk_aluno_has_responsavel_responsavel1_idx` (`responsavel_id` ASC) VISIBLE,
  INDEX `fk_aluno_has_responsavel_aluno1_idx` (`aluno_id` ASC) VISIBLE,
  CONSTRAINT `fk_aluno_has_responsavel_aluno1`
    FOREIGN KEY (`aluno_id`)
    REFERENCES `escola`.`aluno` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_aluno_has_responsavel_responsavel1`
    FOREIGN KEY (`responsavel_id`)
    REFERENCES `escola`.`responsavel` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `escola`.`curso`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `escola`.`curso` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NULL,
  `coordenador` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `escola`.`disciplina`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `escola`.`disciplina` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NULL,
  `codigo` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `escola`.`curso_disciplina`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `escola`.`curso_disciplina` (
  `curso_id` INT NOT NULL,
  `disciplina_id` INT NOT NULL,
  PRIMARY KEY (`curso_id`, `disciplina_id`),
  INDEX `fk_curso_has_disciplina_disciplina1_idx` (`disciplina_id` ASC) VISIBLE,
  INDEX `fk_curso_has_disciplina_curso1_idx` (`curso_id` ASC) VISIBLE,
  CONSTRAINT `fk_curso_has_disciplina_curso1`
    FOREIGN KEY (`curso_id`)
    REFERENCES `escola`.`curso` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_curso_has_disciplina_disciplina1`
    FOREIGN KEY (`disciplina_id`)
    REFERENCES `escola`.`disciplina` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `escola`.`professor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `escola`.`professor` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `escola`.`turma`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `escola`.`turma` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `semestre` VARCHAR(45) NULL,
  `professor_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_turma_professor1_idx` (`professor_id` ASC) VISIBLE,
  CONSTRAINT `fk_turma_professor1`
    FOREIGN KEY (`professor_id`)
    REFERENCES `escola`.`professor` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `escola`.`aluno_turma`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `escola`.`aluno_turma` (
  `aluno_id` INT NOT NULL,
  `turma_id` INT NOT NULL,
  PRIMARY KEY (`aluno_id`, `turma_id`),
  INDEX `fk_aluno_has_turma_turma1_idx` (`turma_id` ASC) VISIBLE,
  INDEX `fk_aluno_has_turma_aluno1_idx` (`aluno_id` ASC) VISIBLE,
  CONSTRAINT `fk_aluno_has_turma_aluno1`
    FOREIGN KEY (`aluno_id`)
    REFERENCES `escola`.`aluno` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_aluno_has_turma_turma1`
    FOREIGN KEY (`turma_id`)
    REFERENCES `escola`.`turma` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `escola`.`disciplina_turma`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `escola`.`disciplina_turma` (
  `disciplina_id` INT NOT NULL,
  `turma_id` INT NOT NULL,
  PRIMARY KEY (`disciplina_id`, `turma_id`),
  INDEX `fk_disciplina_has_turma_turma1_idx` (`turma_id` ASC) VISIBLE,
  INDEX `fk_disciplina_has_turma_disciplina1_idx` (`disciplina_id` ASC) VISIBLE,
  CONSTRAINT `fk_disciplina_has_turma_disciplina1`
    FOREIGN KEY (`disciplina_id`)
    REFERENCES `escola`.`disciplina` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_disciplina_has_turma_turma1`
    FOREIGN KEY (`turma_id`)
    REFERENCES `escola`.`turma` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
