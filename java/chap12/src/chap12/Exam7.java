package chap12;

import java.util.Calendar;
import java.util.Scanner;

/*
 * 년도와 월으 ㄹ입력받아 달력출력하기
 * 2차원 배열 사용
 */
public class Exam7 {
	public static void main(String[] args) {
		int [][] calendar = new int [7][7];
		Scanner scan = new Scanner(System.in);
		Calendar cal = Calendar.getInstance();
		
		while(true) {
			System.out.println("년도를 입력하세요 (종료:9999)");
			int year = scan.nextInt();
			if(year == 9999) break;
			
			System.out.println("월을 입력하세요 (종료:99");
			int month = scan.nextInt();
			if(month == 99) break;
			
			cal.set(year,(month-1),1);//마지막날을 구하기위해 (year,month,1) 넣음
			int lastday = cal.getActualMaximum(Calendar.DATE); //마지막 일자 산출
			//달력 생성하기
			for(int i=1;i<=lastday;i++) {
				cal.set(year,(month-1),i);
				int week = cal.get(Calendar.DAY_OF_WEEK); //요일(1~7)까지의 값
				int weekcnt= cal.get(Calendar.WEEK_OF_MONTH);// 번째 주, 행
				calendar[weekcnt-1][week-1] = i;
			}
			//달력 출력하기
			System.out.printf("%10d년%3d월\n",year,month);
			System.out.printf("%5s%5s%5s%5s%5s%5s%5s\n","일,월,화,수,목,금,토".split(","));
			
			for(int i=0;i<calendar.length;i++) {
				for(int j=0;j<calendar[i].length;j++) {
					if(calendar[i][j]==0)
						System.out.printf("%3s"," ");
						else
							System.out.printf("%3d",calendar[i][j]);
					}
					System.out.println();
				}
				
			}	
		}
	}

