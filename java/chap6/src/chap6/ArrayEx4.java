package chap6;

import java.util.Scanner;

/*
 * 10진수를 2진수로 변경하기
 * */
public class ArrayEx4 {
	public static void main(String[] args) {
		int []binary = new int[32];
		System.out.println("2진수 변환할 10진수를 입력하세요");
		Scanner scan = new Scanner(System.in);
		int num=scan.nextInt();
		int divnum=num,index=0;
		while(divnum != 0) {
			binary[index++] = divnum % 2; //div를 2로나눈 나머지를 index로집어넣음
			divnum /= 2;
		}
		System.out.println(num+"의 2진수:");
		for(int i=index-1;i>=0;i--) {
			System.out.print(binary[i]);
		}
		System.out.println();
	}
}
