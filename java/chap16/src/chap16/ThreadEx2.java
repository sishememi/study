package chap16;
/*
 * Runnable �������̽� �����Ͽ� ������ �����ϱ�
 * 
 */
class Runnable1 implements Runnable{//Runnable�������̽� ���� Ŭ����. Runnable1�� threadŬ���� �� �ƴ�. ��� ����.
	@Override
	public void run() { //�����尡 �ؾ��� �ൿ�� ���� run()�޼��带 �������̵� �ؾ��Ѵ�.
		for(int i=0; i<5; i++) {
			System.out.println(i+"="+Thread.currentThread().getName());//Thread.currentThread().getName(): ���� ���� ���� ���� �������� �̸�
			try {
				Thread.sleep(1000); //Runnable�� sleep�޼��带 ������ ���� �ʱ⶧���� , Thread�޼����� sleep�� Thread.sleep()���� ����.
			}catch(InterruptedException e) {}
		}
		
	}
	
}
public class ThreadEx2 {
	public static void main(String[] args) {
		System.out.println("main ������ ����");
		Runnable r = new Runnable1();//Thread ��ü�� �ƴ�
		Thread t1 = new Thread(r,"First");//New����, r���ִ� run�޼��带 ȣ����.
		Thread t2 = new Thread(r,"Second");//New����
		t1.start();t2.start();// thread ��ü�� ���� r.run �޼��� ȣ��
		t1.run();t2.run();//r�� �ִ� run()�޼��� ȣ��
		/*
		 * start() ���
		 * 1. ���� ����ȭ
		 * 2. r ��ü�� ������ �ִ� run()�޼��� ȣ��.
		 */
		System.out.println("main ������ ����");

	}
}
