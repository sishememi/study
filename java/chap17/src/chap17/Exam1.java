package chap17;
/*
 * EchoServerEx1 ���α׷��� ��Ƽ Ŭ���̾�Ʈ�� ���� �����ϵ��� �����ϱ�
 * Thread ����ؾ���
 */

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

class ServerThread extends Thread {
	private Socket client = null;
	PrintWriter out;
	BufferedReader br;
	
	 ServerThread(Socket client) {
		this.client=client;
		System.out.println("connected ip:"+client.getInetAddress());
		System.out.println("connected port:"+client.getPort());
		try {
			out = new PrintWriter(client.getOutputStream(),true);//Ŭ���̾�Ʈ�� ����Ҽ��ִ� ��
			br = new BufferedReader(new InputStreamReader(client.getInputStream()));
		}catch(IOException e) {
			e.printStackTrace();
		}	
	 }
	@Override
	public void run() {
		String input;
		try {
			while((input=br.readLine())!=null){ //Ŭ���̾�Ʈ�� �Է����� line
				out.println(input);
				out.flush();
				System.out.println("client data:"+input);//�Է��ѳ��� input
				}
			br.close(); out.close(); client.close(); 
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}
}

public class Exam1 {
	public static void main(String[] args) {
		try {
			ServerSocket server = new ServerSocket(5000,100);//ServerSocket�� �������� ������ accept�ؼ� �����ü����� ����50�� ����(��������) /100 ���������� �� ����
			while(true) {//�󸶳� ���ӵ����𸣱⶧���� ���ѹݺ�
			System.out.println("Ŭ���̾�Ʈ ���Ӵ��");//Ŭ���̾�Ʈ�� ���ö����� ���
			Socket client = server.accept(); //Ŭ���̾�Ʈ�� �������� socket�� ����, client�� �������     => client = new Socket(ip, port);
			System.out.println("���������");
			ServerThread th = new ServerThread(client);
			th.start();
	
			}
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}
