package chap19;

import java.util.Scanner;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

/*
 * 1. IntStream.rangeClosed �޼��带 �̿��Ͽ�
 *  �Էµ� ���ڱ����� ��, ¦���� ��, Ȧ���� ���� ���ϴ� ���α׷� �ۼ��ϱ�
 */

public class e191002 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("���ڸ� �Է��ϼ���.");
	//	int num = sc.nextInt();
		int num = Integer.MAX_VALUE;
//		System.out.println("������ ��: "+IntStream.rangeClosed(1, num).sum());
//		System.out.println("¦���� ��: "+IntStream.rangeClosed(1, num).filter(n->n%2==0).sum());
//		System.out.println("Ȧ���� ��: "+IntStream.rangeClosed(1, num).filter(n->n%2==1).sum());
		System.out.println("������ ��: "+LongStream.rangeClosed(1, num).sum());
		System.out.println("¦���� ��: "+LongStream.rangeClosed(1, num).filter(n->n%2==0).sum());
		System.out.println("Ȧ���� ��: "+LongStream.rangeClosed(1, num).filter(n->n%2==1).sum());
	}
}
