--1
SELECT studno 학번,(kor+math+eng)/3 평균, case when (kor+math+eng)/3 >=95 then 'A+'
									 		 when (kor+math+eng)/3 >=90 then 'A0'
									 		 when (kor+math+eng)/3 >=85 then 'B+'
									 		 when (kor+math+eng)/3 >=80 then 'B0'
									 		 when (kor+math+eng)/3 >=75 then 'C+'
									 		 when (kor+math+eng)/3 >=70 then 'C0'
									 		 when (kor+math+eng)/3 >=65 then 'D+' 
											 when (kor+math+eng)/3 >=60 then 'D0' ELSE ' ' END 학점,
		 if((kor+math+eng)/3 >=60,'PASS','FAIL') 인정여부		
		 FROM score
		 
--2
SELECT NAME,height,if(height<160,'A',if(height BETWEEN 160 AND 169, 'B',
							if(height BETWEEN 170 AND 179,'C',if(height>=180,'D','')))) 등급 FROM student
							
SELECT NAME,height,case when height < 160 then "A등급"						
								when height	BETWEEN 160 AND 169 then "B등급"
								when height	BETWEEN 170 AND 179 then "C등급" ELSE "D등급" END 키의범위 FROM student
							
							
--3
SELECT NAME,salary, if(salary<=200,'4급',if(salary BETWEEN 201 and 300,'3급',if(salary BETWEEN 301 AND 400,'2급',if(salary>=401,'1급','')))) 등급 FROM professor
ORDER BY 등급

--4
SELECT major1 전공,AVG(weight) 평균몸무게,COUNT(*) 학생수 FROM student
GROUP BY major1
ORDER BY 전공
--5
SELECT job 직급,AVG(salary) 평균급여,if(AVG(salary)>=1000,'우수','보통') 수준 FROM emp
GROUP BY job

--6
SELECT major1  학과,AVG(weight) 평균몸무게,COUNT(*) 학생수 FROM student
GROUP BY major1
ORDER BY 2 DESC

--7
SELECT deptno ,COUNT(*) FROM professor
GROUP BY deptno
HAVING COUNT(*) <=2

--8
SELECT COUNT(*) 전체,
 SUM(if(LEFT(tel,INSTR(tel,')')-1)=02,1,0)) '서울',
 		 SUM(if(LEFT(tel,INSTR(tel,')')-1)=031,1,0)) '경기',
		 SUM(if(LEFT(tel,INSTR(tel,')')-1)=051,1,0)) '부산',
	    SUM(if(LEFT(tel,INSTR(tel,')')-1)=052,1,0)) '경남',
	    SUM(if(LEFT(tel,INSTR(tel,')')-1)IN(02,031,051,052),0,1)) '그외지역'		
		 FROM student
--OR
SELECT COUNT(*) 전체,
		 SUM(if(LEFT(tel,INSTR(tel,')')-1)=02,1,0)) '서울',
 		 SUM(if(LEFT(tel,INSTR(tel,')')-1)=031,1,0)) '경기',
		 SUM(if(LEFT(tel,INSTR(tel,')')-1)=051,1,0)) '부산',
	    SUM(if(LEFT(tel,INSTR(tel,')')-1)=052,1,0)) '경남',
	    SUM(if(LEFT(tel,INSTR(tel,')')-1)not IN(02,031,051,052),1,0)) '그외지역'		
		 FROM student		 

--9. 학생이 속한 전화번호의 지역번호를 출력하기	단,02,031,051,052 제외하여 출력하기
SELECT DISTINCT(LEFT(tel,INSTR(tel,')')-1)) 지역번호  FROM student
WHERE LEFT(tel,INSTR(tel,')')-1) NOT IN('02','031','051','052')
ORDER BY 지역번호