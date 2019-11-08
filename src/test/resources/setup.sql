
DROP TABLE IF EXISTS characters;
CREATE TABLE IF NOT EXISTS characters (
    id bigint(20) NOT NULL,
    age bigint(20) DEFAULT NULL,
    jobs varchar(100) NOT NULL,
    username varchar(100) NOT NULL,
    PRIMARY KEY (id)
);