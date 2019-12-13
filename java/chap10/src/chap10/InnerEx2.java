package chap10;

import chap10.Outer2.InstanceInner;

//java  static Ŭ�������� ��ü�� ������ �ʾƵ���.
class Outer2{
	private int outeriv = 10;//private ����Ŭ�������� ��밡��
	private static int outercv = 20;
	class InstanceInner{
		int iiv = outeriv;
		int iiv2 = outercv;
	}
	static class StaticInner{
		int siv = new Outer2().outeriv;//int siv = outeriv; =>����, ��ü�� �����������
		static int scv = outercv;
	}
	static StaticInner cv = new StaticInner();
	InstanceInner iv = new InstanceInner();
	static InstanceInner cv2 = new Outer2().new InstanceInner(); //Static�� ���� �ν��Ͻ�����̱⶧���� Ŭ��������� ���ٸ���.
//	StaticInner iv2 = new StaticInner(); //iv2�� �ν��Ͻ�..?
	
	void method(int pv) { //��������Ŭ���� , �������� pv
		//���� ����Ŭ�������� ���Ǵ� �޼����� ���������� ���ȭ �Ǿ���Ѵ�.
		int i = 0;
//		pv++;
		class LocalInner{ 
			int liv = outeriv; //�ܺ�Ŭ������ private ��� ���� ����
			int liv2 = outercv;//�ܺ�Ŭ������ private ��� ���� ����
			void method() {
				//���� ����Ŭ��������  ����Ŭ������ ���� �޼����� �������� ������ �ȵ�.
//				i = 100; 
//				pv++; 
				System.out.println("pv="+pv);
				System.out.println(liv+","+liv2);
				System.out.println(outeriv+","+outercv);//�ܺ�Ŭ������ private ��� ���� ����
				
			}
		}
		LocalInner li = new LocalInner();
		li.method();
	}
}
public class InnerEx2 {
	public static void main(String[] args) {
			Outer2 out = new Outer2();
			out.method(1);
			Outer2.InstanceInner i2 = out.new InstanceInner();
			System.out.println(i2.iiv);
			System.out.println(i2.iiv2);
			Outer2.StaticInner i3 = new Outer2.StaticInner();
			System.out.println(i3.siv);
			System.out.println(Outer2.StaticInner.scv);
			
	}

}
