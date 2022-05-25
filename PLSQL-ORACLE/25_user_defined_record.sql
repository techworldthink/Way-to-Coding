
-- passing records as arguments
CREATE OR REPLACE PROCEDURE VIEW_USER(
  user_data IN mytable%rowtype
)
IS
BEGIN

  DBMS_OUTPUT.PUT_LINE(user_data.id);
  DBMS_OUTPUT.PUT_LINE(user_data.name);

END VIEW_USER;
/

-- main
CREATE OR REPLACE PROCEDURE MANAGE_USER(
  user_id IN mytable.id%type
)
AS
  TYPE USER_RECORD IS RECORD(
    id   NUMBER,
    name VARCHAR(20)
  );
  user_records USER_RECORD;
BEGIN

  SELECT * 
  INTO user_records
  FROM mytable
  WHERE id = user_id;

  VIEW_USER(user_records);
  
END MANAGE_USER;
/

-- call main procedure
execute MANAGE_USER(3);

-- check
SELECT * FROM mytable;