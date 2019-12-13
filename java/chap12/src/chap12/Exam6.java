package chap12;

import java.util.Calendar;
import java.util.Scanner;

public class Exam6 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("�⵵�� �Է��ϼ���.");
		int year = scan.nextInt();
		System.out.println("���� �Է��ϼ���.");
		int month = scan.nextInt();
		
		Calendar cal = Calendar.getInstance();
		
		cal.set(year,month-1,1);//month-1 => 0 �� 1�� , ������ ���� 1�� ����
		
		int firstweek = cal.get(Calendar.DAY_OF_WEEK); //1���� ���ۿ���
		int lastday = cal.getActualMaximum(Calendar.DATE); //�ش� ���� ��������¥
		
		System.out.println("\t" + year + "��" + month + "��");
//		System.out.println(" ��\t��\tȭ\t��\t��\t��\t��");
		System.out.printf("%5s%5s%5s%5s%5s%5s%5s\n","��,��,ȭ,��,��,��,��".split(","));

//1.		
//		int day=1;
//	
//		for(int i=1; i <= 7; i++) {
//			for(int j =1; j <= 7; j++) {
//				if(i==1 && j<firstweek)
//					System.out.printf("%3s"," ");
//				else
//					System.out.printf("%3d",day++);
//				if(day > lastday) break;
//			}
//			if(day > lastday) break;
//			System.out.println();
//		}
		
		
//2.		
		for(int i=1,day=1;day<=lastday;i++) {
			if(i < firstweek) System.out.printf("%3s"," ");
			else System.out.printf("%3d",day++);
			if(i%7==0) System.out.println();
		}
	}
}
