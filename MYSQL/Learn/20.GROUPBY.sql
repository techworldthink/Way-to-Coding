/*
 * The GROUP BY statement is often used with aggregate functions
 * COUNT()
 * MAX()
 * MIN()
 * SUM()
 * AVG()
 * to group the result-set by one or more columns.
*/

DROP DATABASE IF EXISTS test;
CREATE DATABASE test;
use test;

CREATE TABLE book(
bookId int not null,
bookName varchar(20)
);

INSERT INTO book VALUES(1,"POEM"); 
INSERT INTO book VALUES(2,"STORY"); 
INSERT INTO book VALUES(3,"NOVEL"); 
INSERT INTO book VALUES(4,"DOCS"); 
INSERT INTO book VALUES(11,"POEM"); 
INSERT INTO book VALUES(12,"STORY"); 
INSERT INTO book VALUES(13,"NOVEL"); 
INSERT INTO book VALUES(14,"DOCS"); 
INSERT INTO book VALUES(15,"DOCS"); 
INSERT INTO book VALUES(16,"DOCS"); 
INSERT INTO book VALUES(34,"POEM"); 

SELECT * FROM book GROUP BY bookName;
SELECT COUNT(*),bookName FROM book GROUP BY bookName;
SELECT MIN(bookId),bookName FROM book GROUP BY bookName;


/* .........  Example  .......... */

CREATE TABLE agent(
agentId int primary key,
agentName varchar(20),
agentArea varchar(20),
agentCommission int
);

INSERT INTO agent VALUES(1,"A","KL1",100);
INSERT INTO agent VALUES(2,"B","KL1",200);
INSERT INTO agent VALUES(3,"C","KL2",100);
INSERT INTO agent VALUES(4,"D","KL2",10);
INSERT INTO agent VALUES(5,"E","KL3",500);

SELECT agentArea,MIN(agentCommission) FROM  agent GROUP BY agentArea;