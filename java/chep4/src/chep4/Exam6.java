package chep4;

import java.util.Scanner;

/*
 * 사과를 사과 상자에 담기로 한다. 1개의 상자에 10개의 사과를 담을 수 있다.
 * 필요한 사과 상자의 갯수를 출력하기.
 * [결과]
 * 사과의 갯수를 입력하세요.
 * 22
 * 필요한 상자의 갯수 : 3
 * 
 * 사과의 갯수를 입력하세요
 * 30
 * 필요한 상자의 갯수: 3
 * */
public class Exam6 {

	public static void main(String[] args) {
		
		System.out.println("사과의 갯수를 입력하세요.");
		Scanner scan=new Scanner(System.in);
		int apple = scan.nextInt();
		int result=((apple%10==0)?(apple/10):(apple/10)+1);
		System.out.println("필요한 상자의 갯수:"+result);
		
		
	}

}
