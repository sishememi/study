package chap16;
/*
 * ����ȭ ����
 * 	����ȭ �޼��� ����
 * 	=>�ݵ�� ������ü�� �޼��忩�� ��.
 * 	=>������ü: ��� �����尡 �ϳ��� ��ü�� �����ϰ� �־���Ѵ�.
 */
class Printer{
	public synchronized void printChar(char ch) {//����ȭ �޼��� , ������ ����ȭ�޼���X 
		for(int i=0;i<80;i++) {
			System.out.print(ch);
		}
		System.out.println();
	}
}
class PrintThread3 extends Thread{
	Printer ptr;
	char ch;
	PrintThread3(Printer ptr, char ch){
		this.ptr = ptr;
		this.ch = ch;
	}
	public void run() {
		for(int i=0;i<20;i++) {
			ptr.printChar(ch);
		}
	}
}
public class ThreadEx10 {
	public static void main(String[] args) {
		Printer ptr = new Printer();
		Thread t1 = new PrintThread3(ptr,'A');
		Thread t2 = new PrintThread3(ptr,'B');
		Thread t3 = new PrintThread3(ptr,'C');
//		Thread t1 = new PrintThread3(new Printer(),'A');// �� ,��,���� �ȸ��� ��ü�� 3�� ����
//		Thread t2 = new PrintThread3(new Printer(),'B');// �� ,��,���� �ȸ��� ��ü�� 3�� ����
//		Thread t3 = new PrintThread3(new Printer(),'C');// �� ,��,���� �ȸ��� ��ü�� 3�� ����
		t1.start();t2.start();t3.start();

	}
}
