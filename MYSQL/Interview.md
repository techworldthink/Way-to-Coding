
## 1. DDL (Data Definition Language)
```sql
/*
 * DDL - CREATE, RENAME, TRUNCATE,  ALTER, DROP  
 */
 
DROP DATABASE IF EXISTS testDb;
CREATE DATABASE testDb;
USE testDb;
 
CREATE TABLE employee(
    id 			INT PRIMARY KEY,
    name 		VARCHAR(30),
    salary 		INT,
    doj 		DATE,
    leaveDays           INT
 );
DESCRIBE employee;
 
ALTER TABLE employee ADD (userStatus INT);
ALTER TABLE employee MODIFY userStatus VARCHAR(2);
ALTER TABLE employee DROP COLUMN userStatus;
ALTER TABLE employee RENAME TO employee_newname;


TRUNCATE TABLE employee;
DROP TABLE IF EXISTS employee;
```

## 2. DML (Data Manipulation Language)
```sql
/*
 * DML - SELECT, INSERT, DELETE, UPDATE  
 */

INSERT INTO employee VALUES(1,"A",1000,"2022-03-12",12);
INSERT INTO employee(id,name,salary,doj,leaveDays) VALUES(9,"H",8000,"1022-03-12",12);

SELECT * FROM employee;
SELECT name FROM employee;
SELECT * FROM employee LIMIT 2;
SELECT DISTINCT salary FROM employee;
SELECT COUNT(DISTINCT salary) FROM employee;
SELECT name FROM employee WHERE id=1;
SELECT name FROM employee WHERE id BETWEEN 2 AND 5;
SELECT name FROM employee WHERE name LIKE "%A%";
SELECT name FROM employee WHERE name LIKE "_A%";
SELECT name FROM employee WHERE id IN(1,3);
SELECT name FROM employee WHERE id IN(SELECT id FROM employee);
SELECT name FROM employee WHERE id=1 OR id=2;
SELECT name FROM employee WHERE NOT id=1;
SELECT name FROM employee WHERE id=1 AND id=1;
SELECT name FROM employee ORDER BY salary ASC;
SELECT name FROM employee ORDER BY salary DESC;
SELECT name FROM employee WHERE leaveDays IS NULL;
SELECT name FROM employee WHERE leaveDays IS NOT NULL;
SELECT name AS NAME,salary AS SALARY FROM employee;
SELECT CONCAT(id,name) AS user_details FROM employee;
SELECT CONCAT_WS(", ",id,name) AS user_details FROM employee;
SELECT E.id FROM employee AS E;

SET SQL_SAFE_UPDATES = 0;
UPDATE employee SET salary=30000 WHERE salary=20000;
DELETE FROM employee WHERE id=9;

SELECT COUNT(*) FROM employee;
SELECT AVG(salary) FROM employee;
SELECT SUM(salary) FROM employee;
SELECT MIN(salary) FROM employee;
SELECT MAX(salary) FROM employee;


/* JOIN */

CREATE TABLE book(
    bookId int not null primary key,
    bookName varchar(20)
);

CREATE TABLE registers(
    regId int not null primary key,
    bookId int,
    FOREIGN KEY(bookId) REFERENCES book (bookId) ON DELETE CASCADE ON UPDATE CASCADE
);

/*   INNER JOIN - Returns records that have matching values in both tables   */
SELECT book.bookName,registers.regId FROM book INNER JOIN registers ON book.bookId=registers.regId;
SELECT book.bookName,registers.regId FROM registers INNER JOIN book ON book.bookId=registers.regId;

/*   LEFT JOIN: Returns all records from the left table, and the matched records from the right table   */
SELECT book.bookName,registers.regId FROM book LEFT JOIN registers ON book.bookId=registers.regId;
SELECT book.bookName,registers.regId FROM registers LEFT JOIN book ON book.bookId=registers.regId;

/*   RIGHT JOIN: Returns all records from the right table, and the matched records from the left table   */
SELECT book.bookName,registers.regId FROM book RIGHT JOIN registers ON book.bookId=registers.regId;
SELECT book.bookName,registers.regId FROM registers RIGHT JOIN book ON book.bookId=registers.regId;

/*   CROSS JOIN: Returns all records from both tables   */
SELECT book.bookName,registers.regId FROM book CROSS JOIN registers;
SELECT book.bookName,registers.regId FROM registers CROSS JOIN book;

/*   SELF JOIN: A self join is a regular join, but the table is joined with itself   */
SELECT T1.bookName FROM book T1,book T2 WHERE T1.bookId=T2.bookId;
SELECT T1.bookName FROM book T1,book T2 WHERE T1.bookId <> T2.bookId;
SELECT T1.bookName FROM book T1,book T2;



/*
 * The GROUP BY statement is often used with aggregate functions
 * COUNT()
 * MAX()
 * MIN()
 * SUM()
 * AVG()
 * to group the result-set by one or more columns.
*/

SELECT * FROM book GROUP BY bookName;
SELECT COUNT(*),bookName FROM book GROUP BY bookName;
SELECT MIN(bookId),bookName FROM book GROUP BY bookName;
SELECT agentArea,MIN(agentCommission) FROM  agent GROUP BY agentArea;



SELECT * FROM book GROUP BY bookName HAVING COUNT(bookId)>2;
SELECT * FROM book GROUP BY bookName HAVING COUNT(bookId)>2 ORDER BY bookNAme ASC;

```



 ## 3. DCL (Data Control Language)
```sql
/*
 * Data Control Language
 * GRANT 
 * REVOKE
 */
 
 DROP DATABASE IF EXISTS testing ;
 CREATE DATABASE testing;
 USE testing;
 
-- Create a role 'tester' if it doesn't exist
CREATE ROLE IF NOT EXISTS tester;

-- Grant the CREATE privilege on the 'testing' database to the 'tester' role
GRANT CREATE ON testing TO tester;

-- Create a user 'dev1' with a password 'dev1Pass' if it doesn't exist
CREATE USER IF NOT EXISTS 'dev1'@'localhost' IDENTIFIED BY 'dev1Pass';

-- Grant the 'tester' role to the 'dev1' user
GRANT tester TO 'dev1'@'localhost';

-- Show the grants for the 'dev1' user
SHOW GRANTS FOR 'dev1'@'localhost';

-- Select the current role (if applicable, depending on the MySQL version)
SELECT CURRENT_ROLE();

-- Revoke the 'tester' role from the 'dev1' user
REVOKE tester FROM 'dev1'@'localhost';

-- Revoke the CREATE privilege on the 'testing' database from the 'tester' role
REVOKE CREATE ON testing FROM tester;

-- Drop the 'tester' role
DROP ROLE tester;

 ```

  ## 4. TCL ( Transaction Control Language)
```sql
/* 
 * Transaction Control Language
 * COMMIT
 * ROLLBACK
 * SAVEPOINT
 */
 
 DROP DATABASE IF EXISTS testing ;
 CREATE DATABASE testing;
 USE testing;

 CREATE TABLE IF NOT EXISTS testTable(
    ID INT PRIMARY KEY,
    DataValue VARCHAR(30)
 );
 
 
 INSERT INTO testTable VALUES(2,"ABC");
 COMMIT;
 UPDATE testTable SET ID=11 WHERE ID=2;
 
 START TRANSACTION;
 SAVEPOINT A;
 INSERT INTO testTable VALUES(4,"ABCDE");
 
 SELECT * FROM testTable;
 
 ROLLBACK TO A;
 SELECT * FROM testTable;
```