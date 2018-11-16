DROP TABLE IF EXISTS roles;
DROP TABLE IF EXISTS votes;
DROP TABLE IF EXISTS meals;
DROP TABLE IF EXISTS restaurants;
DROP TABLE IF EXISTS users;
DROP SEQUENCE IF EXISTS global_seq;

CREATE SEQUENCE global_seq START 100000;

CREATE TABLE users
(
  id               INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  name             VARCHAR                 NOT NULL,
  email            VARCHAR                 NOT NULL,
  phone            BIGINT                  NOT NULL,
  password         VARCHAR                 NOT NULL,
  registered       TIMESTAMP DEFAULT now() NOT NULL,
  enabled          BOOL DEFAULT TRUE       NOT NULL
);
CREATE UNIQUE INDEX users_unique_email_idx ON users (email);

CREATE TABLE roles
(
  user_id INTEGER NOT NULL,
  role    VARCHAR,
  CONSTRAINT user_roles_idx UNIQUE (user_id, role),
  FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE
);

CREATE TABLE restaurants
(
  id               INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  name             VARCHAR                 NOT NULL,
  email            VARCHAR                 NOT NULL,
  phone            BIGINT                  NOT NULL,
  registered       TIMESTAMP DEFAULT now() NOT NULL,
  enabled          BOOL DEFAULT TRUE       NOT NULL
);
CREATE UNIQUE INDEX restaurants_unique_email_idx ON restaurants (email);

CREATE TABLE votes
(
  id               INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  registered        TIMESTAMP DEFAULT now() NOT NULL,
  user_id          INTEGER NOT NULL,
  restaurant_id    INTEGER NOT NULL,
  CONSTRAINT date_user_restaurant_vote_idx UNIQUE (registered, user_id),
  FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE,
  FOREIGN KEY (restaurant_id) REFERENCES restaurants (id) ON DELETE CASCADE
);

CREATE TABLE meals
(
  id                 INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  restaurant_id      INTEGER   NOT NULL,
  registered         DATE DEFAULT CURRENT_DATE NOT NULL,
  description        VARCHAR   NOT NULL,
  price              DOUBLE PRECISION   NOT NULL,
  FOREIGN KEY (restaurant_id) REFERENCES restaurants (id) ON DELETE CASCADE
);