
-- Create a new schema: pets
--Create two related tables: Customer + Pets
--Demonstrate populating records into these tables
-- =========================================
-- Pets Database Project
-- =======================================
-- 1. Create a new schema
CREATE SCHEMA pets;


-- 2. Create Customer table
CREATE TABLE pets.customer (
    customer_id SERIAL PRIMARY KEY,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL
);


-- 3. Create Pets table
CREATE TABLE pets.pets (
    pet_id SERIAL PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    species VARCHAR(50),
    customer_id INT NOT NULL,

    FOREIGN KEY (customer_id)
        REFERENCES pets.customer(customer_id)
);


-- 4. Populate Customer records
INSERT INTO pets.customer (first_name, last_name)
VALUES
    ('John', 'Smith'),
    ('Sarah', 'Johnson'),
    ('Michael', 'Brown');


-- 5. Populate Pets records
INSERT INTO pets.pets (name, species, customer_id)
VALUES
    ('Buddy', 'Dog', 1),
    ('Milo', 'Cat', 1),
    ('Max', 'Dog', 2),
    ('Luna', 'Cat', 3);


-- 6. Demonstrate the records
SELECT *
FROM pets.customer;

SELECT *
FROM pets.pets; 