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
