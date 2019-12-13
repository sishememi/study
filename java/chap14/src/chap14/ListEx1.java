package chap14;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListEx1 {
	public static void main(String[] args) {
		//<Integer>:���׸� ǥ��
		//List<Integer> : Integer ��ü�� ������ �����ϴ� ��ü�� ������ �������� ����.
		//ArrayList : �����迭. ������ ������ ���� ��ü�� ����.
		//			     ÷�� ��� ����
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);list.add(2);list.add(5); // autoboxing
		list.add(4);list.add(3);list.add(0);
		list.add(0);
		System.out.println(list);
		for(int i=0; i<list.size();i++) {
			System.out.println(i+1+":"+list.get(i));
		}
		//list.subList(1, 4) : list ��ü�� 1�� �ε������� 3�� �ε������� �κи���Ʈ�� ����.
		List<Integer> list2 = new ArrayList<Integer>(list.subList(1, 4));
		System.out.println(list2);
		
		//list2�� ����
		//Collections : Collection �����ӿ�ũ�� ���õ� �߰� ����� ����� ���� Ŭ����
		Collections.sort(list2); //list2 List ��ü�� ����.
		System.out.println(list2);
	}
}
