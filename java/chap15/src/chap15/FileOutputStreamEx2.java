package chap15;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

/*
 * FileOutputStream �� �̿��Ͽ� error �α� ���� �����ϱ�.
 */
public class FileOutputStreamEx2 {
	public static void main(String[] args) {
		firstMethod();
	}
	private static void firstMethod() {
		secondMethod();
	}
	private static void secondMethod() {
		try {
			throw new Exception("���Ͽ� ���� �޼��� �����ϱ�");
		} catch(Exception e) {
			e.printStackTrace();//ǥ�ؿ�����ü�� �޼��� ���.
			try {
				/*
				 *("error.log",true)
				 * "error.log": ������ ������ �̸�, ������ ������ ����. ������ ������ ���� ����.
				 * true/false : true : ������ �ִ� ��� ������ ���뿡 ���ο� ������ �߰�.
				 * 				false : ������ �ִ� ��� ������ ������ ���ο� �������� ����.
				 */
				FileOutputStream fos = new FileOutputStream("error.log",true);
				fos.write(e.getMessage().getBytes()); //e.getMessage()�� ���ڿ���  Byte�� �迭�� ������ 
				e.printStackTrace(new PrintStream(fos)); //error.log ���Ͽ�  e.printStackTrace() ������ ���
				fos.write("====================\n\n".getBytes());
			} catch(IOException e1) {
				e1.printStackTrace();
			}
		}
	}
}
