package chap12;
/*
 * count �޼��� �����ϱ�.
 * int count("���ڿ��ҽ�","ã�� ���ڿ�"): ���ڿ��ҽ����� ã�� ���ڿ��� ������ ����
 */
public class Exam1 {
	public static void main(String[] args) {
		//str1 = "12345AB12AB345AB",str2 = "12"
		System.out.println(count("12345AB12AB345AB","12"));//2. 12�� '2'�� �ִ�.
		System.out.println(count("12345AB12AB345AB","AB"));//3  AB�� '3'�� �ִ�.
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

