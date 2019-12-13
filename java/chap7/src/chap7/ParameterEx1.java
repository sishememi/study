package chap7;
/*
 * 매개변수 예제
 * 기본형 매개변수
 * 참조형 매개변수
 * */
class Value{
	int val;
}
public class ParameterEx1 {
	public static void main(String[] args) {
		Value v = new Value();
		v.val = 100;
		change1(v.val);
		System.out.println("change1() 이후:" + v.val);//100
		change2(v);
		System.out.println("change2() 이후:" + v.val);//200
	}
	static void change1(int val) {  //static 없으면 에러
		val+=100;
		System.out.println("change()1 :" + val);//200
	}//void형 이기때문에  여기서 종료

	static void change2(Value v) {
		v.val+=100;
		System.out.println("change()2 :" + v.val);//200
	}

}
