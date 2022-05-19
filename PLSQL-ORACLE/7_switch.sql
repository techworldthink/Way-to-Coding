DECLARE
    total_amount number := 1000;
    discount     number := 0;
BEGIN
    CASE
        WHEN total_amount > 200 then
            discount := total_amount * .10;
        WHEN total_amount >= 100 and total_amount <= 200 then
            discount := total_amount * .05;
        else
            discount := total_amount * .01;
    end CASE;
    
    dbms_output.put_line(discount);
    
END;