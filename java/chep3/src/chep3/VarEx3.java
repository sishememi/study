package chep3;
/*
 * 특수문자: \
 * 		문자에 의미를 부여하거나, 의미를 가진 문자의 의미 제거
 * */
public class VarEx3 {

	public static void main(String[] args) {
		char single='\'';
		String hkd="Hello\"홍길동\"";
		System.out.println(single);
		System.out.println(hkd);
		String root="c:\\";
	    System.out.println(root);
		
	    System.out.println("서울\t대구\t부산");  //tab 표시로 의미부여.
	    System.out.println("안녕하세요\n이부분은 다음줄에"); //new line 표시.
	    System.out.println("\uD64D\uAE38\uB3D9"); //unicode로 표시
	}

}
