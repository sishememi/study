package chap5;

import java.util.Scanner;

/*
 * 숫자를 입력받아서 양수인경우 양수, 음수인 경우 음수 ,0인경우는 0
 * */
public class Exam1 {

	public static void main(String[] args) {
		 System.out.println("숫자를 입력하세요.");
		 Scanner scan = new Scanner(System.in);
		 int num = scan.nextInt();
		
		 if(num>0) {
			 System.out.println("양수입니다.");
		 }else if(num<0) {
			 System.out.println("음수입니다.");
		 }else if(num==0) {
			 System.out.println("0 입니다.");
		 }
		
		
	}

}
