package chep4;

import java.util.Scanner;
/*
 * ȭ�鿡�� 10���� 99������ ���ڸ� �ڿ����� �Է¹޾� �Է¹��� �� ���� ũ�ų� ���� ���� ���� 10�� ����� ���ϱ�
 * 10�� ����� �Է¼��� �� ���� ����ϱ�
 * 
 * [���]
 * 10���� 99������ ���� �Է��ϼ���.
 * 24
 * 30 - 24 = 6
 * 
 * 20
 * 20 - 20 = 0
 * 
 * 77
 * 80 - 77 = 3
 *
 * */

public class Exam8 {

	public static void main(String[] args) {
	
				System.out.println("10���� 99������ ���� �Է��ϼ���");
				Scanner scan=new Scanner(System.in);
				int num = scan.nextInt();
				
				int result=(num%10==0)? num :((num/10)+1)*10;
				System.out.println(result+"-"+num+"="+(result-num));
				// ���� =>System.out.println((num>=10 && num <=99)?(num%10==0)?(num-num):(((num/10)+1)*10-num):"�߸��Է��߽��ϴ�.");		
	}

}
