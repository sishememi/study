package chap11;
/*
 * finally ����: ���� ����, ���ܽ��� ��� �����.
 * 				try, catch �������� return������ ������ finally�� �����.
 * 				try ������ ���� ����.
 */
public class ExeptionEx3 {
	public static void main(String[] args) {
		try {
			System.out.print(1);
			System.out.print(2);
			System.out.print(3/0);
//			return; //�޼��� ����
		}catch(Exception e) {
			System.out.print(4);
			return;
		}finally {
			System.out.print(5);
		}
		System.out.println(6);
	}
}
