package chap11;
//���ٸ� �����Ͽ� ������ ���� ���ֱ�.
class MyException1 extends RuntimeException{
	MyException1(String msg){
		super(msg);
	}
}
public class Exam3 {
	public static void main(String[] args) {
		method();
	}
	private static void method()  {
		throw new MyException1("Exam3.method() ���� ���� �߻�");//RuntimeException��������
		
	}
}
