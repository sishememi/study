package chap14;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

class Student implements Comparable<Student> {
	String name; //멤버변수
	int kor,eng,math;//멤버변수

	public Student(String name, int kor, int eng, int math) {
		super();
		this.name=name;
		this.kor=kor;
		this.eng=eng;
		this.math=math;
	}
	public int getTotal() {
		return kor + eng + math;
		
	}
	public int compareTo(Student s) {
		return name.compareTo(s.name);
	}
	
	public String toString() {
		return  "이름:"+name +" 국어:" + kor +" 영어:" + eng +" 수학:" 
						+ math +" 총합:"+ getTotal() +" 평균:"+ getTotal()/3.0;
		
//		return String.format("%s:국어(%d),영어(%d),수학(%d),총점(%d),평균(%.2f),",
//									name,kor,eng,math,getTotal(),getTotal()/3.0);
	}
	
}
public class e190924 {
	public static void main(String[] args) {
		List<Student> list = new ArrayList<Student>();
		  list.add(new Student("홍길동",90,80,70));
		  list.add(new Student("김삿갓",95,85,75));
		  list.add(new Student("이몽룡",80,95,95));
		  list.add(new Student("임꺽정",60,75,100));

		  System.out.println("기본정렬방식");
		  TreeSet<Student> set1 = makeTreeSet(list,null);  
		  System.out.println(set1);
		  System.out.println("총점기준 내림차순 정렬");
		  Comparator<Student> c =new Comparator<Student>(){ //이름없는 내부클래스로 객체 생성
			@Override
			public int compare(Student s1, Student s2) {
				
				return (s1.getTotal()-s2.getTotal())*-1; //내림차순 = s2.getTotal()-s2.getTotal()
			}
		  };
		  TreeSet<Student> set2 = makeTreeSet(list,c);
		  System.out.println(set2);
		  System.out.println("국어 점수내림차순 정렬");
		  TreeSet<Student> set3 = makeTreeSet(list,new Comparator<Student>(){//이름없는 내부클래스로 객체 생성
			@Override
			public int compare(Student s1, Student s2) {
			
				return s2.kor-s1.kor;
			}
		  });
		  System.out.println(set3);
		  System.out.println("영어 점수내림차순 정렬");
		  TreeSet<Student> set4 = makeTreeSet(list, new Comparator<Student>() {
			@Override
			public int compare(Student s1, Student s2) {
				return (s1.eng-s2.eng)*-1;
			}
		  });		 
		  System.out.println(set4);
		  System.out.println("수학 점수내림차순 정렬");
		  TreeSet<Student> set5 = makeTreeSet(list, new Comparator<Student>() {
			@Override
			public int compare(Student s1, Student s2) {
				return (s1.math-s2.math)*-1;
			}
		  });
		  System.out.println(set5);
		 }
		 private static TreeSet<Student> makeTreeSet(List<Student> list, Comparator<Student> c) {
			 TreeSet<Student> set = new TreeSet<Student>(c);
			// TreeSet<Student> set = new TreeSet<Student>(list);//기본 정렬방식만 됨.
			 for(Student s : list) {
				 set.add(s);
			 }
				 return set;
		 } 
	}




