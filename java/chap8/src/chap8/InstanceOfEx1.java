package chap8;
/*
 * Instanceof 예제
 * */
public class InstanceOfEx1 {
	public static void main(String[] args) {
//		Parent3 p = new Parent3();  //으로하면 컴파일해서 오류남 classcast어쩌고..오류
//		Child3 c = (Child3)p;   // Child3 c = (Child3)p; child가 형변환해서 parent객체를 참조하려고하는데 child객체가 없어서 참조할 수 없다.
								// 해결하려면 Parent3 p = new Child3(); 이렇게 변환해야함. 
		
		Parent3 p = new Parent3();
		if(p instanceof Child3) {  //Child3 ture? 참조가능?, Parent3 p = new Child3(); 일떄 출력
			System.out.println("p 참조변수 객체는 Child3 객체다");
			Child3 c = (Child3)p;
			System.out.println(c.x);
			c.method();
		}
		if(p instanceof Parent3) {//Parent3 p = new Parent3(); 일떄 출력
			System.out.println("p 참조변수 객체는 Parent3 객체다");
		}
		/*
		 * 모든 클래스는 Object 클래스를 상속 받는다.
		 * -> 모든 객체는 Object 객체를 포함한다.
		 * -> 모든 객체는 Object 타입의 참조변수로 참조가 가능하다.
		 * */
		if(p instanceof Object) {//Parent3 p = new Parent3(); 일떄 출력
			System.out.println("p 참조변수 객체는 Object 객체다");
			Object o = p;//Object타입으로 형변환
			System.out.println(p.x);
			//System.out.println(o.x);  //오류  o.x는  object에 멤버만큼만 접근가능. p를 참조할 수 가 없기때문에 참조할 수 없다.
									  //강사님 피셜-> x는 Object 클래스의 멤버가 아니다. 접근할 수 없다. 객체에는 x라는 멤버가있는데, 단지 object타입으로 접근이 불가능
		}
	}
}
