package chap6;

import java.util.Scanner;

public class Exam13 {

	public static void main(String[] args) {
		System.out.println("�迭�� ũ�⸦ Ȧ���� �Է��ϼ���.");
		Scanner s = new Scanner(System.in);
		int odd = s.nextInt();
		int sum=0;
		//int p=0;
		
		//int num = odd;
		
		int [][]matrix = new int[odd][odd];

		for(int i=1;i<=odd;i+=2) {
			sum+=i;
		}System.out.println(sum);
		/*while(num > 0) {
			sum+=num;
			num-=2;
		}*/
		
		int result=sum*2-1; //���ۼ���
			
			for(int i=0; i<=odd/2;i++) {
				for(int j=i; j<odd-i;j++) {
					matrix[i][j]= result--;
					//result--;	
			}
		}
		
			for(int i=(odd/2)+1; i<odd;i++) {
				for(int j=odd-i-1; j<=i;j++) {
					matrix[i][j]= result;
					result--;	
			}System.out.println();
		}
	
		//matrix  ���
		for(int i=0; i<matrix.length;i++) {
			for(int j=0; j<matrix[i].length; j++) {
				System.out.print((matrix[i][j]==0)?"\t":matrix[i][j]+"\t");
			}
			System.out.println();
		}
		/*for(int i=0; i<matrix.length;i++) {
			for(int j=0; j<matrix[i].length; j++) {
				if(matrix[i][j]==0) {
					//' '�� 4�ڸ� Ȯ���Ͽ����
					System.out.printf("%4c",' ');
				}else {
					//%4d :matrix[i][j]���� 10���� 4�ڸ��� ���
					System.out.printf("%4d",matrix[i][j]);
				}
				
				}
			
			}*/
			System.out.println();
		}
	}


