package chap15;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

public class ProcessEx1 {
	public static void main(String[] args) throws IOException {
		//Runtime.getRuntime() : OS로부터 실행권한을 받기.
		Process p = Runtime.getRuntime().exec("ping 192.168.0.1");
		Reader is = new InputStreamReader(p.getInputStream());
		int data = 0;
		while((data=is.read()) != -1) {
			System.out.print((char)data);
		}

	}
}
