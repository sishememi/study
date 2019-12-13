package chap19;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class MapEx1 {
	public static void main(String[] args) {
		List<String> list = Arrays.asList("홍길동전","춘항전","구운몽","전우치전","사씨남정기");
		System.out.println();
		//list.stream().mapToInt(String::length).forEach(len->System.out.println(len));//len 자료형 int=> mapToInt
		IntStream isr = list.stream().mapToInt(String::length); //문자열 자체의 길이를 가지고 새로운 list를 만듬
		isr.forEach(System.out::println);
		System.out.println();
		list.stream().mapToInt(s->s.length()).forEach(System.out::println);//위에랑 결과는 같음, s의 자료형 String=원본데이터(List<String>)에서 String인걸 알려줌
				
	}
}
