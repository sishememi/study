package chap19;

import java.util.Arrays;
import java.util.List;

public class FilterStreamEx1 {
	public static void main(String[] args) {
		List<String> list = Arrays.asList("ȫ�浿","���","ȫ�浿","�Ӳ���","ȫ�浿");
		list.stream().forEach(n->System.out.println(n));
		System.out.println();
		//Stream distinct() : ������ ��Ʈ���� ��� �� �ߺ� ���� �� �ٽ� ��Ʈ������ ����
		list.stream().distinct().forEach(n->System.out.println(n));
		System.out.println();
		//filter(Predicate p) : p�� ����� true�� ��ҵ�θ� Stream���� ����
		list.stream().filter(n->n.startsWith("ȫ")).forEach(n->System.out.println(n));
		System.out.println();
		list.stream().filter(n->n.startsWith("ȫ")).distinct().forEach(n->System.out.println(n));
		//list.stream().distinct().filter(n->n.startsWith("ȫ")).forEach(n->System.out.println(n)); ������ ����� ����
		System.out.println();
	}
}
