package chap8;

class Parent{
	int x=10;  //부모클래스를 지우면 에러, super를 찍으면 무조건 부모클래스의 변수를 호출해야하기때무넹.
	Parent(int x){
		this.x = x;
	}
}
class Child2 extends Parent{
	Child2() {  // 부모클래스의 생성자를 호출해서 부모클래스의 객체를 생성해야한다.
		super(100);
	}
	
	int x = 20;
	void method() {
		int x = 30;
		// x: 1.지역변수 => 2. 현재 클래스의 멤버중 x => 3. 부모클래스의 객체의 멤버 중 x
		System.out.println(x);  //30 ,method의 지역변수를 지우고 출력하면 20으로 출력, 지역변수가 없으면 멤버변수로 찾아감
		//1. 현재 클래스의 멤버중 x => 부모클래스의 객체의 멤버 중 x
		System.out.println(this.x);  //20 ,  이 객체에 있는 변수 x값  child 의 멤버변수가 없어지면 부모클래스 변수를 찍는다. 
		//부모클래스의 객체의 멤버중 x
		System.out.println(super.x);  //10 ,부모 클래스의 x 값
	}
}

public class SuperEx1 {
	public static void main(String[] args) {
		Child2 c = new Child2();
		c.method();
	}

}


