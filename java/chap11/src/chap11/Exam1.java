package chap11;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Exam1 {
	public static void main(String[] args) {
		//화면에서 1부터 10까지의 숫자를 입력받아서 숫자만큼  * 가로로 출력하기
		//단 99숫자가 입력될때까지 계속 입력받기		
		
		Scanner scan = new Scanner(System.in);
		while(true) {
			System.out.println("1부터 10까지 중 숫자를 입력하세요(종료:99)");
			//입력값이 숫자가 아닌경우 : InputMismatchException 발생될 경우
			//		숫자만 입력하세요 메세지를 출력하고, 다시 입력받도록 프로그램 수정.		
			try {
				int num = scan.nextInt();
				if(num==99){
					System.out.println("프로그램 종료"); break;}
				if(num < 1 || num > 10) {
//					System.out.println("1부터10까지 숫자만 처리하세요");
//					continue;
					throw new Exception("1부터 10까지의 숫자만 입력하세요.");
				}
				
				System.out.print(num+":");
				for(int i=0;i<num;i++) {
					System.out.print("*");
				}
				System.out.println();				
				}catch (InputMismatchException e){
					//System.out.println("숫자만 입력하세요.");
					//scan= new Scanner(System.in);
					String str = scan.next();
					System.out.println(str+"은 숫자가아닙니다.숫자만 입력하세요.");
					continue; //제외해도됨.
				}catch(Exception e) {
					System.out.println(e.getMessage());
				}
		}		
	}
}

