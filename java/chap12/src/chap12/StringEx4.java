package chap12;
/*
 *	String �� ������ ���ڿ� ��.
 */
public class StringEx4 {
	public static void main(String[] args) {
		String str = "ABC123";
		System.out.println("main :"+str);
		str = change(str);
		System.out.println("change ���� main :"+str);
	}
	 static String change(String str) {
		str += "456";
		System.out.println("change() str :" +str);	
		return str;
	}

//	 static void change(String str) {
//		str += "456";
//		System.out.println("change() str :" +str);	
//	}
}
