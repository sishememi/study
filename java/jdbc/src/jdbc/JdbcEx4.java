package jdbc;

import java.sql.*;
/*
 * PreparedStatement ����
 */
 public class JdbcEx4 {
	public static void main(String[] args) throws ClassNotFoundException, SQLException{
		Class.forName("org.mariadb.jdbc.Driver");
		Connection conn = DriverManager.getConnection
				("jdbc:mariadb://localhost:3306/classdb","scott","1234");
		String sql = "create table login"+"(id varchar(10) primary key,password varchar(10))";
		 PreparedStatement pstmt = conn.prepareStatement(sql);
		 int result = pstmt.executeUpdate(); //login ���̺� ����
		 System.out.println("login ���̺� create :"+result);
		 pstmt.close();//sql ���� ����
		 sql = "insert into login(id,password) values(?,?)";//�ΰ��� ����ǥ
		 pstmt = conn.prepareStatement(sql);
		 pstmt.setString(1,"hongkd");//ù��° ������
		 pstmt.setString(2, "ȫ�浿");//�ι�° ����ǥ
		 result = pstmt.executeUpdate();//insert ��������
		 System.out.println("ȫ�浿 insert : "+result);
		 pstmt.setString(1,"sagatk");
		 pstmt.setString(2, "���");
		 result = pstmt.executeUpdate();//insert ��������
		 System.out.println("���  insert : "+result);
		 pstmt.setString(1,"monglee");
		 pstmt.setString(2, "�̸���");
		 result = pstmt.executeUpdate();//insert ��������
		 System.out.println("�̸���  insert : "+result);
		 
		 pstmt.close();
		 sql="select * from login"; 
		 pstmt = conn.prepareStatement(sql);//���ο� ���� ����
		 ResultSet rs = pstmt.executeQuery();
		 while(rs.next()) {
			 System.out.printf("���̵�:%-12s, ��й�ȣ:%-12s\n",
					 rs.getString(1),rs.getString(2));
		 }
		 pstmt.close(); //������ ������..
		 sql = "drop table login";
		 pstmt = conn.prepareStatement(sql);
		 result = pstmt.executeUpdate();//drop ���̺� ����
		 System.out.println("login ���̺� drop:"+result);
		 conn.close();
	}
	
}
