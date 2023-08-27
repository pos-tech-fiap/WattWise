---- Create the wattwise database
--CREATE DATABASE wattwise;

-- Connect to the wattwise database
\c wattwise;

-- Create the tb_electronic table
CREATE TABLE IF NOT EXISTS tb_electronics (
    id UUID PRIMARY KEY,
    name VARCHAR(255),
    model VARCHAR(100),
    power VARCHAR(50)
);

-- Create the tb_address table
CREATE TABLE IF NOT EXISTS tb_address (
    id SERIAL PRIMARY KEY,
    street VARCHAR(100),
    city VARCHAR(50),
    country VARCHAR(50)
);

-- Create the tb_person table
CREATE TABLE IF NOT EXISTS tb_person (
    id SERIAL PRIMARY KEY,
    first_name VARCHAR(50),
    last_name VARCHAR(50),
    age INT
);