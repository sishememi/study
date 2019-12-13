	package chap6;
/*
 * 배열 예제1
 * */
public class Array1 {
	public static void main(String[] args) {
		//1. 배열 참조 변수 선언
		int [] arr1; //1차원 배열을 객체를 참조하는 참조변수의 선언
		int arr2 [];
		
		//2. 배열 객체 생성
		arr1=new int[5]; //int형 저장공간을 5 개 생성 기본값(0) new 메모리할당해주는 기능.그래서 기본값으로 초기화가 자동으로될수있음
		arr2=new int[5]; 
		//3. 배열값을 초기화
		arr1[0]=10;
		arr1[1]=20;
		arr1[2]=30;
		arr2=arr1; //arr2에 값이 들어가는거ㅔ 아니고 arr1를 참조한다.
		arr2[4]=50; // arr1[4]=50 arr2[4]=50
		//4.배열 출력
		System.out.println("arr1 출력:");
		for(int i=0;i<arr1.length;i++)
		{
			System.out.println("arr1["+i+"]="+arr1[i]);
		}
		
		System.out.println("arr2 출력:");
		for(int i=0;i<arr2.length;i++) {
			System.out.println("arr2["+i+"]="+arr1[i]);
		}
		System.out.println("개선된 for 구문을 이용");
		//개선된 for 구문
		for(int a: arr1) {
			System.out.println(a);
		}
	}
}
