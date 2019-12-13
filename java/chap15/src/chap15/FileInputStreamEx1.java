package chap15;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

/*
 * FileInputStream : ���Ϸ� ���� �����͸� �б�
 * 	int read() : 1byte��  �о ����.
 * 	int read(byte[] buf) : buf�� ũ�⸸ŭ �о �����͸� buf�� ����. ������ ���� byte�� ����.
 * 	int read(byte[] buf, int start, int len) :
 * 					�����͸� len����Ʈ ��ŭ �о buf�� start �ε��� ���� ����.
 * 					���� ���� ����Ʈ �� ����.
 */
public class FileInputStreamEx1 {
	public static void main(String[] args) throws IOException{
		FileInputStream fis = new FileInputStream("src/chap15/InputStreamEx1.java");
		System.out.println("***********read() �޼��带 �̿��Ͽ� �б�");
		int data =0;
		while((data = fis.read()) != -1) {
			System.out.print((char)data);
		}
		System.out.println("***********read(byte [] buf) �޼��带 �̿��Ͽ� �б�");
		fis = new FileInputStream("src/chap15/InputStreamEx1.java"); //String�� �ѹ��� ���� �� �־ ���⼭ �ٽ� ����.
		byte [] buf = new byte[fis.available()];
		//fis.available() : �б� ���� ����Ʈ �� ����
		while((data = fis.read(buf)) != -1) {
			//buf�� 0�� �ε��� ���� data ���� ��ŭ�� ���ڿ� ����
			System.out.print(new String(buf,0,data));
		}
		
		System.out.println("***********int read(byte[] buf, int start, int len) �޼��带 �̿��Ͽ� �б�");
		fis = new FileInputStream("src/chap15/InputStreamEx1.java");
		buf = new byte[fis.available()];
		//fis.available() : �б� ���� ����Ʈ �� ����
		while((data = fis.read(buf , 0 ,buf.length)) != -1) {
			System.out.print(new String(buf,0,data));
		}
	}
}
