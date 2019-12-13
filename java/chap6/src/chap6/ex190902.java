package chap6;

import java.util.Scanner;

public class ex190902 {

	public static void main(String[] args) {
		   //a,b,c ... z
		  char[] abcCode = 
		   { '`', '~', '!', '@', '#', '$', '%', '^', '&', '*','(', ')', '-', '_', '+', '=', '|', '[', ']', '{', '}', ';', ':', ',', '.', '/'};
		  // 0 1 2 3 4 5 6 7 8 9
		  char[] numCode = { 'q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p' };
		  System.out.println("소문자영 숫자로 이루어진 문자열을 입력하세요");
		  Scanner scan = new Scanner(System.in);
		  String src = scan.next();
		  String result = "";
		  
		 
		 for(int i=0; i<src.length();i++) {
			 char p= (char)src.charAt(i);
			 if('a'<=p && p<='z') {

				 result+=abcCode[p-'a'];			
			 }if('0'<=p && p<='9') {

				 result+=numCode[p-'0'];
		     }
		 }		 	  
		 System.out.println("src:" + src);
		 System.out.println("result:" + result);
	}
}

/*char[][] star = { 
{ '*', '*', ' ', ' ', ' ' },
{ '*', '*', ' ', ' ', ' ' },
{ '*', '*', '*', '*', '*' },
{ '*', '*', '*', '*', '*' } };
char [][] star2 = new char [star[0].length][star.length];

for(int i=0;i<star.length;i++) {
for(int j=0;j<star[i].length;j++) {
	star2[j][star.length-1-i]=star[i][j];
}
System.out.println();
}

for(int i=0;i<star2.length;i++) {
for(int j=0;j<star2[i].length;j++) {
	 System.out.print(star2[i][j]);
}
System.out.println();
}*/
