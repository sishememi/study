package chap6;

import java.util.Scanner;

/*
 * 10������ 2������ �����ϱ�
 * */
public class ArrayEx4 {
	public static void main(String[] args) {
		int []binary = new int[32];
		System.out.println("2���� ��ȯ�� 10������ �Է��ϼ���");
		Scanner scan = new Scanner(System.in);
		int num=scan.nextInt();
		int divnum=num,index=0;
		while(divnum != 0) {
			binary[index++] = divnum % 2; //div�� 2�γ��� �������� index���������
			divnum /= 2;
		}
		System.out.println(num+"�� 2����:");
		for(int i=index-1;i>=0;i--) {
			System.out.print(binary[i]);
		}
		System.out.println();
	}
}
