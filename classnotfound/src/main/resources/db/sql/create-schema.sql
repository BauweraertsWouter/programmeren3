CREATE SEQUENCE user_sequence;
CREATE SEQUENCE question_sequence;

CREATE TABLE user (
  use_id BIGINT PRIMARY KEY,
  use_name VARCHAR(20) NOT NULL,
  use_email VARCHAR(100) NOT NULL,
  use_password VARCHAR(100) NOT NULL
);

CREATE TABLE question (
  que_id BIGINT PRIMARY KEY,
  que_subject VARCHAR(100) NOT NULL,
  que_body VARCHAR(1000) NOT NULL,
  que_score INTEGER NOT NULL,
  que_timestamp TIMESTAMP NOT NULL
);
