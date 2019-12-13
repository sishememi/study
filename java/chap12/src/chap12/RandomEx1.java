package chap12;

import java.util.Random;

public class RandomEx1 {
	public static void main(String[] args) {
		Random rand = new Random();
		rand.setSeed(0);//seed 설정 
		Random rand2= new Random();
		/*
		 * currentTimeMillis() : 1970년 1월 1일 부터 현재까지의 시간을 밀리초로 리턴
		 * 						  현재시간. 가만히있어도 항상 값이 변경됨.
		 */
		rand2.setSeed(System.currentTimeMillis());//seed 설정
		System.out.println("rand ==>");
		for(int i=0; i< 5; i++) {
			//정수형 난수 발생 nextInt :0~99 정수형 난수 발생
			System.out.println(i+":"+rand.nextInt(100));
		}
		System.out.println("rand2 ==>");
		for(int i=0; i< 5; i++) {
			System.out.println(i+":"+rand2.nextInt(100));
		}
	}
}
