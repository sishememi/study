package jdbc;

import java.sql.*;

/*
 * PreparedStatement ����
 * 
 * Statement�� ���� �������̽�
 * */

public class JdbcEx3 {
	public static void main(String[] args) throws ClassNotFoundException, SQLException{
		Class.forName("org.mariadb.jdbc.Driver"); 
		Connection conn = DriverManager.getConnection
				 ("jdbc:mariadb://localhost:3306/classdb","scott","1234");
		PreparedStatement pstmt = conn.prepareStatement
				("select * from student where grade=?");//grade=? grade�� ���߿� �����ϰ���
		//pstmt.setInt(1, 1); �տ� 1 => ù��° ?
		//						 2 => ��.
		for(int i=1;i<=4;i++) {
		pstmt.setInt(1, i); //ù��° ?�� ������ �� i �Է�
		System.out.println("----------"+i+"�г�-----------");
		ResultSet rs  = pstmt.executeQuery();
		while(rs.next()) {
			/*
			 * %7s: %s: ���ڿ��� �����,7�ڸ��� Ȯ���ؼ� ���ڿ��� ���
			 * %-5s: - : �������ķ� ���(������ �⺻����)
			 * %3d : d :������ ���,3�ڸ� Ȯ���ؼ� �������� ���(������)
			 * %5.2f: %f : �ε��Ҽ���, �Ǽ����
			 * 		   5 : 5�ڸ� Ȯ��
			 * 		  .2 : �Ҽ������� 2�ڸ������� ���. 3��°�ڸ����� �ݿø�.
			 * */
			System.out.printf("�й�:%7s,�̸�:%-5s,�г�:%3d,Ű:%5.2f,������:%5.2f,�а��ڵ�:%-5s\n",
			rs.getString("studno"), //studno �÷��� String Ÿ������ ����.
			rs.getString("name"), 
			rs.getInt("grade"), //grade �÷��� Int Ÿ������ ����
			rs.getDouble("height"),
			rs.getDouble("weight"),
			rs.getDouble("major1")); 
			}
		}
	}
}
