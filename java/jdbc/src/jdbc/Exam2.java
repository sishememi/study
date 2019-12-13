package jdbc;
/*
 * 교수테이블에서 학과별 교수 목록을 출력하기
 * 1.교수들의 학과 조회하여, 각 학과별 교수의 목록을 출력하기
 * 2.교수들의 학과 조회하여, 학과인원이 2명 이상인 학과 교수의 목록을 출력하기.
 * */
import java.sql.*;
public class Exam2 {
	public static void main(String[] args) throws ClassNotFoundException, SQLException{
		Class.forName("org.mariadb.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/classdb","scott","1234");
		//강사님 버전
		  PreparedStatement pstmt1 = conn.prepareStatement
//			1.교수들의 학과 조회하여, 각 학과별 교수의 목록을 출력하기
				  //("select distinct deptno from professor is not null");
//			2.교수들의 학과 조회하여, 학과인원이 2명 이상인 학과 교수의 목록을 출력하기.
				  ("select deptno from professor group by deptno having count(*)>=2");
			ResultSet rs = pstmt1.executeQuery();
			PreparedStatement pstmt2 = conn.prepareStatement
				("select * from professor where deptno=?");
			while(rs.next()) {
			pstmt2.setInt(1,rs.getInt(1));//=(1,rs.getInt(deptno)) rs 조회된 컬럼 중 첫번째 컬럼
			ResultSet rs2 = pstmt2.executeQuery();
			System.out.println("---------"+rs.getInt(1)+"학과---------");
			while(rs2.next()) {
			System.out.printf("번호:%-5s,이름:%-5s,id:%-5s,position:%-5s,급여:%-5d,보너스:%-5d,학과:%-5s \n",
				rs2.getString("no"),
				rs2.getString("name"),
				rs2.getString("id"),
				rs2.getString("position"),
				rs2.getInt("salary"),
				rs2.getInt("bonus"),
				rs2.getString("deptno")); 
	}
}
		 
		/*PreparedStatement pstmt = conn.prepareStatement
				("select * from professor where deptno=?");
		
		    for(int i=101;i<=301;i++) {
			if(i!=101 && i!=102 && i!=103 && i!=201 && i!=202 && i!=301) 
			continue; else pstmt.setInt(1, i);
			System.out.println("---------"+i+"학과--------");
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				System.out.printf("번호:%-5s,이름:%-5s,id:%-5s,position:%-5s,급여:%-5d,보너스:%-5d,학과:%-5s,입사일:%s \n",
				rs.getString("no"),
				rs.getString("name"),
				rs.getString("id"),
				rs.getString("position"),
				rs.getInt("salary"),
				rs.getInt("bonus"),
				rs.getString("deptno"),
				rs.getString("hiredate"));
				
			}
		}*/

	}



}

