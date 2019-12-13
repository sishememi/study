package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Scanner;

/*
 * �ֿܼ��� select ������ �Է¹޾� ȭ�鿡 ����ϱ�.
 * 
 * �÷���1 �÷���2
 * ��1    ��2
 */
public class Exam3 {
	public static void main(String[] args)  throws ClassNotFoundException, SQLException{
		Scanner s = new Scanner(System.in);
		Class.forName("org.mariadb.jdbc.Driver");
		Connection conn = DriverManager.getConnection
				("jdbc:mariadb://localhost:3306/classdb","scott","1234");
		while(true) { //while(true) ���ѹݺ� exit ���� ����.
		System.out.println("select ������ �Է��ϼ���. (����:exit)");
		String txt =  s.nextLine(); //�ַܼ� �Է� enter���� ���⋚���� nextLine ���� �����
		if(txt.equals("exit"))break;
		PreparedStatement pstmt = conn.prepareStatement(txt);
		ResultSet rs = pstmt.executeQuery();
		ResultSetMetaData rsmt = rs.getMetaData();//rsmt.getColumnCount() ��ȸ�� �÷��� ����
		//���ڵ��� ���� ���ϴºκ�~
		PreparedStatement pstmt2 = conn.prepareStatement("select count(*) from (" + txt +") a");//txt�� �������� count(*)�� ���� ���ڵ� �� ��ȸ..
		ResultSet rs2 = pstmt2.executeQuery();
		rs2.next(); //~���ڵ� ���� ���ϴ� �κ�
		System.out.println("========================================================");
		System.out.println("��ȸ�� �÷���:"+rsmt.getColumnCount()); //metadata����  ���� ������ �÷��� ��� ����
		System.out.println("��ȸ�� ���ڵ� ����:"+rs2.getInt(1)); //metadata���� ��ȸ�� ���ڵ� ���� �� �� ����.
		System.out.println("========================================================");
		System.out.printf("%-10s%-15s%-10s\n","�÷���","�÷�Ÿ��","NULL ���");
		
		for(int i=1; i<=rsmt.getColumnCount();i++) { 
			System.out.printf("%-10s %-10s(%3d) %-10s\n",
					rsmt.getColumnName(i),
					rsmt.getColumnTypeName(i),
					rsmt.getColumnDisplaySize(i),
					(rsmt.isNullable(i)==0?"NOT NULL":"NULL"));
		}
		System.out.println("=========================================================");
		for(int i=1; i<=rsmt.getColumnCount();i++) { //�÷��� ����κ� ���
			System.out.print(rsmt.getColumnLabel(i)+"\t");
		}
		System.out.println();
		System.out.println("=========================================================");
		//���ڵ� ���
		while(rs.next()) {
			for(int i=1;i<=rsmt.getColumnCount();i++) {
				System.out.print(rs.getString(i)+"\t");
				}
			System.out.println();
			}	
		}
		System.out.println("���α׷� ����");
	}
}
