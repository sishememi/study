package chap15;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/*
 * ȭ�鿡�� ���ϸ��� �Է¹ް�,������ �Է¹޾� �Է¹��� ���Ͽ� �Էµ� ������ �����ϱ�.
 * exit�� �ԷµǸ� ���� �Է� �����ϱ�.
 * 
 * [���]
 * ���ϸ��� �Է��ϼ���
 * aaa.txt
 * ������ ������ �Է��ϼ���
 * �ȳ��ϼ���
 * �ݰ����ϴ�.
 * exit
 * 
 * aaa.txt ������ ����
 * �ȳ��ϼ���
 * �ݰ����ϴ�.
 */
public class Exam2 {
	public static void main(String[] args) throws IOException{

//			Scanner s = new Scanner(System.in);
//			System.out.println("���ϸ��� �Է��ϼ���");
//			String file = s.next();
//			System.out.println("������ ������ �Է��ϼ���");
//			while(true) {
//				String t = s.next();
//				if(t.equalsIgnoreCase("exit")) break;
//				FileOutputStream fos = new FileOutputStream(file,true);
//				fos.write((t+"\n").getBytes());
//		}
		//FileWriter ����
		Scanner s = new Scanner(System.in);
		System.out.println("���ϸ��� �Է��ϼ���");
		String file = s.next();
		FileWriter f = new FileWriter(file,true);
		System.out.println("������ �Է��ϼ���:(����:exit)");
		while(true) {
			String txt =s.next();
			if(txt.equals("exit"))break;
			
			f.write(txt+"\n");
		}
		f.flush();
	}
}
