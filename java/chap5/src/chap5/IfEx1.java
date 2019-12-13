package chap5;

import java.util.Scanner;
/*
 * if 구문 예제
 * 
 * 	if(조건식){
 * 		문장1....: => 조건식의 결과가 참인 경우 실행되는 문장
 * }else {
 * 		문장2 : => 조건식1의 결과가 거짓인 경우 실행 되는 문장
 * }
 * 
 * 	if(조건식1){
 * 		문장1....: => 조건식의 결과가 참인 경우 실행되는 문장
 * }else if(조건식2){
 * 		문장2 : => 조건식1의 결과가 거짓이고 조건식2가 참인 경우 실행 되는 문장
 * }else if(조건식3){
 * 		문장3 : => 조건식1, 조건식2 결과가 거짓이고, 조건식3의 결과가 참인 경우 실행 되는 문장
 *}...
 *}else{
 *		문장=> 모든 if 구문의 결과가 거짓인 경우 실행되는 문장.
 *}
 * */
public class IfEx1 {

	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		System.out.println("점수를입력하세요");
		int score=scan.nextInt();
		if(score>=60) {
			System.out.println("합격을축하합니다.");
		}else {
			System.out.println("불합격입니다..");
		}
		//90이상이면 "A학점" 80이상이면 "B학점" 70이상이면 "C학점" 60이상이면 "D학점" 그외는 "F학점" 출력하기
		if(score>=90)
		{
			System.out.println("A학점입니다.");
		}else if(score>=80)
		{
			System.out.println("B학점입니다.");
		}else if(score>=70) {
			System.out.println("C학점입니다.");
		}else if(score>=60) {
			System.out.println("D학점입니다.");
		}else {
			System.out.println("F학점입니다.");
			}
		}
	}//main 종료. 프로그램 종료
	

