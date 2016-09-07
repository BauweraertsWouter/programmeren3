CREATE OR REPLACE TABLE user (
  use_id IDENTITY PRIMARY KEY,
  use_name VARCHAR(20) NOT NULL,
  use_email VARCHAR(100) NOT NULL,
  use_password VARCHAR(100) NOT NULL
);

CREATE OR REPLACE TABLE question_answer (
  qa_id IDENTITY PRIMARY KEY,
  qa_subject VARCHAR(100) NOT NULL,
  qa_body VARCHAR(1000) NOT NULL,
  qa_score INTEGER NOT NULL,
  qa_timestamp TIMESTAMP NOT NULL,
  qa_use_id BIGINT NOT NULL
    CONSTRAINT fk_qa_use_id REFERENCES user(use_id)
  /* TODO: add optional foreign key to parent question */
);

CREATE OR REPLACE TABLE vote (
  vot_id IDENTITY PRIMARY KEY,
  vot_use_id BIGINT NOT NULL
    CONSTRAINT fk_vot_use_id REFERENCES user(use_id),
  vot_qa_id BIGINT NOT NULL
    CONSTRAINT fk_vot_qa_id REFERENCES question_answer(qa_id),
  vot_is_up BOOLEAN NOT NULL
);
