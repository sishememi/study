package chap5;

import java.util.Scanner;

/*
 * 숫자로 이루어진 문자열을 입력받아 각 자리수 합을 구하기
 * String str=scan.next(); //123
 * str.length(): 3  문자열 길이
 * str.charAt(숫자): 첫번째 문자 
 * str.charAt(0) => '1'
 * str.charAt(1) => '2' 
 * str.charAt(2) => '3' 
 * for구문 이용.
 * */
public class Exam6 {
	public static void main(String[] args) {
		System.out.println("숫자를 입력하세요");
		Scanner scan = new Scanner(System.in);
		String str = scan.next();
		
		int sum=0;
		for(int i=0;i<str.length();i++) //0부터 시작해야 첫번째꺼부터 나옴,조건문 = 이 빠지는 이유는 3자리일때 4 까지 출력되면 안되기때문.
		{
			char a = str.charAt(i);   //=sum+=(str.charAt(i)-'0')
			System.out.println(i+"번째 자리수: "+a);
			sum+=(a-'0'); //0 빼는이유 숫자로 만들어주기위함. ex)50-'0'(48) = 2
			//sum+=(a-48);
			
		}System.out.println("자리수 합:"+sum);
	} 
}
