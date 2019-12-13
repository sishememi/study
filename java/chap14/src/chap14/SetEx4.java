package chap14;


import java.util.Comparator;
import java.util.TreeSet;

/*
 * ClassCastException: 객체와 참조변수간의 에러
 * Comparable:이름으로만 정렬
 * Comparator: 다른걸로 정렬가능
 * 
 * 정리
 * 정렬 관련 인터페이스
 * Comparable 인터페이스: 추상메서드 compareTo(Object)
 * 					      클래스의 기본 정렬 방식 지정
 * Comparator 인터페이스: 추상메서드 compare(Object o1, Object o2)
 * 					      기본정렬 방식 대로 정렬하지 않고 사용자가 임의로 정렬 방식을 지정
 */
class Phone implements Comparable<Phone>
{
   String name;
   int number;
   public Phone(String name, int number) {
      super();
      this.name = name;
      this.number = number;
   }
   public String toString()
   {
      return "(" + name + "," + number + ")";
   }
@Override
	public int compareTo(Phone p) {//compareTo가  Comparable에 존재하는 메서드
	return name.compareTo(p.name);
	}
}
public class SetEx4 {

   public static void main(String[] args) {
	   	System.out.println("이름순으로 출력");
	   	TreeSet<Phone> set = new TreeSet<>();
	   	  set.add(new Phone("홍길동",1234));
	      set.add(new Phone("김삿갓",3456));
	      set.add(new Phone("이몽룡",5678));
	      System.out.println(set);
	      
	      System.out.println("전화번호 순으로 출력");
	   set = new TreeSet<>(new Comparator<Phone>() 
      {//TreeSet 객체를 모으기위해 Comparable 인터페이스를 구현해야한다..
         @Override
         public int compare(Phone p1, Phone p2) 
         //Comparator 변수기 때문에  compareTo 없음.
         {
            return p1.number-p2.number;
         }
      }); // 이름없는 외부 클래스 방법
//      TreeSet<Phone> set = new TreeSet<>(); 
      set.add(new Phone("홍길동",1234));
      set.add(new Phone("김삿갓",3456));
      set.add(new Phone("이몽룡",5678));
      System.out.println(set);
      
      System.out.println("이름의 역순으로 출력");
      set = new TreeSet<>(Comparator.reverseOrder()); //Comparator.reverseOrder()순서를 뒤집어서 출력   
      set.add(new Phone("홍길동",1234));
      set.add(new Phone("김삿갓",3456));
      set.add(new Phone("이몽룡",5678));
      System.out.println(set);
      
      System.out.println("전화번호의 역순으로 출력");
      set = new TreeSet<>(new Comparator<Phone>(){
    	  @Override
    	  public int compare(Phone p1,Phone p2) {
    		  return p2.number-p1.number; //(p1.number-p2.number) * -1
    	  }
      }); //Comparator.reverseOrder()순서를 뒤집어서 출력   
      set.add(new Phone("홍길동",1234));
      set.add(new Phone("김삿갓",3456));
      set.add(new Phone("이몽룡",5678));
      System.out.println(set);
   }

}