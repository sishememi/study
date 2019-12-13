package chap18;

/*
 * 매개변수 존재, 리턴타입 없는 경우
 * 매개변수가 한개인 경우() 생략할 수 있다.
 * 실행되는 구문이 한개인 경우 {} 생략 가능
 * 
 */
@FunctionalInterface
interface LambdaInterface3{
	void method(int x);
}
public class LambadaEx3 {
	public static void main(String[] args) {
		LambdaInterface3 f3;
		f3 = (x)->{
			System.out.println(x*5);
		};
		f3.method(2);//10
		f3.method(10);//50
		
		f3= (x)->{ //동적으로 메서드 바꿀수 있다.
			System.out.println(x+x);
		};
		f3.method(10);
		
		f3 = x->System.out.println(x*3); //한줄로 나타내는 방법
		f3.method(10);
	}
}