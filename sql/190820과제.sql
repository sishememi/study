--1 학생의 이름과 지도교수 이름 조회하기. 
--  지도 교수가 없는 학생과 지도 학생이  없는 교수도 조회하기
--  단 지도교수가 없는 학생의 지도교수는  '0000' 으로 출력하고
--  지도 학생이 없는 교수의 지도학생은 '****' 로 출력하기
SELECT s.name,IFNULL(p.name,'0000') FROM student s left join professor p
on s.profno=p.no 
UNION
SELECT IFNULL(s.name,'****'),p.name FROM student s right  join professor p
on s.profno=p.no


--2. 지도 교수가 지도하는 학생의 인원수를 출력하기.
--   단 지도학생이 없는 교수의 인원수 0으로 출력하기
--   지도교수번호, 지도교수이름, 지도학생인원수를 출력하기
SELECT s.profno,p.NAME,COUNT(s.name) 
FROM professor p LEFT join student s 
ON  s.profno = p.no 
GROUP BY p.no

SELECT p.no,p.name 교수이름,count(s.name) FROM professor p left join student s on s.profno=p.no
GROUP BY p.name;

SELECT p.no,p.name,COUNT(s.profno)
FROM student s RIGHT JOIN professor p
ON s.profno=p.no GROUP BY p.name

 --교수 중 지도학생이 없는 교수의 번호,이름,학과번호,학과명 출력하기 
SELECT p.no,p.name,m.code,m.name  /*--,COUNT(s.profno)*/
FROM student s RIGHT JOIN professor p
ON s.profno=p.no JOIN major m 
ON p.deptno=m.code
GROUP BY p.name 
HAVING COUNT(s.profno)=0

--3. emp 테이블에서 사원번호, 사원명,직급,  상사이름, 상사직급 출력하기 
--  모든 사원이 출력되어야 한다.(self join)
--  상사가 없는 사원은 상사이름을 '상사없음'으로  출력하기 
SELECT e1.empno 사원번호,e1.ename 사원명,e1.job 직급,ifnull(e2.ename,'상사없음') 상사이름,ifnull(e2.job,'상사없음')e2.job 상사직급 FROM emp e1 left join emp e2 on e2.empno=e1.mgr

--+상사의 직급이 없는 경우 현재 직급을 출력하기 
SELECT e1.empno 사원번호,e1.ename 사원명,e1.job 직급,ifnull(e2.ename,'상사없음') 상사이름,ifnull(e2.job,e1.job)상사직급 FROM emp e1 left join emp e2 on e2.empno=e1.mgr

--4.김경빈 사원과 같이 입사한 사원의 사원번호, 사원명,직급, 부서코드, 부서코드 명을 출력하기 
SELECT e.empno 사원번호 ,e.ename 사원명 ,e.job 직급,d.deptno 부서코드 ,d.dname 부서코드명 FROM emp e, dept d WHERE e.deptno=d.deptno AND hiredate = (SELECT hiredate FROM emp WHERE ename = '김경빈')

--5.교수 테이블에서 송승환교수보다 나중에 입사한 교수의 이름, 입사일,학과코드,학과명을 출력하기 
SELECT p.NAME 교수이름 ,p.hiredate 입사일,p.deptno 학과코드,m.NAME 학과명 FROM professor p,major m
WHERE p.deptno=m.code 
AND hiredate > (SELECT hiredate FROM professor WHERE NAME = '송승환')

--6.학생 중 2학년 학생의 최대 체중보다 체중이 큰 1학년 학생의 이름, 몸무게, 키를 출력하기 
SELECT NAME 학생이름,weight 몸무게,height 키 FROM student 
WHERE grade=1 AND weight > (SELECT MAX(weight) FROM student WHERE grade=2)
