CREATE TABLE IF NOT EXISTS `post` (
  `id`       BIGINT IDENTITY PRIMARY KEY,
  `title`    VARCHAR(255),
  `subtitle` VARCHAR(255),
  `content`  TEXT,
  `date`     VARCHAR(255),
  `author`   VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS `comment` (
  `id`      BIGINT IDENTITY PRIMARY KEY,
  `author`  VARCHAR(255),
  `review`  VARCHAR(255),
  `date`    VARCHAR(255),
  `post_id` BIGINT
);

CREATE TABLE IF NOT EXISTS `user` (
  `id`       BIGINT IDENTITY PRIMARY KEY,
  `nickname` VARCHAR(255) UNIQUE,
  `email`    VARCHAR(255) UNIQUE,
  `login`    VARCHAR(255) UNIQUE,
  `password` VARCHAR(255),
);

CREATE TABLE IF NOT EXISTS `authority` (
  `id`   BIGINT IDENTITY PRIMARY KEY,
  `name` VARCHAR(255),
);

CREATE TABLE IF NOT EXISTS `user_authority` (
  `id`      BIGINT IDENTITY PRIMARY KEY,
  `user_id` BIGINT,
  `role_id` BIGINT
);
