package chap16;
/*
 * Thread 예제1
 * Thread 생성
 * 	1.Thread 클래스 상속 =>Thread1.java
 * 	2.Runnable 인터페이스 구현=>Thread2.java
 * Thread의 환경 ->동시에 움직인다.
 * 모든 스레드는 상태를 가지고 있다.
 */
class Thread1 extends Thread{//extends Thread :Thread 클래스 상속
	Thread1(String name){
		super(name);
	}
	@Override
	public void run() { //Running 상태
		for(int i=0; i<5; i++) {
			System.out.println(i+"="+getName());//Thread의 getName() = 스레드에서 상속받았음. 스레드상속받은 getName
			try {
				sleep(1000);//대기상태 ,1000밀리초 = 1 초대기 ,sleep() thread클래스에 있는 메서드 무조건 예외처리해야함
			}catch(InterruptedException e) {}
		}
	}
	//Dead상태
}
public class ThreadEx1 {
	public static void main(String[] args) {
		System.out.println("main 스레드 시작");
		Thread t1 = new Thread1("First");//New상태
		Thread t2 = new Thread1("Second");//New상태
		//t1.start();//Runnable 상태 , 스택을 병렬화시켜서 나눔,run()메서드 시작.
		/*
		 * start() 기능
		 * 1. 스택영역을 병렬화시킴(main?을나눠서 갖는다)
		 * 2. 자신의 스택 영역에 run()메서드 호출
		 * 
		 */
		//t2.start(); //Runnable 상태 ,동시에 run메서드 실행
		t1.run();//Thread인 것 같지만 Thread 아님. 결과가 다름. single스레드 환경 같이나옴..
		t2.run();
		System.out.println("main 스레드 종료"); //스레드2개생성 후 메인을 다 찍고 끝내버린다.메인이사라짐. 하지만 2개의 스레드가 남아있음. 그래서 메인시작메인종료 가 먼저찍히고 나중에 t1,t2가 찍힌다.
	}
}
