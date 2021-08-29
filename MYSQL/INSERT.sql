DROP DATABASE IF EXISTS test;
CREATE DATABASE test;
use test;

CREATE TABLE book(
bookId int not null primary key,
bookName varchar(20)
);

INSERT INTO book VALUES(1,"POEM"); 
INSERT INTO book VALUES(2,"STORY"); 
INSERT INTO book VALUES(3,"NOVEL"); 
INSERT INTO book VALUES(4,"DOCS"); 
INSERT INTO book(bookId,bookName) VALUES(5,"TEXT"); 

SELECT * FROM book;