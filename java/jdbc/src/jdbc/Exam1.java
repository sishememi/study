package jdbc;

import java.sql.*;

/*
 * 1.dept 테이블을 이용하여 서울지역의 레코드만 dept_seoul 테이블로 생성하기
 * 2.dept_seoul 테이블에
 * 	 deptno:60, dname:특수영업부, loc:서울레코드 추가.
 * 3.dept_seoul 테이블에
 * 	 deptno:60 레코드의  dname:특수영업부1 수정하기.
 * 4.dept_seoul 테이블의 모든 컬럼의 내용을 화면에 출력하기.
 * */
public class Exam1 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("org.mariadb.jdbc.Driver"); //문자열로 설정된 클래스를  메모리에 로드.
		Connection conn = DriverManager.getConnection
				 ("jdbc:mariadb://localhost:3306/classdb","scott","1234");
		Statement stmt = conn.createStatement(); //명령전달..
		
		String sql = "create table dept_seoul ( select * from dept where loc='서울')";
		int result =stmt.executeUpdate(sql);
		System.out.println("1. 결과:"+result);
		
		sql="insert into dept_seoul values(60,'특수영업부','서울')";
		result = stmt.executeUpdate(sql); //여기서 insert into dept_seoul values(60,'특수영업부','서울')이 구문이 db로가서 파싱.
		System.out.println("2. 결과:"+result);
		
		sql="update dept_seoul set dname='특수영업부1' where deptno=60";
		result =stmt.executeUpdate(sql);
		System.out.println("3. 결과:"+result);
		
		ResultSet rs = stmt.executeQuery("select * from  dept_seoul");
		while(rs.next()) { 
			System.out.print("부서번호:"+rs.getString("deptno"));
			System.out.print(",부서명:"+rs.getString("dname"));
			System.out.println(",부서위치:"+rs.getString("loc"));	
		}
	}
}
