/*
 * Data Definition Language
 * CREATE
 * DROP
 * ALTER
 * TRUNCATE
 */
 
 DROP DATABASE IF EXISTS testing ;
 CREATE DATABASE testing;
 USE testing;
 
 CREATE TABLE testTable(ID INT PRIMARY KEY,DataValue VARCHAR(30));
 DESCRIBE testTable;
  
 ALTER TABLE testTable ADD (CValue int);
 DESCRIBE testTable;
  
 ALTER TABLE testTable MODIFY CValue varchar(20);
 DESCRIBE testTable;
 
 ALTER TABLE testTable DROP COLUMN CValue;
 DESCRIBE testTable;
 
 TRUNCATE TABLE testTable;