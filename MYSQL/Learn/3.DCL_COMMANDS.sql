/*
 * Data Control Language
 * GRANT 
 * REVOKE
 */
 
 DROP DATABASE IF EXISTS testing ;
 CREATE DATABASE testing;
 USE testing;
 
 CREATE ROLE IF NOT EXISTS tester;
 GRANT CREATE ON testing TO tester;
 CREATE USER IF NOT EXISTS 'dev1'@'localhost' IDENTIFIED BY 'dev1Pass';
 GRANT tester to 'dev1'@'localhost';
 SHOW GRANTS FOR 'dev1'@'localhost';
 SELECT CURRENT_ROLE();
 
 REVOKE 'dev1'@'localhost' FROM tester;
 REVOKE CREATE ON testing FROM tester;
 DROP ROLE tester;