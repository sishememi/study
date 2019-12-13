package chap16;
/*
 * CarMarket Ŭ���� : �ڵ��� Ŭ����
 * 	��� ���� : String car;
 * 	��� �޼��� 	
 * 		synchronized void push() : car ����� �ڵ��� �԰�(����)
 * 			{"�ҳ�Ÿ","SM5","�׷���","���׽ý�","K9"} �� �Ѱ��� car�� ����
 * 			������ car==null �� ��츸 ���尡��.
 * 		synchronized void pop() : ����� car�� ���.
 * 			car=null�� ����.
 * 			car != null ��� ���� null�̸� wait����
 * Seller Ŭ����  : �Ǹſ�. Thread Ŭ���� 
 * 	0 ~ 2000�и��ʸ� ���Ƿ� ���
 * 	pop()�޼��带 ȣ���ϱ�
 * Producer Ŭ���� : ������. Thread Ŭ����
 * 	0 ~ 5000�и��� ���Ƿ� sleep
 * 	push()�޼��� ȣ���ϱ�.
 */
class CarMarketer {
	String car;
	String input[] ={"�ҳ�Ÿ","SM5","�׷���","���׽ý�","K9","������","����"};
	synchronized void push() {
		while(car != null) {//�ڵ����� null�̾ƴϰ� ������ ���� ������ �԰�x ,������ car==null �� ��츸 ���尡��. null�� �ƴϸ� ���
			try {
				wait();
			}catch(InterruptedException e) {}
		}
//		int r =(int)(Math.random()*7);
//		car = input[r];
		car = input[(int)(Math.random()*input.length)]; //�����Ͱ� ����
		notify();//wait���ӿ��� ������ ����
		System.out.println(Thread.currentThread().getName()+":"+car+"�԰�");
}
	synchronized void pop() {
		while(car == null) {//car != null ��� ���� null�̸� wait����
			try {
				wait();//push�� �־��ٶ����� ������.
			}catch(InterruptedException e) {}
		}
		notifyAll();//�����ִ� �����带 ��� ����
		System.out.println(Thread.currentThread().getName()+":"+car+"���");
		car=null;
	}
}
class Seller extends Thread{
	CarMarketer carmarketer;
	Seller(CarMarketer carmarketer){
		super("�Ǹſ� ������");
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
		super("������ ������");
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
