package chap6;
/*
 * 2차원 배열보다 가로,세로가 1씩 더큰 배열 result를 생성하여,
 * 마지막 행과 열에 합계를 저장하는 프로그램을 구현하기.
 * */
public class Exam15 {
	//@SuppressWarnings("null")
	public static void main(String[] args) {
		int [][] score= {
				{90,80,70},
				{95,85,75},
				{70,80,75},
				{75,70,85},
				{70,75,80}
		};
		
	
		int [][] result = new int[score.length+1][score[0].length+1] ;
		
		
		for(int i=0;i<score.length;i++) {
			for(int j=0;j<score[i].length;j++){
				result[i][j]+=score[i][j]; //score의 값들을 result에 넣어줌
				result[i][score[i].length]+=score[i][j];//행을 더함 마지막의 열에 해당하는..score[i].length
				result[score.length][j]+=score[i][j]; //열을 더함.
				result[score.length][score[i].length]+=score[i][j]; //행 열의 총합
			}
		}
		
		
		for(int i=0;i<result.length;i++) {
			for(int j=0; j<result[i].length;j++) {
				
				System.out.printf("%5d",result[i][j]);				
			}
		
					
			System.out.println();
		}

	}
}
