package chap5;

import java.util.Scanner;
/*
 * if ���� ����
 * 
 * 	if(���ǽ�){
 * 		����1....: => ���ǽ��� ����� ���� ��� ����Ǵ� ����
 * }else {
 * 		����2 : => ���ǽ�1�� ����� ������ ��� ���� �Ǵ� ����
 * }
 * 
 * 	if(���ǽ�1){
 * 		����1....: => ���ǽ��� ����� ���� ��� ����Ǵ� ����
 * }else if(���ǽ�2){
 * 		����2 : => ���ǽ�1�� ����� �����̰� ���ǽ�2�� ���� ��� ���� �Ǵ� ����
 * }else if(���ǽ�3){
 * 		����3 : => ���ǽ�1, ���ǽ�2 ����� �����̰�, ���ǽ�3�� ����� ���� ��� ���� �Ǵ� ����
 *}...
 *}else{
 *		����=> ��� if ������ ����� ������ ��� ����Ǵ� ����.
 *}
 * */
public class IfEx1 {

	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		System.out.println("�������Է��ϼ���");
		int score=scan.nextInt();
		if(score>=60) {
			System.out.println("�հ��������մϴ�.");
		}else {
			System.out.println("���հ��Դϴ�..");
		}
		//90�̻��̸� "A����" 80�̻��̸� "B����" 70�̻��̸� "C����" 60�̻��̸� "D����" �׿ܴ� "F����" ����ϱ�
		if(score>=90)
		{
			System.out.println("A�����Դϴ�.");
		}else if(score>=80)
		{
			System.out.println("B�����Դϴ�.");
		}else if(score>=70) {
			System.out.println("C�����Դϴ�.");
		}else if(score>=60) {
			System.out.println("D�����Դϴ�.");
		}else {
			System.out.println("F�����Դϴ�.");
			}
		}
	}//main ����. ���α׷� ����
	

