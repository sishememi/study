package chap8;
/*
 * super() ������: �θ�Ŭ������ ������ ȣ��� �����.
 * */
class Super{ //��簴ü�� �����ڰ� �־�߸��������.
	int x;
	Super(int x){  
		this.x = x;
	}
}
class Child extends Super{
	int y;
	public Child(){  //�⺻������...
		super(100);
	} 
}
public class SuperEx {
	public static void main(String[] args) {
		Child c = new Child();
		System.out.println(c.x);

	}

}

  