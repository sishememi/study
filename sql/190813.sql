/*
	1.테이블의 구조:desc
	2.테이블의 내용 조회:select
	select 컬럼명1,컬럼명2,...||* from 테이블명 
	[where 조건문]:레코드 선택 기준 
	[group by 컬럼명] 
	[having 조건문] : 그룹선택 기준 
	[order by 컬럼명] : 정렬 설정 반드시 쿼리 마지막에 사용 
	 
	3.컬 럼
		리터럴 커럼:상수 컬럼 
		별명 설정 
		얀산자 사용 가능 
		중복 제거: distinct
	4.where 조건문: 
		관계연산자(>,<,<=,>=...)
		논리연산자(and,or)
		컬럼명 between A and B
		IN : 값여러개를 or 조건으로 설정 
		LIKE , NOT LIKE :  % : 값이 0개 이상인 임의의 문자 
								 _ : 1개의 임의의 문자	 
		IS NULL, IS NOT NULL 
			NULL은 값이 없기때문에 불가능함.
*/

--정렬(SORT) 하기: order by 구문
--오름차순 정렬: ASC(기본값(default) 이므로 생략가능)
--내림차순 정렬: DESC
--select 구문의 마지막이 기술되어야 한다.

--1학년 학생의 이름과 키를 조회하기. 단 키가 큰 순으로 조회하기.
SELECT NAME 이름,height 키 FROM student
WHERE grade = 1 
ORDER  BY height DESC
 
SELECT NAME 이름,height 키 FROM student
WHERE grade = 1 
ORDER  BY 2 DESC --*컬럼1=이름 컬럼2=키 

SELECT NAME 이름,height 키 FROM student
WHERE grade = 1 
ORDER  BY 키 DESC 


/*
문제 
1. emp 테이블에서 사원이름,현재 급여, 인상예정급여를 조회하기 
	단, 인상예상급여는 현재급여에서 10%인상된 급여를 말한다.
	인상예상급여의 내림차순으로 조회하기	 
	 
*/
SELECT ename 사원이름,salary 현재급여, salary*1.1 인상예정급여 FROM emp
ORDER BY 3 DESC 

--학생들의 이름,학년,키를 학년 순으로 키가 큰순으로 조회하기
SELECT NAME 이름,grade 학년,height 키 FROM student
ORDER BY grade,height DESC

--학생들의 이름,학년 ,키를 학과 순으로 조회하기
SELECT NAME 이름,grade 학년 ,height 키 FROM student
ORDER BY major1

--합집합: union, union all
--		union :합집합, 중복 내용 제거.
--		union all :합집합 두개 쿼리의 결과를 합하여 출력함. 중복 제거 안됨.
--		조회되는 컬럼의 갯수가 똑같아야한다.


--전공1 학과가 202이거나, 전공2학과가 101인 학생의 학번,이름,전공1,전공2를 조회하기
SELECT studno 학번,NAME 이름,major1 전공1,major2 전공2 FROM student
WHERE major1=202 OR major2=101

--union
SELECT studno 학번,NAME 이름,major1 전공1,major2 전공2 FROM student
WHERE major1=202 
UNION all
SELECT studno 학번,NAME 이름,major1 전공1,major2 전공2 FROM student
WHERE major2=101

--union all
SELECT studno 학번,NAME 이름,major1 전공1,major2 전공2 FROM student
WHERE major1=202 
UNION all
SELECT studno 학번,NAME 이름,major1 전공1,major2 전공2 FROM student
WHERE major2=101

--학생 중 전공1학과가 101번학과인 학생의 학번,이름,전공1코드와 교수중 학과코드가
--101번 학과인 교수의 교수번호,이름,학과코드 조회하기 
SELECT "학생" 구분,studno ,NAME ,major1  FROM student WHERE major1=101
union
SELECT "교수",NO ,NAME,deptno  FROM professor WHERE deptno=101


/*
	문제 
	1.교수 중 급여가 450이상인 경우는 5%인상예정이고, 450미만인 경우는 10%인상 예정이다.
	교수번호,교수이름,현재급여,인상예정 급여 조회하기. 인상예정 급여가 큰순으로 정렬하기 

	2.교수 중 보너스가 있는 교수의 연봉은 급여*12+보너스이고, 
	보너스가 없는 교수의 연봉은 급여*12로 한다. 교수번호,교수이름,급여,보너스,연봉 
	조회하기. 단, 연봉순으로 정렬하기.
*/
SELECT NO 교수번호, NAME 교수이름,salary  현재급여,salary*1.05 인상예정급여 FROM professor
WHERE salary>=450
UNION
SELECT NO , NAME ,salary  ,salary*1.1  FROM professor
WHERE salary<450
ORDER BY 4 DESC 

SELECT NO 교수번호, NAME 교수이름,salary 급여,bonus 보너스,salary*12+bonus 연봉 FROM professor
WHERE bonus IS NOT NULL
UNION
SELECT NO, NAME ,salary,bonus ,salary*12  FROM professor
WHERE bonus IS NULL 
ORDER BY 5


/*함수 
	단일행함수: 하나의 레코드에서만 사용이 되는 함수.
	그룹함수: 여러 행에 관련된 기능을 처리하는 함수.
*/

--문자 관련 함수: 문자열에서 사용되는 함수 
--대소문자 변환 함수: upper,lower

--학과번호가 101학과인 학생의 이름,id,대문자id,소문자id를 조회하기 
SELECT NAME,id,UPPER (id),LOWER (id) FROM student
WHERE major1=101

--문자열 길이 함수: length,char_length
-- length : 문자열의 바이트 수 
-- char_length: 문자열의 갯 수 
 
--학생의 이름,아이디,이름글자수,이름바이트수 조회하기
SELECT NAME,id,CHAR_LENGTH(NAME),LENGTH(id) FROM student

--문자열 연결 함수: concat

--교수의 이름과 직급을 연결하여 조회하기 
SELECT NAME,POSITION FROM professor
SELECT concat(NAME,POSITION,'님')정보 FROM professor

--문제 
--학생 정보를 다음예와 같이 조회하기 
SELECT CONCAT(NAME,grade,'학년')이름, CONCAT(height,'cm')키,CONCAT(weight,'kg')몸무게 FROM student

--부문 문자열 
--	substr(컬럼명,시작인덱스, 글자수)
--	left(컬럼명,글자수):왼쪽부터 글자수만큼 부분 문자열로 리턴 
--	right(컬럼명,글자수):오른쪽부터 글자수만큼 부분 문자열로 리턴 

--학생의 이름만 조회하기. 이름은 두자로 한다.
SELECT RIGHT(NAME,2) FROM student

--학생의 이름과,주민번호 기준 생일부분만 조회하기 
SELECT NAME 이름,left(jumin,6)생년월일  FROM student
SELECT NAME 이름,substr(jumin,1,6)생년월일  FROM student

--학생의 이름과, 주민번호기준 성별부분만 조회하기 
SELECT NAME 이름, substr(jumin,7,1)성별 FROM student 

--문제
--1.학생 중 생일 3월인 학생의 이름,생년월일 조회하기 단,생일은 주민번호 기준으로 한다.
--2.학생의 이름, 생년월일을 98년 02월 20일의 형식인 생년월일과,학년을 출력하자.
-- 	단,생년월일은 주민번호 기준으로. 월을기준으로 정렬하여 출력하기.
SELECT NAME 이름,LEFT(jumin,6)생년월일 FROM student
WHERE substr(jumin,4,1)=3

SELECT NAME 이름,CONCAT(SUBSTR(jumin,1,2),'년',SUBSTR(jumin,3,2),'월',SUBSTR(jumin,5,2),'일')생년월일,grade 학년 FROM student
ORDER BY SUBSTR(jumin,3,2)