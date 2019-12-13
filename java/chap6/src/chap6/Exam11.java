package chap6;
/*
 * 2차원 배열의 행의 합과 열의 합 구하기
 * [결과]
 * 0행의합:
 * 1행의합:
 * 2행의합:
 * 0열의합:
 * 1열의합:
 * 2열의합:
 * 
 * */
public class Exam11 {
	public static void main(String[] args) {
		int [][]arr = {{10,20},{30,40,50},{60,70,80,90}};
		int[] sum = new int[3]; //arr의 행의갯수 =int arr[arr.length]
		int[] sum1= new int[4]; //열의 최댓값
		
		/**일반화.
		 * int [][]arr = {{10,20},{30,40,50},{60,70,80,90}};
		int[] sum = new int[arr.length]; //arr의 행의갯수 =int arr[3]
		int maxcol=0;
		for(int i=0; i<arr.length;i++) {
			if(maxcol<arr[i].length) {
				maxcol<arr[i].length
			}
		}
		int[] sum1= new int[maxcol]; //열의 최댓값*/
		
		for(int i=0; i<arr.length;i++) {
			
			for(int j=0; j<arr[i].length;j++) {
				
					sum[i] += arr[i][j];
					sum1[j] += arr[i][j];
			
			}System.out.println(i+"행의 합:"+sum[i]);
			
		}	
		
			for(int i=0; i<sum1.length;i++) {
			
				System.out.println(i+"열의 합:"+sum1[i]);
			
			}
			
		}	
	}

