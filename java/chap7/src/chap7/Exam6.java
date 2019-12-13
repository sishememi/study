package chap7;
/*
 * Rectangle3 클래스 구현하기
 * 멤버변수: width,height,serialNo,sno(원의 번호를 생성하기위한 static 변수)
 * 생성자: 가로와 세로를 입력받고, 가로,세로값을 초기화함.
 * 멤버메서드:
 * 		int area():넓이 값리턴
 * 		int length(): 둘레값 리턴
 * 		boolean isSquare():정사각형 여부 리턴
 * 	    void info():
 * 			"1번 사각형:(10,10,) 넓이:100, 둘레:40, 정사각형" 문자열을 출력하기 
 * 			"2번 사각형:(20,10,) 넓이:200, 둘레:60, 직사각형" 문자열을 출력하기 
*/
class Rectangle3{
	int width,height,serialNo;
	static int sno;
	
	int area() {
		return width*height;
		}
	
	int length() {
		return (width+height)*2;
		}
	
	Rectangle3(int w, int h){
		width=w;  //내가 입력한 값(w)으로 할당 
		height=h;
		serialNo= ++sno;
	}
	void info() {
		System.out.println(serialNo+"번 사각형: ("+width+","+height+") 넓이:"+area()+", 둘레:"+length()+","+(isSquare()?"정사각형":"직사각형"));
	}
	
	boolean isSquare() {  //true나 false값만 받을 수 있음.
//		if(width==height) { 
//			System.out.print("정사각형");
//			}else {
//				System.out.print("직사각형");
//			}
		return width==height;  //가로와 세로가 같으면 true 아니면 false 를  삼항연산자? 조건연산자?로  기입하면댐..
			
	}
}
public class Exam6 {
	public static void main(String[] args) {
		Rectangle3[] recarr = new Rectangle3[3];
		recarr[0] = new Rectangle3(10,10);
		recarr[1] = new Rectangle3(20,10);
		recarr[2] = new Rectangle3(25,25);
		
		for(Rectangle3 r: recarr) {
			//r.serialNo = ++Rectangle3.sno; 여기에 안하고 생성자에 넣어도됨.
			r.info();
		}
	}

}
