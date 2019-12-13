package chap14;

import java.util.HashSet;
import java.util.Set;

/*
 * Set 인터페이스: 중복 객체를 저장하지 않는다. 저장 순서가 유지 되지 않는다.
 * 		구현클래스: HashSet,LinkedHashSet, TreeSet 이 있다.
 */
public class SetEx1 {
	public static void main(String[] args) {
		Object [] arr= {"홍길동",1,"1","김삿갓","이몽룡","홍길동","성춘향","향단이,","홍길동","김삿갓"};
		Set<Object> set1 = new HashSet<Object>();//숫자 1,문자열 "1" 다름.
		Set<Object> set2 = new HashSet<Object>();
		Set<Object> set3 = new HashSet<Object>();
		for(int i=0; i<arr.length;i++) {
			if(!set1.add(arr[i])){//true아니면 false값임. 2번째 홍길동은 set1에 이미 있으니 Set는 중복불가함. 그러니까 
				if(!set2.add(arr[i])) { //set2에 홍길동이 들어감. 여기에도 이미홍길동이 있으니
					set3.add(arr[i]);//3번째 홍길동은 set3에 들어감
				}
			}
		}
		System.out.println(set1);
		System.out.println(set2);
		System.out.println(set3);
		
	}
}
