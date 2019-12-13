package chap14;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
//Key�� Value�� ��  Map.Entry�޼��� 

public class MapEx1 {
	public static void main(String[] args) {
		Map<String,Integer> map = new HashMap<String,Integer>();
		String [] names = {"ȫ�浿","���","�̸���","�Ӳ���","���"}; //key
		int [] nums = {1234,4567,2350,9870,3456}; 
		//value ����� �θ��ε� key���ϳ��� ����� 4567�� �����ٰ� 3456���� ���� �����.
		for(int i=0;i<names.length;i++) {
			map.put(names[i],nums[i]);
		}
		System.out.println(map);
		//Value = map.get(key) => key�� �ش��ϴ� Value ���� ����
		System.out.println("ȫ�浿�� ��ȣ: "+map.get("ȫ�浿"));
		System.out.println("����� ��ȣ: "+map.get("���"));
		System.out.println("�̸����� ��ȣ: "+map.get("�̸���"));
		//key���鸸 ��ȸ
		System.out.println("key���鸸 ��ȸ");
		Set<String> keys = map.keySet();
		for(String k : keys) {
			System.out.println(k+"�� ��ȣ"+map.get(k));
		}
		//Value���鸸 ��ȸ
		System.out.println("Value���鸸 ��ȸ");
		Collection<Integer> values = map.values();
		//=>key�� ��ȸ �Ұ� . value �ߺ�/���� �� �𸦶� ��밡�� �� Collection
		for(Integer v : values) {
			System.out.println(v);
		}
		//key,Value�� ���� ��ü�� ��ȸ
		System.out.println("Key,Value�� ���� ��ü�� ��ȸ");
		Set<Map.Entry<String, Integer>> entry = map.entrySet();
		// Map.Entry<String, Integer>String key���ڷ���,Integer value�� �ڷ���
		//map.entrySet(); ������ ������� ��ü�� �޾���
		for(Map.Entry<String, Integer> m : entry) {
			System.out.println(m.getKey()+"�� ��ȣ: "+m.getValue());
			System.out.println(m);
		}
	}
}
