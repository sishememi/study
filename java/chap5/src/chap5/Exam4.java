package chap5;

public class Exam4 {

	public static void main(String[] args) {
		int i;
		int j;
		for(i=2;i<=9;i++) {
			System.out.print(i+"´Ü\t");
		}
		for(j=2;j<=9;j++) {			
			System.out.print("\n");			
			for(i=2;i<=9;i++) {	
				System.out.print(i+"*"+j+"="+(i*j)+"\t");
			}
		}
	} 
}


