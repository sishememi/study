package chap6;

import java.util.Scanner;

/*
 * ���ڸ��߱� ����
 * �ý����� 4�ڸ��� ���� �ٸ� ���� ������ ��
 * ����ڰ� ����� ���� ���ߴ� ����
 * 	�ڸ����� �°� �������� �� ���:��Ʈ����ũ
 * 	�ڸ����� Ʋ������ ��������: ��
 * 4��Ʈ����ũ ����.
 * */
public class Exam9 {
	public static void main(String[] args) {
		int numarr[]= { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		//answer: ����ڰ� ������� �ý����� 4�ڸ� ����.
		int answer[]= new int[4];
		//1. �ߺ����� �ʴ� 4�ڸ����� �����ϱ�
		for(int i=0;i<1000;i++)
		{	int f=(int)(Math.random()*10); //4 numarr[4]
			int t=(int)(Math.random()*10);//1	numarr[1]
			int temp=numarr[f];  //numarr f�� ���� tmep��
			numarr[f]=numarr[t];//numarr t�� ���� f��
			numarr[t]=temp; //temp�� ���� t��  �̷������� ������.
		}
		for(int i=0;i<answer.length;i++) 
		{	answer[i]=numarr[i]; //numarr���Ӱ��� answer�� �Ű���.
			//System.out.print(answer[i]);
		}
	/*	for(int a:answer)
		{
			System.out.print(a);
		}System.out.println();*/ //��ǻ�Ϳ� ������ ���� �Ϻη� ������
		
		//����ڷκ��� ������ �ɶ����� 4�ڸ� ���ڸ� �Է¹ޱ�
		Scanner s = new Scanner(System.in);
		int [] data = new int[4];
		while(true) {
			//ȭ�鿡�� 4�ڸ� ���� �Է�.
			System.out.println("���δٸ� 4�ڸ� ���ڸ� �Է��ϼ���");
			String input=s.next(); // input= ���ڷ� �̷���� ���ڿ�
			//"1234" => data[0]=1 data[1]=>2 data[2]=>3 data[3]=>4
			for(int i=0;i<data.length;i++) {
					data[i]=input.charAt(i)-'0';   //data[i]��  input�� �޾ƿ��� i��° ù��° ���ڿ���(-'0'//�ƽ�Ű) �����Ͽ� ���ڷ� ������  
				System.out.print(data[i]);
			}System.out.println();
			//��Ʈ����ũ,�� ����
			int strike=0;
			int ball=0;
			
			for(int i=0;i<answer.length;i++) {			 
				for(int j=0; j<answer.length;j++) {
					if(answer[i]==data[j]) {
					if(i==j)
					strike++;
					else ball++;
					break;
					}
				}
			}
			
			if(strike==4) {
			System.out.println("�����Դϴ�. ������ �����մϴ�.");
			break;
			}else {
				System.out.println(strike+"��Ʈ����ũ "+ball+"��");
			}
		}		
	}
}

			/*for(int i = 0; i< data.length; i++)
			{            
			if(answer[i]==data[i])      
			strike++;
			else
			{
			for(int j =0; j <data.length; j++)
			{
			if(answer[i]==data[j])
			ball++;
			}
			}
			}*/

