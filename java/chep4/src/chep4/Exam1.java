package chep4;

import java.util.Scanner;

public class Exam1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
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
	}

}
