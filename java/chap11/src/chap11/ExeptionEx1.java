package chap11;
/*
 * ����ó��
 * try �� :���ܰ� �߻��� ���ɼ��� �ִ� �����.
 * 			���ܰ� �߻��� ��� ���� catch ������ �̵�.
 * catch ��:���ܰ� �߻��ϸ� ȣ��Ǵ� ��
 * 			 ���ܰ� �߻��Ǹ� , ���ܴ� ���, ���������� ������ ��.
 * 			try ���� �Բ� ��� �ؾ���.
 */
public class ExeptionEx1 {
	public static void main(String[] args) {
		try {
		System.out.print(1);//ArithmeticExeption ���� �߻�
		System.out.print(2);
		System.out.print(3/0); 
		System.out.print(4);
		} catch (ArithmeticException e) {
			System.out.println("0���� ������ ������");
		}
		System.out.println(5);

		
	}

}

