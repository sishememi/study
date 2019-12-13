package chap7;


public class MemberCallEx1 {
	static int cv1 = 10;
	static int cv2 = cv1; //클래스 멤버가 호출
	int iv1 = 100;
	int iv2 = iv1;		//인스턴스멤버간 호출
	int iv3 = cv1;      //인스턴스 멤버에서 클래스멤버 호출 가능
	//static int cv3 = iv1; //클래스멤버에서 인스턴스멤버를 호출 불가능  => 객체화 필요 
	static int cv3 = new MemberCallEx1().iv1; //객체화 시킴.
	public static void main(String[] args) {
//		cv2 = iv1;  // 클래스 멤버인 main메서드에서 iv1인스턴스 멤버에 접근할 수 없음. =>객체화 / cv2는ㅇ ㅣ미 할당 되어있음. 객체화가 되지않으면 iv1은 사용불가/
		cv2= new MemberCallEx1().iv1;
		//iv1 = cv2;  
		new MemberCallEx1().iv1 = cv2;	
//		method1(); // 클래스인 main 에서 인스턴스인 method1을 접근할수 없다. error
		new MemberCallEx1().method1();
		method2(); //
	}
	
	void method1() {   
		System.out.println(cv1 + cv2); 
		System.out.println(iv1 + iv2);
	}
	
	static void method2() {       
		System.out.println(cv1 + cv2);
//		System.out.println(iv1 + iv2);  //변수화되어있지않음 ,객체화 되어있지않음.
		MemberCallEx1 m = new MemberCallEx1();
		System.out.println(m.iv1+m.iv2);
	}
}
