/* 
* Alisa Steensen
* Module 5&6
*/

-- Create database CSD430 if it does not exist
CREATE DATABASE IF NOT EXISTS CSD430;
USE CSD430;

-- Create table alisa_states_data if does not exist
DROP TABLE IF EXISTS alisa_states_data;

CREATE TABLE alisa_states_data (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    state_name VARCHAR(50),
    capital VARCHAR(50),
    population_millions DOUBLE,
    state_bird VARCHAR(50),
    state_flower VARCHAR(50)
);

-- Insert into tables the states data
INSERT INTO alisa_states_data (state_name, capital, population_millions, state_bird, state_flower) VALUES
('Iowa', 'Des Moines', 3.2, 'Eastern Goldfinch', 'Wild Rose'),
('California', 'Sacramento', 39.2, 'California Quail', 'California Poppy'),
('Texas', 'Austin', 29.5, 'Northern Mockingbird', 'Bluebonnet'),
('Florida', 'Tallahassee', 21.8, 'Mockingbird', 'Orange Blossom'),
('New York', 'Albany', 19.8, 'Eastern Bluebird', 'Rose'),
('Nebraska', 'Lincoln', 1.9, 'Western Meadowlark', 'Goldenrod'),
('Colorado', 'Denver', 5.8, 'Lark Bunting', 'Rocky Mountain Columbine'),
('Hawaii', 'Honolulu', 1.4, 'Nene', 'Hibiscus'),
('Alaska', 'Juneau', 0.7, 'Willow Ptarmigan', 'Forget-Me-Not'),
('Georgia', 'Atlanta', 10.8, 'Brown Thrasher', 'Cherokee Rose');
