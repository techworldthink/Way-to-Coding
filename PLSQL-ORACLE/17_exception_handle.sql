CREATE OR REPLACE PROCEDURE COUNT_ROW_USERS(
    user_id IN NUMBER
) AS
    user_name  mytable.name%type;
BEGIN

  SELECT name INTO user_name FROM mytable 
  WHERE id = user_id;
  DBMS_OUTPUT.PUT_LINE(user_name);

EXCEPTION

    WHEN no_data_found THEN
        DBMS_OUTPUT.PUT_LINE('No such user');
    WHEN too_many_rows THEN
        DBMS_OUTPUT.PUT_LINE('You got more than 1 row');
    WHEN others THEN
        DBMS_OUTPUT.PUT_LINE('Error!');
  
END COUNT_ROW_USERS;
/


-- procedure calling

BEGIN
  COUNT_ROW_USERS(2);
END;

-- another call method
execute COUNT_ROW_USERS(2);