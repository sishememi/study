package chap8;

class Parent3{ //Child 는 내것이 아님
	int x = 10;
	void method() {
		System.out.println("Parent 메서드");
	}
}
class Child3 extends Parent3{
	int x = 20;
	void method() {
		int x = 30;
		System.out.println("Child 메서드");
		System.out.println("x=" +x);
		System.out.println("this.x="+this.x);
		System.out.println("super.x="+super.x);
	}
}
public class BindingEx1 {
	public static void main(String[] args) {
		Parent3 p = new Child3();
		System.out.println(p.x);  //Parent3 의 p Child3에게 객체를 생성..? 부모는 자식에게 접근할수 없으므로 parent에 x멤버가 없으면 x에 접근할 수 없다.
		p.method(); //부모 클래스에서 void가 없어지면 ??? Parent 클래스의 method라는 멤버가 없기떄문에 에러가 난다. 자손 method는 부모method가없으면 접근할 수 없다.
		System.out.println();
		Child3 c = new Child3();
		System.out.println(c.x);
		c.method();
	}
}
