package chap11;

public class ExeptionEx7 {
	public static void main(String[] args)  {
		try {
			badmethod();
		} catch (Exception e) {
			System.out.println("main���� ���� ó��");
			e.printStackTrace();
		}
	}

	private static void badmethod() throws Exception {
		try {
		throw new Exception("���� ���� �߻�"); //���� �߻�
		}catch(Exception e) {
			System.out.println("badmethod���� ���� ó��");
			e.printStackTrace();
			throw e; //���� ��߻�
		}
	}
}
