package test0916;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class test191008 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader in = new BufferedReader(new FileReader("InputStream¿¹Á¦.txt"));
//		List<String> l = new ArrayList<String>();
//		char [] buf =new char[1024];
//		int data=0;
//		while((data=in.read(buf))!=-1) {
//			l.add(new String(buf,0,data));
//			System.out.println(l);
//		}
//		
		String r=null;
		List<String> l = new ArrayList<String>();
		while((r=in.readLine())!=null) {
			l.add(r);
		}
		in.close();
	System.out.println(l);

	}

}
