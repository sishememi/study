package chap18;
/*
 * �Ű������� �ְ�, ���ϰ��� �ִ� ���
 */
interface LambdaInterface4{
	int method(int x, int y);
}
public class LambadaEx4 {
	public static void main(String[] args) {
		LambdaInterface4 f4= (x,y)->{
			return x*y;
		};
		System.out.println("�� ���� ��:"+f4.method(2, 5));//10
		f4 = (x,y) -> x+y;//�������� ���ϰ� ����.
		System.out.println("�� ���� ��:"+f4.method(2, 5));//7
		f4 = (x,y) -> x/y;
		System.out.println("�� ���� ��:"+f4.method(5, 2));//2
		f4 = (x,y) -> x%y;
		System.out.println("�� ���� ������:"+f4.method(5, 2));//1
		f4 = (x,y) -> sum(x,y);
		System.out.println("�� ���� ��:"+f4.method(2, 5));//7
		
		//�� �� �� ū�� ����ϱ�
		f4 = (x,y) ->x>y?x:y;
		System.out.println("�� �� �� ū��:"+f4.method(2, 5));
		//�� �� �� ������ ����ϱ�
		f4 = (x,y)->x<y?x:y;
		System.out.println("�� �� �� ������:"+f4.method(2, 5));
	}

	static int sum(int x, int y) {
		
		return x+y;
	}
}
