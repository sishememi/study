package chap14;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/*
 * ȭ�鿡�� Ȧ������ ���ڸ� �Է¹޾Ƽ� ������ ��հ� �߰����� ����ϱ�.
 * 
 * 10 40 30 60 30 
 * 
 * �߰���=> 10,30,30,40,60  ���� �� �߰��� �ִ°�
 * ��հ�:...
 * �߰���:30
 */
public class Exam1 {
	public static void main(String[] args) {
		System.out.println("���� Ȧ������ �Է��ϼ��� ");
		int sum=0;
		List<Integer> list = new ArrayList<Integer>();
		Scanner scan = new Scanner(System.in);
		while(true) {
			int num = scan.nextInt();
			list.add(num);
			if(list.size()%2==1) {
				System.out.println("���� �Է��� �����ڽ��ϱ�?(y/n)");
				String  yn = scan.next();
				if(yn.equalsIgnoreCase("y")) break;
			}
		}
		System.out.println(list);
		
		for(int i=0;i<list.size();i++) {
			sum += list.get(i);
		}
		System.out.println("������ ����: "+sum);
		System.out.println("��հ�: "+sum/list.size());
		
		Collections.sort(list);
		System.out.println(list);
		System.out.println("�߰���: "+list.get(list.size()/2));
	}

}
