package chep4;
/*
 *ȭ�鿡�� �ݾ��� �Է¹޾� 500,100,50,10,1�� �������� �ٲٱ�
 *�ʿ��� ������ ������ ����ϱ�
 *[���]
 *�ݾ��� �Է��ϼ���
 *5641
 *500��:11��
 *100��:1��
 *50��:0��
 *10��:4��
 *1��:1��
 */

import java.util.Scanner;

public class Exam3 {

	public static void main(String[] args) {
		int won;
		System.out.println("�ݾ��� �Է��ϼ���");
		Scanner scan=new Scanner(System.in);
		won=scan.nextInt();
		System.out.println("500��:"+won/500+"��");
		System.out.println("100��:"+(won%500)/100+"��");
		System.out.println("50��:"+(won%100)/50+"��");
		System.out.println("10��:"+(won%50)/10+"��");
		System.out.println("1��:"+(won%10)+"��");
		
		
	}

}
