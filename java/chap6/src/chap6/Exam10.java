package chap6;
/*
 * 5명 학생의 국어 영어 수학 점수를 학생별로 총점과 평균을 출력하고
 * 과목별 총점과 평균을 출력하기.
 * [결과]
 * 		     국어    영어    수학    총점   평균
 * 1번학생: 100  80   90  270	90.0..
 * 2번학생:  80  95  100  275 90.0..
 * ...
 * 과목총점: 400 350 430
 * */
public class Exam10 {
	public static void main(String[] args) {
		int[][]score= { {100,80,90},{80,100,95},{60,65,70},{85,70,75},{90,80,90}};
		int []total=new int[3];
		//int sum=0;
			System.out.println("\t국어\t영어\t수학\t총점\t평균"); 
			for(int i=0;i<score.length;i++) {
				System.out.print(i+1+"번학생:\t"); //0번지+1 = 1번학생
				int sum=0;				
				for(int j=0;j<score[i].length;j++) {
					System.out.print(score[i][j]+"\t");  //score[i][j]=score[0][0]=100
					 sum+=score[i][j];//학생별 합계 sum+=score[0][0]=100
					 total[j]+=score[i][j];//과목별 합계
		
			}
				System.out.println(sum+"\t"+(double)sum/score[i].length);
		}
			System.out.print("과목총점:\t");
			for(int i=0;i<total.length;i++)
			{
				System.out.print(total[i]+"\t");
			}
			System.out.println();
			System.out.print("과목평균:\t");
			for(int i=0;i<total.length;i++)
			{
				System.out.print((double)total[i]/score.length+"\t");
			}
	}
}

