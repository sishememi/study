package chap14;

import java.util.HashSet;
import java.util.Set;

/*
 * Set �������̽�: �ߺ� ��ü�� �������� �ʴ´�. ���� ������ ���� ���� �ʴ´�.
 * 		����Ŭ����: HashSet,LinkedHashSet, TreeSet �� �ִ�.
 */
public class SetEx1 {
	public static void main(String[] args) {
		Object [] arr= {"ȫ�浿",1,"1","���","�̸���","ȫ�浿","������","�����,","ȫ�浿","���"};
		Set<Object> set1 = new HashSet<Object>();//���� 1,���ڿ� "1" �ٸ�.
		Set<Object> set2 = new HashSet<Object>();
		Set<Object> set3 = new HashSet<Object>();
		for(int i=0; i<arr.length;i++) {
			if(!set1.add(arr[i])){//true�ƴϸ� false����. 2��° ȫ�浿�� set1�� �̹� ������ Set�� �ߺ��Ұ���. �׷��ϱ� 
				if(!set2.add(arr[i])) { //set2�� ȫ�浿�� ��. ���⿡�� �̹�ȫ�浿�� ������
					set3.add(arr[i]);//3��° ȫ�浿�� set3�� ��
				}
			}
		}
		System.out.println(set1);
		System.out.println(set2);
		System.out.println(set3);
		
	}
}
