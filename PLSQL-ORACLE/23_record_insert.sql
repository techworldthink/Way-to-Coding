-- passing records as arguments
CREATE OR REPLACE PROCEDURE INSERT_USER(
  user_data IN mytable%rowtype
)
IS
BEGIN

  INSERT INTO mytable VALUES user_data;

END INSERT_USER;
/

-- main
CREATE OR REPLACE PROCEDURE MANAGE_USER(
  user_id IN mytable.id%type
)
AS
  user_record mytable%rowtype;
BEGIN

  SELECT * 
  INTO user_record
  FROM mytable
  WHERE id = user_id;

  INSERT_USER(user_record);
  
END MANAGE_USER;
/



-- call main procedure
execute MANAGE_USER(2);

-- check
SELECT * FROM mytable;