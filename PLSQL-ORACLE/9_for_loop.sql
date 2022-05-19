DECLARE

    counter number := 1;
    
BEGIN

    -- FOR counter IN REVERSE 10..20
    FOR counter IN 10..20
    LOOP
        dbms_output.put_line('value is : ' || counter);
    END LOOP;
    
END;