/*
	문자관련 함수 	 
	instr(컬럼,문자):컬럼에서 문자의 인덱스 리턴 
	문자 추가: lpad(컬럼명,자릿수,나머지를 채울 문자) : 왼쪽 추가
				  rpad(컬럼명,자릿수,나머지를 채울 문자) : 오른쪽 추가 
	문자 제거함수: 양쪽 끝의 문자를 제거.
						trim(leading/trailing/both 문자열 from 컬럼명): 왼/오/양쪽을 제거 
						trim(컬럼명) : 양쪽의 공백을 제거 
						ltrim(컬럼명) : 왼쪽 공백을 제거  
						rtrim(컬럼명) : 오른쪽 공백 제거 
						=>문자 중간에 있는 공백은 제거되지 않 는다.
	문자치환 함수: replace(컬럼명,문자1,문자2)
		=>ㅋ컬럼의 문자열 중 문자1 -> 문자2
		 
	숫자 관련 함수 
		반올림: around(컬럼,[표시할 소숫점 이하 자리수])
		버림: turncat(컬럼, 표시할 소숫점 이하 자리수)
		나머지: mod(숫자1,숫자2): 숫자1%숫자2
		제곱: power(숫자,1,숫자2): 숫자1을 숫자2만큼 제곱 
		근사정수: ceil(숫자) :큰 근사정수 
	   			 floor(숫자):작은 근사정수 
	 
	날짜 관련 함수   			 
	 	현재 시점: now()
	 	오늘 일자: curdate(),current_date,current _date()
	 	일자 수 계산: datedifF(날짜1,날짜2) 날짜1 - 날짜2  일자 수 
	 	일자의 부분함수:
	 							year(날짜): 날짜의 년도 리턴 
	 							month(날짜): 날짜의 월 리턴 
	 							day(날짜): 날짜의 일 리턴 
	 							weekday(): 0(월),1(화),...부터시작 
	 							dayofweek(): 1(일),2(월)...시작 
	 							last_day(날짜): 그 달의 마지막 일자 
	 			날짜의  이후: date_add(날짜,interval 1 [day|year|month|our|minute|sencond...]
	 			날짜의 이전:  date_sub(날짜,interval 1 [day|year|month|our|minute|sencond...]
	 			 
	 	날짜변환 함수:
		 	문자열->날짜로 변경:  str_to_date(문자열,'형식지정문자')
			날짜-> 문자열로 변경:date_format(날짜,'형식지정문자')
			형식지정문자 
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
				 	 
		기타함수	 
			ifnull(컬럼,기본값): 컬럼의 값이 null인 경우는 기본값으로 대체함.
			조건함수:
				if : if(조건문,참,거짓)
*/

--조건함수 : case 함수 
--case 컬럼  when 값 then 문자...
--				else 문자 end
--case when 조건 then 문자...

--교수의 학과명이 101학과인 경우 '컴퓨터공학'으로 그외는 공란으로 출력하기 
--교수의 이름,학과코드,학과명을 출력하기 
SELECT NAME 이름 ,deptno 학과코드 ,if(deptno=101,'컴퓨터공학','')학과명 FROM professor

--↓↓↓↓↓↓↓↓↓↓↓↓↓↓ case 문으로 변환 ↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

SELECT NAME 이름 ,deptno 학과코드 ,case deptno when 101 then'컴퓨터공학' ELSE '' END 학과명  FROM professor

--교수의 학과명이 101학과인 경우 '컴퓨터공학'으로 그외는 '기타학과'로 출력하기 
--교수의 이름,학과코드,학과명을 출력하기 
SELECT NAME 이름,deptno 학과코드,if(deptno=101,'컴퓨터공학','기타학과') 학과명 FROM professor

SELECT NAME 이름,deptno 학과코드,case deptno when 101 then '컴퓨터공학' ELSE '기타학과' END 학과명 FROM professor

--교수의 이름,학과코드,학과명 출력하기
--학과명은 101학과인 경우 '컴퓨터공학'으로 102학과는 멀티미디어공학, 201학과 기계공학 그외는 기타학과 라고 한다.
SELECT NAME,deptno,if(deptno=101,'컴퓨터공학',
										if(deptno=102,'멀티미디어공학',
													if(deptno=201,'기계공학','기타학과')))학과명 FROM professor
				-----↓↓↓↓↓↓↓↓↓↓↓↓↓↓case로 변환
SELECT NAME,deptno,case deptno when 101 then '컴퓨터공학' 
										 when 102 then '멀티미디어공학' 
										 when 201 then '기계공학' ELSE '기타학과' END 학과명 FROM professor
										 
										 
--학생의 주민번호 7번째 자리가 1,3 인경우 남자로, 2,4인 경우 여자로 그외는 주민번호 오류로 성별을 출력하자 
--학생의 이름,주민번호,성별 출력하기 
SELECT NAME 이름 ,jumin 주민번호,case SUBSTR(jumin,7,1) 
													  when 1 then '남자' 
													  when 2 then '여자'
													  when 3 then '남자'
													  when 4 then '여자' ELSE '주민번호 오류' END 성별 FROM student
											 -- ↓↓↓↓ case 다음 컬럼이오지않으면 when 다음 조건문이 온다.	
SELECT NAME 이름 ,jumin 주민번호,case 	when SUBSTR(jumin,7,1) IN (1,3) then '남자' 
													when SUBSTR(jumin,7,1) IN (2,4) then '여자' ELSE '주민번호 오류' END 성별 FROM student													
													

--문제 
--학생의 이름,전화번호,지역명을 출력하기 
--지역명은 전화번호의 지역번호가 02:서울 031:경기 051:부산	052:경남 그외는 기타 출력 기
SELECT NAME 이름, tel 전화번호, case left(tel,INSTR(tel,')')-1) when 02 then '서울'
																				 	when 031 then '경기'
																				 	when 051 then '부산'
																				 	when 052 then '경남' ELSE '기타' END 지역명 FROM student
																				
--학생의 생일이 1-3월이면 1분기,4-6월이면 2분기,7-9월이면 3분기 10-12월은 4분기라 한다.
--학생의 이름 ,주민번호, 출생분기 출력하기 
--생일은 주민번호를 기준으로 한다.
SELECT NAME,jumin, case when substr(jumin,3,2) IN(1,2,3) then '1분기'
								when substr(jumin,3,2) IN(4,5,6) then '2분기'
								when substr(jumin,3,2) IN(7,8,9) then '3분기' else'4분기' END 출생분기 FROM student

--학생의 생일이 1-3월이면 1분기,4-6월이면 2분기,7-9월이면 3분기 10-12월은 4분기라 한다.
--학생의 이름 ,주민번호, 출생분기 출력하기 
--생일은 생일을 기준으로 한다.				 	
SELECT NAME,jumin,case when SUBSTR(birthday,6,2)  IN(1,2,3) then '1분기'			 
							  when SUBSTR(birthday,6,2)  IN(4,5,6) then '2분기'	
							  when SUBSTR(birthday,6,2)  IN(7,8,9) then '3분기' else'4분기' END 출생분기 FROM student
							  
SELECT NAME,jumin,case when MONTH (birthday)  IN(1,2,3) then '1분기'			 
							  when MONTH (birthday)  IN(4,5,6) then '2분기'	
							  when MONTH (birthday)  IN(7,8,9) then '3분기' else'4분기' END 출생분기 FROM student
							  
/*
	그룹함수: 여러행을 그룹화 한 결과를 리턴 
*/							  
-- count 함수: 레코드의 건수를 리턴. null값은 개수에서 제외됨.
--교수의 전체 인원수와 교수 중 보너스를 받는 교수의 인원 수를 출력하기 
SELECT COUNT(*),COUNT(bonus) FROM professor
							  
--학생의 전체인원수와 지도교수가 있는 학생의 인원수 출력하기
SELECT COUNT(*),COUNT(profno) FROM student
							                                                                                                                                                              --1학년학생의 전체인원수와 지도교수가 있는 학생의 인원수 출력하기
SELECT COUNT(*),COUNT(profno) FROM student        
WHERE grade=1     
--2학년학생의 전체인원수와 지도교수가 있는 학생의 인원수 출력하기
SELECT COUNT(*),COUNT(profno) FROM student        
WHERE grade=2         
--3학년학생의 전체인원수와 지도교수가 있는 학생의 인원수 출력하기
SELECT COUNT(*),COUNT(profno) FROM student        
WHERE grade=3
--4학년학생의 전체인원수와 지도교수가 있는 학생의 인원수 출력하기
SELECT COUNT(*),COUNT(profno) FROM student        
WHERE grade=4            

--학년별 학생의 전체인원수와 지도교수가 있는 학생의 인원수 출력하기 
SELECT COUNT(*),COUNT(profno) FROM student 
GROUP by grade   

--전공1학과별 학생의 인원수와 지도교수가 있는 학생의 인원수 출력하기 
SELECT major1,COUNT(*),COUNT(profno) FROM student
GROUP BY major1 

--문제 
--1. 교수 중 직책별 교수의 인원수와 보너스를 받고있는 인원수를 출력하기 
SELECT POSITION, COUNT(*),COUNT(bonus) FROM professor 
GROUP BY position                                                                                                 
--2. 사원  중 부서별 사원의 인원수와 보너스를 받고있는 인원수를 출력하기          
SELECT deptno, COUNT(*),COUNT(bonus) FROM emp 
GROUP BY deptno


--합계: sum
--평균: avg, null값은 제외 

--교수들의 급여 합계와 보너스 합계를 조회하기 
SELECT SUM(salary),SUM(bonus) FROM professor

--교수들의 급여 평균과 보너스의 평균을 조회하기 
SELECT AVG(salary),AVG(bonus) FROM professor  

--교수들의 전체 인원수, 급여합계,보너스합계,급여평균,보너스평균을 조회하기
--평균을 보너스를 받지 않는 경우는 0으로 처리하여 평균에 계산되도록 하기.
SELECT COUNT(*),SUM(salary),SUM(bonus),AVG(salary),AVG(ifnull(bonus,0)) FROM professor

--문제
--1.교수의 부서별 인원수,총급여합계,총보너스합계,급여평균,보너스평균
-- 조회하기. 단 보너스가 없는 교수도 평균에 계산되도록 하기.
SELECT deptno,COUNT(*) '부서별 인원수',SUM(salary) 총급여합계,SUM(bonus) 총보너스합계,AVG(salary) 급여평균,AVG(IFNULL(bonus,0)) 보너스평균 FROM professor
GROUP BY deptno 
--2.교수의 직급별 인원수,총급여합계,총보너스합계,급여평균,보너스평균 조회하기단 보너스가 없는 교수도 평군에 계산되도록 하기.
SELECT position,COUNT(*) '직급별 인원수',SUM(salary) 총급여합계,SUM(bonus) 총보너스합계,AVG(salary) 급여평균,AVG(IFNULL(bonus,0)) 보너스평균  FROM professor
GROUP BY POSITION 
--3.부서별 교수의 급여합계,보너스합계,연봉합계,급여평균,보너스평균,연봉평균 출력하기.
--연봉은 급여*12+bonus를 한다. 단, 보너스가 없는 경우는 0으로 처리함
--평균출력시 소숫점이하 2자리로 반올림하여 출력할것
SELECT SUM(salary)급여합계,SUM(bonus) 연봉합계 ,SUM(salary*12+ifnull(bonus,0))연봉합계,
round(AVG(salary),2) 급여평균,round(AVG(IFNULL(bonus,0)),2) 보너스평균,round(AVG(salary*12+ifnull(bonus,0)),2) 연봉평균 FROM professor
GROUP BY deptno
--4. 학생의 학년별 키와 몸무게 평균을 구하가
--학년별로 정렬하기,평균은 소숫점2자리까지 반올림하여 출력하기
SELECT grade,round(AVG(weight),2) 키평균,round(AVG(height),2) 몸무게평균 FROM student
GROUP BY grade


--having : 그룹의 조건
--학생의 학년별 키와 몸무게 평균을 구하가
--몸무게 평균이 70이상인 학년만 출력하자.
SELECT grade, AVG(weight),AVG(height) FROM student
GROUP BY grade
HAVING AVG(weight)>=70

/*
	SELECT 컬럼명|*
	from 테이블명
	where 레코드선택의 조건문
	group by 컬럼명
	having 그룹함수 조건
	order by 컬럼
*/

--문제
--교수 테이블에서 부서별 급여 합계와 평균을 구하기
--단, 급여 평균이 400이상인 부서만 출력하기
SELECT deptno, SUM(salary),AVG(salary) FROM professor
GROUP BY deptno
HAVING SUM(salary) >= 400

--교수 테이블에서 부서별 급여 합계와 평균을 구하기 
--평군이 큰순으로 출력하기
SELECT deptno,SUM(salary),AVG(salary) FROM professor
GROUP BY deptno
ORDER BY 3 DESC 

/* min(),max() : 최소값,최대값*/

--전공1학과별 가장 키가 큰학생의 키와, 가장 작은 학생의 키 , 키 평균을 출력하기
SELECT major1,MAX(height) 큰키,MIN(height)작은키,AVG(height) 평균키FROM student
GROUP BY major1

--문제
--1.전공1별로 가장 큰 키와, 가장 작은 키, 키의 평균을 구하기 평균키가 170이상인  전공1학과를 출력하기
SELECT major1, MAX(height) 큰키,MIN(height) 작은키,AVG(height) 평균키 FROM student
GROUP BY major1
HAVING AVG(height) >= 170

--2.교수테이블에서 급여와 보너스 합계가 가장 많은 값과, 적은값,평균금액 출력하기.
--단, 보너스가 없으면 0으로 처리한다. 평균은 소숫점이하 한자리로 반올림 하여 출력한다.
SELECT MAX(salary+ifnull(bonus,0))'급여+보너스최대',MIN(salary+ifnull(bonus,0))'급여+보너스최소',round(AVG(salary+ifnull(bonus,0)),1)'급여+보너스 평균' FROM professor

--3.학과별 평균 급여가 300이상인  학과의 학과코드 ,평균급여, 인원수를  출력하기
SELECT deptno,AVG(salary) 평균급여,COUNT(*)인원수  FROM professor
GROUP BY deptno
HAVING 평균급여>=300 --having에서 별명 사용가능!

--4.주민번호를 기준으로 남학생,여학생의 최대키와 최소키,평균키를 출력하기 평균키는 소숫점이하 2자리로 반올림하여 출력한다.
SELECT case when substr(jumin,7,1) IN (1,3) then '남자'ELSE '여자' END 성별,max(height) 최대키,MIN(height) 최소키 ,round(AVG(height),2) 평균키 FROM student
GROUP BY case when substr(jumin,7,1) IN (1,3) then '남자'ELSE '여자' END

--5.학생 중 생일(birthday)기준으로 월별로 태어난 인원수를 출력하기 
SELECT SUBSTR(birthday,6,2) 월별, COUNT(*) 인원수 FROM student
GROUP BY SUBSTR(birthday,6,2)

--6.학생 중 생일(birthday)기준으로 월별로 태어난 인원수를 다음 결과처럼 출력하기
SELECT COUNT(*) 전체,sum(if(month(birthday)=1,1,0)) '01월' ,sum(if(month(birthday)=2,1,0)) '02월' ,sum(if(month(birthday)=3,1,0)) '03월',sum(if(month(birthday)=4,1,0)) '04월',
							sum(if(month(birthday)=5,1,0)) '05월' ,sum(if(month(birthday)=6,1,0)) '06월' ,sum(if(month(birthday)=7,1,0))'07월' ,sum(if(month(birthday)=8,1,0)) '08월',
							sum(if(month(birthday)=9,1,0)) '09월' ,sum(if(month(birthday)=10,1,0)) '10월',sum(if(month(birthday)=11,1,0)) '11월',sum(if(month(birthday)=12,1,0)) '12월'
							FROM student

--7.전화번호의 지역번호가 02 서울 031 경기 051 부산 052 경남 ,나머지 그외 지역 학생의 인원수를 조회하기 
SELECT case LEFT(tel,INSTR(tel,')')-1) when 02 then  '서울'
													when 031 then '경기'
													when 051 then '부산'
													when 052 then '경남' ELSE '그외 지역' END 지역,COUNT(*) 인원수  FROM student
GROUP BY 지역
ORDER BY LEFT(tel,INSTR(tel,')')-1)

--8.전화번호의 지역번호가 02 서울 031 경기 051 부산 052 경남 ,나머지 그외 지역 학생의 인원수를 조회하기 가로출력
SELECT SUM(if(LEFT(tel,INSTR(tel,')')-1)=02,1,0)) '서울',
 		 SUM(if(LEFT(tel,INSTR(tel,')')-1)=031,1,0)) '경기',
		 SUM(if(LEFT(tel,INSTR(tel,')')-1)=051,1,0)) '부산',
	    SUM(if(LEFT(tel,INSTR(tel,')')-1)=052,1,0)) '경남',
	    SUM(if(LEFT(tel,INSTR(tel,')')-1),1,0)) '그외지역'		
		 FROM student		 