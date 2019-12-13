package chap5;

import java.util.Scanner;

/*
 * 무한반복(루프): 절대 종료되지 않는 프로그램.
 * 화면에서 숫자를 입력받기 99999 숫자 입력되면 입력 종료함.
 * 입력 종료시 숫자의 종합과 평균을 구하기
 * */
public class LoopEx6 {
	public static void main(String[] args) {
		int sum = 0;
		int cnt = 0;
		System.out.println("숫자를 입력하세요(종료:99999)");
		Scanner scan = new Scanner(System.in);
				
		while(true) {
			int num=scan.nextInt();
			if(num==99999) break;
			cnt++;
			sum+=num;
		}
		System.out.println("총합:"+sum);
		System.out.println("평균:"+(double)sum/cnt);
	}
}
