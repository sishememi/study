package chap5;

import java.util.Scanner;
/*
 * switch ��������
 * ������ �Է¹޾� A~F����ϱ�
 * 
 * switch(���ǰ�(����,����)){
 * 		case1 ��1 : ����1; break;
 * 		case2 ��1 : ����2; break;
 * 			...
 * 		default : ����;
 * 
 * }
 * 
 * break ����: break�� ���� switch����, �ݺ����� ����.
 * */
public class SwitchEx1 {

	public static void main(String[] args) {
		System.out.println("������ �Է��ϼ���");
		Scanner scan = new Scanner(System.in);
		int score = scan.nextInt();
		String grade;
		switch(score/10)
		{
			case 10:
			case 9: grade="A";break;
			case 8: grade="B";break;
			case 7: grade="C";break;
			case 6: grade="D";break;
			default:grade="F";break;
		}
		System.out.println(score+"������"+grade+"�����Դϴ�.");
	}

}
