package chap6;
/*
 * command ���ο��� ���ڸ� �Է¹޾� ������ ����� ����ϱ�.
 * java Exam7 10
 * string->int ��ȯ �޼���  : int num=Integer.parseInt(args[0]);
 * 10�� ���: 1,2,5,10,
 * */
public class Exam7 {
	public static void main(String[] args) {
		if(args.length==0) {
			System.out.println("Ŀ�ǵ���ο�  �Ķ���͸� �Է��ϼ���");
			System.out.println("java Exam7 10");
			return;
		}
		
		
		int num=Integer.parseInt(args[0]); //Integer.parseInt(String) ���ڷε� ���ڿ��� int���� ���ڷ� ��ȯ �Լ�
		System.out.print(num+"�� ���:");
		for(int i=1;i<=num;i++) {			
			if(num%i==0)
				System.out.print(+i+",");
		}
	}
}
/*������ �Է�
 * for(String a: args) {
		int num=Integer.parseInt(a); //Integer.parseInt(String) ���ڷε� ���ڿ��� int���� ���ڷ� ��ȯ �Լ�
		System.out.print(num+"�� ���:");
		for(int i=1;i<=num;i++) {			
			if(num%i==0)
				System.out.print(+i+",");
		}
		System.out.println();
		}*/
 