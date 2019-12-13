package chap12;
/*
 * Object 클래스
 * equals 메서드 예제 : 내용비교시 사용되는 메서드  => 오버라이딩 필요
 * 
 * =>같은 객체인지 여부는 == 로 구분이 가능함.
 * =>같은 내용인지 여부는 equals 메서드를 오버라이딩
 * 
 */
class Equal{
	int value;
	Equal(int value){
		this.value = value;
	}
}
public class EqualsEx1 {
	public static void main(String[] args) {
		 Equal e1 = new Equal(10);
		 Equal e2 = new Equal(10);
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
	}

}
