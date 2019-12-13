package chap16;
/*
 * 동기화:synchronized 예약어 표현
 * 	동기화 블럭:ThreadEx9.java
 * 			lock 객체를 소유한 스레드만 동기화 영역을 실행.
 * 			lock은 Object 객체여야 한다. 객체여야함. 기본자료형은 lock으로 사용할 수 없다.
 * 			모든 스레드가 공유하는 공유 객체여야 함.
 * 	동기화메서드:ThreadEx10.java
 */
class PrintThread2 extends Thread{
	char ch;
	static Object lock = new Object(); //String,Integer 가능, object형/ int X(안됨)= 기본자료형 X / 배열은 Object의 하위클래스이고, 객체이기때문에 쓸 수 있다.
	//static이 없으면 동기화가 되지 않음.
	PrintThread2(char ch){
		this.ch = ch;
	}
	public void run() {
		for(int i=0;i<20;i++) {
			synchronized(lock) { //lock : t1 소유 => t2가 running이되면 t2가 소유됨..
			for(int j=0;j<80;j++) {
				System.out.print(ch);
			}
			System.out.println();
			//동기화 블럭/ 이블럭 을 빠져나가면 lock 이 자유로워짐
			}
		}
	}
}
public class ThreadEx9 {
	public static void main(String[] args) {
		Thread t1 = new PrintThread2('A');//running일때 for구문에 의해 처음 lock을 t1이 소유함 r상태일때 A를 80개찍고 =>runnable로?바뀌고 바로
		Thread t2 = new PrintThread2('B');// t2가 running상태로 바뀜
		Thread t3 = new PrintThread2('C');//대기
		t1.start();t2.start();t3.start();
	}
}
