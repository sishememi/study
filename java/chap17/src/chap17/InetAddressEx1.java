package chap17;

import java.net.InetAddress;
import java.net.UnknownHostException;
/*
 * InetAddress Ŭ���� : IP �ּ� ������ �����ϴ� Ŭ����
 * 	InetAddress getByName("�����θ�")
 * 	InetAddress[] getAllByName("������ �̸�")
 * 	InetAddress getByAddress(byte[] addr):����Ʈ�� �迭�� ���� �������·� �� �Է�
 *  InetAddress getLocalHost : ����ǻ���� ip�ּ� ����
 */
public class InetAddressEx1 {
	public static void main(String[] args) throws UnknownHostException {
		InetAddress ip = InetAddress.getByName("www.goodee.co.kr");
		System.out.println("getByName�޼��� ȣ��");
		System.out.println("hostname:"+ip.getHostName());//������
		System.out.println("hostaddress:"+ip.getHostAddress());//���������� �ּ�
		InetAddress [] ips = InetAddress.getAllByName("www.goodee.co.kr");
		System.out.println("getByName �޼��� ȣ��");
		for(InetAddress i : ips) {
			System.out.println("ip �ּ�:"+i);
		}
		System.out.println("getLocalHost �޼��� ȣ��");
		InetAddress local = InetAddress.getLocalHost();//����ǻ�� IP�ּ�
		System.out.println("�� ��ǻ��:"+local);
	}
}
