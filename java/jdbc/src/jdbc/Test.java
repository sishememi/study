package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Test {
	static Connection conn;
	static {
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
				System.out.println("\n========= �޴��� �����ϼ��� =========");
				System.out.println(" 1 : ����ȸ���߰� ");
				System.out.println(" 2 : ����ȸ������ ");
				System.out.println(" 3 : ����ȸ��Ż�� ");
				System.out.println(" 4 : ����ȸ�������ȸ ");
				System.out.println(" 9 : ���α׷� ���� ");
				System.out.println("==================================");
				int num=scan.nextInt();
				if(num==9) break;
				switch(num) {
				case 1 :insert(); break;
				case 2 :update(); break;
				case 3 :delete(); break;
				case 4 :select(); break;
				
				}
			}
		
		}
		
		private static void select() throws SQLException{
			PreparedStatement pstmt = conn.prepareStatement("select * from syjfamily");
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				Family f = new Family(rs.getInt("fno"),rs.getString("name"),rs.getInt("age"),rs.getString("job"),rs.getInt("sex"));
					System.out.println(f);
			}
		}

		private static void delete() throws SQLException{
			select();
			System.out.println("Ż���� ���� ȸ���� ��ȣ�� �Է��ϼ���:");
			Scanner scan = new Scanner(System.in);
			int fno = scan.nextInt();
			PreparedStatement pstmt = conn.prepareStatement("delete from syjfamily where fno= ?");
			pstmt.setInt(1,fno);
			pstmt.executeUpdate();
			System.out.println(fno+"Ż�� �Ϸ�");
			
		}

		private static void update() throws SQLException{

			Scanner scan = new Scanner(System.in);
			System.out.print("������ȣ:");
			int fno = scan.nextInt();
			
			PreparedStatement pstmt = conn.prepareStatement("select * from syjfamily where fno=?");
			pstmt.setInt(1,fno);
			ResultSet rs = pstmt.executeQuery();
					
			  if(rs.next()) 
		      {
		         Family f = new Family(rs.getInt("fno"), rs.getString("name"), rs.getInt("age"), rs.getString("job"), rs.getInt("sex"));
		         System.out.println(f);
	
		         System.out.println("���� �̸� : " + f.getName() + "�� �����Ͻðڽ��ϱ�(y/n)?");
		         String yn = scan.next();
		         if(yn.equalsIgnoreCase("y"))
		         {
		            System.out.println("������ �̸��� �Է� :");
		            String name = scan.next();
		            f.setName(name);
		         }

		         System.out.println("���� ���� :" + f.getAge() + "�� �����Ͻðڽ��ϱ�(y/n)?");
		         yn = scan.next();
		         if(yn.equalsIgnoreCase("y"))
		         {
		            System.out.println("������ ���̸� �Է� :");
		            int age = scan.nextInt();
		            f.setAge(age);
		         }

		         System.out.println("���� ���� : " + f.getJob() + "�� �����Ͻðڽ��ϱ�(y/n)?");
		         yn = scan.next();
		         if(yn.equalsIgnoreCase("y"))
		         {
		            System.out.println("������ ������ �Է� :");
		            String job = scan.next();
		            f.setJob(job);
		         }
		         System.out.println("���� ����(1:����, 2:����) :" + f.getSex() + "�� �����Ͻðڽ��ϱ�(y/n)?");
		         yn = scan.next();
		         if(yn.equalsIgnoreCase("y"))
		         {
		            System.out.println("������ ������ �Է� :");
		            int sex = scan.nextInt();
		            f.setSex(sex);
		         }         
		         pstmt.close();
		         pstmt = conn.prepareStatement("update syjfamily set name =?, age=?, job=?, sex=? where fno =?");
		         pstmt.setString(1, f.getName());
		         pstmt.setInt(2, f.getAge());
		         pstmt.setString(3, f.getJob());
		         pstmt.setInt(4, f.getSex());
		         pstmt.setInt(5, f.getFno());
		         pstmt.executeUpdate();
		         System.out.println(f);
		         System.out.println("���� �Ϸ�");
		      }
	}
		private static void insert() throws SQLException {
			Scanner scan = new Scanner(System.in);
			System.out.print("���� �̸�:");
			String name = scan.next();
			System.out.print("���� ����:");
			int age = scan.nextInt();
			System.out.print("���� ����:");
			String job = scan.next();
			System.out.print("���� ����(1:����,2:����):");
			int sex = scan.nextInt();
			
			PreparedStatement pstmt = conn.prepareStatement
					("insert into syjfamily (name,age,job,sex) values(?,?,?,?)");
			pstmt.setString(1,name);
			pstmt.setInt(2, age);
			pstmt.setString(3, job);
			pstmt.setInt(4, sex);
			pstmt.executeUpdate();
			System.out.println(new Family(name,age,job,sex)+"�߰��Ϸ�");
			
		}
}
