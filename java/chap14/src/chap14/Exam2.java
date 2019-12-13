package chap14;

import java.util.HashSet;
import java.util.Set;
/*
 * Student Ŭ���� �����ϱ�
 * 1.�������: �й�(studno),�̸�(name),����(major)
 * 2.����޼���:toString() �������̵�
 * 3.�й��� �̸��� ������ ���� �л����� �ν��ϵ��� �������̵��ϱ�
 * 4.���� Ŭ������ �µ��� ������ �����ϱ�.
 */
class Student1{
	String studno;
	String name;
	String major;
	Student1(String studno,String name,String major){
		this.studno=studno;
		this.name=name;
		this.major=major;
	}
	@Override
	public int hashCode() {
		return studno.hashCode()+name.hashCode();
	}
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Student1) {
			Student1 st = (Student1)obj;
			return name.equals(st.name) && studno.equals(st.studno);
		}else return false;
	}
	
	public String toString() {
		return "("+studno+","+name+","+major+")";
	}
}
public class Exam2 {
	public static void main(String[] args) {
		Set<Student1> set = new HashSet<Student1>();
		set.add(new Student1("1234","ȫ�浿","�濵"));
		set.add(new Student1("2345","ȫ���","�濵"));
		set.add(new Student1("2345","ȫ���","�İ�")); //�߰� �Ұ�,�̸��� �й��̰�������� ���̹� ��ϵǾ�����.
		set.add(new Student1("1234","ȫ�浿","���")); //�߰� �Ұ�.
		set.add(new Student1("4567","ȫ�浿","�濵")); //�߰� ����. �̸��� ������ �й��� �ٸ��⶧���� ��� ����.
		System.out.println("����л� ��: " +set.size());
		System.out.println(set);
	}
}
