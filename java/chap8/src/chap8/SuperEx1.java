package chap8;

class Parent{
	int x=10;  //�θ�Ŭ������ ����� ����, super�� ������ ������ �θ�Ŭ������ ������ ȣ���ؾ��ϱ⶧����.
	Parent(int x){
		this.x = x;
	}
}
class Child2 extends Parent{
	Child2() {  // �θ�Ŭ������ �����ڸ� ȣ���ؼ� �θ�Ŭ������ ��ü�� �����ؾ��Ѵ�.
		super(100);
	}
	
	int x = 20;
	void method() {
		int x = 30;
		// x: 1.�������� => 2. ���� Ŭ������ ����� x => 3. �θ�Ŭ������ ��ü�� ��� �� x
		System.out.println(x);  //30 ,method�� ���������� ����� ����ϸ� 20���� ���, ���������� ������ ��������� ã�ư�
		//1. ���� Ŭ������ ����� x => �θ�Ŭ������ ��ü�� ��� �� x
		System.out.println(this.x);  //20 ,  �� ��ü�� �ִ� ���� x��  child �� ��������� �������� �θ�Ŭ���� ������ ��´�. 
		//�θ�Ŭ������ ��ü�� ����� x
		System.out.println(super.x);  //10 ,�θ� Ŭ������ x ��
	}
}

public class SuperEx1 {
	public static void main(String[] args) {
		Child2 c = new Child2();
		c.method();
	}

}


