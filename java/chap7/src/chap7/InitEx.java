package chap7;
/*
 * 초기화 블럭 예제
 * static 초기화 블럭:
 * 		주요기능: 클래스 변수의 초기화 
 * 		실행시기: 클래스 정보가 로드 되고, 한번 실행.
 * 인스턴스 초기화 블럭
 * 		주요기능: 인스턴스 변수의 초기화. 생성자와 기능이 겹겹침
 * 		실행시기: 객체 생성시 생성자 호출전에 먼저 호출됨.
*/
public class InitEx {

	static int cv; //클래스변수
	int iv; // 인스턴스 변수
	InitEx(){  //생성자
		System.out.println("5.생성자 호출 됨");
		}
	static {  //static 초기화 블럭 /  클래스멤버만 접근
		cv = (int)(Math.random() * 100);
		System.out.println("1.클래스 초기화 블럭  cv="+cv);
	}
	
	{ //인스턴스 초기화 블럭  / 인스턴스 멤버 (거의 쓰진않음)
		System.out.println("4.인스턴스 초기화 블럭. 생성자보다 먼저 호출됨");
		iv = (int)(Math.random() * 100);
	}
	public static void main(String[] args) {
		System.out.println("2.main 메서드 시작.");
		System.out.println("3.main init1 객체 생성");
		InitEx init1 = new InitEx();
		System.out.println("main init2 객체 생성");
		InitEx init2 = new InitEx();
		
	}
}
