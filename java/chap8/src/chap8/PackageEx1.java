package chap8;

import chap8.packtest.Pack2; //를 기입하면 chap8.packtest.Pack2 p2 = new chap8.packtest.Pack2 이렇게 기입하지 않아도됨
import java.util.Date;
/*
 * package: 클래스들의 모임.
 * 		클래스이름은 패키지명을 포함한다.
 * 		package 설정은 파일의 처음에 한번만 설정이 가능하다.
 * 		=> 하나의 파일에 있는 모든 클래스는 같은 패키지에 속한 클래스다.
 * 
 * import: 패키지명을 생략할 수 있도록 미리 사용될 클래스의 패키지를 선언하는 문장.
 * 
 * 클래스의 이름을 생략할 수 있는 경우
 * 	1. 같은 패키지에 속한 클래스는 패키지명을 생략할 수 있다.
 *  2. java.lang 패키지에 속한 클래스들은 패키지명을 생략 가능함.
 *  3. import 구문으로 설정된 클래스는 패키지명 생략 가능
 * 
 * */

class Pack1{
	void method() {
		System.out.println("chap8.Pack1.method() 호출됨");
	}
}
public class PackageEx1 {
	public static void main(String[] args) {
		Pack1 p1 = new Pack1(); //진짜이름 chap8.Pack1임 생략해도 이 안에 Pack1 이 있어서 가능
		p1.method();
		Pack2 p2 = new Pack2(); //다른 클래스에 있는 Pack2이기때문에 전체 이름 chap8.packtest.Pack2를 써줌
		p2.method();
//		java.util.Date d = new java.util.Date();
		Date d = new Date(); //import java.util.Date;를 기입하면 이렇게 써도됨
		
	}
}
