package chap7;
/*
 * ��� �޼����� ����
 * 	 Ŭ���� �޼���
 * 	 �ν��Ͻ� �޼���
 * */
class Math2{
	int a,b; //�ν��Ͻ� ����/ ��üȭ�� �Ǿ���Ѵ�....?
	
	//�ν��Ͻ� �޼���: ��üȭ�� �Ǿ�� �޼����� ȣ���� ������. ����������.�޼����() ȣ���ؾ���.
	int add1() {
		return a+b;
	}
	//Ŭ���� �޼��� : Ŭ�������� �ε�ɶ� �޼����� ȣ���� ������. Ŭ������.�޼����() ȣ�� �� �� �ִ�.
	static int add2(int a, int b) { return a+b;}

}
public class MathEx2 {
	public static void main(String[] args) { //��ǥ���� Ŭ���� �޼���.���ο� static�� �ݵ�� ����ϴ����� jvm�� ������ ����̾���..��üȭ��Ű���ʰ� �ٷ� �����ϱ�����
		Math2 m = new Math2();
		m.a=10;
		m.b=20;
		System.out.println(m.add1());//30
		System.out.println(m.add2(100, 200));//300
		System.out.println(Math2.add2(100, 200));//300
	}
}
