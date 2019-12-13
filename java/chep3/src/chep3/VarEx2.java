package chep3;
/*형변환 예제
 * 	큰자료형 <= 작은자료형: 자동형변환
 * 	작은자료형 <= 큰자료형: 명시적형변환
 *  byte < short < int < long(8) < float(4) < double
 *  	   char = 정수형
 *  A=B : 같다 의 의미가 아니고, 대입의 의미임. B의 값을 A에 입력.
 *  A = lvalue : 대입연산자의 왼쪽 값. 반드시 변수여야함.
 *  B = rvalue : 대입연산자의 오른쪽 값. 변수,리터널,수식 가능
 */

public class VarEx2 {

	public static void main(String[] args) {
		//1. 참조형과 기본형은 형변환 불가
		String s = "a"; //" ":문자열,string(참조형) ' ': 문자,char(기본형),문자형은 한개의 문자만 가능.없어도안댐 'ab' => X
		//s='a';// 참조형인 string 기본형인  char형이 변환 불가.
		
		//2.기본형 사이에 boolean을 제외한 7개는 서로 형변환이 가능하다.
		byte b1 = 100;
		int i1 = (int)b1; // int <= byte 형변환됨. 자동형변환
		byte b2 = (byte)i1;// byte <= byte 형변환됨. 명시적형변환
		System.out.println("b1="+b1+", i1="+i1);
		
		byte b3 = (byte)256;
		System.out.println("b3="+b3);
		
		long l1 = 10;
		float f1 = l1;
		long l2 = (long)f1;
		System.out.println("l2"+l2);
		
		char c1 = 'A';
		short s1 = (short)c1;
		char c2 = (char)b1;
		System.out.println("c2"+c2);

		
		// 큰자료형 = 큰자료형 + 작은자료형
		 // int i2 = (int)l1 + i1; 이것도 맞음
		int i2 = (int)(i1 + l1);
		// String = String + 기본자료형
		System.out.println("번호:"+ 1 + 2 + 3); //결과 = 번호:123  번호:+1=번호1,  번호1+2= 번호12 ,번호12+3=번호123 => 번호6 으로하려면  (1+2+3)으로 우선순위 표시
		System.out.println(1 + 2 + 3+"번");  //결과 = 6번   1+2=3, 3+3=6, 6+번=6번
		
		char c3 = 'A'; //아스키 코드값 65 문자형
	    int i3 = c3; //숫자형 c3을 숫자로인식해서 아스키코드 출력
	    System.out.println("c3="+c3+",i3="+i3); //c3=A,i3=65
	    System.out.println("c3="+c3+",i3="+(char)i3); //c3=A,i3=A
	    
	    //int보다 작은 자료형의 연산의 결과는 int
	     byte b4;
	     byte b5=1;
	     byte b6=2;
	     b4 = (byte)(b5+b6);
	     
	     //or
	     
	     /*int b4;
	     byte b5=1;
	     byte b6=2;
	     b4 = (byte)(b5+b6);*/
	     	
	    //3.잘못된 문장을 고쳐서 에러가 발생하지 않도록 수정하시오.
	     byte var1= 127;
	     short var2=128;
	     int var3=128;
	     long var4 =128L;
	     var4=var1;
	     var1=(byte)var3;
	     float var5= 1.0f;
	     double var6= 1.0;
	     var5=(float)var6;
	     var6=var5;
	     
	     			
	} 
}
