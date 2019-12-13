package chap17;

import java.net.InetAddress;
import java.net.UnknownHostException;
/*
 * InetAddress 클래스 : IP 주소 정보를 저장하는 클래스
 * 	InetAddress getByName("도메인명")
 * 	InetAddress[] getAllByName("도메인 이름")
 * 	InetAddress getByAddress(byte[] addr):바이트형 배열로 만들어서 숫자형태로 값 입력
 *  InetAddress getLocalHost : 내컴퓨터의 ip주소 리턴
 */
public class InetAddressEx1 {
	public static void main(String[] args) throws UnknownHostException {
		InetAddress ip = InetAddress.getByName("www.goodee.co.kr");
		System.out.println("getByName메서드 호출");
		System.out.println("hostname:"+ip.getHostName());//도메인
		System.out.println("hostaddress:"+ip.getHostAddress());//숫자형태의 주소
		InetAddress [] ips = InetAddress.getAllByName("www.goodee.co.kr");
		System.out.println("getByName 메서드 호출");
		for(InetAddress i : ips) {
			System.out.println("ip 주소:"+i);
		}
		System.out.println("getLocalHost 메서드 호출");
		InetAddress local = InetAddress.getLocalHost();//내컴퓨터 IP주소
		System.out.println("내 컴퓨터:"+local);
	}
}
