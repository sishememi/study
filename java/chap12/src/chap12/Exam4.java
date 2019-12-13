package chap12;

public class Exam4 {
	public static void main(String[] args) {
		System.out.println(delChar("(1!2@3^4~5)","~!@#$%^&*()"));//12345
		System.out.println(delChar("(1!2@3^4~5)","12345"));//(!@^~)
	}
	
	static StringBuffer delChar(String a, String b) {
	
		StringBuffer sb = new StringBuffer();
		for(int i=0; i<a.length();i++) {
			char ch = a.charAt(i);
			if( b.indexOf(ch) <0 ) {
				sb.append(ch);
			}	
		}
		return sb;
	}
}	
//		for(int i=1; i<b.length();i+=2) {
//			if()
//		}
//		System.out.println(sb);
		

		

