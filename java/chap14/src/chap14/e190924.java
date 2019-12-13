package chap14;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

class Student implements Comparable<Student> {
	String name; //�������
	int kor,eng,math;//�������

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
		return  "�̸�:"+name +" ����:" + kor +" ����:" + eng +" ����:" 
						+ math +" ����:"+ getTotal() +" ���:"+ getTotal()/3.0;
		
//		return String.format("%s:����(%d),����(%d),����(%d),����(%d),���(%.2f),",
//									name,kor,eng,math,getTotal(),getTotal()/3.0);
	}
	
}
public class e190924 {
	public static void main(String[] args) {
		List<Student> list = new ArrayList<Student>();
		  list.add(new Student("ȫ�浿",90,80,70));
		  list.add(new Student("���",95,85,75));
		  list.add(new Student("�̸���",80,95,95));
		  list.add(new Student("�Ӳ���",60,75,100));

		  System.out.println("�⺻���Ĺ��");
		  TreeSet<Student> set1 = makeTreeSet(list,null);  
		  System.out.println(set1);
		  System.out.println("�������� �������� ����");
		  Comparator<Student> c =new Comparator<Student>(){ //�̸����� ����Ŭ������ ��ü ����
			@Override
			public int compare(Student s1, Student s2) {
				
				return (s1.getTotal()-s2.getTotal())*-1; //�������� = s2.getTotal()-s2.getTotal()
			}
		  };
		  TreeSet<Student> set2 = makeTreeSet(list,c);
		  System.out.println(set2);
		  System.out.println("���� ������������ ����");
		  TreeSet<Student> set3 = makeTreeSet(list,new Comparator<Student>(){//�̸����� ����Ŭ������ ��ü ����
			@Override
			public int compare(Student s1, Student s2) {
			
				return s2.kor-s1.kor;
			}
		  });
		  System.out.println(set3);
		  System.out.println("���� ������������ ����");
		  TreeSet<Student> set4 = makeTreeSet(list, new Comparator<Student>() {
			@Override
			public int compare(Student s1, Student s2) {
				return (s1.eng-s2.eng)*-1;
			}
		  });		 
		  System.out.println(set4);
		  System.out.println("���� ������������ ����");
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
			// TreeSet<Student> set = new TreeSet<Student>(list);//�⺻ ���Ĺ�ĸ� ��.
			 for(Student s : list) {
				 set.add(s);
			 }
				 return set;
		 } 
	}




