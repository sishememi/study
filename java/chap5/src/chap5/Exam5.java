package chap5;

import java.util.Scanner;

/*
 * ȭ�鿡�� �ڿ����� �Է¹޾Ƽ� ������ �ڸ����� ���� ���ϱ�.
 * [���]
 * �ڿ����� �Է��ϼ���
 * 123
 * �ڸ��� ��:6
 * 
 * �ڿ����� �Է��ϼ���
 * 1357
 * �ڸ��� ��:16 
 */
public class Exam5 {
	public static void main(String[] args) {
		System.out.println("���ڸ� �Է��ϼ���");
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();

		int sum = 0;
		while(num != 0) {		
				sum+=num%10;
				num/=10;// num=num/10
				System.out.println(num);
		}
		System.out.println("�ڸ��� ��:"+sum);	 
	}
}
