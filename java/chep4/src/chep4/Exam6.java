package chep4;

import java.util.Scanner;

/*
 * ����� ��� ���ڿ� ���� �Ѵ�. 1���� ���ڿ� 10���� ����� ���� �� �ִ�.
 * �ʿ��� ��� ������ ������ ����ϱ�.
 * [���]
 * ����� ������ �Է��ϼ���.
 * 22
 * �ʿ��� ������ ���� : 3
 * 
 * ����� ������ �Է��ϼ���
 * 30
 * �ʿ��� ������ ����: 3
 * */
public class Exam6 {

	public static void main(String[] args) {
		
		System.out.println("����� ������ �Է��ϼ���.");
		Scanner scan=new Scanner(System.in);
		int apple = scan.nextInt();
		int result=((apple%10==0)?(apple/10):(apple/10)+1);
		System.out.println("�ʿ��� ������ ����:"+result);
		
		
	}

}
