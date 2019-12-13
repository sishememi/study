package chap12;

public class Exam2 {
	public static void main(String[] args) {
		System.out.println(round(3.1215,1));//3.1
		System.out.println(round(3.1215,2));//3.12
		System.out.println(round(3.1215,3));//3.122
		System.out.println(round(3.1215,4));//3.1215
	}
	

	static double round (double d,int n) {
		return Double.parseDouble(String.format("%."+n+"f",d));	
		}
	
//	static String round (double d,int n) {
//		return String.format("%."+n+"f",d);	
//		}
	
//	static float round (double d,int n) {
//		return Float.parseFloat(String.format("%."+n+"f",d));	
//		}
}
