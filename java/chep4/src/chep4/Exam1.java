package chep4;

import java.util.Scanner;

public class Exam1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//12345 �ʰ� ��ð� ��� �������� ����ϱ�
				//���
				//??�� ??�� ??��
				//3681��
				//3681/3600 => 1 �ð� 
				//(3681 % 3600)/60 => 1��
				//(3681 % 3600)%60 => 21��
				int num =12345;
				//Ű���忡��  �Է¹ޱ�
				System.out.println("����� �ʸ� �Է��ϼ���");
				Scanner scan=new Scanner(System.in);
				num=scan.nextInt();
				System.out.println(num/3600+"��"+(num%3600)/60+"��"+num%60+"��");
	}

}
