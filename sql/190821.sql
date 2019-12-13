/*
	outer join: 조인컬럼의 조건에 맞지 않아도 조회가 되도록 하는 조인 
			Left outer join: 왼쪽 테이블의 내용을 전부 나오도록 하는 조인 
			right outer join: 오른쪽 테이블의 내용을 전부 나오도록 하는 조인 
			full outer join: 양쪽 테이블의 내용을 전부 나오도록 하는 조인 
							union 명령어를 이용하여 구현 
	subquery: where 조건문에 select 구문을 사용할 수 있다.
		단일 행 subquery : subquery에 조회되는 결과가 1개의 레코드인 경우 
				연산자: =,>,<,...
		복수 행 subquery : subquery의 결과가 여러개 레코드인 경우 
				연산자: in,>any,<any,>all,<all ...
		다중컬럼 subquery : 비교대상이 되는 컬럼이 두개 이상임.
					복수행인 경우: any,all 사용 불가   
*/

/*
	상호 연관 subquery : 외부 query가 subquery에 영향을 주는 subquery //성능이 안좋아짐 
*/
--직원이 직원의 직급 평균 급여 이상을 받는 직원의 이름,직급,급여 출력하기 
SELECT ename,job,salary FROM emp e1
WHERE salary >= (SELECT AVG(salary) FROM emp e2 WHERE e2.job=e1.job);

SELECT job,AVG(salary) FROM emp GROUP BY job


--문제
--교수 본인 직급의 평균 급여 이상을 받는 교수의 이름,직급,급여,학과명을 출력하기
SELECT p1.NAME,p1.POSITION,p1.salary,m.name FROM professor p1,major m 
WHERE p1.deptno=m.code 
AND salary >= (SELECT AVG(salary) FROM professor p2 WHERE p2.position=p1.position)

/*
	sub query 사용 위치에 따른 분류
		1.where 조건문
		2.컬럼부분에 : 스칼라 subquery
		3.having 구문 
		4.from 절: inline view => view 에서 다시.
*/

--학년의 평균 몸무게가 70보다 큰 학년의 학년과 평균 몸무게를 출력하기
SELECT grade,AVG(weight) FROM student GROUP BY grade HAVING AVG(weight)>70

--emp 테이블의 dept 테이블에서 사원의 이름,직급,부서코드,부서명 출력하기
SELECT e.ename,e.job,d.deptno,d.dname FROM emp e, dept d WHERE e.deptno=d.deptno

-- =>스칼라방식
SELECT ename,job,deptno,(SELECT dname FROM dept d where d.deptno=e.deptno) 부서명 FROM emp e

--학년 별로 평균체중이 가장 적은 학년과  평균 체중을 출력하기
--maria
SELECT grade,AVG(weight) FROM student  GROUP BY grade HAVING AVG(weight) <=ALL (SELECT AVG(weight) FROM student GROUP BY grade)

--oracel 방식(maria에선 안됨)
SELECT grade,AVG(weight) FROM student  GROUP BY grade 
HAVING AVG(weight) = (SELECT min(AVG(weight)) FROM student GROUP BY grade)

--오라클방식을 우회해서 하는방식 
SELECT grade,AVG(weight) FROM student  GROUP BY grade 
HAVING AVG(weight) =
(SELECT MIN(AVG) from (SELECT grade,AVG(weight) avg FROM student GROUP BY grade) a)
--(SELECT grade,AVG(weight) avg FROM student GROUP BY grade) a)-> grade ,avg(weight)레코드로 테이블을 만들어 alias를 a로지정

SELECT grade ,MIN(AVG) FROM
(SELECT grade, AVG(weight) AVG FROM student GROUP BY grade ORDER BY 2) a


--전공 테이블(major)에서 공과대학(deptno=10)에 소속된 학과이름을 출력하기
SELECT NAME FROM major WHERE part in (SELECT m1.code FROM major m1,major m2 WHERE m1.code=m2.part AND m1.part=10 )
 
SELECT NAME FROM major 
WHERE part in (SELECT m1.code FROM major m1,major m2 
						WHERE m1.part=m2.code AND m2.name='공과대학' )

SELECT NAME FROM major 
WHERE part in (SELECT code FROM major where part = 10)

/*
	DDL: Data Definition language 데이터 정의어
		  객체(table,index,view,user...) 
		  생성(create), 삭제(drop), 수정(alter),truncate 기능 명령어
		  commit,rollback의 대상이 아님.                               = transaction(트랜잭션): 원자화 , all or noting
																															 	
*/

--create 명령어
--table1 테이블 생성하기 
CREATE TABLE test1( NO INT PRIMARY KEY AUTO_INCREMENT,
					     NAME VARCHAR(20),
					     birth DATETIME 
						  )
/*
	no: 컬럼명 
	int,varchar,datetime=날짜+시간): 자료형 
 	 숫자형: 
	  			int(4), bigint(8),dectimal(기본,10진수)
 	 문자형: 
	  			varchar(~4000),char(1~255),text(대용량)
	  			오라클: 대용량,blog(2G?,),CLOB(4G?텍스트)
	날짜형: datetime : 날짜+시간 
			  date: 날짜 
			  time: 시간 
			  timestamp: 시간인증을 위한 자료형  	
	primary key: 기본키 , 중복불가+ NOT NULL 기능
			테이블 내에서 중복값을 가질 수 없는 컬럼	
	AUTO_INCREMENT: 숫자형 기본키에서만 사용가능
			값을 자동으로 증가시킴
			오라클에서 사용 불가 => sequence(시퀀스) 객체를 이용하여 auto_increment 기능 수행			 
*/
SELECT * FROM test1

DESC test1

--test2 테이블 생성하기
--컬럼: seq :숫자, name : 문자, birth: 날짜만.
CREATE TABLE test2 ( seq INT PRIMARY KEY AUTO_INCREMENT,NAME VARCHAR(20),birth DATETIME)

DESC test2

INSERT into test2(NAME,birth) VALUE('홍길동','1995-01-10')
INSERT into test2(NAME,birth) VALUE('김삿갓','1996-05-21')
INSERT into test2(seq,NAME,birth) VALUE(3,'김삿갓','1996-05-21')
INSERT into test2(seq,NAME,birth) VALUE(5,'김삿갓','1996-05-21')
INSERT into test2(NAME,birth) VALUE('향단이','1996-04-21')
SELECT * FROM test2

--기본키가 여러컬럼인 테이블 생성하기 test3
--기본키가 여러 컬럼인 경우는 모든 컬럼의 값이 중복안됨.
CREATE TABLE test3(
			NO INT ,
			seq INT,
			NAME VARCHAR(30),
			PRIMARY KEY (NO,seq)
)

INSERT INTO test3(NO,seq,NAME) VALUE(1,1,'첫번째')	
INSERT INTO test3(NO,seq,NAME) VALUE(1,2,'두번째')
INSERT INTO test3(NO,seq,NAME) VALUE(2,1,'세번째')
INSERT INTO test3(NO,seq,NAME) VALUE(2,2,'네번째')
SELECT * FROM test3

--기본값을 설정하기
CREATE TABLE test4(
		NO INT PRIMARY KEY,
		NAME VARCHAR(30) DEFAULT '홍길동' /*값이 없으면 기본값=홍길동 적용*/
		)
INSERT INTO test4(NO) VALUE(1);
INSERT INTO test4(NO,NAME) VALUE(2,'김삿갓');
INSERT INTO test4(NO) VALUE(3)
SELECT * FROM test4

DESC test4

--기존 테이블을 이용하여 새로운 테이블 생성하기

--deptno 테이블의 모든 컬럼과 모든 레코드를 가지고 있는 depttest1 테이블 생성하기
CREATE TABLE depttest1 
AS SELECT * FROM dept

SELECT * FROM depttest1

--dept 테이블에서 deptno, dname 컬럼만 가진 depttest2 테이블 생성하기
CREATE TABLE depttest2
as SELECT deptno,dname FROM dept

SELECT * FROM depttest2

--dept 테이블에서 deptno,dname 컬럼만 가진,지역이 서울인 레코드만 
--depttest3 테이블로 생성하기
CREATE TABLE depttest3
AS SELECT deptno,dname,loc FROM dept WHERE loc='서울'

SELECT * from depttest3

--dept 테이블에서 모든컬럼과 구조만으로 이루어진 depttest4 생성하기
--데이터는 제외하고 생성하기.
CREATE TABLE depttest4
AS SELECT * FROM dept WHERE 1=2 /*where 레코드를 선택해주는 기준 모든 기분을거짓으로 만들면 데이터는 불러오지않음*/
SELECT * from depttest4


--문제
--1. 교수테이블에서 101번 학과 교수들로 이루어진 테이블 professor _101 생성하기
--professor _101의 컬럼은 교수번호,이름,학과코드,직책 컬럼만 가진다.
CREATE TABLE professor_101
AS SELECT no,NAME,deptno,POSITION FROM professor WHERE deptno=101

SELECT * FROM professor_101

/*
index index라는 객체
unique index
*/
-- index 생성하기
CREATE INDEX professor_101_name ON professor_101 (NAME DESC)

/*
	alter : 객체(테이블)의 구조 수정.
	alter table 테이블명 add/modify/change/rename to 컬럼명 자료형
*/
SELECT * FROM depttest2
--depttest2 테이블에 loc 컬럼 추가하기
ALTER TABLE depttest2 add loc VARCHAR(20)
----depttest2 테이블에 loc 컬럼 크기를 varchar(100) 변경하기
ALTER TABLE depttest2 modify  loc VARCHAR(100)
desc depttest2 

--depttest2 테이블에 loc 컬럼을 area 컬럼명으로 변경하기
ALTER TABLE depttest2 CHANGE loc AREA VARCHAR(100)

--depttest2 테이블의 이름을 dept2 이름으로 변경하기
ALTER TABLE depttest2 RENAME to dept2
desc dept2 

--dept2 테이블에 loc컬럼 제거하기.
ALTER TABLE dept2 DROP AREA
desc dept2 

DESC depttest1 /*dept를 똑같이 복사했으나 PRIMARY KEY 없음) 제약조건 복사X*/
desc dept
-- 기본키 설정하기
ALTER TABLE depttest1 ADD CONSTRAINT PRIMARY KEY (deptno)
DESC depttest1

--외래키 설정하기
--professor_101 테이블에 no 컬럼은 반듣시 professor 테이블의  no컬럼의 값이어야한다.
DESC professor
DESC professor_101

ALTER TABLE professor_101 ADD constraint FOREIGN KEY (NO) REFERENCES professor(NO)
DESC professor_101
SELECT * FROM professor_101
INSERT INTO professor_101(no,NAME,position) VALUE(9990,'홍길동','임시직')
INSERT INTO professor_101(no,NAME,position) VALUE(1005,'홍길동','임시직')

--제약 조건 삭제하기
--depttest1 테이블의 기본키 삭제하기
ALTER TABLE depttest1 DROP PRIMARY KEY
DESC depttest1

--professor_101 테이블의  외래키 삭제하기 foreign key는 여러개 사용될 수 있어서 이름을 사용해  제거해야한다.
ALTER TABLE professor_101 DROP FOREIGN KEY professor_101_ibfk_1

--문제
--1. dept3 테이블 생성하기
--   dept 테이블로부터 deptno,dname 두개의 컬럼을 만든다
--2.내용은 없다.
CREATE TABLE dept3  AS  SELECT deptno,dname FROM dept WHERE 1=2
SELECT * FROM dept3
DESC dept3
--3.area 컬럼을 추가한다 varchar(10)
ALTER TABLE dept3 ADD AREA VARCHAR(10)
SELECT * FROM dept3
--4.deptno 컬럼을 기본키로 설정하기
ALTER TABLE dept3 ADD CONSTRAINT PRIMARY KEY(deptno)
DESC dept3
--5.area 컬럼의 크기를 varchar(100) 증가하기
ALTER TABLE dept3 MODIFY area VARCHAR(100) 
DESC dept3
SELECT * FROM dept3