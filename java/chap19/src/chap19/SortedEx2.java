package chap19;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/*
 * Student 클래스를 Student2 클래스 변경하여 이름순으로 정렬되도록 Student2 클래스 구현하기.
 * Comparable 아무런 내용없이 sorted를 쓰기위해 Comparable로 형변환 후 호출
 */

class Student2 implements Comparable<Student2>{
	private String name;
	private int eng;
	private int math;
	private String major;
	public Student2(String name, int eng, int math, String major) {
		super();
		this.name = name;
		this.eng = eng;
		this.math = math;
		this.major = major;
	}
	public String getName() {	return name;	}
	public int getEng() {	return eng;	}
	public int getMath() {	return math;	}
	public String getMajor() {	return major;	}
	
	@Override
	public String toString() {
		return "[name=" + name + ", eng=" + eng + ", math=" + math + ", major=" + major + "]";
	}
	@Override
	public int compareTo(Student2 o) {
		return name.compareTo(o.name);
	}
	
}
public class SortedEx2 {
	public static void main(String[] args) {
		List<Student2> list = Arrays.asList(
				new Student2("홍길동",90,80,"경영"),
				new Student2("김삿갓",95,85,"컴공"),
				new Student2("이몽룡",80,90,"화공"),
				new Student2("임꺽정",70,60,"경영"));
				list.stream().sorted().forEach(System.out::println);
				System.out.println("영어 점수순으로 정렬하여 출력하기 : 기존 방식");
				list.stream().sorted(new Comparator<Student2>() {
					@Override
					public int compare(Student2 s1 , Student2 s2) {
						return s2.getEng() - s1.getEng();
					}
				}).forEach(System.out::println);
				System.out.println("영어 점수 역순으로 정렬하여 출력하기 : 람다식");
				list.stream().sorted((s1,s2)->s2.getEng()-s1.getEng()).forEach(System.out::println);
				System.out.println("수학 점수 역순으로 정렬하여 출력하기 : 람다식");
				list.stream().sorted((s1,s2)->s2.getMath()-s1.getMath()).forEach(System.out::println);
				System.out.println("총점 수 역순으로 정렬하여 출력하기 : 람다식");
				list.stream().sorted((s1,s2)->(s2.getMath()+s2.getEng())-(s1.getMath()+s1.getEng())).forEach(System.out::println);
	}
}
