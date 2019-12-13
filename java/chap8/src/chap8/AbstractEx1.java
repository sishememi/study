package chap8;
/*
 * 추상 클래스간의 상속도 가능함.
 * 추상클래스가 자손 클래스인 경우 부모의 추상 메서드를 구현하지 않아도 됨.
 * 단 추상 클래스를 상속받은 일반 클래스는 모든 추상 메서들르 구현해야함.
 * 
 * 자손클래스의 접근제어자는 부모클래스의 접근자를 똑같거나 넓은 범위로 자손 클래스의 접근제어자 생성
 * */
abstract class Abs1{
	int a = 10;
	abstract int getA();
}
abstract class Abs2 extends Abs1{
	int b = 20;
	abstract int getB();
}
class Normal extends Abs2{

	@Override
	int getB() { 	return b;	}

	@Override
	int getA() {	return a;	}	
}
public class AbstractEx1 {
	public static void main(String[] args) {
		Abs1 a1 = new Normal();
		System.out.println(a1.getA()); //10
//		System.out.println(a1.getB()); //error  Abs1에는 getB라는 메서드가 없기떄문에 에러가난다.
		Abs2 a2 = (Abs2)a1; //형변환
		System.out.println(a2.getA()); //10
		System.out.println(a2.getB()); //20
		Normal n = (Normal)a2; //부모->ㅈㅏ식  형변환
		System.out.println(a2.getA()); //10
		System.out.println(a2.getB()); //20
//		a2 = new Abs2(); // error Abs2가 추상클래스이기 떄문에 객체화가 되지않음
		
		

	}
}
