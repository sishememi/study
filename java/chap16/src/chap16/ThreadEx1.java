package chap16;
/*
 * Thread ����1
 * Thread ����
 * 	1.Thread Ŭ���� ��� =>Thread1.java
 * 	2.Runnable �������̽� ����=>Thread2.java
 * Thread�� ȯ�� ->���ÿ� �����δ�.
 * ��� ������� ���¸� ������ �ִ�.
 */
class Thread1 extends Thread{//extends Thread :Thread Ŭ���� ���
	Thread1(String name){
		super(name);
	}
	@Override
	public void run() { //Running ����
		for(int i=0; i<5; i++) {
			System.out.println(i+"="+getName());//Thread�� getName() = �����忡�� ��ӹ޾���. �������ӹ��� getName
			try {
				sleep(1000);//������ ,1000�и��� = 1 �ʴ�� ,sleep() threadŬ������ �ִ� �޼��� ������ ����ó���ؾ���
			}catch(InterruptedException e) {}
		}
	}
	//Dead����
}
public class ThreadEx1 {
	public static void main(String[] args) {
		System.out.println("main ������ ����");
		Thread t1 = new Thread1("First");//New����
		Thread t2 = new Thread1("Second");//New����
		//t1.start();//Runnable ���� , ������ ����ȭ���Ѽ� ����,run()�޼��� ����.
		/*
		 * start() ���
		 * 1. ���ÿ����� ����ȭ��Ŵ(main?�������� ���´�)
		 * 2. �ڽ��� ���� ������ run()�޼��� ȣ��
		 * 
		 */
		//t2.start(); //Runnable ���� ,���ÿ� run�޼��� ����
		t1.run();//Thread�� �� ������ Thread �ƴ�. ����� �ٸ�. single������ ȯ�� ���̳���..
		t2.run();
		System.out.println("main ������ ����"); //������2������ �� ������ �� ��� ����������.�����̻����. ������ 2���� �����尡 ��������. �׷��� ���ν��۸������� �� ���������� ���߿� t1,t2�� ������.
	}
}
