package chap6;

import java.util.Scanner;

/*
 * 10������ 16������ ��ȯ�Ͽ� ����ϱ�
 * */
public class Exam6 {

	public static void main(String[] args) {
		char [] data= {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
		char [] arr= new char[10];
		System.out.println("16���� ��ȯ�� 10������ �Է��ϼ���");
		Scanner scan = new Scanner(System.in);
		int num=scan.nextInt();
		int divnum=num,index=0;
				
		while(divnum != 0) {
			arr[index++] = data[divnum % 16]; //�������� 0�̸� 0 �������� 15�̸�F �������� ÷�ڷ� ����..arr[0]=data[15%16=F],arr[0]���� F�� ����.
			divnum /= 16; //divnum�� 15/16=0 
		}
		System.out.println(num + "�� 16����:");
		for(int i=index-1;i>=0;i--) {
				System.out.print(arr[i]);
		}System.out.println();
	}
}
