package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

/*
 * 1.subject ���̺� �����ϱ�
 *   ������ ��ȣ,�����,�ð�
 * 2.Bean Ŭ���� �����ϱ�
 * 3.subject���̺� ���� �߰�,����,����,��ȸ ���α׷� �ۼ��ϱ�
 */

public class JdbcEx7 {
	static Connection conn;// Connection ��ü static 
	static { //static �ʱ�ȭ ��
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			conn = DriverManager.getConnection
					("jdbc:mariadb://localhost:3306/classdb","scott","1234");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws SQLException {
		Scanner scan = new Scanner(System.in);
		while(true) {
			System.out.println("\n============�޴� ����=============");
			System.out.println("   1: ���� �߰� ");
			System.out.println("   2: ���� ���� ");
			System.out.println("   3: ���� ���� ");
			System.out.println("   4: ���� ��ȸ ");
			System.out.println("   9: ���α׷� ���� ");
			System.out.println("===============================");
			int num = scan.nextInt();
			if(num==9) break; 			
			switch(num) {
				case 1 : insert(); break;
				case 2 : update(); break;
				case 3 : delete(); break;
				case 4 : select(); break;				
			}		
		}
		System.out.println("���α׷� ����");
	}
	
	private static void delete() throws SQLException{
		select(); //������ ��ϵ� ���� ��� ��ȸ
		System.out.println("������ �����ȣ�� �Է��ϼ���");
		Scanner scan = new Scanner(System.in);
		int no = scan.nextInt();
		PreparedStatement pstmt = conn.prepareStatement("delete from subject where no= ?");
		pstmt.setInt(1,no);
		pstmt.executeUpdate();
		System.out.println(no+"���� ���� �Ϸ�");

	}

	private static void select() throws SQLException {
		PreparedStatement pstmt = conn.prepareStatement("select * from subject");
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			Subject s = new Subject(rs.getInt("no"),rs.getString("name"),rs.getInt("hour"));
				System.out.println(s);
		}
	}


	private static void update() throws SQLException{
		Scanner scan = new Scanner(System.in);
		System.out.println("������ ������ ��ȣ�� �Է��ϼ���");
		int no = scan.nextInt();
		
		PreparedStatement pstmt = conn.prepareStatement("select * from subject where no = ?");
		pstmt.setInt(1, no);//���ڵ���ȸ
		ResultSet rs = pstmt.executeQuery();
		if(rs.next()) { //��ȸ�Ǵ� �������ֳ�? ������ ����
			//���� �� ������ ���
			Subject s = new Subject(rs.getInt("no"),rs.getString("name"),rs.getInt("hour"));//s �����Ǳ� �� ��ü
			System.out.println(s); 
			//������� ���� �� ������ ���
			
			System.out.println("�����:"+s.getName()+"�� �����Ͻðڽ��ϱ�(y/n)?"); //y�� ����
			String yn = scan.next();
			if(yn.equalsIgnoreCase("y")){//equalsIgnoreCase ��ҹ��� �������� �ʴ� �޼���, ���о��� ������ ���� ��� true ����.
				System.out.println("������ ������� �Է��ϼ���:");
				String name= scan.next();
				s.setName(name); //subject ��ü�� ����� ����
			}else {
			System.out.println("�ð�:"+s.getHour()+"�� �����Ͻðڽ��ϱ�(y/n)?");
			yn=scan.next();
			if(yn.equalsIgnoreCase("y")){
				System.out.println("������ �ð��� �Է��ϼ���:");
				int hour = scan.nextInt();
				s.setHour(hour);
			}}
			pstmt.close();
			//update�� �ϱ� ���� �κ�
			pstmt =conn.prepareStatement("update subject set name=?, hour=? where no=?");
			pstmt.setString(1, s.getName());
			pstmt.setInt(2, s.getHour());
			pstmt.setInt(3, s.getNo());
			pstmt.executeUpdate(); //����Ϸ�
			System.out.println(s); //�Ϸ� �� ����ֱ�
			System.out.println("���� �Ϸ�");
					
		}
	}

	private static void insert() throws SQLException{
		Scanner scan = new Scanner(System.in);
	      System.out.print("����� : ");
	      String name = scan.next();
	      System.out.print("����ð� : ");
	      int hour = scan.nextInt();

	      PreparedStatement pstmt = conn.prepareStatement("insert into subject (name, hour) values(?,?)");
	      pstmt.setString(1, name);
	      pstmt.setInt(2, hour);
	      pstmt.executeUpdate();
	      System.out.println(new Subject(name,hour)+ "�߰� �Ϸ�");
	}
	
}
