DROP DATABASE IF EXISTS scrumPlannerDb;
CREATE DATABASE IF NOT EXISTS scrumPlannerDb;
USE scrumPlannerDb;

CREATE TABLE IF NOT EXISTS company (
  id            INT          NOT NULL AUTO_INCREMENT,
  name          VARCHAR(255) NOT NULL,
  creation_date TIMESTAMP    NOT NULL,
  PRIMARY KEY (id)
)
  ENGINE = InnoDb;

CREATE TABLE IF NOT EXISTS user (
  id        INT          NOT NULL AUTO_INCREMENT,
  name      VARCHAR(255) NOT NULL,
  age       INT          NOT NULL,
  CNP       VARCHAR(255) NOT NULL,
  email     VARCHAR(255) NOT NULL,
  password  VARCHAR(255) NOT NULL,
  user_type VARCHAR(255) NOT NULL,
  user_id   VARCHAR(255) NOT NULL,
  PRIMARY KEY (id)
)
  ENGINE = InnoDb;

CREATE TABLE IF NOT EXISTS project (
  id          INT          NOT NULL AUTO_INCREMENT,
  name        VARCHAR(255) NOT NULL,
  permissions VARCHAR(255) NOT NULL,
  user_id     INT          NOT NULL,
  PRIMARY KEY (id)
)
  ENGINE = InnoDb;

CREATE TABLE IF NOT EXISTS taskboard (
  id       INT NOT NULL AUTO_INCREMENT,
  panel_id INT NOT NULL,
  PRIMARY KEY (id)
)
  ENGINE = InnoDb;

CREATE TABLE IF NOT EXISTS panel (
  id           INT          NOT NULL AUTO_INCREMENT,
  panel_type   VARCHAR(255) NOT NULL,
  taskboard_id INT          NOT NULL,
  PRIMARY KEY (id)
)
  ENGINE = InnoDb;

CREATE TABLE IF NOT EXISTS card (
  id           INT          NOT NULL AUTO_INCREMENT,
  title        VARCHAR(255) NOT NULL,
  description  VARCHAR(255) NOT NULL,
  story_points INT          NOT NULL,
  state        VARCHAR(255) NOT NULL,
  estimation   TIMESTAMP    NOT NULL,
  card_type    VARCHAR(255) NOT NULL,
  panel_id     INT          NOT NULL,
  PRIMARY KEY (id)
)
  ENGINE = InnoDb;

CREATE TABLE IF NOT EXISTS tag (
  id          INT          NOT NULL AUTO_INCREMENT,
  description VARCHAR(255) NOT NULL,
  card_id     INT          NOT NULL,
  PRIMARY KEY (id)
)
  ENGINE = InnoDb;