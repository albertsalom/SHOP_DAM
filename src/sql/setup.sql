DROP DATABASE IF EXISTS shop;

CREATE DATABASE shop;

USE shop;

CREATE TABLE employee (
    employeeId INT PRIMARY KEY,
    name VARCHAR(100) UNIQUE,
    password VARCHAR(255)
);

INSERT INTO employee (employeeId, name, password)
VALUES (123, "Albert", "albert1"), (456, "Juan", "juan1"), 
(789, "Pablo", "pablo1"), (111, "Maria", "maria1");