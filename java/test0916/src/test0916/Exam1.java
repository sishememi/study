package test0916;


class Animal {
	String name;
	int age;
	public Animal(String name, int age) {
		this.name=name;
		this.age=age;
	}
	@Override
	public String toString() {
		return "이름:" + name + ", 나이:" + age ;
	}
	
}
public class Exam1 {
	public static void main(String[] args) {
		float num=(float) 10.5;
		Animal a=new Animal ("원숭이", 20);
	    System.out.println(a);
	  }
}