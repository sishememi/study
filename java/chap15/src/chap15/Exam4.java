package chap15;

import java.io.File;

/*
 * c:\windows 폴더를 지정하여 폴더의 하위 폴더 갯수와 파일의 갯수, 파일의 총 크기 출력하기.
 */
public class Exam4 {
	public static void main(String[] args) {
		String filePath = "c:/Windows";
		File f1 = new File(filePath);
		String files[] = f1.list();
		int cnt1=0,cnt2=0,size=0;
		
		for(String f : files) {
			File f2 = new File(filePath,f);
			if(f2.isFile()) {
				cnt1++;
			}else if(f2.isDirectory()) {
				cnt2++;
				size+=f2.length();
			}
		}	
		System.out.printf("하위 폴더의 갯수: %d 파일의 갯수: %d, 파일의 총 크기: %,dbyte%n",cnt2,cnt1,size);
	}
}
