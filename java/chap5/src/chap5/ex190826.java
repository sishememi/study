package chap5;

import java.util.Scanner;

public class ex190826 {
	public static void main(String[] args) {
		
	
		 /*System.out.println("������ �Է��ϼ���");
		  Scanner scan = new Scanner(System.in);
		  int num = scan.nextInt();
		   switch(num/10){
		    case 10:
		    case 9:
		    case 8:
		    case 7:
		    case 6: System.out.println("�հ�");break;
		    default: System.out.println("���հ�");
		   }*/

		   
		int sum=0;
		int i=1;
		System.out.println("for ���� ���");
		for(i=1;i<=100;i++) {	
			if(i%2==0) {
				sum+=i;		
			}
		}System.out.println("1~100���� ¦���� ��:"+sum);
			
		System.out.println("while ���� ���");
		sum=0;
		i=0;
		while(i<=100) {	
			if(i%2==0) {
			sum+=i;
			i=i+2;	
			}
		}System.out.println("1~100���� ¦����  ��:"+sum);
		
		System.out.println("do while �������");
		sum=0;
		i=0;
		do {
			sum+=i;
			i=i+2;
		}while(i<=100);
		System.out.println("1~100���� ¦����  ��:"+sum);
		
	}
}


/* 0���� ������
  int sum=0;
  int i=0;
  System.out.println("for ���� ���");
  for(i=0;i<=100;i=i+2) {
   sum+=i;  
  }System.out.println("1~100������ ��:"+sum);
  
  System.out.println("while ���� ���");
  sum=0;
  i=0;
  while(i<=100) {   
   sum+=i;
   i=i+2;   
  }System.out.println("1~100������ ��:"+sum);
  
  System.out.println("do while �������");
  sum=0;
  i=0;
  do {
   sum+=i;
   i=i+2;
  }while(i<=100);
  System.out.println("1~100������ ��:"+sum);
  
  */
 