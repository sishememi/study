package chap9;

import java.util.Scanner;

public class e0916 {
	public static void main(String[] args) {
//		Scanner scan = new Scanner(System.in);
//		System.out.println("두개의 정수를 입력하세요");
//		int num1 = scan.nextInt();
//		int num2 = scan.nextInt();
//		int min = (num1>num2)?num1:num2;
//
//		System.out.print(num1+"과"+num2+"의 공약수:");
//		for(int i=1;i<=min;i++) {		
//			if(num1%i==0 && num2%i==0) {
//				
//				System.out.print(i+" ");
//			}
//		}
		int arr[]= {1,2,3,4,5,6,7,8,9};
		int num[]= new int[3];
		
		for(int i=0;i<1000;i++) {
			int f=(int)(Math.random()*9);
			int l=(int)(Math.random()*9);
			
			int tmp=arr[f];
			arr[f]=arr[l];
			arr[l]=tmp;
		}
		
		for(int i=0;i<num.length;i++) {
			num[i]=arr[i];
		}
		
		for(int i=0;i<num.length;i++) {
			System.out.print(num[i]);
		}
	}
}


