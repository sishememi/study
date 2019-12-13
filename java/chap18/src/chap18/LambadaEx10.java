package chap18;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/*
 * Predicate 인터페이스 :
 * 매개변수 있고 리턴값은 boolean인 함수 test 메서드를 가지고 있음
 */
public class LambadaEx10 {
   private static List<Student> list = Arrays.asList
   (
      new Student("홍길동", 50, 60, "컴공"),
      new Student("이몽룡", 95, 90, "경영"),
      new Student("김삿갓", 75, 80, "심리"),
      new Student("임꺽정", 65, 70, "전자"),
      new Student("성춘향", 65, 0, "컴공")
   );
   public static void main(String[] args) 
   {
      System.out.println("영어 점수가 60점 이상인 학생의 영어 평균: " + avg1(t->t.getEng() >=60));
      System.out.println("수학 점수가 60점 이상인 학생의 영어 평균: " + avg2(t->t.getMath() >=60));
      System.out.println("컴공과 학생의 영어 평균: "+ avgEng(t->t.getMajor().equals("컴공")));
      System.out.print("컴공과 학생의 이름: ");
      //nameList();
      nameList(t->t.getMajor().equals("컴공"));
      System.out.println();
      System.out.print("컴공과가 아닌 학생의 영어 평균: " +avgEng(t->!t.getMajor().equals("컴공")));
      System.out.println();
      System.out.print("컴공과 아닌 학생의 이름: ");
      nameList(t->!t.getMajor().equals("컴공"));
  }


//private static void nameList() {
//	   for(Student s : list) {
//		   if(s.getMajor().equals("컴공")) {
//			   System.out.print(s.getName()+",");
//		   }
//	   }
//}

private static void nameList(Predicate<Student> pr) {
	for(Student s : list) {
		 if(pr.test(s)) //전공이 컴공인 경우 true
         {
            System.out.print(s.getName()+",");
         }
	  }
}
private static double avgEng(Predicate<Student> pr) {
	   int count = 0, sum =0;
	      for(Student s : list)
	      {
	         if(pr.test(s))
	         {
	            count++;
	            sum += s.getEng();
	         }
	      }
	return (double)sum/count;
}

private static double avg1(Predicate<Student> pr) 
   {
      int count = 0, sum =0;
      for(Student s : list)
      {
         if(pr.test(s)) //t.getEng() >=60 인 경우 true
         {
            count++;
            sum += s.getEng();
         }
      }
      return (double)sum/count;
   }
   private static double avg2(Predicate<Student> pr) 
   {
      int count = 0, sum =0;
      for(Student s : list)
      {
         if(pr.test(s))
         {
            count++;
            sum += s.getMath();
         }
      }
      return (double)sum/count;
   }
}