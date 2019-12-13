package chap19;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

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
	
	@Override
	public String toString() {
		return "[name=" + name + ", eng=" + eng + ", math=" + math + ", major=" + major + "]";
	}
	
}
public class Exam1 {
	public static void main(String[] args) {
		List<Student> list = Arrays.asList(
				new Student("홍길동",60,70,"컴공"),new Student("김삿갓",65,55,"경영"),
				new Student("이몽룡",80,75,"화공"),new Student("임꺽정",85,65,"컴공")
				);
		//1.list를 Stream 객체로 변경하여 내용 출력하기.
//		list.stream().forEach(s->{ System.out.println(s);});//전체목록
//		list.stream().forEach(System.out::println);
		list.stream().forEach(s->{
			System.out.print(s);
			int sum = s.getEng()+s.getMath();
			System.out.printf(",총점=%-5d, 평균=%-10.2f\n",(s.getEng()+s.getMath()),(s.getEng()+s.getMath())/2.0);
		});
		//2.수학점수 총점
		int sum = list.stream().mapToInt(Student::getMath).sum();
		System.out.println("수학 점수 총점: "+sum);
		System.out.println("영어 점수 총점: "+list.stream().mapToInt(Student::getEng).sum());
		System.out.println("수학 점수 평균: "+list.stream().mapToInt(Student::getMath).average().getAsDouble());
		System.out.println("영어 점수 평균: "+list.stream().mapToInt(Student::getEng).average().getAsDouble());
		
		//3.컴공과 학생의 인원수 출력
		System.out.println("컴공학생 인원수: "+list.stream().filter(s->s.getMajor().equals("컴공")).count());
		//4.컴공학생의 목록 출력
		System.out.println("컴공학생의 목록");
		list.stream().filter(s->s.getMajor().equals("컴공")).forEach(System.out::println);
		//5.컴공학생의 수학 총점,영어총점, 수학평균, 영어평균
		System.out.println("컴공 수학 점수 총점:" + list.stream().filter(s->s.getMajor().equals("컴공")).mapToInt(Student::getMath).sum());
		System.out.println("컴공 영어 점수 총점:" + list.stream().filter(s->s.getMajor().equals("컴공")).mapToInt(Student::getEng).sum());
		System.out.println("컴공 수학 점수 평균:" + list.stream().filter(s->s.getMajor().equals("컴공")).mapToInt(Student::getMath).average().getAsDouble());
		System.out.println("컴공 영어 점수 평균:" + list.stream().filter(s->s.getMajor().equals("컴공")).mapToInt(Student::getEng).average().getAsDouble());
	}
}
