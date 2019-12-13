package chap8;
/*
 * super() 생성자: 부모클래스의 생성자 호출시 사용함.
 * */
class Super{ //모든객체는 생성자가 있어야만들어진다.
	int x;
	Super(int x){  
		this.x = x;
	}
}
class Child extends Super{
	int y;
	public Child(){  //기본생성자...
		super(100);
	} 
}
public class SuperEx {
	public static void main(String[] args) {
		Child c = new Child();
		System.out.println(c.x);

	}

}

  