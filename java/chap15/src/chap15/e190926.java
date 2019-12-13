package chap15;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/*
 * 1. src/chap15 ������ .java ���� �� InputStream ���� ��� �ҽ���  
 * 	  InputStream����.txt  ���Ϸ� �����ϱ�
   	  InputStream ���� ��� �ҽ� : XXXInputStreamXXX.java
 */
public class e190926 {
	public static void main(String[] args) throws IOException {
		
		File f1 = new File("src/chap15");
		String files[] = f1.list();
		FileOutputStream fos = new FileOutputStream("InputStream����.txt");
		
		for(String s: files) {	
			if(s.contains("InputStream")) {
				FileInputStream fis = new FileInputStream("src/chap15/"+s);
				int data= 0;
				byte [] buf = new byte[fis.available()];
				while((data = fis.read(buf)) != -1) {
					fos.write(("****************"+s+"****************").getBytes());
					fos.write(buf);
				}
				
			}

		}		
		//����Թ���
//		File f1 = new File("src/chap15");
//		String flist[] = f1.list();
//		int len;
//		FileOutputStream fos = new FileOutputStream("InputStream����.txt");
//		byte[] buf = new byte[1024];
//		for(String fname : flist) {
//			File f2 = new File(f1,fname);
//			if(f2.isFile() && fname.indexOf("InputStream")>=0 && fname.endsWith(".java"));//fname.contains("InputStream"): fname���ڿ� ���ο�  InputStream ����?, indexOf�� ����,fname.endsWith(".java"): fname ���� .java�� ����?
//				FileInputStream fis = new FileInputStream(f2);
//				fos.write(("\n\n****************"+fname+"****************").getBytes());
//				while((len = fis.read(buf)) != -1) {
//					fos.write(buf,0,len);
//				}
//				fis.close();
//			}
//		fos.flush();
//		fos.close();
//		}
	}	
}	
//		File f1 = new File("src/chap15");
//		String files[] = f1.list();
//		for(String s : files) {
//			File f2 = new File("src/chap15",s);
//			if(f2.isFile())
//				System.out.printf("%s \n",s);
//		}
//	}
//}



