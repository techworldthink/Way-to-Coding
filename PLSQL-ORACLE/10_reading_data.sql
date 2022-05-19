DECLARE
    c_id    number := 10;
    c_name  varchar2(50);
    c_addr  varchar2(50);
BEGIN
    SELECT first_name,country INTO c_name,c_addr
    FROM customer
    WHERE customer_id = c_id;
    
    DBMS_OUTPUT.PUT_LINE('Name : ' || c_name);
    DBMS_OUTPUT.PUT_LINE('Address : ' || c_addr);
END;


SELECT * FROM customer;