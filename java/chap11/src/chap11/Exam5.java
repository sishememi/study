package chap11;
class MyException2 extends Exception{}
class MyException3 extends MyException2{}

public class Exam5 {
	public static void main(String[] args) {
		try {
			throw new MyException3(); //MyException3 ����
			
		}catch(MyException2 e) {
			System.out.println("MyException2 ���� ó��");
			
		}catch(Exception e) {
			System.out.println("Exception ����ó��");
		}
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {//Thread ����ó��			
		}
	}

}
