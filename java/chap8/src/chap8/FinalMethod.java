package chap8;
/*
 * final 변경 불가.
 * final method: 재정의 불가. 오버라이딩 불가 메서드.
 * */
public class FinalMethod {
	final void finalMethod() { //오버라이딩 불가 메서드
		System.out.println("finalMethod 오버라이딩 불가");
	}
}

class SubMethod extends FinalMethod{
	void finalMethod() {
		System.out.println("finalMethod 오버라이딩 불가");
	}
}

