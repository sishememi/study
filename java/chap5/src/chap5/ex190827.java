package chap5;

import java.util.Scanner;

public class ex190827 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("������ ���Ƹ��� �հ� �Է�:");
		int mari = scan.nextInt();
		System.out.println("������ ���Ƹ��� �ٸ��� �հ� �Է�:");
		int leg = scan.nextInt();
		boolean check=false;
		int d,c;
		for(d=0;d<=leg;d++) {
			for(c=0;c<=leg;c++) {
				if(d*4+c*2==leg && mari==d+c) {
				System.out.println("������"+d+"����,���Ƹ�"+c+"����");
				check =true;
				break; 
					}
				}
			}
			if(!check) //if(d>leg)
				System.out.println("�������");
		
	
		
		/*for(int x=0;x<=10;x++) {
			for(int y=0;y<=10;y++) {
				if(2*x+4*y==10) {
					System.out.println("x="+x+",y="+y);
				}
			}
		}*/
		
		/*for(int x=1;x<=6;x++) {
			for(int y=1;y<=6;y++) {
				if(x+y==6) {
					System.out.println(x+","+y);
				}
			}
		}*/
	}
}

