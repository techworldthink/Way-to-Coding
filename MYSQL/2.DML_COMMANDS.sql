/* 
 * Data Manipulation Language
 * INSERT
 * UPDATE
 * DELETE
 * SELECT
 */
 
 USE testing;
 
 INSERT INTO testTable VALUES(1,"ABC");
 SELECT * FROM testTable;
 UPDATE testTable SET ID=2 WHERE ID=1;
 SELECT * FROM testTable;
 DELETE FROM testTable WHERE ID=2;
 SELECT * FROM testTable;