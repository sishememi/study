package chap10;
/*
 * ���� Ŭ���� ����
 *  
 * �ν��Ͻ� ����Ŭ����: static�� �پ��ִ� Ŭ���� ����� ���� �� ����. �� ����� ����.
 * static ����Ŭ����: Ŭ���� ����� ���� �� �ִ�.
 * ��������Ŭ����: �޼��� ���� ����� Ŭ����. �޼��� ���ο����� ����� ������.
 * �̸�����(������) ����Ŭ����: Ŭ���� �̸����� ��üȭ ������ Ŭ����
 * 						�߻�Ŭ����,�������̽��� ��üȭ ������.
 * 
 * 
 * ����Ŭ������ Ư¡
 * 	1. Ŭ���� ���ο� �����ϴ� Ŭ����
 * 	2. �ڷ������� ����. ��üȭ ����, Object Ŭ������ ���� Ŭ������.
 * 		���(����,�޼���,������)�� ������ �� �ִ�.
 * 	3. �ܺ� Ŭ������ �����. => �ܺ�Ŭ������ private ����� ������ ����.
 */
class Outer1{
	class InstanceInner{  //�ν��Ͻ� ����Ŭ����
		int iv=100;
//		static int cv = 10;  //Ŭ���� ����� ���� �� ����. �ν��Ͻ� ���� Ŭ�����̱⶧��.error
		final static int MAX =200;//������ ����� Ŭ���� ����� ���� �� �ִ�.
	}
	static class StaticInner{   //static ����Ŭ����
		int iv=300;
		static int cv = 400;  //Ŭ���� ����� ���� �� �ִ�.
		final static int MAX = 500;
	}
	void method() {
		class LocalInner{  //���� ����Ŭ����
			int iv=600;
//			static int cv=700;  //Ŭ���� ����� ���� �� ����. error
			final static int MAX=700; //����� ����.
		}
		LocalInner lc = new LocalInner(); //���� ����� ���ο����� ��ü��������
		System.out.println(lc.iv); //600
		System.out.println(lc.MAX); //700
		System.out.println(LocalInner.MAX); //700

	}
	void method2() {
//		LocalInner lc = new LocalInner();   => method() �޼��忡���� ��밡�� 
	}
}
public class InnerEx1 {
	public static void main(String[] args) {
		Outer1.StaticInner si = new Outer1.StaticInner();
		System.out.println(si.iv);//300 
		System.out.println(Outer1.StaticInner.cv);// 400  static�̶� ��üȭ ��  �ʿ� ����.
		System.out.println(Outer1.StaticInner.MAX);//500
		Outer1.InstanceInner ii = new Outer1().new InstanceInner();
		Outer1 outer = new Outer1();
		Outer1.InstanceInner ii2 = outer.new InstanceInner();
		System.out.println(ii2.iv);//100
		System.out.println(Outer1.InstanceInner.MAX);//200 max���� ����� �̷��� ���� ����.
		outer.method();
	}
}
