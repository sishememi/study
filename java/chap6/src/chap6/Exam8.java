package chap6;
/*
 * command line���� ���ڷ� �̷���� ���ڸ� �ΰ� �޾Ƽ� �μ��� ������� ���Ͻÿ�. 
 * */
public class Exam8 {
	public static void main(String[] args) {
		if(args.length !=2) { //�迭�� ���� �ΰ�
			System.out.println("command line�� �ΰ��� �Ķ���͸� �Է��ϼ���");
			System.out.println("java Exam8 10 20");
			return ; //main�޼��� ����.
		}	
		int num1=Integer.parseInt(args[0]);
		int num2=Integer.parseInt(args[1]);
		int min=(num1>num2)?num2:num1;

		System.out.print("�����:");
		
		for(int i=1;i<=min;i++) {
			if(num1%i==0 && num2%i==0) {				
				System.out.print(i+",");			
			}
		}
		
	}
}
