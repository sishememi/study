package chap5;

import java.util.Scanner;

/*
 * 화면에서 자연수를 입력받아서 각각의 자리수의 합을 구하기.
 * [결과]
 * 자연수를 입력하세요
 * 123
 * 자리수 합:6
 * 
 * 자연수를 입력하세요
 * 1357
 * 자리수 합:16 
 */
public class Exam5 {
	public static void main(String[] args) {
		System.out.println("숫자를 입력하세요");
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();

		int sum = 0;
		while(num != 0) {		
				sum+=num%10;
				num/=10;// num=num/10
				System.out.println(num);
		}
		System.out.println("자리수 합:"+sum);	 
	}
}
