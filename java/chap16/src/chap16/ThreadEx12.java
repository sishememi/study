package chap16;
/*
 * wait(),notify(),notify()
 * 	1. ����ȭ ����(����ȭ ��, ����ȭ �޼���) �޼��常 ȣ���� ����
 * 	2. Object Ŭ������ ��� �޼��� => ��� ��ü�� wait,notify,norifyAll �޼��� ���� ����
 * 	3. wait() : ���� ���� ���� Thread�� �����·� ��ȯ. lock ������. notify,norifyAll �޼��带 �̿��Ͽ�
 * 				�����¿��� Runnable ���·� ��ȯ�� ������.
 * 	   notify() : wait() ������ ������ �� �Ѱ��� Runnable ���·� ��ȯ. �����ڰ� ���� �Ұ�.
 * 	   notifyAll() : wait() ������ ������ ��θ� Runnable ���·� ��ȯ.
 * 
 */
class ATM2 implements Runnable{ //Runnable �������̽��� ������ Runnable.,notify()�� ��µ� ObjectŬ������ ���
	private long money = 120000;//110000
	@Override
	public void run() {
		synchronized(this) { //����ȭ ��, 
		for(int i=0;i<10;i++) {
			if(money <= 0) { //100000
				System.out.println("�ܾ��� �����ϴ�.");
				notify();
				break;
			}
			withDraw(10000);
			if(money % 20000 == 0) {
				try {
					wait(); //son wait() => lock ����, ���
				}catch(InterruptedException e) {}
				}else {
					notify(); //daugther Runnable���� wait()�� son�� �ݺ������� �ٲ�..
				}
			}
		}
	}
private void withDraw(int i) {
		if(money <= 0) return;
		money -= i;
		System.out.println(Thread.currentThread().getName()+"���. �ܾ�:"+money);	
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
