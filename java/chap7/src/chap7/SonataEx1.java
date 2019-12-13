package chap7;
/*
 * 선언 위치에 따른 변수의 종류
 * 클래스 변수: 클래스 내부에 선언.
 * 			static 예약어로 선언함
 *			클래스 정보가 메모리에 로드될때 변수메모리 할당.	
 *			객체화와 관련없는 변수임
 *			메모리할당 위치: 클래스 영역.
 *			큰 특징: 클래스의 모든 객체의 공통 변수로 사용됨.
 *			사용: 클래스명.변수명
 * 
 * 인스턴스 변수: 클래스 내부에 선언됨
 * 			   자료형 변수명; 선언됨.
 * 			   객체화시 메모리 할당 
 * 			   반드시 객체화 되어야 변수를 사용할 수 있음
 * 			   메모리 할당 위치: 힙영역
 * 			   사용: 참조변수명.변수명
 * 
 * 지역변수 : 메서드 내부에서 선언됨. ?왜 지역변수?변수 선언시에만사용됨.메서드 종료시 변수도 함께 종료
 * 	(매개변수포함) 초기화되어야함.
 * 			  변수선언이 실행될때 메모리 할당.
 * 			  메모리 할당 : 스택영역 
 * 			  사용: 변수명
 *  * */
class Sonata{
	String color; //인스턴스변수
	int number;  //인스턴스변수
	static int width = 250; //클래스 변수
	static int height = 150;//클래스 변수
	public String toString()//글로 자동호출 
	{
		return color + ":" + number + "(" + width + "," + height +")";
	}
}
public class SonataEx1 {
	public static void main(String[] args) {
			System.out.println("자동차크기:"+ Sonata.width + ","+Sonata.height);
			 //car1 지역변수, 초기화 됨 rorcp aksefmdjwla..
			Sonata car1 = new Sonata();
			car1.color="White";//힙영역에 할당 ,인스턴스변수 , 참조변수.변수명
			car1.number=1234;//힙영역에 할당
			System.out.println("car1:"+car1); //println에 car1은 car1.toString() 메서드 호출
			
			Sonata car2 = new Sonata();
			car2.color="black";
			car2.number=2345;
			System.out.println("car2:"+car2);
			
			car2.width=300;
			car1.height=200;
			System.out.println("car1:"+car1);
			System.out.println("car2:"+car2);
	}
}
