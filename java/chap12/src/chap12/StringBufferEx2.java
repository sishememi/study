package chap12;

public class StringBufferEx2 {
	public static void main(String[] args) {
		StringBuffer sb = new StringBuffer();
		sb.append("abc").append(123).append('A').append(false);
		System.out.println(sb);//abc123Afalse
		sb.delete(2, 4);//2,3번째만 없어짐
		System.out.println(sb);//ab23Afalse
		sb.deleteCharAt(4);
		System.out.println(sb);//ab23false
		sb.insert(5, "==");
		System.out.println(sb);//ab23f==alse
		sb = new StringBuffer("ABCDEFG"); //문자열을 가지고있는 stringbuffer객체를 만듬.
		sb.replace(0, 3, "abc");//0번부터 3개
		System.out.println(sb);//abcDEFG
		sb.reverse();
		System.out.println(sb);//GFEDcba


	}
}
