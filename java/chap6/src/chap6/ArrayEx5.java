package chap6;

import java.util.Scanner;

/*
 * 10진수를 입력받아 2,9,10,16 진수로 변경하기
 * 
 * */
public class ArrayEx5 {
	public static void main(String[] args) {
		int [] digit= {2,8,10,16};
		char [] data= {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
		char [] arr = new char[32];
		Scanner s = new Scanner(System.in);
		System.out.println("변환할 10진수를 입력하세요");
		int num=s.nextInt(); //10
		int divnum=num,index=0;
		
		for(int d: digit) { //d=2
			divnum=num;//10
			index=0;
			while(divnum!=0) {
				//arr[0]='0'
				//arr[1]='1'
				//arr[2]='0'
				//arr[3]='1'
				arr[index++]=data[divnum%d]; //10%2=>0
				divnum /= d;//5
			}
			System.out.print(num + "의" + d + "진수 :");
			for(int i=index-1;i>=0;i--) {
				System.out.print(arr[i]);
		}	System.out.println();	
		}
		System.out.println("2진수는:"+Integer.toBinaryString(num));
		System.out.println("8진수는:"+Integer.toOctalString(num));
		System.out.println("16진수는:"+Integer.toHexString(num));							
	}
}
