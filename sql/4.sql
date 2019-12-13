create table member(
	id varchar(20) primary key,
	pass varchar(20),
	name varchar(20),
	gender int(1),
	tel varchar(50),
	email varchar(100),
	picture varchar(200)
)

SELECT * FROM member;
INSERT INTO member(id,pass,NAME,gender,tel) VALUES('admin','1234','관리자',1,'1234');

ALTER table member add email varchar(100);