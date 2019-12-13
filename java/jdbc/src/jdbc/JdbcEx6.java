package jdbc;
/*
 * Bean Ŭ������ �̿��Ͽ� ������ ���� �� ��ȸ�ϱ�.
 */

import java.sql.*;

public class JdbcEx6 {
	public static void main(String[] args) throws Exception {
		Class.forName("org.mariadb.jdbc.Driver");
		Connection conn = DriverManager.getConnection
				("jdbc:mariadb://localhost:3306/classdb","scott","1234");
		PreparedStatement pstmt = conn.prepareStatement("select count(*) from (select * from emp) a"); //emp���̺��� ���� �����ͼ� ���ڵ� ���� ��� ,�̰Ͱ� ����.select count(*) from emp
		ResultSet rs = pstmt.executeQuery();
		rs.next();
		//count: emp ���̺��� ����� ���ڵ��� ����
		int count = rs.getInt(1); //ù���� �÷�
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
		conn.close(); //db�� ���� ����
		for(Emp e: emps) {
			System.out.println(e);
		}
	}
}
