--DDL : 데이터 정의어
--create,alter,drop,truncate
--drop: (객체)테이블을 제거.
--truncate: 테이블의 데이터 제거 rollback이 안됨
--				모든 데이터(레코드)가 제거됨.


--DML : 데이터 조작어
--CRUD 
-- C: insert  create 약자. 데이터를 추가
-- R: select  read 약자. 데이터 조회
-- U: update  update 약자. 데이터 수정
-- D: delete  delete 약자. 데이터 제거

--TCL : transation control language
--commit : 데이터 변경 완료. transation 종료
--rollback: 데이터 변경 취소. transation 종료

--autocommit false
SET autocommit=FALSE
SHOW TABLES

SELECT * FROM dept2
DELETE FROM dept2
COMMIT 