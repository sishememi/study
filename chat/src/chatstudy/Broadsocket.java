package chatstudy;

import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/broadcasting")//웹소켓의 서버클래스 지정
public class Broadsocket {
	private static Set<Session> clients  //static을 붙임으로써 하나만 가질수있음.
		= Collections.synchronizedSet(new HashSet<Session>());
	@OnMessage  //클라이언트에서 메세지 수신
	public void onMessage(String message,Session session) throws IOException{
		synchronized(clients) {
			for(Session client : clients) {
				if(!client.equals(session)) { //클라이언트 정보가 나의 session경우. 수신된 session
					client.getBasicRemote().sendText(message);
				}
			}
		}
	}
	@OnOpen //클라이언트가 연결되었을 때
	public void onOpen(Session session) {
		clients.add(session);
	}
	@OnClose
	public void onClose(Session session) {
		clients.remove(session);
	}
}
