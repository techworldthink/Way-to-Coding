DROP DATABASE IF EXISTS test;
CREATE DATABASE test;
use test;

CREATE TABLE book(
bookId int not null primary key,
bookName varchar(20)
);

CREATE TABLE registers(
regId int not null primary key,
bookId int,
FOREIGN KEY(bookId) REFERENCES book (bookId) ON DELETE CASCADE ON UPDATE CASCADE
);

INSERT INTO book VALUES(1,"POEM"); 
INSERT INTO book VALUES(2,"STORY"); 
INSERT INTO book VALUES(3,"NOVEL"); 
INSERT INTO book VALUES(4,"DOCS"); 

INSERT INTO registers VALUES(1,1); 
INSERT INTO registers VALUES(2,2); 

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
