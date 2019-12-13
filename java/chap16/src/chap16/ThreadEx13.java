package chap16;
/*
 * 	������ ������, �Һ��� ������ ����.
 * 
 *	������ �Ƶ��� �ϳ��� ���¸� �����Ѵ�.
 * 	���¿� �ܾ��� 0�̸� �Ƶ��� wait() ���·� ����ǰ�, ������ ���¿� �ܾ��� ������ wait() ���·�,
 * 	������ �ܾ��� 0�� �̸� 10000,20000,30000�� �� �Ѱ��� �Ա��Ѵ�.
 * 	���� 0 ~ 3000 ���� sleep
 * 	�Ƶ� 0 ~ 1000 ���� sleep
 */
class Account {
	int money;//�ܾ�
	synchronized void output() { //���
		while(money == 0) {
			try {
				wait(); //son ������ ���.
			}catch(InterruptedException e) {}
		}
		notifyAll(); //wait() ������ �������� ��� Runnable ���·� ��ȯ
		System.out.println(Thread.currentThread().getName()+":"+money+"�� ���");
		money = 0;
	}
	synchronized void input() { //�Ա�
		while(money > 0) {
			try {
				wait(); //���� �����尡 wait(), money�� 0�� �ɶ� �����..
			}catch(InterruptedException e) {}
		}
			money = ((int)(Math.random()*3)+1)*1000;//1��,2��,3���� �ϳ��� ����
			notifyAll();
			System.out.println(Thread.currentThread().getName()+":"+money+"�� �Ա�");
		}
	}

class Mother extends Thread{
	Account account;
	Mother(Account account){
		super("���� ������");
		this.account=account;
	}
	public void run() {
		for(int i=0;i<20;i++) {
			account.input();
			try {
				sleep((int)(Math.random()*3000));//0 ~ 3�� ���� ���Ƿ� sleep
			}catch(InterruptedException e) {}
		}
	}
}
class Son extends Thread{
	Account account;
	Son(Account account){
		super("�Ƶ� ������");
		this.account=account;
	}
	public void run() {
		for(int i=0;i<20;i++) {
			account.output();
			try {
				sleep((int)(Math.random()*1000)); //0 ~ 1��
			}catch(InterruptedException e) {}
		}
	}
}
public class ThreadEx13 {
	public static void main(String[] args) {
		Account acc = new Account();
		Thread mother = new Mother(acc);
		Thread son = new Son(acc);
		son.start();mother.start();
	}
}
