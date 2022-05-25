CREATE OR REPLACE PROCEDURE ADD_USER(
  user_id   IN NUMBER,
  user_name IN VARCHAR2
) AS
  total_rows NUMBER;
BEGIN

  INSERT INTO mytable(id,name)
  VALUES(user_id,user_name);
  
  IF sql%FOUND THEN
    total_rows := sql%ROWCOUNT;
    DBMS_OUTPUT.PUT_LINE('Affected row count : ' || total_rows);
  END IF;

END ADD_USER;
/

execute ADD_USER(4,'abc');