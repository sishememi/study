package chap5;
/*
 * 중첩 반복문: 반복눈 내부에 반복문이 구현됨.
 * 구구단 출력하기
 * */
public class LoopEx3 {
	public static void main(String[] args) {
		for(int i=2;i<=9;i++) {
			
			for(int j=1;j<=9;j++) {
				System.out.print(i+"*"+j+"="+(i*j));
			}
		}
	}

}
