package chap16;
/*
 * 	Thread 우선순위  : Runnable 상태 스케줄러에게 선택받아  Runnable상태로 변경 될때 우선순위.
 * 		우선순위가 높다고 해서 무조건 빠른 선택을 받는 것은 아님. 확률이 높다.
 * 		우선순위 설정 메서드  : setPriority(우선순위)
 */
class ThreadProperty extends Thread{
	ThreadProperty(String name,int p){
		super(name);
		setPriority(p); //우선순위 설정
	}
	@Override
	public void run() {
		for(int i=0;i<50;i++) {
			System.out.println(this); //toString메서드 호출 thread에 오버라이딩.
			/*
			 * Thread[Third,10,main]
			 * Third : 스레드이름
			 * 10 	 : 우선순위
			 * main	 : 스레드 그룹
			 */
		try {
			sleep(20);
			}catch(InterruptedException e) {}
		}
	}
}
public  class ThreadEx3 {
	public static void main(String[] args) { 
		System.out.println(Thread.currentThread());
		System.out.println("높은 우선 순위:"+ Thread.MAX_PRIORITY);//10
		System.out.println("낮은 우선 순위:"+ Thread.MIN_PRIORITY);//1
		System.out.println("기본 우선 순위:"+ Thread.NORM_PRIORITY);//5
		Thread t1 = new ThreadProperty("First",5);
		Thread t2 = new ThreadProperty("Second",1);
		Thread t3 = new ThreadProperty("Third",10);
		t1.start();t2.start();t3.start();
	}
}
