package chep4;
/*
 * ���������� ����2 : ���������ڿ� �ٸ� �����ڸ� ���� ����ϴ� ���*/
public class OpEx2 {

	public static void main(String[] args) {		
		int x=5,y=5;
		y= x++; //1. y=x, y=5, 2. x++: x=6
		System.out.println("x="+x+",y="+y); // x=6,y=5
		y= ++x;//1. ++x: x=7 2.y=x, y=7
		System.out.println("x="+x+",y="+y); //x=7,y=7
		System.out.println("x="+ x++); //1."x=7" ���, 2.x++ x=8;
		System.out.println("x="+ ++x); //1. ++x x=9, 2."x=9" ���
		x= y--; //1.x=y 2. y-- y=6
		System.out.println("x="+x+",y="+y); // x=7,y=6 
		x= --y; //1 --y 2.x
		System.out.println("x="+x+",y="+y); // x=5,y=5
		
	}

}
