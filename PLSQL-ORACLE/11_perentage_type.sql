DECLARE
    c_id    customer.customer_id%type := 10;
    c_name  customer.first_name%type;
    c_addr  customer.country%type;
BEGIN
    SELECT first_name,country INTO c_name,c_addr
    FROM customer
    WHERE customer_id = c_id;
    
    DBMS_OUTPUT.PUT_LINE('Name : ' || c_name);
    DBMS_OUTPUT.PUT_LINE('Address : ' || c_addr);
END;
/

SELECT * FROM customer;