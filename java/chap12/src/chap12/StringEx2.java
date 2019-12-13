package chap12;
/*
 * String 클래스의 주요 메서드
 */
public class StringEx2 {
	public static void main(String[] args) {
		String s = new String("ABCDEFGH");
		System.out.println(s.charAt(4));//E,5번째 문자 리턴
		//정렬관련 메서드."ABCDEFGH" - "abc": 65 - 97 = -32
		System.out.println(s.compareTo("abc"));//-32
		//IgnoreCase:대소문자 구분없이
		System.out.println(s.compareToIgnoreCase("abcdefgh"));//0 
		//concat():문자열 연결함수 s+"abc"
		System.out.println(s.concat("abc"));//ABCDEFGHabc
		System.out.println(s+"abc");//ABCDEFGHabc
		//endsWith: s문자열의 끝이 "GH"?
		System.out.println(s.endsWith("GH"));//true
		//startsWith: s문자열의 시작이 "AB"?
		System.out.println(s.startsWith("AB"));//true
		//equalsIgnoreCase: s의 내용이 대소문자 상관없이 같니?
		System.out.println(s.equalsIgnoreCase("abcdefgh"));//true
		System.out.println(s.equals("abcdefgh"));//false
		
		s = new String("This is a String");
		//indexOf: 문자나 문자열의 위치 리턴
		System.out.println(s.indexOf('i')); //2
		//indexOf: 5번인덱스포함 이후에 문자나 문자열의 위치 리턴.
		System.out.println(s.indexOf('i',5));
		//indexOf: 15번인덱스포함 이후에 문자나 문자열의 위치 리턴.
		System.out.println(s.indexOf('i',15));//-1. 15번 인텍스 이후 문자 없음.해당위치 찾을수 없음
		System.out.println(s.indexOf("is"));//2
		System.out.println(s.indexOf("is",3));//5
		//lastIndexOf: 뒤쪽부터 검색하여 문자나 문자열의 위치 리턴, 앞쪽 인덱스부터읽은 번호
		System.out.println(s.lastIndexOf("is"));//5
		System.out.println(s.length());//16. 문자열 길이 
		//replace : 치환  is => QR문자열로 치환.
		System.out.println(s.replace("is","QR"));
		//substring: 부분 문자열 리턴
		//5번 인덱스 이후를 부분문자열로 리턴
		System.out.println(s.substring(5));		
		//5번 인덱스부터 13번 인덱스 앞까지를 부분문자열로 리턴 (5 ~ 12 인덱스)
		//5번은 인덱스 번호 13은 글 몇번째인가 번호임.
		System.out.println(s.substring(5,13));	
		System.out.println(s.toLowerCase());//소문자
		System.out.println(s.toUpperCase());//대문자
		//trim() : 양쪽 공백 제거.
		System.out.println("    문자열  trim 메서드                 ".trim());

	
	}
}

