-- passing records as arguments
CREATE OR REPLACE PROCEDURE CHECK_USER(
  user_data IN mytable%rowtype
)
IS
BEGIN

  DBMS_OUTPUT.PUT_LINE(user_data.id);
  DBMS_OUTPUT.PUT_LINE(user_data.name);

END CHECK_USER;
/

-- first procedure
CREATE OR REPLACE PROCEDURE LIST_USER(
  user_id IN mytable.id%type
)
AS
  user_record mytable%rowtype;
BEGIN

  SELECT * 
  INTO user_record
  FROM mytable
  WHERE id = user_id;

  CHECK_USER(user_record);

END LIST_USER;
/



-- call first procedure
execute LIST_USER(2);