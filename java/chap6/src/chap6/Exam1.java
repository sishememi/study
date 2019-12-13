package chap6;

import java.util.Scanner;

/*
 * 화면에서 5개의 정수를 입력받아서 점수의 합계,평균,최대점수,최소점수 출력하기.
 * 입력받은 점수는 score 배열에 저장하기.
 * */
public class Exam1 {
	public static void main(String[] args) {
		
		System.out.println("5개의 정수를 입력하세요");
		Scanner s = new Scanner(System.in);
		int[] score = new int[5];
		
		for(int i=0; i<score.length; i++) {
		score[i] = s.nextInt();
		}
		
		int sum=0 ,max=0 ,min=0;
		for(int i=0;i<score.length;i++){
			sum+=score[i];
			if(max < score[i]) max=score[i];
			if(i==0 || min > score[i]) min =score[i]; //i==0로 초기화. min이 최솟값이어야하고, min이 0이면 min이 더 클수가 없다 무조건 0으로 나옴
		}System.out.println("합계:"+sum+" 평균:"+(double)sum/score.length+" 최대점수:"+max+" 최소점수:"+min);

	}
}
