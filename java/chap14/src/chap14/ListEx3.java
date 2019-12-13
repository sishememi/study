package chap14;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/*
 * 화면에서 숫자를 여러개 입력받고, 그 중에 홀수인 자연수들만 합을 구하고,
 * 홀수 중 최대값 최소값을 출력하기
 * 최대값의 인덱스,최소값의 인덱스를 출력하기
 */
public class ListEx3 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("자연수를 여러개 입력하세요.(종료:0)");
		List<Integer> list = new ArrayList<Integer>();// ArrayList객체의 list를 생성
		int sum = 0;
		while(true) { //홀수
			int num = scan.nextInt();
			if(num%2==1) {
				list.add(num);
				sum+=num;
			}else if(num==0) { //끝내기 위한 0
				break;
				}
			}
		System.out.println("입력된 홀수: "+list);
		for(Integer i : list) { //입력값  개선된for문으로 출력 가능.
			System.out.println(i);
		}
		System.out.println("홀수의 합: "+sum);
		System.out.println("최대값: "+Collections.max(list)+
				",index: "+list.indexOf(Collections.max(list)));
		//Collections.max(list) = 현재리스트중에 현재 가장큰값을 전달, list.indexOf(객체)=값이 있는 인덱스 값(위치)을 전달해줌.
		System.out.println("최소값: "+Collections.min(list)+
				",index: "+list.indexOf(Collections.min(list)));

	}
		
	}

