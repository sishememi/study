SELECT name,truncate(DATEDIFF(NOW(),hiredate)/30,0) 근무개월  FROM professor
ORDER BY 2 DESC

SELECT NAME 학생이름,id 사용자아이디 FROM student
WHERE CHAR_LENGTH(id)>=7


SELECT NAME,substr(email,INSTR(email,'@')+1)서버이름 FROM professor

SELECT NAME, RPAD(id,20,'$') id   FROM professor WHERE deptno IN(101,201,301)
UNION
SELECT NAME, LPAD(id,20,'#') id   FROM student  WHERE major1 IN(101,201,301)

SELECT empno 사원번호,eNAME 사원이름,job 직급,deptno 부서코드,
concat(year(DATE_ADD(hiredate,INTERVAL 10 YEAR)),"-",lpad(MONTH(birthday),2,0),'-01') 안식시작일
,DATE_ADD(concat(year(DATE_ADD(hiredate,INTERVAL 10 YEAR)),"-",MONTH(birthday),"-01"),INTERVAL 1 MONTH) 안식종료일
FROM emp

--or
SELECT empno 사원번호,eNAME 사원이름,job 직급,deptno 부서코드,
STR_TO_DATE(concat(year(DATE_ADD(hiredate,INTERVAL 10 YEAR)),lpad(MONTH(birthday),2,0),'01'),'%Y%m%d') 안식시작일
LAST_DAY(STR_TO_DATE(concat(year(DATE_ADD(hiredate,INTERVAL 10 YEAR)),lpad(MONTH(birthday),2,0),'01'),'%Y%m%d')) 안식종료일 FROM emp


SELECT studno 학생번호,NAME 이름, major1 학과번호,if(MOD(studno,3)=0,'A팀',if(MOD(studno,3)=1,'B팀','C팀')) 팀이름  from student