package chap6;
/*
 * Math.random() �Լ��� �̿��Ͽ� 1���� 10������ ������ ���� �迭�� 10�� �����ϱ�
 * �迭�� ����� �� ��ŭ * �� ����ϱ� 
 * 0 <= Math.random() <1.0
 * arr={3,5,2,1..}
 * 3:***
 * 5:*****
 * 2:**
 * ...
 */
public class Exam2 {
	public static void main(String[] args) {
		
		int [] arr = new int[10]; //10���� �迭 �⺻���� �ڵ����� 0���� �ʱ�ȭ ��
		
		for(int i=0;i<arr.length;i++) {		//arr.length�� ���� 10��.
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
