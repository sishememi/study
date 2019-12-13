package chap12;

import java.util.Calendar;
import java.util.Scanner;

public class Exam6 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("년도를 입력하세요.");
		int year = scan.nextInt();
		System.out.println("월을 입력하세요.");
		int month = scan.nextInt();
		
		Calendar cal = Calendar.getInstance();
		
		cal.set(year,month-1,1);//month-1 => 0 이 1월 , 선택한 월의 1일 설정
		
		int firstweek = cal.get(Calendar.DAY_OF_WEEK); //1일의 시작요일
		int lastday = cal.getActualMaximum(Calendar.DATE); //해당 월의 마지막날짜
		
		System.out.println("\t" + year + "년" + month + "월");
//		System.out.println(" 일\t월\t화\t수\t목\t금\t토");
		System.out.printf("%5s%5s%5s%5s%5s%5s%5s\n","일,월,화,수,목,금,토".split(","));

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
