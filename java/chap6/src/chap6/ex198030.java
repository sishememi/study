package chap6;

import java.util.Scanner;

public class ex198030 {
	public static void main(String[] args) {
	
		String str = "it is possible to draw a parallel between their experience and ours";
		
		int arr[]= new int [26]; //a~z ������ ���� ������ �迭
		
		for(int i=0; i<str.length();i++) {
			char ch = str.charAt(i);
			if(ch >= 'a' && ch<='z') {//�ҹ����� ��츸 
				arr[ch-'a']++; // arr[0]�� ='a'-'a' arr[1]��='b'-'a' ...
			}
		}
		System.out.println(str+"���ڰ��� ���ϱ�=>");
		for(int i=0; i<arr.length;i++) {
			System.out.println((char)(i+'a')+":"+arr[i]+"��");
		}
	}
}
		/*//2.��
		if(args.length == 0) {
			   System.out.println("command ���ڸ� �Է��ϼ���");
			   return;
			  }			  
		 int num = Integer.parseInt(args[0]);//����<=���ڿ�
		 int cnt=0;			  
			  // command line���� �Է¹ޱ�     
				  for(int i=1; i<=num; i++){ // �Ҽ��Ǻ�
					  if(num%i==0)
						  cnt++;
					  } 
				  //System.out.println(num);
				  if(cnt==2){
			    System.out.println(args[0] + " : �Ҽ��Դϴ�");
			   } else
			    System.out.println(args[0] + " : ����� " + cnt + "��. �Ҽ��� �ƴմϴ�");
			  }
	}*/

					
/*1��
 * int[] coin = {500,100,50,10,5,1};//������ 6����
int[] cnt = {5,5,5,5,5,5};//������ ����. �ٲ��� �� �ִ� ������ ���� ����������.

System.out.println("�ݾ��� �Է��ϼ���");
Scanner scan = new Scanner(System.in);
int money = scan.nextInt();

int sum=0;

for(int i=0; i<coin.length; i++){
	sum += coin[i]*cnt[i];
}

 if(money>sum)
 {
  System.out.println("������ �����մϴ�");
  return;//�޼��� ����.   �ٲ��ټ� ���� ���.
 } 
 for(int i=0; i<coin.length;i++) {
	 int coinNum=0;
	 //coinNum :�ٲ��� ������ ����
	 coinNum= money/coin[i];
	 //���� �ٲ��� ���� �����ȿ� ������ Ȯ���ؾ���.
	 if(cnt[i]<coinNum) {
		 coinNum=cnt[i];
		 cnt[i]=0;//������ �ִ� ���� ����
	 }else {
	 		cnt[i]-=coinNum;
	 		}
	 money-=coinNum*coin[i];//coinNum=�ٲ��ټ��ִ� �ִ밹�� money���� coinNum���� coin[i]�� ����
  System.out.println(coin[i] + "��¥�� ���� : " + coinNum + "��");
}
for(int i=0; i<coin.length;i++) {
	System.out.println("���� ����"+coin[i]+"��:"+cnt[i]+"��");
}
	}
}*/
	
		
		

		  
/*
int a;
int total=0;
   
for(int i=0;i<coins.length;i++) {
 a=money/coins[i];
 money%=coins[i];  
 System.out.println(coins[i]+"�� ¥�� ����:"+a+"��");
 total+=a;
 }
System.out.println("��ü�ʿ��� ���� ����:"+total);
}
}

* int[] coin = { 500, 100, 50, 10, 5, 1 };
		  int[] cnt = { 5, 5, 5, 5, 5, 5 };
		  
		  System.out.println("�ݾ��� �Է��ϼ���");
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
				 }System.out.println(coin[i]+"��:"+a+"��");		 			  
		  }
		  for(int i=0; i<coin.length;i++) { 
			  a=money/coin[i];
			  if(a<=cnt[i]) {
				b=cnt[i]-a;
			  	money%=coin[i];}
			  System.out.println("���� ����"+coin[i]+"��:"+b+"��");
		  }
	 }
}		
*/

