package chap6;

import java.util.Scanner;

/*
 * 숫자맞추기 게임
 * 시스템이 4자리의 서로 다른 수를 저장한 후
 * 사용자가 저장된 수를 맞추는 게임
 * 	자리수도 맞고 숫자존재 할 경우:스트라이크
 * 	자리수는 틀리지만 숫자존재: 볼
 * 4스트라이크 정답.
 * */
public class Exam9 {
	public static void main(String[] args) {
		int numarr[]= { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		//answer: 사용자가 맞춰야할 시스템의 4자리 숫자.
		int answer[]= new int[4];
		//1. 중복되지 않는 4자리수를 생성하기
		for(int i=0;i<1000;i++)
		{	int f=(int)(Math.random()*10); //4 numarr[4]
			int t=(int)(Math.random()*10);//1	numarr[1]
			int temp=numarr[f];  //numarr f에 값을 tmep에
			numarr[f]=numarr[t];//numarr t에 값을 f에
			numarr[t]=temp; //temp에 값을 t에  이런식으로 섞어줌.
		}
		for(int i=0;i<answer.length;i++) 
		{	answer[i]=numarr[i]; //numarr으ㅣ값을 answer로 옮겨줌.
			//System.out.print(answer[i]);
		}
	/*	for(int a:answer)
		{
			System.out.print(a);
		}System.out.println();*/ //컴퓨터에 나오는 숫자 일부러 가려줌
		
		//사용자로부터 정답이 될때까지 4자리 숫자를 입력받기
		Scanner s = new Scanner(System.in);
		int [] data = new int[4];
		while(true) {
			//화면에서 4자리 정수 입력.
			System.out.println("서로다른 4자리 숫자를 입력하세요");
			String input=s.next(); // input= 숫자로 이루어진 문자열
			//"1234" => data[0]=1 data[1]=>2 data[2]=>3 data[3]=>4
			for(int i=0;i<data.length;i++) {
					data[i]=input.charAt(i)-'0';   //data[i]에  input에 받아오는 i번째 첫번째 문자열을(-'0'//아스키) 으로하여 숫자로 가져옴  
				System.out.print(data[i]);
			}System.out.println();
			//스트라이크,볼 결정
			int strike=0;
			int ball=0;
			
			for(int i=0;i<answer.length;i++) {			 
				for(int j=0; j<answer.length;j++) {
					if(answer[i]==data[j]) {
					if(i==j)
					strike++;
					else ball++;
					break;
					}
				}
			}
			
			if(strike==4) {
			System.out.println("정답입니다. 게임을 종료합니다.");
			break;
			}else {
				System.out.println(strike+"스트라이크 "+ball+"볼");
			}
		}		
	}
}

			/*for(int i = 0; i< data.length; i++)
			{            
			if(answer[i]==data[i])      
			strike++;
			else
			{
			for(int j =0; j <data.length; j++)
			{
			if(answer[i]==data[j])
			ball++;
			}
			}
			}*/

