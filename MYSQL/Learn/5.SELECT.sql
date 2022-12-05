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
INSERT INTO book(bookId) VALUES(5); 

SELECT * FROM book;
SELECT bookID FROM book;
SELECT DISTINCT bookName FROM book;
SELECT count(DISTINCT bookName) FROM book;
SELECT bookName FROM book WHERE bookId=11;
SELECT bookName FROM book WHERE bookId BETWEEN 3 AND 12;
SELECT bookName FROM book WHERE bookName LIKE "P%";
SELECT bookName FROM book WHERE bookId IN(1,2,12);
SELECT bookName FROM book WHERE bookId IN(SELECT bookId from book);
SELECT bookName FROM book WHERE bookId=1 OR bookId=12;
SELECT bookName FROM book WHERE NOT bookId=1;
SELECT bookName FROM book ORDER BY bookName ASC;
SELECT bookName FROM book ORDER BY bookName DESC;
SELECT bookId FROM book WHERE bookName IS NULL;
SELECT bookId FROM book WHERE bookName IS NOT NULL;