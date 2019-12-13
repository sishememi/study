package chap16;
/*
 * 데몬스레드
 * 	데몬 스레드의 기능은 일반 스레드의 보조 역할을 담당한다.
 * 	일반스레드가 종료되면 데몬스레드도 함께 종료된다.
 * 	데몬 스레드는 일반적으로 무한 반복이다.
 * 	데몬스레드 설정 방법 : setDaemon => 반드시 new 상태에서 해야한다.
 * 								 Runnable 상태에서 설정하면 예외가 발생한다.
 */
class DaemonThread extends Thread{
	public void run() {
		while(true) {
			System.out.println(getName());//기본이름설정: Thread-n
			try {
				sleep(100);//0.1초
			}catch(InterruptedException e) {}
		}
	}
}
public class ThreadEx7 {
	public static void main(String[] args) throws InterruptedException{//여기서 main이 일반쓰레드
		Thread t1 = new DaemonThread();
		Thread t2 = new DaemonThread();
		t1.setDaemon(true);//데몬스레드로 설정, 일반스레드의 보조하는 역할. 일반스레드가 없으면 끝남. new상태에서만 설정이 가능함
		t2.setDaemon(true);//데몬스레드로 설정
		t1.start(); t2.start();
		Thread.sleep(2000);
		System.out.println("main스레드 종료");
	}
}
