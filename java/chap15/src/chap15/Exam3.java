package chap15;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/*
 * bin/chap15/PrintStreamEx1.class 파일은 이진파일이다.
 * 이 파일을 읽어서 화면에 코드값을 16진수로 출력하기
 * 
 * [결과]
 * CA FE BA .....17: 16개 정도
 */
public class Exam3 {
	public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream("bin/chap15/PrintStreamEx1.class");
		//byte배열이 16자리씩 넣어서 출력
//		int data=0;
//		byte [] buf =new byte[16];
//		while((data = fis.read(buf)) != -1) {
//			for(int i=0; i<data; i++) {
//				System.out.printf("%02X ",buf[i]);	//02 = 0찍고 2자리 확보.
//			}
//			System.out.println();
//		}
		
		System.out.println();
		
		//좋은방식은아님 한번에 data에읽어와서 16자리씩 끊는것.
		System.out.println("좋은방식은아님 한번에 data에읽어와서 16자리씩 끊는것.");
		byte [] buf =new byte[fis.available()];
		int data=fis.read(buf);
		int cnt=0;
		for(int i=0;i<data;i++) {
			if(++cnt % 16 ==0 )System.out.println();
			System.out.printf("%02X ",buf[i]);
		}
	}
}
