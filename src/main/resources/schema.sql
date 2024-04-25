CREATE TABLE IF NOT EXISTS post_it (
    id INTEGER AUTO_INCREMENT,
    title varchar(255) NOT NULL,
    description TEXT,
    status VARCHAR(20) NOT NULL,
    difficulty VARCHAR(20) NOT NULL,
    time_needed INTEGER NOT NULL,
    date_created TIMESTAMP NOT NULL,
    date_updated TIMESTAMP,
    PRIMARY KEY (id)
);

INSERT INTO post_it(title,description,status,difficulty,time_needed,date_created)
VALUES('Afwas', 'Afwas doen', 'DONE', 'EASY', 15, CURRENT_TIMESTAMP);