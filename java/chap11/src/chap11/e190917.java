package chap11;

import java.util.InputMismatchException;
import java.util.Scanner;
/*
 * 1.임의의 수를 저장.
 * 2.반복문으로 데이터를 입력받기.
 * 3.입력횟수 증가
 */
public class e190917 {
	 public static void main(String[] args) throws Exception {
		 int cnum=(int)(Math.random()*100)+1;
		 int count=0;
		 Scanner scan = new Scanner(System.in);
		
//		 while(true) {
//			 try {
//				 System.out.println("1~100사이의 숫자를 입력하세요");
//				  int num = scan.nextInt();
//				  if(num<1 || num>100) {
//					count++;				  
//				  throw new Exception("1 과 100 사이의 숫자만 입력하세요");
//				  }else if(cnum>num) {
//					  System.out.println("입력한 숫자보다 큽니다.");
//						 count++;
//					 }else if(cnum<num) {
//					  System.out.println("입력한 숫자보다 작습니다.");
//					  count++;
//				  }else if(cnum==num) {
//					  count++;
//					  System.out.println("정답입력 횟수:"+count);
//					  System.out.println("정답");
//				  }
//			 }catch(InputMismatchException e) {
//				 count++;
//				 System.out.println("숫자만 입력하세요");
//				 scan = new Scanner(System.in);
//				 continue;
//			 }catch(Exception e) {
//				 System.out.println(e.getMessage());
//				 
//			 }			 		 
//		 } 
//		  
		 int num=0;
		 System.out.println("1~100사이의 숫자를 입력하세요");
		 while(true) {
			 try {
				num = scan.nextInt();
				count++;
				 if(num<1 || num>100) 			  
				 throw new Exception("1 과 100 사이의 숫자만 입력하세요");
				 }catch(InputMismatchException e) {
					 String d = scan.next();
					 count++;
					 System.out.println(d+"잘못입력했습니다. 숫자만 입력하세요");
					 scan = new Scanner(System.in);
					 continue;
				 }catch(Exception e) {
				  System.out.println(e.getMessage());
					 continue; 
				 }
			 if(cnum==num) break;
			 else if(cnum>num) {
				  System.out.println("입력한 숫자보다 큽니다.");
					 
				 }else if(cnum<num) {
				  System.out.println("입력한 숫자보다 작습니다.");	  
				 }
			 	//count++;	 
			  }
		 System.out.println("정답입니다.");
		 System.out.println("입력횟수:"+count);
			 
		 } 
		 
	 }


//interface Beta {//3.String testIt()}
//class Alpha implements Beta {
//	String testIt() {//3.public String testIt()
//		return "Tested";
//	}
//}
//public class e190917 {
//	static Beta getIt() {
//		return new Alpha(); //Beta 인터페이스를 구현한 구현클래스의 객체
// }
// public static void main(String[] args) {
//	Beta b = getIt();
//  	Alpha a = (Alpha)b;
//  	System.out.println(a.testIt());
//  	//3.System.out.println(b.testIt());
// }
//}

