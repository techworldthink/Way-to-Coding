-- package
CREATE OR REPLACE PACKAGE USER_PACKAGE
AS
PROCEDURE ADD_USER(
  user_id   IN NUMBER,
  user_name IN VARCHAR2
);
PROCEDURE GET_USER(
  user_id   IN NUMBER
); 
PROCEDURE GET_COUNT;

END USER_PACKAGE;



-- package body
CREATE OR REPLACE PACKAGE BODY USER_PACKAGE
AS

PROCEDURE ADD_USER(
  user_id   IN NUMBER,
  user_name IN VARCHAR2
) AS
BEGIN

  INSERT INTO mytable(id,name)
  VALUES(user_id,user_name);
  
  DBMS_OUTPUT.PUT_LINE('Data succesfully inserted');
  
END ADD_USER;


PROCEDURE GET_USER(
  user_id   IN NUMBER
) 
AS
    username mytable.name%type;
BEGIN

  SELECT name INTO username 
  FROM mytable 
  WHERE id = user_id;
  
  DBMS_OUTPUT.PUT_LINE(username);
  
END GET_USER;

PROCEDURE GET_COUNT
AS
    user_count NUMBER;
BEGIN

  SELECT count(*) INTO user_count 
  FROM mytable;
  
  DBMS_OUTPUT.PUT_LINE(user_count);
  
END GET_COUNT;

END USER_PACKAGE;


