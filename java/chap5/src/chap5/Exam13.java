package chap5;
/*
 * �̵�ﰢ��
 * ���� �Է� 3
 * 		*   len-i ��ŭ��´�
 * 	   ***
 * 	  *****	 �ٴ� (len*2)-1
 * �ٽ�Ǯ��
 * */
import java.util.Scanner;

public class Exam13 {

	public static void main(String[] args) {
		System.out.println("�ﰢ���� ���̸� �Է��ϼ���.");
		Scanner scan = new Scanner(System.in);
		int len = scan.nextInt();
		int bottom = (len*2)-1;		
		int m=bottom/2 ;
		
		for(int i=0; i<len; i++) {
			for(int j=0; j<bottom; j++) {
				if(j>=m-i && j<=m+i) {
					System.out.print("*");
				}else System.out.print(" ");
			}System.out.println();
		}
	}	
}


