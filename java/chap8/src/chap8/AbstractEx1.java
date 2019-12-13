package chap8;
/*
 * �߻� Ŭ�������� ��ӵ� ������.
 * �߻�Ŭ������ �ڼ� Ŭ������ ��� �θ��� �߻� �޼��带 �������� �ʾƵ� ��.
 * �� �߻� Ŭ������ ��ӹ��� �Ϲ� Ŭ������ ��� �߻� �޼��鸣 �����ؾ���.
 * 
 * �ڼ�Ŭ������ ���������ڴ� �θ�Ŭ������ �����ڸ� �Ȱ��ų� ���� ������ �ڼ� Ŭ������ ���������� ����
 * */
abstract class Abs1{
	int a = 10;
	abstract int getA();
}
abstract class Abs2 extends Abs1{
	int b = 20;
	abstract int getB();
}
class Normal extends Abs2{

	@Override
	int getB() { 	return b;	}

	@Override
	int getA() {	return a;	}	
}
public class AbstractEx1 {
	public static void main(String[] args) {
		Abs1 a1 = new Normal();
		System.out.println(a1.getA()); //10
//		System.out.println(a1.getB()); //error  Abs1���� getB��� �޼��尡 ���⋚���� ����������.
		Abs2 a2 = (Abs2)a1; //����ȯ
		System.out.println(a2.getA()); //10
		System.out.println(a2.getB()); //20
		Normal n = (Normal)a2; //�θ�->������  ����ȯ
		System.out.println(a2.getA()); //10
		System.out.println(a2.getB()); //20
//		a2 = new Abs2(); // error Abs2�� �߻�Ŭ�����̱� ������ ��üȭ�� ��������
		
		

	}
}
