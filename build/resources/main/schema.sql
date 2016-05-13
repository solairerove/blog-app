CREATE TABLE IF NOT EXISTS `post` (
  `id`       INTEGER IDENTITY PRIMARY KEY,
  `title`    VARCHAR(255),
  `subtitle` VARCHAR(255),
  `content`  TEXT,
  `date`     VARCHAR(255),
  `author`   VARCHAR(255)
);