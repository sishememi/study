package chap6;
/*
 * �迭�� ����: System.arraycopy �޼��带 �̿��ϴ� ���
 * */
public class ArrayEx13 {
	public static void main(String[] args) {
	
		int score1[]= {90,80,70};
		int score2[]=new int[5];
		System.arraycopy(score1, 0,score2, 2,score1.length);
		for(int s: score2) {
			System.out.println(s);
		}
	}
}
