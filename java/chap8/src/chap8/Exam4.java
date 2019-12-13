package chap8;
/*
 * 1.Animal 클래스 => 추상클래스
 * 	멤버변수: 동물의 종류, 다리수
 * 	생성자: 동물의 종류랑 다리수 입력받기.
 * 	멤버메서드:
 * 			void eat() => 추상메서드
 * 			void sound() => 추상메서드
 * 2.Dog 클래스: Animal 클래스의 자손클래스
 * 	생성자의 매개변수 없음.
 * 	멤버메서드:
 * 		void eat(): "주인이 주는대로 먹는다" 출력
 * 		void sound(): "멍멍";
 * 3.Lion클레스: Animal 클래스의 자손클래스
 * 	생성자의 매개변수 없음.
 *  멤버메서드:
 *  	void eat(): "초식동물을 잡아먹는다" 출력
 *  	void sound():"어흥";
 * */
abstract class Animal {
	String type;
	int leg;
	
	Animal(String type,int leg){
		this.type=type;
		this.leg=leg;
	}
	
	abstract void eat();
	abstract void sound();
}
class Dog extends Animal{
	
	Dog(){
		super("개",4);
		
	}
	@Override
	void eat() {
		System.out.println("주인이 주는대로 먹는다");
	}
	@Override
	void sound() {
		System.out.println("멍멍");
	}
}

class Lion extends Animal{
	 Lion(){
		 super("사자",4);
	 }

	@Override
	void eat() {
		System.out.println("초식동물을 잡아먹는다");
	}

	@Override
	void sound() {
		System.out.println("어흥");
	}
}
public class Exam4 {
	public static void main(String[] args) {
		Animal [] animal = new Animal[2];
		animal[0] = new Dog();
		animal[1] = new Lion();
		for(Animal a : animal) {
			System.out.print(a.type+ "=>");
			a.sound(); //[0]=dog에있는 최종 오버라이딩 된 메서드 호출,Animal타입의 추상메서드
			a.eat(); //Animal타입의 추상메서드, 최종 오버라이딩 된 메서드가 호출된다.
		}
		
	}
}
