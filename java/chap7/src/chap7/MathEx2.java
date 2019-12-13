package chap7;
/*
 * 멤버 메서드의 종류
 * 	 클래스 메서드
 * 	 인스턴스 메서드
 * */
class Math2{
	int a,b; //인스턴스 변수/ 객체화가 되어야한다....?
	
	//인스턴스 메서드: 객체화가 되어야 메서드의 호출이 가능함. 참조변수명.메서드명() 호출해야함.
	int add1() {
		return a+b;
	}
	//클래스 메서드 : 클래스정보 로드될때 메서드의 호출이 가능함. 클래스명.메서드명() 호출 할 수 있다.
	static int add2(int a, int b) { return a+b;}

}
public class MathEx2 {
	public static void main(String[] args) { //대표적인 클래스 메서드.메인에 static을 반드시 써야하는이유 jvm이 접근할 방법이없다..객체화시키지않고 바로 접근하기위해
		Math2 m = new Math2();
		m.a=10;
		m.b=20;
		System.out.println(m.add1());//30
		System.out.println(m.add2(100, 200));//300
		System.out.println(Math2.add2(100, 200));//300
	}
}
