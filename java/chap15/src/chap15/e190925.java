package chap15;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

/*
 * 1. 파일명을 입력받기
 2. 1의 이름으로 FileInputStream으로 열기.
    try {
    FileInputStream fis = new FileInputStream(파일명)
    } catch(FileNotFoundException e) {
       "해당 파일이 없습니다. " 출력
       1번으로 이동
    }
 3. 1의 파일명+".bak" 파일 FileOutputStream으로 열기
    FileOutputStream fos = new FileOutputStream(파일명+".bak")
 4. 2의 FileInputStream에서 read() 하고.
    3의 FileOutputStream에 write() 하기   

 */
public class e190925 {
	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(System.in);
		while(true) {
			System.out.println("파일명을 입력하세요 (종료:exit)");
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
				System.out.println(file+"=>"+bakfile+"복사완료");
				}catch(FileNotFoundException e) {
					System.out.println("복사할 파일이 없습니다.");
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
//			System.out.println(file.substring(0,file.indexOf('.'))+ ".bak 파일에 " +file+"의 내용을 복사하기");
//			
//			}catch(FileNotFoundException e) {
//		     System.out.println( "해당 파일이 없습니다.");
//		     continue;
//		    }
		}
	}

