package chap17;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleWebServerEx1 {
	public static void main(String[] args) {
		try {
			ServerSocket server = new ServerSocket(8888); //8888��Ʈ�� ���ε���
			while(true) {
				System.out.println("Ŭ���̾�Ʈ ���� ���");
				Socket client = server.accept();
				System.out.println("������ ����");
				HttpThread ht = new HttpThread(client);
				ht.start();
			}
		}catch(Exception e) {
				e.printStackTrace();
			}
		}
	static class HttpThread extends Thread{
		private Socket client;
		BufferedReader br;
		PrintWriter pw;
		HttpThread(Socket client){
			this.client=client;
			try{
				br = new BufferedReader(new InputStreamReader(client.getInputStream()));
				pw = new PrintWriter(client.getOutputStream());
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
		@Override
		public void run() {
			BufferedReader fbr = null;
			try {
				// GET / HTTP/1.1
				String line = br.readLine();
				System.out.println("Http Headr: "+line);
				int start = line.indexOf("/")+1;
				int end = line.lastIndexOf("HTTP")-1;
				String fileName = line.substring(start,end);
				if(fileName.equals(""))fileName = "index.html";
				System.out.println("����� ��û ����:"+fileName);
				fbr = new BufferedReader(new FileReader(fileName));
				String fileLine = null;
				while((fileLine= fbr.readLine()) != null) {
					pw.println(fileLine);
					pw.flush();
				}
			}catch(IOException e) {
				e.printStackTrace();
			}finally {
				try {
					if(fbr != null) fbr.close();
					if(br != null) br.close();
					if(pw != null) pw.close();
					if(client != null) client.close();
				}catch(IOException e) {}
			}
		}
	}
}