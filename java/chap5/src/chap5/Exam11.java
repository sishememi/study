package chap5;
/*
 * ȭ�鿡 �ﰢ�� ���̸� �Է¹ް�, ���̿� �´� *�� �ﰢ�� ����ϱ�
 * [���]
 * �ﰢ���� ���̸� �Է��ϼ���
 * 3
 * 	 *
 *  **
 * ***
 * 
 * */
import java.util.Scanner;

public class Exam11 {
	public static void main(String[] args) {
		System.out.println("�ﰢ���� ���̸� �Է��ϼ���.");
		Scanner scan = new Scanner(System.in);
		int len = scan.nextInt();	
		
		for(int i=len; i>=1 ;i--) {
			for(int j=1; j<=len ;j++) {	
				if(i>j) {
					System.out.print(" ");		
				}else {
					System.out.print("*");
				}
			}
			System.out.println();
		}
	}
}



