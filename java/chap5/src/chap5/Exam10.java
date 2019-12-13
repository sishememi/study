package chap5;

import java.util.Scanner;

/*
 * 화면에 삼각형 높이를 입력받고, 높이에 맞는 *로 삼각형 출력하기
 * [결과]
 * 삼각형의 높이를 입력하세요
 * 3
 * ***
 * **
 * *
 * 못풀었음
 * */
public class Exam10 {
	public static void main(String[] args) {
		System.out.println("삼각형의 높이를 입력하세요.");
		Scanner scan = new Scanner(System.in);
		int len = scan.nextInt();	
		
		for(int i = 1; i <= len; i++){
			for(int j = len; j >= i; j--) {
				System.out.print("*");			
			}System.out.println();
		}
		// =같음
		for(int i=len;i>=1;i--) {
			for(int j=1;j<=i;j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}


