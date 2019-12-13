package chap5;
/*
 * 반복문 예제
 * for 
 * 		for(초기값;조건식;증감식) {	...}
 * 		주로  시작과 종료가 지정된 경우, 순차적인 처리
 * while
 * 		while(조건식) {  ...}
 * 		비순차적.
 * 		시작과 종료가 지정되지 않은 경우
 * 			ex) exit문자가 입력될때 까지, 9문자가 입력될때 까지....등
 * do while
 * 		do { 	...}  while(조건식);
 * 		비순차적.
 * 		조건에 상관없이 한번은 문장을 실행 할때.
 * */
public class LoopEx1 {
	public static void main(String[] args) {
		System.out.print(1);
		System.out.print(2);
		System.out.print(3);
		System.out.print(4);
		System.out.println(5);
		System.out.println("for 구문으로 1~5까지 출력하기");
		//i = 5
		for(int i=1;i<=5;i++) {
			System.out.print(i);//12345
		}
		System.out.println();
		
		System.out.println("While 구문으로 1~5까지 출력하기");
		int i=1;
		while(i<=5) {
			System.out.print(i);
			i++;
		}
		System.out.println(); //()에 i 라고 찍으면 6까지 찍힘
		
		System.out.println("do while 구문으로 1~5까지 출력하기");
		i=1;
		do {
			System.out.print(i);
			i++;
		}while(i<=5);
		System.out.println();
	}

}

