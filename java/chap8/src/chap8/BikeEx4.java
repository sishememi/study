package chap8;
/*
 * 
 * */
class Bike4{
	int wheel;
	int price = 10;
	
	Bike4(int wheel){
		this.wheel = wheel;
	}
	void drive() {
		System.out.println(price+"만원짜리 자전거의 페달을 밟는다.");
	}
	void stop() {
		System.out.println(price+"만원짜리 자전거의 브레이크를 밟는다.");
	}
}

class AutoBike4 extends Bike4{
	boolean power; //기본값 false로 정의
	int price = 200;
	AutoBike4(int wheel){
		super(wheel);
	}
	void power() {
		power =  !power;
		if(power) System.out.println("전원이 켜졌습니다.");
		else System.out.println("전원이 꺼졌습니다.");
	}
	@Override
	void drive() {
		if(!power) power();
		System.out.println(this.price+"만원짜리 자전거의 출발 버튼을 누른다."); //this.price = 200 만원
		System.out.println(super.price+"만원짜리 자전거의 출발 버튼을 누른다.");//super.price = 10 만원
	}
	@Override
	void stop() {
		if(power) System.out.println(price+"만원짜리 자전거의 정지 버튼을 누른다.");
		else System.out.println("전원이 꺼졌습니다. 멈출수 없습니다.");
	}
	
}
public class BikeEx4 {
	public static void main(String[] args) {
		AutoBike4 auto = new AutoBike4(2);
		
		//auto.price: AutoBike4 클래스의  price 값이 출력
		System.out.println("가격은 "+auto.price+"만원입니다.");  
		auto.power();
		auto.drive();
		auto.stop();
		Bike4 bike = auto;  
		//bike.price  : Bike4 클래스의 price 값이 출력됨.
		System.out.println("가격은 "+bike.price+"만원입니다."); 
		//AutoBike4 클래스 drive 메서드  호출
		//drive 내에서 사용된 멤버변수는 메서드를 따른다.
		bike.drive(); 
		bike.stop();
	}
}
