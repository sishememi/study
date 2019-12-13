package chap15;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

/*
 * 보조 스트림 : PrintStream (예외처리를 안하도록 ..만들어짐?.,.)
 * 		- OutputStream의 하위 클래스
 * 		- print(),println(),printf() 메서드 추가
 * 		  	모든 자료형을 출력.
 * 			예외처리 생략이 가능한 메서드
 * 		- System.out(표준 출력),System.err(표준 오류)의 자료형임.
 */
public class PrintStreamEx1 {
	public static void main(String[] args) throws IOException {
		FileOutputStream fos = new FileOutputStream("print.txt");
		PrintStream ps = new PrintStream(fos,true); //매개변수 output스트림/true:autoflush 기능 추가
		ps.println("홍길동");
		ps.println(1234);
		ps.println(true);
		ps.println(65);//65
		ps.write(65);//A.
	//	ps.flush();
		ps = new PrintStream("print2.txt"); //위에 PrintStream ps = new PrintStream(fos); 되어있으면 알아서 파일생성으로 인지
		ps.println("홍길동");
		ps.println(1234);
		ps.println(true);
		ps.println(65);//65
		ps.write(65);//A.
		ps.flush();
	}
}
