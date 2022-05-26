CREATE OR REPLACE PROCEDURE LIST_USER(
  user_id IN mytable.id%type
)
AS
    
BEGIN

FOR c_rec IN (SELECT id,name FROM mytable WHERE id = user_id)
LOOP
  DBMS_OUTPUT.PUT_LINE(c_rec.id);
  DBMS_OUTPUT.PUT_LINE(c_rec.name);
END LOOP;

END LIST_USER;
/


execute LIST_USER(2);