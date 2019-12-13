package chap7;
/*
 * main 메서드에서 Animal2 클래스의 객체생성이 되도록 생성자를 구현하기
 * */
class Animal2{
	String name;
	int age;
	Animal2(String s, int i){ //생성자 , 인스턴스멤버...
		name = s;
		age = i;
	}
	
	public String toString() {
		return name + ":" + age;
	}
}
public class Exam5 {

	public static void main(String[] args) {
		Animal2 a = new Animal2("원숭이",24);
//		a.name="원숭이";
//		a.age=24;       이렇게 안해도 됨 생성자에서 설정하기때문
		System.out.println(a);
	}

}
