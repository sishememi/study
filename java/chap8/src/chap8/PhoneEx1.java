package chap8;
/*
 * 상속 예제
 * 
 *  1.자손객체의 객체 생성시 부모객체를 먼저 생성한다.
 *  2.자손객체는 부모 객체의 멤버에 접근 할 수 있다.
 *  3.클래스간의 상속은 단일 상속만 가능하다.
 *    자손클래스의 부모는 한개만 가능하다.
 *  4.모든 클래스는 Object 클래스를 상속받는다. = 모든 클래스에 object객체가 있다.
 *  	모든 객체는 Object 클래스의 객체를 포함한다.
 *  	모든 객체는 Object 클래스의 멤버에 접근이 가능하다.
*/
class Phone extends Object { //extends Object 생략되어있음 모든 부모객체는 object객체 존재.
	boolean power;
	int number;
	void power() {
		power = !power;
	}
	void send() {
		if(power)
		System.out.println("전화걸기");
	}	
	void receiver() {
		if(power)
		System.out.println("전화받기");
	}
}
class SmartPhone extends Phone{ //상속받음 ,phone 객체 포함하고있음
	void setApp(String name) {
		if(power)
			System.out.println(name + "설치중~~");
	}
}
public class PhoneEx1 {
	public static void main(String[] args) {
		SmartPhone sp = new SmartPhone();
		sp.power = true;
		sp.send();
		sp.receiver();
		sp.setApp("네이버");
		
	}
}


