package chap17;
/*
 * EchoServerEx1 프로그램을 멀티 클라이언트가 접속 가능하도록 수정하기
 * Thread 사용해야함
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
			out = new PrintWriter(client.getOutputStream(),true);//클라이언트와 통신할수있는 곳
			br = new BufferedReader(new InputStreamReader(client.getInputStream()));
		}catch(IOException e) {
			e.printStackTrace();
		}	
	 }
	@Override
	public void run() {
		String input;
		try {
			while((input=br.readLine())!=null){ //클라이언트가 입력해준 line
				out.println(input);
				out.flush();
				System.out.println("client data:"+input);//입력한내용 input
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
			ServerSocket server = new ServerSocket(5000,100);//ServerSocket은 여러개의 소켓을 accept해서 가져올수있음 보통50개 정도(동시접속) /100 동시접속자 수 지정
			while(true) {//얼마나 접속될지모르기때문에 무한반복
			System.out.println("클라이언트 접속대기");//클라이언트가 들어올때까지 대기
			Socket client = server.accept(); //클라이언트가 만들어놓은 socket을 받음, client가 만들어줌     => client = new Socket(ip, port);
			System.out.println("스레드생성");
			ServerThread th = new ServerThread(client);
			th.start();
	
			}
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}
