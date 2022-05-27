 -- Statement level
 
CREATE OR REPLACE TRIGGER user_after_action
AFTER INSERT OR UPDATE ON mytable
DECLARE
    
BEGIN
    IF INSERTING THEN
        DBMS_OUTPUT.PUT_LINE('Data inserted');
    ELSIF UPDATING THEN
        DBMS_OUTPUT.PUT_LINE('Data updated');
    END IF;
END;




INSERT INTO mytable VALUES(5,'hai');
UPDATE mytable SET name = 'hi' WHERE name = 'hai';