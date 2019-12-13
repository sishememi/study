package chap14;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListEx1 {
	public static void main(String[] args) {
		//<Integer>:제네릭 표현
		//List<Integer> : Integer 객체를 여러개 저장하는 객체를 참조할 참조변수 선언.
		//ArrayList : 가변배열. 저장할 갯수를 몰라도 객체를 저장.
		//			     첨자 사용 가능
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);list.add(2);list.add(5); // autoboxing
		list.add(4);list.add(3);list.add(0);
		list.add(0);
		System.out.println(list);
		for(int i=0; i<list.size();i++) {
			System.out.println(i+1+":"+list.get(i));
		}
		//list.subList(1, 4) : list 객체의 1번 인덱스부터 3번 인덱스까지 부분리스트로 리턴.
		List<Integer> list2 = new ArrayList<Integer>(list.subList(1, 4));
		System.out.println(list2);
		
		//list2를 정렬
		//Collections : Collection 프레임워크에 관련된 추가 기능을 멤버로 가진 클래스
		Collections.sort(list2); //list2 List 객체를 졍렬.
		System.out.println(list2);
	}
}
