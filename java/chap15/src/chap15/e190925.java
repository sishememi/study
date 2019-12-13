package chap15;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

/*
 * 1. ���ϸ��� �Է¹ޱ�
 2. 1�� �̸����� FileInputStream���� ����.
    try {
    FileInputStream fis = new FileInputStream(���ϸ�)
    } catch(FileNotFoundException e) {
       "�ش� ������ �����ϴ�. " ���
       1������ �̵�
    }
 3. 1�� ���ϸ�+".bak" ���� FileOutputStream���� ����
    FileOutputStream fos = new FileOutputStream(���ϸ�+".bak")
 4. 2�� FileInputStream���� read() �ϰ�.
    3�� FileOutputStream�� write() �ϱ�   

 */
public class e190925 {
	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(System.in);
		while(true) {
			System.out.println("���ϸ��� �Է��ϼ��� (����:exit)");
			String file = scan.next();
			if(file.equalsIgnoreCase("exit")) break;
			String bakfile= file.substring(0,file.lastIndexOf('.'))+ ".bak";
			FileInputStream fis = null;
			FileOutputStream fos = null;
			try {
				fis = new FileInputStream(file);
				fos = new FileOutputStream(bakfile);
				byte [] buf = new byte[8096];
				int len = 0;
				while((len =fis.read(buf))!=-1) {
					System.out.println(new String(buf,0,len));
				}
				System.out.println(file+"=>"+bakfile+"����Ϸ�");
				}catch(FileNotFoundException e) {
					System.out.println("������ ������ �����ϴ�.");
				}
				finally{
					if(fos != null) fos.flush();
					if(fis != null) fis.close();
					if(fos != null) fos.close();
				}
			}
//		try {
//			FileInputStream fis = new FileInputStream(file);
//			byte [] buf = new byte[fis.available()];
//			int data=0;
//			while((data=fis.read(buf))!= -1) {
//				System.out.println(new String (buf,0,data));
//			}
//			FileOutputStream fos = new FileOutputStream(file+".bak".getBytes());
//			fos.write(buf);
//			fos.flush();
//			System.out.println(file.substring(0,file.indexOf('.'))+ ".bak ���Ͽ� " +file+"�� ������ �����ϱ�");
//			
//			}catch(FileNotFoundException e) {
//		     System.out.println( "�ش� ������ �����ϴ�.");
//		     continue;
//		    }
		}
	}

