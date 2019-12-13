package chap14;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
/*
 * Properties 클래스 Hashtable 테이블의 하위클래스임.
 * Hashtable은  Map 인터페이스의 구현클래스이므로 Properties 클래스도 Map을 구현한 클래스다.
 * (key,value) 자료형이 모두 String임. 제네릭표현 안한다.
 * -텍스트파일에서 Map 객체를 추가할 수 있는 기능이 있다.
 */
public class PropertiesEx1 {
	public static void main(String[] args) throws IOException {
		Properties pr = new Properties();//Properties() 객체생성 
		System.out.println(pr);//아무것도 없음
		FileInputStream fis = new FileInputStream("a.properties");//FileInputStream=>a.properties를 지정함.fis에 a.pr~ 파일을 읽을준비를 완료한 상태.
		pr.load(fis); //== pr.load(new FileInputStream("a.properties"));
		System.out.println(pr);
		System.out.println("이름: "+pr.get("name"));//pr.get("name") : 키가 객체의 value를 리턴, : 홍길동
		System.out.println("전화번호: "+pr.getProperty("tel"));//pr.getProperty() :Hashtable이 이전에 사용되던 get 메서드. 전화번호를 가져옴
		pr.put("subject","컴퓨터공학"); //properties에 subject,컴퓨터공학 추가(put)
		System.out.println(pr);
		//FileOutputStream : 파일 생성하기.
		FileOutputStream fos = new FileOutputStream("b.properties");
		//pr 객체의 (key,value) 객체를 파일로 생성
		pr.store(fos, "#save");//"#save"가 보이면 저장해 #은 properties에서 주석
		//pr.store(new FileOutputStream("b.properties"), "#save");//== FileOutputStream fos = new FileOutputStream("b.properties");
				
	}
}
