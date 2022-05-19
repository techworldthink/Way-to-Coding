CREATE OR REPLACE PROCEDURE COUNT_ROW_USERS(
  count_user   OUT NUMBER
) AS
BEGIN

  SELECT COUNT(*) INTO count_user FROM mytable;
  
END COUNT_ROW_USERS;
/


-- procedure calling
DECLARE
    count_get NUMBER;
BEGIN
  COUNT_ROW_USERS(count_get);
  DBMS_OUTPUT.PUT_LINE(count_get);
END;

