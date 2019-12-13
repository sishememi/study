package chap11;
/*
 * throws 예외 처리
 * 
 */
public class ExeptionEx5 {
	public static void main(String[] args) {
		try {
			first();
		}catch(Exception e){
			System.out.println("숫자만 가능합니다.");	
			e.printStackTrace();
		}
	}

	private static void first()  throws Exception{
		System.out.println("first 메서드");
		second();
	}

	private static void second() {
		System.out.println("second 메서드");
		//NumberFormatException 예외 발생
		System.out.println(Integer.parseInt("abc")); 
		}
	
}
