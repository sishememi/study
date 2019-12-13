package chap12;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
 * Date Ŭ���� ����
 * SimpleDateFormat : ����ȭ Ŭ����.
 *		Strig format(Date) : Date Ÿ���� ��ü�� ����ȭ�� ���ڿ��� �����Ͽ� ����.
 *		Date parse(String) : ����ȭ�� ���ڿ��� Date ��ü�� ����.
 */
public class DateEx1 {
	public static void main(String[] args) {
		Date now = new Date(); //����ð� ��ü ����, ����ð��� ��ü�� ����� now�� ����.
		System.out.println(now);
		//SimpleDateFormat : ��¥�� ���ڿ� ����.
//							  ���ڿ� ��¥�� ���� ����.
		/*
		 * yyyy : �⵵�� 4�ڸ� ���
		 * MM : ��
		 * dd : ����
		 * HH : 0 ~ 23��
		 * hh : 1 ~ 12��
		 * mm : ��
		 * ss : ��
		 * E  : ����
		 * a  : ����,����
		 */
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss E a");
		String dispDate = sf.format(now);
		System.out.println(dispDate);
//		System.out.println(sf.format(now));//format ���� �������������ιٲٴ°�
		String  strDate = "2019-09-21";
		SimpleDateFormat sf2 = new SimpleDateFormat("yyyy-MM-dd");//yyyy-MM-dd�������� ���� �� format ��ų�� �ִ�.
		Date day = null;
		try {
			day = sf2.parse(strDate);//parse ������ => ��¥��
		}catch(ParseException e) {
			e.printStackTrace();
		}
		System.out.println(day);
		System.out.println(sf.format(day));
		
		//����: 2019�� 12�� 31���� ���� ����ϱ�.
		//		�� �Է°��� "2019�� 12�� 31��"���·�
		//   	    ��°��� "2019-12-31 ��¥�� ������ ??���� �Դϴ�."
		
		strDate = "2019�� 12�� 31��";
		SimpleDateFormat sf3 = new SimpleDateFormat("yyyy��MM��dd��");//yyyy��MM��dd���������� ������ �ְ� sf3��ü�� format ��ų�� �ִ�.
		try {
		day = sf3.parse(strDate); //��,��,�� �� �˰� parse��Ŵ
		}catch(ParseException e){
			e.printStackTrace();
		}
		SimpleDateFormat sf4 = new SimpleDateFormat("yyyy-MM-dd��¥�� ������  E���� �Դϴ�.");
		System.out.println(sf4.format(day)+"��¥�� ������");
	}
}
