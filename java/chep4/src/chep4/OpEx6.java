package chep4;

import java.util.Scanner;

/*
 * 산술연산
 * 	/ : 나누기 연산자
 * 		정수=정수/정수
 * 	% : 나머지 연산자
 * 		나머지연산의 결과 값의 부호는 피젯수의 부호와 같다.
 * 
 * */
public class OpEx6 {

	public static void main(String[] args) {
		System.out.println(10/8);//1
		System.out.println(10/-8);//-1
		System.out.println(-10/8);//-1
		System.out.println(-10/-8);//1
		
		System.out.println(10%8);//2
		System.out.println(10%-8);//2
		System.out.println(-10%8);//-2
		System.out.println(-10%-8);//-2
		// %연산의 결과 부호는 피젯수의 부호를 따라감(나누어지는수).
		
		//12345 초가 몇시간 몇분 몇초인지 출력하기
		//결과
		//??시 ??분 ??초
		//3681초
		//3681/3600 => 1 시간 
		//(3681 % 3600)/60 => 1분
		//(3681 % 3600)%60 => 21초
		int num =12345;
		//키보드에서  입력받기
		System.out.println("계산할 초를 입력하세요");
		Scanner scan=new Scanner(System.in);
		num=scan.nextInt();
		System.out.println(num/3600+"시"+(num%3600)/60+"분"+num%60+"초");
		 float f1 = 1F;        
		  float f3 = '1'; 
		  float f2 = (float) 1.0;     
		  String f4 = "1";   
		  float f5 = (float) 1.0d; 
  
	}

}
