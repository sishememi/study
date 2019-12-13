package chap14;

import java.util.HashSet;
import java.util.Set;
/*
 * Student 클래스 구현하기
 * 1.멤버변수: 학번(studno),이름(name),전공(major)
 * 2.멤버메서드:toString() 오버라이딩
 * 3.학번과 이름이 같으면 같은 학생으로 인식하도록 오버라이딩하기
 * 4.구동 클래스에 맞도록 생성자 구현하기.
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
		set.add(new Student1("1234","홍길동","경영"));
		set.add(new Student1("2345","홍길순","경영"));
		set.add(new Student1("2345","홍길순","컴공")); //추가 불가,이름과 학번이같은사람ㅇ ㅣ이미 등록되어있음.
		set.add(new Student1("1234","홍길동","통계")); //추가 불가.
		set.add(new Student1("4567","홍길동","경영")); //추가 가능. 이름은 같지만 학번은 다르기때문에 등록 가능.
		System.out.println("등록학생 수: " +set.size());
		System.out.println(set);
	}
}
