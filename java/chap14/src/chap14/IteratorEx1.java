package chap14;

import java.util.List;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class IteratorEx1 {
	public static void main(String[] args) {
		Iterator<Integer> it = null;
		List<Integer> list = new ArrayList<Integer>();
		Set<Integer> set = new  HashSet<Integer>();
		for(int i=1;i<=5;i++) {
			list.add(i*10);
			set.add(i*10);
			}
		System.out.println(list);
		System.out.println(set);
		//������ for �������� Collection ��ü�� ��ȸ�� �� �ִ�. ������ �̰� ���� ����.
		//Jdk 5.0 �߰���.
		for(Integer o : list) { //list ������ ���  ���׸��� ���� ������ Object�� ����  for(Object o : set)
			System.out.print(o+",");
		}
		System.out.println();
		for(Object o : set) {
			//set ������ ��µ�. ���׸��� ���� ������ Object�� ����  for(Object o : set) 
			//Ojbect�� �ֻ��� Ŭ���� Integer���׸� �����ص� Object ���𰡴�.
			System.out.print(o+",");
		}
		System.out.println();
		it = list.iterator();
		print(it);
	//	System.out.println(it.next());
		//error �̹� ������ it.remove()�� ���� �������� �ٵ� it.remove()�� ���� �ʾƵ� ����, �ܹ����̱⶧��. 
		it = set.iterator();
		print(it); 
		System.out.println(list);
		System.out.println(set);
	}
	
	private static void print(Iterator<Integer> it) {
		while(it.hasNext()) {
			System.out.println(it.next());
			it.remove();//�ݵ�� next�� �о�;���. list�� �� �ϳ��� �����ϰ� ���ϸ� set�� �ִ°� �о��.
		}	
	}
}
