package chap15;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/*
 * 1. src/chap15 폴더의 .java 파일 중 InputStream 관련 모든 소스를  
 * 	  InputStream예제.txt  파일로 생성하기
   	  InputStream 관련 모든 소스 : XXXInputStreamXXX.java
 */
public class e190926 {
	public static void main(String[] args) throws IOException {
		
		File f1 = new File("src/chap15");
		String files[] = f1.list();
		FileOutputStream fos = new FileOutputStream("InputStream예제.txt");
		
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
		//강사님버전
//		File f1 = new File("src/chap15");
//		String flist[] = f1.list();
//		int len;
//		FileOutputStream fos = new FileOutputStream("InputStream예제.txt");
//		byte[] buf = new byte[1024];
//		for(String fname : flist) {
//			File f2 = new File(f1,fname);
//			if(f2.isFile() && fname.indexOf("InputStream")>=0 && fname.endsWith(".java"));//fname.contains("InputStream"): fname문자열 내부에  InputStream 존재?, indexOf도 가능,fname.endsWith(".java"): fname 끝이 .java로 끝남?
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



