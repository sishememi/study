package chap10;
/*
 * ������ ���� Ŭ����
 */
interface I {
	void test();
}
abstract class Abs{
	abstract void test();
}
public class InnerEx4 {
	public static void main(String[] args) {
		 I i = new I() {
			 int iv = 100;
			@Override
			public void test() {
				System.out.println("iv="+iv);
				System.out.println("this.iv="+this.iv);
				System.out.println("���� Ŭ������ test �޼���");
			}
			
		};
		i.test();//test()�� �������̽� I�� ����̱� ������ ������ ����.
//		System.out.println(i.iv); //iv����� �������̽� I�� ����� �ƴϱ� ������ ��� �Ұ�. �̸��� ���⶧���� 
		int iv = 100;
//		iv++;
		//������ ����Ŭ������ �������� Ŭ������.
		//���������� ����Ŭ�������� ����Ҷ� ���ȭ�� �ʿ��ϴ�.
		Abs a = new Abs() {
			@Override
			void test() {
				System.out.println("iv="+iv); //�������� iv ���
				System.out.println("Abs ���� Ŭ������ test �޼���");
			}
		};
		a.test();
		
	}
}
