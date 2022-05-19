CREATE OR REPLACE FUNCTION COUNT_USERS(
    user_id  IN NUMBER
)RETURN NUMBER AS
    count_user NUMBER :=0;
BEGIN

  SELECT COUNT(*) INTO count_user FROM mytable WHERE id = user_id;
  
  RETURN count_user;
  
END COUNT_USERS;
/


-- function calling
SELECT COUNT_USERS(1) FROM dual;


-- function calling method 2
DECLARE
    user_count NUMBER;
BEGIN
    user_count := COUNT_USERS(1);
    DBMS_OUTPUT.PUT_LINE(user_count);
END;



