DECLARE

    counter number := 1;
    
BEGIN

    WHILE counter < 10
    LOOP
        counter := counter + 1;
    END LOOP;
    
    dbms_output.put_line(counter);
    
END;