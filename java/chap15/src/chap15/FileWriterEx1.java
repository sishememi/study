package chap15;


import java.io.FileWriter;
import java.io.IOException;

/*
 * FileWriter 예제
 * 		:파일에 데이터 출력
 * 	void write(int data) : data 중 1바이트만 파일로 출력
 * 	void write(char[] buf) : buf의 내용을 파일로 출력
 * 	void write(char[] buf, int start, int len): buf의 start 인덱스 부터 len 바이트 만큼 내용을 파일로 출력
 */
public class FileWriterEx1 {
	public static void main(String[] args) throws IOException {
		FileWriter fos = new FileWriter("out2.txt");//FileWriter="out2.txt" 생성
		fos.write('1');fos.write('2');fos.write('3');
		fos.write('a');fos.write('b');fos.write('c');
		fos.write('가');fos.write('나');fos.write('다');
		//.getBytes() : 문자열을 byte[](배열)로 리턴.
		char[] buf = "\n반갑습니다. FileOutputStream 예제입니다.\n" .toCharArray(); //문자가 out2.txt에 들어간다.
		fos.write(buf);
		fos.write(buf,1,6);
		fos.write("안녕"); //write일때만 문자열 입력가능.
		fos.flush();
	}
}
