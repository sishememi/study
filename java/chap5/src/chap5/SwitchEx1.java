package chap5;

import java.util.Scanner;
/*
 * switch 구문예제
 * 점수를 입력받아 A~F출력하기
 * 
 * switch(조건값(변수,수식)){
 * 		case1 값1 : 문장1; break;
 * 		case2 값1 : 문장2; break;
 * 			...
 * 		default : 문장;
 * 
 * }
 * 
 * break 문장: break가 속한 switch구문, 반복문을 빠짐.
 * */
public class SwitchEx1 {

	public static void main(String[] args) {
		System.out.println("점수를 입력하세요");
		Scanner scan = new Scanner(System.in);
		int score = scan.nextInt();
		String grade;
		switch(score/10)
		{
			case 10:
			case 9: grade="A";break;
			case 8: grade="B";break;
			case 7: grade="C";break;
			case 6: grade="D";break;
			default:grade="F";break;
		}
		System.out.println(score+"점수는"+grade+"학점입니다.");
	}

}
