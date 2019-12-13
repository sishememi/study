package chap19;

import java.util.Arrays;
import java.util.List;

public class FilterStreamEx1 {
	public static void main(String[] args) {
		List<String> list = Arrays.asList("홍길동","김삿갓","홍길동","임꺽정","홍길동");
		list.stream().forEach(n->System.out.println(n));
		System.out.println();
		//Stream distinct() : 기존의 스트림의 요소 중 중복 제거 후 다시 스트림으로 리턴
		list.stream().distinct().forEach(n->System.out.println(n));
		System.out.println();
		//filter(Predicate p) : p의 결과가 true인 요소들로만 Stream으로 리턴
		list.stream().filter(n->n.startsWith("홍")).forEach(n->System.out.println(n));
		System.out.println();
		list.stream().filter(n->n.startsWith("홍")).distinct().forEach(n->System.out.println(n));
		//list.stream().distinct().filter(n->n.startsWith("홍")).forEach(n->System.out.println(n)); 위에와 결과가 같다
		System.out.println();
	}
}
