package chap6;

import java.util.Scanner;

/*
 * 10진수를 8진수로 변환
 */
public class Exam5 {
	public static void main(String[] args) {
	
		int []octal = new int[64];
		System.out.println("8진수 변환할 10진수를 입력하세요");
		Scanner scan = new Scanner(System.in);
		int num=scan.nextInt();
		int divnum=num,index=0;
		while(divnum != 0) {
			octal[index++] = divnum % 8; //div를 8로나눈 나머지를 index로집어넣음
			divnum /= 8;
		}
		System.out.println(num+"의 8진수:");
		for(int i=index-1;i>=0;i--) {
			System.out.print(octal[i]);
		}
		System.out.println();
	}

}
