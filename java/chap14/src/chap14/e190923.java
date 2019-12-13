package chap14;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/* 1 ~ 1000�������� ��ȣ�� ������ ������ �ִ�.
  1�� 1��, 2�� 2��, 3�� 3�� �� ��÷�ϴ� ���α׷� �ۼ��ϱ�
  �� ��÷�� 3����� ��÷�ϰ�, ��÷��ȣ�� �ߺ��Ǹ� �ȵȴ�.
  ����� ������ ����ϹǷ� ����� ����� �޶� ����.
  LinkedHashSet : ��������, �ߺ��Ұ�
  Random
  new ArrayList(Set) : Set ��ü�� List��ü�� ����

 [���]
3�� ���� ��÷�մϴ�.
945
123
6
2�� ���� ��÷�մϴ�.
611
404
1�� ���� ��÷�մϴ�.
797

*** ���� ��÷ ��� ***
1��:797,
2��:404,611,
3��:6,123,945,  

*/
public class e190923 {
	public static void main(String[] args) {  
		Set<Integer> set = new LinkedHashSet<>();
		
		  // 1. 6���� ���ڸ� �̾ƾ���
		while(set.size() < 6) {
			set.add((int)(Math.random()*1000)+1);
			}
		//����Թ���
//		while(set.size()>6) {
//			
//			if(set.size()==0)
//				System.out.println("3�� ��� ��÷�մϴ�.");
//			else if(set.size()==3)
//				System.out.println("2�� ��� ��÷�մϴ�.");
//			if(set.size()==5)
//				System.out.println("1�� ��� ��÷�մϴ�.");
//			int num = (int)(Math.random()*1000)+1;
//			if(set.add(num)) {
//				System.out.println(num);
//			}
//		}
				
//		System.out.println(lott);
		  // 2. ��� ������
		  
		  // 2-1. LinkedHashSet : �������� �ߺ��Ұ� ====== �ε����� ����
		  //  �׷���
		  //  set��ü�� �ε����� �ִ� lott��ü�� ����	
		List<Integer> lott = new ArrayList<Integer>(set);
		System.out.println("3�� ���� ��÷�մϴ�.");
		for(int i=0;i<=2;i++) {
			System.out.println(lott.get(i));
		}
		System.out.println("2�� ���� ��÷�մϴ�.");
		for(int i=3;i<=4;i++) {
			System.out.println(lott.get(i));
		}
		System.out.println("1�� ���� ��÷�մϴ�.");
		for(int i=5;i<=5;i++) {
			System.out.println(lott.get(i));
		}
		System.out.println();
		

		System.out.println("*** ���� ��÷ ��� ***");
		List<Integer> list = new ArrayList<>(set);
//		for(int i=list.size()-1;i>=0;i--) {
//			if(i == list.size()-1) 
//				System.out.println("1��: "+list.get(i));
//			else if(i == list.size()-2)
//				System.out.print("\n2��: "+list.get(i));
//			else if(i < list.size()-2 && i>=3)
//				System.out.print(list.get(i));
//			else if(i==2)
//				System.out.print("\n3��: "+list.get(i));
//			else 
//				System.out.println(list.get(i));
//		}
		System.out.println("1��: "+list.subList(5,6));
		System.out.println("2��: "+list.subList(3,5));
		System.out.println("3��: "+list.subList(0,3));
	

	}
}
