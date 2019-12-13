package chap8;
/*
 * final 변수: 변경 불가 변수. 상수
 * final 변수도 생성자에서 한번은 값을 설정 할 수 있다.
 * 단 명시적으로 초기화 되지 않은 경우에만 가능하다.
 * const 상수로 사용되지 않는다. 상수는 final 제어자로 표현함
 * */

class FinalValue{
	final int NUM;
	FinalValue(int num){
		NUM=num; //생성자에서 변경 한번 가능함.		
	}
	FinalValue(){
		this(100);
	}

	public int getNUM(){
		return NUM;
	}

}
public class FinalValueEx1 {
	public static void main(String[] args) {
		FinalValue f1 = new FinalValue();
		//f1.NUM=200; NUM은 상수.
		System.out.println(f1.getNUM()); //100
		FinalValue f2 = new FinalValue(120);
		System.out.println(f2.getNUM()); //120
	}
}

