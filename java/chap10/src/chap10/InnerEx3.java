package chap10;
/*
 * ����Ŭ���� ��ü���� ���Ǵ� this
 */
class Outer3{
	int iv = 10;
	int iv2 = 20;
	class InstanceInner{
		int iv = 100;
		void method1() {
			int iv= 300;
			System.out.println("iv="+iv);//300
			System.out.println("this.iv="+this.iv);//100
			//Outer3.this.iv : Outer3 Ŭ������ ��� ���� iv ��
			Outer3.this.iv =50; //���氡��
			System.out.println("this.iv="+Outer3.this.iv);//50, Outer3 iv�� ����.
		}
	}
}
public class InnerEx3 {
	public static void main(String[] args) {
		Outer3 out = new Outer3();
		Outer3.InstanceInner ii = out.new InstanceInner();
		ii.method1();
		//
	}

}
