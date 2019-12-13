package chap12;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*
 * Scanner를 이용하여 File로 정보 읽기
 */
public class ScannerEx2 {
	public static void main(String[] args) throws FileNotFoundException{
		//File : 파일의 정보를 저장하는 클래스.
		Scanner scan = new Scanner(new File("score.txt"));
		int cnt = 0;
		int totalSum = 0;
		while(scan.hasNextLine()) { //다음 줄이 존재?
			String line = scan.nextLine();//홍길동,4.5,3.8,4.2
			Scanner scan2 = new Scanner(line).useDelimiter(","); //문자열 형태로 읽어냄.
			double sum = 0;
			int i = 0;
			String name = scan2.next(); //name = "홍길동 "
			System.out.print(name+":");
			while(scan2.hasNextDouble()) {//double 형태 존재?
				double score = scan2.nextDouble();
				sum += score;
				System.out.print(score+",");
				i++;
			}
			System.out.println(" sum = "+sum+" ,avg ="+((int)(sum/i*100))/100.0);
			totalSum+=sum;
			cnt++;
		}
		System.out.println("인원수"+cnt);

	}
}
