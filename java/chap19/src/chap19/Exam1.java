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
				new Student("ȫ�浿",60,70,"�İ�"),new Student("���",65,55,"�濵"),
				new Student("�̸���",80,75,"ȭ��"),new Student("�Ӳ���",85,65,"�İ�")
				);
		//1.list�� Stream ��ü�� �����Ͽ� ���� ����ϱ�.
//		list.stream().forEach(s->{ System.out.println(s);});//��ü���
//		list.stream().forEach(System.out::println);
		list.stream().forEach(s->{
			System.out.print(s);
			int sum = s.getEng()+s.getMath();
			System.out.printf(",����=%-5d, ���=%-10.2f\n",(s.getEng()+s.getMath()),(s.getEng()+s.getMath())/2.0);
		});
		//2.�������� ����
		int sum = list.stream().mapToInt(Student::getMath).sum();
		System.out.println("���� ���� ����: "+sum);
		System.out.println("���� ���� ����: "+list.stream().mapToInt(Student::getEng).sum());
		System.out.println("���� ���� ���: "+list.stream().mapToInt(Student::getMath).average().getAsDouble());
		System.out.println("���� ���� ���: "+list.stream().mapToInt(Student::getEng).average().getAsDouble());
		
		//3.�İ��� �л��� �ο��� ���
		System.out.println("�İ��л� �ο���: "+list.stream().filter(s->s.getMajor().equals("�İ�")).count());
		//4.�İ��л��� ��� ���
		System.out.println("�İ��л��� ���");
		list.stream().filter(s->s.getMajor().equals("�İ�")).forEach(System.out::println);
		//5.�İ��л��� ���� ����,��������, �������, �������
		System.out.println("�İ� ���� ���� ����:" + list.stream().filter(s->s.getMajor().equals("�İ�")).mapToInt(Student::getMath).sum());
		System.out.println("�İ� ���� ���� ����:" + list.stream().filter(s->s.getMajor().equals("�İ�")).mapToInt(Student::getEng).sum());
		System.out.println("�İ� ���� ���� ���:" + list.stream().filter(s->s.getMajor().equals("�İ�")).mapToInt(Student::getMath).average().getAsDouble());
		System.out.println("�İ� ���� ���� ���:" + list.stream().filter(s->s.getMajor().equals("�İ�")).mapToInt(Student::getEng).average().getAsDouble());
	}
}
