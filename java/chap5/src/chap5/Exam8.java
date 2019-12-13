package chap5;

public class Exam8 {
	public static void main(String[] args) {	
		int sum=0;
		for(int i=1;i<=10;i++) {			
			System.out.print("(");			
			for(int j=1;j<=i;j++) {					
				sum=+j;
				System.out.print(j+((i!=j)?"+":""));
			}
			System.out.println(")"+((i==10)?"=":"+"));		
		}
		System.out.println(sum); 
	}
}
