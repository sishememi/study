package chap14;

import java.util.List;
import java.util.Vector;

/*
 * Vector 예제: Collection 프레임워크 이전에 사용되던 클래스.
 * 			   List의 구현 클래스
 * 				addElement , removeElement 는 Vector의 메서드
 */
public class ListEx2 {
	public static void main(String[] args) {
	//	Vector<Double> list = new Vector<Double>();
		List<Double> list = new Vector<Double>();
		list.add(0.3);
		list.add(Math.PI);
	//	list.addElement(5.0);//Vector의 추가기능 메서드. add와 같은 기능
		list.add(5.0);//List의 추가기능 메서드. addElement와 같은 기능
		
		for(Double o : list) {
			System.out.println(o);
		}
		double num = 5.0;
		int index = list.indexOf(num);//2 ,실제로는 3번째
		if(index >= 0 ) System.out.println(num+"의 위치:"+index);
		else System.out.println(num+"은 리스트에 없습니다.");
		num=0.3;
		System.out.println(list.indexOf(num));//0
		System.out.println(list.indexOf(5.0));//2
		if(list.contains(num)) {//list.contains(num) = list 요소중 0.3인 데이터 존재?
	//		list.removeElement(num); //0.3 삭제  Vector의 멤버, remove와 같은 기능
			list.remove(num);//List의 추가기능 메서드. removeElement
			System.out.println(num+"삭제됨");
		}
		System.out.println(list.indexOf(num));//0.3이 사라져서 -1(값 없음)를 넘겨줌
		System.out.println(list.indexOf(5.0));//1
		System.out.println(list);
	}

}
