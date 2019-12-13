package chap16;
/*
 * Exam1 프로그램의 SumThread 클래스 대신 Runnable 인터페이스를 구현한 방식으로 변경하기.
 * SumRunnable 클래스를 이용하여 1부터 500까지의 합 구하기.
 */
class SumRunnable implements Runnable{	
	int n1,n2,sum;
	public SumRunnable(int n1,int n2) {
		super();
		this.n1 = n1;
		this.n2 = n2;
	}
	@Override
	public void run() {
		for(int i=n1;i<=n2;i++) {
			sum+=i;
		}
		System.out.printf("%d에서부터 %d까지의 합:%d\n",n1,n2,sum);
	}
}
public class Exam2 {
	public static void main(String[] args) throws InterruptedException {
		
		SumRunnable r1 = new SumRunnable(1,100);
		SumRunnable r2 = new SumRunnable(101,200);
		SumRunnable r3 = new SumRunnable(201,300);
		SumRunnable r4 = new SumRunnable(301,400);
		SumRunnable r5 = new SumRunnable(401,500);
		Thread t1 = new Thread(r1); //Thread의 Runnable객체를 r1 객체로 변경
		Thread t2 = new Thread(r2);
		Thread t3 = new Thread(r3);
		Thread t4 = new Thread(r4);
		Thread t5 = new Thread(r5);
		
		t1.start();t2.start();t3.start();
		t5.start();t4.start();
		
		t1.join();//t1 스레드가 종료할 때까지 main스레드가 대기
		t2.join();t3.join();t4.join();t5.join();
		System.out.println("1~500까지의 합:"+(r1.sum+r2.sum+r3.sum+r4.sum+r5.sum));
	}
}
