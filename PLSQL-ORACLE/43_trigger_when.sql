/*
* UPDATE - NEW/OLD
* INSERT - NEW
* DELETE - OLD
*/

CREATE OR REPLACE TRIGGER user_after_update
AFTER UPDATE ON mytable 
FOR EACH ROW
WHEN (OLD.NAME = 'abc')
DECLARE
    
BEGIN
    DBMS_OUTPUT.PUT_LINE(:OLD.name);
    DBMS_OUTPUT.PUT_LINE(:NEW.name);
END;

INSERT INTO mytable VALUES(10,'abc');
UPDATE mytable SET name = 'abc' WHERE name = 'abc';