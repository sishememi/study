package chap19;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/*
 * Stream 정렬하기
 */
public class SortedEx1 {
	public static void main(String ... args) //==(String[] args)
	{
		//(String ... a) : 가변 매개 변수(...) =스트링이 여러개 존재해도됨.. / 내부적으로 String[] 형태 저장.
 		List<String> list = Arrays.asList("홍길동","김삿갓","이몽룡","임꺽정");
		System.out.println("기본정렬");
		list.stream().sorted().forEach(System.out::println);
		System.out.println("기본의 역순 정렬");
		list.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);
		
	}
}
