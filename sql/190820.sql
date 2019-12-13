/*
	그룹 함수 
		표준편차: stddev
		분산: variance
		순위지정함수: rank() over(정렬방식)
		누계산출함수: sum() over(정렬방식)
		
		
	JOIN 구문
		:여러개의 테이블을 연결하여 조회.
		cross join: m*n 건수로 조회. 사용시 주의 사항
		등가조인(equi join): 조인컬럼을 이용하여 조건이 맞는 레코드만 조회
									조인컬럼값이 같은 경우 조인 대상 레코드.
	   self join: 조인되는 테이블이 같은 테이블임.
	   			  조인컬럼은 같은 테이블의 다른컬럼을  이용함.
	   			  반드시 테이블의 별명을 지정해야 한다.
*/
/*
	비등가조인(non equi join)
		조인컬럼의 조건이 =이 아닌 경우. 범위지정으로 조인됨.
		
*/
SELECT * FROM guest;
SELECT * FROM pointitem
-- 고객테이블과 포인트상품테이블에서 고객이 포인트로 받을 수 있는 상품명과 고객의 이름, 고객의 포인트 조회하기.
--maria
SELECT g.name,g.point,p.name
FROM guest g,pointitem  p
WHERE g.point BETWEEN p.spoint AND p.epoint
--ansi
SELECT g.name,g.point,p.name
FROM guest g join pointitem  p
on g.point BETWEEN p.spoint AND p.epoint

-- 고객테이블과 포인트상품테이블에서 고객이 포인트로 받을 수 있는 상품명과 고객의 이름, 고객의 포인트 조회하기.
--단, 고객이 자기 포인트보다 낮은 포인트의 상품을 선택할 수 있다고 가정하자.
--외장하드를 선택할 수 있는 고객이름,고객의 포인트,포인트 상품명,시작포인트,종료포인트를 출력하기
SELECT g.name,g.point,p.name,p.spoint,p.epoint
FROM guest g,pointitem  p
WHERE  g.point>=7001 and p.spoint AND p.name='외장하드'
--maria
SELECT g.name,g.point,p.name,p.spoint,p.epoint
FROM guest g,pointitem  p
WHERE g.point >= p.spoint AND p.name= '외장하드'
--ansi
SELECT g.name,g.point,p.name,p.spoint,p.epoint
FROM guest g join pointitem  p
ON  g.point >= p.spoint AND p.name= '외장하드'

--문제 
--1.낮은포인트 상품을 가져 갈수 있다고 가정할때, 개인별로 가져갈 수 있는 고객명,고객의포인트,상품의 갯수를 출력하기 
--가져갈 수 있는 상품의 갯수의 역순으로 정렬하여 출력하기 
SELECT g.name 고객명,g.point 고객포인트,COUNT(*) '가져갈 수 있는 상품의 갯수'
FROM guest g,pointitem  p
WHERE g.point >= p.spoint 
GROUP BY g.name
ORDER BY COUNT(*) DESC
--2. 고객테이블과 상품테이블을 조인하여, 고객의포인트로 받을 수 있는 상품명을 출력하기 고객이 자기포인트 보다 낮은 포인트의 상품을 선택할 수 있을 때
--고객명,고객의포인트,상품의 갯수 조회하기. 2개이상의 상품을 가져갈 수 있는 고객만 조회하기.
SELECT  g.name 고객명,g.point 고객포인트,COUNT(*) '가져갈 수 있는 상품의 갯수'
FROM guest g,pointitem  p
WHERE g.point >= p.spoint 
GROUP BY g.name
HAVING COUNT(*)>=2
ORDER BY COUNT(*) DESC

SELECT * FROM scorebase
--3.학생의 학번,이름,국어,수학,영어 성적,총점,평균,학점 출력하기
--학점은 scorebase를 이용하기.
SELECT st.studno 학번,st.NAME 이름,sc.kor 국어,sc.math 수학,sc.eng 영어,sc.kor+sc.math+sc.eng 총점,ROUND((sc.kor+sc.math+sc.eng)/3) 평균,sb.grade 학점
FROM scorebase sb,score sc,student st
WHERE st.studno=sc.studno AND ROUND((sc.kor+sc.math+sc.eng)/3) >= sb.min_point AND ROUND((sc.kor+sc.math+sc.eng)/3) <= sb.max_point

SELECT st.studno 학번,st.NAME 이름,sc.kor 국어,sc.math 수학,sc.eng 영어,sc.kor+sc.math+sc.eng 총점,ROUND((sc.kor+sc.math+sc.eng)/3) 평균,sb.grade 학점
FROM scorebase sb,score sc,student st
WHERE st.studno=sc.studno AND ROUND((sc.kor+sc.math+sc.eng)/3) BETWEEN sb.min_point AND sb.max_point


--4. 3번문제에서 학점별인원수, 학점별 평균점수의 평균을 출력하기
SELECT sb.grade 학점,COUNT(*) 학점별인원수,AVG(ROUND((sc.kor+sc.math+sc.eng)/3)) '학점별 평균점수의 평균'
FROM scorebase sb,score sc
WHERE sc.studno AND ROUND((sc.kor+sc.math+sc.eng)/3) >= sb.min_point AND ROUND((sc.kor+sc.math+sc.eng)/3) <= sb.max_point
GROUP BY sb.grade


/*
	outer join: 양쪽 테이블의 조인컬럼 조건에 맞는 경우만 레코드가 조회됨 => inner join
					조건에 맞지 않아도 한쪽 테이블의 레코드는 조회 가능 => outer join
	left outer join: 왼쪽 테이블의 모든 레코드 조회
	right outer join: 오른쪽 테이블의 모든 레코드 조회
	full outer join: 양쪽 테이블의 모든 레코드 조회
							구현되지 않음. union 명령어를 사용해야 함.
*/
--학생의 이름과 지도교수이름을 출력하기 조건에 맞느경우만 조회
SELECT s.name,p.name FROM student s,professor p
WHERE s.profno=p.no

--left outer join
--학생의 이름과 지도교수이름을 출력하기 단, 지도교수가 없는 학생도 출력하기
--maria
SELECT s.name,p.name FROM student s left join professor p
on s.profno=p.no

SELECT s.name,p.name FROM student s LEFT JOIN professor p
ON s.profno=p.no
--ansi
SELECT s.name,p.name FROM student s left outer join professor p
on s.profno=p.no

--오라클 방식. 마리아 디비 오류
SELECT s.name,p.name FROM student s ,professor p
on s.profno=p.no(+)

--right outer join(오른쪽에있는 테이블다나오게)
--학생의 이름과 지도교수이름을 출력하기 단, 지도학생이 없는 교수도 출력하기
SELECT s.name,p.name FROM student s right join professor p
on s.profno=p.no

SELECT s.name,p.name FROM student s RIGHT outer join professor p
on s.profno=p.no

--오라클방식
SELECT s.name,p.name FROM student s RIGHT outer join professor p
on s.profno(+)=p.no

--full outer join (양쪽 다나오도록)
--학생의 이름과 지도교수이름을 출력하기 단, 지도학생이 없는 교수와 지도교수가 없는 학생  출력하기
SELECT s.name,p.name FROM student s left join professor p
on s.profno=p.no
UNION
SELECT s.name,p.name FROM student s right  join professor p
on s.profno=p.no
-- =========================================================>>> full outer join

--문제
--1.emp,p_grade 테이블을 조인하여 사원이름,직급,현재연봉,해당 직급의 연봉하한,연봉 상한 출력하기
--연봉은 급여*12+bonus *10000 으로 계산한다.
--단 모든 사원을  출력하기 outer join
SELECT e.ename,e.job,(e.salary*12+ifnull(bonus,0))*10000 현재연봉,p.s_pay 연봉하한,p.e_pay 연봉상한
FROM emp e left outer join p_grade p
on e.job = p.position

--2.emp,p_grade 테이블을 조인하여 사원이름,입사일,근속년도,현재직급,예상직급 출력하기 
--근속년도는 오늘을 기준으로 입사일사이의 일자/365로 나눈 후 소숫점이하는 버림 
--단 모든 사원을 출력하기 
SELECT e.ename  사원이름,e.hiredate  입사일,TRUNCATE(DATEDIFF(NOW(),e.hiredate)/365,0) 근속년도,e.job 현재직급,p.position 예상직급
FROM emp e LEFT join p_grade p
ON TRUNCATE(DATEDIFF(NOW(),hiredate)/365,0) BETWEEN p.s_year AND p.e_year

--3. emp,p_grade 테이블을 조인하여 사원이름,생일,나이,근속년도,현재직급,예상직급 출력하기 
--나이는 오늘을 기준으로 생일 사이의 일자/365로 나눈 후 소숫점이하는 버림 
--단 모든 사원을 출력하기 
SELECT e.ename ,e.birthday ,TRUNCATE(DATEDIFF(NOW(),birthday)/365,0) 나이,TRUNCATE(DATEDIFF(NOW(),hiredate)/365,0) 근속년도,p.position 현재직급
FROM emp e LEFT OUTER join p_grade p
ON TRUNCATE(DATEDIFF(NOW(),hiredate)/365,0) BETWEEN p.s_age AND p.e_age

--사원테이블에서 사원번호,사원명,상사명 출력하기
--단 모든 직원을 출력하기 //self 조인도 outer join 가능
SELECT e1.empno,e1.ename,e2.ename FROM emp e1 LEFT JOIN emp e2 
ON e1.mgr=e2.empno

SELECT * FROM major
--1. major 테이블에서 학과코드,학과명,상위학과코드, 상위학과명 출력하기
--단 모든 학과 조회하기.
SELECT m1.CODE,m1.NaME,m1.part,m2.NAME 
FROM major m1 left join major m2
ON m1.part=m2.code

--2. 교수번호,이름,입사일,자신보다 입사일이 빠른사람의 인원 수 출력하기.
--단 모든 교수를 조회하기. count null값 계산X 
SELECT p1.NO,p1.NAME,p1.hiredate,COUNT(p2.hiredate) FROM professor p1 LEFT  OUTER  JOIN professor p2
ON p1.hiredate > p2.hiredate
GROUP BY p1.name
ORDER BY p1.hiredate

SELECT * FROM professor

/*
	Join: 여러개의 테이블 연결하여 조회하기 
		cross join : 모든 레코드를 조회하기, m*n개의 레코드가 생성 
		등가조인: 조인컬럼의 값을 = 연산자로 비교, 조건문이 맞는 경우 레코드를 선택 
		비등가조인: 조인컬럼의 값을 <,>,>=,<= 연산자로 비교, 조건문이 맞는 경우 레코드를 선택 
		self 조인: 연결되는 테이블이 같은 경우.
					  반드시 alias를 기술해야한다.
					  조인컬럼은 같은 테이블의 다른 컬럼으로 정한다.
		outer 조인: left,right, full join 조건이 맞지 않아도 한쪽,양쪽 테이블 모두 조회.
		inner 조인: left,right, full join 조건이 맞는 경우 테이블 모두 조회.
*/
/*
	subquery: select 내부에 select 구문이 존재함 (대용량에서 쓰면 성능이 떨어짐)
				 where 조건문에 사용되는 select 구문 
	 단일행 subquery : where 조건문에 사용된 select 구문의 결과가 한개인 경우
	 				사용되는 연산자: =, >= ,<= ,> ,< 
	 복수행 subquery : where 조건문에 사용된 select 구문의 결과가 여러개인 경우
	 				사용되는 연산자: in, any, all
	 				in : 그 중 한개와 같은 경우 
	 				any: 그 중 한개보다 클때. 가장 작은 값보다 클때
	 				all: 모든 값보다 클때. 가장 큰 값보다 클때
*/

--emp 테이블에서 이혜라 사원보다 많은 급여를 받는 직원의 정보 출력하기 
SELECT salary FROM emp WHERE NAME='이혜라'
SELECT * FROM emp WHERE salary>600
==>서브쿼리
SELECT * FROM emp WHERE salary >(SELECT salary FROM emp WHERE eNAME='이혜라')


--문제 
--1.학생 중 김종연 학생보다 윗학년의 이름과,학년,전공1코드,전공1학과명 출력하기.
SELECT st.NAME,st.grade,st.major1,m.name FROM student st ,major m
WHERE st.major1=m.code AND grade > (SELECT grade FROM student WHERE NAME='김종연')
--2.학생 중 김종연 학생과 같은 학과 학생의 이름과,학년,전공1코드,전공1학과명 출력하기.
SELECT st.NAME,st.grade,st.major1,m.name FROM student st ,major m
WHERE st.major1=m.code AND major1 = (SELECT major1 FROM student WHERE NAME='김종연')
--3. 사원중 사원의 평균 급여 미만의 급여를 받는 사원의 번호, 이름, 직급, 급여를 출력하기.
SELECT empno,ename,job,salary FROM emp WHERE salary < (SELECT AVG(salary) FROM emp WHERE job='사원')

SELECT empno,ename,job,salary FROM emp WHERE salart<(SELECT AVG(salary) FROM emp WHERE job=
--복수행 서브쿼리
--emp ,dept 테이블을 이용하여 근무지역이 서울인 사원의 사번,이름,부서번호,부서명 추력하기
SELECT e.empno,e.ename,d.deptno,d.dname FROM emp e,dept d
 WHERE  e.deptno=d.deptno AND e.deptno IN(SELECT deptno FROM dept where loc='서울')

--1학년 학생과 같은 키를 가지고 있는 2학년 학생의 이름,키,학년 출력하기
SELECT NAME,height,grade 
FROM student
WHERE grade=2 AND height IN(SELECT height FROM student WHERE grade=1)

--사원테이블에서 사원직급의 최대 급여보다 급여가 높은 사람의 이름, 직급,급여 출력하기
SELECT ename,job,salary FROM emp 
where salary> all(SELECT salary FROM emp WHERE job='사원')

SELECT ename,job,salary FROM emp 
where salary> (SELECT max(salary) FROM emp WHERE job='사원')

--사원테이블에서 사원직급의 최소  급여보다 급여가 높은 사람의 이름, 직급,급여 출력하기
SELECT ename,job,salary FROM emp 
where salary> any (SELECT salary FROM emp WHERE job='사원')

SELECT ename,job,salary FROM emp 
where salary> (SELECT min(salary) FROM emp WHERE job='사원')


--학생 중 4학년 학생의 최소 체중보다 체중이 적은 학생의 이름,체중을 출력하기.
SELECT NAME,weight FROM student WHERE weight < (SELECT MIN(weight) FROM student WHERE grade=4) 

SELECT NAME,weight FROM student WHERE weight < all (SELECT weight FROM student WHERE grade=4) 

--학년별로 최대키를 가진 학생의 학년과 이름, 키를 출력하기
--1학년중 최대키를 가진 학생 조회
SELECT grade, NAME,height FROM student WHERE height = (SELECT MAX(height) FROM student WHERE grade=1)
AND grade =1

selecct NAME,height WHERE hieght=(SELECT MAX(height) FROM student WHERE grade=1)AND grade=1

--다중 컬럼 서브쿼리: 비교 대상과 컬럼이 두개 이상임.
							--any와 all 을 사용불가.

--학년별로 최대키를 가진 학생의 학년과 이름,키를 출력하기
SELECT grade,NAME,height FROM student
WHERE (grade,height) IN(SELECT grade,MAX(height) FROM student GROUP BY grade)

--문제
--1.학과별로 입사일이 가장 오래된 교수의 교수번호,이름,입사일,학과명 출력하기 
SELECT p.NO,p.NAME,hiredate,m.name FROM professor p,major m
WHERE p.deptno=m.code AND (deptno,hiredate) in(select deptno,min(hiredate) FROM professor GROUP BY deptno)

--2.emp 테이블에서 직급별로 해당 직급의 최대 급여를 받는 직원의 이름,직급,급여 출력하기
SELECT ename,job,salary FROM emp WHERE (job,salary) IN(SELECT job,MAX(salary) FROM emp GROUP BY job)

--3.emp 테이블에서 부서별 평균 연봉 중 가장 작은 평균 연봉보다 적게 받는 직원의 직원명,부서명,연봉출력하기
--연봉은 급여*12+bonus 보너스가 없으면 0으로 처리하기.

SELECT e.ename,d.dname,salary*12+IFNULL(bonus,0) 
FROM emp e,dept d 
WHERE e.deptno = d.deptno
AND salary*12+IFNULL(bonus,0) 
	<all (SELECT avg(salary*12+IFNULL(bonus,0)) FROM emp GROUP BY deptno)
	
	