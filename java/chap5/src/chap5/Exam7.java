package chap5;
/*
 * 1. 1부터 100까지 2의 배수이거나 3의 배수의 합 구하기
 * 2. 1부터 100까지 2의배수도 아니고 3의 배수도 아닌 수의 합 구하기
 * */
public class Exam7 {

	public static void main(String[] args) {
		int i;
		int sum=0;
		int sum2=0;
		for(i=1;i<=100;i++){
			
			if(i%2==0 || i%3==0) {
				//System.out.println(i);
				sum+=i; 
			 } else {
					sum2+=i;
			 }
			 
			//coninue 쓰는방법
			/*
			 * if(i%2==0 || i%3==0) coninue
					sum+=i;
			  if(i%2!=0 || i%3!=0) coninue
					sum2+=i;
			 
			 * */
		}System.out.println("2의 배수이거나 3의 배수의 합:"+sum); 
		System.out.println("2의배수도 아니고 3의 배수도 아닌 수의 합:"+sum2);
	}
	
}
