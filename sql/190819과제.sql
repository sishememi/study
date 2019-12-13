--1
SELECT s.studno 학번, s.NAME 이름, s.major1 전공1번호, m.NAME 전공학과, m.build 학과위치 FROM student s, major m
WHERE s.major1=m.code AND s.name='장성태'
--2
SELECT s.studno 학번,s.NAME 이름,s.weight 체중,m.NAME 전공학과, m.build 학과위치 FROM student s, major m
WHERE s.major1=m.code AND s.weight >= 80
--3
SELECT s.name,m.code,m.name FROM student s, major m
WHERE s.major1=m.code AND s.grade=4
--4
SELECT s.name,m.name,m.build FROM student s, major m
WHERE s.major1=m.code AND s.name LIKE '김%'
--5
SELECT s.studno 학번,s.name 학생이름,m.name 소속학과 FROM student s, major m
WHERE s.major1=m.code 
ORDER BY s.name
--6
SELECT m.name 부서명,SUM(p.salary) 급여합계,SUM(IFNULL(p.bonus,0)) 보너스합계,round(AVG(p.salary),2) 급여평균,round(AVG(IFNULL(p.bonus,0)),2) 보너스평균 FROM professor p,major m
WHERE p.deptno=m.code
GROUP BY m.name