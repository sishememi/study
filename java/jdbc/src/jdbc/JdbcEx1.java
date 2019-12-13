package jdbc;
/*
 * Java �� DBMS(maria db���) �����ϱ�
 * 1.����̹� ����(mariadb-java-client-2.4.2.jar) classpath ����. ��뵵������ 
 * 2.JDBC ���� ��Ű��: java.sql.*
 * 3.����̹� Ŭ������ �ε��ϱ�
 * 4.db�� java�� �����ϴ� ��ü ����.
 * 5.SQL ��ɹ��� DB�� ��� ���� ��ü ����.
 * 6.Statement ��ü�� �̿��Ͽ� Sql���� ����. ��� ���
 * 
 * maria db�� 1.������ �ϰԵȴ�. 2.���� 3.�������
 * */

import java.sql.*; //java.sql ��Ű���� ��� Ŭ���� ���

public class JdbcEx1 {
	public static void main(String[] args) throws ClassNotFoundException, SQLException{
		//3. ����̹� Ŭ������ �ε��ϱ�,Class.forName -> Ŭ������ã��
		Class.forName("org.mariadb.jdbc.Driver"); //���ڿ��� ������ Ŭ������  �޸𸮿� �ε�.
		//4. db�� java�� �����ϴ� ��ü ����.
		Connection conn = DriverManager.getConnection
				 ("jdbc:mariadb://localhost:3306/classdb","scott","1234");
		//5. SQL ��ɹ��� DB�� ��� ���� ��ü ����.
		Statement stmt = conn.createStatement();
		//6. Statement ��ü�� �̿��Ͽ� Sql���� ����. ��� ���
		ResultSet rs = stmt.executeQuery("select * from student");
		//7.�����ȸ
		while(rs.next()) { //�Ѱ� ���ڵ徿 ��ȸ
			System.out.print("�й�:"+rs.getString("studno"));
			System.out.print(",�̸�:"+rs.getString("name"));
			System.out.print(",�г�:"+rs.getString("grade"));
			System.out.print(",Ű:"+rs.getString("height"));
			System.out.print(",������:"+rs.getString("weight"));
			System.out.println(",�а��ڵ�:"+rs.getString("major1"));
		}
		
		//����:�������̺��� ������ ��ȣ,�̸�,id,�Ի���,�޿�,���ʽ�,�а��ڵ带 ȭ�鿡 ����ϱ�
		ResultSet rs1 = stmt.executeQuery("select * from professor");
		
		while(rs1.next()) { //�Ѱ� ���ڵ徿 ��ȸ
			System.out.print("��ȣ:"+rs1.getString("no"));
			System.out.print(",�̸�:"+rs1.getString("name"));
			System.out.print(",id:"+rs1.getString("id"));
			System.out.print(",�Ի���:"+rs1.getString("hiredate"));
			System.out.print(",�޿�:"+rs1.getString("salary"));
			System.out.print(",���ʽ�:"+rs1.getString("bonus"));
			System.out.println(",�а��ڵ�:"+rs1.getString("deptno"));
		}
	}
}