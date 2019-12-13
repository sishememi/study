package jdbc;
/*
 * Java 와 DBMS(maria db사용) 연결하기
 * 1.드라이버 파일(mariadb-java-client-2.4.2.jar) classpath 연결. 사용도구설정 
 * 2.JDBC 관련 패키지: java.sql.*
 * 3.드라이버 클래스를 로드하기
 * 4.db와 java를 연결하는 객체 생성.
 * 5.SQL 명령문을 DB에 명령 전달 객체 생성.
 * 6.Statement 객체를 이용하여 Sql구문 실행. 결과 얻기
 * 
 * maria db는 1.번역을 하게된다. 2.실행 3.결과리턴
 * */

import java.sql.*; //java.sql 패키지의 모든 클래스 등록

public class JdbcEx1 {
	public static void main(String[] args) throws ClassNotFoundException, SQLException{
		//3. 드라이버 클래스를 로드하기,Class.forName -> 클래스를찾음
		Class.forName("org.mariadb.jdbc.Driver"); //문자열로 설정된 클래스를  메모리에 로드.
		//4. db와 java를 연결하는 객체 생성.
		Connection conn = DriverManager.getConnection
				 ("jdbc:mariadb://localhost:3306/classdb","scott","1234");
		//5. SQL 명령문을 DB에 명령 전달 객체 생성.
		Statement stmt = conn.createStatement();
		//6. Statement 객체를 이용하여 Sql구문 실행. 결과 얻기
		ResultSet rs = stmt.executeQuery("select * from student");
		//7.결과조회
		while(rs.next()) { //한개 레코드씩 조회
			System.out.print("학번:"+rs.getString("studno"));
			System.out.print(",이름:"+rs.getString("name"));
			System.out.print(",학년:"+rs.getString("grade"));
			System.out.print(",키:"+rs.getString("height"));
			System.out.print(",몸무게:"+rs.getString("weight"));
			System.out.println(",학과코드:"+rs.getString("major1"));
		}
		
		//문제:교수테이블에서 교수의 번호,이름,id,입사일,급여,보너스,학과코드를 화면에 출력하기
		ResultSet rs1 = stmt.executeQuery("select * from professor");
		
		while(rs1.next()) { //한개 레코드씩 조회
			System.out.print("번호:"+rs1.getString("no"));
			System.out.print(",이름:"+rs1.getString("name"));
			System.out.print(",id:"+rs1.getString("id"));
			System.out.print(",입사일:"+rs1.getString("hiredate"));
			System.out.print(",급여:"+rs1.getString("salary"));
			System.out.print(",보너스:"+rs1.getString("bonus"));
			System.out.println(",학과코드:"+rs1.getString("deptno"));
		}
	}
}