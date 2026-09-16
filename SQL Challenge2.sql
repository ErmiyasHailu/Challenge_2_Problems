-- 1 Get all invoice ids with the customers first name, last name, and the invoice total

SELECT 
    invoice.invoice_id,
    customer.first_name,
    customer.last_name,
    invoice.total
FROM invoice
INNER JOIN customer
    ON invoice.customer_id = customer.customer_id;

-- 2. Print the invoice id, customer's first name, and invoice total. But only if the invoice is over $30.
SELECT 
    invoice.invoice_id,
    customer.first_name,
    invoice.total
FROM invoice
INNER JOIN customer
    ON invoice.customer_id = customer.customer_id
WHERE invoice.total > 30;

--3. Get all the invoices for USA customers in the last 6 months. Use a CTE.

WITH usa_customers AS (
    SELECT customer_id
    FROM customer
    WHERE country = 'USA'
)
SELECT
    invoice.invoice_id,
    invoice.customer_id,
    invoice.invoice_date,
    invoice.total
FROM invoice
JOIN usa_customers
    ON invoice.customer_id = usa_customers.customer_id
WHERE invoice.invoice_date >= CURRENT_DATE - INTERVAL '6 months';