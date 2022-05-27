
 -- Row level


CREATE OR REPLACE TRIGGER user_after_update
AFTER UPDATE ON mytable FOR EACH ROW
DECLARE
    
BEGIN
    DBMS_OUTPUT.PUT_LINE('Data inserted, row');
END;


UPDATE mytable SET name = 'hai' WHERE name = 'hi';