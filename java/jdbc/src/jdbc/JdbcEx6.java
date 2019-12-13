package jdbc;
/*
 * Bean 클래스를 이용하여 데이터 저장 및 조회하기.
 */

import java.sql.*;

public class JdbcEx6 {
	public static void main(String[] args) throws Exception {
		Class.forName("org.mariadb.jdbc.Driver");
		Connection conn = DriverManager.getConnection
				("jdbc:mariadb://localhost:3306/classdb","scott","1234");
		PreparedStatement pstmt = conn.prepareStatement("select count(*) from (select * from emp) a"); //emp테이블의 모든걸 가져와서 레코드 수를 출력 ,이것과 같다.select count(*) from emp
		ResultSet rs = pstmt.executeQuery();
		rs.next();
		//count: emp 테이블의 저장된 레코드의 갯수
		int count = rs.getInt(1); //첫번재 컬럼
		Emp[] emps = new Emp[count];
		pstmt.close();
		pstmt = conn.prepareStatement("select * from emp");
		rs = pstmt.executeQuery();
		int i =  0;
		while(rs.next()) {
			Emp e= new Emp();
			e.setEmpno(rs.getInt("empno"));
			e.setEname(rs.getString("ename"));
			e.setJob(rs.getString("job"));
			e.setMgr(rs.getString("mgr"));
			e.setBirthday(rs.getTimestamp("birthday"));
			e.setHiredate(rs.getTimestamp("hiredate"));
			e.setSalary(rs.getInt("salary"));
			e.setBonus(rs.getInt("bonus"));
			e.setDeptno(rs.getInt("deptno"));
			emps[i++] = e;
		}
		conn.close(); //db와 접속 종료
		for(Emp e: emps) {
			System.out.println(e);
		}
	}
}
