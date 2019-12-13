package chap6;

import java.util.Scanner;

public class ex198030 {
	public static void main(String[] args) {
	
		String str = "it is possible to draw a parallel between their experience and ours";
		
		int arr[]= new int [26]; //a~z 문자의 갯수 저장할 배열
		
		for(int i=0; i<str.length();i++) {
			char ch = str.charAt(i);
			if(ch >= 'a' && ch<='z') {//소문자인 경우만 
				arr[ch-'a']++; // arr[0]번 ='a'-'a' arr[1]번='b'-'a' ...
			}
		}
		System.out.println(str+"문자갯수 구하기=>");
		for(int i=0; i<arr.length;i++) {
			System.out.println((char)(i+'a')+":"+arr[i]+"개");
		}
	}
}
		/*//2.번
		if(args.length == 0) {
			   System.out.println("command 숫자를 입력하세요");
			   return;
			  }			  
		 int num = Integer.parseInt(args[0]);//정수<=문자열
		 int cnt=0;			  
			  // command line에서 입력받기     
				  for(int i=1; i<=num; i++){ // 소수판별
					  if(num%i==0)
						  cnt++;
					  } 
				  //System.out.println(num);
				  if(cnt==2){
			    System.out.println(args[0] + " : 소수입니다");
			   } else
			    System.out.println(args[0] + " : 약수가 " + cnt + "개. 소수가 아닙니다");
			  }
	}*/

					
/*1번
 * int[] coin = {500,100,50,10,5,1};//동전의 6종류
int[] cnt = {5,5,5,5,5,5};//동전의 갯수. 바꿔줄 수 있는 동전의 갯수 정해져있음.

System.out.println("금액을 입력하세요");
Scanner scan = new Scanner(System.in);
int money = scan.nextInt();

int sum=0;

for(int i=0; i<coin.length; i++){
	sum += coin[i]*cnt[i];
}

 if(money>sum)
 {
  System.out.println("동전이 부족합니다");
  return;//메서드 종료.   바꿔줄수 없는 경우.
 } 
 for(int i=0; i<coin.length;i++) {
	 int coinNum=0;
	 //coinNum :바꿔줄 동전의 갯수
	 coinNum= money/coin[i];
	 //내가 바꿔줄 동전 갯수안에 들어가는지 확인해야함.
	 if(cnt[i]<coinNum) {
		 coinNum=cnt[i];
		 cnt[i]=0;//가지고 있는 동전 갯수
	 }else {
	 		cnt[i]-=coinNum;
	 		}
	 money-=coinNum*coin[i];//coinNum=바꿔줄수있는 최대갯수 money에서 coinNum에서 coin[i]를 뺀다
  System.out.println(coin[i] + "원짜리 동전 : " + coinNum + "개");
}
for(int i=0; i<coin.length;i++) {
	System.out.println("남은 동전"+coin[i]+"원:"+cnt[i]+"개");
}
	}
}*/
	
		
		

		  
/*
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
}

* int[] coin = { 500, 100, 50, 10, 5, 1 };
		  int[] cnt = { 5, 5, 5, 5, 5, 5 };
		  
		  System.out.println("금액을 입력하세요");
		  Scanner s = new Scanner(System.in);
		  int money = s.nextInt(); 
		  int a=0;
		  int b=0;
		  
		  for(int i=0;i<coin.length;i++){ 			  
			  a=money/coin[i];
			  if(a>cnt[i]) {
				  a=5;
				  money%=coin[i]; }else {
					  //a=money/coin[i];
					  money%=coin[i];   
				 }System.out.println(coin[i]+"원:"+a+"개");		 			  
		  }
		  for(int i=0; i<coin.length;i++) { 
			  a=money/coin[i];
			  if(a<=cnt[i]) {
				b=cnt[i]-a;
			  	money%=coin[i];}
			  System.out.println("남은 동전"+coin[i]+"원:"+b+"개");
		  }
	 }
}		
*/

