SELECT NAME 이름,jumin 주민번호,birthday, height 키, weight 몸무게 FROM student
WHERE grade = 1
ORDER BY 3


SELECT NAME 교수이름,salary 급여,bonus 보너스 FROM professor
WHERE salary >=300 AND bonus IS NOT NULL 
UNION
SELECT NAME 교수이름,salary 급여,bonus 보너스 FROM professor
WHERE salary >=450


SELECT studno 학번, NAME 이름,grade 학년,tel 전화번호 FROM student
WHERE LEFT(tel,2)>02 --tel not like "02%" --left(tel,2) != 02
ORDER BY 학년


SELECT  studno 학번, NAME 이름,grade 학년,id FROM student 
WHERE id LIKE "%kim%"   --where lower(id) like "%kim%"


SELECT NO 교수번호,NAME 이름,salary 급여,salary*1.1 "인상예상급여" FROM professor
WHERE bonus IS NULL
union
SELECT NO ,NAME ,salary ,salary  FROM professor
WHERE bonus IS NOT NULL 
ORDER BY 4 DESC 


SELECT studno 학번,NAME 이름,major1 전공1코드 FROM student
WHERE NAME LIKE "%훈"  ---right(name,1)='훈'
ORDER BY grade


SELECT studno 학번,NAME 이름,CONCAT (UPPER(LEFT(id,1)),LOWER(substr(id,2)))id FROM student


SELECT NAME 교수이름,url,SUBSTR (url,8,22)homepage,CHAR_LENGTH(substr(url,8))homepage의길이 FROM professor
WHERE url IS NOT NULL 
--char_length(substr(url,8))


SELECT studno 학번,NAME 이름,id,CHAR_LENGTH(id)id의글자수 FROM  student
WHERE CHAR_LENGTH(id) BETWEEN 7 AND 10


SELECT NAME 교수이름 FROM professor
WHERE NAME BETWEEN  "자" AND "차-1"