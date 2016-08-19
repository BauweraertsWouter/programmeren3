CREATE SEQUENCE hibernate_sequence;

CREATE TABLE question (
  que_id IDENTITY PRIMARY KEY,
  que_subject VARCHAR(100) NOT NULL,
  que_body VARCHAR(1000) NOT NULL,
  que_score INTEGER NOT NULL,
  que_timestamp TIMESTAMP NOT NULL
);
