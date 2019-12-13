package chep4;
import java.util.Scanner;
/*
 * 조건 연산자를 이용하기
 * 점수를 입력받아서 90이상이면 "A학점" 80이상이면 "B학점" 70이상이면 "C학점" 60이상이면 "D학점" 그외는 "F학점" 출력하기
 * */
public class Exam7 {

	public static void main(String[] args) {
		System.out.println("점수를 입력하세요:");
		Scanner scan = new Scanner(System.in);
		int score = scan.nextInt();
		String a;
		if(score>=90) {
			a="A학점입니다.";
		}else if(score>=80) {
			a="B학점입니다.";
		}else if(score>=70) {
			a="C학점입니다.";
		}else if(score>=60) {
			a="D학점입니다.";
		}else  {
			a="F학점입니다.";
		}
		System.out.println(a);
	}
	//= System.out.println(score+"점수는"+((score>=90)?:"a":(score>=80)?"b":(score>=70)?"C":(score>=60)?"d":"f")+"학점입니다");

}
