package chap7;
/*
 * �Ű����� ����
 * �⺻�� �Ű�����
 * ������ �Ű�����
 * */
class Value{
	int val;
}
public class ParameterEx1 {
	public static void main(String[] args) {
		Value v = new Value();
		v.val = 100;
		change1(v.val);
		System.out.println("change1() ����:" + v.val);//100
		change2(v);
		System.out.println("change2() ����:" + v.val);//200
	}
	static void change1(int val) {  //static ������ ����
		val+=100;
		System.out.println("change()1 :" + val);//200
	}//void�� �̱⶧����  ���⼭ ����

	static void change2(Value v) {
		v.val+=100;
		System.out.println("change()2 :" + v.val);//200
	}

}
