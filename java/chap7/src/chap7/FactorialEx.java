package chap7;
//call stack ����
//��͸޼���(�Լ�): �ڽ��� �ڽŸ޼��带 �ٽ� ȣ���ϴ� �޼���.
//				=> ���� ������ �����ϹǷ� ������.
public class FactorialEx {
	public static void main(String[] args) {
		System.out.println("4!="+factorial(4));
		
	}

	private static int factorial(int i) {
		return  (i==0)?1:i*factorial(i-1);
	}
}
