package chap9;
/*
 * jdk8.0 ���Ŀ� �������̽��� �����θ� ���� �޼��带 ����� ���� �� �ִ�.
 * 
 * default �޼���: �ν��Ͻ����
 * 				 ���� ������ �����ϹǷ� �Ȱ��� default �޼��尡 ������ �� �ִ�.
 * 				=> ����Ŭ�������� �������̵��� �ʿ���.
 * static �޼���: Ŭ�������
 * */
interface MyInterface1{
	void method();
	default void method1() {
		System.out.println("MyInterface1�� ����Ʈ �޼���: method1()");
	}
	static void staticMethod() { //Ŭ���� ����̱� ������ �浹x Ŭ���������� ���� ���󰡱⶧����
		System.out.println("MyInterface1�� static �޼���: staticMethod()");
	}
}

interface MyInterface2{
	void method();
	default void method1() {
		System.out.println("MyInterface2�� ����Ʈ �޼���: method1()");
	}
	static void staticMethod() {
		System.out.println("MyInterface2�� static �޼���: staticMethod()");
	}
}

class Parent{
	public void method2() {
		System.out.println("Parent Ŭ������ ��� �޼��� : method2()");
	}
}
class Child extends Parent implements MyInterface1,MyInterface2{//class Child extends Parent implements MyInterface1,MyInterface2�� ���� ������ ������ ,
	//method1()�� �ΰ��� ����.�� �� override �ؾߴ�
	/*
	 *  MyInterface1,MyInterface2  �������̽��� method1 default �޼��尡 �浹 �߻�
	 *  => Child Ŭ�������� �ݵ�� �������̵� �ؾ���.
	 * */
	@Override
	public void method1() {
		System.out.println("Child Ŭ������  method1()");
	}

	@Override
	public void method() {
	System.out.println("Child Ŭ������  method()");
	System.out.println("MyInterface1,MyInterface2 �������̽��� �߻� �޼��� method �������̵���");
	} 
	
}
public class DefaultInterfaceEx1 {
	public static void main(String[] args) {
		Child c = new Child();
		c.method1();
		c.method2();
		MyInterface1.staticMethod();//staticMethod()Ŭ���� �޼���
		MyInterface2.staticMethod();
	}

}
