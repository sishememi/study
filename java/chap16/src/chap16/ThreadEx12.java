package chap16;
/*
 * wait(),notify(),notify()
 * 	1. 동기화 영역(동기화 블럭, 동기화 메서드) 메서드만 호출이 가능
 * 	2. Object 클래스의 멤버 메서드 => 모든 객체는 wait,notify,norifyAll 메서드 실행 가능
 * 	3. wait() : 현재 실행 중인 Thread를 대기상태로 변환. lock 해제함. notify,norifyAll 메서드를 이용하여
 * 				대기상태에서 Runnable 상태로 변환이 가능함.
 * 	   notify() : wait() 상태인 스레드 중 한개만 Runnable 상태로 변환. 개발자가 지정 불가.
 * 	   notifyAll() : wait() 상태인 스레드 모두를 Runnable 상태로 변환.
 * 
 */
class ATM2 implements Runnable{ //Runnable 인터페이스를 구현한 Runnable.,notify()를 썼는데 Object클래스의 멤버
	private long money = 120000;//110000
	@Override
	public void run() {
		synchronized(this) { //동기화 블럭, 
		for(int i=0;i<10;i++) {
			if(money <= 0) { //100000
				System.out.println("잔액이 없습니다.");
				notify();
				break;
			}
			withDraw(10000);
			if(money % 20000 == 0) {
				try {
					wait(); //son wait() => lock 해제, 대기
				}catch(InterruptedException e) {}
				}else {
					notify(); //daugther Runnable상태 wait()의 son과 반복적으로 바뀜ㅁ..
				}
			}
		}
	}
private void withDraw(int i) {
		if(money <= 0) return;
		money -= i;
		System.out.println(Thread.currentThread().getName()+"출금. 잔액:"+money);	
	}
}
public class ThreadEx12 {
	public static void main(String[] args) {
		ATM2 atm = new ATM2();
		Thread son = new Thread(atm,"SON");
		Thread daughter = new Thread(atm,"DAUGTHER");
		son.start();daughter.start();
	}
}
