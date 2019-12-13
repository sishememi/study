package chap15;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/*
 * ȭ�鿡�� ���ϸ��� �Է¹޾Ƽ� �ش� ������ ������ ȭ�鿡 ����ϱ�
 * ���� ������ ���� ���� '�ش� ���� ����' �� ����ϱ�.
 * �ѱ��� ������ �ʾƾ���.
 * FileInputStream ����ϱ�
 */
public class Exam1 {
	public static void main(String[] args) throws IOException{
		System.out.println("���ϸ��� �Է��ϼ���");
		Scanner scan = new Scanner(System.in);
		String fname = scan.next();
		try {
			//FileInputStream fis = new FileInputStream("src/chap15/"+fname+".java");
			FileInputStream fis = new FileInputStream(fname);
			byte [] buf = new byte[fis.available()];
			int data = 0;
			while((data = fis.read(buf))!= -1) {
				System.out.println(new String(buf,0,data));
			}
		} catch (FileNotFoundException e) {
			System.out.println("�ش� ���� ����");
			//e.printStackTrace();
		}
	}

}
