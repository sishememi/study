package chap5;
/*
 * 1. 1���� 100���� 2�� ����̰ų� 3�� ����� �� ���ϱ�
 * 2. 1���� 100���� 2�ǹ���� �ƴϰ� 3�� ����� �ƴ� ���� �� ���ϱ�
 * */
public class Exam7 {

	public static void main(String[] args) {
		int i;
		int sum=0;
		int sum2=0;
		for(i=1;i<=100;i++){
			
			if(i%2==0 || i%3==0) {
				//System.out.println(i);
				sum+=i; 
			 } else {
					sum2+=i;
			 }
			 
			//coninue ���¹��
			/*
			 * if(i%2==0 || i%3==0) coninue
					sum+=i;
			  if(i%2!=0 || i%3!=0) coninue
					sum2+=i;
			 
			 * */
		}System.out.println("2�� ����̰ų� 3�� ����� ��:"+sum); 
		System.out.println("2�ǹ���� �ƴϰ� 3�� ����� �ƴ� ���� ��:"+sum2);
	}
	
}
