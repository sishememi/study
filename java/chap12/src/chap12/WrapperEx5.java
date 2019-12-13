package chap12;
/*
 * switch 구문에서 조건값으로 사용할 수 있는 자료형
 * = 9개
 * byte,short,int,char,String
 * Byte,Short,Integer,Character //wrapper class
 */
public class WrapperEx5 {
	public static void main(String[] args) {
		Integer data = 65;
		switch(data) {
		case 1 : System.out.println("성공");break;
		default : System.out.println("실패");break;
		}

	}

}
