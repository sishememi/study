package chap6;

import java.util.Scanner;

/*
 * 10������ 8������ ��ȯ
 */
public class Exam5 {
	public static void main(String[] args) {
	
		int []octal = new int[64];
		System.out.println("8���� ��ȯ�� 10������ �Է��ϼ���");
		Scanner scan = new Scanner(System.in);
		int num=scan.nextInt();
		int divnum=num,index=0;
		while(divnum != 0) {
			octal[index++] = divnum % 8; //div�� 8�γ��� �������� index���������
			divnum /= 8;
		}
		System.out.println(num+"�� 8����:");
		for(int i=index-1;i>=0;i--) {
			System.out.print(octal[i]);
		}
		System.out.println();
	}

}
