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
				System.out.println("\n========= 메뉴를 선택하세요 =========");
				System.out.println(" 1 : 가족회원추가 ");
				System.out.println(" 2 : 가족회원변경 ");
				System.out.println(" 3 : 가족회원탈퇴 ");
				System.out.println(" 4 : 가족회원목록조회 ");
				System.out.println(" 9 : 프로그램 종료 ");
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
			System.out.println("탈퇴할 가족 회원의 번호를 입력하세요:");
			Scanner scan = new Scanner(System.in);
			int fno = scan.nextInt();
			PreparedStatement pstmt = conn.prepareStatement("delete from syjfamily where fno= ?");
			pstmt.setInt(1,fno);
			pstmt.executeUpdate();
			System.out.println(fno+"탈퇴 완료");
			
		}

		private static void update() throws SQLException{

			Scanner scan = new Scanner(System.in);
			System.out.print("가족번호:");
			int fno = scan.nextInt();
			
			PreparedStatement pstmt = conn.prepareStatement("select * from syjfamily where fno=?");
			pstmt.setInt(1,fno);
			ResultSet rs = pstmt.executeQuery();
					
			  if(rs.next()) 
		      {
		         Family f = new Family(rs.getInt("fno"), rs.getString("name"), rs.getInt("age"), rs.getString("job"), rs.getInt("sex"));
		         System.out.println(f);
	
		         System.out.println("가족 이름 : " + f.getName() + "을 변경하시겠습니까(y/n)?");
		         String yn = scan.next();
		         if(yn.equalsIgnoreCase("y"))
		         {
		            System.out.println("변경할 이름을 입력 :");
		            String name = scan.next();
		            f.setName(name);
		         }

		         System.out.println("가족 나이 :" + f.getAge() + "을 변경하시겠습니까(y/n)?");
		         yn = scan.next();
		         if(yn.equalsIgnoreCase("y"))
		         {
		            System.out.println("변경할 나이를 입력 :");
		            int age = scan.nextInt();
		            f.setAge(age);
		         }

		         System.out.println("가족 직업 : " + f.getJob() + "을 변경하시겠습니까(y/n)?");
		         yn = scan.next();
		         if(yn.equalsIgnoreCase("y"))
		         {
		            System.out.println("변경할 직업을 입력 :");
		            String job = scan.next();
		            f.setJob(job);
		         }
		         System.out.println("가족 성별(1:남자, 2:여자) :" + f.getSex() + "을 변경하시겠습니까(y/n)?");
		         yn = scan.next();
		         if(yn.equalsIgnoreCase("y"))
		         {
		            System.out.println("변경할 성별을 입력 :");
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
		         System.out.println("변경 완료");
		      }
	}
		private static void insert() throws SQLException {
			Scanner scan = new Scanner(System.in);
			System.out.print("가족 이름:");
			String name = scan.next();
			System.out.print("가족 나이:");
			int age = scan.nextInt();
			System.out.print("가족 직업:");
			String job = scan.next();
			System.out.print("가족 성별(1:남자,2:여자):");
			int sex = scan.nextInt();
			
			PreparedStatement pstmt = conn.prepareStatement
					("insert into syjfamily (name,age,job,sex) values(?,?,?,?)");
			pstmt.setString(1,name);
			pstmt.setInt(2, age);
			pstmt.setString(3, job);
			pstmt.setInt(4, sex);
			pstmt.executeUpdate();
			System.out.println(new Family(name,age,job,sex)+"추가완료");
			
		}
}
