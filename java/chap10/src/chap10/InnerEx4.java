package chap10;
/*
 * 무명의 내부 클래스
 */
interface I {
	void test();
}
abstract class Abs{
	abstract void test();
}
public class InnerEx4 {
	public static void main(String[] args) {
		 I i = new I() {
			 int iv = 100;
			@Override
			public void test() {
				System.out.println("iv="+iv);
				System.out.println("this.iv="+this.iv);
				System.out.println("내부 클래스의 test 메서드");
			}
			
		};
		i.test();//test()는 인터페이스 I의 멤버이기 때문ㅇ ㅔ접근 가능.
//		System.out.println(i.iv); //iv멤버는 인터페이스 I의 멤버가 아니기 때문에 출력 불가. 이름이 없기때문에 
		int iv = 100;
//		iv++;
		//무명의 내부클래스는 지역내부 클래스임.
		//지역변수는 내부클래스에서 사용할때 상수화가 필요하다.
		Abs a = new Abs() {
			@Override
			void test() {
				System.out.println("iv="+iv); //지역변수 iv 출력
				System.out.println("Abs 내부 클래스의 test 메서드");
			}
		};
		a.test();
		
	}
}
