package chep4;

import java.util.Scanner;
/*
 * �Ѱ��� ���ڸ� �Է¹޾Ƽ� �ҹ����� ��� �빮�ڷ� �����Ͽ� ����ϱ�.
 * �ҹ��ڰ� �ƴ� ���� "�ҹ��� �ƴ�" ����ϱ�
 * 
 *  Scanner scan = new Scanner(System.in);
 * String str=scan.next();
 * char ch=str.charAt(0);
 * ch ����: 'a' <=ch <='z'
 * �빮��=�ҹ���-32;
 * 		
 * */
public class Exam5 {

	public static void main(String[] args) {
		System.out.println("�ҹ��ڸ� �Է��ϼ���");
		Scanner scan = new Scanner(System.in);
		String str=scan.next(); //���ڿ��� �Է¹��� "A"
		char ch=str.charAt(0);//���ڿ� �� ù��° ���� 'A'
	   	//boolean result=(ch>='a' && ch <='z');
		//System.out.println(result?(char)(ch-32)+"":"�ҹ��ھƴ�");//+"" <=���ڿ��� �ٲ٤���
		System.out.println((ch >='a' && ch <= 'z')?(char)(ch-32)+"":"�ҹ��ھƴ�");
	}	

}
