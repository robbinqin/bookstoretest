CREATE DATABASE IF NOT EXISTS bookstore;
USE category;
CREATE TABLE IF NOT EXISTS categories(
	id varchar(100) PRIMARY KEY,
	name varchar(100) NOT NULL UNIQUE,
	description varchar(255)	
);
