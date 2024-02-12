-- Drop tables if they exist
DROP TABLE IF EXISTS authorities;
DROP TABLE IF EXISTS users;

--
-- Table structure for table users
--

CREATE TABLE users (
  username VARCHAR(50) NOT NULL PRIMARY KEY,
  password VARCHAR(50) NOT NULL,
  enabled BOOLEAN NOT NULL
);

--
-- Inserting data for table users
--

INSERT INTO users(username, password, enabled) VALUES('shinonome','{noop}test123',true);
INSERT INTO users(username, password, enabled) VALUES ('ayaka','{noop}test123',true);
INSERT INTO users(username, password, enabled) VALUES ('furina','{noop}test123',true);

--
-- Table structure for table authorities
--

CREATE TABLE authorities (
  username VARCHAR(50) NOT NULL,
  authority VARCHAR(50) NOT NULL,
  CONSTRAINT authorities_pk PRIMARY KEY (username, authority),
  CONSTRAINT fk_authorities_users FOREIGN KEY (username) REFERENCES users (username)
);

--
-- Inserting data for table authorities
--

INSERT INTO authorities VALUES ('shinonome','ROLE_USER');
INSERT INTO authorities VALUES ('ayaka','ROLE_USER');
INSERT INTO authorities VALUES ('ayaka','ROLE_MANAGER');
INSERT INTO authorities VALUES ('furina','ROLE_USER');
INSERT INTO authorities VALUES ('furina','ROLE_MANAGER');
INSERT INTO authorities VALUES ('furina','ROLE_ADMIN');
