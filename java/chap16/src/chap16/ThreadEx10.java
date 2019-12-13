package chap16;
/*
 * 동기화 영역
 * 	동기화 메서드 예제
 * 	=>반드시 공유객체의 메서드여야 함.
 * 	=>공유객체: 모든 스레드가 하나의 객체를 공유하고 있어야한다.
 */
class Printer{
	public synchronized void printChar(char ch) {//동기화 메서드 , 무조건 동기화메서드X 
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
//		Thread t1 = new PrintThread3(new Printer(),'A');// 줄 ,열,갯수 안맞음 객체가 3개 생김
//		Thread t2 = new PrintThread3(new Printer(),'B');// 줄 ,열,갯수 안맞음 객체가 3개 생김
//		Thread t3 = new PrintThread3(new Printer(),'C');// 줄 ,열,갯수 안맞음 객체가 3개 생김
		t1.start();t2.start();t3.start();

	}
}
