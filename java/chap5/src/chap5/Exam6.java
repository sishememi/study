package chap5;

import java.util.Scanner;

/*
 * ���ڷ� �̷���� ���ڿ��� �Է¹޾� �� �ڸ��� ���� ���ϱ�
 * String str=scan.next(); //123
 * str.length(): 3  ���ڿ� ����
 * str.charAt(����): ù��° ���� 
 * str.charAt(0) => '1'
 * str.charAt(1) => '2' 
 * str.charAt(2) => '3' 
 * for���� �̿�.
 * */
public class Exam6 {
	public static void main(String[] args) {
		System.out.println("���ڸ� �Է��ϼ���");
		Scanner scan = new Scanner(System.in);
		String str = scan.next();
		
		int sum=0;
		for(int i=0;i<str.length();i++) //0���� �����ؾ� ù��°������ ����,���ǹ� = �� ������ ������ 3�ڸ��϶� 4 ���� ��µǸ� �ȵǱ⶧��.
		{
			char a = str.charAt(i);   //=sum+=(str.charAt(i)-'0')
			System.out.println(i+"��° �ڸ���: "+a);
			sum+=(a-'0'); //0 �������� ���ڷ� ������ֱ�����. ex)50-'0'(48) = 2
			//sum+=(a-48);
			
		}System.out.println("�ڸ��� ��:"+sum);
	} 
}
