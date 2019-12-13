package jdbc;

import java.sql.*;

/*
 * 1.dept ���̺��� �̿��Ͽ� ���������� ���ڵ常 dept_seoul ���̺�� �����ϱ�
 * 2.dept_seoul ���̺�
 * 	 deptno:60, dname:Ư��������, loc:���ﷹ�ڵ� �߰�.
 * 3.dept_seoul ���̺�
 * 	 deptno:60 ���ڵ���  dname:Ư��������1 �����ϱ�.
 * 4.dept_seoul ���̺��� ��� �÷��� ������ ȭ�鿡 ����ϱ�.
 * */
public class Exam1 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("org.mariadb.jdbc.Driver"); //���ڿ��� ������ Ŭ������  �޸𸮿� �ε�.
		Connection conn = DriverManager.getConnection
				 ("jdbc:mariadb://localhost:3306/classdb","scott","1234");
		Statement stmt = conn.createStatement(); //�������..
		
		String sql = "create table dept_seoul ( select * from dept where loc='����')";
		int result =stmt.executeUpdate(sql);
		System.out.println("1. ���:"+result);
		
		sql="insert into dept_seoul values(60,'Ư��������','����')";
		result = stmt.executeUpdate(sql); //���⼭ insert into dept_seoul values(60,'Ư��������','����')�� ������ db�ΰ��� �Ľ�.
		System.out.println("2. ���:"+result);
		
		sql="update dept_seoul set dname='Ư��������1' where deptno=60";
		result =stmt.executeUpdate(sql);
		System.out.println("3. ���:"+result);
		
		ResultSet rs = stmt.executeQuery("select * from  dept_seoul");
		while(rs.next()) { 
			System.out.print("�μ���ȣ:"+rs.getString("deptno"));
			System.out.print(",�μ���:"+rs.getString("dname"));
			System.out.println(",�μ���ġ:"+rs.getString("loc"));	
		}
	}
}
