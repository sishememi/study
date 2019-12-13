--복습 
/*
	order by:정렬 설정 
		select 구문의 마지막에 기술되어야 한다.
		ASC:오름차순 정렬
		DESC:내림차순 정렬
		order by 컬럼1,컬럼2 => 컬럼1 1차 정렬, 컬럼2 2차 정렬
		
	집합연산자:
		union :합집합
		union all : 합집합,중복 제거 안됨, 단순히 결과를 연결하여 조회.
		=> 두 개의 select 문의 조회되는 컬럼의 수가 같아야 한다.
		
	함수: 단일행 함수, 그룹함수
		-문자열 관련 함수
			대소문자변경: upper,lower
			문자열의 길이: length(문자열의 바이트수), char_length(문자열의 길이)
			부분문자열: substr,left,right	
							substr(컬럼,시작인덱스,갯수) => 갯수 생략시 이후 문자열 전부
							left(컬럼,갯수) => 왼쪽에서 갯수만큼 부분 문자열 리턴
							right(컬럼,갯수) => 왼쪽에서 갯수만큼 부분 문자열 리턴
			문자열 연결함수 : concat				
*/

--문자열에서 문자의 위치: instr
--	 	instr(컬럼,문자)

--학생 테이블에서 이름,전화번호,')'문자의 위치를 조회하기 
SELECT NAME,tel,INSTR(tel,')') ')위치조회' FROM student

--교수테이블에서 교수의이름,url,hompage 출력하기 
--homepagesms url에서 http://이후문자열의미 
SELECT NAME,url,SUBSTR(url,8)hompage FROM professor
SELECT NAME,url,SUBSTR(url,INSTR(url,'/')+2)hompage FROM professor

--문제 
--1.학생의 이름, 전화번호, 지역번호 조회하기 
--지역번호는 02,031 전화번호에서 ) 앞의 문자를 의미한다.
SELECT NAME,tel,left(tel,INSTR(tel,')')-1)지역번호 FROM student


--문자 추가함수:lpad, rpad
--  lpad:왼쪽에 문자를 추가. lpad(컬럼,전체자리수,채울문자)
--  rpad:오른쪽에 문자를 추가. rpad(컬럼,전체자리수,채울문자)

--학생의 학번과 이름을 출력하기. 학번은 10자리로 빈자리는 오른쪽에 *로 채워 출력하기 
SELECT rpad(studno,10,'*')학번,NAME FROM student

--교수테이블에서 이름,직급을 출력하기. 직급은 12자리로 출력하되 빈자리는 왼쪽에
--*로 채워 출력하기
SELECT NAME,LPAD(POSITION,12,'*')직급 FROM professor


--문자제거함수: trim,rtrim,ltrim
--	rtrim: 오른쪽 공백 제거 
--	ltrim: 왼	쪽 공백 제거 
--	trim: 양쪽 지정된 문자 제거	

--00012000056700000 문자의 양쪽0을 제거하기 
SELECT TRIM(BOTH '0' FROM '00012000056700000')
--00012000056700000 문자의 오른쪽0을 제거하기 
SELECT TRIM(TRAILING '0' FROM '00012000056700000')
----00012000056700000 문자의 왼쪽0을 제거하기 
SELECT TRIM(LEADING '0' FROM '00012000056700000')

--교수테이블에서 url컬럼에서 http://가 제거된 homepage를 출력하기
SELECT TRIM(LEADING 'http://' FROM url)homepage  from professor 

--왼쪽 공백 제거
SELECT LTRIM("        왼쪽 공백  제거          ")
SELECT CONCAT("******",LTRIM("        왼쪽 공백 제거         "),"-*****")
--오른쪽 공백 제거
SELECT RTRIM("        오른쪽쪽 공백  제거               ")
SELECT CONCAT("******",RTRIM("        왼쪽 공백 제거         "),"-*****")
--양쪽 공백 제거
SELECT CONCAT("******",TRIM(BOTH" " FROM "        왼쪽 공백 제거         "),"*****")
 
 
--문자 치환 함수: replace
--replace(컬럼,'문자1','문자2') => 컬럼에서 문자1을 문자2로 변경 

--학생의 이름을 성부분 한자만 # 문자로 치환하여 출력하기 
SELECT NAME,REPLACE(NAME,lefT(NAME,1),'#') FROM student

--문제 
--1. 101학과 학생의 이름과 주민번호 출력하기 단,주민번호 뒤 6자리는 *로 출력하기 
SELECT NAME,REPLACE(jumin,substr(jumin,7,12),"******") FROM student WHERE major1 = 101

SELECT NAME,CONCAT(LEFT(jumin,7),"******") from student WHERE major1 = 101


/*
	숫자 관련 함수 
*/
--반올림 함수 
-- round(숫자) : 소숫점 이하 첫째자리에서 반올림. 소숫점 제거 
-- round(숫자1,숫자2): 숫자1을 소숫점이하 숫자2+1 자리에서 반올림.
--							  소숫점 이하 숫자2만큼 출력  //소숫점 위치가 기준=0
SELECT ROUND(122.113456,-1)r1,ROUND(122.113456)r2,ROUND(122.113456,0)r3,
ROUND(122.113456,1)r4,ROUND(122.113456,2)r5,ROUND(122.113456,5)r6;

--버림함수 
--truncate(숫자1,숫자2): 숫자 1을 소숫점이하 숫자2자리까지 출력 
--							 	이후 숫자는 버림. 숫자2는 반드시 써야한다.
SELECT truncate(122.113456,-1)r1,truncate(122.113456,0)r3,
truncate(122.113456,1)r4,truncate(122.113456,2)r5,truncate(122.113456,5)r6

-- 교수의 급여를 15%인상하여 정수로  출력하기 
--교수이름,현재급여,반올림예상급여,절삭된예상급여 
SELECT NAME,salary,salary*1.15,round(salary*1.15),truncate(salary*1.15,0) FROM professor


SELECT * FROM score
--문제 
--1.score 테이블에서 학생의 학번,국어,영어,수학 총점 평균 출력하기 
-- 	단, 평균은 소숫점이하 2자리까지만 반올림하여 출력하기 
--총점의 내림차순 정렬하기 
SELECT *,(math+kor+eng)총점,round((math+kor+eng)/3,2) 평균  from score
ORDER BY 1 DESC 


--근사정수: 가장가까운 정수
--ceil: 큰 근사정수 
--floor: 작은 근사정수
SELECT ceil(122.113456)r1,floor(122.113456)r3,
FLOOR(-122.113456)r4,CEIL(-122.113456)r5


--나머지 함수:mod
--제곱함수:power
SELECT MOD(21,8),POWER(3,3)

/*
	날짜함수
		현재 날짜: now(),curdate(),current_date,current_date()
oracle에서 : sysdate 예약어로 사용함.now()와 같은기능 
*/
SELECT now(),curdate(),current_date,CURRENT_DATE() 

--datediff: 날짜 사이의 일자수 리턴
SELECT NOW(),'2019-01-01',DATEDIFF(NOW(),'2019-01-01')
SELECT DATEDIFF('2019-08-15','2019-08-14'),DATEDIFF('2019-08-14','2019-08-15')

--생일에서 현재까지의 일수 계산하기
SELECT DATEDIFF(NOW(),'1996-04-08')
--학생의 이름과,생일,학생의 생일부터 현재까지의 일수 조회하기
SELECT NAME,birthday,DATEDIFF(NOW(),birthday)일수  FROM student
--학생 중 생일이 1996년 이후에 태어난 학생의 이름과 생일 출력하기
SELECT NAME,birthday FROM student
WHERE birthday >= '1996-01-01' /*ex)2018-08-14의 형식은 db에서 날짜로변환하여 인식한다*/

--문제
--1.학생의 이름과 생일,현재까지의 개월수와 나이를 출력하기
--개월수는 일수/30 나누어 계산,나이는 일수/365로 나누어 계산
--개월수 와 나이는 반올림하여 정수로 출력하기

--2.교수의 이름과, 직급,hiredate,입사개월수,입사년수를 출력하기
--입사개월수는 일수/30으로 계산. 입사년수는 일수/365로 계산
--입사개월수와 입사년수는 절삭하여 정수로 출력하기 

SELECT NAME birthday,round(DATEDIFF(NOW(),birthday)/30)개월수 , round(DATEDIFF(NOW(),birthday)/365)나이  from student

SELECT NAME,POSITION,hiredate,TRUNCATE(DATEDIFF(NOW(),hiredate)/30,0)입사개월,TRUNCATE(DATEDIFF(NOW(),hiredate)/365,0)입사년수 FROM professor
/*
	year: 년도 
	month: 월
	day: 일
	weekday: 요일 0:월,1:화,...6:일
	DAYOFWEEK: 요일  1:일,2:월,...7:토
	week: 일년 중 몇번째 주 
	last_day: 해당월의 마지막 일자 
*/

SELECT YEAR(NOW()),month(NOW()),day(NOW()),weekday(NOW()),DAYOFWEEK(NOW()),
week(NOW()),last_day(NOW())

--교수이름,입사일,입사년도의 휴가 보상일, 올해의 휴가보상일 출력하기
--휴가보상일 입사월의 마지막 일자 
SELECT NAME,hiredate,LAST_DAY(hiredate),
LAST_DAY(concat(YEAR(NOW()),"-",MONTh(hiredate),"-01")) FROM professor

--문제 
--1.교수테이블에서 입사일이 1-3월인 모든 교수의 급여를 15%인상하여 정수로 출력
--단,반올림된 인상급여, 절삭된 인상급여 출력하기.
--교수의 이름,급여,반올림인상급여,절삭인상급여,급여소급일 출력하기 
--급여소급일은 올해 입사월의 마지막날로 한다.

SELECT NAME 이름,salary 급여,ROUND(salary*1.15)인상급여,TRUNCATE(salary*1.15,0),
 LAST_DAY(concat(YEAR(NOW()),"-",MONTh(hiredate),"-01"))FROM professor
 WHERE MONTH(hiredate) BETWEEN '1' AND '3'
 

-- 이전 이후 날짜: date_add, date_sub
-- 현재시간 기준 1 일 이후 날짜 
SELECT NOW(),DATE_ADD(NOW(),INTERVAL 1 DAY)
-- 현재시간 이후 1일 이전 날짜 
SELECT NOW(),DATE_sub(NOW(),INTERVAL 1 DAY)
-- 현재 시간 기준 1 시간 이전 
SELECT NOW(),DATE_sub(NOW(),INTERVAL 1 HOUR)
-- 현재 시간 기준 1 분 이전
SELECT NOW(),DATE_sub(NOW(),INTERVAL 1 minute)
-- 현재 시간 기준 1 초  이전 
SELECT NOW(),DATE_sub(NOW(),INTERVAL 1 second)
-- 현재 시간 기준 1 달 이전 
SELECT NOW(),DATE_sub(NOW(),INTERVAL 1 MONTH)
-- 현재 시간 기준 1 년  이전 
SELECT NOW(),DATE_sub(NOW(),INTERVAL 1 YEAR)


--문제
--1.현재기준 10일 이후 일자의 해당월의 마지막 날짜,
--	 현재기준 20일 이후 일자의 해당월의 마지막 날짜 조회하기
SELECT NOW(),last_day(DATE_ADD(NOW(),INTERVAL 10 DAY))'10일이후',last_day(DATE_ADD(NOW(),INTERVAL 20 DAY))'20일이후'
--2.교수의 정식 입사일은 입사일의 3개월 이후다.
--	교수번호,이름,입사일, 정식입사일 조회하기 
SELECT NO,NAME,hiredate,DATE_ADD(hiredate,INTERVAL 3 MONTH)정식입사일 FROM professor
--3.사원의 정식 입사일은 입사일의 2개월 이후 다음달의 1일로 한다.
--	사원번호,이름,입사일, 정식입사일 조회하기 

SELECT empno,eNAME,hiredate,concat(year(hiredate),"-0",month(DATE_ADD(hiredate,INTERVAL 3 MONTH)),"-01")정식입사일 FROM emp
--or
SELECT empno,eNAME,hiredate,last_day(hiredate+INTERVAL 3 MONTH)+INTERVAL 1 DAY 정식입사일 FROM emp 
--or
SELECT empno,eNAME,hiredate,date_add(LAST_DAY(DATE_ADD(hiredate,INTERVAL 2 MONTH)),interval 1 DAY) FROM emp


/*
	변환관련함수
	날자를 문자열 변환: date_format
	문자를 날짜로 변환: str_to_date
		%y: 4자리로 만든 년도
		%m: 2자리 월
		%d: 2자리 일자
		%h: 1 ~ 12 시
		%H: 0 ~ 23 시
		%i: 0 ~ 59 분
		%s: 0 ~ 59 초
		%a: 약자로 표기된  요일 
		%W: 요일
		%p: AM,PM

*/

SELECT DATE_FORMAT(NOW(),'%Y년%m월%d일 %h:%i%s'),
DATE_FORMAT(NOW(),'%Y년%m월%d일 %H:%i%s:%p'),
DATE_FORMAT(NOW(),'%Y년%m월%d일 %H:%i%s:%W'),
DATE_FORMAT(NOW(),'%Y년%m월%d일 %h:%i%s:%a')

SELECT STR_TO_DATE('20190101','%Y%m%d'),
		 DATE_FORMAT(STR_TO_DATE('20190101','%Y%m%d'),'%Y년%m월%d일')

SELECT STR_TO_DATE('2019/01/01','%Y/%m/%d'),
		 STR_TO_DATE('2019/01/01 10:30:23','%Y/%m/%d %h:%i:%s')
		 
		 
/*
	기타함수
	ifnull(컬럼,기본값): 컬럼이 null인 경우 기본값으로 변환

*/		
SELECT NAME,POSITION,salary,bonus,salary+ifnull(bonus,0) FROM professor

--문제 
--	1교수의 이름,직책,급여,보너스를 출력하기
-- 	보너스가 없는 경우는 'bonus 없음'으로 출력하자
	SELECT NAME,POSITION,salary,ifnull(bonus,"bonus없음")보너스 FROM professor
-- 	지도교수가 없는 경우 '지도교수배정안됨'으로 출력하기\
	SELECT NAME,IFNULL(profno,"지도교수배정안됨")지도교수번호 FROM student
--	3.major 테이블에서 코드,Bild 출력하기
-- 	buil값이 없는 경우 '단독 건물 없음'으로 출력
	SELECT code,name,IFNULL(build,"단독건물없음")build FROM major

/*
	조건 관련 함수
		if : if(조건문,참,거짓)
		case : 
*/

--교수의 이름, 학과번호, 학과명  출력하기 
-- 단학과번호가 101인 경우 '컴퓨터공학' 나머지는 '그외학과'로  출력하기 

SELECT NAME ,deptno,if(deptno=101,'컴퓨터공학','그 외학과') 학과명 FROM professor

--교수의 이름, 학과번호, 학과명  출력하기 
--단 학과명은 학과번호가 101인 경우'컴공'
								--102 '멀티' 201'기계공학' 나머지'그 외학과' 출력 
SELECT NAME,deptno, if(deptno=101,'컴퓨터공학',if(deptno=102,'멀티미디어공학과',if(deptno=201,'기계공학과','그 외학과')))학과명  FROM professor
 
--문제 
--1. 학생의 주민번호 7번째 자리가 1,3인 경우 남자,2,4인 경우 여자로, 
-- 	그 외는 주민번호  오류 성별 출력하기 
-- 학생의 이름, 주민번호, 성별을 출력하기 
SELECT NAME,jumin,if(SUBSTR(jumin,7,1)=1 ,'남자',if(SUBSTR(jumin,7,1)=3 ,'남자',if(SUBSTR(jumin,7,1)=2 ,'여자', if(SUBSTR(jumin,7,1)=4,'여자','그외학과')))) 성별 FROM student

--or
SELECT NAME,jumin,if(SUBSTR(jumin,7,1) IN(1,3),'남자',if(SUBSTR(jumin,7,1) IN(2,4),'여자','그외학과'))성별  FROM student 

--or
SELECT NAME,jumin,
if(SUBSTR(jumin,7,1)=1 OR if(SUBSTR(jumin,7,1)=3,'남자',
if(SUBSTR(jumin,7,1)=2 OR if(SUBSTR(jumin,7,1)=4,'여자' ,'그외학과')))) 성별 FROM student


--2. 학생의 이름,전화번호, 지역명 출력하기 
-- 	지역명은 전화번호의 지역번호가 02:서울,031,경기,051:부산 그외는 기타지역으로 출력
SELECT NAME,tel,if(SUBSTR(tel,1,2)=02,'서울',if(SUBSTR(tel,1,3)=031,'경기',if(SUBSTR(tel,1,3)=051,'부산','기타지역')))지역명 FROM student
								
								
								