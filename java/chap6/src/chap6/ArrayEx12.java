package chap6;
/*
 * �迭��  ����: for������ �̿��Ͽ� �迭 �����ϱ�.
 * 
 * �ѹ� ������ �迭 ��ü�� ũ�� ������ �ȵ� => collection �� List ��ü�� ���� ����.
 * */
public class ArrayEx12 {

	public static void main(String[] args) {
		int score1[]= {90,80,70};
		//score1.length=5; //error. �迭�� ũ�� �����̾ȵ�.
		int score2[]=new int[5];
		for(int i=0; i<score1.length;i++) {
			score2[i]=score1[i];
		}
		for(int s:score2) {
			System.out.println(s);
		}
	}
}
