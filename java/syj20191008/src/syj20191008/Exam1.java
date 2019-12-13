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
	   String name;  //이름
	   private String work;  //업무
	   private String position; //직급
	   private int age;     //나이
	   
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
		return "직원명=" + name + ", 업무=" + work + ", 직급=" + position + ", 나이=" + age ;
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
	System.out.println("========직원 목록 보기(이름순)=========");
	list.stream().sorted(new Comparator<SYJEmp>() 
    {
		@Override
        public int compare(SYJEmp o1, SYJEmp o2) 
        {
           int result = o1.name.compareTo(o2.name);
           return result;
        }
    }).forEach(System.out::println);
	System.out.println("=========직원 목록 보기(나이순)==========");
	list.stream().sorted(new Comparator<SYJEmp>() 
    {
		@Override
        public int compare(SYJEmp o1, SYJEmp o2) 
        {
           int result = o1.getAge() - o2.getAge();
           return result;
        }
     }).forEach(System.out::println);
	System.out.print("직급이 과장인 직원의 평균 나이 :");

	double avg = list.stream().filter(s -> s.getPosition().equals("과장")).mapToInt(SYJEmp::getAge).average().getAsDouble();
	System.out.println(avg);
	}

}