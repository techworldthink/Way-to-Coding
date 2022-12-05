
/*
DROP DATABASE IF EXISTS test2;
CREATE DATABASE test2;
use test2;

CREATE TABLE book(
bookId int not null,
bookName varchar(20)
);
*/

use test2;
call add_book(0,"A");
call add_book(1,"B");
SELECT * FROM book;
