package chap6;
/*
 * 2���� �迭�� �ʱ�ȭ
 * */
public class ArrayEx8 {
	public static void main(String[] args) {
		int[][]arr= {{10,20},{30,40},{50,60,70}};//{10,20} 1�����迭1,{30,40} 1�����迭2,{50,60,70} 1�����迭3  
		for(int i=0; i<arr.length;i++) { //arr.length = 3       ������ü?,,
			for(int j=0; j<arr[i].length;j++) { //arr1.length=2 arr2.length=2 arr3.length=3
				System.out.print("arr["+i+"]["+j+"]="+arr[i][j]+"\t");
			}
			System.out.println();
		}
	}

}
