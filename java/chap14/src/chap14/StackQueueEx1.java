package chap14;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/*
 * Stack Ŭ���� : LIFO(Last In First Out)
 * 			    Vector Ŭ������  ����Ŭ������.
 * 		push(Object) : ��ü�� stack�� ����. �߰�.
 * 		Object pop() : stack���� ��ü ����. ����. stack���� ��ü�� ����.
 * 		Object peek() : stack���� ��ü�� ��ȸ. ���Ŵ� �ƴ�. 
 * Queue �������̽� : FIFO(First In First Out)
 * 				  LinkedList Ŭ������  ������.
 * 		offer(Object) : ��ü�� queue�� ����. �߰�
 * 		Object poll() : ��ü�� queue����  ����. ����. queue���� ����
 *		Object peek() : queue���� ��ü�� ��ȸ.
 *
 *LinkedList : Queue, List �������̽� ��� ����.
 */
public class StackQueueEx1 {
	public static void main(String[] args) {
		String cars[] = {"�ҳ�Ÿ","�׷���","SM6","K9"};
		Stack<String> stack = new Stack<String>();
		for(String s : cars) stack.push(s);
		System.out.println("���ÿ� ����� ��ü�� ����: " +stack.size());
		System.out.println(stack.peek());
		System.out.println("���ÿ� ����� ��ü�� ����: " +stack.size());
		System.out.println(stack.pop());
		System.out.println("���ÿ� ����� ��ü�� ����: " +stack.size());
		System.out.println();
		Queue<String> queue = new LinkedList<String>();
		for(String s : cars) queue.offer(s);
		System.out.println("ť�� ����� ��ü�� ����: " +queue.size());
		System.out.println(queue.peek());
		System.out.println("ť�� ����� ��ü�� ����: " +queue.size());
		System.out.println(queue.poll());
		System.out.println("ť�� ����� ��ü�� ����: " +queue.size());
	}
}
