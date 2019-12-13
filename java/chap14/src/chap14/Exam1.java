package chap14;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/*
 * 화면에서 홀수개의 숫자를 입력받아서 숫자의 평균과 중간값을 출력하기.
 * 
 * 10 40 30 60 30 
 * 
 * 중간값=> 10,30,30,40,60  정렬 후 중간에 있는값
 * 평균값:...
 * 중간값:30
 */
public class Exam1 {
	public static void main(String[] args) {
		System.out.println("숫자 홀수개를 입력하세요 ");
		int sum=0;
		List<Integer> list = new ArrayList<Integer>();
		Scanner scan = new Scanner(System.in);
		while(true) {
			int num = scan.nextInt();
			list.add(num);
			if(list.size()%2==1) {
				System.out.println("숫자 입력을 끝내겠습니까?(y/n)");
				String  yn = scan.next();
				if(yn.equalsIgnoreCase("y")) break;
			}
		}
		System.out.println(list);
		
		for(int i=0;i<list.size();i++) {
			sum += list.get(i);
		}
		System.out.println("숫자의 총합: "+sum);
		System.out.println("평균값: "+sum/list.size());
		
		Collections.sort(list);
		System.out.println(list);
		System.out.println("중간값: "+list.get(list.size()/2));
	}

}
