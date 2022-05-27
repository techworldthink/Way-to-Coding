-- Triggers
/*
 * row level
 * statement level
 * before triggers
 * afte triggers
 *
 */
 

 -- Statement level


 -- after insert
CREATE OR REPLACE TRIGGER user_after_insert
AFTER INSERT ON mytable
DECLARE
    
BEGIN
    DBMS_OUTPUT.PUT_LINE('Data inserted');
END;

-- before update
CREATE OR REPLACE TRIGGER user_before_update
BEFORE UPDATE ON mytable
DECLARE
    
BEGIN
    DBMS_OUTPUT.PUT_LINE('Data wlll update');
END;

-- after update
CREATE OR REPLACE TRIGGER user_after_update
AFTER UPDATE ON mytable
DECLARE
    
BEGIN
    DBMS_OUTPUT.PUT_LINE('Data updated');
END;


INSERT INTO mytable VALUES(5,'hai');
UPDATE mytable SET name = 'hi' WHERE name = 'hai';