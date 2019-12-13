package chap6;

import java.util.Arrays;

/*
 * 배열의 복사: Arrays 클래스 이용하기.
 * */
public class ArrayEx14 {
	public static void main(String[] args) {

		int score[]= {90,80,70};
		int score2[]=null;
		score2=Arrays.copyOf(score,5 ); //Arrays가 객체를 만들어 전달
		for(int s: score2) {
			System.out.println(s);
		}
	}
}
