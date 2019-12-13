package chap15;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/*
 * 화면에서 파일명을 입력받아서 해당 파일의 내용을 화면에 출력하기
 * 만약 파일이 없는 경우는 '해당 파일 없음' 을 출력하기.
 * 한글은 깨지지 않아야함.
 * FileInputStream 사용하기
 */
public class Exam1 {
	public static void main(String[] args) throws IOException{
		System.out.println("파일명을 입력하세요");
		Scanner scan = new Scanner(System.in);
		String fname = scan.next();
		try {
			//FileInputStream fis = new FileInputStream("src/chap15/"+fname+".java");
			FileInputStream fis = new FileInputStream(fname);
			byte [] buf = new byte[fis.available()];
			int data = 0;
			while((data = fis.read(buf))!= -1) {
				System.out.println(new String(buf,0,data));
			}
		} catch (FileNotFoundException e) {
			System.out.println("해당 파일 없음");
			//e.printStackTrace();
		}
	}

}
