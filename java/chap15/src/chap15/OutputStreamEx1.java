package chap15;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
/*
 * System.out�� Ÿ�� PrintStream
 * PrintStream��  OutputStream�� ����Ŭ������.
 */
public class OutputStreamEx1 {
	public static void main(String[] args) throws IOException {
//		OutputStream out = System.out;//�θ�Ÿ���� System.out�� ������ �� �ִ�.
//		out.println('a'); //println Ÿ����  PrintStream�̶� ����.. OutputStream�� ����� �ƴϴ�.
//		out.write('1');out.write('2');out.write('3');
//		out.write('a');out.write('b');out.write('c');
//		out.write('��');out.write('��');out.write('��'); //�ȳ���  OutputStream�� 1����Ʈ�� ����
//		out.flush();
		
		//������ ����� �� �ִ�  ��� ������ Writer�� ���
		Writer out = new OutputStreamWriter(System.out);
		out.write('1');out.write('2');out.write('3');
		out.write('a');out.write('b');out.write('c');
		out.write('��');out.write('��');out.write('��'); 
		out.flush(); // ������ ������ �������� ���� ����
	}
}
