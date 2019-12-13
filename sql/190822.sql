/*
	subquery : select 구문 내부에 select 구문이 존재 
		단일행 subquery, 복수행 subquery, 다중컬럼 subquery                      = where조건이나 having 절에 사용
		상호연관 subquery: select 할때 외부쿼리의 컬럼을 내부 쿼리에서 참조.     = where조건이나 having 절에 사용
		스칼라 subquery: 컬럼부분에 사용되는 subquery
		having 구문 subquery 사용가능
		from 구문 subquery: inline veiw
*/

/* DDL: Data Definition Language
		create: create table, create index,create user,create database...
			  	  객체를 생성하는 명령어
		alter: 이미 생성된 객체의 정의 변경 명령어
				 컬럼 추가,컬럼의 크기 변경, 컬럼의 이름 변경, 컬럼 제거			
				 table의 이름 변경,기본키 생성/삭제,index 생성/삭제 가능.
		drop
		truncate
				
*/
--drop 명령어: 객체 제거하기
SHOW TABLES --현재 데이터베이스에 존재하는 table 목록 리턴
--professor_101 테이블 제거
DROP TABLE professor_101

--truncate : 데이터를 제거함. rollback 되지 않음. (속도가빠르다)
-- 			 대용량 데이터를 빠른 시간에 삭제가능. 삭제 성능이  좋음.
--				 복구가 안되므로 주의 필요.
--			    DELETE 구문: 데이터 제거하기. rollback 됨
--								  데이터를 조건에 맞는 레코드 제거됨 
SELECT * FROM depttest1
TRUNCATE TABLE depttest1

/*
	DML: Data Manipulation Language : 데이터 처리(조작)언어.
		  테이블 내부의 자료(레코드)를 변경할 수 있는 언어.
		  1.instert: 레코드 추가
		  2.update: 레코드 변경
		  3.delete: 레코드 삭제
		    select: 레코드 조회
		    
		    
		    
	CRUD: create(insert),read(select),update,delete
		transection 처리 가능 
			commit,rollback 가능 
*/
SET autocommit=TRUE  --<= 자동 commit 설정
SET autocommit=FALSE --<= 자동 commit 해제
SHOW VARIABLES LIKE 'autocommit' -- autocommit 값 확인

SELECT  * FROM depttest3
DELETE FROM depttest3
rollback

--insert : 레코드 추가 명령어
--insert into 테이블명 [(컬럼명1,컬럼명2....)] value (값1,값2,....)

-- depttest4 테이블에 90번 부서 추가하기
--deptno:90  dname:특판팀 loc:광주
SELECT * FROM depttest4
INSERT INTO depttest4 (deptno,dname,loc) VALUE (90,'특판팀','광주')


--컬럼명 기술하지 않고 insert 구문 처리하기 권장하지않음.
--반드시 모든 컬럼을 값으로 입력해야함
--스키마에 정의된 컬럼의 순서대로 값을  처리함.
INSERT INTO depttest4 VALUE (91,'특판1팀','전주')
INSERT INTO depttest4 VALUE (91,'특판1팀') --오류
INSERT INTO depttest4 VALUE (92,'전주','특판2팀')
INSERT INTO depttest4 VALUE (93,'특판1팀')
SELECT * FROM depttest4

--컬럼명을 기술해야 하는 경우
--1. 모든 컬럼에 값을 입력하지 않을 때.
INSERT INTO depttest4 (deptno,dname) VALUE (93,'특판3팀')
SELECT * FROM depttest4
--2. 스키마에 순서를 모를때.
INSERT INTO depttest4 (dname,deptno) VALUE ('특판4팀',94)
SELECT * FROM depttest4
--3. db구조의 변경이 자주 발생될 때,컬럼명을 기술하는 것이 안전함.
ROLLBACK depttest4
COMMIT 

--문제
--1.교수테이블에
--교수번호:6001, 이름:홍길동, id:hongkd, salary:350, 입사일:2019-05-01
--직책:초빙교수 값을 가진 레코드를 등록하기
INSERT INTO professor (NO,NAME,id,salary,hiredate,POSITION) VALUE(6001,'홍길동','hongkd',350,'2019-05-01','초빙교수')
SELECT * FROM professor

--2.사원 테이블에 사원번호:3001,이름:홍길동,직책:사외이사,급여:100,부서:10, 입사일:오늘 인 레코드 등록하기
INSERT INTO emp (empno,ename,job,salary,deptno,hiredate) VALUE (3001,'홍길동','사외이사',100,10,curdATE())
SELECT * FROM emp

--기존의 데이터를 이용하여 데이터 입력하기 insert
--1.학생 중 1학년 학생들로 이루어진 student1 테이블을 생성하기.
-- 단 데이터는 가져오지 않는다.
CREATE TABLE student1 AS SELECT * FROM student WHERE  AND 1=2
SELECT * FROM student1

--2. insert 구문을 이용해서 1학년 학생 정보를 등록하기
INSERT INTO student1 SELECT * FROM student WHERE grade=1

SELECT * FROM student1

--문제
--1. student1 테이블의 내용을 모두 제거하고,
--	  1학년 학생 중 평균키 이상인 학생의 정보를 저장하기.
DELETE from  student1
SELECT * FROM student1
INSERT INTO student1 SELECT * FROM student WHERE height >= (SELECT AVG(height) FROM student WHERE grade=1) AND grade= 1
--2.major테이블 과 같은 컬럼을 가진 major10 테이블 생성하기.
--  단 데이터는 없도록 하기.
--  major10 이라는  테이블에 공과대학에 속한 학과data만 저장하기.
CREATE TABLE major10 AS SELECT * FROM major WHERE 1=2
SELECT * FROM major10

INSERT INTO major10 
SELECT * FROM major 
WHERE part in(SELECT m1.CODE FROM major m1,major m2 WHERE  m1.part=m2.code AND m2.NAME='공과대학')

INSERT INTO major10 
SELECT * FROM major 
WHERE part in(SELECT CODE FROM major  WHERE part =10)

truncate major10
SELECT * FROM major m1,major m2 WHERE  m1.part=m2.code
--틀림
INSERT INTO major10 
SELECT * FROM major
WHERE part in(SELECT m1.CODE FROM major m1,major m2 WHERE  m1.code=m2.part AND m1.NAME='공과대학')
--

--3.student 테이블과 같은 컬럼을 가진 테이블 student_male 테이블 생성하기.
-- 학생 중 남학생만 student_male 테이블에 데이터를 저장하기.
-- 성별은 주민번호를 기준으로 한다.
CREATE TABLE student_male AS SELECT * FROM student WHERE 1=2
SELECT * FROM student_male
INSERT INTO student_male SELECT * FROM student WHERE substr(jumin,7,1)=1 in(SELECT substr(jumin,7,1) FROM student )
-- =INSERT INTO student_male SELECT * FROM student WHERE substr(jumin,7,1) in('1','3' )
DELETE FROM student_male

/*
	update: 컬럼의 값을 변경
	
	update 테이블명 set 컬럼1=값1, 컬럼2=값2....
	[where 조건문] => 조건문 없으면 모든 레코드의 컬럼이 수정
						=> 조건문이 있으면 조건을 만족하는 레코드만 컬럼이 수정
*/

--emp테이블에서 직급이 사원인 경우 보너스 10만원 인상하기.
-- 보너스가 없으면 0으로 처리하기.
SELECT * FROM emp WHERE job='사원'

UPDATE emp SET bonus = ifnull(bonus,0)+10
WHERE job='사원'

--문제
--1.교수테이블에서 이상미 교수와 같은 직급의 교수 중 급여가 350 미만의 교수의 급여를 10% 인상하여 변경하기
SELECT * FROM professor WHERE POSITION = (SELECT POSITION FROM professor WHERE NAME='이상미') AND salary < 350

UPDATE professor SET salary = salary*1.1
WHERE POSITION = (SELECT POSITION FROM professor WHERE NAME='이상미') AND salary < 350

--2.교수테이블의 시간 강사의 보너스를 조교수의 평균 보너스의 50%로 변경하기 
UPDATE professor SET bonus = (SELECT AVG(bonus) FROM professor WHERE POSITION='조교수')*0.5 
WHERE POSITION='시간강사'

SELECT * FROM professor
rollback
--3.학생 중 지도교수가 없는 학생의 지도교수를 이용 학생의 지도교수로 변경하기
UPDATE student SET profno = (SELECT profno FROM student WHERE NAME='이용') 
WHERE profno IS NULL

SELECT * FROM student

/*
	delete : 레코드 삭제
	delete from 테이블명
	[where 조건문] => 조건문 없으면 모든 레코드 삭제
						=> 조건문이 있으면 조건에 맞는 레코드만삭제
*/
--교수 중 교수번호가 6000번이상인 교수를 퇴직시키기
SELECT * FROM professor WHERE NO >= 6000
DELETE FROM professor WHERE NO >= 6000

ROLLBACK

--