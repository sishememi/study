package chap6;
/*
 * command 라인에서 숫자를 입력받아 숫자의 약수를 출력하기.
 * java Exam7 10
 * string->int 변환 메서드  : int num=Integer.parseInt(args[0]);
 * 10의 약수: 1,2,5,10,
 * */
public class Exam7 {
	public static void main(String[] args) {
		if(args.length==0) {
			System.out.println("커맨드라인에  파라미터를 입력하세요");
			System.out.println("java Exam7 10");
			return;
		}
		
		
		int num=Integer.parseInt(args[0]); //Integer.parseInt(String) 숫자로된 문자열을 int형의 숫자로 변환 함수
		System.out.print(num+"의 약수:");
		for(int i=1;i<=num;i++) {			
			if(num%i==0)
				System.out.print(+i+",");
		}
	}
}
/*여러개 입력
 * for(String a: args) {
		int num=Integer.parseInt(a); //Integer.parseInt(String) 숫자로된 문자열을 int형의 숫자로 변환 함수
		System.out.print(num+"의 약수:");
		for(int i=1;i<=num;i++) {			
			if(num%i==0)
				System.out.print(+i+",");
		}
		System.out.println();
		}*/
 