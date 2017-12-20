DROP TABLE IF EXISTS article CASCADE;
DROP TABLE IF EXISTS image CASCADE;

CREATE TABLE IF NOT EXISTS article (
	article_id SERIAL NOT NULL,
	post_date_time TIMESTAMP NOT NULL,
	article_title VARCHAR(1024), 
	shooting_date DATE,
	PRIMARY KEY (article_id)
);

CREATE TABLE IF NOT EXISTS image (
	image_id SERIAL NOT NULL,
	image_file_name VARCHAR(256),
	article_id INT4 NOT NULL,
	PRIMARY KEY (image_id)
);

ALTER TABLE image DROP CONSTRAINT IF EXISTS FK_articleid;

ALTER TABLE image ADD CONSTRAINT FK_articleid FOREIGN KEY (article_id) REFERENCES article;