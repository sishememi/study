package chap15;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

/*
 * FileInputStream : 파일로 부터 데이터를 읽기
 * 	int read() : 1byte를  읽어서 리턴.
 * 	int read(byte[] buf) : buf의 크기만큼 읽어서 데이터를 buf에 저장. 실제로 읽은 byte수 리턴.
 * 	int read(byte[] buf, int start, int len) :
 * 					데이터를 len바이트 만큼 읽어서 buf에 start 인덱스 부터 저장.
 * 					실제 읽은 바이트 수 리턴.
 */
public class FileInputStreamEx1 {
	public static void main(String[] args) throws IOException{
		FileInputStream fis = new FileInputStream("src/chap15/InputStreamEx1.java");
		System.out.println("***********read() 메서드를 이용하여 읽기");
		int data =0;
		while((data = fis.read()) != -1) {
			System.out.print((char)data);
		}
		System.out.println("***********read(byte [] buf) 메서드를 이용하여 읽기");
		fis = new FileInputStream("src/chap15/InputStreamEx1.java"); //String은 한번만 읽을 수 있어서 여기서 다시 생성.
		byte [] buf = new byte[fis.available()];
		//fis.available() : 읽기 가능 바이트 수 리턴
		while((data = fis.read(buf)) != -1) {
			//buf의 0번 인덱스 부터 data 길이 만큼을 문자열 변경
			System.out.print(new String(buf,0,data));
		}
		
		System.out.println("***********int read(byte[] buf, int start, int len) 메서드를 이용하여 읽기");
		fis = new FileInputStream("src/chap15/InputStreamEx1.java");
		buf = new byte[fis.available()];
		//fis.available() : 읽기 가능 바이트 수 리턴
		while((data = fis.read(buf , 0 ,buf.length)) != -1) {
			System.out.print(new String(buf,0,data));
		}
	}
}
