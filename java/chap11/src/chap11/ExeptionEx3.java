package chap11;
/*
 * finally 구문: 정상 실행, 예외실행 모두 실행됨.
 * 				try, catch 구문에서 return문장을 만나도 finally는 실행됨.
 * 				try 구문과 같이 사용됨.
 */
public class ExeptionEx3 {
	public static void main(String[] args) {
		try {
			System.out.print(1);
			System.out.print(2);
			System.out.print(3/0);
//			return; //메서드 종료
		}catch(Exception e) {
			System.out.print(4);
			return;
		}finally {
			System.out.print(5);
		}
		System.out.println(6);
	}
}
