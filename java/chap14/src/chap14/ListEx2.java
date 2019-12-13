package chap14;

import java.util.List;
import java.util.Vector;

/*
 * Vector ����: Collection �����ӿ�ũ ������ ���Ǵ� Ŭ����.
 * 			   List�� ���� Ŭ����
 * 				addElement , removeElement �� Vector�� �޼���
 */
public class ListEx2 {
	public static void main(String[] args) {
	//	Vector<Double> list = new Vector<Double>();
		List<Double> list = new Vector<Double>();
		list.add(0.3);
		list.add(Math.PI);
	//	list.addElement(5.0);//Vector�� �߰���� �޼���. add�� ���� ���
		list.add(5.0);//List�� �߰���� �޼���. addElement�� ���� ���
		
		for(Double o : list) {
			System.out.println(o);
		}
		double num = 5.0;
		int index = list.indexOf(num);//2 ,�����δ� 3��°
		if(index >= 0 ) System.out.println(num+"�� ��ġ:"+index);
		else System.out.println(num+"�� ����Ʈ�� �����ϴ�.");
		num=0.3;
		System.out.println(list.indexOf(num));//0
		System.out.println(list.indexOf(5.0));//2
		if(list.contains(num)) {//list.contains(num) = list ����� 0.3�� ������ ����?
	//		list.removeElement(num); //0.3 ����  Vector�� ���, remove�� ���� ���
			list.remove(num);//List�� �߰���� �޼���. removeElement
			System.out.println(num+"������");
		}
		System.out.println(list.indexOf(num));//0.3�� ������� -1(�� ����)�� �Ѱ���
		System.out.println(list.indexOf(5.0));//1
		System.out.println(list);
	}

}
