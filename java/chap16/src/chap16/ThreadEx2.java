package chap16;
/*
 * Runnable 인터페이스 구현하여 스레드 생성하기
 * 
 */
class Runnable1 implements Runnable{//Runnable인터페이스 구현 클래스. Runnable1은 thread클래스 가 아님. 상관 없다.
	@Override
	public void run() { //스레드가 해야할 행동을 적은 run()메서드를 오버라이딩 해야한다.
		for(int i=0; i<5; i++) {
			System.out.println(i+"="+Thread.currentThread().getName());//Thread.currentThread().getName(): 지금 현재 실행 중인 스레드의 이름
			try {
				Thread.sleep(1000); //Runnable에 sleep메서드를 가지고 있지 않기때문에 , Thread메서드인 sleep을 Thread.sleep()으로 기재.
			}catch(InterruptedException e) {}
		}
		
	}
	
}
public class ThreadEx2 {
	public static void main(String[] args) {
		System.out.println("main 스레드 시작");
		Runnable r = new Runnable1();//Thread 객체가 아님
		Thread t1 = new Thread(r,"First");//New상태, r에있는 run메서드를 호출함.
		Thread t2 = new Thread(r,"Second");//New상태
		t1.start();t2.start();// thread 객체를 통한 r.run 메서드 호출
		t1.run();t2.run();//r에 있는 run()메서드 호출
		/*
		 * start() 기능
		 * 1. 스택 병렬화
		 * 2. r 객체가 가지고 있는 run()메서드 호출.
		 */
		System.out.println("main 스레드 종료");

	}
}
