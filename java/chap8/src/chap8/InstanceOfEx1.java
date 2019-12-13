package chap8;
/*
 * Instanceof ����
 * */
public class InstanceOfEx1 {
	public static void main(String[] args) {
//		Parent3 p = new Parent3();  //�����ϸ� �������ؼ� ������ classcast��¼��..����
//		Child3 c = (Child3)p;   // Child3 c = (Child3)p; child�� ����ȯ�ؼ� parent��ü�� �����Ϸ����ϴµ� child��ü�� ��� ������ �� ����.
								// �ذ��Ϸ��� Parent3 p = new Child3(); �̷��� ��ȯ�ؾ���. 
		
		Parent3 p = new Parent3();
		if(p instanceof Child3) {  //Child3 ture? ��������?, Parent3 p = new Child3(); �ϋ� ���
			System.out.println("p �������� ��ü�� Child3 ��ü��");
			Child3 c = (Child3)p;
			System.out.println(c.x);
			c.method();
		}
		if(p instanceof Parent3) {//Parent3 p = new Parent3(); �ϋ� ���
			System.out.println("p �������� ��ü�� Parent3 ��ü��");
		}
		/*
		 * ��� Ŭ������ Object Ŭ������ ��� �޴´�.
		 * -> ��� ��ü�� Object ��ü�� �����Ѵ�.
		 * -> ��� ��ü�� Object Ÿ���� ���������� ������ �����ϴ�.
		 * */
		if(p instanceof Object) {//Parent3 p = new Parent3(); �ϋ� ���
			System.out.println("p �������� ��ü�� Object ��ü��");
			Object o = p;//ObjectŸ������ ����ȯ
			System.out.println(p.x);
			//System.out.println(o.x);  //����  o.x��  object�� �����ŭ�� ���ٰ���. p�� ������ �� �� ���⶧���� ������ �� ����.
									  //����� �Ǽ�-> x�� Object Ŭ������ ����� �ƴϴ�. ������ �� ����. ��ü���� x��� ������ִµ�, ���� objectŸ������ ������ �Ұ���
		}
	}
}
