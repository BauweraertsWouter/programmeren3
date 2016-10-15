CREATE TABLE team (
  id IDENTITY PRIMARY KEY,
  name VARCHAR(50) NOT NULL,
  uci_code CHAR(3) NOT NULL,
  year_founded SMALLINT NOT NULL
);

CREATE TABLE rider (
  id IDENTITY PRIMARY KEY,
  name VARCHAR(50) NOT NULL,
  date_of_birth DATE NOT NULL,
  team_id BIGINT NOT NULL
    CONSTRAINT fk_rider_team_id REFERENCES team(id)
);

/*
 * Currently this is Tour de France.
 * An extra 'type' field could be added to support all three grand tours.
 */
CREATE TABLE tour (
  id IDENTITY PRIMARY KEY,
  year SMALLINT NOT NULL
);

/*
 * To be added: name, date, type (individual time trial, flat stage, ...)
 */
CREATE TABLE stage (
  id IDENTITY PRIMARY KEY,
  seq TINYINT NOT NULL,
  tour_id BIGINT NOT NULL
    CONSTRAINT fk_stage_tour_id REFERENCES tour(id)
);

CREATE TABLE stage_result (
  id IDENTITY PRIMARY KEY,
  finish_place SMALLINT, /* NULL is DNF */
  stage_id BIGINT NOT NULL
    CONSTRAINT fk_stage_result_stage_id REFERENCES stage(id),
  rider_id BIGINT NOT NULL
    CONSTRAINT fk_stage_result_rider_id REFERENCES rider(id)
);
