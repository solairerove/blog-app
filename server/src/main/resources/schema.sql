CREATE TABLE IF NOT EXISTS `post` (
  `id`       INTEGER IDENTITY PRIMARY KEY,
  `title`    VARCHAR(255),
  `subtitle` VARCHAR(255),
  `content`  TEXT,
  `date`     VARCHAR(255),
  `author`   VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS `comment` (
  `id`      INTEGER IDENTITY PRIMARY KEY,
  `author`  VARCHAR(255),
  `review`  VARCHAR(255),
  `date`    VARCHAR(255),
  `post_id` INTEGER
);
