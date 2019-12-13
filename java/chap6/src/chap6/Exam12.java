package chap6;

import java.util.Scanner;

/*
 * 모래시계
 * */
public class Exam12 {
	public static void main(String[] args) {
		System.out.println("배열의 크기를 홀수로 입력하세요.");
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
	
		//matrix  출력
		for(int i=0; i<matrix.length;i++) {
			for(int j=0; j<matrix[i].length; j++) {
				System.out.print(matrix[i][j]);
			}
			System.out.println();
		}
	}
}
