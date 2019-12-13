package chap6;
/*
 * 가변배열 예제
 * */
public class ArrayEx11 {
	public static void main(String[] args) {
		int[][] arr = new int [10][];//행만 결정함.
		for(int i=0;i<arr.length;i++) {
			arr[i] = new int[i+1]; //열을 하나씩 결정하기위함 , 첫번재 열 i=0 이면 1개짜리 i=1이면 2개짜리 배열,,=>가변배열
		}
		int data=0;
		
		for(int j=9;j>=0;j--) {
			for(int i=j;i<arr.length;i++) {
				arr[i][j] = ++data; //data증가
			}
		}
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[i].length;j++) {
				System.out.printf("%4d",arr[i][j]);
			}
			System.out.println();
		}
	}
	
}
