package chap16;
class ATM implements Runnable{ //������ü
	private int money = 100000;
	public void run() {
		//this: ATM ��ü
		synchronized(this) { //son �����尡 lock ȹ��
		try {
			Thread.sleep((int)Math.random()*1000);
		}catch(InterruptedException e) {
		}	
	while(true) {
		if(money <= 0) break;
		widthraw();
		}
	}
}
private void widthraw() {
		if(money <= 0) return;
		money -= 10000;
		System.out.println(Thread.currentThread().getName()+"���. �ܾ�:"+money);
	}
}
public class ThreadEx11 {
	public static void main(String[] args) {
		ATM atm = new ATM();
		Thread son = new Thread(atm,"SON");
		Thread daughter = new Thread(atm,"DAUGTHER");
		son.start();daughter.start();

	}
}
