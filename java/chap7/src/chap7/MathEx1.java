package chap7;
/*
 * �޼��� ����
 * [����������] ����Ÿ�� �޼����̸�(�Ű����� ���) =>�����
 * { 							     =>������
 * 		�����
 * }
 * ����Ÿ��: �޼��� ���� �� ���޵Ǵ� ���� �ڷ���.
 * 	      void�� ���� ���ϰ��� ����.
 * �Ű�����: �޼��� ȣ��� ���޵Ǵ� �ʱ�ȭ ��.
 * 		     �Ű������� ���� ��� () ǥ����. 
 * return: return�� ����Ǹ� �޼��尡 �����.
 * 		      ����Ÿ���� void�� �ƴ� ���� �ݵ�� return ���ϰ�; �����ؾ���.
 * 		   void �� ���� return ���� ������. �޼����� ������ '}' �޼��尡 �����.
 * */
class Math1{
	int add1(int a,int b)// => ����� 
	{ return a+b;}  // => ������ 
	long add2(int a,int b) {return a+b;} //return a+b�� ������ ������ ����Ÿ���� long�� Ÿ������ �ڵ� ����ȯ���� add2���� ȣ��Ǿ� ��µȴ�
	double add3(int a,int b) { return a+b;} //a+b�� int ����  ����Ÿ���� double�� Ÿ������ ����ȯ �Ǿ� ��µȴ�.
}

public class MathEx1 {
	public static void main(String[] args) {
		Math1 m1 = new Math1();
		int i = m1.add1(10,20);
		long l = m1.add2(10,20);  //int l ���ϸ� ������ add2�� long ���̿���..
		double d = m1.add3(10,20);
		System.out.println(i);
		System.out.println(l);
		System.out.println(d);
		
	}
}
