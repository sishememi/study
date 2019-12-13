package chap16;
/*
 * ����ȭ:synchronized ����� ǥ��
 * 	����ȭ ��:ThreadEx9.java
 * 			lock ��ü�� ������ �����常 ����ȭ ������ ����.
 * 			lock�� Object ��ü���� �Ѵ�. ��ü������. �⺻�ڷ����� lock���� ����� �� ����.
 * 			��� �����尡 �����ϴ� ���� ��ü���� ��.
 * 	����ȭ�޼���:ThreadEx10.java
 */
class PrintThread2 extends Thread{
	char ch;
	static Object lock = new Object(); //String,Integer ����, object��/ int X(�ȵ�)= �⺻�ڷ��� X / �迭�� Object�� ����Ŭ�����̰�, ��ü�̱⶧���� �� �� �ִ�.
	//static�� ������ ����ȭ�� ���� ����.
	PrintThread2(char ch){
		this.ch = ch;
	}
	public void run() {
		for(int i=0;i<20;i++) {
			synchronized(lock) { //lock : t1 ���� => t2�� running�̵Ǹ� t2�� ������..
			for(int j=0;j<80;j++) {
				System.out.print(ch);
			}
			System.out.println();
			//����ȭ ��/ �̺� �� ���������� lock �� �����ο���
			}
		}
	}
}
public class ThreadEx9 {
	public static void main(String[] args) {
		Thread t1 = new PrintThread2('A');//running�϶� for������ ���� ó�� lock�� t1�� ������ r�����϶� A�� 80����� =>runnable��?�ٲ�� �ٷ�
		Thread t2 = new PrintThread2('B');// t2�� running���·� �ٲ�
		Thread t3 = new PrintThread2('C');//���
		t1.start();t2.start();t3.start();
	}
}
