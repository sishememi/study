package chap6;
/*
 * 1부터 9까지 숫자중 중복되지 않도록 3자리 숫자를 임의로 생성하는 프로그램 작성하기.
 * 123
 * 982
 */
public class Exam3 {
	public static void main(String[] args) {
		int [] arr = {1,2,3,4,5,6,7,8,9};
		int [] nums = new int[3];
		
	for(int i=0;i<10000;i++) { //1부터 10000번 섞음.
			int f=(int)(Math.random()*9);//3
			int t=(int)(Math.random()*9);//8
			//arr[f] arr[t] 바꾸기.
			int tmp= arr[f];	//tmp:4 라고할때 f=3 3번인덱스값 t=8 8번인덱스값..
			arr[f]=arr[t]; 
			arr[t]=tmp;
	}
	for(int i=0;i<nums.length;i++) {
		nums[i]=arr[i];
	}
	for(int n : nums) {
		System.out.print(n+",");
	}
	}
}
