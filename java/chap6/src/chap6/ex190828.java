package chap6;

import java.util.Scanner;

public class ex190828 {
	public static void main(String[] args) {
		int[] coins = {500,100,50,10,5,1};
		 Scanner scan = new Scanner(System.in);
		 System.out.println("�������� �ٲ� �ݾ��� �Է��ϼ���");
		 int money = scan.nextInt();
		 
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
		/*for(int coin: coins) {
			  System.out.println(coins[i]+"�� ¥�� ����:"+a+"��");
			  cnt+=money/coin;
			  money%coin;
		} System.out.println("��ü�ʿ��� ���� ����:"+cnt);*/
	}


/*
 * 1.
		Scanner scan = new Scanner(System.in);
		 System.out.println("�ﰢ���� ���̸� �Է��ϼ���");
		  int h = scan.nextInt();
		  int sum=0;
		  for(int a=0; a<=h; a++) {   //����
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
System.out.println("�ﰢ���� ���̸� �Է��ϼ���:");
			Scanner s = new Scanner(System.in);
			int num=s.nextInt();
			int b=(num*2)-1;
			int sum=0;
			int m=b/2;
			int data=0;
			for(int i=b; i>=1;i-=2) //bottom���� 2���� 1���� ��
				{ data+=i;} //���⵵ 5��+3+��+1��=9��....
			
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
