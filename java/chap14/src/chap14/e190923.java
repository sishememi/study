package chap14;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/* 1 ~ 1000번까지의 번호를 가지는 복권이 있다.
  1등 1장, 2등 2장, 3등 3장 을 추첨하는 프로그램 작성하기
  단 추첨은 3등부터 추첨하고, 당첨번호는 중복되면 안된다.
  결과는 난수를 사용하므로 실행시 결과가 달라 진다.
  LinkedHashSet : 순서유지, 중복불가
  Random
  new ArrayList(Set) : Set 객체를 List객체로 생성

 [결과]
3등 복권 추첨합니다.
945
123
6
2등 복권 추첨합니다.
611
404
1등 복권 추첨합니다.
797

*** 복권 추첨 결과 ***
1등:797,
2등:404,611,
3등:6,123,945,  

*/
public class e190923 {
	public static void main(String[] args) {  
		Set<Integer> set = new LinkedHashSet<>();
		
		  // 1. 6개의 숫자를 뽑아야해
		while(set.size() < 6) {
			set.add((int)(Math.random()*1000)+1);
			}
		//강사님버전
//		while(set.size()>6) {
//			
//			if(set.size()==0)
//				System.out.println("3등 등복권 추첨합니다.");
//			else if(set.size()==3)
//				System.out.println("2등 등복권 추첨합니다.");
//			if(set.size()==5)
//				System.out.println("1등 등복권 추첨합니다.");
//			int num = (int)(Math.random()*1000)+1;
//			if(set.add(num)) {
//				System.out.println(num);
//			}
//		}
				
//		System.out.println(lott);
		  // 2. 등수 나누기
		  
		  // 2-1. LinkedHashSet : 순서유지 중복불가 ====== 인덱스가 없음
		  //  그래서
		  //  set객체를 인덱스가 있는 lott객체로 생성	
		List<Integer> lott = new ArrayList<Integer>(set);
		System.out.println("3등 복권 추첨합니다.");
		for(int i=0;i<=2;i++) {
			System.out.println(lott.get(i));
		}
		System.out.println("2등 복권 추첨합니다.");
		for(int i=3;i<=4;i++) {
			System.out.println(lott.get(i));
		}
		System.out.println("1등 복권 추첨합니다.");
		for(int i=5;i<=5;i++) {
			System.out.println(lott.get(i));
		}
		System.out.println();
		

		System.out.println("*** 복권 추첨 결과 ***");
		List<Integer> list = new ArrayList<>(set);
//		for(int i=list.size()-1;i>=0;i--) {
//			if(i == list.size()-1) 
//				System.out.println("1등: "+list.get(i));
//			else if(i == list.size()-2)
//				System.out.print("\n2등: "+list.get(i));
//			else if(i < list.size()-2 && i>=3)
//				System.out.print(list.get(i));
//			else if(i==2)
//				System.out.print("\n3등: "+list.get(i));
//			else 
//				System.out.println(list.get(i));
//		}
		System.out.println("1등: "+list.subList(5,6));
		System.out.println("2등: "+list.subList(3,5));
		System.out.println("3등: "+list.subList(0,3));
	

	}
}
