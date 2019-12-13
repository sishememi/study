package chap14;

import java.util.HashSet;
import java.util.Set;
/*
 * ��ü�� �ߺ��� ���� �Ǵ��ϴ� ����
 * 1.equals(Object): ����� true
 * 2.hashCode()	   : ����� ����
 * 	=>equals �޼��带 �������̵� �� ���, hashcode() �޼��嵵 �������̵� �ϵ��� ������.
 * 	=>�ΰ��� �޼��尡 Object�� ��� �޼�����. �������̵� �ʿ�
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
		set.add(new Person("ȫ�浿",10));
		set.add(new Person("ȫ�浿",10));
		System.out.println(set);
		
		Person p1 = new Person("���",20);
		Person p2 = p1; //p1�� p2�� ���� ��ü ����
		set.add(p1);
		set.add(p2);
		System.out.println(set);
	
	}
}
