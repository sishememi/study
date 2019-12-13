package chap15;

import java.io.FileOutputStream;
import java.io.IOException;

/*
 * FilOutputStream ����
 * 		:���Ͽ� ������ ���
 * 	void write(int data) : data �� 1����Ʈ�� ���Ϸ� ���
 * 	void write(byte[] buf) : buf�� ������ ���Ϸ� ���
 * 	void write(byte[] buf, int start, int len): buf�� start �ε��� ���� len ����Ʈ ��ŭ ������ ���Ϸ� ���
 */
public class FileOutputStreamEx1 {
	public static void main(String[] args) throws IOException{
		FileOutputStream fos = new FileOutputStream("out.txt");
		fos.write('1');fos.write('2');fos.write('3');
		fos.write('a');fos.write('b');fos.write('d');
		fos.write('��');fos.write('��');fos.write('��');
		//.getBytes() : ���ڿ��� byte[](�迭)�� ����.
		byte [] buf = "\n�ݰ����ϴ�. FileOutputStream �����Դϴ�.\n" .getBytes();
		fos.write(buf);
		fos.write(buf,1,6);
		fos.flush();
	}
}