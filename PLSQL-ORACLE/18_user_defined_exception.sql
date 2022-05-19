CREATE OR REPLACE PROCEDURE COUNT_ROW_USERS(
  user_id  IN NUMBER
) AS
    count_user     NUMBER;
    ex_user_id EXCEPTION;
BEGIN

    IF user_id <= 0 THEN
        RAISE ex_user_id;
    END IF;
    
    SELECT COUNT(*) INTO count_user FROM mytable
    WHERE id = user_id;
  
    DBMS_OUTPUT.PUT_LINE(count_user);

EXCEPTION

    WHEN ex_user_id THEN
        DBMS_OUTPUT.PUT_LINE('Invalid user id');
  
END COUNT_ROW_USERS;
/



-- another call method
execute COUNT_ROW_USERS(0);