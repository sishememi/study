package chap6;

import java.util.Scanner;

/*
 * ȭ�鿡�� 5���� ������ �Է¹޾Ƽ� ������ �հ�,���,�ִ�����,�ּ����� ����ϱ�.
 * �Է¹��� ������ score �迭�� �����ϱ�.
 * */
public class Exam1 {
	public static void main(String[] args) {
		
		System.out.println("5���� ������ �Է��ϼ���");
		Scanner s = new Scanner(System.in);
		int[] score = new int[5];
		
		for(int i=0; i<score.length; i++) {
		score[i] = s.nextInt();
		}
		
		int sum=0 ,max=0 ,min=0;
		for(int i=0;i<score.length;i++){
			sum+=score[i];
			if(max < score[i]) max=score[i];
			if(i==0 || min > score[i]) min =score[i]; //i==0�� �ʱ�ȭ. min�� �ּڰ��̾���ϰ�, min�� 0�̸� min�� �� Ŭ���� ���� ������ 0���� ����
		}System.out.println("�հ�:"+sum+" ���:"+(double)sum/score.length+" �ִ�����:"+max+" �ּ�����:"+min);

	}
}
