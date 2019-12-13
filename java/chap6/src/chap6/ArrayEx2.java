package chap6;
/*
 * 배열 선언시 초기화를 하는 예제
 * */
public class ArrayEx2 {
	public static void main(String[] args) {
		//배열의 선언+생성+초기화
		int arr[]= {10,20,30,40,50};
		for(int a:arr) {
			System.out.print(a+",");			
		}
		System.out.println();
		for(int i=0;i<arr.length;i++)	{
			System.out.println("arr["+i+"]="+arr[i]);
		}
		System.out.println();
		//생성+초기화
		arr= new int[]{100,200,300};
		for(int a:arr) {
			System.out.print(a+",");			
		}

	}

}
