-- procedure one
CREATE OR REPLACE PROCEDURE ADD_USER(
  user_id   IN NUMBER,
  user_name IN VARCHAR2
) AS
BEGIN

  INSERT INTO mytable(id,name)
  VALUES(user_id,user_name);
  
  DBMS_OUTPUT.PUT_LINE('Data succesfully inserted');
  
  COMMIT;

END ADD_USER;
/

-- procedure second
CREATE OR REPLACE PROCEDURE GET_USER(
  user_id   IN NUMBER
) 
AS
    username mytable.name%type;
BEGIN

  SELECT name INTO username 
  FROM mytable 
  WHERE id = user_id;
  
  DBMS_OUTPUT.PUT_LINE(username);
  
  COMMIT;

END GET_USER;
/

-- procedure third
CREATE OR REPLACE PROCEDURE GET_COUNT
AS
    user_count NUMBER;
BEGIN

  SELECT count(*) INTO user_count 
  FROM mytable;
  
  DBMS_OUTPUT.PUT_LINE(user_count);
  
  COMMIT;

END GET_COUNT;
/
