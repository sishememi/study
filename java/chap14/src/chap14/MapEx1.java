package chap14;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
//Key와 Value의 쌍  Map.Entry메서드 

public class MapEx1 {
	public static void main(String[] args) {
		Map<String,Integer> map = new HashMap<String,Integer>();
		String [] names = {"홍길동","김삿갓","이몽룡","임꺽정","김삿갓"}; //key
		int [] nums = {1234,4567,2350,9870,3456}; 
		//value 김삿갓이 두명인데 key는하나라 김삿갓은 4567을 가졌다가 3456으로 값이 변경됨.
		for(int i=0;i<names.length;i++) {
			map.put(names[i],nums[i]);
		}
		System.out.println(map);
		//Value = map.get(key) => key에 해당하는 Value 값을 리턴
		System.out.println("홍길동의 번호: "+map.get("홍길동"));
		System.out.println("김삿갓의 번호: "+map.get("김삿갓"));
		System.out.println("이몽룡의 번호: "+map.get("이몽룡"));
		//key값들만 조회
		System.out.println("key값들만 조회");
		Set<String> keys = map.keySet();
		for(String k : keys) {
			System.out.println(k+"의 번호"+map.get(k));
		}
		//Value값들만 조회
		System.out.println("Value값들만 조회");
		Collection<Integer> values = map.values();
		//=>key값 조회 불가 . value 중복/순서 다 모를때 사용가능 한 Collection
		for(Integer v : values) {
			System.out.println(v);
		}
		//key,Value의 쌍인 객체로 조회
		System.out.println("Key,Value의 쌍인 객체로 조회");
		Set<Map.Entry<String, Integer>> entry = map.entrySet();
		// Map.Entry<String, Integer>String key의자료형,Integer value의 자료형
		//map.entrySet(); 쌍으로 만들어진 객체를 받아줌
		for(Map.Entry<String, Integer> m : entry) {
			System.out.println(m.getKey()+"의 번호: "+m.getValue());
			System.out.println(m);
		}
	}
}
