package chap16;
/*
 * Ÿ�� ���� ���� ���α׷� �����ϱ�
 * String[] data= {"�¿�","����","����","ȿ��","����","����","����ī","���","Ƽ�Ĵ�"};
 * List<String> words = new  ArrayList<String>();
 * 3�ʿ� �ѹ��� words�� data�� ������ �̸��� �߰��ϱ�. => ������ (DataAddThread)�� �ۼ�.
 * ȭ�鿡 �Էµ� �̸���, words�� ����� �̸��� ���� ��� words���� �Էµ� �̸��� �����Ѵ�.
 * words�� ��� �����Ͱ� �����Ǹ� ���α׷��� �����Ѵ�.
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//class DataAddThread extends Thread{
//	List<String> words;
//	String[] data;
//	int interval;//3��
//	
//	DataAddThread(String[] data, List<String> words,int interval) {
//		this.data = data;
//		this.words = words;
//		this.interval = interval;
//	}
//	@Override 
//	public void run() {
//		while(true) {
//			int a =(int)(Math.random()*data.length);
//			words.add(data[a]);
//			System.out.println(words);
//			try {
//				sleep(interval);
//			}catch(InterruptedException e) {}
//		}
//	}
//}
//public class Exam4 {
//	
//	public static void main(String[] args) throws InterruptedException {
//		List<String> words = new ArrayList<String>();
//		String[] data={"�¿�","����","����","ȿ��","����","����","����ī","���","Ƽ�Ĵ�"};
//		int interval = 3*1000;//3��
//		Thread t = new DataAddThread(data, words, interval);
//		t.setDaemon(true);
//		t.start();
//	//	t.join();
//		Scanner scan = new Scanner(System.in);
//		String name = null;
//		while(true) {
//		name = scan.next();
//		if(words.contains(name)) 
//			words.remove(name);
//		if(words.size()==0) {
//			System.out.println("���α׷� ����"); 
//			break;
//			}
//		}
//	}	
//}

public class Exam4 {
	List<String> words = new ArrayList<String>();
	String[] data={"�¿�","����","����","ȿ��","����","����","����ī","���","Ƽ�Ĵ�"};
	int interval = 3*1000;//3��
	public static void main(String[] args) {
		Exam4 g =new Exam4();
		g.game();
		System.out.println("���α׷� ����");
	}
	private void game() {
		Scanner scan = new Scanner(System.in);
		words.add(data[0]);
		DataAddThread t1 = new DataAddThread(data, words, interval);
		t1.setDaemon(true);
		t1.start();
		while(true) {
			System.out.println(words);
			System.out.print(">>");
			String input = scan.nextLine().trim();
			words.remove(input);
			if(words.size()==0) break;
		}
	}
	
class  DataAddThread extends Thread{
	List<String> words;
	String[] data;
	int interval;//3��
	DataAddThread(String[] data, List<String> words,int interval) {
		this.data = data;
		this.words = words;
		this.interval = interval;
		}
	@Override
	public void run() {
		while(true) {
			try {
				sleep(interval);
			}catch(InterruptedException e) {}
		words.add(data[(int)(Math.random()*data.length)]);
		}
		}
	}
}
	
