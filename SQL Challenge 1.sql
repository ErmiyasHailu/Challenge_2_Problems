
       --- SQL Challenge 1
-- 1. Get all fields and records from customer
SELECT * FROM customer;
-- 2. Get all fields from customer, but only if they are from Arizona
SELECT * FROM customer WHERE state = 'AZ';
-- 3. Get all invoices older than 6 months 
SELECT * FROM invoice
WHERE invoice_date < CURRENT_DATE - INTERVAL '6 months';

--4. Update all customer phone numbers to NULL if they don’t follow this format: ‘+1 555 555-5555’
UPDATE customer SET phone = NULL
WHERE phone !~ '^\+1 [0-9]{3} [0-9]{3}-[0-9]{4}$';

--5. Get all tracks that are longer than 180000 milliseconds 
SELECT * FROM track
WHERE milliseconds >180000;

--6 Update all customers not in the USA so that their country=USA and address, city, & state are NULL
UPDATE customer
SET country = 'USA', address = NULL, city = NULL, state = NULL
WHERE country <> 'USA';
--7 Given a customer_id, return their total spending across all invoices using a function 

CREATE OR REPLACE FUNCTION get_customer_total_spending(p_customer_id INTEGER)
RETURNS NUMERIC
LANGUAGE SQL
AS $$
    SELECT SUM(total)
    FROM invoice
    WHERE customer_id = p_customer_id;
$$;
-- to call the function 
SELECT get_customer_total_spending(4);

-- 8. Given an employee_id + new_manager_id, create a stored procedure to update an Employee’s ReportsTo field.
-- Prevent an employee reporting to themselves, reporting to a non-existence employee, or creating a circular management relationship
CREATE OR REPLACE PROCEDURE update_employee_manager(
    p_employee_id INT,
    p_new_manager_id INT
)
LANGUAGE plpgsql
AS $$
BEGIN

    -- 1. Employee cannot report to themselves
    IF p_employee_id = p_new_manager_id THEN
        RAISE EXCEPTION 'Employee cannot report to themselves';
    END IF;

    -- 2. Manager must exist
    IF NOT EXISTS (
        SELECT 1
        FROM employee
        WHERE employee_id = p_new_manager_id
    ) THEN
        RAISE EXCEPTION 'Manager does not exist';
    END IF;

    -- 3. Prevent circular management relationship
    IF EXISTS (
        WITH RECURSIVE manager_chain AS (
            SELECT employee_id, reports_to
            FROM employee
            WHERE employee_id = p_new_manager_id

            UNION ALL

            SELECT e.employee_id, e.reports_to
            FROM employee e
            JOIN manager_chain mc
                ON e.employee_id = mc.reports_to
        )
        SELECT 1
        FROM manager_chain
        WHERE employee_id = p_employee_id
    ) THEN
        RAISE EXCEPTION 'This would create a circular management relationship';
    END IF;

    -- 4. Update the employee's manager
    UPDATE employee
    SET reports_to = p_new_manager_id
    WHERE employee_id = p_employee_id;

END;
$$;

CALL update_employee_manager(5, 3);

