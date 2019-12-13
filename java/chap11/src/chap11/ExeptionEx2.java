package chap11;

import java.text.NumberFormat;

/*
 * 다중 catch 구문예제
 */
public class ExeptionEx2 {

	public static void main(String[] args) {
		try {
			//ArithmeticExeption 예외 발생
			System.out.println(args[0]); //홍길동
			//NumberFormatExeption 예외발생
			System.out.println(Integer.parseInt(args[0]));
			System.out.println(10/Integer.parseInt(args[0]));
			String str = null;
			System.out.println(str.charAt(0));//NullPointerException, charAt 실제 실행을했을때 예외인걸 알 수 있다.
		}catch(ArithmeticException e){
			System.out.println("0으로 나누지 마세요.");
		}catch(ArrayIndexOutOfBoundsException e){
			System.out.println("command 라인에 파라미터를 입력하세요.");
		}catch(NumberFormatException e) {
			System.out.println("command 라인에 숫자를 입력하세요");
		}catch(NullPointerException e) {
			System.out.println("null");
		}catch(RuntimeException e) {
			System.out.println("1.오류발생: 전산부로 전화요망");
			e.printStackTrace();//에러발생시 보여지지않을때 화면에 출력.
		}catch(Exception e) {
			System.out.println("2.오류발생: 전산부로 전화요망");
		}
		
	}
}







