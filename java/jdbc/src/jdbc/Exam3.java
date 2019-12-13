package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Scanner;

/*
 * 콘솔에서 select 구문을 입력받아 화면에 출력하기.
 * 
 * 컬럼명1 컬럼명2
 * 값1    값2
 */
public class Exam3 {
	public static void main(String[] args)  throws ClassNotFoundException, SQLException{
		Scanner s = new Scanner(System.in);
		Class.forName("org.mariadb.jdbc.Driver");
		Connection conn = DriverManager.getConnection
				("jdbc:mariadb://localhost:3306/classdb","scott","1234");
		while(true) { //while(true) 무한반복 exit 쓰면 종료.
		System.out.println("select 구문을 입력하세요. (종료:exit)");
		String txt =  s.nextLine(); //콘솔로 입력 enter값이 들어가기떄문에 nextLine 으로 써야함
		if(txt.equals("exit"))break;
		PreparedStatement pstmt = conn.prepareStatement(txt);
		ResultSet rs = pstmt.executeQuery();
		ResultSetMetaData rsmt = rs.getMetaData();//rsmt.getColumnCount() 조회된 컬럼의 객수
		//레코드의 갯수 구하는부분~
		PreparedStatement pstmt2 = conn.prepareStatement("select count(*) from (" + txt +") a");//txt의 쿼리문의 count(*)를 세어 레코드 수 조회..
		ResultSet rs2 = pstmt2.executeQuery();
		rs2.next(); //~레코드 갯수 구하는 부분
		System.out.println("========================================================");
		System.out.println("조회된 컬럼수:"+rsmt.getColumnCount()); //metadata에서  받은 값으로 컬럼수 출력 가능
		System.out.println("조회된 레코드 갯수:"+rs2.getInt(1)); //metadata에서 조회된 레코드 수는 알 수 없다.
		System.out.println("========================================================");
		System.out.printf("%-10s%-15s%-10s\n","컬럼명","컬럼타입","NULL 허용");
		
		for(int i=1; i<=rsmt.getColumnCount();i++) { 
			System.out.printf("%-10s %-10s(%3d) %-10s\n",
					rsmt.getColumnName(i),
					rsmt.getColumnTypeName(i),
					rsmt.getColumnDisplaySize(i),
					(rsmt.isNullable(i)==0?"NOT NULL":"NULL"));
		}
		System.out.println("=========================================================");
		for(int i=1; i<=rsmt.getColumnCount();i++) { //컬럼명 헤더부분 출력
			System.out.print(rsmt.getColumnLabel(i)+"\t");
		}
		System.out.println();
		System.out.println("=========================================================");
		//레코드 출력
		while(rs.next()) {
			for(int i=1;i<=rsmt.getColumnCount();i++) {
				System.out.print(rs.getString(i)+"\t");
				}
			System.out.println();
			}	
		}
		System.out.println("프로그램 종료");
	}
}
