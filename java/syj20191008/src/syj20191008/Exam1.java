package syj20191008;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;



class SYJEmp{
	   String name;  //�̸�
	   private String work;  //����
	   private String position; //����
	   private int age;     //����
	   
	   public SYJEmp(String name, String work, String position, int age) {
		super();
		this.name = name;
		this.work = work;
		this.position = position;
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public String getWork() {
		return work;
	}
	public String getPosition() {
		return position;
	}
	public int getAge() {
		return age;
	}
	@Override
	public String toString() {
		return "������=" + name + ", ����=" + work + ", ����=" + position + ", ����=" + age ;
	}

	   
}
public class Exam1 {
	public static void main(String[] args) throws IOException {
	BufferedReader br = new BufferedReader(new FileReader("emp.txt"));
	List<SYJEmp> list = br.lines().map(s -> 
	{
		 String[] str = s.split(",");
	     return new SYJEmp(str[0],str[1],str[2]
	    		 ,Integer.parseInt(str[3]));
	}).collect(Collectors.toList());
	System.out.println("========���� ��� ����(�̸���)=========");
	list.stream().sorted(new Comparator<SYJEmp>() 
    {
		@Override
        public int compare(SYJEmp o1, SYJEmp o2) 
        {
           int result = o1.name.compareTo(o2.name);
           return result;
        }
    }).forEach(System.out::println);
	System.out.println("=========���� ��� ����(���̼�)==========");
	list.stream().sorted(new Comparator<SYJEmp>() 
    {
		@Override
        public int compare(SYJEmp o1, SYJEmp o2) 
        {
           int result = o1.getAge() - o2.getAge();
           return result;
        }
     }).forEach(System.out::println);
	System.out.print("������ ������ ������ ��� ���� :");

	double avg = list.stream().filter(s -> s.getPosition().equals("����")).mapToInt(SYJEmp::getAge).average().getAsDouble();
	System.out.println(avg);
	}

}