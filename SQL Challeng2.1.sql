-- Create a new table called record_logs
-- Fields: log_id, record_id, field_changed, last_update, old_value, new_value
--Create a trigger that tracks changes to customer records and logs the changes in our new table

-- 1. table creations
CREATE TABLE record_logs (
    log_id SERIAL PRIMARY KEY,
    record_id INTEGER,
    field_changed VARCHAR(100),
    last_update TIMESTAMP,
    old_value TEXT,
    new_value TEXT
);



-- 2. Create trigger function


CREATE OR REPLACE FUNCTION log_customer_changes()
RETURNS TRIGGER
LANGUAGE plpgsql
AS $$
BEGIN

    -- Check if first_name changed
    IF OLD.first_name IS DISTINCT FROM NEW.first_name THEN
        INSERT INTO record_logs
            (record_id, field_changed, last_update, old_value, new_value)
        VALUES
            (OLD.customer_id,
             'first_name',
             CURRENT_TIMESTAMP,
             OLD.first_name,
             NEW.first_name);
    END IF;


    -- Check if last_name changed
    IF OLD.last_name IS DISTINCT FROM NEW.last_name THEN
        INSERT INTO record_logs
            (record_id, field_changed, last_update, old_value, new_value)
        VALUES
            (OLD.customer_id,
             'last_name',
             CURRENT_TIMESTAMP,
             OLD.last_name,
             NEW.last_name);
    END IF;


    -- Check if email changed
    IF OLD.email IS DISTINCT FROM NEW.email THEN
        INSERT INTO record_logs
            (record_id, field_changed, last_update, old_value, new_value)
        VALUES
            (OLD.customer_id,
             'email',
             CURRENT_TIMESTAMP,
             OLD.email,
             NEW.email);
    END IF;


    RETURN NEW;

END;
$$;


-- 
-- 3. Create the trigger
-- 

CREATE TRIGGER customer_changes_trigger
AFTER UPDATE ON customer
FOR EACH ROW
EXECUTE FUNCTION log_customer_changes();


-- 
-- 4. Test the trigger
-- 

UPDATE customer
SET first_name = 'John'
WHERE customer_id = 1;



-- 5. View the log


SELECT *
FROM record_logs;



