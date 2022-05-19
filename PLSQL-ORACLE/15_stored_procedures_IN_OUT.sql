CREATE OR REPLACE PROCEDURE COUNT_ROW_USERS(
  count_user  IN OUT NUMBER
) AS
BEGIN

  SELECT COUNT(*) INTO count_user FROM mytable WHERE id=count_user;
  
END COUNT_ROW_USERS;
/


-- procedure calling
DECLARE
    count_get NUMBER := 1;
BEGIN
  COUNT_ROW_USERS(count_get);
  DBMS_OUTPUT.PUT_LINE(count_get);
END;

-- verify
SELECT * FROM mytable;