package chap12;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/*
 * �ΰ��� ��¥�� �Է¹޾Ƽ� �� ��¥������ �ϼ��� ����ϱ�.
 */
public class CalendarEx3 {
	public static void main(String[] args) throws ParseException {
		System.out.println("ù��° ��¥�� �Է��ϼ���(yyyy-MM-dd)");
		Scanner scan = new Scanner(System.in);
		String first = scan.next();
		System.out.println("�ι�° ��¥�� �Է��ϼ���(yyyy-MM-dd)");
		String second = scan.next();
		
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		Date fdate=sf.parse(first);//parse �޼���: ���ڿ� ->DateŸ������ �ٲ���
		Date sdate=sf.parse(second);
		//sdate.getTime(): 1970����� ��¥������ �ð��� �и��ʷ� ��������
		long datecnt = (sdate.getTime()-fdate.getTime())/(1000*60*60*24); 
		System.out.printf("%s -%s ������ ����: %d\n",second,first,datecnt);
	}
}
