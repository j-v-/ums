CREATE DATABASE ums
  WITH OWNER = postgres
       ENCODING = 'UTF8';

CREATE SCHEMA management
  AUTHORIZATION postgres;

CREATE TABLE management.users(
 id serial PRIMARY KEY,
 title VARCHAR (10),
 firstName VARCHAR (50) NOT NULL,
 lastName VARCHAR (50) NOT NULL,
 dob TIMESTAMP NOT NULL,
 isActive BOOLEAN NOT NULL DEFAULT FALSE
);


INSERT INTO management.users(title, firstname, lastname, dob, isactive) VALUES ('Mr', 'James', 'Potter', current_timestamp, false);
INSERT INTO management.users(title, firstname, lastname, dob, isactive)  VALUES ("Mr", "Lily", "Potter", current_timestamp, false);
INSERT INTO management.users(title, firstname, lastname, dob, isactive)  VALUES ("Mr", "Harry", "Potter", current_timestamp, true);