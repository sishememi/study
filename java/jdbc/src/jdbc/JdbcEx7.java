package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

/*
 * 1.subject 테이블 생성하기
 *   교과목 번호,과목명,시간
 * 2.Bean 클래스 생성하기
 * 3.subject테이블에 내용 추가,변경,삭제,조회 프로그램 작성하기
 */

public class JdbcEx7 {
	static Connection conn;// Connection 객체 static 
	static { //static 초기화 블럭
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
			System.out.println("\n============메뉴 선택=============");
			System.out.println("   1: 과목 추가 ");
			System.out.println("   2: 과목 변경 ");
			System.out.println("   3: 과목 삭제 ");
			System.out.println("   4: 과목 조회 ");
			System.out.println("   9: 프로그램 종료 ");
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
		System.out.println("프로그램 종료");
	}
	
	private static void delete() throws SQLException{
		select(); //삭제전 등록된 과목 목록 조회
		System.out.println("삭제할 과목번호를 입력하세요");
		Scanner scan = new Scanner(System.in);
		int no = scan.nextInt();
		PreparedStatement pstmt = conn.prepareStatement("delete from subject where no= ?");
		pstmt.setInt(1,no);
		pstmt.executeUpdate();
		System.out.println(no+"과목 삭제 완료");

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
		System.out.println("변경할 교과목 번호를 입력하세요");
		int no = scan.nextInt();
		
		PreparedStatement pstmt = conn.prepareStatement("select * from subject where no = ?");
		pstmt.setInt(1, no);//레코드조회
		ResultSet rs = pstmt.executeQuery();
		if(rs.next()) { //조회되는 내용이있나? 있으면 찍음
			//수정 전 데이터 출력
			Subject s = new Subject(rs.getInt("no"),rs.getString("name"),rs.getInt("hour"));//s 수정되기 전 객체
			System.out.println(s); 
			//여기까지 수정 전 데이터 출력
			
			System.out.println("과목명:"+s.getName()+"을 변경하시겠습니까(y/n)?"); //y만 가능
			String yn = scan.next();
			if(yn.equalsIgnoreCase("y")){//equalsIgnoreCase 대소문자 구별하지 않는 메서드, 구분없이 내용이 같은 경우 true 리턴.
				System.out.println("변경할 과목명을 입력하세요:");
				String name= scan.next();
				s.setName(name); //subject 객체에 과목명만 수정
			}else {
			System.out.println("시간:"+s.getHour()+"을 변경하시겠습니까(y/n)?");
			yn=scan.next();
			if(yn.equalsIgnoreCase("y")){
				System.out.println("변경할 시간을 입력하세요:");
				int hour = scan.nextInt();
				s.setHour(hour);
			}}
			pstmt.close();
			//update를 하기 위한 부분
			pstmt =conn.prepareStatement("update subject set name=?, hour=? where no=?");
			pstmt.setString(1, s.getName());
			pstmt.setInt(2, s.getHour());
			pstmt.setInt(3, s.getNo());
			pstmt.executeUpdate(); //변경완료
			System.out.println(s); //완료 후 찍어주기
			System.out.println("변경 완료");
					
		}
	}

	private static void insert() throws SQLException{
		Scanner scan = new Scanner(System.in);
	      System.out.print("과목명 : ");
	      String name = scan.next();
	      System.out.print("과목시간 : ");
	      int hour = scan.nextInt();

	      PreparedStatement pstmt = conn.prepareStatement("insert into subject (name, hour) values(?,?)");
	      pstmt.setString(1, name);
	      pstmt.setInt(2, hour);
	      pstmt.executeUpdate();
	      System.out.println(new Subject(name,hour)+ "추가 완료");
	}
	
}
