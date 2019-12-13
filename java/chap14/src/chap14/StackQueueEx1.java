package chap14;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/*
 * Stack 클래스 : LIFO(Last In First Out)
 * 			    Vector 클래스의  하위클래스임.
 * 		push(Object) : 객체를 stack에 저장. 추가.
 * 		Object pop() : stack에서 객체 꺼냄. 리턴. stack에서 객체를 제거.
 * 		Object peek() : stack에서 객체를 조회. 제거는 아님. 
 * Queue 인터페이스 : FIFO(First In First Out)
 * 				  LinkedList 클래스가  구현함.
 * 		offer(Object) : 객체를 queue에 저장. 추가
 * 		Object poll() : 객체를 queue에서  꺼냄. 리턴. queue에서 제거
 *		Object peek() : queue에서 객체를 조회.
 *
 *LinkedList : Queue, List 인터페이스 모두 구현.
 */
public class StackQueueEx1 {
	public static void main(String[] args) {
		String cars[] = {"소나타","그랜저","SM6","K9"};
		Stack<String> stack = new Stack<String>();
		for(String s : cars) stack.push(s);
		System.out.println("스택에 저장된 객체의 갯수: " +stack.size());
		System.out.println(stack.peek());
		System.out.println("스택에 저장된 객체의 갯수: " +stack.size());
		System.out.println(stack.pop());
		System.out.println("스택에 저장된 객체의 갯수: " +stack.size());
		System.out.println();
		Queue<String> queue = new LinkedList<String>();
		for(String s : cars) queue.offer(s);
		System.out.println("큐에 저장된 객체의 갯수: " +queue.size());
		System.out.println(queue.peek());
		System.out.println("큐에 저장된 객체의 갯수: " +queue.size());
		System.out.println(queue.poll());
		System.out.println("큐에 저장된 객체의 갯수: " +queue.size());
	}
}
