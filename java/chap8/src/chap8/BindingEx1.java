package chap8;

class Parent3{ //Child �� ������ �ƴ�
	int x = 10;
	void method() {
		System.out.println("Parent �޼���");
	}
}
class Child3 extends Parent3{
	int x = 20;
	void method() {
		int x = 30;
		System.out.println("Child �޼���");
		System.out.println("x=" +x);
		System.out.println("this.x="+this.x);
		System.out.println("super.x="+super.x);
	}
}
public class BindingEx1 {
	public static void main(String[] args) {
		Parent3 p = new Child3();
		System.out.println(p.x);  //Parent3 �� p Child3���� ��ü�� ����..? �θ�� �ڽĿ��� �����Ҽ� �����Ƿ� parent�� x����� ������ x�� ������ �� ����.
		p.method(); //�θ� Ŭ�������� void�� �������� ??? Parent Ŭ������ method��� ����� ���⋚���� ������ ����. �ڼ� method�� �θ�method�������� ������ �� ����.
		System.out.println();
		Child3 c = new Child3();
		System.out.println(c.x);
		c.method();
	}
}
