package chap6;
/*
 * command line에서 숫자로 이루어진 문자를 두개 받아서 두수의 공약수를 구하시오. 
 * */
public class Exam8 {
	public static void main(String[] args) {
		if(args.length !=2) { //배열의 값이 두개
			System.out.println("command line에 두개의 파라미터만 입력하세요");
			System.out.println("java Exam8 10 20");
			return ; //main메서드 종료.
		}	
		int num1=Integer.parseInt(args[0]);
		int num2=Integer.parseInt(args[1]);
		int min=(num1>num2)?num2:num1;

		System.out.print("공약수:");
		
		for(int i=1;i<=min;i++) {
			if(num1%i==0 && num2%i==0) {				
				System.out.print(i+",");			
			}
		}
		
	}
}
