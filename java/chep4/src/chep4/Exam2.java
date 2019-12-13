package chep4;

import java.util.Scanner;

/*
 * 화면에서 3자리 정수를 입력받아 100 자리 미만을 버리고 출력하기
 * [결과]
 * 세자리 정수를 입력하세요
 * 321
 * 300*/
public class Exam2 {

	public static void main(String[] args) {
		int num;
		System.out.println("3자리 정수를 입력하세요");
		Scanner scan=new Scanner(System.in);
		num=scan.nextInt();
		System.out.print(num-(num%100));

	}

}
