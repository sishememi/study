package chap7;
/*
 * static 변수를 이용하여 자동차 시리얼 번호 설정하기.
 * */

class Sonata2{
	String color;
	int number;
	int serialNo;
	static int sno; //클래스변수 기본값 =0(초기화)
	static int width = 250;//클래스변수 
	static int height = 150;//클래스변수 
	public String toString() {
		return "자동차고유번호:"+serialNo+","+color+":"+number
				+"("+width+","+height+" :자동차 생산번호="+sno+")";
	}
	
}

public class SonataEx2 {
	public static void main(String[] args) {
		Sonata2 car1= new Sonata2(); //객체1
		car1.color="white";
		car1.number=1234;
		car1.serialNo= ++Sonata2.sno; //sno 값이 2로나옴 car2의 sno 시리얼번호가 2번으로 도ㅣ어있기때문  
	//  System.out.println(car1); 여기에 먼저 써주면 자동차생산번호 1로찍힘
		Sonata2 car2 = new Sonata2(); //객체2		
		car2.color="black";
		car2.number=5678;
		car2.serialNo= ++Sonata2.sno;
		System.out.println(car1); //자동차 생산번호2
		System.out.println(car2);//자동차 생산번호2
		Sonata2 car3 = new Sonata2();//객체3
		car3.color="red";
		car3.number=4321;
		car3.serialNo= ++Sonata2.sno;
		System.out.println(car3);
		Sonata2 car4 = car3; //객체X 객체의 갯수= new Sonata2();의 수
		System.out.println(car4); //car3과 같은 내용
	}

}
