package chap7;
/*
 * 지역변수: 메서드 내부에서 선언된 변수.
 * 		      반드시 초기화 되어야한다ㅣ.
 * 		      매개변수는 지역변수다
 * */
public class LocalValEx {
	public static void main(String[] args) {
		//args 지역변수
		int num;//지역변수
		boolean b=true;//지역변수. main메서 내부에 선언되었기때문
		if(b)
		{
			num=100;
		}else
		{
			num=200;
		}
		System.out.println(num);
		String grade; //초기화되지않은상태
		int score=80;//지역변수
		switch(score/10) {
		case 9: grade ="A";break;
		case 8: grade ="B";break;
		case 7: grade ="C";break;
		case 6: grade ="D";break;
		default : grade = "F";
		}
		System.out.println("학점:"+grade); //default : grade = "F"; 가 있으면 grade값이 초기화가 됨. 
											//하지만 default가 없으면 초기화가 안된 가능성이있는상태.
	}
}
