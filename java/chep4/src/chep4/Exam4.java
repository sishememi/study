package chep4;

import java.util.Scanner;

/*
 * ���ڸ� �Է¹޾Ƽ� ����� ��� �����, ������ ������,0�� ���� 0 ����ϱ�
 * 
 * */
public class Exam4 {

	public static void main(String[] args) {
		System.out.println("���ڸ� �Է��ϼ���");
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
		System.out.println((num>0)?"���":(num<0)?"����":"0");
		//System.out.println(num+"��"+result+"�Դϴ�.");
	}
}