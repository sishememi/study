package chap15;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/*
 * 화면에서 파일명을 입력받고,내용을 입력받아 입력받은 파일에 입력된 내용을 저장하기.
 * exit가 입력되면 내용 입력 종료하기.
 * 
 * [결과]
 * 파일명을 입력하세요
 * aaa.txt
 * 저장할 내용을 입력하세요
 * 안녕하세요
 * 반갑습니다.
 * exit
 * 
 * aaa.txt 파일의 내용
 * 안녕하세요
 * 반갑습니다.
 */
public class Exam2 {
	public static void main(String[] args) throws IOException{

//			Scanner s = new Scanner(System.in);
//			System.out.println("파일명을 입력하세요");
//			String file = s.next();
//			System.out.println("저장할 내용을 입력하세요");
//			while(true) {
//				String t = s.next();
//				if(t.equalsIgnoreCase("exit")) break;
//				FileOutputStream fos = new FileOutputStream(file,true);
//				fos.write((t+"\n").getBytes());
//		}
		//FileWriter 버전
		Scanner s = new Scanner(System.in);
		System.out.println("파일명을 입력하세요");
		String file = s.next();
		FileWriter f = new FileWriter(file,true);
		System.out.println("내용을 입력하세요:(종료:exit)");
		while(true) {
			String txt =s.next();
			if(txt.equals("exit"))break;
			
			f.write(txt+"\n");
		}
		f.flush();
	}
}
