package chap12;

import java.util.Calendar;
import java.util.Scanner;

/*
 * �⵵�� ���� ���Է¹޾� �޷�����ϱ�
 * 2���� �迭 ���
 */
public class Exam7 {
	public static void main(String[] args) {
		int [][] calendar = new int [7][7];
		Scanner scan = new Scanner(System.in);
		Calendar cal = Calendar.getInstance();
		
		while(true) {
			System.out.println("�⵵�� �Է��ϼ��� (����:9999)");
			int year = scan.nextInt();
			if(year == 9999) break;
			
			System.out.println("���� �Է��ϼ��� (����:99");
			int month = scan.nextInt();
			if(month == 99) break;
			
			cal.set(year,(month-1),1);//���������� ���ϱ����� (year,month,1) ����
			int lastday = cal.getActualMaximum(Calendar.DATE); //������ ���� ����
			//�޷� �����ϱ�
			for(int i=1;i<=lastday;i++) {
				cal.set(year,(month-1),i);
				int week = cal.get(Calendar.DAY_OF_WEEK); //����(1~7)������ ��
				int weekcnt= cal.get(Calendar.WEEK_OF_MONTH);// ��° ��, ��
				calendar[weekcnt-1][week-1] = i;
			}
			//�޷� ����ϱ�
			System.out.printf("%10d��%3d��\n",year,month);
			System.out.printf("%5s%5s%5s%5s%5s%5s%5s\n","��,��,ȭ,��,��,��,��".split(","));
			
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

