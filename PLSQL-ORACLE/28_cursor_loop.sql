CREATE OR REPLACE PROCEDURE LIST_USER(
  user_id IN mytable.id%type
)
AS
  uid mytable.id%type;
  uname mytable.name%type;
  CURSOR c  IS SELECT id,name FROM mytable WHERE id = user_id;
BEGIN

OPEN c;

LOOP
  FETCH c  
  INTO uid,uname;
  
  EXIT WHEN c%NOTFOUND;
  
  DBMS_OUTPUT.PUT_LINE(uid);
  DBMS_OUTPUT.PUT_LINE(uname);
END LOOP;

CLOSE c;

END LIST_USER;
/


execute LIST_USER(2);