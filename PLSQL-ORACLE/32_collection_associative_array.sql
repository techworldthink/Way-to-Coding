DECLARE
 TYPE userdatatype IS TABLE OF VARCHAR2(64) 
    INDEX BY BINARY_INTEGER;            
    
  user_table  userdatatype;        
  i  NUMBER;                    
  
BEGIN
    user_table(1) := 'A';
    user_table(2) := 'B';
 
  i := user_table.FIRST;
 
  WHILE i IS NOT NULL LOOP
    DBMS_Output.PUT_LINE('user : ' || user_table(i));
    i := user_table.NEXT(i);
  END LOOP;
END;
/