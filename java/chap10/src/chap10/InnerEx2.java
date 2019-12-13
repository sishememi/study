package chap10;

import chap10.Outer2.InstanceInner;

//java  static 클래스에서 객체를 만들지 않아도됨.
class Outer2{
	private int outeriv = 10;//private 내부클래스에서 사용가능
	private static int outercv = 20;
	class InstanceInner{
		int iiv = outeriv;
		int iiv2 = outercv;
	}
	static class StaticInner{
		int siv = new Outer2().outeriv;//int siv = outeriv; =>에러, 객체를 생성해줘야함
		static int scv = outercv;
	}
	static StaticInner cv = new StaticInner();
	InstanceInner iv = new InstanceInner();
	static InstanceInner cv2 = new Outer2().new InstanceInner(); //Static이 없는 인스턴스멤버이기때문에 클래스멤버에 접근못함.
//	StaticInner iv2 = new StaticInner(); //iv2는 인스턴스..?
	
	void method(int pv) { //지역내부클래스 , 지역변수 pv
		//지역 내부클래스에서 사용되는 메서드의 지역변수는 상수화 되어야한다.
		int i = 0;
//		pv++;
		class LocalInner{ 
			int liv = outeriv; //외부클래스의 private 멤버 접근 가능
			int liv2 = outercv;//외부클래스의 private 멤버 접근 가능
			void method() {
				//지역 내부클래스에서  내부클래스가 속한 메서드의 지역변수 변경이 안됨.
//				i = 100; 
//				pv++; 
				System.out.println("pv="+pv);
				System.out.println(liv+","+liv2);
				System.out.println(outeriv+","+outercv);//외부클래스의 private 멤버 접근 가능
				
			}
		}
		LocalInner li = new LocalInner();
		li.method();
	}
}
public class InnerEx2 {
	public static void main(String[] args) {
			Outer2 out = new Outer2();
			out.method(1);
			Outer2.InstanceInner i2 = out.new InstanceInner();
			System.out.println(i2.iiv);
			System.out.println(i2.iiv2);
			Outer2.StaticInner i3 = new Outer2.StaticInner();
			System.out.println(i3.siv);
			System.out.println(Outer2.StaticInner.scv);
			
	}

}
