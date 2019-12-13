package jdbc;
/*
 * �������̺��� �а��� ���� ����� ����ϱ�
 * 1.�������� �а� ��ȸ�Ͽ�, �� �а��� ������ ����� ����ϱ�
 * 2.�������� �а� ��ȸ�Ͽ�, �а��ο��� 2�� �̻��� �а� ������ ����� ����ϱ�.
 * */
import java.sql.*;
public class Exam2 {
	public static void main(String[] args) throws ClassNotFoundException, SQLException{
		Class.forName("org.mariadb.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/classdb","scott","1234");
		//����� ����
		  PreparedStatement pstmt1 = conn.prepareStatement
//			1.�������� �а� ��ȸ�Ͽ�, �� �а��� ������ ����� ����ϱ�
				  //("select distinct deptno from professor is not null");
//			2.�������� �а� ��ȸ�Ͽ�, �а��ο��� 2�� �̻��� �а� ������ ����� ����ϱ�.
				  ("select deptno from professor group by deptno having count(*)>=2");
			ResultSet rs = pstmt1.executeQuery();
			PreparedStatement pstmt2 = conn.prepareStatement
				("select * from professor where deptno=?");
			while(rs.next()) {
			pstmt2.setInt(1,rs.getInt(1));//=(1,rs.getInt(deptno)) rs ��ȸ�� �÷� �� ù��° �÷�
			ResultSet rs2 = pstmt2.executeQuery();
			System.out.println("---------"+rs.getInt(1)+"�а�---------");
			while(rs2.next()) {
			System.out.printf("��ȣ:%-5s,�̸�:%-5s,id:%-5s,position:%-5s,�޿�:%-5d,���ʽ�:%-5d,�а�:%-5s \n",
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
			System.out.println("---------"+i+"�а�--------");
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				System.out.printf("��ȣ:%-5s,�̸�:%-5s,id:%-5s,position:%-5s,�޿�:%-5d,���ʽ�:%-5d,�а�:%-5s,�Ի���:%s \n",
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

