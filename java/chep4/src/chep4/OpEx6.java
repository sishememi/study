package chep4;

import java.util.Scanner;

/*
 * �������
 * 	/ : ������ ������
 * 		����=����/����
 * 	% : ������ ������
 * 		������������ ��� ���� ��ȣ�� �������� ��ȣ�� ����.
 * 
 * */
public class OpEx6 {

	public static void main(String[] args) {
		System.out.println(10/8);//1
		System.out.println(10/-8);//-1
		System.out.println(-10/8);//-1
		System.out.println(-10/-8);//1
		
		System.out.println(10%8);//2
		System.out.println(10%-8);//2
		System.out.println(-10%8);//-2
		System.out.println(-10%-8);//-2
		// %������ ��� ��ȣ�� �������� ��ȣ�� ����(���������¼�).
		
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
		 float f1 = 1F;        
		  float f3 = '1'; 
		  float f2 = (float) 1.0;     
		  String f4 = "1";   
		  float f5 = (float) 1.0d; 
  
	}

}
