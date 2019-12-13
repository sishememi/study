package chap16;
/*
 * CarMarket 클래스 : 자동차 클래스
 * 	멤버 변수 : String car;
 * 	멤버 메서드 	
 * 		synchronized void push() : car 멤버에 자동차 입고(저장)
 * 			{"소나타","SM5","그랜저","제네시스","K9"} 중 한개를 car에 저장
 * 			기존에 car==null 인 경우만 저장가능.
 * 		synchronized void pop() : 저장된 car를 출고.
 * 			car=null로 변경.
 * 			car != null 출고 가능 null이면 wait상태
 * Seller 클래스  : 판매원. Thread 클래스 
 * 	0 ~ 2000밀리초를 임의로 출력
 * 	pop()메서드를 호출하기
 * Producer 클래스 : 공급자. Thread 클래스
 * 	0 ~ 5000밀리초 임의로 sleep
 * 	push()메서드 호출하기.
 */
class CarMarketer {
	String car;
	String input[] ={"소나타","SM5","그랜저","제네시스","K9","포르쉐","벤츠"};
	synchronized void push() {
		while(car != null) {//자동차가 null이아니고 기존의 값이 있으면 입고x ,기존에 car==null 인 경우만 저장가능. null이 아니면 대기
			try {
				wait();
			}catch(InterruptedException e) {}
		}
//		int r =(int)(Math.random()*7);
//		car = input[r];
		car = input[(int)(Math.random()*input.length)]; //위에것과 동일
		notify();//waitㅇㅣ였던 스레드 깨움
		System.out.println(Thread.currentThread().getName()+":"+car+"입고");
}
	synchronized void pop() {
		while(car == null) {//car != null 출고 가능 null이면 wait상태
			try {
				wait();//push가 넣어줄때까지 대기상태.
			}catch(InterruptedException e) {}
		}
		notifyAll();//잠들어있던 스레드를 모두 깨움
		System.out.println(Thread.currentThread().getName()+":"+car+"출고");
		car=null;
	}
}
class Seller extends Thread{
	CarMarketer carmarketer;
	Seller(CarMarketer carmarketer){
		super("판매원 스레드");
		this.carmarketer=carmarketer;
	}
	public void run() {
		for(int i=0;i<20;i++) {
			carmarketer.pop();
			try {
				sleep((int)(Math.random()*2000));
			}catch(InterruptedException e) {}
		}
	}
}
class Producer extends Thread{
	CarMarketer carmarketer;
	Producer(CarMarketer carmarketer){
		super("공급자 스레드");
		this.carmarketer=carmarketer;
	}
	public void run() {
		for(int i=0;i<20;i++) {
			carmarketer.push();
			try {
				sleep((int)(Math.random()*5000));
			}catch(InterruptedException e) {}
			}
		}
	}

public class Exam5 {
	public static void main(String[] args) {
		CarMarketer cmk = new CarMarketer();
		Thread pop = new Seller(cmk);
		Thread push = new Producer(cmk);
		pop.start();push.start();
	}
}
