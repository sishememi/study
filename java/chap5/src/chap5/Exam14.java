package chap5;

import java.util.Scanner;

/*
 * �Է� ���� ���ڰ� �¿��Ī������ �Ǵ��ϱ�
 * ���ڸ� �Է��ϼ���
 * 121
 * �¿��Ī��
 * ���ڸ� �Է��ϼ���
 * 123
 * �¿��Ī�� �ƴ�
 * �ٽ�Ǯ��
 * */
public class Exam14 {

	public static void main(String[] args) {
		System.out.println("���ڸ� �Է��ϼ���.");
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
		int c=0;
		int temp=num;
		while(temp!=0) {
			c *= 10;
			c += temp%10;
			temp/=10;
		}
		if(num == c) {		
			System.out.println("�¿��Ī");			
		}else {
		System.out.println("�¿��Ī�ƴ�");
	  }
	}
}
