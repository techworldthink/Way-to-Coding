
## 1. DDL (Data Definition Language)
```sql
/*
 * DDL
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

TRUNCATE TABLE employee;
DROP TABLE IF EXISTS employee;
```

## 2. DML (Data Manipulation Language)
```sql
/*
 * DML
 */

INSERT INTO employee VALUES(1,"A",1000,"2022-03-12",12);
INSERT INTO employee VALUES(2,"B",2000,"2022-04-12",12);
INSERT INTO employee VALUES(3,"C",3000,"2022-05-12",12);
INSERT INTO employee VALUES(4,"D",4000,"2021-03-12",12);
INSERT INTO employee VALUES(5,"E",5000,"2020-03-12",12);
INSERT INTO employee VALUES(6,"F",6000,"2022-03-15",12);
INSERT INTO employee VALUES(7,"G",7000,"2022-03-01",12);
INSERT INTO employee VALUES(8,"H",8000,"1022-03-12",12);
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
```



 