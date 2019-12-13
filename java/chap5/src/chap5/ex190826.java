package chap5;

import java.util.Scanner;

public class ex190826 {
	public static void main(String[] args) {
		
	
		 /*System.out.println("점수를 입력하세요");
		  Scanner scan = new Scanner(System.in);
		  int num = scan.nextInt();
		   switch(num/10){
		    case 10:
		    case 9:
		    case 8:
		    case 7:
		    case 6: System.out.println("합격");break;
		    default: System.out.println("불합격");
		   }*/

		   
		int sum=0;
		int i=1;
		System.out.println("for 구문 사용");
		for(i=1;i<=100;i++) {	
			if(i%2==0) {
				sum+=i;		
			}
		}System.out.println("1~100까지 짝수의 합:"+sum);
			
		System.out.println("while 구문 사용");
		sum=0;
		i=0;
		while(i<=100) {	
			if(i%2==0) {
			sum+=i;
			i=i+2;	
			}
		}System.out.println("1~100까지 짝수의  합:"+sum);
		
		System.out.println("do while 구문사용");
		sum=0;
		i=0;
		do {
			sum+=i;
			i=i+2;
		}while(i<=100);
		System.out.println("1~100까지 짝수의  합:"+sum);
		
	}
}


/* 0부터 했을때
  int sum=0;
  int i=0;
  System.out.println("for 구문 사용");
  for(i=0;i<=100;i=i+2) {
   sum+=i;  
  }System.out.println("1~100까지의 합:"+sum);
  
  System.out.println("while 구문 사용");
  sum=0;
  i=0;
  while(i<=100) {   
   sum+=i;
   i=i+2;   
  }System.out.println("1~100까지의 합:"+sum);
  
  System.out.println("do while 구문사용");
  sum=0;
  i=0;
  do {
   sum+=i;
   i=i+2;
  }while(i<=100);
  System.out.println("1~100까지의 합:"+sum);
  
  */
 