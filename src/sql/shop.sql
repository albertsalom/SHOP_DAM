DROP DATABASE IF EXISTS shop;

CREATE DATABASE shop;

USE shop;

CREATE TABLE employee (
    employeeId INT PRIMARY KEY,
    name VARCHAR(100) UNIQUE,
    password VARCHAR(255)
);

INSERT INTO employee (employeeId, name, password)
VALUES (111, "Albert", "test1"), (222, "Juan", "test2"), 
(333, "Antonio", "test3"), (444, "Rafa", "test4");