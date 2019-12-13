SET SESSION FOREIGN_KEY_CHECKS=0;

/* Drop Tables */

DROP TABLE IF EXISTS test;




/* Create Tables */

CREATE TABLE test
(
	num int NOT NULL,
	name varchar(50) NOT NULL,
	제목 varchar(20),
	내용 ,
	PRIMARY KEY (num)
);



