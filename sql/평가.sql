SELECT LAST_DAY(DATE_ADD(NOW(),INTERVAL 10 DAY)),LAST_DAY(DATE_ADD(NOW(),INTERVAL 20 DAY))
1. 두개의 테이블의 외래키를 생성하는 구문 작성하기
ALTER TABLE professor_101 ADD constraint FOREIGN KEY (NO) REFERENCES professor(NO)

2. 데이터를 추가하는 dml 구문 작성하기
insert into 테이블명 [(컬럼명1,컬럼명2....)] value (값1,값2,....)

ex)INSERT INTO depttest4 (deptno,dname,loc) VALUE (90,'특판팀','광주')

3. classdb데이터 베이스에 존재하는 테이블 목록 조회하기
SHOW TABLES  --현재 데이터베이스에 존재하는 table 목록 리턴

4. 기본키를 추가하는 ddl 구문 작성하기
ALTER TABLE depttest1 ADD CONSTRAINT PRIMARY KEY (deptno)

5. 기존테이블을 이용하여 새로운 테이블 생성하기
create table 새로운테이블
as select * from 기존테이블

ex)deptno 테이블의 모든 컬럼과 모든 레코드를 가지고 있는 depttest1 테이블 생성하기
CREATE TABLE depttest1 
AS SELECT * FROM dept

6. 그룹함수를 이용한 조회 (2)

7. 두개의 테이블을 조인하여 조회(3)

8. subquery를 이용하여 조회하기


INSERT INTO car(NO,NAME,color) VALUE(11,'홍길동','빨강')
ALTER TABLE car ADD CONSTRAINT  PRIMARY KEY(NO)

CREATE TABLE car_info
AS SELECT NO NAME,color FROM car WHERE  no=10 

SELECT COUNT(*),COUNT(bonus) FROM professor
GROUP BY POSITION

SELECT COUNT(*),SUM(salary),SUM(IFNULL(bonus,0)),AVG(salary),AVG(IFNULL(bonus,0)) FROM professor
GROUP BY deptno

SELECT o.name,o.tel,c.color FROM OWNER o car c WHERE o.no=c.ownerno3


SELECT  e1.empno,e1.ename,e1.job,e1.mgr,e2.ename,e2.job FROM emp e1 left join emp e2
on e1.empno=e2.mgr


SELECT e1.empno,e1.ename,e1.job,e1.mgr,e2.ename,e2.job FROM emp e1 LEFT JOIN emp e2 
ON e1.mgr=e2.empno

SELECT p.no,p.name,COUNT(profno) 
FROM professor p left join student s 
ON  p.no=s.profno
GROUP BY s.profno


--학생의 이름과 지도교수이름을 출력하기 단, 지도학생이 없는 교수도 출력하기
SELECT p.no,p.name,COUNT(*) FROM student s right join professor p
on s.profno=p.no
GROUP BY s.profno

SELECT e.ename,e.job,d.deptno,d.dname FROM emp e, dept d
WHERE e.deptno=d.deptno and birthday = (SELECT month(birthday) FROM emp WHERE ename='강칠성')

SELECT COUNT(*),COUNT(bonus) FROM professor
GROUP BY POSITION

SELECT COUNT(*), SUM(salary), SUM(IFNULL(bonus,0)), AVG(salary), AVG(IFNULL(bonus,0))

FROM professor

GROUP BY deptno