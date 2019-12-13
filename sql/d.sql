clascreate table dept (
  deptno   integer(2) primary key, 
  dname    varchar(14),
  loc      varchar(20));

insert into dept values (10,'대표이사','서울');
insert into dept values (20,'기획부','서울');
insert into dept values (30,'기술부','서울');
insert into dept values (40,'영업부','서울');
insert into dept values (50,'운용팀','울산');


create table emp ( 
  empno     integer(4) primary key, 
  ename     varchar(10), 
  job       varchar(9), 
  mgr       integer(4), 
  birthday  date,
  hiredate  date, 
  salary    integer(7),
  bonus     integer(7), 
  deptno    integer(2));

insert into emp values (1000,'이승엽','대표',NULL,'1972-10-01','2012-01-01',1800,500,10);
insert into emp values (1002,'김유택','이사',1000,'1973-11-10','2013-01-03',1000,300,30);
insert into emp values (2001,'주승재','차장',1000,'1982-01-12','2012-01-01',900,200,20);
insert into emp values (2002,'송승환','차장',1000,'1984-02-19','2014-10-01',900,200,40);
insert into emp values (2003,'주재희','주임',2001,'1983-03-14','2012-10-01',700,100,20);
insert into emp values (2004,'이혜라','사원',2002,'1990-04-20','2012-10-01',600,150,40);
insert into emp values (2005,'이로운','사원',2001,'1991-05-21','2014-09-01',500,150,20);
insert into emp values (2006,'박하연','사원',1000,'1990-06-30','2014-10-01',600,150,50);
insert into emp values (2007,'김잔디','사원',2002,'1989-07-11','2015-11-01',550,NULL,40);
insert into emp values (2008,'김경빈','과장',1002,'1980-08-23','2016-01-03',650,200,30);
insert into emp values (2009,'이영섭','과장',1002,'1982-09-08','2016-01-03',650,200,30);
insert into emp values (2010,'강칠성','사원',1002,'1980-10-06','2016-06-01',600,NULL,30);
insert into emp values (2011,'김명신','사원',1002,'1972-11-22','2016-06-01',500,NULL,30);
insert into emp values (2012,'김민용','사원',2002,'1992-12-16','2014-10-01',550,150,40);


create table major
( code integer(3) primary key , 
  name varchar(20) not null,
  part integer(3),
  build  varchar(14));

insert into major