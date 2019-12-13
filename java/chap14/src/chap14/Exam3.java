package chap14;

import java.util.Set;
import java.util.TreeSet;

/*
 * TreeSet 예제: 중복불가, 정렬
 * Lotto 번호 생성기 TreeSet을 이용하여 출력하기
 */
public class Exam3 {
	public static void main(String[] args) {
		Set<Integer> set = new TreeSet<>();//8.0이후
		set.add(10);set.add(0);set.add(6);set.add(4);set.add(2);set.add(0);
		set.add(10);set.add(0);set.add(6);set.add(4);set.add(2);set.add(0);
		System.out.println(set);
		System.out.println("Lotto 번호===================");
		Set<Integer> ball = new TreeSet<>();
		while(ball.size() < 6) {
			ball.add((int)(Math.random()*45)+1);
		}
		System.out.println(ball);
	}

}
