package chap12;
/*
 * 숫자형 문자열 숫자로 변경
 * parseXXX() 메서드
 */
public class WrapperEx3 {
	public static void main(String[] args) {
		int is = Integer.parseInt("123");
		System.out.println(is);
		//123을 8진수로  인식
		is = Integer.parseInt("123",8);
		System.out.println(is);
		is = Integer.parseInt("123",16);
		System.out.println(is);
		float f = Float.parseFloat("123.45");
		System.out.println(f);//123.45
		f= Float.parseFloat("123.45f");
		System.out.println(f);
		double d =Double.parseDouble("123.45");
		System.out.println(d);
		System.out.println(Integer.toBinaryString(500));
		System.out.println(Integer.toOctalString(500));
		System.out.println(Integer.toHexString(500));
		
				
	}

}
