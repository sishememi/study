package chap6;
/*
 * �����迭 ����
 * */
public class ArrayEx11 {
	public static void main(String[] args) {
		int[][] arr = new int [10][];//�ุ ������.
		for(int i=0;i<arr.length;i++) {
			arr[i] = new int[i+1]; //���� �ϳ��� �����ϱ����� , ù���� �� i=0 �̸� 1��¥�� i=1�̸� 2��¥�� �迭,,=>�����迭
		}
		int data=0;
		
		for(int j=9;j>=0;j--) {
			for(int i=j;i<arr.length;i++) {
				arr[i][j] = ++data; //data����
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
