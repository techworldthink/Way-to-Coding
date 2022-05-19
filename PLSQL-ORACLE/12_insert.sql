CREATE TABLE mytable(
    ID NUMBER,
    NAME VARCHAR2(50)
);

DECLARE
 user_id   mytable.id%type := 1;
 user_name mytable.name%type := 'A';
BEGIN
    INSERT INTO mytable(id,name)
    VALUES(user_id,user_name);
    
    COMMIT;
    
    DBMS_OUTPUT.PUT_LINE('Data succesfully Inserted.');
END;
/

SELECT * FROM mytable;