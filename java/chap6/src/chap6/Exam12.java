package chap6;

import java.util.Scanner;

/*
 * �𷡽ð�
 * */
public class Exam12 {
	public static void main(String[] args) {
		System.out.println("�迭�� ũ�⸦ Ȧ���� �Է��ϼ���.");
		Scanner s = new Scanner(System.in);
		int odd = s.nextInt();
		
		char [][]matrix = new char[odd][odd];
		
		
			for(int i=0; i<=odd/2;i++) {
				for(int j=i; j<odd-i;j++) {
					matrix[i][j]='*';
			}
		}
		
			for(int i=(odd/2)+1; i<odd;i++) {
				for(int j=odd-i-1; j<=i;j++) {
				
				matrix[i][j]='*';
			}
		}
	
		//matrix  ���
		for(int i=0; i<matrix.length;i++) {
			for(int j=0; j<matrix[i].length; j++) {
				System.out.print(matrix[i][j]);
			}
			System.out.println();
		}
	}
}
