package chap17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServerEx1 {
	public static void main(String[] args)   {
		int port =5000;
		Socket client = null;
		ServerSocket server = null;
		try {
		server = new ServerSocket(port);
		client = server.accept();//서버접속되면ㅇ ㅣ상태에서 대기
		System.out.println("server:"+server);
		System.out.println("localport:"+server.getLocalPort());
		System.out.println();
		System.out.println("connected ip:"+client.getInetAddress());
		System.out.println("connected port:"+client.getPort());
		PrintWriter out = new PrintWriter(client.getOutputStream(),true);
		BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));
		String input;
		while((input=br.readLine())!=null){
			out.println(input);
			out.flush();
			System.out.println("client data:"+input);
			}
		br.close(); out.close(); client.close(); server.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
	} 

}
