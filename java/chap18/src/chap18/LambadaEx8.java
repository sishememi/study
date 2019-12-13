package chap18;

import java.util.function.Function;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;

/*
 * Function 계열 함수 인터페이스: applyXXX 추상메서드를 멤버로 가진다.
 * 매개변수도 있고, 리턴값도 존재
 */
class Student{
	private String name;
	private int eng;
	private int math;
	private String major;
	public Student(String name, int eng, int math, String major) {
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

	
}
public class LambadaEx8 {
	public static Student[] List= {
		new Student("홍길동",90,80,"경영"),new Student("김삿갓",95,70,"컴공")};
	public static void main(String[] args) {
		System.out.print("학생 이름:");
		printString(t->t.getName()); //t = 매개변수 ,Student 타입이 들어와야함. t.getName()= String값만 들어옴.
		System.out.print("전공 이름:");
		printString(t->t.getMajor());
		System.out.print("영어 점수:");
		printInt(t->t.getEng());
		System.out.print("수학 점수:");
		printInt(t->t.getMath());
		System.out.print("영어 점수 합계:");
		printTot(t->t.getEng());
		System.out.print("수학 점수 합계:");
		printTot(t->t.getMath());
		System.out.print("영어 점수 평균:");
		printAvg(t->t.getEng());
		System.out.print("수학 점수 평균:");
		printAvg(t->t.getMath());
		
	}
	
	private static void printAvg(ToDoubleFunction<Student> f) {
		double sum = 0;
		for(Student s : List) {
			sum+=f.applyAsDouble(s);
		}
		System.out.printf("%.2f\n",sum/List.length);	
		
	}

	private static void printTot(ToIntFunction<Student> f) {
		int sum=0;
		for(Student s : List) {
			sum+=f.applyAsInt(s);
		}
		System.out.println(sum);	
	}
	private static void printInt(ToIntFunction<Student> f) {
		for(Student s : List) {
			System.out.print(f.applyAsInt(s)+",");
		}
		System.out.println();	
	}
	//Function<Student,String>: 매개변수 타입: Student, 리턴타입:String
	private static void printString(Function<Student,String> f){
		for(Student s : List) {
			System.out.print(f.apply(s)+",");
		}
		System.out.println();
	}
	
}
