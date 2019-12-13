package jdbc;
/*
 * select ���� ����: ���ڵ� ������ ��ȸ.:ResultSet executeQuery(Sql)
 * DDL,DML ���� ����: ���� �߻�             :int executeUpdate(Sql)
 * 		executeUpdate ���� �� ����� ����� ���ڵ� ���� ����
 * */

import java.sql.*;

public class JdbcEX2 {
	public static void main(String[] args) throws ClassNotFoundException, SQLException{
		Class.forName("org.mariadb.jdbc.Driver"); //���ڿ��� ������ Ŭ������  �޸𸮿� �ε�.
		Connection conn = DriverManager.getConnection
				 ("jdbc:mariadb://localhost:3306/classdb","scott","1234");
		Statement stmt = conn.createStatement();
		String sql="create table jdbctemp (id int primary key ,name varchar(100))";
		
		int result = stmt.executeUpdate(sql); //����(�߰�,����,����)�� ���ڵ� ����.
		System.out.println("1. ���:"+result);
		sql="insert into jdbctemp values(1,'ȫ�浿')";
		result = stmt.executeUpdate(sql); //�߰��� ���ڵ� 1��
		System.out.println("2. ���:"+result);//1
		sql="insert into jdbctemp values(2,'���')";
		result = stmt.executeUpdate(sql);//�߰��� ���ڵ� 1��
		System.out.println("3. ���:"+result);
		sql="delete from jdbctemp where id=1";
		result = stmt.executeUpdate(sql);//������ ���ڵ� 1��
		System.out.println("4. ���:"+result);
		
	}
}
