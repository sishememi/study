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
		//개선된 for 구문으로 Collection 객체를 조회할 수 있다. 요즘은 이걸 많이 사용됨.
		//Jdk 5.0 추가됨.
		for(Integer o : list) { //list 값들이 출력  제네릭을 쓰지 않으면 Object로 선언  for(Object o : set)
			System.out.print(o+",");
		}
		System.out.println();
		for(Object o : set) {
			//set 값들이 출력됨. 제네릭을 쓰지 않으면 Object로 선언  for(Object o : set) 
			//Ojbect는 최상위 클래스 Integer제네릭 기입해도 Object 선언가능.
			System.out.print(o+",");
		}
		System.out.println();
		it = list.iterator();
		print(it);
	//	System.out.println(it.next());
		//error 이미 위에서 it.remove()에 의해 지워버림 근데 it.remove()를 하지 않아도 에러, 단방향이기때문. 
		it = set.iterator();
		print(it); 
		System.out.println(list);
		System.out.println(set);
	}
	
	private static void print(Iterator<Integer> it) {
		while(it.hasNext()) {
			System.out.println(it.next());
			it.remove();//반드시 next를 읽어와야함. list에 값 하나씩 제거하고 다하면 set에 있는걸 읽어옴.
		}	
	}
}
