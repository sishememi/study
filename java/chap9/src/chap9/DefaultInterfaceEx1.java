package chap9;
/*
 * jdk8.0 이후에 인터페이스도 구현부를 가진 메서드를 멤버로 가질 수 있다.
 * 
 * default 메서드: 인스턴스멤버
 * 				 다중 구현이 가능하므로 똑같은 default 메서드가 존재할 수 있다.
 * 				=> 구현클래스에서 오버라이딩이 필요함.
 * static 메서드: 클래스멤버
 * */
interface MyInterface1{
	void method();
	default void method1() {
		System.out.println("MyInterface1의 디폴트 메서드: method1()");
	}
	static void staticMethod() { //클래스 멤버이기 때문에 충돌x 클래스정보에 따라 따라가기때문에
		System.out.println("MyInterface1의 static 메서드: staticMethod()");
	}
}

interface MyInterface2{
	void method();
	default void method1() {
		System.out.println("MyInterface2의 디폴트 메서드: method1()");
	}
	static void staticMethod() {
		System.out.println("MyInterface2의 static 메서드: staticMethod()");
	}
}

class Parent{
	public void method2() {
		System.out.println("Parent 클래스의 멤버 메서드 : method2()");
	}
}
class Child extends Parent implements MyInterface1,MyInterface2{//class Child extends Parent implements MyInterface1,MyInterface2는 다중 구현이 되지만 ,
	//method1()이 두개가 들어옴.그 때 override 해야댐
	/*
	 *  MyInterface1,MyInterface2  인터페이스의 method1 default 메서드가 충돌 발생
	 *  => Child 클래스에서 반드시 오버라이딩 해야함.
	 * */
	@Override
	public void method1() {
		System.out.println("Child 클래스의  method1()");
	}

	@Override
	public void method() {
	System.out.println("Child 클래스의  method()");
	System.out.println("MyInterface1,MyInterface2 인터페이스의 추상 메서드 method 오버라이딩함");
	} 
	
}
public class DefaultInterfaceEx1 {
	public static void main(String[] args) {
		Child c = new Child();
		c.method1();
		c.method2();
		MyInterface1.staticMethod();//staticMethod()클래스 메서드
		MyInterface2.staticMethod();
	}

}
