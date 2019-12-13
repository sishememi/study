package chap12;

/*
 * Object 클래스
 * equals 메서드 예제 
 * Equal2 클래스에 equals 메서드 오버라이딩하기
 */
class Equal2{
	int value;
	Equal2(int value){	
		this.value = value;	
	}
	@Override
	   public boolean equals(Object o){ //e1와e2의 내용비교해주는 부분.
	      if(o instanceof Equal2) {//o가 Equal2와 다른객체?
	         Equal2 e = (Equal2)o;
	         return value == e.value;
	      }else return false;
	   }
}
public class EqualsEx2 {
	public static void main(String[] args) {
		Equal2 e1 = new Equal2(10);
		 Equal2 e2 = new Equal2(10);
		 if(e1==e2) {
			 System.out.println("e1 과 e2는 같은 객체임");
		 }else {
			 System.out.println("e1 과 e2는 다른 객체임");
		 }
		 if(e1.equals(e2)) {
			 System.out.println("e1과 e2는 같은 내용의 객체임");
		 }else {
			 System.out.println("e1 과 e2는 다른 내용의 객체임");
		 }
		 System.out.println("e1.hashCode()="+e1.hashCode());
		 System.out.println("e2.hashCode()="+e2.hashCode());

		 String s1 = new String("abc");
		 String s2 = new String("abc");
		 
		 if(s1==s2) {
			 System.out.println("s1 과s2는 같은 객체임");
		 }else {
			 System.out.println("s1 과 s2는 다른 객체임");
		 }
		 if(s1.equals(s2)) {//내용부분 비교
			 System.out.println("s1과 s2는 같은 내용의 객체임");
		 }else {
			 System.out.println("s1 과 s2는 다른 내용의 객체임");
		 }
		 System.out.println("e1.hashCode()="+e1.hashCode());
		 System.out.println("e2.hashCode()="+e2.hashCode());
		 System.out.println("s1.hashCode()="+s1.hashCode());
		 System.out.println("s2.hashCode()="+s2.hashCode());
	}

}
