package chap5;

import java.util.Scanner;

/*
 * ���� ���߱� ����.
 * ��ǻ�Ͱ� 1���� 100������ ������ ���� �����ϰ�  �ְ�,
 * ����ڴ� �ݺ������� ���ڸ� �Է��ؼ�  ����� ���ڸ� ���߱�.
 * ���ڸ� ���߸� ���α׷� �����ϱ�.
 */
public class LoopEx4 {
	public static void main(String[] args) {
		//1. ��ǻ���� ������ �� ����
		/*Math.random():����, ������ ��
		 * 0 <= Math.random() < 1.0
		 * 0 <= Math.random() *100 < 100.0
		 * 0 <= (int)Math.random() *100 < 100
		 * 1 <= (int)Math.random() *100 +1 <= 100.0
		 */
		//ans : 1 ���� 100������ ������ �� �����ϴ� ����.
		int ans = (int)(Math.random()*100)+1;  //35
		Scanner scan = new Scanner(System.in);
		int input;
		int ct=0;  //0 �� �ʱ�ȭ ���ϸ� ����, ��� ���������� 0���� �ʱ�ȭ �ؾ���.
		do {
			System.out.println("1~100 ������ ���ڸ� �Է��ϼ���");
			 input = scan.nextInt();
			if(ans > input) {
				System.out.println("�� ū�� �Դϴ�.");
			}else if (ans < input){
				System.out.println("�� ���� �� �Դϴ�.");
			}else {
				System.out.println("�����Դϴ�.");
			}
			ct++;
		}while(ans != input);
		System.out.println(ct+"�� ����");
	}
}
