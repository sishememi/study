package chep4;

import java.util.Scanner;

/*
 * 숫자를 입력받아서 양수인 경우 양수로, 음수인 음수로,0인 경우는 0 출력하기
 * 
 * */
public class Exam4 {

	public static void main(String[] args) {
		System.out.println("숫자를 입력하세요");
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
		System.out.println((num>0)?"양수":(num<0)?"음수":"0");
		//System.out.println(num+"은"+result+"입니다.");
	}
}