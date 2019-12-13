package chap11;

import java.io.IOException;

/*
 * 오버라이딩 된 메서드의 예외처리는 부모메서드의 예외처리와 같거나 좁은 범위만 가능하다.
 * 또한 관련없는 예외처리도 안된다.
 */
class Parent{
	void method(int i) throws RuntimeException{
		System.out.println(i);
	}
}
class Child extends Parent{
	@Override
	void method(int i) throws RuntimeException{
		System.out.println(i);
		try {
			throw new IOException();
		}catch(IOException e) {};
	}
}
public class ExeptionEx9 {
	public static void main(String[] args) {
		

	}

}
