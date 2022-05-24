CREATE OR REPLACE PROCEDURE LIST_USER(
  user_id IN mytable.id%type
)
AS
  user_record mytable%rowtype;
  user_record_temp mytable%rowtype;
BEGIN

  SELECT * 
  INTO user_record
  FROM mytable
  WHERE id = user_id;

  -- change username value
  user_record.name := 'new_sample_name';
  -- copy record
  user_record_temp := user_record;

  DBMS_OUTPUT.PUT_LINE(user_record.id);
  DBMS_OUTPUT.PUT_LINE(user_record.name);

END LIST_USER;
/


execute LIST_USER(2);