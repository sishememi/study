package chap16;
/*
 * ���󽺷���
 * 	���� �������� ����� �Ϲ� �������� ���� ������ ����Ѵ�.
 * 	�Ϲݽ����尡 ����Ǹ� ���󽺷��嵵 �Բ� ����ȴ�.
 * 	���� ������� �Ϲ������� ���� �ݺ��̴�.
 * 	���󽺷��� ���� ��� : setDaemon => �ݵ�� new ���¿��� �ؾ��Ѵ�.
 * 								 Runnable ���¿��� �����ϸ� ���ܰ� �߻��Ѵ�.
 */
class DaemonThread extends Thread{
	public void run() {
		while(true) {
			System.out.println(getName());//�⺻�̸�����: Thread-n
			try {
				sleep(100);//0.1��
			}catch(InterruptedException e) {}
		}
	}
}
public class ThreadEx7 {
	public static void main(String[] args) throws InterruptedException{//���⼭ main�� �Ϲݾ�����
		Thread t1 = new DaemonThread();
		Thread t2 = new DaemonThread();
		t1.setDaemon(true);//���󽺷���� ����, �Ϲݽ������� �����ϴ� ����. �Ϲݽ����尡 ������ ����. new���¿����� ������ ������
		t2.setDaemon(true);//���󽺷���� ����
		t1.start(); t2.start();
		Thread.sleep(2000);
		System.out.println("main������ ����");
	}
}
