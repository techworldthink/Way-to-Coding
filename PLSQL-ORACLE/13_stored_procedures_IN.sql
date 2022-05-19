CREATE TABLE mytable(
    ID NUMBER,
    NAME VARCHAR2(50)
);

CREATE OR REPLACE PROCEDURE ADD_USER(
  user_id   IN NUMBER,
  user_name IN VARCHAR2
) AS
BEGIN

  INSERT INTO mytable(id,name)
  VALUES(user_id,user_name);
  
  COMMIT;

END ADD_USER;
/

-- to call method 1

BEGIN
  ADD_USER(1,'testuser');
END;


-- to call method 2

BEGIN

ADD_USER(
  user_id => 2,
  user_name =>'testuser'
);

END;

-- to call method 3

execute ADD_USER(1,'testuser');

-- view

SELECT * FROM mytable;