package chap6;
/*
 * Math.random() 함수를 이용하여 1부터 10까지의 임의의 수를 배열에 10개 저장하기
 * 배열에 저장된 수 만큼 * 를 출력하기 
 * 0 <= Math.random() <1.0
 * arr={3,5,2,1..}
 * 3:***
 * 5:*****
 * 2:**
 * ...
 */
public class Exam2 {
	public static void main(String[] args) {
		
		int [] arr = new int[10]; //10개의 배열 기본값은 자동으로 0으로 초기화 됨
		
		for(int i=0;i<arr.length;i++) {		//arr.length의 값은 10개.
			arr[i]=(int)(Math.random()*10)+1;
			}
		
		for(int i=0; i<arr.length;i++) {
			System.out.print(arr[i]+":");			
			for(int j=0; j<arr[i];j++) {
			System.out.print("*");
			}
			System.out.println();
		}
		
		/*
		 * for(int a : arr) {
			System.out.print(a+":");			
			for(int i=0; i<a[i];i++) {
			System.out.print("*");
			}
			System.out.println();
		}*/
	}
}
