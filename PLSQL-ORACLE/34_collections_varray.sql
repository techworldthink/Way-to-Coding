-- Nested tables

DECLARE
 TYPE userdatatype IS VARRAY(4) OF VARCHAR2(64);            
  user_table  userdatatype := userdatatype();        
  i  NUMBER;                    
  
BEGIN

    user_table.EXTEND(4); -- size of array
    
    user_table(1) := 'A';   -- sequencial insert
    user_table(2) := 'B';
    
 
  i := user_table.FIRST;
 
  WHILE i IS NOT NULL LOOP
    DBMS_Output.PUT_LINE('user : ' || user_table(i));
    i := user_table.NEXT(i);
  END LOOP;
END;
/