package chap14;

import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;

/*
 * TreeSet ����
 * 	Set > SortedSet ����Ŭ����.
 * 	Set: �ߺ��Ұ�
 *  SortedSet: ���ĵ�.
 *  
 *  =>���ǻ���: ��������� Ŭ������ �ݵ�� Comparable �������̽��� ������ Ŭ������ TreeSet�� ��ҷ� ���� ����
 *  ���� ���� �������̽�
 *    Comparator: �⺻ ���� ����� �����Ҷ� ���
 *    Comparable: �⺻ ���� ��� �����Ҷ� ���
 * 
 */
public class SetEx3 {
	public static void main(String[] args) {
		SortedSet<String> set = new TreeSet<>();//SortedSet= sort ���� �������̽�
		set = new TreeSet<>(new Descending());//��������
		set = new TreeSet<>(Comparator.reverseOrder());//8.0���� ����
		String from = "bat";
		String to ="d";
		set.add("abc");set.add("alian");
		set.add("bat");set.add("azz");
		set.add("car");set.add("Car");
		set.add("disc");set.add("dance");
		set.add("dZZZZ");set.add("dzzzz");
		set.add("elevater");set.add("fan");
		set.add("flower");
		System.out.println(set);
//		System.out.println("from:" +from+", to:"+to);
//		System.out.println(set.subSet(from, to));//���ĵǾ����. subSet= Sortedset���� ���
//		System.out.println("from:" +from+ ", to:"+ to+"zzzz");
//		System.out.println(set.subSet(from, to+"zzzz"));

	}

}
/*
 * �������̽� :1.��� 2.�߻�޼��� 3.default 4.static �޼��� = 3.4 �����θ�.
 */
class Descending implements Comparator{ //�������̽� Comparator �߻�Ŭ���� compare�� ������ ����
	@Override
	public int compare(Object o1,Object o2) {
		Comparable c1 =(Comparable) o1;
		Comparable c2 =(Comparable) o2;
		return c1.compareTo(c2)* -1;//c1.compareTo(c2)* -1 => ������ �����, ����� ������.
	}
}
