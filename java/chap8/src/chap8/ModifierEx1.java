package chap8;
/*
 * 접근 제한자
 * 		private < (default) < protected < public
 * 
 * private은 생성자에서 사용가능 객체생성을 막는다. 대표적 Math()생성자
 * */

import chap8.packtest.Modifier2;

class Modifier{
	private int v1 = 100; //자손X 동일클래스에서만 허용
			int v2 = 200; //접근제어자X ,default 같은 클래스,같은 패키지에서 허용
	protected int v3=v1; //같은클래스 같은 패키지 상속관계면 접근가능
	public void method() {
		System.out.println("chap8.Modifier.method() 메서드임");
		System.out.println("v1 = "+100);
		System.out.println("v2 = "+200);
	}
}
class Modifier3 extends Modifier2 {
	public void method() {
		System.out.println("v1="+v1); //v1 변수의 접근제어자가 private임.
		System.out.println("v2="+v2); //v2 변수의 접근제어자가 (default)임
		System.out.println("v3="+v3); //v3 변수의 접근제어자가 protected 임.(상속관계일때 접근허용)
		System.out.println("v4="+v4); //v4 변수의 접근제어자가 public. 모든 접근 허용.
		
	}
}
public class ModifierEx1 {

	public static void main(String[] args) {
		Modifier m1 = new Modifier();
//		System.out.println(m1.v1); //접근 불가.
		System.out.println(m1.v2);
		m1.method();
		Modifier3 m3 = new Modifier3();
//		System.out.println("m3.v1="+m3.v1);
//		System.out.println("m3.v2="+m3.v2);
//		System.out.println("m3.v3="+m3.v3);
		System.out.println("m3.v4="+m3.v4);
//		Math m = new Math(); //Math => 생성자의 접근제어자가  private임. 객체생성 불가 
	
	}
}
