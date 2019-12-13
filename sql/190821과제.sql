--1. 학생테이블에서 전공학과가 101번인 학과의 평균몸무게보다
--  몸무게가 많은 학생들의 이름과 몸무게, 학과명 출력
SELECT s.NAME,s.weight,m.NAME FROM student s, major m  
WHERE s.major1=m.code AND weight > (SELECT AVG(weight) FROM student WHERE major1=101)

--2. 이상미 교수와 같은 입사일에 입사한 교수 중 이영택교수 보다 
--    월급을 적게받는 교수의 이름, 급여, 입사일 출력하기
SELECT NAME, salary, hiredate FROM professor 
WHERE hiredate = (SELECT hiredate FROM professor WHERE NAME='이상미') 
AND salary < (SELECT salary FROM professor WHERE  NAME='이영택')

--3. 101번 학과 학생들의 평균 몸무게 보다  
--  몸무게가 적은 학생의 학번과,이름과, 학과번호, 몸무게를 출력하기
SELECT studno,NAME,major1,weight FROM student WHERE weight < (SELECT AVG(weight) FROM student WHERE major1=101)

--4.자신의 학과 학생들의 평균 몸무게 보다 몸무게가 적은 
 -- 학생의 학번과,이름과, 학과번호, 몸무게를 출력하기
SELECT s1.studno,s1.nAME,s1.major1,s1.weight FROM student s1 
WHERE weight < (SELECT AVG(weight) FROM student s2 WHERE s1.major1=s2.major1);

--5. 학번이 960212학생과 학년이 같고 키는 950115학생보다  큰 학생의 이름, 학년, 키를 출력하기
SELECT NAME,grade,weight FROM student 
WHERE  grade = (SELECT grade FROM student WHERE studno=960212) 
and  height > (SELECT height FROM student WHERE studno=950115)

--6. 컴퓨터정보학부에 소속된 모든 학생의 학번,이름, 학과번호, 학과명 출력하기
SELECT s.studno,s.NAME,s.major1,m.NAME FROM student s , major m 
where s.major1 = m.code AND m.part = (SELECT code FROM major WHERE NAME='컴퓨터정보학부');

SELECT s.studno,s.NAME,s.major1,m.NAME FROM student s , major m 
where s.major1 = m.code AND s.major1 IN(SELECT CODE FROM major WHERE part=100)

SELECT s.studno,s.NAME,s.major1,m.NAME FROM student s , major m 
WHERE s.major1=m.code 
and s.major1 IN(SELECT m1.code FROM major m1,major m2 WHERE m1.part=m2.code AND m2.name='컴퓨터정보학부')

--7. 4학년학생 중 키가 제일 작은 학생보다 키가   큰 학생의 학번,이름,키를 출력하기\
SELECT studno,NAME,height FROM student WHERE height > (SELECT MIN(height) FROM student WHERE grade=4)

SELECT studno,NAME,height FROM student WHERE height > any (SELECT MIN(height) FROM student WHERE grade=4)
--8. 학생 중에서 생년월일이 가장 빠른 학생의 학번, 이름, 생년월일을 출력하기
SELECT studno,NAME,birthday FROM student 
WHERE birthday = (SELECT min(birthday) FROM student)