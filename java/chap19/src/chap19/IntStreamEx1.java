package chap19;

import java.util.Arrays;
import java.util.stream.IntStream;

/*
 * 
 */
public class IntStreamEx1 {
	public static void main(String[] args) {
		int [] arr = {1,2,3,4,5,};
		System.out.println("Arrays.stream �޼��带 �̿��Ͽ� IntStream �����ϱ�");
		IntStream intstream1 = Arrays.stream(arr);
		intstream1.forEach(s->System.out.print(s+"\t"));
		System.out.println();
		Arrays.stream(arr).forEach(s->System.out.print(s+"\t"));
		System.out.println();
		System.out.println("IntStream.of �޼��带 �̿��Ͽ� IntStream �����ϱ�");
		//IntStream IntStream.of(arr) 
		IntStream.of(arr).forEach(s->System.out.print(s+"\t"));
		System.out.println();
		//range : ���� ����. 20 ���� �ȵ�. 10~19������ ���ڸ� IntStream ��ü�� ����
		System.out.println("IntStream.range(1,5) �޼��带 �̿��Ͽ� IntStream �����ϱ�");
		IntStream.range(10, 15).forEach(s->System.out.print(s+"\t"));
		System.out.println();
		//rangeClosed : ���� ����. 5 ���Ե�. 1~5������ ���ڸ� InStream ��ü�� ����
		System.out.println("IntStream.rangeClosed(1,5) �޼��带 �̿��Ͽ� IntStream �����ϱ�");
		IntStream.rangeClosed(1, 5).forEach(s->System.out.print(s+"\t"));
		
	}
}
