package chap7;
/*
 * 추상화: 클래스 생성 과정.
 * 클래스: 사용자 정의 자료형.
 * 	 속성: 멤버 변수
 * 	 기능: 멤버 메서드
 *
 * */
class Phone{
	String color;
	boolean power;
	String no;
	void power() {power=!power;}
	void send(String no) {
		System.out.println(no+"로 전화 송신중~~");
	}
	void receive(String no) {
		System.out.println(no+"전화 수신중~~");
	}
}
public class PhoneEx1 {
	public static void main(String[] args) {
		//Phone p1; => 참조변수 선언
		//new Phone() => 객체 생성. 객체화, 인스턴스화
		//new 예약어: 객체 생성기능. 메모리 할당함
		//		 	String을  제외한 모든 클래스의 객체 생성은 new 연산자로 가능함.
		Phone p1=new Phone(); //new => 메모리할당 p1이라는.and 기본값 초기화.
		p1.color="검정";
		p1.power= true;
		p1.no="01012345678";
		System.out.println(p1.color+","+p1.power+","+p1.no);
		p1.send("01043214321");
		p1.receive("01043214321");
		Phone p2=new Phone();
		/*
		 * new 예약어 가능
		 * 1. 힙영역에 메모리 할당.
		 * 2. 멤버변수를 기본값으로 초기화
		 * 		기본값: 숫자:0
		 * 			  boolean: false
		 * 			    그외 : null
		 * 3. 생성자 호출 기능
		 * */
//		System.out.println(p1.color+","+p1.power+","+p1.no);
		System.out.println(p2.color+","+p2.power+","+p2.no);
		p2=p1; //p1을 p2에 넣는다.
		/*
		 * p1 객체의 p2 객체는 같은 객체임.
		 * 하나의 객체는 두개의 참조변수가  참조 가능함.
		 * 하나의 참조변수가 두개의 객체는 참조  불가능함.
		 */
//		p1.power();
//		System.out.println(p1.color+","+p1.power+","+p1.no);
		System.out.println(p2.color+","+p2.power+","+p2.no);
	}
}
