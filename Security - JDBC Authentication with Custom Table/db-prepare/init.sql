-- Drop tables if they exist
DROP TABLE IF EXISTS authorities;
DROP TABLE IF EXISTS users;

--
-- Table structure for table users
--

CREATE TABLE accounts (
  account_name VARCHAR(50) NOT NULL PRIMARY KEY,
  pwd VARCHAR(50) NOT NULL,
  is_active BOOLEAN NOT NULL
);

--
-- Inserting data for table users
--

INSERT INTO accounts(account_name, pwd, is_active) VALUES('lumine','{noop}test123',true);
INSERT INTO accounts(account_name, pwd, is_active) VALUES ('ayaka','{noop}test123',true);
INSERT INTO accounts(account_name, pwd, is_active) VALUES ('furina','{noop}test123',true);

--
-- Table structure for table authorities
--

CREATE TABLE permissions (
  account_name VARCHAR(50) NOT NULL,
  role VARCHAR(50) NOT NULL,
  CONSTRAINT permissions_pk PRIMARY KEY (account_name, role),
  CONSTRAINT fk_permissions_accounts FOREIGN KEY (account_name) REFERENCES accounts (account_name)
);

--
-- Inserting data for table authorities
--

INSERT INTO permissions VALUES ('lumine','ROLE_USER');
INSERT INTO permissions VALUES ('ayaka','ROLE_USER');
INSERT INTO permissions VALUES ('ayaka','ROLE_MANAGER');
INSERT INTO permissions VALUES ('furina','ROLE_USER');
INSERT INTO permissions VALUES ('furina','ROLE_MANAGER');
INSERT INTO permissions VALUES ('furina','ROLE_ADMIN');
