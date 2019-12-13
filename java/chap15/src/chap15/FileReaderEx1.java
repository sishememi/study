package chap15;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/*
 * FileReader ���� : FileReader Ŭ������ ������ 1char ������ �д� ���.
 * 	int read() : ������ 1char ������ �о� ����
 * 	int read(char [] buf) : buf�� ũ�⸸ŭ �����͸� �о buf�� �����͸� ����. ������ ���� ����Ʈ�� ����.
 * 	int read(char[] buf, int start, int len) :
 * 			�����͸� len ���� ��ŭ �о buf�� start �ε��� ���� ����.
 * 			���� ���� ���� �� ����.
 */
public class FileReaderEx1 {
	public static void main(String[] args) throws IOException {
		FileReader fis = new FileReader("src/chap15/InputStreamEx1.java");
		System.out.println("***********read() �޼��带 �̿��Ͽ� �б�");
		int data =0;
		while((data = fis.read()) != -1) {
			System.out.print((char)data);
		}
		
		fis = new FileReader("src/chap15/InputStreamEx1.java");
		System.out.println("***********read(char [] buf) �޼��带 �̿��Ͽ� �б�");
		char [] buf = new char[1024];
		while((data = fis.read(buf)) != -1) {
			System.out.print(new String(buf,0,data));
		}
		
		fis = new FileReader("src/chap15/InputStreamEx1.java");
		System.out.println("***********read(char[] buf, int start, int len) �޼��带 �̿��Ͽ� �б�");
		buf = new char[1024];
		while((data = fis.read(buf,0,buf.length)) != -1) {
			System.out.print(new String(buf,0,data));
		}
		
	}
}
