package chap6;

import java.util.Arrays;

/*
 * 로또번호 추첨기
 * */
public class ArrayEx3 {

	public static void main(String[] args) {
		int [] balls = new int[45];
		int [] lotto= new int[6];
		
		for(int i=0; i<balls.length;i++) {
			balls[i]=i+1;
		}
		//balls 섞기
		for(int i=0;i<1000;i++) {
			int f=(int)(Math.random()*45);
			int t=(int)(Math.random()*45);
			int tmp=balls[f];
			balls[f]=balls[t];
			balls[t]=tmp;
		}
		//6개의 번호선택
		for(int i=0;i<lotto.length;i++) {
			lotto[i]=balls[i];
		}
		//정렬하기
		/*Arrays.sort(lotto);*/
		for(int i=0;i<lotto.length;i++) {
			boolean change = false;
			for(int j=0;j<lotto.length-1-i;j++) { //j<lotto.length-1-i이라고 쓰는이유 lotto[j+1]가 제일 마지막까지 돌아가야하기때문에 -1기입.
				if(lotto[j]>lotto[j+1]) {
					int tmp = lotto[j];
					lotto[j] = lotto[j+1];
					lotto[j+1] = tmp;
				}
			}
			if(!change) break; //성능을위해서 중간에 멈추기위한값. 
		}
		//선택 번호 출력
		for(int b:lotto) {
			System.out.print(b+",");
		}
	}
}
