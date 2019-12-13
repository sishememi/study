package chap14;

import java.util.HashSet;
import java.util.Set;
/*
 * 객체의 중복을 논리적 판단하는 기준
 * 1.equals(Object): 결과가 true
 * 2.hashCode()	   : 결과가 동일
 * 	=>equals 메서드를 오버라이딩 할 경우, hashcode() 메서드도 오버라이딩 하도록 권장함.
 * 	=>두개의 메서드가 Object의 멤버 메서드임. 오버라이딩 필요
 */
class Person{
	String name;
	int age;
	public Person(String name,int age) {
		this.name=name;
		this.age=age;
	}
	
	@Override
	public int hashCode() {
		return name.hashCode()+age;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Person) {
			Person p = (Person)obj;
			return name.equals(p.name) && age ==p.age;
		}else return false;
	}

	public String toString() {
		return "("+name+","+age+")";
	}
	
}
public class SetEx2 {
	public static void main(String[] args) {
		Set<Object> set = new HashSet<Object>();
		set.add(new String("abc"));
		set.add(new String("abc"));
		set.add(new Person("홍길동",10));
		set.add(new Person("홍길동",10));
		System.out.println(set);
		
		Person p1 = new Person("김삿갓",20);
		Person p2 = p1; //p1과 p2가 같은 객체 참조
		set.add(p1);
		set.add(p2);
		System.out.println(set);
	
	}
}
