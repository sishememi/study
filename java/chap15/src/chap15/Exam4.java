package chap15;

import java.io.File;

/*
 * c:\windows ������ �����Ͽ� ������ ���� ���� ������ ������ ����, ������ �� ũ�� ����ϱ�.
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
		System.out.printf("���� ������ ����: %d ������ ����: %d, ������ �� ũ��: %,dbyte%n",cnt2,cnt1,size);
	}
}
