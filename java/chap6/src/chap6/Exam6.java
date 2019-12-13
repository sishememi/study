package chap6;

import java.util.Scanner;

/*
 * 10진수를 16진수로 변환하여 출력하기
 * */
public class Exam6 {

	public static void main(String[] args) {
		char [] data= {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
		char [] arr= new char[10];
		System.out.println("16진수 변환할 10진수를 입력하세요");
		Scanner scan = new Scanner(System.in);
		int num=scan.nextInt();
		int divnum=num,index=0;
				
		while(divnum != 0) {
			arr[index++] = data[divnum % 16]; //나머지가 0이면 0 나머지가 15이면F 나머지를 첨자로 접근..arr[0]=data[15%16=F],arr[0]번에 F가 저장.
			divnum /= 16; //divnum이 15/16=0 
		}
		System.out.println(num + "의 16진수:");
		for(int i=index-1;i>=0;i--) {
				System.out.print(arr[i]);
		}System.out.println();
	}
}
