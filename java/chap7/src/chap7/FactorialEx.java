package chap7;
//call stack 영역
//재귀메서드(함수): 자신이 자신메서드를 다시 호출하는 메서드.
//				=> 스택 영역이 존재하므로 가능함.
public class FactorialEx {
	public static void main(String[] args) {
		System.out.println("4!="+factorial(4));
		
	}

	private static int factorial(int i) {
		return  (i==0)?1:i*factorial(i-1);
	}
}
