package chap17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/*
 * Echo 클라이언트 예제 :   키보드로 입력받은 내용을 서버로 전송
 *                서버는 입력받은 내용을 다시 클라이언트로 전송함
 */
public class EchoClientEx1 {

   public static void main(String[] args) 
   {
      int port = 5000;
      String ip = "192.168.0.75";
      Socket client = null;
      PrintWriter out = null;
      BufferedReader br = null;
      try
      {
         String input;
         BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
         client = new Socket(ip, port);
         br = new BufferedReader(new InputStreamReader(client.getInputStream()));
         out = new PrintWriter(client.getOutputStream());
         System.out.println("local port : " + client.getLocalPort());
         System.out.println("local ip" + client.getLocalAddress());
         System.out.println("server port" + client.getPort());
         System.out.println("server ip" + client.getInetAddress());
         System.out.println("메세지 입력:");
         while((input = stdin.readLine()) != null)
         {
            if(input.equals("bye")) break;
            out.println(input);
            out.flush();
            System.out.println("server echo :" +br.readLine());
            System.out.println("메세지 입력");
         }
         out.close(); br.close(); stdin.close(); client.close();
      }
      catch(IOException e)
      {
         e.printStackTrace();
      }
   }
}
