package chap15;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

/*
 * ���� ��Ʈ�� : PrintStream (����ó���� ���ϵ��� ..�������?.,.)
 * 		- OutputStream�� ���� Ŭ����
 * 		- print(),println(),printf() �޼��� �߰�
 * 		  	��� �ڷ����� ���.
 * 			����ó�� ������ ������ �޼���
 * 		- System.out(ǥ�� ���),System.err(ǥ�� ����)�� �ڷ�����.
 */
public class PrintStreamEx1 {
	public static void main(String[] args) throws IOException {
		FileOutputStream fos = new FileOutputStream("print.txt");
		PrintStream ps = new PrintStream(fos,true); //�Ű����� output��Ʈ��/true:autoflush ��� �߰�
		ps.println("ȫ�浿");
		ps.println(1234);
		ps.println(true);
		ps.println(65);//65
		ps.write(65);//A.
	//	ps.flush();
		ps = new PrintStream("print2.txt"); //���� PrintStream ps = new PrintStream(fos); �Ǿ������� �˾Ƽ� ���ϻ������� ����
		ps.println("ȫ�浿");
		ps.println(1234);
		ps.println(true);
		ps.println(65);//65
		ps.write(65);//A.
		ps.flush();
	}
}
