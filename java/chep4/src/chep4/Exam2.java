package chep4;

import java.util.Scanner;

/*
 * ȭ�鿡�� 3�ڸ� ������ �Է¹޾� 100 �ڸ� �̸��� ������ ����ϱ�
 * [���]
 * ���ڸ� ������ �Է��ϼ���
 * 321
 * 300*/
public class Exam2 {

	public static void main(String[] args) {
		int num;
		System.out.println("3�ڸ� ������ �Է��ϼ���");
		Scanner scan=new Scanner(System.in);
		num=scan.nextInt();
		System.out.print(num-(num%100));

	}

}
