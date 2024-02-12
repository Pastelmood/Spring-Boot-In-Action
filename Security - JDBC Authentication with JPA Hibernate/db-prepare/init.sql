-- Drop tables if they exist
DROP TABLE IF EXISTS "user" CASCADE;
DROP TABLE IF EXISTS role CASCADE;

-- Create the "user" table
CREATE TABLE "user" (
  id SERIAL PRIMARY KEY,
  username VARCHAR(50) NOT NULL,
  password VARCHAR(80) NOT NULL,
  enabled BOOLEAN NOT NULL
);

-- Create the "role" table
CREATE TABLE role (
  id SERIAL PRIMARY KEY,
  name VARCHAR(50)
);

-- Create the "users_roles" table
CREATE TABLE users_roles (
  user_id INT NOT NULL,
  role_id INT NOT NULL,
  PRIMARY KEY (user_id, role_id),
  CONSTRAINT fk_user FOREIGN KEY (user_id) REFERENCES "user" (id) ON DELETE CASCADE,
  CONSTRAINT fk_role FOREIGN KEY (role_id) REFERENCES role (id) ON DELETE CASCADE
);

-- Insert data into the "user" table. password is test123
INSERT INTO "user" (username, password, enabled)
VALUES
('lumine', '$2a$10$0dEvcgExevq.9klKLQd/1uKHlxLDXRfvMmEHQBsUtOl4nm68w6P4C', TRUE),
('paimon', '$2a$10$MEXa9avhbtRNH5/EAxP81.Gvy.BiowRdW7YDEWvQqQrRBZchvIkMW', TRUE),
('furina', '$2a$10$dJJs8db8dPs3dDoNY30sduLuIcsdS4u6I3N5spWeDNnFhnrKZvudS', TRUE);

-- Insert data into the "role" table
INSERT INTO role (name)
VALUES
('ROLE_USER'),('ROLE_MANAGER'),('ROLE_ADMIN');

-- Insert data into the "users_roles" table
INSERT INTO users_roles (user_id, role_id)
VALUES
(1, 1),
(2, 1),
(2, 2),
(3, 1),
(3, 2),
(3, 3);
