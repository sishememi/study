/*
	조건함수 : if, case
		case 컬럼명 when 값 then 출력값,...
			else 출력값  end
	 
		case when 조건문 then 출력값,...
			else 출력값 end

	그룹함수: 여러개의 레코드로부터 결과 리턴. NULL 값은 제외됨.
	 	건수: COUNT(컬럼명) => 컬럼의 값이 NULL이 아닌 레코드 건수 
	 			COUNT(*) => 전체 레코드 건수 
	   합계: SUM(컬럼명/값) 
		평균: AVG(컬럼명) 
		가장큰값: MAX(컬럼명)
		가장작은값: MIN(컬럼명)
	 		 
	GROUP  BY 예약어: 그룹함수를 사용시, 그룹외의  기준이되는 컬럼명 
	HAVING: 그룹함수의 조건문 사용시.  	 
*/

--표준편차, 분산 
--stddey,variance
--학생의 국어,영어,수학 점수의 표준편차값과 분산 값을 출력하기 
SELECT STDDEV(kor) 국어표준편차,STDDEV(eng) 영어표준편차,STDDEV(math) 수학표준편차,VARIANCE(kor) 국어분산,VARIANCE(eng) 영어분산 ,VARIANCE(math) 수학분산
FROM score


--순위 지정 함수 : rank over
--교수들의 번호,이름,급여,급여 많이 받는 순위 출력하기 
SELECT NO,NAME,salary,rank() over(ORDER BY salary desc) 급여순위 FROM professor

--교수들의 번호,이름,급여,급여 적게  받는 순위 출력하기 
SELECT NO,NAME,salary,rank() over(ORDER BY salary) 급여순위 FROM professor

--문제 
--1.emp 테이블에서 30번 부서 직원들의 사원번호,이름,급여,급여적은 순위 출력하기 
SELECT empNO,eNAME,salary,deptno,rank() over(ORDER BY salary) 급여순위 FROM emp
WHERE deptno= 30
--2.score 테이블에서 학생의 학번,총점,총점이 많은 순위 출력하기 
SELECT studno 학번,kor+eng+math 총점,rank() over(ORDER BY kor+eng+math DESC) 총점순위 FROM score

--3.student 테이블에서 학생의 학번,국어,국어점수가  많은 순위 출력하기 
--											 수학,수학점수가  많은 순위 
--											 영어,영어점수가  많은 순위, 국어점수가 많은 순서로 출력하기 
SELECT studno 학번,kor  국어,rank() over(ORDER BY kor DESC) 국어점수순위, eng 영어점수,rank() over(ORDER BY eng desc) 영어점수순위,math,rank() over(ORDER BY math desc) 수학점수순위 FROM score 
ORDER BY kor DESC

--문제
--1. 교수테이블에서 교수번호,이름,연봉,연봉많은순위 출력하기 
--연봉은 급여*12+bonus, 보너스가 없는 경우는 0으로 처리하기 
SELECT NO,NAME,salary*12+ifnull(bonus,0) 연봉 ,rank() over(ORDER BY salary*12+ifnull(bonus,0) desc) 연봉많은순위 FROM professor

--누계 계산 함수: sum over()

--교수의 이름,급여,보너스,급여 중간 합계 출력하기 
SELECT NAME,salary,bonus,SUM(salary) over(ORDER BY salary DESC) 급여소개 FROM professor
----교수의 이름,급여,보너스,급여적은 순  중간 합계 출력하기 
SELECT NAME,salary,bonus,SUM(salary) over(ORDER BY salary) 급여소개 FROM professor

/************
 	join : 여러개의 테이블을 연결하여 조회하기 
 	 
*/
--cross join : m*n개의 레코드가 생성됨. 사용시 주의해야함.
SELECT * FROM emp,dept
SELECT * FROM emp ==> 14건 fpzhem
SELECT * FROM dept ==> 5건 레코드

--사원테이블과 부서테이블을  cross join하여 사원번호,사원명,부서코드,부서명 조회하기 
-- ★★★★중복된 컬럼을 조회시 반드시 테이블이름을 기술해야한다.★★★★ 
-- 테이블 이름을 별명을 사용해도 된다.
SELECT empno,ename,dept.deptno,dname  FROM emp,dept
SELECT empno,ename,e.deptno,d.deptno,dname  FROM emp e,dept d   --alias를 써줄수 있다. =간단 

--등가조인: equi join  =기본(inner join)
-- 조인컬럼을 이용하여 필요한 레코드만 조회하기 
-- ★Maria db방식 조인 
SELECT empno,ename,e.deptno,d.deptno,dname  FROM emp e,dept d
WHERE e.deptno=d.deptno

-- ★Ansi 방식 조인 
SELECT empno,ename,e.deptno,d.deptno,dname  FROM emp e JOIN dept d
ON e.deptno=d.deptno

--학생테이블에서 학번,이름 과 score테이블에서 학번에 해당하는 국어,영어,수학점수 조회 
SELECT st.studno,st.NAME,kor,eng,math FROM student st,score sc
WHERE st.studno=sc.studno

SELECT st.studno,st.NAME,kor,eng,math FROM student st join score sc
ON  st.studno=sc.studno

--문제 
--학생의 학번,이름,학년,학과코드,지도교수번호,지도교수 이름을 조회하자
--maria db방식
SELECT studno,s.NAME,grade,major1,profno,p.NAME FROM student s,professor p
WHERE s.profno=p.no

--ansi 방식 
SELECT studno,s.NAME,grade,major1,profno,p.NAME FROM student s join professor p
ON s.profno=p.no

--3학년학생의 학번,이름,학년,학과코드,지도교수번호,지도교수 이름을 조회하자
--maria 방식
SELECT studno,s.NAME,grade,major1,profno,p.NAME FROM student s,professor p
WHERE s.profno=p.no AND grade=3
--ansi 방식
SELECT studno,s.NAME,grade,major1,profno,p.NAME FROM student s join professor p
ON s.profno=p.no 
where grade=3

--김태훈 학생의 학번,이름,국어,영어,수학 총점을 조회하기
--maria
SELECT st.studno,NAME,sc.kor,sc.eng,sc.math,sc.kor+sc.eng+sc.math 총점 FROM student st,score sc
WHERE st.studno=sc.studno and NAME='김태훈'
--ansi
SELECT st.studno,NAME,sc.kor,sc.eng,sc.math,sc.kor+sc.eng+sc.math 총점 FROM student st join score sc
on st.studno=sc.studno
where NAME='김태훈'

--학생의 이름과,학과명,지도교수명 출력하기
--학과명은 major 테이블, 
--지도교수명 professor 테이블
SELECT NAME,major1,profno FROM student
SELECT * FROM professor
SELECT * FROM major

--mariade
SELECT s.name,m.name,p.name
from student s,major m,professor p
WHERE s.major1=m.code
AND s.profno=p.no

--ansi
SELECT s.name,m.name,p.name
from student s join major m
on s.major1=m.code join professor p
on s.profno=p.no

--문제 
--1.학생의 학번,이름,학과명,국어,영어,수학 점수를 출력하기 
--maria
SELECT s.studno 학번,s.NAME 이름,m.name 학과명,c.kor 국어 ,c.eng 영어,c.math 수학
FROM student s,major m,score c
WHERE s.major1=m.code
AND s.studno=c.studno
--ansi
SELECT s.studno 학번,s.NAME 이름,m.name 학과명,c.kor 국어 ,c.eng 영어,c.math 수학
FROM student s join major m
on s.major1=m.code JOIN score c
on s.studno=c.studno 
--2.사원의 이름,부서코드,부서명 출력하기 
SELECT eNAME 이름,e.deptno 부서코드 ,d.dname 부서명 FROM emp e,dept d
WHERE e.deptno=d.deptno

--ansi
SELECT eNAME 이름,e.deptno 부서코드 ,d.dname 부서명 FROM emp e join dept d
on e.deptno=d.deptno

--3.p_grade 테이블과 emp테이블을 조인하여 사원이름,직급,현재연봉, 해당직급의 연봉하한,연봉상한을 출력하기 
--현재 연봉은 (급여*12+bonus)*10000으로 한다.
--보너스가 없는 경우 0으로 처리하기.
SELECT ename 이름,p.POSITION 직급 ,salary*12+IFNULL(bonus,0)*10000 현재연봉,p.s_pay 연봉하한,p.e_pay 연봉상한 FROM p_grade p, emp e 
WHERE p.position=e.job
--ansi
SELECT ename 이름,p.POSITION 직급 ,salary*12+IFNULL(bonus,0)*10000 현재연봉,p.s_pay 연봉하한,p.e_pay 연봉상한 FROM p_grade p join emp e 
on p.position=e.job

SELECT * FROM emp

--지도교수이름과 지도학생이름 출력
SELECT p.NAME 지도교수명 ,s.NAME 지도학생이름 
FROM student s,professor p
WHERE p.no=s.profno
ORDER BY p.name

--문제
--1.지도 교수 별, 지도 교수이름과 지도 학생수를 조회하기
SELECT p.NAME 지도교수이름, COUNT(*) 지도학생수
FROM student s,professor p
WHERE p.no=s.profno
GROUP BY p.name
--2.지도 교수 별, 지도 교수이름과 지도 학생수를 조회하기. 단, 지도학생이 2명이상인 교수만 조회하기
SELECT p.NAME 지도교수이름, COUNT(*) 지도학생수
FROM student s,professor p
WHERE p.no=s.profno
GROUP BY p.name
HAVING COUNT(*)>=2

--self join: 조인되는 테이블이 같은 테이블이다.등가조인과 다른점=> 테이블의 별명을 반드시 설정.

--사원테이블 사원번호,사원명,상사의 이름을 조회하자
SELECT * FROM emp

SELECT e1.empno,e1.ename,e2.empno FROM emp e1,emp e2
WHERE e1.empno=e2.empno

--문제 
--1.학과 테이블에서 학과코드와 학과명,상위학과명을 출력하자
select * from major;

SELECT m1.code  학과코드 ,m1.name  학과명, m2.name  상위학과명 FROM major m1,major m2
WHERE m1.part=m2.code

--2.교수테이블에서 교수번호,이름,입사일,자신과 입사일이 같은 사람의 인원수를 출력하기 단, 입사일이 빠른 순으로 정렬하기
SELECT p1.NO,p1.NAME,p1.hiredate,COUNT(*)
FROM professor p1,professor p2
WHERE p1.hiredate=p2.hiredate
GROUP BY p1.no
ORDER BY p1.hiredate

