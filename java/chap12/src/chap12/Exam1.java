package chap12;
/*
 * count 메서드 구현하기.
 * int count("문자열소스","찾는 문자열"): 문자열소스에서 찾는 문자열의 갯수를 리턴
 */
public class Exam1 {
	public static void main(String[] args) {
		//str1 = "12345AB12AB345AB",str2 = "12"
		System.out.println(count("12345AB12AB345AB","12"));//2. 12가 '2'번 있다.
		System.out.println(count("12345AB12AB345AB","AB"));//3  AB가 '3'번 있다.
		System.out.println(count("12345","6"));//0
	
	}
	 static int count(String str1,String str2) {
		 int cnt=0;
		 int idx=0;
		 while(true) {
			 idx = str1.indexOf(str2,idx);
			 if(idx == -1)  break;	 
			 cnt++;
			 idx++;
		}
		 return cnt;
	}
}

