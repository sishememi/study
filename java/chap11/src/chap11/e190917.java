package chap11;

import java.util.InputMismatchException;
import java.util.Scanner;
/*
 * 1.������ ���� ����.
 * 2.�ݺ������� �����͸� �Է¹ޱ�.
 * 3.�Է�Ƚ�� ����
 */
public class e190917 {
	 public static void main(String[] args) throws Exception {
		 int cnum=(int)(Math.random()*100)+1;
		 int count=0;
		 Scanner scan = new Scanner(System.in);
		
//		 while(true) {
//			 try {
//				 System.out.println("1~100������ ���ڸ� �Է��ϼ���");
//				  int num = scan.nextInt();
//				  if(num<1 || num>100) {
//					count++;				  
//				  throw new Exception("1 �� 100 ������ ���ڸ� �Է��ϼ���");
//				  }else if(cnum>num) {
//					  System.out.println("�Է��� ���ں��� Ů�ϴ�.");
//						 count++;
//					 }else if(cnum<num) {
//					  System.out.println("�Է��� ���ں��� �۽��ϴ�.");
//					  count++;
//				  }else if(cnum==num) {
//					  count++;
//					  System.out.println("�����Է� Ƚ��:"+count);
//					  System.out.println("����");
//				  }
//			 }catch(InputMismatchException e) {
//				 count++;
//				 System.out.println("���ڸ� �Է��ϼ���");
//				 scan = new Scanner(System.in);
//				 continue;
//			 }catch(Exception e) {
//				 System.out.println(e.getMessage());
//				 
//			 }			 		 
//		 } 
//		  
		 int num=0;
		 System.out.println("1~100������ ���ڸ� �Է��ϼ���");
		 while(true) {
			 try {
				num = scan.nextInt();
				count++;
				 if(num<1 || num>100) 			  
				 throw new Exception("1 �� 100 ������ ���ڸ� �Է��ϼ���");
				 }catch(InputMismatchException e) {
					 String d = scan.next();
					 count++;
					 System.out.println(d+"�߸��Է��߽��ϴ�. ���ڸ� �Է��ϼ���");
					 scan = new Scanner(System.in);
					 continue;
				 }catch(Exception e) {
				  System.out.println(e.getMessage());
					 continue; 
				 }
			 if(cnum==num) break;
			 else if(cnum>num) {
				  System.out.println("�Է��� ���ں��� Ů�ϴ�.");
					 
				 }else if(cnum<num) {
				  System.out.println("�Է��� ���ں��� �۽��ϴ�.");	  
				 }
			 	//count++;	 
			  }
		 System.out.println("�����Դϴ�.");
		 System.out.println("�Է�Ƚ��:"+count);
			 
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
//		return new Alpha(); //Beta �������̽��� ������ ����Ŭ������ ��ü
// }
// public static void main(String[] args) {
//	Beta b = getIt();
//  	Alpha a = (Alpha)b;
//  	System.out.println(a.testIt());
//  	//3.System.out.println(b.testIt());
// }
//}

