package chap8;
/*
 * ���� ������
 * 		private < (default) < protected < public
 * 
 * private�� �����ڿ��� ��밡�� ��ü������ ���´�. ��ǥ�� Math()������
 * */

import chap8.packtest.Modifier2;

class Modifier{
	private int v1 = 100; //�ڼ�X ����Ŭ���������� ���
			int v2 = 200; //����������X ,default ���� Ŭ����,���� ��Ű������ ���
	protected int v3=v1; //����Ŭ���� ���� ��Ű�� ��Ӱ���� ���ٰ���
	public void method() {
		System.out.println("chap8.Modifier.method() �޼�����");
		System.out.println("v1 = "+100);
		System.out.println("v2 = "+200);
	}
}
class Modifier3 extends Modifier2 {
	public void method() {
		System.out.println("v1="+v1); //v1 ������ ���������ڰ� private��.
		System.out.println("v2="+v2); //v2 ������ ���������ڰ� (default)��
		System.out.println("v3="+v3); //v3 ������ ���������ڰ� protected ��.(��Ӱ����϶� �������)
		System.out.println("v4="+v4); //v4 ������ ���������ڰ� public. ��� ���� ���.
		
	}
}
public class ModifierEx1 {

	public static void main(String[] args) {
		Modifier m1 = new Modifier();
//		System.out.println(m1.v1); //���� �Ұ�.
		System.out.println(m1.v2);
		m1.method();
		Modifier3 m3 = new Modifier3();
//		System.out.println("m3.v1="+m3.v1);
//		System.out.println("m3.v2="+m3.v2);
//		System.out.println("m3.v3="+m3.v3);
		System.out.println("m3.v4="+m3.v4);
//		Math m = new Math(); //Math => �������� ���������ڰ�  private��. ��ü���� �Ұ� 
	
	}
}
