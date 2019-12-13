package chap11;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Exam1 {
	public static void main(String[] args) {
		//ȭ�鿡�� 1���� 10������ ���ڸ� �Է¹޾Ƽ� ���ڸ�ŭ  * ���η� ����ϱ�
		//�� 99���ڰ� �Էµɶ����� ��� �Է¹ޱ�		
		
		Scanner scan = new Scanner(System.in);
		while(true) {
			System.out.println("1���� 10���� �� ���ڸ� �Է��ϼ���(����:99)");
			//�Է°��� ���ڰ� �ƴѰ�� : InputMismatchException �߻��� ���
			//		���ڸ� �Է��ϼ��� �޼����� ����ϰ�, �ٽ� �Է¹޵��� ���α׷� ����.		
			try {
				int num = scan.nextInt();
				if(num==99){
					System.out.println("���α׷� ����"); break;}
				if(num < 1 || num > 10) {
//					System.out.println("1����10���� ���ڸ� ó���ϼ���");
//					continue;
					throw new Exception("1���� 10������ ���ڸ� �Է��ϼ���.");
				}
				
				System.out.print(num+":");
				for(int i=0;i<num;i++) {
					System.out.print("*");
				}
				System.out.println();				
				}catch (InputMismatchException e){
					//System.out.println("���ڸ� �Է��ϼ���.");
					//scan= new Scanner(System.in);
					String str = scan.next();
					System.out.println(str+"�� ���ڰ��ƴմϴ�.���ڸ� �Է��ϼ���.");
					continue; //�����ص���.
				}catch(Exception e) {
					System.out.println(e.getMessage());
				}
		}		
	}
}

