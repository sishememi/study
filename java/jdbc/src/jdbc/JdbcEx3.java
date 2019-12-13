package jdbc;

import java.sql.*;

/*
 * PreparedStatement 예제
 * 
 * Statement의 하위 인터페이스
 * */

public class JdbcEx3 {
	public static void main(String[] args) throws ClassNotFoundException, SQLException{
		Class.forName("org.mariadb.jdbc.Driver"); 
		Connection conn = DriverManager.getConnection
				 ("jdbc:mariadb://localhost:3306/classdb","scott","1234");
		PreparedStatement pstmt = conn.prepareStatement
				("select * from student where grade=?");//grade=? grade는 나중에 생각하겠음
		//pstmt.setInt(1, 1); 앞에 1 => 첫번째 ?
		//						 2 => 값.
		for(int i=1;i<=4;i++) {
		pstmt.setInt(1, i); //첫번째 ?는 정수형 값 i 입력
		System.out.println("----------"+i+"학년-----------");
		ResultSet rs  = pstmt.executeQuery();
		while(rs.next()) {
			/*
			 * %7s: %s: 문자열을 출력함,7자리를 확보해서 문자열로 출력
			 * %-5s: - : 좌측정렬로 출력(우측이 기본정렬)
			 * %3d : d :십진수 출력,3자리 확보해서 십진수로 출력(정수형)
			 * %5.2f: %f : 부동소숫점, 실수출력
			 * 		   5 : 5자리 확보
			 * 		  .2 : 소숫점이하 2자리까지만 출력. 3번째자리에서 반올림.
			 * */
			System.out.printf("학번:%7s,이름:%-5s,학년:%3d,키:%5.2f,뭄무게:%5.2f,학과코드:%-5s\n",
			rs.getString("studno"), //studno 컬럼을 String 타입으로 리턴.
			rs.getString("name"), 
			rs.getInt("grade"), //grade 컬럼을 Int 타입으로 리턴
			rs.getDouble("height"),
			rs.getDouble("weight"),
			rs.getDouble("major1")); 
			}
		}
	}
}
