package chap5;

/*
 * ȭ�鿡 �ﰢ�� ���̸� �Է¹ް�, ���̿� �´� *�� �ﰢ�� ����ϱ�
 * [���]
 * �ﰢ���� ���̸� �Է��ϼ���
 * 3
 * ***
 *  **
 *   *
 * �ϴ� *�� ������ i�� 1�϶� 3����� i��  2�϶� 2����� i��  1���϶� 1�����, i�� j���� ������ ����.
 * */
import java.util.Scanner;

public class Exam12 {

	public static void main(String[] args) {
		System.out.println("�ﰢ���� ���̸� �Է��ϼ���.");
		Scanner scan = new Scanner(System.in);
		int len = scan.nextInt();	
		
			for(int i=1;i<=len;i++) {
				for(int j=1;j<=len;j++) {
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
