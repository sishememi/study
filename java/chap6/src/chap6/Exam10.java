package chap6;
/*
 * 5�� �л��� ���� ���� ���� ������ �л����� ������ ����� ����ϰ�
 * ���� ������ ����� ����ϱ�.
 * [���]
 * 		     ����    ����    ����    ����   ���
 * 1���л�: 100  80   90  270	90.0..
 * 2���л�:  80  95  100  275 90.0..
 * ...
 * ��������: 400 350 430
 * */
public class Exam10 {
	public static void main(String[] args) {
		int[][]score= { {100,80,90},{80,100,95},{60,65,70},{85,70,75},{90,80,90}};
		int []total=new int[3];
		//int sum=0;
			System.out.println("\t����\t����\t����\t����\t���"); 
			for(int i=0;i<score.length;i++) {
				System.out.print(i+1+"���л�:\t"); //0����+1 = 1���л�
				int sum=0;				
				for(int j=0;j<score[i].length;j++) {
					System.out.print(score[i][j]+"\t");  //score[i][j]=score[0][0]=100
					 sum+=score[i][j];//�л��� �հ� sum+=score[0][0]=100
					 total[j]+=score[i][j];//���� �հ�
		
			}
				System.out.println(sum+"\t"+(double)sum/score[i].length);
		}
			System.out.print("��������:\t");
			for(int i=0;i<total.length;i++)
			{
				System.out.print(total[i]+"\t");
			}
			System.out.println();
			System.out.print("�������:\t");
			for(int i=0;i<total.length;i++)
			{
				System.out.print((double)total[i]/score.length+"\t");
			}
	}
}

