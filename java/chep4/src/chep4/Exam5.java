package chep4;

import java.util.Scanner;
/*
 * 한개의 문자를 입력받아서 소문자인 경우 대문자로 변경하여 출력하기.
 * 소문자가 아닌 경우는 "소문자 아님" 출력하기
 * 
 *  Scanner scan = new Scanner(System.in);
 * String str=scan.next();
 * char ch=str.charAt(0);
 * ch 범위: 'a' <=ch <='z'
 * 대문자=소문자-32;
 * 		
 * */
public class Exam5 {

	public static void main(String[] args) {
		System.out.println("소문자를 입력하세요");
		Scanner scan = new Scanner(System.in);
		String str=scan.next(); //문자열로 입력받음 "A"
		char ch=str.charAt(0);//문자열 중 첫번째 문자 'A'
	   	//boolean result=(ch>='a' && ch <='z');
		//System.out.println(result?(char)(ch-32)+"":"소문자아님");//+"" <=문자열로 바꾸ㅓ줌
		System.out.println((ch >='a' && ch <= 'z')?(char)(ch-32)+"":"소문자아님");
	}	

}
