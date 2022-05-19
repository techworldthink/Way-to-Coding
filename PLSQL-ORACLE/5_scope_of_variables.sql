DECLARE
    -- Global variable
    ordernumber number := 1000;

BEGIN
    -- Local variable
    DECLARE
        id number := 11111;
    BEGIN
        dbms_output.put_line(id);
    END;
    
    dbms_output.put_line(ordernumber);
    
END;