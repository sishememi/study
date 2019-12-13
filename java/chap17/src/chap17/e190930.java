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
			ServerSocket server = new ServerSocket(8888); //8888��Ʈ�ѹ��� ���ε���, server��ü ����
			while(true) {
				System.out.println("Ŭ���̾�Ʈ ���� ���");
				Socket client = server.accept();
				//server���� accept�޼ҵ� ȣ��, Ŭ���̾�Ʈ ���� ��⿪�� ,accept�޼ҵ�� ���� client�� Ŭ���̾�Ʈ�� 1:1����� ����
				//client���� ��Ű���.
				System.out.println("������ ����");
				HttpThread ht = new HttpThread(client);//����� �����尡 �˾Ƽ����ְԵ�, ���� ����� �˾Ƽ���.
				ht.start();
			}
		}catch(Exception e) {
				e.printStackTrace();
			}
		}
	static class HttpThread extends Thread{//���θ޼��忡�� ��ä�����̵Ƿ��� static�� �پ���Ѵ�.
		private Socket client;
		BufferedReader br;
		OutputStream pw;
		HttpThread(Socket client){
			this.client=client;
			try{
				br = new BufferedReader(new InputStreamReader(client.getInputStream()));//�Է½�Ʈ��,BufferedReader Ŭ���̾�Ʈ�ʿ��� �����ֱ⶧���� ��� x
				pw = client.getOutputStream();//��½�Ʈ��
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
		@Override
		public void run() {
			FileInputStream fbr = null; //�̹��� ���϶����� InputStream��������
			try {
				// GET / HTTP/1.1
				String line = br.readLine();//Ŭ���̾�Ʈ�� ù��°�޼����� ����=> GET / HTTP/1.1
				System.out.println("Http Headr: "+line);
				int start = line.indexOf("/")+1;
				int end = line.lastIndexOf("HTTP")-1;
				String fileName = line.substring(start,end);
				if(fileName.equals(""))fileName = "index.html"; //�����̸��� ���������
				System.out.println("����� ��û ����:"+fileName);
				fbr = new FileInputStream(fileName); //������ �о��, Writer�̸� �̹����� �������� ����.
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