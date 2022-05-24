-- demo row insert
INSERT INTO mytable VALUES(3,'test');

-- passing records as arguments
CREATE OR REPLACE PROCEDURE UPDATE_USER(
  user_data IN mytable%rowtype
)
IS
BEGIN

  UPDATE mytable
  SET ROW = user_data
  WHERE id = user_data.id;

END UPDATE_USER;
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

  user_record.name := 'newname';

  UPDATE_USER(user_record);

END MANAGE_USER;
/

-- call main procedure
execute MANAGE_USER(3);

-- check
SELECT * FROM mytable;
