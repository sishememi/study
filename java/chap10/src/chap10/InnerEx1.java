package chap10;
/*
 * 내부 클래스 예제
 *  
 * 인스턴스 내부클래스: static이 붙어있는 클래스 멤버를 가질 수 없다. 단 상수는 가능.
 * static 내부클래스: 클래스 멤버를 가질 수 있다.
 * 지역내부클래스: 메서드 내에 선언된 클래스. 메서드 내부에서만 사용이 가능함.
 * 이름없는(무명의) 내부클래스: 클래스 이름없이 객체화 가능한 클래스
 * 						추상클래스,인터페이스의 객체화 가능함.
 * 
 * 
 * 내부클래스의 특징
 * 	1. 클래스 내부에 존재하는 클래스
 * 	2. 자료형으로 사용됨. 객체화 가능, Object 클래스의 하위 클래스임.
 * 		멤버(변수,메서드,생성자)를 소유할 수 있다.
 * 	3. 외부 클래스의 멤버임. => 외부클래스의 private 멤버에 접근이 가능.
 */
class Outer1{
	class InstanceInner{  //인스턴스 내부클래스
		int iv=100;
//		static int cv = 10;  //클래스 멤버를 가질 수 없다. 인스턴스 내부 클래스이기때문.error
		final static int MAX =200;//하지만 상수는 클래스 멤버로 가질 수 있다.
	}
	static class StaticInner{   //static 내부클래스
		int iv=300;
		static int cv = 400;  //클래스 멤버를 가질 수 있다.
		final static int MAX = 500;
	}
	void method() {
		class LocalInner{  //지역 내부클래스
			int iv=600;
//			static int cv=700;  //클래스 멤버를 가질 수 없다. error
			final static int MAX=700; //상수는 가능.
		}
		LocalInner lc = new LocalInner(); //내가 선언된 내부에서만 객체생성가능
		System.out.println(lc.iv); //600
		System.out.println(lc.MAX); //700
		System.out.println(LocalInner.MAX); //700

	}
	void method2() {
//		LocalInner lc = new LocalInner();   => method() 메서드에서만 사용가능 
	}
}
public class InnerEx1 {
	public static void main(String[] args) {
		Outer1.StaticInner si = new Outer1.StaticInner();
		System.out.println(si.iv);//300 
		System.out.println(Outer1.StaticInner.cv);// 400  static이라 객체화 될  필요 없음.
		System.out.println(Outer1.StaticInner.MAX);//500
		Outer1.InstanceInner ii = new Outer1().new InstanceInner();
		Outer1 outer = new Outer1();
		Outer1.InstanceInner ii2 = outer.new InstanceInner();
		System.out.println(ii2.iv);//100
		System.out.println(Outer1.InstanceInner.MAX);//200 max값이 상수라 이렇게 접근 가능.
		outer.method();
	}
}
