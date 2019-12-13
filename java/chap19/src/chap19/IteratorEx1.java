package chap19;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

public class IteratorEx1 {
	
	public static void main(String[] args) {
		List<String> list = Arrays.asList("ȫ�浿","���","�̸���","������","�Ӳ���","�����");
		System.out.println("�ܺ� �ݺ��� �̿�");
		Iterator it = list.iterator(); //list ��ü ����
		while(it.hasNext()) { //�о�ð� ������ 
			System.out.println(it.next()); //���
		}
		System.out.println("���� �ݺ��� �̿�");
//		list.stream().forEach(s->System.out.println(s));
		Stream<String> st = list.stream();//Stream = ������ ���? , List��ü�� Stream ��ü ��ȯ
		st.forEach(s->{ System.out.println(s); });//forEach = s�� �˾Ƽ� ������ st��ü�� ����������
		System.out.println("�ٽ����");
		//st.forEach(s->{ System.out.println(s); });//error �̹� ������ s�� �ٵ��ȱ⶧����
		list.stream().forEach(s->{ System.out.println(s); });//�ٽõ������� �̷����ؾ���.
	}
}
