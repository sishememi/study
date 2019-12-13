/*desc:테이블의 구조 조회 
	desc 테이블이름  =>해달 테이블의 구조(스키마)조회 
 	스키마:컬럼의 이름,자료형,키여부,default값 조회 
	 */
DESC emp
DESC dept

/*
	사원테이블(emp)의 모든 컬럼과 모든 레코드 조회하기 
	select 구문 
	select * || 컬럼이름들 from 테이블이름(컬럼선택)
	[where 조건문] <=조건문이 없으면 모든 레코드 선택 
					 <=조건문이 있으면 조건을 참으로 하는 row만 선택
					 */
SELECT * FROM emp

/*emp 테이블에서 사원번호(empno),사원이름(ename),직급(job) 컬럼을 조회 */
SELECT empno,ename,job FROM emp

/*emp 테이블에서 사원번호(empno),사원이름(ename),급여,부서코드  컬럼을 조회 */
SELECT empno,ename,salary,deptno FROM emp

/*emp 테이블에서 모든 컬럼을 조회,단 deptno가 10인 부서의 레코드만 조회 */
SELECT * FROM emp 
WHERE deptno = 20

/*
	리터널 컬럼: 상수값 
*/
SELECT empno,ename,'사원'/*<=리터럴 컬럼*/ FROM emp

/*
 	1.문제: 교수 테이블(professor)에서 교수번호(no),교수이름(name),'교수' 로 출력하기 
 	2.문제: 학생 테이블(student)에서 학번(studno),학생이름(name),'학생'으로 출력하기 
 	3.문제: 학과 테이블(major)에서 학과번호(code),학과명(name) 컬럼 출력하기 
 */
 SELECT NO,NAME,'교수' FROM professor
 SELECT studno,NAME, '학생' FROM student
 SELECT CODE,NAME FROM major 
 
 
 /*
 	컬럼에 별명(alias) 주기: 조회된 컬럼이름 변경하기 
 */
SELECT NO 교수번호  ,NAME 교수이름 FROM professor
SELECT NO "교수 번호",NAME "교수 이름" FROM professor /*띄어쓰기 가능하기위해 '' 를 사용한다. */
SELECT NO AS "교 수 번 호",NAME AS "교 수 이 름" FROM professor

/*
	컬럼에 연산자 사용하기:변경된 컬럼의 값을 조회할 수 있다.
	*/
/*사원테이블에서 사원이름,현재 급여,10%인상예정급여 조회하기*/

SELECT ename '사원 이름',salary '현재 급여',salary*1.1 '10%인상 예정급여' FROM emp

/*문제 
1.교수 테이블에서 교수번호(no),교수이름(name),현재급여(salary),5%인상예정급여 조회하기 
2.교수 테이블에서 교수번호(no),교수이름(name),연봉  조회하기 
	단, 연봉은 급여*12로 한다.
	*/
SELECT NO 교수번호,NAME 교수이름,salary 현재급여,salary*1.05 "5%인예정급여" 
FROM professor

SELECT NO 교수번호,NAME 교수이름,salary*12 연봉 
FROM professor

/*
 distinct :중복을 제거하여 조회,select 다음에 한번만 사용가능 
*/
--교수가 속한 부서 코드를 조회하기 
SELECT distinct deptno FROM professor
--교수의 직급을 조회하기 
SELECT distinct POSITION FROM professor

--교수의 부서별 직급 조회하기 
SELECT  distinct deptno, POSITION FROM professor 

--where 조건문:레코드를 선택하는 조건. 
--      		 where 조건문이 없는 경우는 모든 레코드를 조회.
--				 where 조건문이 있는 경우는 조건이 참인 레코드만 조회.

--1학년 학생의 모든 컬럼을 조회하기.
SELECT * FROM student WHERE grade = 1

--2학년 학생의 학번,학생이름,학년,전공 1코드 컬럼을 조회하자 
SELECT studno 학번,name 학생이름 ,grade 학년,major1 전공 
FROM student WHERE grade = 2 

--3학년 학생 중 전공 1코드가 101학과  
--학생의 학번,학생이름,학년,전공1코드 컬럼을 조회하기 
SELECT studno 학번,name 학생이름 ,grade 학년,major1 전공 
FROM student WHERE grade = 3 AND major1 = 101

--3학년 학생 이거나  전공 1코드가 101학과  
--학생의 학번,학생이름,학년,전공1코드 컬럼을 조회하기 
SELECT studno 학번,name 학생이름 ,grade 학년,major1 전공 
FROM student WHERE grade = 3 OR  major1 = 101
/*
문제 
1. emp테이블에서 부서코드가 10인 사원의 이름(ename),급여(salary),부서코드(deptno)조회하기 
2. emp 테이블에서 급여가 800보다 큰사람의 이름(ename),급여(salary),부서코드(deptno)조회하기 
3. professor 테이블에서 직급(position)이 정교수인 교수의 이름(name),부서코드(deptno),직급(positon) 조회하기
*/
 
SELECT ename 이름,salary 급여,deptno 부서코드 FROM emp WHERE deptno = 10
SELECT ename 이름,salary 급여,deptno 부서코드 FROM emp WHERE salary >= 800
SELECT NAME 교수이름,deptno 부서코드 ,POSITION 직급 FROM professor WHERE POSITION = "정교수"

--emp 테이블에서 모든 사원의 급여를 10% 인상할때 인상예정급여가 1000만원 이상인 사원의 이름,현재급여,인상예상급여,부서코드 조회
SELECT ename 이름,salary 현재급여 ,salary*1.1 인상예상급여,deptno 부서코드 FROM emp 
WHERE salary*1.1 >= 1000


/*
	where 조건절에서 사용되는 연산자
	between 연산자 
    
	.....
	where 컬럼명 between A and B :컬럼의 값이 A이상B이하인 레코드 선택
		where 컬럼명>= A and 컬럼명 <= B
*/
--1학년 학생과 2학년 학생의 모든 컬럼을 조회하자
SELECT * FROM student WHERE grade BETWEEN 1 AND 2
SELECT * FROM student WHERE grade >= 1 AND grade <= 2

/*
문제 
1. 1학년 학생 중 몸무게가 70이상 80 이하인 학생의 이름,학년 ,몸무게, 전공학과1 조회하기 
2.전공학과1이  101인 학생중 키가 160이상 180이하인 학생의 이름,학년,키, 전공학과1 조회하기 
*/
SELECT NAME 이름,grade 학년, weight 몸무게, major1 전공학과1 FROM student 
WHERE  grade = 1 and weight between 70 AND 80
SELECT NAME 이름,grade 학년, weight 몸무게, major1 전공학과1 FROM student 
WHERE  grade = 1 and weight >= 70 AND weight <= 80

SELECT NAME 이름,grade 학년,height 키, major1 전공학과1 FROM student
WHERE major1 = 101 and height BETWEEN 160 AND 180
SELECT NAME 이름,grade 학년,height 키, major1 전공학과1 FROM student
WHERE major1 = 101 and height >= 160 AND height <= 180


/*
	in 연산자: or조건문을 표현할 수 있다.
*/

--전공1학과가 101번,201인 학과의 학생을 조회하기.
SELECT * FROM student 
WHERE major1 IN(101,201)

SELECT * FROM student 
WHERE major1 = 101 or major1 = 201

--교수중 학과코드가 101,201 학과에 속한 교수의 교수번호,교수이름,학과코드
--입사일(hiredate)를 조회하기
SELECT NO 교수번호,NAME 교수이름,deptno 학과코드,hiredate 입사일 FROM professor
WHERE deptno IN(101,201) --WHERE deptno = 101 or deptno = 201도 가능

/*
	like 연산자: 
	%:0개 이상의 임의의 문자
	_:1개의 임의의 문자
*/

--학생의 성이 김씨인 학생의 학번,이름,학과코드를 조회하기
SELECT studno,NAME,major1 FROM student
WHERE NAME LIKE "김%"

--학생의 이름에 '진' 글자가 포함된 학생의 학번,이름,학과코드를 조회하기
SELECT studno,NAME,major1 FROM student
WHERE NAME LIKE "%진%"

--학생의 이름에 '진' 으로 끝나는 학생의 학번,이름,학과코드를 조회하기 
SELECT studno,NAME,major1 FROM student
WHERE NAME LIKE "%진"

--학생의 이름이 두글자인 학생의 학번,이름,학과코드를 조회하기 
SELECT studno,NAME,major1 FROM student
WHERE NAME LIKE "__"

--교수테이블에서 id컬럼에 k문자가 존재ㅐ하는 교수의 이름,id,직책(position) 조회하기
SELECT NAME 이름,id,POSITION 직책 FROM professor
WHERE id LIKE "%k%" --대소문자 구별 X

--대소문자 구문이 필요할때: binary 예약어 사용하기(오라클에서 사용안함) 
SELECT NAME 이름,id,POSITION 직책 FROM professor
WHERE id LIKE BINARY "%K%"

--IS NULL, IS NOT NULL
--NULL의 의미는 값이 없다 임.
--연산 또는 비교의 대상이 아니 다.
--null값과 연산후의 결과는 null
--교수 중 보너스가 없는 교수의 이름,급여,보너스를 조회하기 
SELECT NAME,salary,bonus FROM professor =>조회되는 값 없음
WHERE bonus = NULL 

SELECT NAME,salary,bonus FROM 
WHERE bonus IS NULL 
de
--교수 중 보너스가 있는 교수의 이름,급여,보너스를 조회하기 
SELECT NAME,salary,bonus FROM 
WHERE bonus IS not NULL 

--교수의 이름,급여,보너스,연봉을 조회하기 
--단 연봉은 급여*12 +보너스로 한다.
SELECT NAME,salary,bonus,salary*12+bonus  FROM professor

=====================================================================
SELECT empno 사원번호,ename 사원명,job 직급 FROM emp

SELECT deptno "부서#",dname 부서명,loc 부서위치 FROM dept

SELECT distinct profno FROM student
WHERE profno IS NOT  NULL 

SELECT NAME ,POSITION 직급  FROM professor

SELECT NAME 이름,birthday 생년월일,height "키(cm)" ,weight "몸무게(kg)" FROM student

SELECT NAME 이름,weight 몸무게,major1 학과코드 FROM student 
WHERE major1 IN(101,201) AND weight BETWEEN 50 AND 80 

SELECT ename 이름,salary 현재급여,salary*1.05 예상인상급여,deptno 부서코드 FROM emp 
WHERE salary >=700

SELECT NAME 이름,major1 전공코드, birthday 생일, grade 학년 FROM student
WHERE birthday >= '1998-06-30' AND grade = 1 

SELECT NAME 이름,major1 전공코드, birthday 생일, grade 학년 FROM student
WHERE birthday >= '1998-06-30' OR  grade = 1 

SELECT studno 학번,NAME 이름,weight 몸무게,height 키,major1 학과코드 FROM student
WHERE major1 IN (101,201) OR  height >= 170
