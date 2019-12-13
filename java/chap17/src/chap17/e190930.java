package chap17;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;


public class e190930 {
	public static void main(String[] args) {
		try {
			ServerSocket server = new ServerSocket(8888); //8888포트넘버와 바인딩됨, server객체 생성
			while(true) {
				System.out.println("클라이언트 접속 대기");
				Socket client = server.accept();
				//server으로 accept메소드 호출, 클라이언트 접속 대기역할 ,accept메소드로 받은 client이 클라이언트와 1:1연결된 소켓
				//client으로 통신가능.
				System.out.println("스레드 생성");
				HttpThread ht = new HttpThread(client);//통신은 스레드가 알아서해주게됨, 실제 통신을 알아서함.
				ht.start();
			}
		}catch(Exception e) {
				e.printStackTrace();
			}
		}
	static class HttpThread extends Thread{//메인메서드에서 객채생성이되려면 static이 붙어야한다.
		private Socket client;
		BufferedReader br;
		OutputStream pw;
		HttpThread(Socket client){
			this.client=client;
			try{
				br = new BufferedReader(new InputStreamReader(client.getInputStream()));//입력스트림,BufferedReader 클라이언트쪽에서 보내주기때문에 상관 x
				pw = client.getOutputStream();//출력스트림
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
		@Override
		public void run() {
			FileInputStream fbr = null; //이미지 파일때문에 InputStream으로읽음
			try {
				// GET / HTTP/1.1
				String line = br.readLine();//클라이언트가 첫번째메세지를 보냄=> GET / HTTP/1.1
				System.out.println("Http Headr: "+line);
				int start = line.indexOf("/")+1;
				int end = line.lastIndexOf("HTTP")-1;
				String fileName = line.substring(start,end);
				if(fileName.equals(""))fileName = "index.html"; //파일이름이 비어있을시
				System.out.println("사용자 요청 파일:"+fileName);
				fbr = new FileInputStream(fileName); //파일을 읽어옴, Writer이면 이미지를 가져오지 못함.
				int filename=0;
				byte [] buf = new byte[1024];
				while((filename=fbr.read(buf))!=-1) {
					pw.write(buf,0,filename);
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