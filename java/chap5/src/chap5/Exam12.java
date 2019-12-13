package chap5;

/*
 * 화면에 삼각형 높이를 입력받고, 높이에 맞는 *로 삼각형 출력하기
 * [결과]
 * 삼각형의 높이를 입력하세요
 * 3
 * ***
 *  **
 *   *
 * 일단 *을 다찍음 i가 1일때 3개찍고 i가  2일때 2개찍고 i가  1개일때 1개찍기, i가 j보다 작으면 공백.
 * */
import java.util.Scanner;

public class Exam12 {

	public static void main(String[] args) {
		System.out.println("삼각형의 높이를 입력하세요.");
		Scanner scan = new Scanner(System.in);
		int len = scan.nextInt();	
		
			for(int i=1;i<=len;i++) {
				for(int j=1;j<=len;j++) {
					if(i>j) {
						System.out.print(" ");
					}else {	
						System.out.print("*");
					}
				}
				System.out.println();
			}

	}

}
