package chap6;
/*
 * 2���� �迭�� ���� �հ� ���� �� ���ϱ�
 * [���]
 * 0������:
 * 1������:
 * 2������:
 * 0������:
 * 1������:
 * 2������:
 * 
 * */
public class Exam11 {
	public static void main(String[] args) {
		int [][]arr = {{10,20},{30,40,50},{60,70,80,90}};
		int[] sum = new int[3]; //arr�� ���ǰ��� =int arr[arr.length]
		int[] sum1= new int[4]; //���� �ִ�
		
		/**�Ϲ�ȭ.
		 * int [][]arr = {{10,20},{30,40,50},{60,70,80,90}};
		int[] sum = new int[arr.length]; //arr�� ���ǰ��� =int arr[3]
		int maxcol=0;
		for(int i=0; i<arr.length;i++) {
			if(maxcol<arr[i].length) {
				maxcol<arr[i].length
			}
		}
		int[] sum1= new int[maxcol]; //���� �ִ�*/
		
		for(int i=0; i<arr.length;i++) {
			
			for(int j=0; j<arr[i].length;j++) {
				
					sum[i] += arr[i][j];
					sum1[j] += arr[i][j];
			
			}System.out.println(i+"���� ��:"+sum[i]);
			
		}	
		
			for(int i=0; i<sum1.length;i++) {
			
				System.out.println(i+"���� ��:"+sum1[i]);
			
			}
			
		}	
	}

