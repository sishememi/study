package chap5;

import java.util.Scanner;

/*
 * 입력 받은 숫자가 좌우대칭수인지 판단하기
 * 숫자를 입력하세요
 * 121
 * 좌우대칭수
 * 숫자를 입력하세요
 * 123
 * 좌우대칭수 아님
 * 다시풀기
 * */
public class Exam14 {

	public static void main(String[] args) {
		System.out.println("숫자를 입력하세요.");
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
		int c=0;
		int temp=num;
		while(temp!=0) {
			c *= 10;
			c += temp%10;
			temp/=10;
		}
		if(num == c) {		
			System.out.println("좌우대칭");			
		}else {
		System.out.println("좌우대칭아님");
	  }
	}
}
