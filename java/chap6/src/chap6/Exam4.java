package chap6;
/*
 * 1부터 100까지 임의의 수 10개를 배열에 저장하고, 정렬하여 출력하기 
 * 단 Arrays.sort() 메서드는 사용하지 않기.
 * 
 * 버블정렬!!!! 
 * 
 * */
public class Exam4 {
	public static void main(String[] args) {
		int [] arr = new int[10];
		for(int i=0;i<arr.length;i++){
				arr[i]=(int)(Math.random()*100);
			}
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr.length-1-i;j++){
				if(arr[j] > arr[j+1]) {
					int tmp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = tmp;
				}
			}
		}
		for(int a:arr)
		System.out.print(a+",");
	}	
}
