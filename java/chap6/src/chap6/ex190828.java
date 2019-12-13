package chap6;

import java.util.Scanner;

public class ex190828 {
	public static void main(String[] args) {
		int[] coins = {500,100,50,10,5,1};
		 Scanner scan = new Scanner(System.in);
		 System.out.println("동전으로 바꿀 금액을 입력하세요");
		 int money = scan.nextInt();
		 
		 int a;
		 int total=0;
		    
		 for(int i=0;i<coins.length;i++) {
		  a=money/coins[i];
		  money%=coins[i];  
		  System.out.println(coins[i]+"원 짜리 동전:"+a+"개");
		  total+=a;
		  }
		 System.out.println("전체필요한 동전 갯수:"+total);
		}
		/*for(int coin: coins) {
			  System.out.println(coins[i]+"원 짜리 동전:"+a+"개");
			  cnt+=money/coin;
			  money%coin;
		} System.out.println("전체필요한 동전 갯수:"+cnt);*/
	}


/*
 * 1.
		Scanner scan = new Scanner(System.in);
		 System.out.println("삼각형의 높이를 입력하세요");
		  int h = scan.nextInt();
		  int sum=0;
		  for(int a=0; a<=h; a++) {   //높이
			  sum+=a;
		  }
		for(int i=1;i<=h;i++) {
	
			for(int j=1;j<=h;j++) {
			if(i>j) {
				System.out.print("\t");
			}else {
				System.out.print(sum--+"\t" );
			}
		}
			System.out.println();
	}
2.
System.out.println("삼각형의 높이를 입력하세요:");
			Scanner s = new Scanner(System.in);
			int num=s.nextInt();
			int b=(num*2)-1;
			int sum=0;
			int m=b/2;
			int data=0;
			for(int i=b; i>=1;i-=2) //bottom부터 2개씩 1까지 합
				{ data+=i;} //여기도 5개+3+개+1개=9개....
			
			for(int i=0;i<num;i++) {
				for(int j=0;j<b;j++) {
					if(j>=m-i && j<=m+i) {
						System.out.print(data--+"\t");

					}else System.out.print("\t");
				}
				System.out.println();
			}
 * 
*/
