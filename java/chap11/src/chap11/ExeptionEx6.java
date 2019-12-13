package chap11;
/*
 * throws : 예외처리: 발생된 예외를 제거하기
 * throw : 예외발생: 없는 예외를 강제 발생.
 */
public class ExeptionEx6 {
	public static void main(String[] args) {
		try {
			
			throw new Exception("예외 강제 발생");
		}catch(Exception e) {
			e.printStackTrace();
		}

	}	
}
