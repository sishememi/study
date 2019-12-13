package chap12;
/*
 * String 클래스 예제
 * 1. String 클래스는 모든클래스 중 유일하게 대입연산자로 객체 생성이 가능함. + 연산자 사용이 가능함.
 * 다른 클래스의 객체는 new 클래스명() 형태로 객체생성이 됨
 * 2. final 클래스임.
 * 3. + 연산으로 기본형을 String 형으로 형변환 가능
 */
public class StringEx1 {
	public static void main(String[] args) {
		String s1 = "abc"; //대입연산자로 객체 생성
		String s2 = "abc";
		String s3 = new String("abc"); //new 연산자로 객체 생성
		String s4 = new String("abc");
		if(s1==s2)
			System.out.println("s1==s2 : 같은 객체");
		else
			System.out.println("s1!=s2 : 다른 객체");
		if(s1.equals(s2))
			System.out.println("s1.equals(s2) : 같은 내용");
		else
			System.out.println("!s1.equals(s2) : 다른 내용");
		if(s3==s4)
			System.out.println("s3==s4 : 같은 객체");
		else
			System.out.println("s3!=s4 : 다른 객체");
		if(s2.equals(s3))
			System.out.println("s3.equals(s4) : 같은 내용");
		else
			System.out.println("!s3.equals(s4) : 다른 내용");
	}

}
