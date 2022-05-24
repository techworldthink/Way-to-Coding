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

  DBMS_OUTPUT.PUT_LINE(user_record.id);
  DBMS_OUTPUT.PUT_LINE(user_record.name);

END LIST_USER;
/


execute LIST_USER(2);