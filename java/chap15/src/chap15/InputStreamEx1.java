package chap15;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
/*
 * �ڹٿ��� �����Ǵ� ǥ�� ����� ��ü
 * ǥ���Է�:InputStream System.in : Ű���忡�� �Է�.
 * ǥ�����:PrintStream System.out : �ܼ�(ȭ��)�� ������ ���
 * ǥ�ؿ���:PrintStream System.err :�ܼ�(ȭ��)�� ������ ���
 * 
 * I/O��Ʈ��: ������ �̵� ���, �ܹ���(�Է�,���), ����(���۰� ����)
 * 
 * 	�Է�			�ֻ���
 * 		����Ʈ: InputStream => ��� ������ ó������/1����Ʈ ������ ����. �׷��� �ѱ��� ����.. 1����Ʈ �����θ� ����,, 
 * 		������: Reader => 2����Ʈ ������ ����.
 * 		����Ʈ �Է½�Ʈ�� => ������ �Է½�Ʈ��: InputStreamReader : Reader Ŭ������ ����Ŭ����
 * 	���
 * 		����Ʈ: OutStream => 1����Ʈ ������ ���.
 * 		������: Writer => 2����Ʈ ������ ���.
 * 		����Ʈ �Է½�Ʈ�� => ������ �Է½�Ʈ��: OutputStreamWriter : Writer Ŭ������ ����Ŭ����
 */
public class InputStreamEx1 {
	public static void main(String[] args) throws IOException {
//		InputStream in = System.in;
		Reader in = new InputStreamReader(System.in);//System.in input��Ʈ�������� �����ֱ⶧���� Reader���� ������ InputStreamReader�� �ʿ�
		int data = 0;
		while((data = in.read()) != -1) {//��Ʈ��+z while�� ����.
			System.out.print((char)data);
		}
	}
}
