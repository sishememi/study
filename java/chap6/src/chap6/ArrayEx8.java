package chap6;
/*
 * 2차원 배열의 초기화
 * */
public class ArrayEx8 {
	public static void main(String[] args) {
		int[][]arr= {{10,20},{30,40},{50,60,70}};//{10,20} 1차원배열1,{30,40} 1차원배열2,{50,60,70} 1차원배열3  
		for(int i=0; i<arr.length;i++) { //arr.length = 3       베열전체?,,
			for(int j=0; j<arr[i].length;j++) { //arr1.length=2 arr2.length=2 arr3.length=3
				System.out.print("arr["+i+"]["+j+"]="+arr[i][j]+"\t");
			}
			System.out.println();
		}
	}

}
