package chap5;

import java.util.Scanner;

/*
 * ���ڸ� �Է¹޾Ƽ� ����ΰ�� ���, ������ ��� ���� ,0�ΰ��� 0
 * */
public class Exam1 {

	public static void main(String[] args) {
		 System.out.println("���ڸ� �Է��ϼ���.");
		 Scanner scan = new Scanner(System.in);
		 int num = scan.nextInt();
		
		 if(num>0) {
			 System.out.println("����Դϴ�.");
		 }else if(num<0) {
			 System.out.println("�����Դϴ�.");
		 }else if(num==0) {
			 System.out.println("0 �Դϴ�.");
		 }
		
		
	}

}
