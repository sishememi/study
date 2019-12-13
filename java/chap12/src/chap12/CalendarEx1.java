package chap12;

import java.util.Calendar;

/*
 * Calendar Ŭ���� ����.
 * Calendar Ŭ������ �߻� Ŭ�����̹Ƿ� new Calendar() �����ڷ� ��ü ���� �Ұ�.
 * �� getInstance() static �޼���� ���� ��¥�� �ش��ϴ� ��ü�� ����
 */
public class CalendarEx1 {
	public static void main(String[] args) {
		Calendar today = Calendar.getInstance();
		System.out.println(today);
		System.out.println("���� �⵵: "+today.get(Calendar.YEAR));
		System.out.println("�̹���: "+today.get(Calendar.MONTH)+1);//MONTH 0�̸� 1�� �׷��� +1�� ����
		System.out.println("����� ��°��: "+today.get(Calendar.WEEK_OF_YEAR));
		System.out.println("������ ��°��: "+today.get(Calendar.WEEK_OF_MONTH));
		System.out.println("����: "+today.get(Calendar.DATE));
		System.out.println("����: "+today.get(Calendar.DAY_OF_MONTH));
		System.out.println("�⵵���س�¥: "+today.get(Calendar.DAY_OF_YEAR));
		System.out.println("����(1(��)~7(��)): "+today.get(Calendar.DAY_OF_WEEK));
		System.out.println("�����ظ�°����: "+today.get(Calendar.DAY_OF_WEEK_IN_MONTH));
		System.out.println("����(0)_����(1): "+today.get(Calendar.AM_PM));
		System.out.println("�ð�(0~11): "+today.get(Calendar.HOUR));
		System.out.println("�ð�(0~23): "+today.get(Calendar.HOUR_OF_DAY));
		System.out.println("��(0~59): "+today.get(Calendar.MINUTE));
		System.out.println("��(0~59): "+today.get(Calendar.SECOND));
		System.out.println("�и���(0~999): "+today.get(Calendar.MILLISECOND));
		//today.get(Calendar.ZONE_OFFSET): �ð��� �и��ʷ� ����.
		System.out.println("Timezone(-12~12): "+today.get(Calendar.ZONE_OFFSET)/(60*60*1000));
		System.out.println("�̹����� ������ ��¥: "+today.getActualMaximum(Calendar.DATE));
		
		Calendar cal = Calendar.getInstance();
		cal.set(2019,(12-1),30);
		System.out.println("��¥: "+cal.get(Calendar.YEAR)+"��"+cal.get(Calendar.MONTH)+"��"+cal.get(Calendar.DATE)+"��");
		//12���� ������ ����
		System.out.println("��������¥: "+cal.get(Calendar.YEAR)+"��"+cal.get(Calendar.MONTH)+"��"+cal.getMaximum(Calendar.DATE)+"��");
		
		cal.set(2019,(12-1),31);
		String week = null;
		switch(cal.get(Calendar.DAY_OF_WEEK)) {
		case 1 : week="�Ͽ���";break;
		case 2 : week="������";break;
		case 3 : week="ȭ����";break;
		case 4 : week="������";break;
		case 5 : week="�����";break;
		case 6 : week="�ݿ���";break;
		case 7 : week="�����";break;
		}System.out.println(week);
		
		System.out.println("��������¥: "+cal.get(Calendar.YEAR)+"��"+cal.get(Calendar.MONTH)+"��"+cal.getMaximum(Calendar.DATE)+"��");
	}
}
