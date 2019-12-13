package chap19;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

public class IteratorEx1 {
	
	public static void main(String[] args) {
		List<String> list = Arrays.asList("홍길동","김삿갓","이몽룡","성춘향","임꺽정","향단이");
		System.out.println("외부 반복자 이용");
		Iterator it = list.iterator(); //list 객체 참조
		while(it.hasNext()) { //읽어올값 있으면 
			System.out.println(it.next()); //출력
		}
		System.out.println("내부 반복자 이용");
//		list.stream().forEach(s->System.out.println(s));
		Stream<String> st = list.stream();//Stream = 데이터 덩어리? , List객체를 Stream 객체 변환
		st.forEach(s->{ System.out.println(s); });//forEach = s를 알아서 돌려줌 st객체의 마지막까지
		System.out.println("다시출력");
		//st.forEach(s->{ System.out.println(s); });//error 이미 위에서 s를 다돌렸기때문에
		list.stream().forEach(s->{ System.out.println(s); });//다시돌리려면 이렇게해야함.
	}
}
