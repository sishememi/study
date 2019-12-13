package chap15;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
/*
 * System.out의 타입 PrintStream
 * PrintStream은  OutputStream의 하위클래스임.
 */
public class OutputStreamEx1 {
	public static void main(String[] args) throws IOException {
//		OutputStream out = System.out;//부모타입의 System.out을 참조할 수 있다.
//		out.println('a'); //println 타입이  PrintStream이라 에러.. OutputStream의 멤버가 아니다.
//		out.write('1');out.write('2');out.write('3');
//		out.write('a');out.write('b');out.write('c');
//		out.write('가');out.write('나');out.write('다'); //안나옴  OutputStream은 1바이트만 찍음
//		out.flush();
		
		//가나다 출력할 수 있는  출력 문자형 Writer을 사용
		Writer out = new OutputStreamWriter(System.out);
		out.write('1');out.write('2');out.write('3');
		out.write('a');out.write('b');out.write('c');
		out.write('가');out.write('나');out.write('다'); 
		out.flush(); // 버퍼의 내용을 목적지로 강제 전송
	}
}
