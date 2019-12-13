package chap15;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
/*
 * 자바에서 제공되는 표준 입출력 객체
 * 표준입력:InputStream System.in : 키보드에서 입력.
 * 표준출력:PrintStream System.out : 콘솔(화면)에 데이터 출력
 * 표준오류:PrintStream System.err :콘솔(화면)에 데이터 출력
 * 
 * I/O스트림: 데이터 이동 통로, 단방향(입력,출력), 지연(버퍼가 존재)
 * 
 * 	입력			최상위
 * 		바이트: InputStream => 모든 데이터 처리가능/1바이트 단위로 읽음. 그래서 한글은 깨짐.. 1바이트 단위로만 깨짐,, 
 * 		문자형: Reader => 2바이트 단위로 읽음.
 * 		바이트 입력스트림 => 문자형 입력스트림: InputStreamReader : Reader 클래스의 하위클래스
 * 	출력
 * 		바이트: OutStream => 1바이트 단위로 출력.
 * 		문자형: Writer => 2바이트 단위로 출력.
 * 		바이트 입력스트림 => 문자형 입력스트림: OutputStreamWriter : Writer 클래스의 하위클래스
 */
public class InputStreamEx1 {
	public static void main(String[] args) throws IOException {
//		InputStream in = System.in;
		Reader in = new InputStreamReader(System.in);//System.in input스트림에서만 쓸수있기때문에 Reader에서 쓰려면 InputStreamReader가 필요
		int data = 0;
		while((data = in.read()) != -1) {//컨트롤+z while문 끝남.
			System.out.print((char)data);
		}
	}
}
