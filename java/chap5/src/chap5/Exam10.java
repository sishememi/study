package chap5;

import java.util.Scanner;

/*
 * ȭ�鿡 �ﰢ�� ���̸� �Է¹ް�, ���̿� �´� *�� �ﰢ�� ����ϱ�
 * [���]
 * �ﰢ���� ���̸� �Է��ϼ���
 * 3
 * ***
 * **
 * *
 * ��Ǯ����
 * */
public class Exam10 {
	public static void main(String[] args) {
		System.out.println("�ﰢ���� ���̸� �Է��ϼ���.");
		Scanner scan = new Scanner(System.in);
		int len = scan.nextInt();	
		
		for(int i = 1; i <= len; i++){
			for(int j = len; j >= i; j--) {
				System.out.print("*");			
			}System.out.println();
		}
		// =����
		for(int i=len;i>=1;i--) {
			for(int j=1;j<=i;j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}


